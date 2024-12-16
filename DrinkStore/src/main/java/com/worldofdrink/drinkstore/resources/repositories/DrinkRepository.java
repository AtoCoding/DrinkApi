/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.repositories;

import com.worldofdrink.drinkstore.resources.dtos.DrinkDto;
import com.worldofdrink.drinkstore.resources.dtos.NewDrinkDto;
import com.worldofdrink.drinkstore.resources.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ato
 */
public class DrinkRepository {

    public List<DrinkDto> getDrinkList() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<DrinkDto> drinkDtoList = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String query = "select Drink.DrinkId, Brand.BrandName, Drink.DrinkName, DrinkSize.UnitPrice, Size.SizeId "
                        + "from Drink "
                        + "join Brand on Drink.BrandId = Brand.BrandId "
                        + "join DrinkSize on Drink.DrinkId = DrinkSize.DrinkId "
                        + "join Size on DrinkSize.SizeId = Size.SizeId";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    DrinkDto drinkDto = new DrinkDto(
                            rs.getInt("DrinkId"),
                            rs.getNString("DrinkName"),
                            rs.getNString("BrandName"),
                            rs.getDouble("UnitPrice"),
                            rs.getInt("SizeId"));
                    drinkDtoList.add(drinkDto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return drinkDtoList;
    }

    public DrinkDto getDrinkDetails(int drinkId, int sizeId) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DrinkDto drinkDto = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String query = "select Drink.DrinkId, Drink.DrinkName, DrinkSize.Quantity, "
                        + "Brand.BrandId, Brand.BrandName, Category.CategoryId, Category.CategoryName, "
                        + "DrinkSize.UnitPrice, Size.SizeId, Size.SizeType "
                        + "from Drink "
                        + "join Brand on Drink.BrandId = Brand.BrandId "
                        + "join Category on Drink.CategoryId = Category.CategoryId "
                        + "join DrinkSize on Drink.DrinkId = DrinkSize.DrinkId AND Drink.DrinkId = ? "
                        + "join Size on DrinkSize.SizeId = Size.SizeId AND Size.SizeId = ?";
                stm = con.prepareStatement(query);
                stm.setInt(1, drinkId);
                stm.setInt(2, sizeId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    drinkDto = new DrinkDto(
                            rs.getInt("DrinkId"),
                            rs.getNString("DrinkName"),
                            rs.getInt("Quantity"),
                            rs.getInt("BrandId"),
                            rs.getNString("BrandName"),
                            rs.getInt("CategoryId"),
                            rs.getNString("CategoryName"),
                            rs.getDouble("UnitPrice"),
                            rs.getInt("SizeId"),
                            rs.getNString("SizeType"));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return drinkDto;
    }

    public boolean createDrink(NewDrinkDto newDrinkDto) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                con.setAutoCommit(false);
                String query = "insert into Drink(DrinkName, BrandId, CategoryId) values (?, ?, ?)";
                stm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, newDrinkDto.getDrinkName());
                stm.setInt(2, newDrinkDto.getBrandId());
                stm.setInt(3, newDrinkDto.getCategoryId());
                int affectedRows = stm.executeUpdate();
                if (affectedRows > 0) {
                    rs = stm.getGeneratedKeys();
                    if(rs.next()) {
                        newDrinkDto.setDrinkId(rs.getInt(1));
                    } else {
                        con.rollback();
                        return false;
                    }
                    boolean isDrinkSizeCreated = createDrinkSize(newDrinkDto, con);
                    if (!isDrinkSizeCreated) {
                        con.rollback();
                        return false;
                    }
                    con.commit();
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    private boolean createDrinkSize(NewDrinkDto newDrinkDto, Connection con) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = null;

        try {
            if (con != null) {
                String query = "insert into DrinkSize(DrinkId, SizeId, UnitPrice, Quantity) values (?, ?, ?, ?)";
                stm = con.prepareStatement(query);

                for (int i = 0; i < newDrinkDto.getSizeList().size(); i++) {
                    stm.setInt(1, newDrinkDto.getDrinkId());
                    stm.setInt(2, newDrinkDto.getSizeList().get(i));
                    stm.setDouble(3, newDrinkDto.getUnitPriceList().get(i));
                    stm.setInt(4, newDrinkDto.getQuantityList().get(i));
                    stm.addBatch();
                }

                int[] results = stm.executeBatch();

                for (int result : results) {
                    if (result == Statement.EXECUTE_FAILED) {
                        return false;
                    }
                }
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
        }
        return false;
    }
}
