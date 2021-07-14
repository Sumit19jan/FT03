package com.example.viewtype;

public class ReceiverModel extends BaseModel{
    private String receiverMessage;

    public ReceiverModel(String message) {
        this.receiverMessage = message;
    }

    public String getReceiverMessage() {
        return receiverMessage;
    }

    @Override
    int getViewType() {
        return 1;
    }
}
