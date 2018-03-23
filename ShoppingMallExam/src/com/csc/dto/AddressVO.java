package com.csc.dto;

public class AddressVO {
	 private String zipNum;
     private String sido;
     private String gugun;
     private String dong;
     private String zip_code;
     private String bunji;
	public String getzipNum() {
		return zipNum;
	}
	public void setzipNum(String zipNum) {
		this.zipNum = zipNum;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}    
}
