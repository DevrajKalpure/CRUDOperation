package com.nt.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmService;

@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeMgmService employeeService;
	
	@GetMapping("/")
	public String homePage() {
		return "welcome";
	}

	@GetMapping("/report")
	public String showReport(@PageableDefault(page=0,size =8,sort ="job",direction = Sort.Direction.ASC)Pageable pageable,@ModelAttribute("emp") Employee emp   , Model model) {
		
		Page<Employee> showAllEmployeeByPagination = employeeService.showAllEmployeeByPagination(pageable);
		
		model.addAttribute("page", showAllEmployeeByPagination);
		return "show_report";
	}
	
	
	@GetMapping("/register")
	public String employeeRegister(@ModelAttribute("emp") Employee employee) {
		
		return "employee_register";
	}
	
	

         @PostMapping("/register")
         public String employeeRegister(@ModelAttribute("emp") Employee employee,RedirectAttributes attr) {
	
        	 String registerEmployee = employeeService.registerEmployee(employee);
        	 
        attr.addFlashAttribute("resultMsg",registerEmployee);
        	 
	       return "redirect:report";
     }

          @GetMapping("/edit")
         public String employeeRegister(@ModelAttribute("emp") Employee emp,@RequestParam("no") int no) {
        	Employee employeeById = employeeService.fetchEmployeeById(no);
        	BeanUtils.copyProperties(employeeById,emp);
        	
        	return "employee_edit";
         }
         
          @PostMapping("/edit")
          public String updateEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attr) {
        	  String editEmployee = employeeService.editEmployee(emp);
        	  attr.addFlashAttribute("resultMsg",editEmployee);
        	  return "redirect:report";
        	  
          }
          
          
          @GetMapping("/delete")
          public String deleteEmployee(@RequestParam("no") int no,Model model) {
        	  
        	  String deleteEmployee = employeeService.deleteEmployee(no);
        	 model.addAttribute("resultMsg", deleteEmployee);
        	  
        	  return "forward:report";
        	
          }
          
          @PostMapping("/search")
          public String dynamicSearch(@ModelAttribute("emp") Employee emp,Model model ) {
        	   List<Employee> search = employeeService.dynamicSearchSearch(emp);
          	 model.addAttribute("empList", search);

        	  return "show_report";
          }
          
          
          
          
         
         
         
}
