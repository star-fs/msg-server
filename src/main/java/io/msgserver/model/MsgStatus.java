package io.msgserver.model;

public enum MsgStatus {

    CREATED("Created"),
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    FAILED("Failed");

    private String status;

    private MsgStatus(final String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString(){
        return this.status;
    }


    public String getName(){
        return this.name();
    }
}