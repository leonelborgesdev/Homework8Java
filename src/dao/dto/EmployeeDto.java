package dao.dto;

public class EmployeeDto {
    private String name;
    private double salary;
    public EmployeeDto(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
}
