package hello;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class grades {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer grade_id;
    private String grade;
    private float points;
    
    public Integer getId() {
		return grade_id;
	}

	public void setId(Integer id) {
		this.grade_id = id;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(Integer point) {
		this.points = point;
	}

}
