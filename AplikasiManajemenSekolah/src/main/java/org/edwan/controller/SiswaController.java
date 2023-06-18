package org.edwan.controller;

import org.edwan.model.Siswa;
import org.edwan.repository.DataKelasRepository;
import org.edwan.repository.JurusanRepository;
import org.edwan.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SiswaController {

    @Autowired
    private final SiswaRepository siswaRepository;
    private final DataKelasRepository kelasRepository;
    private final JurusanRepository jurusanRepository;

    public SiswaController(SiswaRepository siswaRepository, DataKelasRepository kelasRepository, JurusanRepository jurusanRepository) {
        this.siswaRepository = siswaRepository;
        this.kelasRepository = kelasRepository;
        this.jurusanRepository = jurusanRepository;
    }

    @GetMapping("/siswa")
    public String list(Model model) {
        List<Siswa> siswaList = siswaRepository.findAll();
        model.addAttribute("siswaList", siswaList);
        return "siswa/siswa";
    }

    // Tambahkan metode lain untuk menangani operasi CRUD lainnya
}

