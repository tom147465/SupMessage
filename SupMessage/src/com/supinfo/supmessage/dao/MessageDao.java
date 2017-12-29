package com.supinfo.supmessage.dao;

import java.util.List;

import com.supinfo.supmessage.entity.Message;

public interface MessageDao {

	public void addMessage(Message message);

	public List<Message> showhistroy(String sname, String dname);

	public Long CountMessage();

}
