package com.icss.oa.meeting.pojo;

public class Meetingroom {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETINGROOM.ROOM_ID
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    private Integer roomId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETINGROOM.ROOM_NAME
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    private String roomName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETINGROOM.ROOM_ADDR
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    private String roomAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETINGROOM.ROOM_AMOUNT
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    private Integer roomAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETINGROOM.ROOM_AIR
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    private Integer roomAir;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MEETINGROOM.ROOM_STATE
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    private Integer roomState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETINGROOM.ROOM_ID
     *
     * @return the value of MEETINGROOM.ROOM_ID
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    
    public Meetingroom() {
		super();
	}

	public Meetingroom(Integer roomId, String roomName, String roomAddr,
			Integer roomAmount, Integer roomAir, Integer roomState) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomAddr = roomAddr;
		this.roomAmount = roomAmount;
		this.roomAir = roomAir;
		this.roomState = roomState;
	}

    
    public Meetingroom(String roomName, String roomAddr, Integer roomAmount,
    		Integer roomAir, Integer roomState) {
		super();
		this.roomName = roomName;
		this.roomAddr = roomAddr;
		this.roomAmount = roomAmount;
		this.roomAir = roomAir;
		this.roomState = roomState;
	}

	public Integer getRoomId() {
        return roomId;
    }

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETINGROOM.ROOM_ID
     *
     * @param roomId the value for MEETINGROOM.ROOM_ID
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETINGROOM.ROOM_NAME
     *
     * @return the value of MEETINGROOM.ROOM_NAME
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETINGROOM.ROOM_NAME
     *
     * @param roomName the value for MEETINGROOM.ROOM_NAME
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETINGROOM.ROOM_ADDR
     *
     * @return the value of MEETINGROOM.ROOM_ADDR
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public String getRoomAddr() {
        return roomAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETINGROOM.ROOM_ADDR
     *
     * @param roomAddr the value for MEETINGROOM.ROOM_ADDR
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public void setRoomAddr(String roomAddr) {
        this.roomAddr = roomAddr == null ? null : roomAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETINGROOM.ROOM_AMOUNT
     *
     * @return the value of MEETINGROOM.ROOM_AMOUNT
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public Integer getRoomAmount() {
        return roomAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETINGROOM.ROOM_AMOUNT
     *
     * @param roomAmount the value for MEETINGROOM.ROOM_AMOUNT
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETINGROOM.ROOM_AIR
     *
     * @return the value of MEETINGROOM.ROOM_AIR
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public Integer getRoomAir() {
        return roomAir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETINGROOM.ROOM_AIR
     *
     * @param roomAir the value for MEETINGROOM.ROOM_AIR
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public void setRoomAir(Integer roomAir) {
        this.roomAir = roomAir;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MEETINGROOM.ROOM_STATE
     *
     * @return the value of MEETINGROOM.ROOM_STATE
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public Integer getRoomState() {
        return roomState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MEETINGROOM.ROOM_STATE
     *
     * @param roomState the value for MEETINGROOM.ROOM_STATE
     *
     * @mbggenerated Thu Jun 26 10:37:12 CST 2014
     */
    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

	@Override
	public String toString() {
		return "Meetingroom [roomId=" + roomId + ", roomName=" + roomName
				+ ", roomAddr=" + roomAddr + ", roomAmount=" + roomAmount
				+ ", roomAir=" + roomAir + ", roomState=" + roomState + "]";
	}

    
    
}