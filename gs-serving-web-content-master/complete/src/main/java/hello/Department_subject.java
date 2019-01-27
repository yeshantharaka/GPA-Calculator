package hello;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="department_subject")
public class Department_subject {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer ds_id;
    private Integer department_id;
    private Integer subject_id;
    
    
    public Department_subject(Integer department_id, Integer subject_id) {
		super();
		this.department_id = department_id;
		this.subject_id = subject_id;
	}

	public Integer getId() {
		return ds_id;
	}

	public void setId(Integer id) {
		this.ds_id = id;
	}
	
	public Integer getDepartmentId() {
		return department_id;
	}

	public void setDepartmentId(Integer did) {
		this.department_id = did;
	}
	
	public Integer getSubjectId() {
		return subject_id;
	}

	public void setSubjectId(Integer sid) {
		this.subject_id = sid;
	}

}
