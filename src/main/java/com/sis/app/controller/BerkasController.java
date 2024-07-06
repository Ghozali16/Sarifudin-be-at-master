package com.sis.app.controller;

import com.sis.app.entitity.Berkas;
import com.sis.app.impl.BerkasServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/siswa")
public class BerkasController {

    @Autowired
    private BerkasServiceImpl siswaServiceImpl;

    @GetMapping
    public BaseResponse getAllSiswa(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return siswaServiceImpl.getAllSiswa(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getSiswaById(@PathVariable("id") String id) {
        return siswaServiceImpl.getSiswaById(id);
    }

    @PostMapping
    public BaseResponse saveSiswa(@RequestPart("siswa") Berkas siswa, @RequestPart("foto") MultipartFile foto) {
        return siswaServiceImpl.saveSiswa(siswa, foto);
    }

    @PutMapping
    public BaseResponse updateSiswa(@RequestPart("siswa") Berkas siswa, @RequestPart("foto") MultipartFile foto) {
        return siswaServiceImpl.updateSiswa(siswa, foto);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteSiswa(@PathVariable("id") String id) {
        return siswaServiceImpl.deleteSiswa(id);
    }
}
