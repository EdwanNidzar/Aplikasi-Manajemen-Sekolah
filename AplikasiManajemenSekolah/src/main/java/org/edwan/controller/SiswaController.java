package org.edwan.controller;

import org.edwan.model.DataKelas;
import org.edwan.model.Jurusan;
import org.edwan.model.Siswa;
import org.edwan.repository.DataKelasRepository;
import org.edwan.repository.JurusanRepository;
import org.edwan.repository.SiswaRepository;
import org.edwan.service.DataKelasService;
import org.edwan.service.JurusanService;
import org.edwan.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SiswaController {

    public SiswaController(DataKelasService dataKelasService, JurusanService jurusanService, SiswaService siswaService) {
        this.dataKelasService = dataKelasService;
        this.jurusanService = jurusanService;
        this.siswaService = siswaService;
    }

    @Autowired
    DataKelasService dataKelasService;
    JurusanService jurusanService;
    SiswaService siswaService;

    @GetMapping("/siswa")
    public String list(Model model) {
        List<Siswa> siswaList = siswaService.getAllSiswa();
        model.addAttribute("siswaList", siswaList);
        return "siswa/siswa";
    }

    @GetMapping("/newSiswa")
    public String showNewSiswaForm(Model model) {
        Siswa siswa = new Siswa();
        List<DataKelas> dataKelas = dataKelasService.getAllDataKelas();
        List<Jurusan> jurusan = jurusanService.getAllJurusan();

        model.addAttribute("siswa", siswa);

        model.addAttribute("listKelas", dataKelas);  // kelas
        model.addAttribute("listJurusan", jurusan); // jurusan

        return "siswa/siswa_new";
    }

    @PostMapping("/saveSiswa")
    public String saveSiswa(@ModelAttribute("siswa") Siswa siswa){
        siswaService.saveSiswa(siswa);
        return "siswa/siswa";
    }

    @GetMapping("/updateSiswa/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        Siswa siswa = siswaService.getSiswaById(id);
        List<DataKelas> dataKelas = dataKelasService.getAllDataKelas();
        List<Jurusan> jurusan = jurusanService.getAllJurusan();

        model.addAttribute("siswa", siswa);

        model.addAttribute("listKelas", dataKelas);  // kelas
        model.addAttribute("listJurusan", jurusan); // jurusan

        return "siswa/siswa_update";
    }

    @GetMapping("/deleteSiswa/{id}")
    public String deleteSiswa(@PathVariable(value = "id") long id) {
        this.siswaService.deleteSiswaById(id);
        return "redirect:/siswa";
    }


}

