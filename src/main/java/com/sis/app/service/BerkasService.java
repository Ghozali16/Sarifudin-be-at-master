package com.sis.app.service;

import com.sis.app.entitity.Berkas;
import com.sis.app.web.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface BerkasService {
    BaseResponse getAllSiswa(int page, int limit, String search);

    BaseResponse getSiswaById(String id);

    BaseResponse saveSiswa(Berkas siswa, MultipartFile file);

    BaseResponse updateSiswa(Berkas siswa, MultipartFile file);

    BaseResponse deleteSiswa(String id);
}
