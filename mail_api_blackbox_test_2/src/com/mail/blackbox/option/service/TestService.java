package com.mail.blackbox.option.service;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.blackbox.model.TestFault;

public interface TestService {
    
    ObjectMapper mapper = new ObjectMapper();
    
    List<TestFault> startIntegrationTest();
}
