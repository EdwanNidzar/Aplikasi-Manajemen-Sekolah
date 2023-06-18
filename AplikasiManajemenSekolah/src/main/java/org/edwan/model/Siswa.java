package org.edwan.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nis;

    private String namaSiswa;
    private String tempatLahirSiswa;
    private LocalDate tanggalLahirSiswa;
    private String jenisKelaminSiswa;
    private String alamatSiswa;x

    @Column(unique = true)
    private String emailSiswa;
    private String nomorTelpSiswa;

    @ManyToOne
    @JoinColumn(name = "id_kelas")
    private DataKelas kelas;

    @ManyToOne
    @JoinColumn(name = "id_jurusan")
    private Jurusan jurusan;

}

