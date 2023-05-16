package com.vmb.enterprise.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageItem {

    private String uuid;
    private String message;
    private String time;

    @Override
    public String toString() {
        return "MessageItem{" +
                "uuid='" + uuid + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
