import com.example.KiemThuNangCaoBuoi4.enitty.SinhVien;
import com.example.KiemThuNangCaoBuoi4.service.SinhVienService;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class Bai2 {
    SinhVienService service = new SinhVienService();

    @BeforeEach
    public void setUp(){
        service = new SinhVienService();
        service.clearAll();
    }
    // Test 1: Thêm sinh viên hợp lệ
    @Test
    public void testAddValid() {
        SinhVien sv = new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan");
        service.addSinhVien(sv);
        Assert.assertEquals(service.getAll().size(), 1);
    }

    // Test 2: Xóa sinh viên hợp lệ
    @Test
    public void testDeleteValid() {
        SinhVien sv = new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan");
        service.addSinhVien(sv);
        service.deleteSinhVien(1L);
        Assert.assertEquals(service.getAll().size(), 0);
    }

    // Test 3: Tìm sinh viên hợp lệ
    @Test
    public void testSearchSinhVienValid() {
        SinhVien sv = new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan");
        service.addSinhVien(sv);
        SinhVien foundSV = service.searchSinhVien(1L);
        Assert.assertNotNull(foundSV);
    }

    // Test 4: Tìm sinh viên không tồn tại
    @Test
    public void testSearchSinhVienInvalid() {
        SinhVien foundSV = service.searchSinhVien(99L);
        Assert.assertNull(foundSV);
    }

    // Test 5: Thêm 2 sinh viên, kiểm tra danh sách
    @Test
    public void testAddMultipleStudents() {
        service.addSinhVien(new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan"));
        service.addSinhVien(new SinhVien(2L, "Le Van B", "10A2", "2025", "Ly"));
        Assert.assertEquals(service.getAll().size(), 2);
    }

    // Test 6: Xóa sinh viên không tồn tại
    @Test
    public void testDeleteNonExistentStudent() {
        service.deleteSinhVien(99L);
        Assert.assertEquals(service.getAll().size(), 0);
    }

    // Test 7: Xóa sinh viên khi danh sách rỗng
    @Test
    public void testDeleteWhenEmpty() {
        service.deleteSinhVien(1L);
        Assert.assertEquals(service.getAll().size(), 0);
    }

    // Test 8: Thêm sinh viên với ID trùng
    @Test
    public void testAddDuplicateID() {
        service.addSinhVien(new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan"));
        service.addSinhVien(new SinhVien(1L, "Le Van B", "10A2", "2025", "Ly")); // Trùng ID
        Assert.assertEquals(service.getAll().size(), 1);
    }

    // Test 9: Thêm sinh viên với tên trống
    @Test
    public void testAddEmptyName() {
        SinhVien sv = new SinhVien(2L, "", "10A1", "2024", "Toan");
        service.addSinhVien(sv);
        Assert.assertEquals(service.getAll().size(), 0);
    }

    // Test 10: Kiểm tra danh sách sinh viên rỗng ban đầu
    @Test
    public void testInitialEmptyList() {
        Assert.assertEquals(service.getAll().size(), 0);
    }

    //Test 11: Xóa toàn bộ sinh viên trong danh sách
    @Test
    public void testClearAllStudents() {
        service.addSinhVien(new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan"));
        service.addSinhVien(new SinhVien(2L, "Le Van B", "10A2", "2025", "Ly"));
        service.clearAll();
        Assert.assertEquals(service.getAll().size(), 0);
    }

    // Test 12: Thêm sinh viên và kiểm tra thông tin
    @Test
    public void testStudentInfo() {
        SinhVien sv = new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan");
        service.addSinhVien(sv);
        SinhVien found = service.searchSinhVien(1L);
        Assert.assertEquals(found.getTenSV(), "Nguyen Van A");
    }

    // Test 13: Thêm sinh viên với lớp trống
    @Test
    public void testAddEmptyClass() {
        SinhVien sv = new SinhVien(3L, "Tran Van C", "", "2023", "Hoa");
        service.addSinhVien(sv);
        Assert.assertEquals(service.getAll().size(), 0);
    }

    //Test 14: Thêm sinh viên với năm học không hợp lệ
    @Test
    public void testAddInvalidYear() {
        SinhVien sv = new SinhVien(4L, "Pham Thi D", "10A1", "abcd", "Ly");
        service.addSinhVien(sv);
        Assert.assertEquals(service.getAll().size(), 0);
    }

    // Test 15: Tìm tất cả sinh viên trong lớp 10A1
    @Test
    public void testSearchByClass() {
        service.addSinhVien(new SinhVien(1L, "Nguyen Van A", "10A1", "2024", "Toan"));
        service.addSinhVien(new SinhVien(2L, "Le Van B", "10A2", "2025", "Ly"));
        service.addSinhVien(new SinhVien(3L, "Tran Van C", "10A1", "2023", "Hoa"));

        List<SinhVien> studentsInClass = service.searchByClass("10A1");
        Assert.assertEquals(studentsInClass.size(), 2);
    }
}
