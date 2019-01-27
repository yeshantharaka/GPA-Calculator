package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.Subjects;
import hello.SubjectsRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/subject_register")
public class SubjectController {
	@Autowired
	private SubjectsRepository subjectsRepository;
	
	@Autowired
	private SubjectInsertService subjectInsertService;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String subject_code
			, @RequestParam String subject_name, @RequestParam Integer credits, @RequestParam(value = "is_core", required=false, defaultValue = "false") Boolean is_core
			, @RequestParam Integer department, @RequestParam(value = "is_technical", required=false, defaultValue = "false") Boolean is_technical, @RequestParam(value = "is_general", required=false, defaultValue = "false") Boolean is_general) {
		
		subjectInsertService.insertSubject(subject_code, subject_name, credits, is_core, is_technical, is_general, department);

	     return  "<script type=\"text/javascript\">\r\n" + 
	     		"    window.location = \"http://localhost:8080/subject_register\";\r\n" + 
	     		"</script>";

	}
	
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Subjects> getAllUsers() {
		// This returns a JSON or XML with the users
		return subjectsRepository.findAll();
	}
	
}
