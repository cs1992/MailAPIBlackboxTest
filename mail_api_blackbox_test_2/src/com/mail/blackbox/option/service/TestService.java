package com.mail.blackbox.option.service;

import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.blackbox.model.TestFault;

public interface TestService {
    
    ObjectMapper mapper = new ObjectMapper();
    
    HashSet<TestFault> startIntegrationTest();
}
