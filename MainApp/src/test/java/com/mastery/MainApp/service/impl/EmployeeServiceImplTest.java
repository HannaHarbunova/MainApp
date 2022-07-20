package com.mastery.MainApp.service.impl;

import com.mastery.MainApp.model.Employee;
import com.mastery.MainApp.model.Gender;
import com.mastery.MainApp.repository.impl.EmployeeRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    private Employee employee;
    private List<Employee> employeesList;

    @Mock
    private EmployeeRepositoryImpl employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setEmployeeId(1L);
        employee.setFirstName("Vasya");
        employee.setLastName("Pupkin");
        employee.setDepartmentId(4L);
        employee.setJobTitle("DevManager");
//        employee.setGender(Gender.MALE);
        employee.setGender("MALE");
        employee.setDateOfBirth(LocalDate.parse("1984-11-11"));

        employeesList = new ArrayList<>();
        employeesList.add(employee);
    }

    @Test
    void testCreateSuccess() {
        employeeService.create(employee);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testReadAll() {
        when(employeeRepository.findAll()).thenReturn(employeesList);
        List<Employee> expected = employeesList;
        List<Employee> actual = employeeService.readAll();
        assertEquals(expected, actual);
    }

    @Test
    void testReadById() {
        when(employeeRepository.getById(1L)).thenReturn(employee);
        Employee expected = employee;
        Employee actual = employeeService.read(1L);
        assertEquals(expected, actual);
    }

    @Test
    void testUpdate() {
        when(employeeRepository.existsById(1L)).thenReturn(true);
        employeeService.update(employee, 1L);
        verify(employeeRepository, times(1)).update(employee);
    }

    @Test
    void testDelete() {
        when(employeeRepository.existsById(1L)).thenReturn(true);
        employeeService.delete(1L);
        verify(employeeRepository, times(1)).deleteById(1L);
    }
}