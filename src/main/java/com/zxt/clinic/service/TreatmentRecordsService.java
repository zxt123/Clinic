package com.zxt.clinic.service;

import com.zxt.clinic.entity.TreatmentRecords;

import java.util.Date;
import java.util.List;

public interface TreatmentRecordsService {
    public List<TreatmentRecords> findAllTreatmentRecords(int doctorId);
    public List<TreatmentRecords> findTreatmentRecordsOfSomeDay(int doctorId, Date date);
}
