package com.mapper.pojo;

public class FlagSet {
	private String compataror;
	private String conValue;
	private String siValue;
	
	public void setCompataror(String compataror) {
		for(int i=0;i<compataror.length();i++) {
			char o= compataror.charAt(i);
			if(o == '<' || o== '>' || o== '=') {
				if(this.compataror == null)
					this.compataror = Character.toString(o);
				else
					this.compataror += Character.toString(o);
			}
		}
		
	}
	public void setConValue(String conValue) {
		for(int i=0;i<conValue.length();i++) {
		char o= conValue.charAt(i);
			if(o != '<' && o!= '>' && o!= '=') {
				if(this.conValue == null)
					this.conValue = Character.toString(o);
				else
					this.conValue += Character.toString(o);
			}
		}
	}
	public void setSiValue(String siValue) {
		for(int i=0;i<siValue.length();i++) {
		char o= siValue.charAt(i);
			if(o != '<' && o!= '>' && o!= '=') {
				if(this.siValue == null)
					this.siValue = Character.toString(o);
				else
					this.siValue += Character.toString(o);
			}
		}
	}
	public String getCompataror() {
		return compataror;
	}
	public String getConValue() {
		return conValue;
	}
	public String getSiValue() {
		return siValue;
	}
	
}
