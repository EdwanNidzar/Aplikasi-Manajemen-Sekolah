package org.edwan.repository;

import org.edwan.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa,Long> {
    Optional<Siswa> findByNis(String nis);
}