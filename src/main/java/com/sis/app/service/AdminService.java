package com.sis.app.service;

import com.sis.app.entitity.admin;
import com.sis.app.web.BaseResponse;

public interface AdminService {
    BaseResponse getAllKomponen(int page, int limit, String search);

    BaseResponse getKomponenById(String id);

    BaseResponse saveKomponen(admin komponen);

    BaseResponse updateKomponen(admin komponen);

    BaseResponse deleteKomponen(String id);
}
