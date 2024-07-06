package com.sis.app.service;

import com.sis.app.entitity.Test;
import com.sis.app.web.BaseResponse;

public interface TestService {
    BaseResponse getAllTahunAjaran(int page, int limit, String search);

    BaseResponse getTahunAjaranById(String id);

    BaseResponse saveTahunAjaran(Test tahunAjaran);

    BaseResponse updateTahunAjaran(Test tahunAjaran);

    BaseResponse deleteTahunAjaran(String id);
}
