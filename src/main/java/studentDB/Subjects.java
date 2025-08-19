package studentDB;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subjects {
	
	@Id
	private int id;
	private int english;
	private int maths;
	private int science;
	@ManyToMany(mappedBy = "subjects")
	private List<Student> student;
	
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", english=" + english + ", maths=" + maths + ", science=" + science + "]";
	}
}
