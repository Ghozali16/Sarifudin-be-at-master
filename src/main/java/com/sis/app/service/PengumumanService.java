package com.sis.app.service;

import com.sis.app.entitity.Pengumuman;
import com.sis.app.web.BaseResponse;

public interface PengumumanService {
    BaseResponse getAllTagihanSPP(int page, int limit, String search);

    BaseResponse getTagihanSPPById(String id);

    BaseResponse saveTagihanSPP(Pengumuman tagihanSPP);

    BaseResponse updateTagihanSPP(Pengumuman tagihanSPP);

    BaseResponse deleteTagihanSPP(String id);
}
