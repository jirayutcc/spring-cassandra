package com.jirayutcc.springcassandra.repository;

import com.jirayutcc.springcassandra.models.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends CassandraRepository<Employee, UUID> {
    List<Employee> findByFirstName(String firstName);
}
