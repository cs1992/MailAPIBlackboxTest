package com.mail.blackbox.option.service;

import com.mail.blackbox.model.Param;
import com.mail.blackbox.model.Result;

public interface OptionDefaultTestService {
	Param getCurrentOption(Enum requestParam);
	
	boolean setOption(Param requestParam);
	
	Result diffOption(Param originOption, Param afterOption);
}
