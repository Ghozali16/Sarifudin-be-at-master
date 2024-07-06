package com.sis.app.impl;

import com.sis.app.entitity.Berkas;
import com.sis.app.repo.BerkasRepo;
import com.sis.app.service.BerkasService;
import com.sis.app.web.BaseResponse;
import com.sis.constanta.ResponseMessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BerkasServiceImpl implements BerkasService {

    @Autowired
    private BerkasRepo siswaRepo;

    @Override
    public BaseResponse getAllSiswa(int page, int limit, String search) {
        List<Berkas> siswa = new ArrayList<>();
        HashMap<String, Object> addEntity = new HashMap<>();
        if (page < 0 || limit < 0) {
            siswa = siswaRepo.findAll();
        } else {
            Pageable pageable = Pageable.ofSize(limit).withPage(page);
            Page<Berkas> siswaPage = siswaRepo.findAll(pageable);
            siswa = siswaPage.toList();

            addEntity.put("totalPage", siswaPage.getTotalPages());
            addEntity.put("totalData", siswaPage.getTotalElements());
            addEntity.put("numberOfData", siswaPage.getNumberOfElements());
            addEntity.put("number", siswaPage.getNumber());
        }

        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(), siswa, addEntity);
    }

    @Override
    public BaseResponse getSiswaById(String id) {
        return new BaseResponse(true, ResponseMessageConst.GET_SUCCESS.toString(),
                siswaRepo.findById(Integer.valueOf(id)).orElse(null));
    }

    @Override
    public BaseResponse saveSiswa(Berkas siswa, MultipartFile file) {
        try {

            return new BaseResponse(true, ResponseMessageConst.ADD_SUCCESS.toString(), siswaRepo.save(siswa));
        } catch (Exception e) {
            return new BaseResponse(true, ResponseMessageConst.ADD_FAILED.toString(), siswaRepo.save(siswa));
        }
    }

    public BaseResponse updateSiswa(Berkas siswa, MultipartFile file) {
        try {

            return new BaseResponse(true, ResponseMessageConst.UPDATE_SUCCESS.toString(), siswaRepo.save(siswa));
        } catch (Exception e) {
            return new BaseResponse(true, ResponseMessageConst.UPDATE_FAILED.toString(), siswaRepo.save(siswa));
        }
    }

    @Override
    public BaseResponse deleteSiswa(String id) {
        siswaRepo.deleteById(Integer.valueOf(id));
        return new BaseResponse(true, ResponseMessageConst.DELETE_SUCCESS.toString(), null);
    }
}
