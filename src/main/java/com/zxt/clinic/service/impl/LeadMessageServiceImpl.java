package com.zxt.clinic.service.impl;

import com.zxt.clinic.entity.LeadMessage;
import com.zxt.clinic.repository.LeadMessageRepository;
import com.zxt.clinic.service.LeadMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadMessageServiceImpl implements LeadMessageService {
    @Autowired
    private LeadMessageRepository leadMessageRepository;
    @Override
    public void save(LeadMessage leadMessage) {
        leadMessageRepository.save(leadMessage);
    }
}
