package com.mastery.MainApp.service;

import com.mastery.MainApp.model.Employee;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);

    List<Employee> readAll();

    Employee read(Long id);

    boolean update(Employee employee, Long id);

    boolean delete(Long id);
}
