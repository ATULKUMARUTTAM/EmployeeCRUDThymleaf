package com.atuluttam.EmployeeCRUD.Controller;


import com.atuluttam.EmployeeCRUD.Model.Employee;
import com.atuluttam.EmployeeCRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String homepage(Model model)
    {
       List<Employee> employeeList = employeeService.getAllEmp();
        model.addAttribute("employees", employeeList);
        return "index";
    }


    @GetMapping("/showempform")
    public  String employeeForm(Model model)
    {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return  "empform";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee e)
    {
        employeeService.saveEmp(e);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String updateEmp(@PathVariable Integer id, Model model)
    {
        Employee e = employeeService.getEmpById(id);
            model.addAttribute("employee", e);
        return "updateemp";
    }

    @GetMapping("/delete/{id}")
    public String delEmp(@PathVariable Integer id, Model model)
    {
        employeeService.deleteEmpById(id);
       // model.addAttribute("employee", e);
   return "redirect:/home";
    }
}
