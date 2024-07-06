package com.sis.app.controller;

import com.sis.app.entitity.VerifikasiBerkas;
import com.sis.app.impl.VerifikasiBerkasServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/transaksi")
public class VerifikasiBerkasController {

    @Autowired
    private VerifikasiBerkasServiceImpl transaksiServiceImpl;

    @GetMapping
    public BaseResponse getAllTransaksi(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "0") int limit,
            @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return transaksiServiceImpl.getAllTransaksi(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getTransaksiById(@PathVariable("id") String id) {
        return transaksiServiceImpl.getTransaksiById(id);
    }

    @PostMapping
    public BaseResponse saveTransaksi(@RequestBody VerifikasiBerkas transaksi) {
        return transaksiServiceImpl.saveTransaksi(transaksi);
    }

    @PutMapping
    public BaseResponse UpdateTransaksi(@RequestBody VerifikasiBerkas transaksi) {
        return transaksiServiceImpl.updateTransaksi(transaksi);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTransaksi(@PathVariable("id") String id) {
        return transaksiServiceImpl.deleteTransaksi(id);
    }
}
