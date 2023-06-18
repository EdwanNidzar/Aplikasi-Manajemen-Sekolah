package org.edwan.service;



import org.edwan.model.Jurusan;

import java.util.List;

public interface JurusanService {

    List<Jurusan> getAllJurusan();
    void saveJurusan(Jurusan jurusan);
    Jurusan getJurusanById(long id);
    void deleteJurusanById(Long id);

}
