package com.jirayutcc.springcassandra.services;

import com.jirayutcc.springcassandra.constant.ErrorMapping;
import com.jirayutcc.springcassandra.exception.BusinessException;
import com.jirayutcc.springcassandra.models.Employee;
import com.jirayutcc.springcassandra.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByFirstName(name);
    }

    @SneakyThrows
    public Employee create(Employee customer) {

        try {
            val employee = employeeRepository.save(customer);
            log.info("insert employee success");

            return employee;
        } catch (Exception ex) {
            throw new BusinessException(
                    ErrorMapping.CODE1000.getCode(),
                    ErrorMapping.CODE1000.getMessage()
            );
        }
    }

    public Optional<Employee> update(UUID id, Employee employee) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isEmpty()) {
            return employeeOpt;
        }
        employee.setId(id);
        return Optional.of(employeeRepository.save(employee));
    }

    @SneakyThrows
    public void delete(UUID id) {
        try {
            employeeRepository.deleteById(id);
            log.info("delete employee success");
        } catch (Exception e) {
            throw new BusinessException(
                    ErrorMapping.CODE3000.getCode(),
                    ErrorMapping.CODE3000.getMessage()
            );
        }
    }
}
