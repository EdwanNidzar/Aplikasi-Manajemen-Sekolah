package org.edwan.controller;

import org.edwan.model.DataKelas;
import org.edwan.model.Jurusan;
import org.edwan.repository.JurusanRepository;
import org.edwan.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JurusanController {

    @Autowired
    JurusanService jurusanService;

    @GetMapping("/jurusan")
    public String viewDatakelas(Model model){
        model.addAttribute("listJurusan", jurusanService.getAllJurusan());
        return "jurusan/jurusan";
    }

    @GetMapping("/newJurusan")
    public String showNewJurusanForm(Model model) {
        Jurusan jurusan = new Jurusan();
        model.addAttribute("jurusan", jurusan);
        return "jurusan/jurusan_new";
    }

    @PostMapping("/saveJurusan")
    public String saveJurusan(@ModelAttribute("jurusan") Jurusan jurusan) {

        jurusanService.saveJurusan(jurusan);
        return "redirect:/jurusan/jurusan";
    }

    @GetMapping("/updateJurusan/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Jurusan jurusan = jurusanService.getJurusanById(id);

        model.addAttribute("jurusan", jurusan);
        return "jurusan/jurusan_update";
    }

    @GetMapping("/deleteJurusan/{id}")
    public String deleteDataKelas(@PathVariable(value = "id") long id) {

        this.jurusanService.deleteJurusanById(id);
        return "redirect:/jurusan/jurusan";
    }

}
