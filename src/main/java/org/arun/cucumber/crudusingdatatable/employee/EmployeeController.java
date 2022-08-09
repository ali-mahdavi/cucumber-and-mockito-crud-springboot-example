package org.arun.cucumber.crudusingdatatable.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>((MultiValueMap<String, String>) employeeService.create(employee), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id) {
        Employee employee = employeeService.getById(id);

        return ResponseEntity.ok(employee);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {

        return new ResponseEntity<>((MultiValueMap<String, String>) employeeService.update(employee), HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> deleteById(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok()
                .build();
    }
}
