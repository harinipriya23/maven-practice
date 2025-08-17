package main;

import jakarta.persistence.Embeddable;

@Embeddable
public class Subjects {
	
	private int english;
	private int maths;
	private int science;
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
	@Override
	public String toString() {
		return "Subjects [english=" + english + ", maths=" + maths + ", science=" + science + "]";
	}
}
