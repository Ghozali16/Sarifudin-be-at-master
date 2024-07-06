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
@Table(name = "pembayaran")
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_ta")
    @JsonProperty("id_ta")
    private int idTa;

    @Column(name = "id_siswa")
    @JsonProperty("id_siswa")
    private int idSiswa;

    @Column(name = "tgl_pembayaran")
    @JsonProperty("tgl_pembayaran")
    private LocalDate tglPembayaran;

    @Column(name = "jumlah_bayar")
    @JsonProperty("jumlah_bayar")
    private int jumlahBayar;

    @Column(name = "metode_bayar")
    @JsonProperty("metode_bayar")
    private int metodeBayar;

    @OneToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumns({
            @JoinColumn(name = "id_pembayaran", referencedColumnName = "id", insertable = false, updatable = false)
    })
    private List<VerifikasiBerkas> transaksiList;

}
