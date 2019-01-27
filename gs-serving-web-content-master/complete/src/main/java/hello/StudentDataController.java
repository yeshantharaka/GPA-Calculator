package hello;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.collections.List;

@Controller
@RequestMapping(path="/student_data")
public class StudentDataController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private GuestRepository guestRepository;
	
	
	@GetMapping(path = "/student")
	public @ResponseBody Optional<Students> getStudent() {
		// This returns a JSON or XML with the users
		ArrayList<Guest> gl = (ArrayList<Guest>)guestRepository.findAll(); 
		int s_id=0;
		for(Guest g: gl) {
			s_id = g.getStudent_id();
		}
		
		return studentsRepository.findById(s_id);
	}
	
	@GetMapping(path = "/department")
	public @ResponseBody Optional<Departments> getDepartment() {
		// This returns a JSON or XML with the users
		ArrayList<Guest> gl = (ArrayList<Guest>)guestRepository.findAll(); 
		int s_id=0;
		for(Guest g: gl) {
			s_id = g.getStudent_id();
		}
		
		int dp_id=0;
		//Optional<Students> st = new Optional<Students>();
		ArrayList<Students> st = (ArrayList<Students>)studentsRepository.findAll(); 
		for(Students s: st) {
			if(s.getStudent_id()==s_id) {
				dp_id = s.getDepartment_id();
			}
		}
		
		
		return departmentRepository.findById(dp_id);
	}
	
	
}
