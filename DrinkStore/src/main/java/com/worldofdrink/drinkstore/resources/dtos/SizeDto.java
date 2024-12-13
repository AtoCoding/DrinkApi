/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.dtos;

/**
 *
 * @author Ato
 */
public class SizeDto {
    private int sizeId;
    private String sizeType;

    public SizeDto() {
    }

    public SizeDto(int sizeId, String sizeType) {
        this.sizeId = sizeId;
        this.sizeType = sizeType;
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
        return "SizeDto{" + "sizeId=" + sizeId + ", sizeType=" + sizeType + '}';
    }
    
    
}
