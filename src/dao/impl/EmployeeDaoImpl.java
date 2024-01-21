package dao.impl;

import dao.EmployeeDao;
import dao.dto.EmployeeDto;
import domain.Employee;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String INSERT_INTO_EMPLOYEES = "INSERT INTO employees (name, salary) VALUES (?, ?)";
    private static final String UPDATE_EMPLOYEES = "UPDATE employees SET name=?, salary=? WHERE id=?";
    private static final String DELETE_FROM_EMPLOYEES = "DELETE FROM employees WHERE id=?";
    private static final String SELECT_FROM_EMPLOYEES = "SELECT * FROM employees";

    @Override
    public void insertEmployee(EmployeeDto employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return null;
    }
}
