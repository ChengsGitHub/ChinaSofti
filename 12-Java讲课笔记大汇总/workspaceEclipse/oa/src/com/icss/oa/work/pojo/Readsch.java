package com.icss.oa.work.pojo;

public class Readsch {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column READSCH.READSCH_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    private Integer readschId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column READSCH.READSCH_EMPID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    private Integer readschEmpid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column READSCH.READSCH
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    private Integer readsch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column READSCH.READSCHEMP_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    private Integer readschempId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column READSCH.READSCHDEPT_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    private Integer readschdeptId;
    
    

    public Readsch() {
		super();
	}
    
    

	public Readsch(Integer readschEmpid, Integer readsch, Integer readschempId2,
			Integer readschdeptId) {
		super();
		this.readschEmpid = readschEmpid;
		this.readsch = readsch;
		readschempId = readschempId2;
		this.readschdeptId = readschdeptId;
	}

	

	public Readsch(Integer readschId, Integer readschEmpid, Integer readsch,
			Integer readschempId2, Integer readschdeptId) {
		super();
		this.readschId = readschId;
		this.readschEmpid = readschEmpid;
		this.readsch = readsch;
		readschempId = readschempId2;
		this.readschdeptId = readschdeptId;
	}



	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column READSCH.READSCH_ID
     *
     * @return the value of READSCH.READSCH_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public Integer getReadschId() {
        return readschId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column READSCH.READSCH_ID
     *
     * @param readschId the value for READSCH.READSCH_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public void setReadschId(Integer readschId) {
        this.readschId = readschId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column READSCH.READSCH_EMPID
     *
     * @return the value of READSCH.READSCH_EMPID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public Integer getReadschEmpid() {
        return readschEmpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column READSCH.READSCH_EMPID
     *
     * @param readschEmpid the value for READSCH.READSCH_EMPID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public void setReadschEmpid(Integer readschEmpid) {
        this.readschEmpid = readschEmpid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column READSCH.READSCH
     *
     * @return the value of READSCH.READSCH
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public Integer getReadsch() {
        return readsch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column READSCH.READSCH
     *
     * @param readsch the value for READSCH.READSCH
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public void setReadsch(Integer readsch) {
        this.readsch = readsch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column READSCH.READSCHEMP_ID
     *
     * @return the value of READSCH.READSCHEMP_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public Integer getReadschempId() {
        return readschempId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column READSCH.READSCHEMP_ID
     *
     * @param readschempId the value for READSCH.READSCHEMP_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public void setReadschempId(Integer readschempId) {
        this.readschempId = readschempId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column READSCH.READSCHDEPT_ID
     *
     * @return the value of READSCH.READSCHDEPT_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public Integer getReadschdeptId() {
        return readschdeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column READSCH.READSCHDEPT_ID
     *
     * @param readschdeptId the value for READSCH.READSCHDEPT_ID
     *
     * @mbggenerated Wed Jul 16 16:32:53 CST 2014
     */
    public void setReadschdeptId(Integer readschdeptId) {
        this.readschdeptId = readschdeptId;
    }



	@Override
	public String toString() {
		return "Readsch [readschId=" + readschId + ", readschEmpid="
				+ readschEmpid + ", readsch=" + readsch + ", readschempId="
				+ readschempId + ", readschdeptId=" + readschdeptId + "]";
	}
    
    
}