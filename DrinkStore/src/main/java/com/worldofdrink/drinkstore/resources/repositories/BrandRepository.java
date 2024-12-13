/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.repositories;

import com.worldofdrink.drinkstore.resources.dtos.BrandDto;
import com.worldofdrink.drinkstore.resources.dtos.DrinkDto;
import com.worldofdrink.drinkstore.resources.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ato
 */
public class BrandRepository {
    public List<BrandDto> getBrandList() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<BrandDto> brandDtoList = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String query = "select * from Brand";
                stm = con.prepareStatement(query);
                rs = stm.executeQuery();
                while (rs.next()) {
                    BrandDto brandDto = new BrandDto(
                            rs.getInt("BrandId"),
                            rs.getNString("BrandName"));
                    brandDtoList.add(brandDto);
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
        return brandDtoList;
    }
}
