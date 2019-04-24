package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.TreatmentRecords;
import com.zxt.clinic.repository.TreatmentRecordsRepository;
import com.zxt.clinic.service.TreatmentRecordsService;
import com.zxt.clinic.utils.ComputeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TreatmentRecordsServiceImpl implements TreatmentRecordsService{

    @Autowired
    private TreatmentRecordsRepository treatmentRecordsRepository;
    @Override
    public List<TreatmentRecords> findAllTreatmentRecords(int doctorId) {
        List<TreatmentRecords> treatmentRecords = treatmentRecordsRepository.findByDoctorId(doctorId);
        return treatmentRecords==null||treatmentRecords.isEmpty()?null:treatmentRecords;
    }

    @Override
    public List<TreatmentRecords> findTreatmentRecordsOfSomeDay(int doctorId, Date date) {
        List<TreatmentRecords> treatmentRecordsOfDoctor = findAllTreatmentRecords(doctorId);
        List<TreatmentRecords> treatmentRecordOfSomeDay = new ArrayList<>();
        if (treatmentRecordsOfDoctor==null) {
            return null;
        } else {
            for (TreatmentRecords treatmentRecords:treatmentRecordsOfDoctor){
                if (ComputeTool.isSameDate(date,treatmentRecords.getAppointmentTime())){
                    treatmentRecordOfSomeDay.add(treatmentRecords);
                }
            }
        }
        if (treatmentRecordOfSomeDay.isEmpty()) {
            return null;
        }
        return treatmentRecordOfSomeDay;
    }
}
