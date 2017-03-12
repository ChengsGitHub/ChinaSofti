package com.icss.oa.bus.pojo;

import java.util.Arrays;

public class Bus {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUS.BUS_ID
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    private Integer busId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUS.BUS_TYPE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    private String busType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUS.BUS_LICENSE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    private String busLicense;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUS.BUS_STATE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    private Integer busState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUS.BUS_PHOTO
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    private byte[] busPhoto;

    
    public Bus() {
		super();
	}

	public Bus(Integer busId, String busType, String busLicense,
			Integer busState, byte[] busPhoto) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.busLicense = busLicense;
		this.busState = busState;
		this.busPhoto = busPhoto;
	}

	public Bus(String busType, String busLicense, Integer busState,
			byte[] busPhoto) {
		super();
		this.busType = busType;
		this.busLicense = busLicense;
		this.busState = busState;
		this.busPhoto = busPhoto;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUS.BUS_ID
     *
     * @return the value of BUS.BUS_ID
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public Integer getBusId() {
        return busId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUS.BUS_ID
     *
     * @param busId the value for BUS.BUS_ID
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUS.BUS_TYPE
     *
     * @return the value of BUS.BUS_TYPE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public String getBusType() {
        return busType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUS.BUS_TYPE
     *
     * @param busType the value for BUS.BUS_TYPE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUS.BUS_LICENSE
     *
     * @return the value of BUS.BUS_LICENSE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public String getBusLicense() {
        return busLicense;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUS.BUS_LICENSE
     *
     * @param busLicense the value for BUS.BUS_LICENSE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public void setBusLicense(String busLicense) {
        this.busLicense = busLicense == null ? null : busLicense.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUS.BUS_STATE
     *
     * @return the value of BUS.BUS_STATE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public Integer getBusState() {
        return busState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUS.BUS_STATE
     *
     * @param busState the value for BUS.BUS_STATE
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public void setBusState(Integer busState) {
        this.busState = busState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUS.BUS_PHOTO
     *
     * @return the value of BUS.BUS_PHOTO
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public byte[] getBusPhoto() {
        return busPhoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUS.BUS_PHOTO
     *
     * @param busPhoto the value for BUS.BUS_PHOTO
     *
     * @mbggenerated Wed Jul 16 11:18:08 CST 2014
     */
    public void setBusPhoto(byte[] busPhoto) {
        this.busPhoto = busPhoto;
    }

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busType=" + busType + ", busLicense="
				+ busLicense + ", busState=" + busState + ", busPhoto="
				+ Arrays.toString(busPhoto) + "]";
	}
    
    
}