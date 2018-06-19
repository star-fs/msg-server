package io.msgserver.api;

import io.msgserver.activemq.MessageSender;
import io.msgserver.model.MessageRepository;
import io.msgserver.model.ServiceMessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class MsgApiController implements MsgApi {

    private static final Logger log = LoggerFactory.getLogger(MsgApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    MessageSender messageSender;

    @Autowired
    MessageRepository msgRepository;

    @org.springframework.beans.factory.annotation.Autowired
    public MsgApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ServiceMessage> addMsg(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "msg", required = true) String msg) {

    	String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

        	try {
        		ServiceMessage msgObj = new ServiceMessage();
        		msgObj.setMsg(msg);

        		msgRepository.putMsg(msgObj);
        		return new ResponseEntity<ServiceMessage>(
        				objectMapper.readValue("{  \"id\" : 0,  \"message\" : \"message\"}",
        				ServiceMessage.class
        		), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceMessage>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteMsg(@ApiParam(value = "message id to delete",required=true) @PathVariable("msgId") Long msgId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ServiceMessage> getMsgById(@ApiParam(value = "message ID",required=true) @PathVariable("msgId") Long msgId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ServiceMessage>(objectMapper.readValue("{  \"id\" : 0,  \"message\" : \"message\"}", ServiceMessage.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ServiceMessage>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ServiceMessage>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateMsg(@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "msg", required = true) String msg,@ApiParam(value = "message ID",required=true) @PathVariable("msgId") Long msgId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
