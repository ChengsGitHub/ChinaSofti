package com.icss.oa.bus.pojo;


import java.util.Date;



public class Busorder {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUSORDER.BORDER_ID
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    private Integer borderId;

   /**
    * This field was generated by MyBatis Generator.
    * This field corresponds to the database column BUSORDER.EMP_ID
    */
    private Integer empId;
    

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUSORDER.BORDER_TYPE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    private String borderType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUSORDER.USE_DATE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    private Date useDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUSORDER.USE_REASON
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    private String useReason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column BUSORDER.APRO_STATE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    private Integer aproState;

    public Busorder() {
		super();
	}

	
	public Busorder(Integer empId, String borderType, Date useDate,
			String useReason, Integer aproState) {
		super();
		this.empId = empId;
		this.borderType = borderType;
		this.useDate = useDate;
		this.useReason = useReason;
		this.aproState = aproState;
	}


	public Busorder(Integer borderId, Integer empId, String borderType,
			Date useDate, String useReason, Integer aproState) {
		super();
		this.borderId = borderId;
		this.empId = empId;
		this.borderType = borderType;
		this.useDate = useDate;
		this.useReason = useReason;
		this.aproState = aproState;
	}


	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUSORDER.BORDER_ID
     *
     * @return the value of BUSORDER.BORDER_ID
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public Integer getBorderId() {
        return borderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUSORDER.BORDER_ID
     *
     * @param borderId the value for BUSORDER.BORDER_ID
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public void setBorderId(Integer borderId) {
        this.borderId = borderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUSORDER.BORDER_TYPE
     *
     * @return the value of BUSORDER.BORDER_TYPE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public String getBorderType() {
        return borderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUSORDER.BORDER_TYPE
     *
     * @param borderType the value for BUSORDER.BORDER_TYPE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public void setBorderType(String borderType) {
        this.borderType = borderType == null ? null : borderType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUSORDER.USE_DATE
     *
     * @return the value of BUSORDER.USE_DATE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public Date getUseDate() {
        return useDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUSORDER.USE_DATE
     *
     * @param useDate the value for BUSORDER.USE_DATE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUSORDER.USE_REASON
     *
     * @return the value of BUSORDER.USE_REASON
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public String getUseReason() {
        return useReason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUSORDER.USE_REASON
     *
     * @param useReason the value for BUSORDER.USE_REASON
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public void setUseReason(String useReason) {
        this.useReason = useReason == null ? null : useReason.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column BUSORDER.APRO_STATE
     *
     * @return the value of BUSORDER.APRO_STATE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public Integer getAproState() {
        return aproState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column BUSORDER.APRO_STATE
     *
     * @param aproState the value for BUSORDER.APRO_STATE
     *
     * @mbggenerated Thu Jul 17 15:59:21 CST 2014
     */
    public void setAproState(Integer aproState) {
        this.aproState = aproState;
    }


	@Override
	public String toString() {
		return "Busorder [borderId=" + borderId + ", empId=" + empId
				+ ", borderType=" + borderType + ", useDate=" + useDate
				+ ", useReason=" + useReason + ", aproState=" + aproState + "]";
	}


    
    
}