import config.JdbcConfig;
import dao.EmployeeDao;
import dao.dto.EmployeeDto;
import dao.impl.EmployeeDaoImpl;

import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        JdbcConfig.createTable();

        EmployeeDao dao=new EmployeeDaoImpl();
        //Insertar empleado
        EmployeeDto emp1=new EmployeeDto("John Doe", 50000.0);
        dao.insertEmployee(emp1);

        List<EmployeeDto> employeeDtos= dao.getAllEmployees();
        for (EmployeeDto employee : employeeDtos){
            System.out.println("-> "+ employee.getName() + " | "+ employee.getSalary());
        }
    }
}