package com.example.KiemThuNangCaoBuoi4.service;
import com.example.KiemThuNangCaoBuoi4.enitty.Employee;
import com.example.KiemThuNangCaoBuoi4.enitty.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // Thêm nhân viên
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Xóa nhân viên theo ID
    public boolean deleteEmployee(Long id) {
        return employees.removeIf(e -> e.getId().equals(id));
    }

    // Cập nhật thông tin nhân viên
    public boolean updateEmployee(Long id, String firstName, String lastName, String email) {
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                e.setFirstName(firstName);
                e.setLastName(lastName);
                e.setEmail(email);
                return true;
            }
        }
        return false;
    }

    // Tìm nhân viên theo ID
    public Employee findEmployeeById(Long id) {
        return employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    // Lấy danh sách nhân viên
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    // Xóa toàn bộ danh sách nhân viên
    public void clearAll() {
        employees.clear();
    }

    public List<Employee> searchByEmail(String email) {
        List<Employee> result = new ArrayList<>();
        for (Employee sv : employees) {
            if (sv.getEmail().equalsIgnoreCase(email)) {
                result.add(sv);
            }
        }
        return result;
    }
}
