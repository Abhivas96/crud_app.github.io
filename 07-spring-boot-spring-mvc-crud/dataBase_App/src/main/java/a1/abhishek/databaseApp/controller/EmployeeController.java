package a1.abhishek.databaseApp.controller;

import a1.abhishek.databaseApp.entity.Employee;
import a1.abhishek.databaseApp.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", employees);

		return "employees/list-employees";
	}

	@GetMapping("/addEmployee")
	public String showAddEmployeeFrom(Model theModel){
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employees/add-employee";
	}

	@GetMapping("/updateForm")
	public String showUpdateForm(@RequestParam("employeeId") int theId, Model theModel){
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employees/add-employee";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		employeeService.save(theEmployee);
		return "redirect:/employees/list";
	}
}









