/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.services;

import com.worldofdrink.drinkstore.resources.dtos.CategoryDto;
import com.worldofdrink.drinkstore.resources.repositories.CategoryRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ato
 */
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService() {
        categoryRepository = new CategoryRepository();
    }
    
    public List<CategoryDto> getCategoryList() throws SQLException, ClassNotFoundException {
        return categoryRepository.getCategoryList();
    }    
}
