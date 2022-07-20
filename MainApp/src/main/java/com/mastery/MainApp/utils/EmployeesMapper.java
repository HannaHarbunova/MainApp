package com.mastery.MainApp.utils;

import com.mastery.MainApp.model.Employee;
import com.mastery.MainApp.model.Gender;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeesMapper implements RowMapper<Employee> {

    @Override
    @Transactional
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee employee = new Employee();
        employee.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
        employee.setFirstName(rs.getString("FIRST_NAME"));
        employee.setLastName(rs.getString("LAST_NAME"));
        employee.setDepartmentId(rs.getLong("DEPARTMENT_ID"));
        employee.setJobTitle(rs.getString("JOB_TITLE"));
//        employee.setGender(Gender.valueOf(rs.getString("GENDER")));
        employee.setGender(rs.getString("GENDER"));
        employee.setDateOfBirth(rs.getDate("DATE_OF_BIRTH").toLocalDate());
        return employee;
    }

}
