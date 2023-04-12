package com.jirayutcc.springcassandra.controller;

import com.jirayutcc.springcassandra.models.Employee;
import com.jirayutcc.springcassandra.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<?> getEmployees() {
        List<Employee> customers = employeeService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getEmployees(@RequestParam String name) {
        List<Employee> employees = employeeService.findByName(name);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable UUID id) {
        Optional<?> employee = employeeService.findById(id);
        if (employee.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping()
    public ResponseEntity<?> postEmployee(@RequestBody Employee body) {
        Employee employee = employeeService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putEmployee(@PathVariable UUID id, @RequestBody Employee body) {
        Optional<?> employee = employeeService.update(id, body);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable UUID id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
