package com.sis.app.controller;

import com.sis.app.entitity.Pembayaran;
import com.sis.app.impl.PembayaranServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {

    @Autowired
    private PembayaranServiceImpl pembayaranServiceImpl;

    @GetMapping
    public BaseResponse getAllPembayaran(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "limit", required = false, defaultValue = "10") int limit, @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return pembayaranServiceImpl.getAllPembayaran(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getPembayaranById(@PathVariable("id") String id) {
        return pembayaranServiceImpl.getPembayaranById(id);
    }

    @PostMapping
    public BaseResponse savePembayaran(@RequestBody Pembayaran pembayaran) {
        return pembayaranServiceImpl.savePembayaran(pembayaran);
    }

    @PutMapping
    public BaseResponse updatePembayaran(@RequestBody Pembayaran pembayaran) {
        return pembayaranServiceImpl.updatePembayaran(pembayaran);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deletePembayaran(@PathVariable("id") String id) {
        return pembayaranServiceImpl.deletePembayaran(id);
    }
}
