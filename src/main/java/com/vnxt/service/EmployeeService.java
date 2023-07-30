package com.vnxt.service;

import com.vnxt.model.Employee;
import com.vnxt.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class EmployeeService implements CrudService<Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee retrieve(int id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Employee with id: " + id + ", not available."));
    }

    @Override
    public Employee update(Employee employee) {
        Employee employeeDb = employeeRepository.findById(employee.getId()).orElseThrow(
                () -> new EntityNotFoundException("Employee with id: " + employee.getId() + ", not available."));

        employeeDb.setName(employee.getName());
        employeeDb.setDesignation(employee.getDesignation());

        return employeeRepository.save(employeeDb);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> retrieveAll() {
        return employeeRepository.findAll();
    }

    @KafkaListener(topics = "ADDRESS_TOPIC")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }
}
