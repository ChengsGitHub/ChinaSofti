package com.icss.hr.photo.vo;

import java.io.File;

public class PhotoVo {

	private Integer photoId;

	private Integer empId;// 员工编号

	private File photo;// 文件本身

	private String photoPath; // 文件新名称

	private String photoFileName;// 文件名称

	private String photoContentType;// 文件MIME类型

	public PhotoVo() {
		super();
	}

	public PhotoVo(Integer empId, String photoPath) {
		super();
		this.empId = empId;
		this.photoPath = photoPath;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

}