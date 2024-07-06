package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "calon_siswa")
public class CalonSiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column(name = "jenis_kelamin")
    private String jenisKelamin;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "agama")
    private String agama;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "id_siswa", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private List<Berkas> berkasList;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "id_siswa", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private List<Test> testList;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "id_siswa", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private List<VerifikasiBerkas> verifikasiBerkasList;

    @OneToMany
    @JoinColumns({
            @JoinColumn(name = "id_siswa", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private List<Pembayaran> pembayaranList;
}
