package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hello.Users;
import hello.UserRepository;

@Controller
@RequestMapping(path="/mainpage1")
public class MainpageController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GuestRepository guestRepo;
	@Autowired 
	private StudentsRepository studentRepo;
	
	
	@PostMapping(path = "")
    public String greeting(@RequestParam String user, @RequestParam String pass) {
		
		ArrayList<Users> subList = (ArrayList<Users>)userRepository.findAll(); 
		Boolean is_user = false;
		for(Users sub: subList) {
			String pw = sub.getPassword();
			String name = sub.getUser_name();
			int userId = sub.getUser_id();
			int student_id = 0;
			if(name.equals(user) && pw.equals(pass)) {
				is_user = true;
				ArrayList<Students> studentList = (ArrayList<Students>)studentRepo.findAll(); 
				for(Students stu: studentList) {
					if(stu.getUser_id() == userId) {
						student_id = stu.getStudent_id();
						break;
					}
				}
				Guest guest = new Guest();
				guest.setStudent_id(student_id);
				guestRepo.save(guest);
				break;
			}
		}
		if(is_user == true) {
			//return "mainpage";
			return "redirect:/mainpage";
		} else {
			return "redirect:/";
					
		}
		
        
        
    }
}
