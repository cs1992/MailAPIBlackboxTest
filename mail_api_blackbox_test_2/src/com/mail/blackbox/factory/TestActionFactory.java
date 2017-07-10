package com.mail.blackbox.factory;

import com.mail.blackbox.action.Action;
import com.mail.blackbox.option.action.OptionTestAction;

public class TestActionFactory {
	private static Action optionTestAction;
	
	static {
		optionTestAction = new OptionTestAction();
	}

	public static Action getOptionTestAction() {
		return optionTestAction;
	}
	
	
}
