package com.icss.oa.message.pojo;

import java.util.Date;

public class Message {
  
    private Integer messageId;

    private Integer sendId;

    private Integer recevId;

    private String messageCont;

    private Date sendTime;

    private Integer mSend;

    private Integer mRead;

  
    
    public Message(Integer sendId, Integer recevId, String messageCont,
			Date sendTime) {
		super();
		this.sendId = sendId;
		this.recevId = recevId;
		this.messageCont = messageCont;
		this.sendTime = sendTime;
	}

	public Message() {
		super();
	}

	public Message(Integer sendId, Integer recevId, String messageCont) {
		super();
		this.sendId = sendId;
		this.recevId = recevId;
		this.messageCont = messageCont;
	}

	public Message(Integer messageId, Integer sendId, Integer recevId,
			String messageCont, Date sendTime, Integer mSend, Integer mRead) {
		super();
		this.messageId = messageId;
		this.sendId = sendId;	
		this.recevId = recevId;
		this.messageCont = messageCont;
		this.sendTime = sendTime;
		this.mSend = mSend;
		this.mRead = mRead;
	}


	public Message(Integer sendId, Integer recevId, String messageCont,
			Date sendTime, Integer mSend, Integer mRead) {
		super();
		this.sendId = sendId;
		this.recevId = recevId;
		this.messageCont = messageCont;
		this.sendTime = sendTime;
		this.mSend = mSend;
		this.mRead = mRead;
	}

	public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getRecevId() {
        return recevId;
    }

    public void setRecevId(Integer recevId) {
        this.recevId = recevId;
    }

    public String getMessageCont() {
        return messageCont;
    }

    public void setMessageCont(String messageCont) {
        this.messageCont = messageCont == null ? null : messageCont.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getmSend() {
        return mSend;
    }

    public void setmSend(Integer mSend) {
        this.mSend = mSend;
    }

    public Integer getmRead() {
        return mRead;
    }

    public void setmRead(Integer mRead) {
        this.mRead = mRead;
    }

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", sendId=" + sendId
				+ ", recevId=" + recevId + ", messageCont=" + messageCont
				+ ", sendTime=" + sendTime + ", mSend=" + mSend + ", mRead="
				+ mRead + "]";
	}
}