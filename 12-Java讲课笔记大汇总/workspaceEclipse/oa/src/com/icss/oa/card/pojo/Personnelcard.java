package com.icss.oa.card.pojo;

public class Personnelcard {

    private Integer cardId;

    private String cardName;

    private Integer groupId;

    private String sex;

    private String deptname;

    private String position;

    private String mobilephone;

    private String telephone;

    private String mailaddr;

    private String addr;
    
    private Integer empId;
    
    private Integer jobId;
    
    private Integer deptId;
   
    public Personnelcard() {
		super();
	}
    
	public Personnelcard(String cardName, Integer groupId, String sex,
			String deptname, String position, String mobilephone,
			String telephone, String mailaddr, String addr, Integer empId,
			Integer jobId, Integer deptId) {
		super();
		this.cardName = cardName;
		this.groupId = groupId;
		this.sex = sex;
		this.deptname = deptname;
		this.position = position;
		this.mobilephone = mobilephone;
		this.telephone = telephone;
		this.mailaddr = mailaddr;
		this.addr = addr;
		this.empId = empId;
		this.jobId = jobId;
		this.deptId = deptId;
	}

	public Personnelcard(Integer cardId, String cardName, Integer groupId,
			String sex, String deptname, String position, String mobilephone,
			String telephone, String mailaddr, String addr, Integer empId, 
			Integer jobId, Integer deptId) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.groupId = groupId;
		this.sex = sex;
		this.deptname = deptname;
		this.position = position;
		this.mobilephone = mobilephone;
		this.telephone = telephone;
		this.mailaddr = mailaddr;
		this.addr = addr;
		this.empId = empId;
		this.jobId = jobId;
		this.deptId = deptId;
	}

	public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getMailaddr() {
        return mailaddr;
    }

    public void setMailaddr(String mailaddr) {
        this.mailaddr = mailaddr == null ? null : mailaddr.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }
    
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
    
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }


	@Override
	public String toString() {
		return "Personnelcard [cardId=" + cardId + ", cardName=" + cardName
				+ ", groupId=" + groupId + ", sex=" + sex + ", deptname="
				+ deptname + ", position=" + position + ", mobilephone="
				+ mobilephone + ", telephone=" + telephone + ", mailaddr="
				+ mailaddr + ", addr=" + addr + ", groupId=" + groupId + ", jobId=" 
				+ jobId + ", deptId=" + deptId + "]";
	}
    
    
}