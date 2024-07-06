package com.sis.app.service;

import com.sis.app.entitity.VerifikasiBerkas;
import com.sis.app.web.BaseResponse;

public interface VerifikasiBerkasService {
    BaseResponse getAllTransaksi(int page, int limit, String search);

    BaseResponse getTransaksiById(String id);

    BaseResponse saveTransaksi(VerifikasiBerkas transaksi);

    BaseResponse updateTransaksi(VerifikasiBerkas transaksi);

    BaseResponse deleteTransaksi(String id);
}
