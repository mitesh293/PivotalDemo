package com.mapper.pojo;

import java.util.List;

public class NVSSpecificSet {

	private String age;
	private String height;
	private List<NVSAgeRange> ageRanges;
	
	public String getAge() {
		return age;
	}
	public String getHeight() {
		return height;
	}
	public List<NVSAgeRange> getAgeRanges() {
		return ageRanges;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public void setAgeRanges(List<NVSAgeRange> ageRanges) {
		this.ageRanges = ageRanges;
	}
	
	
}
