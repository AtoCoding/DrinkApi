/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldofdrink.drinkstore.resources.dtos.BrandDto;
import com.worldofdrink.drinkstore.resources.services.BrandService;
import com.worldofdrink.drinkstore.resources.services.DrinkService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Ato
 */
@WebServlet(value = "/v1/brand/*")
public class BrandController extends HttpServlet {

    private final BrandService brandService;

    public BrandController() {
        brandService = new BrandService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String path = request.getPathInfo();
        System.out.println(path);
        try {
            switch (path) {
                case "/": {
                    List<BrandDto> brandDtoList = brandService.getBrandList();
                    
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = objectMapper.writeValueAsString(brandDtoList);

                    PrintWriter out = response.getWriter();
                    out.print("{\"data\":" + jsonResponse + "}");
                    out.flush();

                    break;
                }
                default: {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }
}
