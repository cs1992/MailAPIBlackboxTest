package com.mail.blackbox.option.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

import com.mail.blackbox.action.Action;
import com.mail.blackbox.model.TestFault;
import com.mail.blackbox.option.service.OptionListDefaultTestServiceImpl;
import com.mail.blackbox.util.ConstanceValue;

public class OptionTestAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	List<TestFault> result = OptionListDefaultTestServiceImpl.getOptionListDefaultTestServiceImpl().startIntegrationTest();
//	
//	System.out.println("result size : " + result.size());
//	System.out.println(Arrays.toString(result.toArray()));
	
	request.setAttribute(ConstanceValue.OPTION_TEST_RESULT_VALUE, result);
	
	return ConstanceValue.TEST_RESULT;
    }

}
