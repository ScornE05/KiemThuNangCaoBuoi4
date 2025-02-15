package com.example.KiemThuNangCaoBuoi4.service;

import com.example.KiemThuNangCaoBuoi4.enitty.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> sinhVienList = new ArrayList<>();

    public void addSinhVien(SinhVien sv) {
        sinhVienList.add(sv);
    }

    public void updateSinhVien(SinhVien sv, int maSV) {
        for (SinhVien s : sinhVienList) {
            if (s.getMaSV() == maSV) {
                s.setTenSV(sv.getTenSV());
                s.setLop(sv.getLop());
                s.setKhoaHoc(sv.getKhoaHoc());
                s.setMonHoc(sv.getMonHoc());
                break;
            }
        }
    }

    public void deleteSinhVien(Long maSV) {
        sinhVienList.removeIf(s -> s.getMaSV().equals(maSV));
    }

    public SinhVien searchSinhVien(Long maSV) {
        return sinhVienList.stream().filter(s -> s.getMaSV() == maSV).findFirst().orElse(null);
    }

    public List<SinhVien> getAll() {
        return sinhVienList;
    }

    public void clearAll() {
        sinhVienList.clear();
    }

    public List<SinhVien> searchByClass(String lop) {
        List<SinhVien> result = new ArrayList<>();
        for (SinhVien sv : sinhVienList) {
            if (sv.getLop().equalsIgnoreCase(lop)) {
                result.add(sv);
            }
        }
        return result;
    }
}
