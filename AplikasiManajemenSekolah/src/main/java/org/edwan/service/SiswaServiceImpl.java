package org.edwan.service;

import org.edwan.model.Siswa;
import org.edwan.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaServiceImpl implements SiswaService{

    @Autowired
    private SiswaRepository siswaRepository;

    @Override
    public List<Siswa> getAllSiswa() {
        return siswaRepository.findAll();
    }

    @Override
    public void saveSiswa(Siswa siswa) {
        this.siswaRepository.save(siswa);
    }

    @Override
    public Siswa getSiswaById(long id) {
        Optional<Siswa> optional = siswaRepository.findById(id);
        Siswa siswa = null;
        if(optional.isPresent()){
            siswa = optional.get();
        } else {
            throw new RuntimeException(" Siswa not found for id :: "+id);
        }
        return siswa;
    }

    @Override
    public void deleteSiswaById(Long id) {
        this.siswaRepository.deleteById(id);
    }

}
