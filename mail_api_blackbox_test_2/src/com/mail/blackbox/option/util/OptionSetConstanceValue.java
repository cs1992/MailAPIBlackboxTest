package com.mail.blackbox.option.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mail.blackbox.util.ConstanceValue;
import com.mail.blackbox.util.UtilFunction;
import com.mail.blackbox.util.ConstanceValue.TestType;

import javafx.util.converter.TimeStringConverter;

public class OptionSetConstanceValue {


	public static enum OptionReadSetParam{
		ACTION_AFTER_DELETE("actionAfterDelete", "0"), FIRST_FOLDER_SN("firstFolderSN", "0"),

		FONT_NAME("fontName", "Dotum"), POPUP_READ("popupRead", "false");

		public String param;
		public String defValue;
		private final ArrayList<String> ACTION_AFTER_DELETE_LIST = new ArrayList<>(Arrays.asList("0", "1", "2"));
		private final ArrayList<String> FIRST_FOLDER_SN_LIST = new ArrayList<>();
		private final ArrayList<String> FONT_NAME_LIST = new ArrayList<>(Arrays.asList("dotum", "Nanumgothic"));

		OptionReadSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
		
		public ArrayList<String> getTestValues(OptionReadSetParam param, TestType testType){
			ArrayList<String> list = new ArrayList<>();
			boolean isInvalid = false;
			if (testType == TestType.INVALID_TYPE) {
				isInvalid = true;
			}
			
			switch(param){
			case ACTION_AFTER_DELETE:
				if(isInvalid){
					
				} else {
					
				}
				break;
			case FIRST_FOLDER_SN:
				if(isInvalid){
					
				} else {
					
				}
				break;
			case FONT_NAME:
				if(isInvalid){
					
				} else {
					
				}
				break;
			case POPUP_READ:
				if(isInvalid){
					
				} else {
					
				}
				break;
				default:
				
				
			}
			
			return list;
		}
	}

	public static enum OptionListSetParam {
		DIVIDE_MODE("divideMode", "L"),

		HIDE_IMAGE_USE("hideImageUse", "false"), LIST_FONT_SIZE("listFontSize", "9"),

		LIST_NUM("listNum", "30"), OMIT_SUBJECT("omitSubject", "false"),

		OPEN_FIRST_MAIL("openFirstMail", "false"), PAGING_MODE("pagingMode", "N"),

		PREVIEW("preview", "true"), SHOW_RCPT("showRcpt", "true"),

		USE_MULTIDEPTH("useMultidepth", "false"),

		USE_TO_TAG("useToTag", "true"), USE_VIP_MAIL_BOX("useVipMailBox", "true");

		public String param;
		public String defValue;
		private final ArrayList<String> LIST_NUM_LIST = new ArrayList<String>(
				Arrays.asList("8", "9", "10", "11", "12"));
		private final ArrayList<String> DIVIDE_MODE_LIST = new ArrayList<String>(Arrays.asList("L", "H", "V"));
		private final ArrayList<String> LIST_FONT_SIZE_LIST = new ArrayList<String>(
				Arrays.asList("5", "10", "15", "20", "25", "30", "35", "40", "45", "60", "80"));
		private final ArrayList<String> PAGING_MODE_LIST = new ArrayList<String>(Arrays.asList("N", "S"));

		OptionListSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}

