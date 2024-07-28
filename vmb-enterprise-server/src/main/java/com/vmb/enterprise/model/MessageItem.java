package com.vmb.enterprise.model;
public record MessageItem (
     String uuid,
     String message,
     String time){

    @Override
    public String toString() {
        return "MessageItem{" +
                "uuid='" + uuid + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
