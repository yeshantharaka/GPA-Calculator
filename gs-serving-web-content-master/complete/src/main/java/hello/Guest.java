package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guest {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int student_id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	
}