		public ArrayList<String> getTestValues(OptionListSetParam param, TestType testType) {
			ArrayList<String> list = new ArrayList<>();
			boolean isInvalid = false;
			if (testType == TestType.INVALID_TYPE) {
				isInvalid = true;
			}

			switch (param) {
			case OPEN_FIRST_MAIL:
			case PREVIEW:
			case OMIT_SUBJECT:
			case USE_TO_TAG:
			case SHOW_RCPT:
			case HIDE_IMAGE_USE:
			case USE_VIP_MAIL_BOX:
			case USE_MULTIDEPTH:
				if (isInvalid) {
					list = new ArrayList<>(UtilFunction.getBoolTestCase());
				} else {
					list = ConstanceValue.BOOLEAN_VALUE;
				}
				break;
			case DIVIDE_MODE:
				if (isInvalid) {
					list = new ArrayList<>(UtilFunction.getAlpabetTestCase());
				} else {
					list = DIVIDE_MODE_LIST;
				}
				break;
			case LIST_NUM:
				if (isInvalid) {
					list = new ArrayList<>(
							UtilFunction.getNumberBetweenTestCase(LIST_NUM_LIST));
				} else {
					list = LIST_NUM_LIST;
				}
				break;
			case LIST_FONT_SIZE:
				if (isInvalid) {
					list = new ArrayList<>(UtilFunction.getNumberBetweenTestCase(LIST_FONT_SIZE_LIST));
				} else {
					list = LIST_FONT_SIZE_LIST;
				}
				break;
			case PAGING_MODE:
				if (isInvalid) {
					list = new ArrayList<>(UtilFunction.getAlpabetTestCase());
				} else {
					list = PAGING_MODE_LIST;
				}
				break;
			default:

			}

			return list;
		}
	}

	public static enum OptionWriteSetParm {
		EDIT_TYPE("editType", "H2"), EDIT_FONT("editFont", "Gulim"),

		EDIT_FONT_SIZE("editFontSize", "normal"), USE_STANDARD_HEIGHT("useStandardHeight", "true"),

		POPUP_WRITE("popupWrite", "false"), SELECT_FROM_NAME("selectedFromName", ""),

		AUTO_SEND_MAIL("autoSavePeriod", "60000"), SAVE_SEND_MAIL("saveSentMail", "true"),

		SEND_SEPARATELY("sendSeparately", "false"), SEND_MYSELF("sendMyself", "0"),

		SEND_AFTER_REVIEW("sendAfterReview", "2"), DELAY_DELIVERY("delayDelivery", "false"),

		DELAY_TIME("delayTime", "30"),

		REPLY_TO("replyTo", ""), INCLUDE_ORG_MSG_WHEN_REPLY("includeOrgMsgWhenReply", "true");

		public String param;
		public String defValue;

		OptionWriteSetParm(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}

	public static enum OptionSenderNameParam {
		FROM_NAME("fromName"), DELETE_KEY("deleteKey");

		public String fromName;

		OptionSenderNameParam(String fromName) {
			this.fromName = fromName;
		}
	}

	public static enum OptionDeskHomeSetParam {
		USE_HESK_HOME("useDeskhome", "false");

		public String param;
		public String defValue;

		OptionDeskHomeSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}

	public static enum OptionTrashSetParam {

		USE_TRASH("useTrash", "true"), TRASH_PERIOD("trashPeriod", "0"),

		SAVE_PERIOD("savePeriod", "0");

		public String param;
		public String defValue;

		OptionTrashSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}

	public static enum OptionSignSetParam {
		DEFAULT_SIGN("defaultSign", "0"), DEFAULT_SIGN_FOR_REFW("defaultSignForRefw", "0"),

		ACCOUNT("account", "ncs");

		public String param;
		public String defValue;

		OptionSignSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}

	public static enum OptionFolderEmptyParam {
		FOLDER_SN("folderSN"), DELETE_TYPE("deleteType");

		public String param;

		OptionFolderEmptyParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionFolderAddParam {
		FOLDER_NAME("folderName");

		public String param;

		OptionFolderAddParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionFolderSetReadParam {
		FOLDER_SN("folderSN"), STATUS("status");

		public String param;

		OptionFolderSetReadParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionFolderRenameParam {
		FOLDER_SN("folderSN"), FOLDER_NAME("folderName"),

		PARENT_FOLDER_SN("parentFolderSN");

		public String param;

		OptionFolderRenameParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionFolderDeleteParam {
		FOLDER_SN("folderSN"), DELETE_TYPE("deleteType");

		public String param;

		OptionFolderDeleteParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionQuickReplySetParam {

		USE_QUICK_REPLY("useQuickReply");

		public String param;

		OptionQuickReplySetParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionQuickReplyAddParam {
		CONTENT("content");

		public String param;

		OptionQuickReplyAddParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionQuickReplyEditParam {

		CONTENT("content"), SN("sn");

		public String param;

		OptionQuickReplyEditParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionQuickReplyDeleteParam {

		SN("sn");

		public String param;

		OptionQuickReplyDeleteParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionReminderSetParam {

		SOON("soon", "3"), LATE_TODAY("lageToday", "17:00"),

		TOMORROW("tomorrow", "8:00"), NEXT_WEEK("nextWeek", "2,08:00"),

		USE_FAVORITE("useFavorite", "0,08:00");

		public String param;
		public String defValue;

		OptionReminderSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}

	}

	public static enum OptionMobileNotiSetParam {
		NOTI_TYPE("notiType", "mailbox"), NOTI_MAIL_BOX("notiMailBox", "0");

		public String param;
		public String defValue;

		OptionMobileNotiSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}

	public static enum OptionAddressGetImportantParam {
		PAGE_SIZE("pageSize");

		public String param;

		private OptionAddressGetImportantParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionSpamSetParam {
		SPAM_FROM_ME("spamFromMe", "false"), DIRECT_RCPT("directRcpt", "false"),

		FROM_ADDR_BOOK("fromAddrbook", "false"), LANG_FILTER_USE("langFilterUse", "false"),

		LANG_SET("langSet", "each"), LAGN_SET2("langSet2", "false"),

		LANG_SET3("langSet3", "false"), LANG_SET4("langSet4", "false"),

		AUTO_MOVE("autoMove", "true"), PREV_AUTO_MOVE("prevAutoMove", "true"),

		SPAM_MOVE_TYPE("spamMoveType", "0"), RECEIVE_BLOCK("receiveBlock", "true"),

		DELETE_TYPE("deleteType", "1"), HIDE_IMAGE("hideImage", "true"),

		SPAM_PERIOD("spamPeriod", "10"), HIDE_SPAM_FOLDER("hideSpamFolder", "false");

		public String param;
		public String defValue;

		private OptionSpamSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}

	public static enum OptionReceiveSetParam {
		ADDR_LIST("addrList"), MAILING_LIST("mailingList");

		public String param;

		private OptionReceiveSetParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionRejectAddressSetParam {
		ADD_ITEMS(""), DEL_ITEMS("");

		public String param;

		private OptionRejectAddressSetParam(String param) {
			this.param = param;
		}
	}

	public static enum OptionShortCutSetParam {
		USE_SHORT_CUT("", ""), INBOX_SHOW_KEY("", ""),

		MYBOX_SHOW_KEY("", ""), SENT_BOX_SHOW_KEY("", ""),

		RECEIPT_BOX_SHOW_KEY("", ""), DRAFT_BOX_SHOW_KEY("", ""),

		SPAM_BOX_SHOW_KEY("", ""), TRASH_BOX_SHOW_KEY("", ""),

		INB_TOGGLE_KEY("", ""), SPAM_BOX_EMPTY_KEY("", ""),

		TRASH_BOX_EMPTY_KEY("", ""), ALL_MAIL_SHOW_KEY("", ""),

		UNREAD_MAIL_SHOW_KEY("", ""), MOVE_UP_KEY("", ""),

		MOVE_DOWN_KEY("", ""), PREV_PAGE_MOVE_KEY("", ""),

		NEXT_PAGE_MOVE_KEY("", "");
		// ........
		public String param;
		public String defValue;

		private OptionShortCutSetParam(String param, String defValue) {
			this.param = param;
			this.defValue = defValue;
		}
	}
}
