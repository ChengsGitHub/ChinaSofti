package com.icss.hr.photo.pojo;

import com.icss.hr.emp.pojo.Emp;

public class Photo {

	private int photoId;
	
	private String photoPath;
	
	private Emp emp;

	public Photo() {
		super();
	}

	public Photo(String photoPath, Emp emp) {
		super();
		this.photoPath = photoPath;
		this.emp = emp;
	}

	public Photo(int photoId, String photoPath, Emp emp) {
		super();
		this.photoId = photoId;
		this.photoPath = photoPath;
		this.emp = emp;
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

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", photoPath=" + photoPath
				+ ", emp=" + emp + "]";
	}
		
}