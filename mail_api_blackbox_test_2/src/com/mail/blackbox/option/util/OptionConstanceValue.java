package com.mail.blackbox.option.util;

public class OptionConstanceValue {
	public static final String OPTION_TEST_CONTROLLER = "optionTest";

	public static enum OptionReadSetParam {
		ACTION_AFTER_DELETE("actionAfterDelete"), FIRST_FOLDER_SN("firstFolderSN"),

		FONT_NAME("fontName"), POPUP_READ("popupRead"),

		TIME_ZONE("timeZone"), UNREAD_MAIL_TYPE("unreadMailType"),

		USE_HTML5_NOTI("useHtml5Noti");

		public String param;

		OptionReadSetParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionListSetParam {
		DIVIDE_MODE("divideMode"), FOLD_MULTIDEPTH("foldMultidepth"),

		HIDE_IMAGE_USE("hideImageUse"), LIST_FONT_SIZE("listFontSize"),

		LIST_NUM("listNum"), OMIT_SUBJECT("omitSubject"),

		OPEN_FIRST_MAIL("openFirstMail"), PAGING_MODE("pagingMode"),

		PREVIEW("preview"), SHOW_RCPT("showRcpt"),

		USE_CONVERSATION_VIEW("useConversationView"), USE_MULTIDEPTH("useMultidepth"),

		USE_TO_TAG("useToTag"), USE_VIP_MAIL_BOX("useVipMailBox");

		public String param;

		OptionListSetParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionWriteSetParm{
		EDIT_TYPE(""), EDIT_FONT(""),
		
		EDIT_FONT_SIZE("");
		
		public String param;
		
		OptionWriteSetParm(String param){
			this.param = param;
		}
	}

}
