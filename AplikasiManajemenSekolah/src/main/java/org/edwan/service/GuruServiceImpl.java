package org.edwan.service;

import org.edwan.model.Guru;
import org.edwan.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuruServiceImpl implements GuruService{

    @Autowired
    private GuruRepository guruRepository;

    @Override
    public List<Guru> getAllGuru() {
        return guruRepository.findAll();
    }

    @Override
    public void saveGuru(Guru guru) {
        this.guruRepository.save(guru);
    }

    @Override
    public Guru getGuruById(long id) {
        Optional<Guru> optional = guruRepository.findById(id);
        Guru guru = null;
        if (optional.isPresent()){
            guru = optional.get();
        } else {
            throw new RuntimeException( "Data Guru untuk id : "+id+" tidak ditemukan");
        }
        return guru;
    }

    @Override
    public void deleteGuruById(Long id) {
        this.guruRepository.deleteById(id);
    }
}
