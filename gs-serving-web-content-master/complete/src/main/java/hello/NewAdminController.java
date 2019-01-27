package hello;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.StudentsRepository;
import hello.UserRepository;
import hello.Students;
import hello.Users;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/new_admin")
public class NewAdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String reg, @RequestParam Integer department, @RequestParam String user
			, @RequestParam String password, @RequestParam String c_password) {
		
		Users u = new Users();
		if(password.equals(c_password)) {
			u.setUser_name(user);
			u.setPassword(password);
			u.setIs_admin(true);
			userRepository.save(u);
			
			ArrayList<Users> subList = (ArrayList<Users>)userRepository.findAll(); 
			int sub_id = 0;
			for(Users sub: subList) {
				int id = sub.getUser_id();
				if(id > sub_id) {
					sub_id = id;
				}
			}
			
			Students st = new Students();
			st.setName(name);
			st.setReg_no(reg);
			st.setUser_id(sub_id);
			st.setDepartment_id(department);
			
			studentsRepository.save(st);
			
			return  "<script type=\"text/javascript\">\r\n" + 
	 		"    window.location = \"http://localhost:8080/mainpage\";\r\n" + 
	 		"</script>";
			
		} else {
			return  "<script type=\"text/javascript\">\r\n" + 
			 		"    window.location = \"http://localhost:8080/new_admin\";\r\n" + 
			 		"</script>";
		}
		
		
	}

}
