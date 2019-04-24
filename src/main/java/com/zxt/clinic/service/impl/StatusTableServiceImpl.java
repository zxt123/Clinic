package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.*;
import com.zxt.clinic.repository.*;
import com.zxt.clinic.service.AppointmentService;
import com.zxt.clinic.service.StatusTableService;
import com.zxt.clinic.utils.ComputeTool;
import com.zxt.clinic.web.conversion.Convert;
import com.zxt.clinic.web.model.StatusMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatusTableServiceImpl implements StatusTableService{

    @Autowired
    private StatusTableRepository statusTableRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private DisciplineRecordRepository disciplineRecordRepository;
    @Autowired
    private TreatmentRecordsRepository treatmentRecordsRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentService appointmentService;
    @Override
    public List<StatusTable> findStatusTableOfDoctor(int statusId, int doctorId) {
        return statusTableRepository.findByStatusIdAndDoctorId(statusId,doctorId);
    }

    @Override
    public List<StatusTable> findStatusTable(int statusId) {
        return statusTableRepository.findByStatusId(statusId);
    }

    @Override
    public boolean startTreat(int statusTableId, Date startTime) {
        if (statusTableId <=0||startTime==null){
            return false;
        }else{
            StatusTable statusTable = statusTableRepository.findOne(statusTableId);
            if (statusTable == null){
                return false;
            }
            statusTable.setStartTime(startTime);
            statusTable.setStatusId(StatusMap.treating);
            statusTableRepository.save(statusTable);
            return true;
        }
    }

    @Override
    public boolean endTreat(int statusTableId, Date endTime) {
        if (statusTableId <=0||endTime==null){
            return false;
        }else{
            StatusTable statusTable = statusTableRepository.findOne(statusTableId);
            if (statusTable == null){
                return false;
            }
            statusTable.setEndTime(endTime);
            statusTable.setStatusId(StatusMap.over);
            Date startTime = statusTable.getStartTime();
            int treatmentId = statusTable.getTreatmentId();
            Treatment treatment = treatmentRepository.findOne(treatmentId);
            if (treatment == null){
                return false;
            }
            int price = Integer.parseInt(treatment.getPrice());
            double cost = (double) (price* (ComputeTool.getDistanceTime(startTime,endTime)));
            statusTable.setCost(cost);
            statusTableRepository.save(statusTable);
            return true;
        }
    }

    @Override
    public boolean convert2DisciplineRecord() {
        Date date = new Date();
        Date today = ComputeTool.convert2Zero(date);
        if (today==null){
            return false;
        }
        List<StatusTable> statusTables = statusTableRepository.findByAppointmentTimeBefore(today);
        if (statusTables == null||statusTables.isEmpty()){
            return true;
        }
        for (StatusTable statusTable:statusTables){
            if (!statusTable.getStatusId().equals(StatusMap.pay)){
                DisciplineRecord disciplineRecord = Convert.toDisciplineRecord(statusTable);
                disciplineRecordRepository.save(disciplineRecord);
            }
            statusTableRepository.delete(statusTable);
        }
        return true;
    }

    @Override
    public List<Appointment> convert2StatusTable() {
        Date today = new Date();
        List<Appointment> appointments = appointmentService.findAppointmentOfSomeDaySQL(today);
        if (appointments==null||appointments.isEmpty()){
            return null;
        }
        for (Appointment appointment:appointments){
            if (statusTableRepository.findByAppointmentId(appointment.getId())==null&&disciplineRecordRepository.findByAppointmentId(appointment.getId())==null&& treatmentRecordsRepository.findByAppointmentId(appointment.getId())==null){
                StatusTable statusTable = Convert.toStatusTable(appointment);
                statusTable.setStatusId(StatusMap.coming);
                statusTableRepository.save(statusTable);
            }
        }
        return appointments;
    }

    @Override
    public StatusTable findStatusTableById(Integer id) {
        return statusTableRepository.findOne(id);
    }

    @Override
    public void save(StatusTable statusTable) {
        statusTableRepository.save(statusTable);
    }

    @Override
    public boolean endTreat(StatusTable statusTable) {
        TreatmentRecords treatmentRecords = Convert.toTreatmentRecords(statusTable);
        if (treatmentRecords==null) {
            return false;
        }
        treatmentRecordsRepository.save(treatmentRecords);
        statusTable.setStatusId(StatusMap.pay);
        statusTableRepository.save(statusTable);
        return true;
    }
}
