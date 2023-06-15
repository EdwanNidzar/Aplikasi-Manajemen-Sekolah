package org.edwan.service;

import org.edwan.model.DataKelas;

import java.util.List;

public interface DataKelasService {

    List<DataKelas> getAllDataKelas();
    void saveDataKelas(DataKelas dataKelas);
    DataKelas getDataKelasById(long id);
    void deleteDataKelasById(Long id);
}
