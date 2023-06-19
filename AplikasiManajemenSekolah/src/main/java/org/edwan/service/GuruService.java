package org.edwan.service;



import org.edwan.model.Guru;

import java.util.List;

public interface GuruService {
    List<Guru> getAllGuru();
    void saveGuru(Guru guru);
    Guru getGuruById(long id);
    void deleteGuruById(Long id);
}
