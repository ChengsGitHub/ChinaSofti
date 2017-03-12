package com.icss.hr.photo.vo;

public class PhotoVo {

	private int photoId;

	private String photoPath;

	private int empId;

	public PhotoVo() {
		super();
	}

	public PhotoVo(String photoPath, int empId) {
		super();
		this.photoPath = photoPath;
		this.empId = empId;
	}

	public PhotoVo(int photoId, String photoPath, int empId) {
		super();
		this.photoId = photoId;
		this.photoPath = photoPath;
		this.empId = empId;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

}