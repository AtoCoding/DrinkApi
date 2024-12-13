/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.worldofdrink.drinkstore.resources.services;

import com.worldofdrink.drinkstore.resources.dtos.SizeDto;
import com.worldofdrink.drinkstore.resources.repositories.SizeRepository;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ato
 */
public class SizeService {

    private final SizeRepository sizeRepository;

    public SizeService() {
        sizeRepository = new SizeRepository();
    }

    public List<SizeDto> getSizeList() throws SQLException, ClassNotFoundException {
        return sizeRepository.getSizeList();
    }
}
