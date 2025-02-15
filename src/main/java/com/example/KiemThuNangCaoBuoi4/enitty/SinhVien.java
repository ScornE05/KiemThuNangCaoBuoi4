package com.example.KiemThuNangCaoBuoi4.enitty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SinhVien {
    private Long maSV;
    private String tenSV;
    private String lop;
    private String khoaHoc;
    private String monHoc;

}
