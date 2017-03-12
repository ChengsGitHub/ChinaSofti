package com.icss.oa.card.pojo;

public class Card {

    private Integer groupId;

    private String grouName;
    
    public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	private Integer empId;
      
    public Card() {
		super();
	}

	public Card(Integer groupId, String grouName,Integer empId) {
		super();
		this.groupId = groupId;
		this.grouName = grouName;
		this.empId = empId;
	}

	public Card(String grouName,Integer empId) {
		super();
		this.grouName = grouName;
		this.empId = empId;
	}

	public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGrouName() {
        return grouName;
    }

    public void setGrouName(String grouName) {
        this.grouName = grouName == null ? null : grouName.trim();
    }

	@Override
	public String toString() {
		return "Card [groupId=" + groupId + ", grouName=" + grouName + "]";
	}
}