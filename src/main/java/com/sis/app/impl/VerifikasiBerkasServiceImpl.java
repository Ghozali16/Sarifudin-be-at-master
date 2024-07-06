package com.sis.app.impl;

import com.sis.app.entitity.VerifikasiBerkas;
import com.sis.app.repo.VerifikasiBerkasRepo;
import com.sis.app.service.VerifikasiBerkasService;
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
public class VerifikasiBerkasServiceImpl implements VerifikasiBerkasService {

    @Autowired
    private VerifikasiBerkasRepo transaksiRepo;

    @Override
    public BaseResponse getAllTransaksi(int page, int limit, String search) {
        List<VerifikasiBerkas> transaksi = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            transaksi = transaksiRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<VerifikasiBerkas> transaksiPage = transaksiRepo.findAll(pageable);
            transaksi = transaksiPage.toList();

            addEntity.put("totalPage", transaksiPage.getTotalPages());
            addEntity.put("totalData", transaksiPage.getTotalElements());
            addEntity.put("numberOfData", transaksiPage.getNumberOfElements());
            addEntity.put("number", transaksiPage.getNumber());
        }

        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), transaksi, addEntity);
    }

    @Override
    public BaseResponse getTransaksiById(String id) {
        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(),
                transaksiRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse saveTransaksi(VerifikasiBerkas transaksi) {
        return new BaseResponse(true, ResponseMessageConst.ADD_SUCCESS.toString(), transaksiRepo.save(transaksi));
    }

    @Override
    public BaseResponse updateTransaksi(VerifikasiBerkas transaksi) {
        return new BaseResponse(true, ResponseMessageConst.UPDATE_SUCCESS.toString(), transaksiRepo.save(transaksi));
    }

    @Override
    public BaseResponse deleteTransaksi(String id) {
        transaksiRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, ResponseMessageConst.DELETE_SUCCESS.toString(), null);
    }
}
