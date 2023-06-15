package org.edwan.repository;

import org.edwan.model.DataKelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataKelasRepository extends JpaRepository<DataKelas, Long> {

}
