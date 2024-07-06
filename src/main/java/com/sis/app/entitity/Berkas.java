package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "berkas")
public class Berkas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_siswa")
    private CalonSiswa calonSiswa;

    @Column(name = "file_berkas")
    private byte[] fileBerkas;

    @Column(name = "status_verifikasi")
    private String statusVerifikasi;
}