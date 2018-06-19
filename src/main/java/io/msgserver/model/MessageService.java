package io.msgserver.model;

import java.util.Map;


public interface MessageService {
    public void sendMsg(ServiceMessage msg);
    public void updateOrder(MessageResponse response);
    public Map<String, ServiceMessage> getAllMessages();
}
