package io.msgserver.model;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.msgserver.BasicUtil;
import io.msgserver.activemq.MessageSender;
import io.msgserver.model.MessageResponse;
import io.msgserver.model.MsgStatus;
import io.msgserver.model.ServiceMessage;

@Service("MessageService")
public class MessageServiceImpl implements MessageService {

    static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageRepository msgRepository;

    @Override
    public void sendMsg(ServiceMessage msg) {
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        msg.setMsgId(BasicUtil.getUniqueId());
        msg.setStatus(MsgStatus.CREATED);
        msgRepository.putMsg(msg);
        LOG.info("Application : sending msg request {}", msg);
        messageSender.sendMessage(msg);
        LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void updateOrder(MessageResponse response) {
        ServiceMessage msg = msgRepository.getMsg(response.getMsgId());
        if(response.getReturnCode()==200){
        	msg.setStatus(MsgStatus.CONFIRMED);
        }else if(response.getReturnCode()==300){
            msg.setStatus(MsgStatus.FAILED);
        }else{
            msg.setStatus(MsgStatus.PENDING);
        }
        msgRepository.putMsg(msg);
    }

    public Map<String, ServiceMessage> getAllMessages(){
        return msgRepository.getAllMsgs();
    }

}