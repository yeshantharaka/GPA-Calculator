package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import hello.Departments;
import hello.DepartmentRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/field_register")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam Integer core, @RequestParam Integer tech, @RequestParam Integer gen) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Departments n = new Departments();
		n.setName(name);
		n.setCoreCredits(core);
		n.setTechnicalCredits(tech);
		n.setGeneralCredits(gen);
		departmentRepository.save(n);
//		return "Saved";
	     return  "<script type=\"text/javascript\">\r\n" + 
	     		"    window.location = \"http://localhost:8080/field_register\";\r\n" + 
	     		"</script>";

	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Departments> getAllUsers() {
		// This returns a JSON or XML with the users
		return departmentRepository.findAll();
	}
}
