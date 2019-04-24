package com.zxt.clinic.service;

import com.zxt.clinic.entity.Appointment;
import com.zxt.clinic.entity.StatusTable;

import java.util.Date;
import java.util.List;

public interface StatusTableService {
    public List<StatusTable> findStatusTableOfDoctor(int statusId,int doctorId);
    public List<StatusTable> findStatusTable(int statusId);
    public boolean startTreat(int statusTableId, Date startTime);
    public boolean endTreat(int statusTableId,Date endTime);
    public boolean convert2DisciplineRecord();
    public List<Appointment> convert2StatusTable();
    public StatusTable findStatusTableById(Integer id);
    public void save(StatusTable statusTable);
    public boolean endTreat(StatusTable statusTable);
}
