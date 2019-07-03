package com.mapper.pojo;

import java.util.List;

public class AgeRange {
	private String upperLimit;
	private String lowerLimit;
	private String desc;
	private List<FlagSet> flagSets;
	public String getUpperLimit() {
		return upperLimit;
	}
	public String getLowerLimit() {
		return lowerLimit;
	}
	public String getDesc() {
		return desc;
	}
	public List<FlagSet> getFlagSets() {
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
	public void setFlagSets(List<FlagSet> flagSets) {
		this.flagSets = flagSets;
	}
	
}
