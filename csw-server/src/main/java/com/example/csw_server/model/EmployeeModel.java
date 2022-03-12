package com.example.csw_server.model;

import com.example.csw_server.entity.Employee;
import com.example.csw_server.utils.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    private Connection conn;

    public EmployeeModel() {
        conn = ConnectionHelper.getConnection();
    }
    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("select * from employees ");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            String numberphone = rs.getString("numberphone");
            employees.add(new Employee(id, name, age, address, numberphone));
        }
        return employees;
    }
    public Employee save(Employee employee) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into employees (name, age, address, numberphone) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, employee.getName());
        stmt.setInt(2,employee.getAge());
        stmt.setString(3, employee.getAddress());
        stmt.setString(4, employee.getNumberphone());
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            ResultSet resultSetGeneratedKeys = stmt.getGeneratedKeys();
            if (resultSetGeneratedKeys.next()) {
                int id = resultSetGeneratedKeys.getInt(1);
                employee.setId(id);
                return employee;
            }
        }
        return null;
    }

    public Employee update(int id, Employee updateEmployee) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("update employees set name = ?, age= ?, address = ?,numberphone=? where id = ?");
        stmt.setString(1, updateEmployee.getName());
        stmt.setInt(2,updateEmployee.getAge());
        stmt.setString(3, updateEmployee.getAddress());
        stmt.setString(4, updateEmployee.getNumberphone());
        stmt.setInt(5, id);
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            updateEmployee.setId(id);
            return updateEmployee;
        }
        return null;
    }
    public Employee findById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from employees where id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            String numberphone = rs.getString("numberphone");
            return new Employee(id, name, age, address,numberphone);
        }
        return null;
    }
}
