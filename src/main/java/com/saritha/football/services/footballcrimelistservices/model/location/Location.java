package com.saritha.football.services.footballcrimelistservices.model.location;

public class Location {

    public int status;
    public Result result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "status=" + status +
                ", result=" + result +
                '}';
    }
}
