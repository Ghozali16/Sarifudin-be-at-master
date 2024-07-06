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
@Table(name = "verifikasi_berkas")
public class VerifikasiBerkas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "id_calon_siswa")
        private CalonSiswa calonSiswa;

        @Column(name = "tanggal_verifikasi")
        private LocalDate tanggalVerifikasi;

        @Column(name = "status_verifikasi")
        private String statusVerifikasi;
}
