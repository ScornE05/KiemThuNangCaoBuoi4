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

public class Employee {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
}
