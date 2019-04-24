package com.zxt.clinic.web.conversion;

import com.zxt.clinic.entity.*;
import com.zxt.clinic.web.model.UserInformation;

public class Convert {
    public static UserInformation toUserInformation(User user) {
        UserInformation userInformation = new UserInformation();
        userInformation.setAge(user.getAge());
        userInformation.setDeviceId(user.getDeviceId());
        userInformation.setFavoriteDoctorId(user.getFavoriteDoctorId());
        userInformation.setIcon(user.getIcon());
        userInformation.setId(user.getId());
        userInformation.setName(user.getName());
        userInformation.setPassword(user.getPassword());
        userInformation.setUsername(user.getUsername());
        userInformation.setPhoneNumber(user.getPhoneNumber());
        userInformation.setSex(user.getSex());
        return userInformation;
    }

    public static DisciplineRecord toDisciplineRecord(StatusTable statusTable) {
        DisciplineRecord disciplineRecord = new DisciplineRecord();
        disciplineRecord.setAppointmentId(statusTable.getAppointmentId());
        disciplineRecord.setAppointmentTime(statusTable.getAppointmentTime());
        disciplineRecord.setCost(statusTable.getCost());
        disciplineRecord.setUserId(statusTable.getUserId());
        disciplineRecord.setName(statusTable.getName());
        disciplineRecord.setEmail(statusTable.getEmail());
        disciplineRecord.setPhoneNumber(statusTable.getPhoneNumber());
        disciplineRecord.setDoctorId(statusTable.getDoctorId());
        disciplineRecord.setTreatmentId(statusTable.getTreatmentId());
        disciplineRecord.setQuestions(statusTable.getQuestions());
        disciplineRecord.setTime(statusTable.getTime());
        disciplineRecord.setStartTime(statusTable.getStartTime());
        disciplineRecord.setEndTime(statusTable.getEndTime());
        disciplineRecord.setStatusId(statusTable.getStatusId());
        return disciplineRecord;
    }

    public static TreatmentRecords toTreatmentRecords(StatusTable statusTable) {
        TreatmentRecords treatmentRecords = new TreatmentRecords();
        treatmentRecords.setAppointmentId(statusTable.getAppointmentId());
        treatmentRecords.setAppointmentTime(statusTable.getAppointmentTime());
        treatmentRecords.setCost(statusTable.getCost());
        treatmentRecords.setUserId(statusTable.getUserId());
        treatmentRecords.setName(statusTable.getName());
        treatmentRecords.setEmail(statusTable.getEmail());
        treatmentRecords.setPhoneNumber(statusTable.getPhoneNumber());
        treatmentRecords.setDoctorId(statusTable.getDoctorId());
        treatmentRecords.setTreatmentId(statusTable.getTreatmentId());
        treatmentRecords.setQuestions(statusTable.getQuestions());
        treatmentRecords.setTime(statusTable.getTime());
        treatmentRecords.setStartTime(statusTable.getStartTime());
        treatmentRecords.setEndTime(statusTable.getEndTime());
        treatmentRecords.setPayMethod(statusTable.getPayMethod());
        treatmentRecords.setAdvice(statusTable.getAdvice());
        treatmentRecords.setComment(statusTable.getComment());
        treatmentRecords.setScore(statusTable.getScore());
        return treatmentRecords;
    }
    public static StatusTable toStatusTable(Appointment appointment){
        StatusTable statusTable = new StatusTable();
        statusTable.setAppointmentId(appointment.getId());
        statusTable.setUserId(appointment.getUserId());
        statusTable.setName(appointment.getName());
        statusTable.setPhoneNumber(appointment.getPhoneNumber());
        statusTable.setEmail(appointment.getEmail());
        statusTable.setDoctorId(appointment.getDoctorId());
        statusTable.setTreatmentId(appointment.getTreatmentId());
        statusTable.setAppointmentTime(appointment.getAppointmentTime());
        statusTable.setTime(appointment.getTime());
        statusTable.setQuestions(appointment.getQuestions());
        return statusTable;
    }
}