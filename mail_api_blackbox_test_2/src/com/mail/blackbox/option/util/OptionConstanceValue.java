package com.mail.blackbox.option.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.mail.blackbox.option.util.OptionSetConstanceValue.OptionListSetParam;

public class OptionConstanceValue {
	public static final String OPTION_TEST_CONTROLLER = "optionTest";
	


	public enum OptionAPI {
		READ_GET("/read/get"), READ_SET("/read/set"),

		LIST_GET("/list/get"), LIST_SET("/list/set"),

		WRITE_GET("/write/get"), WRITE_SET("/write/set"),

		SENDER_NAME_ADD("/senderName/add"), SENDER_NAME_DELETE("/senderName/delete"),

		USE_DESK_HOME_GET("/useDeskHome/get"), USE_DESK_HOME_SET("/useDeskHome/set"),

		TRASH_GET("/trash/get"), TRASH_SET("/trash/set"),

		FOLDER_LIST("/folder/list"), FOLDER_ADD("folder/add"),

		FOLDER_RENAME("/folder/rename"), FOLDER_DELETE("/folder/delete"),

		FOLDER_EMPTY("/folder/empty"), FOLDER_SET_READ("/folder/setRead"),

		FILTER_EXIST("/filter/exist"), //////////////////////////////////////////////

		SIGN_GET("/sign/get"), SIGN_SET("/sign/set"),

		QUICK_REPLY_GET("/quickReply/get"), QUICK_REPLY_SET("/quickReply/set"),

		QUICK_REPLY_ADD("/quickReply/add"), QUICK_REPLY_EDIT("/quickReply/edit"),

		QUICK_REPLY_DELETE("/quickReply/delete"),

		REMINDER_GET("/reminder/get"), REMINDER_SET("/reminder/set"),

		MOBILE_NOTI_GET("/mobileNoti/get"), MOBILE_NOTI_SET("/mobileNoti/set"),

		SPAM_GET("/spam/get"), SPAM_SET("/spam/set"),

		RECEIVE_GET("/receive_get"), RECEIVE_SET("/receive_set"),

		REJECT_ADDRESS_GET("/rejectAddress/get"), REJECT_ADDRESS_SET("/rejectAddress/set"),

		SHORT_CUT_GET("/shortCut/get"), SHORT_CUT_SET("/shortCut/set");

		public String api;

		private OptionAPI(String api) {
			this.api = "/json/option" + api + "?";
		}
	}

	public static enum OptionReason {
		FAIL("fail"), NOT_SET_VALUE_SET_DEFAULT("not set value, set default"),

		UNDEFINED_ERROR("undefined error"), SET_VALUE_SET_UNDEFINED_VALUE("set value, set undefined value"),

		SET_VALUE_SET_INVALIED_VALUE("set value, set invalid value"), SET_VALUE_VALID_BUT_NOT_DEFAULT(
				"set value valid, but not default value"),

		NOT_SET_VALUE_SET_UNDEFINED_VALUE("not set value, set undifined value");

		public String result;

		private OptionReason(String result) {
			this.result = result;
		}
	}

}
