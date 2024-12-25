package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service
public class EmployeeMgmServiceImpl implements IEmployeeMgmService{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Page<Employee> showAllEmployeeByPagination(Pageable pageable) {

		 return repo.findAll(pageable);
		
		
	}

	@Override
	public String registerEmployee(Employee employee) {
		int idval=repo.save(employee).getEmpno();
		
		return "Employee is registered with id value::"+idval;
	}

	@Override
	public Employee fetchEmployeeById(int id) {
		return repo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id"));
	}

	@Override
	public String editEmployee(Employee emp) {
            
		repo.save(emp);
		
		return "employee is updated succesfully"+emp.getEmpno();
	}

	@Override
	public String deleteEmployee(int id) {

		repo.deleteById(id);
		
		return "Employee deleted succesfully"+id;
	}

	@Override
	public List<Employee> dynamicSearchSearch(Employee employee) {

		if(employee.getEname().equals(""))
			employee.setEname(null);
		if(employee.getJob().equals(""))
			employee.setJob(null);	
		
		Example<Employee> example=Example.of(employee);
		
	    return repo.findAll(example);
		
		
		
	}

}
