package com.wes.myssm.bean;

import java.util.List;

import com.wes.myssm.entity.Appointment;

public class AppointmentWrapper {
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
