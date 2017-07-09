package com.mail.blackbox.option.util;

public class OptionConstanceValue {
	public static final String OPTION_TEST_CONTROLLER = "optionTest";

	public static enum OptionReadSet {
		ACTION_AFTER_DELETE("actionAfterDelete"), FIRST_FOLDER_SN("firstFolderSN"),

		FONT_NAME("fontName"), POPUP_READ("popupRead"),

		TIME_ZONE("timeZone"), UNREAD_MAIL_TYPE("unreadMailType"),

		USE_HTML5_NOTI("useHtml5Noti");

		public String param;

		OptionReadSet(String param) {
			this.param = param;
		}
	}
	
	public static enum OptionListSet{
		DIVIDE_MODE("divideMode"), FOLD_MULTIDEPTH("foldMultidepth"),
		
		HIDE_IMAGE_USE("hideImageUse");
		
		public String param;
		
		OptionListSet(String param){
			this.param = param;
		}
	}

}
