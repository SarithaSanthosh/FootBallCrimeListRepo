package com.saritha.football.services.footballcrimelistservices.model.crime;

public class OutcomeStatus{
    public String category;
    public String date;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "OutcomeStatus{" +
                "category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
