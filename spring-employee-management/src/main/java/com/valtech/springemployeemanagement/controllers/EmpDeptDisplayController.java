package com.valtech.springemployeemanagement.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.model.DepartmentModel;
import com.valtech.springemployeemanagement.model.EmployeeModel;
import com.valtech.springemployeemanagement.service.EmployeeDepartmentService;

@Controller
@RequestMapping(path = "/display")
public class EmpDeptDisplayController {
	@Autowired
	EmployeeDepartmentService employeeDepartmentService;
	private List<Department> departments;
	private DepartmentModel departmentModel;
	private int currentId;

	@GetMapping("/new")
	public String newEmployee(Model model) {
		model.addAttribute("employee", new EmployeeModel());
		return "display/new";
	}

	@GetMapping(path = "/edit")
	public String editEmployee(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("employee", new EmployeeModel(employeeDepartmentService.getEmployee(id)));
		return "display/edit";

	}

	@GetMapping(path = "/delete")
	public String deleteEmployee(@RequestParam("id") Integer id, Model model) {
		employeeDepartmentService.deleteEmployee(id);
		return "redirect:list";
	}

	@PostMapping(path = "/save", params = "cancel")
	public String cancelEmployee(Model model) {

		departments = employeeDepartmentService.getAllDepartments();
		if (!departments.isEmpty()) {
			Department department = departments.get(employeeDepartmentService.getFirstId() - 1);
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
		}

		model.addAttribute("employees", employeeDepartmentService.getAllEmployees().stream()
				.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		return "display/list";
	}

	@PostMapping(path = "/save", params = "submit")
	public String saveEmployee(@ModelAttribute EmployeeModel employeeModel, @RequestParam("submit") String submit,
			Model model) {

		if (submit.equals("Create")) {
			employeeDepartmentService.createEmployee(employeeModel.getEmployee());
		}
		departments = employeeDepartmentService.getAllDepartments();
		if (!departments.isEmpty()) {
			Department department = departments.get(employeeDepartmentService.getFirstId() - 1);
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
		}
		model.addAttribute("employees", employeeDepartmentService.getAllEmployees().stream()
				.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		return "display/list";
	}

	@GetMapping("/list")
	public String listEmployee(Model model) {
		model.addAttribute("employees", employeeDepartmentService.getAllEmployee().stream()
				.map(employees -> new EmployeeModel(employees)).collect(Collectors.toList()));
		
		
		Department department = employeeDepartmentService.getDepartmentById(employeeDepartmentService.getFirstId());
		departmentModel = new DepartmentModel(department);
//		DepartmentModel departmentModel = new DepartmentModel(
//				employeeDepartmentService.getDepartmentById(employeeDepartmentService.getFirstId()));
		model.addAttribute("department", departmentModel);
		return "display/list";

	}

	@PostMapping(path = "/list", params = "submit")
	public String listEmployee(@RequestParam("submit") String submit, Model model) {
		currentId = departmentModel.getDeptId();
		//currentId = departmentModel != null ? departmentModel.getDeptId() : null;

		if (submit.equals("Last")) {
			Department department = employeeDepartmentService.getDepartmentById(employeeDepartmentService.getLastId());
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
			model.addAttribute("employees",
					employeeDepartmentService.getAllEmployeesByDepartment(departmentModel.getDeptId()).stream()
							.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));

		} else if (submit.equals("Previous")) {
			if (currentId != employeeDepartmentService.getFirstId()) {
				Department department = employeeDepartmentService
						.getDepartmentById(employeeDepartmentService.getPreviousId(currentId));
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees",
						employeeDepartmentService.getAllEmployeesByDepartment(departmentModel.getDeptId()).stream()
								.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));

			} else {
				Department department = employeeDepartmentService
						.getDepartmentById(employeeDepartmentService.getLastId());
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees",
						employeeDepartmentService.getAllEmployeesByDepartment(departmentModel.getDeptId()).stream()
								.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
			}
		} else if (submit.equals("Next")) {
			if (currentId != employeeDepartmentService.getLastId()) {
				Department department = employeeDepartmentService
						.getDepartmentById(employeeDepartmentService.getNextId(currentId));
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees",
						employeeDepartmentService.getAllEmployeesByDepartment(departmentModel.getDeptId()).stream()
								.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));

			} else {
				Department department = employeeDepartmentService
						.getDepartmentById(employeeDepartmentService.getFirstId());
				departmentModel = new DepartmentModel(department);
				model.addAttribute("department", departmentModel);
				model.addAttribute("employees",
						employeeDepartmentService.getAllEmployeesByDepartment(departmentModel.getDeptId()).stream()
								.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
			}
		} else if (submit.equals("First")) {
			Department department = employeeDepartmentService.getDepartmentById(employeeDepartmentService.getFirstId());
			departmentModel = new DepartmentModel(department);
			model.addAttribute("department", departmentModel);
			model.addAttribute("employees",
					employeeDepartmentService.getAllEmployeesByDepartment(departmentModel.getDeptId()).stream()
							.map(employee -> new EmployeeModel(employee)).collect(Collectors.toList()));
		}
		return "display/list";
	}
}
