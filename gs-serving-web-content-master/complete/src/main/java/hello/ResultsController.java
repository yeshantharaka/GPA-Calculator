package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/results")
public class ResultsController {
	
	@Autowired
	private ResultsRepository resultsRepository;
	
	@Autowired
	private GuestRepository guestRepository;
	
	@GetMapping(path = "")
    public String greeting(@RequestParam Integer subject, @RequestParam Integer grade) {
		
		ArrayList<Guest> gl = (ArrayList<Guest>)guestRepository.findAll(); 
		int s_id=0;
		for(Guest g: gl) {
			s_id = g.getStudent_id();
		}
		
		Results rt = new Results();
		rt.setStudent_id(s_id);
		rt.setSubject_id(subject);
		rt.setGrade_id(grade);
		resultsRepository.save(rt);
		
		return "add_results";
	}
}


