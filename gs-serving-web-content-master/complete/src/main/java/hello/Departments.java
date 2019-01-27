package hello;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Departments {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer department_id;
    private String department_name;
    private Integer core_credits;
    private Integer technical_credits;
    private Integer general_credits;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Department_subject department_subject;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="department_id")
    private Students students;

	public Integer getId() {
		return department_id;
	}

	public void setId(Integer id) {
		this.department_id = id;
	}

	public String getName() {
		return department_name;
	}

	public void setName(String name) {
		this.department_name = name;
	}

	public Integer getCoreCredits() {
		return core_credits;
	}

	public void setCoreCredits(Integer core) {
		this.core_credits = core;
	}
	
	public Integer getTechnicalCredits() {
		return technical_credits;
	}

	public void setTechnicalCredits(Integer tech) {
		this.technical_credits = tech;
	}
	
	public Integer getGeneralCredits() {
		return general_credits;
	}

	public void setGeneralCredits(Integer gen) {
		this.general_credits = gen;
	}

}
