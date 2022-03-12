package com.example.csw_server.model;

import com.example.csw_server.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeModelTest {
    private EmployeeModel employeeModel;
    @BeforeEach
    void setUp() {
        employeeModel = new EmployeeModel();
    }

    @Test
    void findAll() throws SQLException {
        Employee product = new Employee("Employee 1", 22, "75 Hồ ba mẫu","01238137");
        employeeModel.save(product);
        List<Employee> productList = employeeModel.findAll();
        assertThat(productList.size()).isGreaterThan(0);
    }

    @Test
    void save() throws SQLException {
        Employee product = new Employee("Employee 1", 22, "75 Hồ ba mẫu","01238137");
        Employee insertedProduct = employeeModel.save(product);
        assertThat(insertedProduct.getId()).isNotEqualTo(0);
    }

    @Test
    void update() throws SQLException {
        Employee product = new Employee("Employee 1", 22, "75 Hồ ba mẫu","01238137");
        Employee insertedProduct = employeeModel.save(product);
        Employee updateProduct = new Employee("Employee 2", 21, "75 Hồ ba mẫu","01238137");
        Employee updatedProduct = employeeModel.update(insertedProduct.getId(), updateProduct);
        assertThat(updatedProduct).isEqualToComparingFieldByFieldRecursively(updateProduct);
    }

    @Test
    void findById() throws SQLException {
        Employee product = new Employee("Employee 1", 22, "75 Hồ ba mẫu","01238137");
        Employee insertedProduct = employeeModel.save(product);
        Employee foundProduct = employeeModel.findById(insertedProduct.getId());
        assertThat(foundProduct).isNotNull();
    }
}