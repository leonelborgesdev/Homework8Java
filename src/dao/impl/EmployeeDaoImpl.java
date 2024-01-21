package dao.impl;

import config.JdbcConfig;
import dao.EmployeeDao;
import dao.dto.EmployeeDto;
import domain.Employee;

import java.sql.*;
import java.util.ArrayList;
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
        try (Connection conn = JdbcConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_EMPLOYEES)) {

            pstmt.setString(1, employee.getName());
            pstmt.setDouble(2, employee.getSalary());
            pstmt.setInt(3, employee.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection conn = JdbcConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_FROM_EMPLOYEES)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        try (Connection conn = JdbcConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_FROM_EMPLOYEES)) {

            // Iteramos el resultSet y guardamos cada empleado recuperado de la BD en una lista
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");
                employees.add(
                        new Employee(id, name, salary)
                );
            }

            // Mapeamos la lista de empleados (entidades recuperadas de la BD) a una lista de dto's
            for (Employee employee : employees) {
                employeeDtos.add(
                        new EmployeeDto(
                                employee.getName(),
                                employee.getSalary())
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeDtos;
    }
}
