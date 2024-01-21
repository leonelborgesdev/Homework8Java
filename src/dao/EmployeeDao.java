package dao;

import dao.dto.EmployeeDto;
import domain.Employee;

import java.util.List;

public interface EmployeeDao {
    void insertEmployee(EmployeeDto employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<EmployeeDto> getAllEmployees();
}
