package com.zxt.clinic.repository;

import com.zxt.clinic.entity.DisciplineRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRecordRepository extends JpaRepository<DisciplineRecord,Integer>{
    public DisciplineRecord findByAppointmentId(Integer appointmentId);
}
