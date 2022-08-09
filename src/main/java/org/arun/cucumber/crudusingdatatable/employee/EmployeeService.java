package org.arun.cucumber.crudusingdatatable.employee;

import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.CreateEmployee;
import org.arun.cucumber.crudusingdatatable.employee.ValidationGroups.UpdateEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Validated(CreateEmployee.class)
    public EmployeeEntity create(@Valid Employee employee) {
        EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
        return employeeDao.save(employeeEntity);
    }

    @Transactional
    @Validated(UpdateEmployee.class)
    public EmployeeEntity update(@Valid Employee employee) {
        EmployeeEntity employeeEntity = mapper.toEmployeeEntity(employee);
        return employeeDao.save(employeeEntity);
    }

    @Transactional(readOnly = true)
    public Employee getById(@NotNull Long id) {
        EmployeeEntity employeeEntity = employeeDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));

        return mapper.toEmployee(employeeEntity);
    }

    @Transactional
    @Validated(ValidationGroups.DeleteEmployee.class)
    public void deleteById(@NotNull Long id) {
        EmployeeEntity employeeEntity = employeeDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found for given id"));
        employeeDao.delete(employeeEntity);
    }

}
