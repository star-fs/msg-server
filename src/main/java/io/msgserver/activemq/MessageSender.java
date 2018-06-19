package io.msgserver.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import io.msgserver.model.ServiceMessage;

@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final ServiceMessage msg) {
        jmsTemplate.send(new MessageCreator(){
        	@Override
            public Message createMessage(Session session) throws JMSException{
        		ObjectMessage objectMessage = session.createObjectMessage(msg);
                return objectMessage;
            }
        });
    }
}