package com.sis.app.entitity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pengumuman")
public class Pengumuman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "judul")
    private String judul;

    @Column(name = "isi_pengumuman")
    private String isiPengumuman;

    @Column(name = "tanggal")
    private LocalDate tanggal;
}
