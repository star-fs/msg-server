package io.msgserver.model;

import java.util.Map;

import io.msgserver.model.ServiceMessage;

public interface MessageRepository {
    public void putMsg(ServiceMessage msg);
    public ServiceMessage getMsg(String msgId);
    public Map<String, ServiceMessage> getAllMsgs();
}