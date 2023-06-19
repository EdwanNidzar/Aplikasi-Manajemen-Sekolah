package org.edwan.controller;

import org.edwan.model.DataKelas;
import org.edwan.model.Guru;
import org.edwan.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuruController {

    @Autowired
    private GuruService guruService;

    @GetMapping("/guru")
    public String viewDataGuru(Model model){
        model.addAttribute("listGuru", guruService.getAllGuru());
        return "guru/guru";
    }

    @GetMapping("/newGuru")
    public String showNewGuruForm(Model model) {
        Guru guru = new Guru();
        model.addAttribute("guru", guru);
        return "guru/guru_new";
    }

    @PostMapping("/saveGuru")
    public String saveDataKelas(@ModelAttribute("dataKelas") Guru guru) {
        guruService.saveGuru(guru);
        return "redirect:/guru";
    }

    @GetMapping("/updateGuru/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Guru guru = guruService.getGuruById(id);

        model.addAttribute("guru", guru);
        return "guru/guru_update";
    }

    @GetMapping("/deleteGuru/{id}")
    public String deleteGuru(@PathVariable(value = "id") long id) {
        this.guruService.deleteGuruById(id);
        return "redirect:/guru";
    }
}
