package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/grade")
public class GradesController {
	@Autowired
	private GradesRepository gradesRepository;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<grades> getAllUsers() {
		// This returns a JSON or XML with the users
		return gradesRepository.findAll();
	}

}
