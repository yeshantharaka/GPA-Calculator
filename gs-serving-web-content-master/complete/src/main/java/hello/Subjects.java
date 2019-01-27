package hello;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Subjects {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer subject_id;
    private String subject_code;
    private String subject_name;
    private Integer credits;
    private boolean is_core;
    private boolean is_technical;
    private boolean is_general;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="subject_id")
    private Department_subject department_subject;

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

	public String getSubject_code() {
		return subject_code;
	}

	public void setSubject_code(String subject_code) {
		this.subject_code = subject_code;
	}

	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}

	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public boolean isIs_core() {
		return is_core;
	}

	public void setIs_core(boolean is_core) {
		this.is_core = is_core;
	}

	public boolean isIs_technical() {
		return is_technical;
	}

	public void setIs_technical(boolean is_technical) {
		this.is_technical = is_technical;
	}

	public boolean isIs_general() {
		return is_general;
	}

	public void setIs_general(boolean is_general) {
		this.is_general = is_general;
	}
    

//	public void setDepartment(Integer dep_id) {
//		this.department_subject.setDepartmentId(dep_id);
//		this.department_subject.setSubjectId(this.subject_id);
//	}
	
}
