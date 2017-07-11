package com.mail.blackbox.option.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mail.blackbox.action.Action;
import com.mail.blackbox.model.Result;
import com.mail.blackbox.option.service.OptionListDefaultTestServiceImpl;
import com.mail.blackbox.util.ConstanceValue;

public class OptionTestAction implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	List<Result> result = OptionListDefaultTestServiceImpl.getOptionListDefaultTestServiceImpl().startTest();
	
	System.out.println(result.size());
	
	return ConstanceValue.OPTION_TEST_RESULT;
    }

}
