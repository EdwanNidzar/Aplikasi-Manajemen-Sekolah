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
@Table(name = "guru")
public class Guru {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nip;
    private String nama_guru;
    private String tempat_lahir_guru;
    private LocalDate tanggal_lahir_guru;
    private String jenis_kelamin_guru;
    private String alamat_guru;
    @Column(unique = true)
    private String email_guru;
    private String nomor_telp_guru;

}