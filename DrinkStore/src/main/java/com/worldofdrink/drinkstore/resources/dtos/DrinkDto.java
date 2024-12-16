/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.dtos;

/**
 *
 * @author Ato
 */
public class DrinkDto {

    private int drinkId;
    private String drinkName;
    private int quantity;
    private int brandId;
    private String brandName;
    private int categoryId;
    private String categoryName;
    private double unitPrice;
    private int sizeId;
    private String sizeType;

    public DrinkDto() {
    }

    public DrinkDto(int drinkId, String drinkName, String brandName, double unitPrice, int sizeId) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.quantity = 0;
        this.brandId = 0;
        this.brandName = brandName;
        this.categoryId = 0;
        this.categoryName = "None";
        this.unitPrice = unitPrice;
        this.sizeId = sizeId;
        this.sizeType = "None";
    }

    public DrinkDto(int drinkId, String drinkName, int quantity, int brandId, String brandName, int categoryId, String categoryName, double unitPrice, int sizeId, String sizeType) {
        this.drinkId = drinkId;
        this.drinkName = drinkName;
        this.quantity = quantity;
        this.brandId = brandId;
        this.brandName = brandName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.unitPrice = unitPrice;
        this.sizeId = sizeId;
        this.sizeType = sizeType;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    @Override
    public String toString() {
        return "DrinkDto{" + "drinkId=" + drinkId + ", drinkName=" + drinkName + ", quantity=" + quantity + ", brandId=" + brandId + ", brandName=" + brandName + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", unitPrice=" + unitPrice + ", sizeId=" + sizeId + ", sizeType=" + sizeType + '}';
    }

}
