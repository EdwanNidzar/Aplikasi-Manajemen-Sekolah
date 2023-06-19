package org.edwan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "siswa")
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siswa")
    private Long id_siswa;

    @Column(unique = true)
    private String nis;

    private String nama_siswa;
    private String tempat_lahir_siswa;
    private LocalDate tanggal_lahir_siswa;
    private String jenis_kelamin_siswa;
    private String alamat_siswa;

    @Column(unique = true)
    private String email_siswa;
    private String nomor_telp_siswa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_kelas", referencedColumnName = "id")
    private DataKelas data_kelas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_jurusan", referencedColumnName = "id")
    private Jurusan jurusan;
}

