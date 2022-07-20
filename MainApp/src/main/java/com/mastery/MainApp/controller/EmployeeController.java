package com.mastery.MainApp.controller;

import com.mastery.MainApp.model.Employee;
import com.mastery.MainApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<?> create(@RequestBody Employee employee) {
        employeeService.create(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> read() {
        final List<Employee> employees = employeeService.readAll();

        return employees != null &&  !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> readById(@PathVariable(name = "id") Long id) {
        final Employee employee = employeeService.read(id);

        return employee != null
                ? new ResponseEntity<>(employee, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Employee employee) {
        final boolean updated = employeeService.update(employee, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = employeeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
