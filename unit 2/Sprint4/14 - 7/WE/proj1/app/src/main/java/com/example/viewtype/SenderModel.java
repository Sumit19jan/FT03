package com.example.viewtype;

public class SenderModel extends BaseModel{
    private String senderMessage;

    public SenderModel(String message) {
        this.senderMessage = message;
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    @Override
    int getViewType() {
        return 0;
    }
}
