package com.saritha.football.services.footballcrimelistservices.model.crime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Crime {
    public String category;
    public String location_type;
    public String context;
    public OutcomeStatus outcome_status;
    public String persistent_id;
    public int id;
    public String location_subtype;
    public String month;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public OutcomeStatus getOutcome_status() {
        return outcome_status;
    }

    public void setOutcome_status(OutcomeStatus outcome_status) {
        this.outcome_status = outcome_status;
    }

    public String getPersistent_id() {
        return persistent_id;
    }

    public void setPersistent_id(String persistent_id) {
        this.persistent_id = persistent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation_subtype() {
        return location_subtype;
    }

    public void setLocation_subtype(String location_subtype) {
        this.location_subtype = location_subtype;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "category='" + category + '\'' +
                ", location_type='" + location_type + '\'' +
                ", context='" + context + '\'' +
                ", outcome_status=" + outcome_status +
                ", persistent_id='" + persistent_id + '\'' +
                ", id=" + id +
                ", location_subtype='" + location_subtype + '\'' +
                ", month='" + month + '\'' +
                '}';
    }
}
