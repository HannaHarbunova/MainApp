package com.mastery.MainApp.repository.impl;

import com.mastery.MainApp.model.Employee;
import com.mastery.MainApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public void save(Employee employee) {
//        jdbcTemplate.update("INSERT INTO EMPLOYEES" +
//                        "(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, JOB_TITLE, GENDER, DATE_OF_BIRTH) VALUES(?,?,?,?,?,?)",
//                employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
//                employee.getGender().name(), employee.getDateOfBirth());
//    }
//
//    @Override
//    public void update(Employee employee) {
//        jdbcTemplate.update("UPDATE EMPLOYEES SET FIRST_NAME=?, LAST_NAME=?, DEPARTMENT_ID=?,JOB_TITLE=?, " +
//                        "GENDER=?, DATE_OF_BIRTH=? WHERE EMPLOYEE_ID=?",
//                employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
//                employee.getGender().name(), employee.getDateOfBirth(), employee.getEmployeeId());
//    }

    @Override
    public void save(Employee employee) {
        jdbcTemplate.update("INSERT INTO EMPLOYEES" +
                        "(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, JOB_TITLE, GENDER, DATE_OF_BIRTH) VALUES(?,?,?,?,?,?)",
                employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender(), employee.getDateOfBirth());
    }

    @Override
    public void update(Employee employee) {
        jdbcTemplate.update("UPDATE EMPLOYEES SET FIRST_NAME=?, LAST_NAME=?, DEPARTMENT_ID=?,JOB_TITLE=?, " +
                        "GENDER=?, DATE_OF_BIRTH=? WHERE EMPLOYEE_ID=?",
                employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender(), employee.getDateOfBirth(), employee.getEmployeeId());
    }

    @Override
    public Employee getById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?",
                    BeanPropertyRowMapper.newInstance(Employee.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM EMPLOYEES",
                BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public boolean existsById(Long id) {
        jdbcTemplate.query("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?",
                BeanPropertyRowMapper.newInstance(Employee.class), id);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID=?", id);
    }
}
