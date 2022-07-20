package com.mastery.MainApp.repository;

import com.mastery.MainApp.model.Employee;

import java.util.List;

public interface EmployeeRepository  {

    void save(Employee employee);

    void update(Employee employee);

    Employee getById(Long id);

    List<Employee> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

}
