package hello;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.websocket.Session;

//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

@Service
public class SubjectInsertService {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private SubjectsRepository subjectsRepository;
	@Autowired
	private DepartmentSubjectRepository departmentSubRepo;
	
	public void insertSubject(String subject_code, String subject_name, Integer credits, boolean is_core
			, boolean is_technical, boolean is_general, Integer department) {

		Subjects n = new Subjects();
		n.setSubject_code(subject_code);
		n.setSubject_name(subject_name);
		n.setCredits(credits);
		n.setIs_core(is_core);
		n.setIs_technical(is_technical);
		n.setIs_general(is_general);
		subjectsRepository.save(n);
		
		ArrayList<Subjects> subList = (ArrayList<Subjects>)subjectsRepository.findAll(); 
		int sub_id = 0;
		for(Subjects sub: subList) {
			int id = sub.getSubject_id();
			if(id > sub_id) {
				sub_id = id;
			}
		}
		//System.out.println(sub_id);
		Department_subject dept_sub = new Department_subject(department,sub_id);

		departmentSubRepo.save(dept_sub);
	}
}
