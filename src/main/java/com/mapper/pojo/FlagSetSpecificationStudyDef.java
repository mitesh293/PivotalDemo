package com.mapper.pojo;

import java.util.List;


public class FlagSetSpecificationStudyDef {

	private String age;
	private String height;
	private List<AgeRange> ageRanges;
	public String getAge() {
		return age;
	}
	public String getHeight() {
		return height;
	}
	public List<AgeRange> getAgeRanges() {
		return ageRanges;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public void setAgeRanges(List<AgeRange> ageRanges) {
		this.ageRanges = ageRanges;
	}
	
}
