package com.example.KiemThuNangCaoBuoi4.service;

import com.example.KiemThuNangCaoBuoi4.enitty.BaiHat;

import java.util.ArrayList;
import java.util.List;
public class BaiHatService {
    private List<BaiHat> danhSachBaiHat = new ArrayList<>();

    public void addBaiHat(BaiHat baiHat) {
        danhSachBaiHat.add(baiHat);
    }

    public void updateBaiHat(BaiHat baiHatMoi, String id) {
        for (int i = 0; i < danhSachBaiHat.size(); i++) {
            if (danhSachBaiHat.get(i).getId().equals(id)) {
                danhSachBaiHat.set(i, baiHatMoi);
                return;
            }
        }
    }

    public void deleteBaiHat(String id) {
        danhSachBaiHat.removeIf(bh -> bh.getId().equals(id));
    }

    public BaiHat searchBaiHat(String id) {
        return danhSachBaiHat.stream()
                .filter(bh -> bh.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<BaiHat> getAll() {
        return danhSachBaiHat;
    }
}
