package com.mapper.pojo;

import java.util.List;


public class NVSAgeRange {
	private String upperLimit;
	private String lowerLimit;
	private String desc;
	private List<NVSFlagSet> flagSets;
	
	public String getUpperLimit() {
		return upperLimit;
	}
	public String getLowerLimit() {
		return lowerLimit;
	}
	public String getDesc() {
		return desc;
	}
	public List<NVSFlagSet> getFlagSets() {
		return flagSets;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setFlagSets(List<NVSFlagSet> flagSets) {
		this.flagSets = flagSets;
	}
	
}
