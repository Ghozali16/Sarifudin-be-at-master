package com.sis.app.controller;

import com.sis.app.entitity.Pengumuman;
import com.sis.app.impl.PengumumanServiceImpl;
import com.sis.app.web.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/tagihan-spp")
public class PengumumanController {

    @Autowired
    private PengumumanServiceImpl tagihanSPPServiceImpl;

    @GetMapping
    public BaseResponse getAllTagihanSPP(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
            @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        return tagihanSPPServiceImpl.getAllTagihanSPP(page, limit, search);
    }

    @GetMapping("/{id}")
    public BaseResponse getTagihanSPPById(@PathVariable("id") String id) {
        return tagihanSPPServiceImpl.getTagihanSPPById(id);
    }

    @PostMapping
    public BaseResponse saveTagihanSPP(@RequestBody Pengumuman tagihanSPP) {
        return tagihanSPPServiceImpl.saveTagihanSPP(tagihanSPP);
    }

    @PutMapping
    public BaseResponse updateTagihanSPP(@RequestBody Pengumuman tagihanSPP) {
        return tagihanSPPServiceImpl.updateTagihanSPP(tagihanSPP);
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteTagihanSPP(@PathVariable("id") String id) {
        return tagihanSPPServiceImpl.deleteTagihanSPP(id);
    }
}
