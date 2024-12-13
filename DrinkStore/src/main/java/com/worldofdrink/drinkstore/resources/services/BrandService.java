/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.services;

import com.worldofdrink.drinkstore.resources.dtos.BrandDto;
import com.worldofdrink.drinkstore.resources.repositories.BrandRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ato
 */
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService() {
        brandRepository = new BrandRepository();
    }
    
    public List<BrandDto> getBrandList() throws SQLException, ClassNotFoundException {
        return brandRepository.getBrandList();
    }
}
