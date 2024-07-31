package org.example.dao;


import org.example.model.Employee;

public class EmployeeDaoImpl implements  BaseDao<Employee> {
    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
    
}
