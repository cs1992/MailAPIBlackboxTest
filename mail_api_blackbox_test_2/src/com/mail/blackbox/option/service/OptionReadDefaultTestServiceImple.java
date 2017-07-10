package com.mail.blackbox.option.service;

import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.Result;
import com.mail.blackbox.util.UtilFunction;

public class OptionReadDefaultTestServiceImple implements OptionDefaultTestService {

	private static OptionDefaultTestService optionReadDefaultTestServiceImple;

	static {
		optionReadDefaultTestServiceImple = new OptionReadDefaultTestServiceImple();
	}

	private OptionReadDefaultTestServiceImple() {
	}

	
	@Override
	public Param getCurrentOption(Enum requestParam) {
		
//		String request = 
		
		
		return null;
	}

	@Override
	public boolean setOption(Param requestParam) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Result diffOption(Param originOption, Param afterOption) {
		// TODO Auto-generated method stub
		return null;
	}

}
