package com.atuluttam.EmployeeCRUD.Service;

import com.atuluttam.EmployeeCRUD.Model.Employee;
import com.atuluttam.EmployeeCRUD.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository er;
    public List<Employee>  getAllEmp()
    {
             return er.findAll();
    }

    public void saveEmp(Employee e)
    {
        er.save(e);
    }

    public  Employee getEmpById(Integer id)
    {
        Optional<Employee> emp = er.findById(id);
        if(emp.isEmpty())
                throw  new RuntimeException("EMPLOYEE NOT Exist with Id" +id);
            return emp.get();
    }

    public void deleteEmpById(Integer id)
    {
        Employee e = getEmpById(id);
        er.deleteById(e.getId());
    }




}
