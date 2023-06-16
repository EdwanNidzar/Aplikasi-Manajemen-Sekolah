package org.edwan.controller;

import org.edwan.model.DataKelas;
import org.edwan.service.DataKelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DataKelasController {

    @Autowired
    private DataKelasService dataKelasService;

    @GetMapping("/datakelas")
    public String viewDatakelas(Model model){
        model.addAttribute("listDataKelas", dataKelasService.getAllDataKelas());
        return "datakelas";
    }

    @GetMapping("/newDataKelas")
    public String showNewDataKelasForm(Model model) {
        DataKelas dataKelas = new DataKelas();
        model.addAttribute("dataKelas", dataKelas);
        return "new_datakelas";
    }

    @PostMapping("/saveDataKelas")
    public String saveDataKelas(@ModelAttribute("dataKelas") DataKelas dataKelas) {
        // save employee to database
        dataKelasService.saveDataKelas(dataKelas);
        return "redirect:/datakelas";
    }

    @GetMapping("/updateDataKelas/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        DataKelas dataKelas = dataKelasService.getDataKelasById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("dataKelas", dataKelas);
        return "update_datakelas";
    }

    @GetMapping("/deleteDataKelas/{id}")
    public String deleteDataKelas(@PathVariable(value = "id") long id) {

        this.dataKelasService.deleteDataKelasById(id);
        return "redirect:/datakelas";
    }
}
