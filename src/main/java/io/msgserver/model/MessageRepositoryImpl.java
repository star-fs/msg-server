package io.msgserver.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

import io.msgserver.model.ServiceMessage;

@Service("MessageRepository")
public class MessageRepositoryImpl implements MessageRepository{

    private final Map<String, ServiceMessage> msgs = new ConcurrentHashMap<String, ServiceMessage>();

	public void putMsg(ServiceMessage msg) {
		msgs.put(msg.getMsgId(), msg);
	}

	@Override
	public ServiceMessage getMsg(String msgId) {
		return msgs.get(msgId);
	}

	@Override
	public Map<String, ServiceMessage> getAllMsgs() {
		return msgs;
	}
}