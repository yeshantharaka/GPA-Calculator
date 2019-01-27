package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Results {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer result_id;
    private Integer student_id;
    private Integer subject_id;
    private Integer grade_id;
    
    
	public Integer getResult_id() {
		return result_id;
	}
	public void setResult_id(Integer result_id) {
		this.result_id = result_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}
	public Integer getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Integer grade_id) {
		this.grade_id = grade_id;
	}
    

}
