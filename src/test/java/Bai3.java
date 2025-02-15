import com.example.KiemThuNangCaoBuoi4.enitty.Employee;
import com.example.KiemThuNangCaoBuoi4.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Bai3 {
    EmployeeService service = new EmployeeService();

    @BeforeEach
    public void setUp() {
        service = new EmployeeService();
        service.clearAll();
    }

    // Test 1: Thêm nhân viên hợp lệ
    @Test
    public void testAddValidEmployee() {
        Employee emp = new Employee(1L, "John Doe", "john.doe@example.com", "HR");
        service.addEmployee(emp);
        Assert.assertEquals(service.getAllEmployees().size(), 1);
    }

    // Test 2: Xóa nhân viên hợp lệ
    @Test
    public void testDeleteValidEmployee() {
        Employee emp = new Employee(1L, "John Doe", "john.doe@example.com", "HR");
        service.addEmployee(emp);
        service.deleteEmployee(1L);
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 3: Tìm nhân viên hợp lệ
    @Test
    public void testSearchEmployeeValid() {
        Employee emp = new Employee(1L, "John Doe", "john.doe@example.com", "HR");
        service.addEmployee(emp);
        Employee foundEmp = service.findEmployeeById(1L);
        Assert.assertNotNull(foundEmp);
    }

    // Test 4: Tìm nhân viên không tồn tại
    @Test
    public void testSearchEmployeeInvalid() {
        Employee foundEmp = service.findEmployeeById(99L);
        Assert.assertNull(foundEmp);
    }

    // Test 5: Thêm nhiều nhân viên
    @Test
    public void testAddMultipleEmployees() {
        service.addEmployee(new Employee(1L, "John Doe", "john.doe@example.com", "HR"));
        service.addEmployee(new Employee(2L, "Jane Smith", "jane.smith@example.com", "IT"));
        Assert.assertEquals(service.getAllEmployees().size(), 2);
    }

    // Test 6: Xóa nhân viên không tồn tại
    @Test
    public void testDeleteNonExistentEmployee() {
        service.deleteEmployee(99L);
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 7: Xóa nhân viên khi danh sách rỗng
    @Test
    public void testDeleteWhenEmpty() {
        service.deleteEmployee(1L);
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 8: Thêm nhân viên với ID trùng
    @Test
    public void testAddDuplicateID() {
        service.addEmployee(new Employee(1L, "John Doe", "john.doe@example.com", "HR"));
        service.addEmployee(new Employee(1L, "Jane Smith", "jane.smith@example.com", "IT"));
        Assert.assertEquals(service.getAllEmployees().size(), 1);
    }

    // Test 9: Thêm nhân viên với email trống
    @Test
    public void testAddEmptyEmail() {
        Employee emp = new Employee(2L, "Jane Smith", "", "IT");
        service.addEmployee(emp);
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 10: Kiểm tra danh sách nhân viên rỗng ban đầu
    @Test
    public void testInitialEmptyList() {
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 11: Xóa toàn bộ nhân viên trong danh sách
    @Test
    public void testClearAllEmployees() {
        service.addEmployee(new Employee(1L, "John Doe", "john.doe@example.com", "HR"));
        service.addEmployee(new Employee(2L, "Jane Smith", "jane.smith@example.com", "IT"));
        service.clearAll();
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 12: Kiểm tra thông tin nhân viên
    @Test
    public void testEmployeeInfo() {
        Employee emp = new Employee(1L, "John Doe", "john.doe@example.com", "HR");
        service.addEmployee(emp);
        Employee found = service.findEmployeeById(1L);
        Assert.assertEquals(found.getLastName(), "John Doe");
    }

    // Test 13: Thêm nhân viên với phòng ban trống
    @Test
    public void testAddEmptyDepartment() {
        Employee emp = new Employee(3L, "Emily Clark", "emily.clark@example.com", "");
        service.addEmployee(emp);
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 14: Thêm nhân viên với email không hợp lệ
    @Test
    public void testAddInvalidEmail() {
        Employee emp = new Employee(4L, "Robert Brown", "invalid-email", "Finance");
        service.addEmployee(emp);
        Assert.assertEquals(service.getAllEmployees().size(), 0);
    }

    // Test 15: Tìm  nhân viên theo mail
    @Test
    public void testSearchByDepartment() {
        service.addEmployee(new Employee(1L, "John Doe", "john.doe@example.com", "IT"));
        service.addEmployee(new Employee(2L, "Jane Smith", "jane.smith@example.com", "HR"));
        service.addEmployee(new Employee(3L, "Emily Clark", "emily.clark@example.com", "IT"));

        List<Employee> employeesInIT = service.searchByEmail("IT");
        Assert.assertEquals(employeesInIT.size(), 2);
    }
}
