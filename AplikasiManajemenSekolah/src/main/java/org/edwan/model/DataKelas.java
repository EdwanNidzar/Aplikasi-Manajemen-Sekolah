package org.edwan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "data_kelas")
public class DataKelas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nama_kelas;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "data_kelas", fetch = FetchType.LAZY)
    private Siswa siswa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }
}
