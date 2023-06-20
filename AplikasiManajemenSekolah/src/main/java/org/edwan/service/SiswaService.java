package org.edwan.service;

import org.edwan.model.Siswa;

import java.util.List;

public interface SiswaService {

    List<Siswa> getAllSiswa();
    void saveSiswa(Siswa siswa);
    Siswa getSiswaById(long id);
    void deleteSiswaById(Long id);
}
