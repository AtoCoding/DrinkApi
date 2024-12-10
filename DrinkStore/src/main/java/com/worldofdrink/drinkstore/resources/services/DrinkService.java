/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.services;

import com.worldofdrink.drinkstore.resources.dtos.DrinkDto;
import com.worldofdrink.drinkstore.resources.repositories.DrinkRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ato
 */
public class DrinkService {
    private final DrinkRepository drinkRepository;
    
    public DrinkService() {
        drinkRepository = new DrinkRepository();
    }
    
    public List<DrinkDto> getDrinkList() throws SQLException, ClassNotFoundException {
        return drinkRepository.getDrinkList();
    }
    
    public DrinkDto getDrinkDetails(int drinkId, int sizeId) throws SQLException, ClassNotFoundException {
        return drinkRepository.getDrinkDetails(drinkId, sizeId);
    }
}
