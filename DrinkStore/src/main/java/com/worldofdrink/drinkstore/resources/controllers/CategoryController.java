/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldofdrink.drinkstore.resources.dtos.BrandDto;
import com.worldofdrink.drinkstore.resources.dtos.CategoryDto;
import com.worldofdrink.drinkstore.resources.services.BrandService;
import com.worldofdrink.drinkstore.resources.services.CategoryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ato
 */
@WebServlet(value = "/v1/category/*")
public class CategoryController extends HttpServlet {

    private final CategoryService categoryService;

    public CategoryController() {
        categoryService = new CategoryService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String path = request.getPathInfo();
        try {
            switch (path) {
                case "/": {
                    List<CategoryDto> categoryDtoList = categoryService.getCategoryList();
                    
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = objectMapper.writeValueAsString(categoryDtoList);

                    PrintWriter out = response.getWriter();
                    out.print("{\"data\":" + jsonResponse + "}");
                    out.flush();

                    break;
                }
                default: {

                }
            }
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }
}
