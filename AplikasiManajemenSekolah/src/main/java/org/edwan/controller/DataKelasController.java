package org.edwan.controller;

import org.edwan.service.DataKelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataKelasController {

    @Autowired
    private DataKelasService dataKelasService;

    @GetMapping("/datakelas")
    public String viewDatakelas(Model model){
        model.addAttribute("listDataKelas", dataKelasService.getAllDataKelas());
        return "datakelas";
    }
}
