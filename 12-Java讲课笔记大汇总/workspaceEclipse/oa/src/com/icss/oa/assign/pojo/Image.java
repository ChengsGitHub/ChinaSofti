package com.icss.oa.assign.pojo;

public class Image {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column IMAGE.IMAGE_ID
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	private Integer imageId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column IMAGE.IMAGE_TYPE
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	private String imageType;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column IMAGE.IMAGE_REF_ID
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	private Integer imageRefId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column IMAGE.IMAGE_DATA
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	private byte[] imageData;

	public Image() {
		super();
	}

	public Image(String imageType, Integer imageRefId, byte[] imageData) {
		super();
		this.imageType = imageType;
		this.imageRefId = imageRefId;
		this.imageData = imageData;
	}
	
	public Image(Integer imageId, String imageType, Integer imageRefId,
			byte[] imageData) {
		super();
		this.imageId = imageId;
		this.imageType = imageType;
		this.imageRefId = imageRefId;
		this.imageData = imageData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column IMAGE.IMAGE_ID
	 * 
	 * @return the value of IMAGE.IMAGE_ID
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public Integer getImageId() {
		return imageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column IMAGE.IMAGE_ID
	 * 
	 * @param imageId
	 *            the value for IMAGE.IMAGE_ID
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column IMAGE.IMAGE_TYPE
	 * 
	 * @return the value of IMAGE.IMAGE_TYPE
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public String getImageType() {
		return imageType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column IMAGE.IMAGE_TYPE
	 * 
	 * @param imageType
	 *            the value for IMAGE.IMAGE_TYPE
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public void setImageType(String imageType) {
		this.imageType = imageType == null ? null : imageType.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column IMAGE.IMAGE_REF_ID
	 * 
	 * @return the value of IMAGE.IMAGE_REF_ID
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public Integer getImageRefId() {
		return imageRefId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column IMAGE.IMAGE_REF_ID
	 * 
	 * @param imageRefId
	 *            the value for IMAGE.IMAGE_REF_ID
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public void setImageRefId(Integer imageRefId) {
		this.imageRefId = imageRefId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column IMAGE.IMAGE_DATA
	 * 
	 * @return the value of IMAGE.IMAGE_DATA
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public byte[] getImageData() {
		return imageData;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column IMAGE.IMAGE_DATA
	 * 
	 * @param imageData
	 *            the value for IMAGE.IMAGE_DATA
	 * 
	 * @mbggenerated Tue Jul 01 11:27:27 CST 2014
	 */
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
}