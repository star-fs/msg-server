package io.msgserver.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ServiceMessage implements Serializable {

    private String msgId;

    private String msg;

    private MsgStatus status;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MsgStatus getStatus() {
        return status;
    }

    public void setStatus(MsgStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((msgId == null) ? 0 : msgId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServiceMessage other = (ServiceMessage) obj;
        if (msgId == null) {
            if (other.msgId != null)
                return false;
        } else if (!msgId.equals(other.msgId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ServiceMessage [msgId=" + msgId + ", status=" + status + "]";
    }

}