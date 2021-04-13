package edu.udb.beautyapps;

import java.io.Serializable;

public class Appointment implements Serializable {

    private String creation_date;
    private String schedule_date;
    private Service service;

    public Appointment() {
    }

    public Appointment(String creation_date, String schedule_date, Service service) {
        this.creation_date = creation_date;
        this.schedule_date = schedule_date;
        this.service = service;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getSchedule_date() {
        return schedule_date;
    }

    public void setSchedule_date(String schedule_date) {
        this.schedule_date = schedule_date;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
