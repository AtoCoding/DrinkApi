/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.dtos;

import java.util.List;

/**
 *
 * @author Ato
 */
public class NewDrinkDto {

    private int drinkId;
    private String drinkName;
    private List<Integer> quantityList;
    private int brandId;
    private int categoryId;
    private List<Double> unitPriceList;
    private List<Integer> sizeList;

    public NewDrinkDto() {
    }

    public NewDrinkDto(int drinkId, String drinkName, List<Integer> quantityList, int brandId, int categoryId, List<Double> unitPriceList, List<Integer> sizeList) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.quantityList = quantityList;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.unitPriceList = unitPriceList;
        this.sizeList = sizeList;
    }

    public int getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Integer> quantityList) {
        this.quantityList = quantityList;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Double> getUnitPriceList() {
        return unitPriceList;
    }

    public void setUnitPriceList(List<Double> unitPriceList) {
        this.unitPriceList = unitPriceList;
    }

    public List<Integer> getSizeList() {
        return sizeList;
    }

    public void setSizeList(List<Integer> sizeList) {
        this.sizeList = sizeList;
    }

    @Override
    public String toString() {
        return "NewDrinkDto{" + "drinkId=" + drinkId + ", drinkName=" + drinkName + ", quantityList=" + quantityList + ", brandId=" + brandId + ", categoryId=" + categoryId + ", unitPriceList=" + unitPriceList + ", sizeList=" + sizeList + '}';
    }

    
}
