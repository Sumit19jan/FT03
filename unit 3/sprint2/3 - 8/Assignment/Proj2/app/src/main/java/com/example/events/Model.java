package com.example.events;

import java.io.Serializable;

public class Model implements Serializable {

    private String title;
    private String desc;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
    private String price;

    public Model(String title, String desc, String startDate, String endDate, String startTime, String endTime, String price) {
        this.title = title;
        this.desc = desc;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPrice() {
        return price;
    }
}
