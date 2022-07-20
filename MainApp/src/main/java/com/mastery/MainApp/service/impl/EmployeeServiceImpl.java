package com.mastery.MainApp.service.impl;

import com.mastery.MainApp.model.Employee;
import com.mastery.MainApp.repository.EmployeeRepository;
import com.mastery.MainApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> readAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee read(Long id) {
        return employeeRepository.getById(id);
    }

    @Override
    public boolean update(Employee employee,Long id) {
        if (employeeRepository.existsById(id)){
            employee.setEmployeeId(id);
            employeeRepository.update(employee);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
