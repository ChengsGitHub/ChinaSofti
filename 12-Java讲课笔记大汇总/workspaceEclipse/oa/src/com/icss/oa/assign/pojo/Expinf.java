package com.icss.oa.assign.pojo;

import java.util.Arrays;

public class Expinf {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_ID
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private Integer expinfId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_NAME
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private String expinfName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_EDU
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private String expinfEdu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_SKI
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private String expinfSki;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_EXP
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private String expinfExp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_ACC
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private String expinfAcc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF_SAL
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private Integer expinfSal;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column EXPINF.EXPINF
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    private byte[] expinf;
    
    

    public Expinf() {
		super();
	}
    
    

	public Expinf(String expinfName, String expinfEdu,
			String expinfSki, String expinfExp, String expinfAcc,
			Integer expinfSal, byte[] expinf) {
		super();
		this.expinfName = expinfName;
		this.expinfEdu = expinfEdu;
		this.expinfSki = expinfSki;
		this.expinfExp = expinfExp;
		this.expinfAcc = expinfAcc;
		this.expinfSal = expinfSal;
		this.expinf = expinf;
	}
	

	public Expinf(Integer expinfId,String expinfName, String expinfEdu, String expinfSki,
			String expinfExp, String expinfAcc, Integer expinfSal, byte[] expinf) {
		super();
		this.expinfId=expinfId;
		this.expinfName = expinfName;
		this.expinfEdu = expinfEdu;
		this.expinfSki = expinfSki;
		this.expinfExp = expinfExp;
		this.expinfAcc = expinfAcc;
		this.expinfSal = expinfSal;
		this.expinf = expinf;
	}



	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_ID
     *
     * @return the value of EXPINF.EXPINF_ID
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public Integer getExpinfId() {
        return expinfId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_ID
     *
     * @param expinfId the value for EXPINF.EXPINF_ID
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfId(Integer expinfId) {
        this.expinfId = expinfId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_NAME
     *
     * @return the value of EXPINF.EXPINF_NAME
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public String getExpinfName() {
        return expinfName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_NAME
     *
     * @param expinfName the value for EXPINF.EXPINF_NAME
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfName(String expinfName) {
        this.expinfName = expinfName == null ? null : expinfName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_EDU
     *
     * @return the value of EXPINF.EXPINF_EDU
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public String getExpinfEdu() {
        return expinfEdu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_EDU
     *
     * @param expinfEdu the value for EXPINF.EXPINF_EDU
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfEdu(String expinfEdu) {
        this.expinfEdu = expinfEdu == null ? null : expinfEdu.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_SKI
     *
     * @return the value of EXPINF.EXPINF_SKI
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public String getExpinfSki() {
        return expinfSki;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_SKI
     *
     * @param expinfSki the value for EXPINF.EXPINF_SKI
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfSki(String expinfSki) {
        this.expinfSki = expinfSki == null ? null : expinfSki.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_EXP
     *
     * @return the value of EXPINF.EXPINF_EXP
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public String getExpinfExp() {
        return expinfExp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_EXP
     *
     * @param expinfExp the value for EXPINF.EXPINF_EXP
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfExp(String expinfExp) {
        this.expinfExp = expinfExp == null ? null : expinfExp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_ACC
     *
     * @return the value of EXPINF.EXPINF_ACC
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public String getExpinfAcc() {
        return expinfAcc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_ACC
     *
     * @param expinfAcc the value for EXPINF.EXPINF_ACC
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfAcc(String expinfAcc) {
        this.expinfAcc = expinfAcc == null ? null : expinfAcc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF_SAL
     *
     * @return the value of EXPINF.EXPINF_SAL
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public Integer getExpinfSal() {
        return expinfSal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF_SAL
     *
     * @param expinfSal the value for EXPINF.EXPINF_SAL
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinfSal(Integer expinfSal) {
        this.expinfSal = expinfSal;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column EXPINF.EXPINF
     *
     * @return the value of EXPINF.EXPINF
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public byte[] getExpinf() {
        return expinf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column EXPINF.EXPINF
     *
     * @param expinf the value for EXPINF.EXPINF
     *
     * @mbggenerated Thu Jun 26 12:27:49 CST 2014
     */
    public void setExpinf(byte[] expinf) {
        this.expinf = expinf;
    }



	@Override
	public String toString() {
		return "Expinf [expinfId=" + expinfId + ", expinfName=" + expinfName
				+ ", expinfEdu=" + expinfEdu + ", expinfSki=" + expinfSki
				+ ", expinfExp=" + expinfExp + ", expinfAcc=" + expinfAcc
				+ ", expinfSal=" + expinfSal + ", expinf=";
	}
        
}