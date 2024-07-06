package com.sis.app.controller;

import com.sis.app.entitity.Test;
import com.sis.app.impl.TestServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tahun-ajaran")
public class TestController {

    @Autowired
    private TestServiceImpl tahunAjaranServiceImpl;

    @GetMapping
    public BaseResponse getAllTahunAjaran(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return tahunAjaranServiceImpl.getAllTahunAjaran(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getTahunAjaranById(@PathVariable("id") String id) {
        return tahunAjaranServiceImpl.getTahunAjaranById(id);
    }

    @PostMapping
    public BaseResponse saveTahunAjaran(@RequestBody Test req) {
        return tahunAjaranServiceImpl.saveTahunAjaran(req);
    }

    @PutMapping
    public BaseResponse updateTahunAjaran(@RequestBody Test req) {
        return tahunAjaranServiceImpl.updateTahunAjaran(req);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTahunAjaran(@PathVariable("id") String id) {
        return tahunAjaranServiceImpl.deleteTahunAjaran(id);
    }
}
