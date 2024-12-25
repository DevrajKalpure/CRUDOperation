package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.Employee;

public interface IEmployeeMgmService {

	
	public Page<Employee> showAllEmployeeByPagination(Pageable pageable );
	
	public String registerEmployee(Employee employee);

    public Employee fetchEmployeeById(int id);
    
    public String editEmployee(Employee emp);
    
    public String deleteEmployee(int id);
    
    public List<Employee> dynamicSearchSearch(Employee employee);

}

