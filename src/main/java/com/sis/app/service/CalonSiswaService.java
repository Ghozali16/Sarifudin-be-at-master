package com.sis.app.service;

import com.sis.app.entitity.CalonSiswa;
import com.sis.app.web.BaseResponse;

public interface CalonSiswaService {
    BaseResponse getAllTagihanLain(int page, int limit, String search);

    BaseResponse getTagihanLainById(String id);

    BaseResponse saveTagihanLain(CalonSiswa tagihanLain);

    BaseResponse updateTagihanLain(CalonSiswa tagihanLain);

    BaseResponse deleteTagihanLain(String id);
}
