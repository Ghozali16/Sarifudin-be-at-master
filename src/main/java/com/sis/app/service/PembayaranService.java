package com.sis.app.service;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.web.BaseResponse;

public interface PembayaranService {
    BaseResponse getAllPembayaran(int page, int limit, String search);
    BaseResponse getPembayaranById(String id);
    BaseResponse savePembayaran(Pembayaran pembayaran);
    BaseResponse updatePembayaran(Pembayaran pembayaran);
    BaseResponse deletePembayaran(String id);
}
