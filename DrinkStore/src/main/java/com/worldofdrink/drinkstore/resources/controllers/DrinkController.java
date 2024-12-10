/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldofdrink.drinkstore.resources.dtos.DrinkDto;
import com.worldofdrink.drinkstore.resources.services.DrinkService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ato
 */
@WebServlet(value = "/v1/drink/*")
public class DrinkController extends HttpServlet {

    private final DrinkService drinkService;

    public DrinkController() {
        drinkService = new DrinkService();
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
                    List<DrinkDto> drinkDtoList = new ArrayList<>();
                    drinkDtoList = drinkService.getDrinkList();

                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonResponse = objectMapper.writeValueAsString(drinkDtoList);

                    PrintWriter out = response.getWriter();
                    out.print("{\"data\":" + jsonResponse + "}");
                    out.flush();
                    break;
                }
                case "/details": {
                    try {
                        int drinkId = Integer.parseInt(request.getParameter("drinkId"));
                        int sizeId = Integer.parseInt(request.getParameter("sizeId"));
                        DrinkDto drinkDto = new DrinkDto();
                        drinkDto = drinkService.getDrinkDetails(drinkId, sizeId);
                        if (drinkDto != null) {
                            ObjectMapper objectMapper = new ObjectMapper();
                            String jsonResponse = objectMapper.writeValueAsString(drinkDto);

                            PrintWriter out = response.getWriter();
                            out.print("{\"data\":" + jsonResponse + "}");
                            out.flush();
                        } else {
                            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                            response.getWriter().write("Có lỗi xảy ra. Vui lòng thử lại!");
                        }
                    } catch (NumberFormatException nfe) {
                        nfe.printStackTrace(); // Handle and log the exception
                        System.out.println(nfe.getMessage());
                    }
                    break;
                }
                default: {

                }
            }
        } catch (IOException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DrinkController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {

    }
}
