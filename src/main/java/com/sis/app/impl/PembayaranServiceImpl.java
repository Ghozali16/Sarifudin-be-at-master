package com.sis.app.impl;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.repo.PembayaranRepo;
import com.sis.app.service.PembayaranService;
import com.sis.app.web.BaseResponse;
import com.sis.constanta.ResponseMessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PembayaranServiceImpl implements PembayaranService {

    @Autowired
    private PembayaranRepo pembayaranRepo;

    @Override
    public BaseResponse getAllPembayaran(int page, int limit, String search) {
        List<Pembayaran> pembayaran = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            pembayaran = pembayaranRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<Pembayaran> pembayaranPage = pembayaranRepo.findAll(pageable);
            pembayaran = pembayaranPage.toList();

            addEntity.put("totalPage", pembayaranPage.getTotalPages());
            addEntity.put("totalData", pembayaranPage.getTotalElements());
            addEntity.put("numberOfData", pembayaranPage.getNumberOfElements());
            addEntity.put("number", pembayaranPage.getNumber());
        }

        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), pembayaran, addEntity);
    }

    @Override
    public BaseResponse getPembayaranById(String id) {
        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), pembayaranRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse savePembayaran(Pembayaran pembayaran) {
        return new BaseResponse(true, ResponseMessageConst.ADD_SUCCESS.toString(), pembayaranRepo.save(pembayaran));
    }

    @Override
    public BaseResponse updatePembayaran(Pembayaran pembayaran) {
        return new BaseResponse(true, ResponseMessageConst.UPDATE_SUCCESS.toString(), pembayaranRepo.save(pembayaran));
    }

    @Override
    public BaseResponse deletePembayaran(String id) {
        pembayaranRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, ResponseMessageConst.DELETE_SUCCESS.toString(), null);
    }
}
