package dao.impl;

import config.JdbcConfig;
import dao.EmployeeDao;
import dao.dto.EmployeeDto;
import domain.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    private static final String INSERT_INTO_EMPLOYEES = "INSERT INTO employees (name, salary) VALUES (?, ?)";
    private static final String UPDATE_EMPLOYEES = "UPDATE employees SET name=?, salary=? WHERE id=?";
    private static final String DELETE_FROM_EMPLOYEES = "DELETE FROM employees WHERE id=?";
    private static final String SELECT_FROM_EMPLOYEES = "SELECT * FROM employees";

    @Override
    public void insertEmployee(EmployeeDto employeeDto) {
        try (Connection conn = JdbcConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_INTO_EMPLOYEES)) {

            // Mapeamos a la entidad
            Employee employee = new Employee(
                    employeeDto.getName(),
                    employeeDto.getSalary()
            );

            // El id no se setea si ya lo hemos definido como autoincremental en la sentencia de creacion de tabla
            //pstmt.setInt(1, employee.getId());
            pstmt.setString(1, employee.getName());
            pstmt.setDouble(2, employee.getSalary());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
