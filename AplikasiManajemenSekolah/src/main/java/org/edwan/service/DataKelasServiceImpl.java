package org.edwan.service;

import org.edwan.model.DataKelas;
import org.edwan.repository.DataKelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataKelasServiceImpl implements DataKelasService{

    @Autowired
    private DataKelasRepository dataKelasRepository;

    @Override
    public List<DataKelas> getAllDataKelas() {
        return dataKelasRepository.findAll();
    }

    @Override
    public void saveDataKelas(DataKelas dataKelas) {
        this.dataKelasRepository.save(dataKelas);
    }

    @Override
    public DataKelas getDataKelasById(long id) {
        Optional<DataKelas> optional = dataKelasRepository.findById(id);
        DataKelas dataKelas = null;
        if (optional.isPresent()){
            dataKelas = optional.get();
        } else {
            throw new RuntimeException(" Data Kelas not found for id :: "+id);
        }
        return dataKelas;
    }

    @Override
    public void deleteDataKelasById(Long id) {
        this.dataKelasRepository.deleteById(id);
    }
}
