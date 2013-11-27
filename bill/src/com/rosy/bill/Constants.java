package com.rosy.bill;


/**
 * Constant values used throughout the application.
 * 
 * <p>
 * <a href="Constants.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author 
 */
public class Constants {
	// ~ Static fields/initializers
	// =============================================

	/** double型运算时的误差范围为0.01 */
	public static final double ERRORRANGE = 0.01;// double型运算时的误差范围为0.01


	/** The name of the ResourceBundle used in this application */
	public static final String BUNDLE_KEY = "ApplicationResources";

	/** The encryption algorithm key to be used for passwords */
	public static final String ENC_ALGORITHM = "algorithm";

	/** A flag to indicate if passwords should be encrypted */
	public static final String ENCRYPT_PASSWORD = "encryptPassword";

	/** File separator from System properties */
	public static final String FILE_SEP = System.getProperty("file.separator");

	/** User home from System properties */
	public static final String USER_HOME = System.getProperty("user.home")
			+ FILE_SEP;

	/** The name of the configuration hashmap stored in application scope. */

	public static final String CONFIG = "appConfig";

	public static final String APP_NAME = "sdb2b";
	
	public static final String APP_INTEGRATION_NAME = "Hcpms";
	
	public static final String INTEGRATION_SESSIONID_KEY = "INTEGRATION_SESSIONID";
	
	public static final String INTEGRATION_PASSWORD = "##fromthisintegration###";
	
	public static final String INTEGRATION_SESSIONID = "integrationsessionId";
	// 以下是Ext json中的一些参数设置
	public static final String OPERATE_MODE = "json";

	public static final String SAVEMORE_JSON = "jsonStr";
	
	public static final String CODE_KEY_VALUE = "codeKeyValue";

	public static final Integer MAX_COUNT = Integer.MAX_VALUE;

	public static final String EXT_SUCCESS_JSON_STR = "{'success':true}";

	public static final String EXT_FAILURE_JSON_STR = "{'success':false}";

	public static final String EXT_LIST_JSON_STR = "{'success':true,'totalCounts':0,'results':[]}";

	public static final String EXT_DATA_JSON_STR = "{'success':true,'data':{}}";

	public static final String EXT_JSON_SUCCESS_STR = "success";
	public static final String EXT_JSON_TOTALCOUNTS_STR = "totalCounts";
	public static final String EXT_JSON_RESULTS_STR = "results";
	public static final String EXT_JSON_DATA_STR = "data";
	public static final String USER_ADMIN = "admin";
	public static final String PASSWORD_ENCORDER_HASH = "SHA";
	public static final String USER_DEFAULT_PASSWORD = "123456";
	public static final String FUNCTION_LISTS = "AUTHORITY_LISTS";
	public static final String LAST_LOGIN_DATE = "LAST_LOGIN_DATE";

	public static final String APP_CONFIG_PROPERTY = "/appConfig.properties";


	/**
	 * Session scope attribute that holds the locale set by the user. By setting
	 * this key to the same one that Struts uses, we get synchronization in
	 * Struts w/o having to do extra work or have two session-level variables.
	 */
	public static final String PREFERRED_LOCALE_KEY = "org.apache.struts.action.LOCALE";

	public static final String ACTION = "1";
	
	/**checkBox 选中*/
	public static final String CHECK_BOX_ON = "on"; 
	
	/**checkBox 未选中*/
	public static final String CHECK_BOX_UN = "un"; 
	
	public static final String  MESSAGETYPE_URGENT ="1";
	
	public static final String  MESSAGETYPE_COMMONLY ="0";
	
	/**消息类型-通知*/
	public static final String MESSAGETYPE_NOTICE = "0"; 
	
	/**消息类型-系统消息*/
	public static final String MESSAGETYPE_SYSTEM = "1"; 

	/** 当前记录有效 */
	public static final String RECFLAG_IN = "1";
	/** 当前记录无效 */
	public static final String RECFLAG_UN = "0";

	/** 当前记录未删除 */
	public static final Integer DELFLAG_IN = 0;

	/** 当前记录未删除 */
	public static final String DELFLAG_STR_IN = "0";

	/** 当前记录删除 */
	public static final Integer DELFLAG_UN = 1;

	/** 当前记录永久删除 */
	public static final Integer DELFLAG_OUT = -1;

	/** 标记可用 */
	public static final Boolean USEFLAG_ON = true;

	/** 标记不可用 */
	public static final Boolean USEFLAG_OFF = false;

	/** 标记可用 */
	public static final String ON = "1";

	/** 标记不可用 */
	public static final String OFF = "0";

	/**分页数组*/
	public static final int[] PAGE_ARRAY ={20,50,100,150,200,500};
	
	/** 广播分页大小  */ 
	public static final Integer BROADCAST_PAGE_SIZE = 5;
	
	/** 每页分页大小 默认是每页20行 */ 
	public static final Integer PAGE_SIZE =20;
	
	/**商品管理分页默认每页20行*/
	public static final Integer PRODUCT_PAGE_SIZE = 20;

	/** 分页时候 displaytag的table Id */
	public static final String LIST_ID_KEY = "listId";

	/** 分页时候 displaytag的table 默认id item */
	public static final String LIST_ID_DEFAULT = "item";

	/** 分页大小保存的参数名 */
	public static final String PAGE_SIZE_KEY = "pageSize";
	/** 跳转到哪页 */
	public static final String PAGE_NUMBER_KEY = "pageNumber";

	/** 总页大小 */
	public static final String RESULT_SIZE_KEY = "resultSize";

	/** Ext 当前从哪行开始 */
	public static final String PAGE_EXT_NUMBER_KEY = "start";
	/** Ext 分页 每页分页大小 */
	public static final String PAGE_EXT_SIZE_KEY = "limit";
	/** Ext 排序的字段 */
	public static final String PAGE_EXT_SORT_KEY = "sort";
	/** Ext 排序的顺序 */
	public static final String PAGE_EXT_DIR_KEY = "dir";

	/** 是否是一个新的查询 */
	public static final String NEW_SEARCH = "newSearch";

	/** 查询条件保存session 键值 */
	public static final String SEARCH_CONDITION = "searchCondition";
	/** 逻辑假、否 */
	public static final String LOGIC_FALSE = "0";
	/** 逻辑真、是 */
	public static final String LOGIC_TRUE = "1";
	/** 审核通过 */
	public static final String CHECK_TRUE = "1";
	/** 未审核 */
	public static final String CHECK_FALSE = "0";
	
	public static final String CONTAIN_ZERO ="1";

	public static final String CURRENT_USER = "_CurrentUser";

	public static final String CURRENT_USER_MSGCOUNT = "currentUsermsgCount";
	
	public static final String CURRENT_USER_MSG_SYS_COUNT = "currentUsermsgSysCount";
	
	public static final String CURRENT_USER_MSG_COMM_COUNT = "currentUsermsgCommCount";
	
	public static final String PROJECT_INFO = "projectInfo";

	public static final String PROJECT_YEAR = "projectYear";

	public static final String PROJECT_ORG_CODE = "projectOrgCode";

	public static final String PROJECT_ID = "projectId";

	public static final String CONTRACT_ID = "contractId";
	
	/**
	 * The name of the CSS Theme setting.
	 */
	public static final String CSS_THEME = "csstheme";

	public static final String UPLOAD_PATH = "WEB-INF\\upload" + FILE_SEP;

	public static final String UPLOAD_ROOT_PATH = "upload" + FILE_SEP;


	
	public static final String UPLOAD_MSG_FILE_PATH = "通知文档" + FILE_SEP;

	public static final String TEMP_PATH = "temp" + FILE_SEP;

	public static final String CANNOT_FOUND_IMAGE_PATH = "resources" + FILE_SEP
			+ "cannotfoundimage.gif";

	public static final String CANNOT_FOUND_FILE_PATH = "resources" + FILE_SEP
			+ "cannotfound.gif";

	public static final String NO_IMAGE_PATH = "resources" + FILE_SEP
			+ "nopic.gif";
	
	/** 生成收费通知周期（单位：月） **/
	public static final int GENERATE_PAYMENT_NOTICE_PERIOD = 1;
	
	/** 生成收费通知的有效开始日期  **/
	public static final int GENERATE_PAYMENT_NOTICE_START_DAY = 1;
	
	
	/** 专柜交费通知类型 **/
	public static final String COUNTER_RENT_TYPE = "ZGJF";
	
	/** 专柜结算通知类型 **/
	public static final String  COUNTER_BILL_TYPE = "ZGJS";
	
	/** 专柜结算计提类型 **/
	public static final String COUNTER_SUBMIT_TYPE = "1";
	
	/** 专柜交费计提类型 **/
	public static final String COUNTER_PAY_TYPE = "2";
	
	
	/**
	 * 存储过程SDB_SEQ_PROC 的参数  
	 * '2' 为产生专柜交费通知单日志ID序号
	 * '3' 为产生专柜交费通知单表单ZG_OID序号
	 */
	public static final String COUNTER_PROC_LOGID = "2";
	public static final String COUNTER_PROC_NOTICEID = "3";
	
	/**
	 * 专柜交费日志描述
	 */
	public static final String COUNTER_RENT_DESC = "导入专柜交费单";
	public static final String COUNTER_BILL_DESC = "导入专柜结算单";
	
	/**
	 * 
	 * 专柜通知单状态  
	 */
	
    public static final String COUNTER_NOTICE_CREATE = "1"; //创建
    public static final String COUNTER_NOTICE_PUBLISH = "2"; //发放
    public static final String COUNTER_NOTICE_SUPPFB = "3"; //供应商反馈
    public static final String COUNTER_NOTICE_SUNDANFB = "4"; //顺电反馈
    public static final String COUNTER_NOTICE_CLOSE = "5"; //关闭 
	
	/*
	 * 审核状态
	 */
	public static final String KEEP_APP = "保存"; //保存申请
		
	public static final String ADD_APP = "申请";//申请
	
	public static final String FIRST_APP = "初审"; //初审
	
	public static final String END_APP = "确审"; //确审
	
	public static final String REBUT_APP = "驳回"; //驳回
	
	public static final String SECOND_APP = "复审"; //复审
	
	public static final String DIS_APP = "作废";//作废
	
	/**
	 * 审核状态 CODE
	 */
	public static final String KEEP_APP_CODE = "0"; //保存申请
	
	public static final String ADD_APP_CODE= "1";//申请
	
	public static final String FIRST_APP_CODE = "2"; //初审
	
	public static final String END_APP_CODE = "3"; //确审
	
	public static final String REBUT_APP_CODE = "4"; //驳回
	
	public static final String SECOND_APP_CODE = "5"; //复审
	
	public static final String DIS_APP_CODE = "7";//作废
	 
	
	/**
	 * 审批状态
	 */
	public static final String RATIFY_APP = "批准";
	public static final String STA_APP = "暂挂";
	
	/**
	 * 购销对账通知单状态
	 */
	public static final String BILL_CREATE = "0";	//创建
	
	public static final String BILL_PUBLISH = "1";	//发布
	
	public static final String BILL_SUPPLIER_FEEDBACK = "2";	//供应商反馈
	
	public static final String BILL_CLOSE = "5";	//关闭
	
	public static final String BILL_SUNDAN_FEEDBACK = "6"; //顺电反馈
	
	//收款通知单生成到的月份
	public static String COLLECTION_MONTH = "";
	//税率
	public static final double TAX = 0.17;
	/** 勿添加到这里 请添加到靠前面 */
	
	public static final String STORE_NAME ="Sundan";
	public static final String STORE_ID = "103";
	
	
	
	/** 交流中心通知类型 **/
	//public static final String MESS_OTHER = "0" ;	 	//供应商一般通知
	public static final String MESS_ORDINARY = "1" ;	 //供应商一般通知
	public static final String MESS_OUT_OF_STOCK = "2" ; //断缺货报警
	public static final String MESS_YEAR_PLAN = "3" ;	 //年度计划
	public static final String MESS_FINANCE= "4" ;		 //供应商财务通知.
	
	//邮件阅读标识
	public static final String MESSAGE_IS_READ = "1";
	public static final String MESSAGE_NO_READ = "0";
	
	
	/**   单位类型         **/
	public static final String ORG_KIND_SUNDAN = "1";  //顺电
	public static final String ORG_KIND_SUPPLIER = "2"; //供应商
	public static final String ORG_KIND_COUNTER_MANUFACTURER = "3";  //专柜--生产商
	public static final String ORG_KIND_COUNTER_WHOLESALER = "4";    //专柜--批发商
	public static final String ORG_KIND_COUNTER_AGENTS = "5";        //专柜--代理商
	
	/** 用户类型  ***/
	public static final String USER_KIND_SUNDAN = "1";   //顺电
	public static final String USER_KIND_SUPPLIER = "2"; //供应商
	public static final String USER_KIND_COUNTER = "3";  //专柜
	
	/**  单位性质    **/
	public static final String ORG_PROPERTY_INDIVIDUAL = "0"; //个体
	public static final String ORG_PROPERTY_PRIVATE = "1";    //私营
	public static final String ORG_PROPERTY_STOCK = "2";      //股份
	public static final String ORG_PROPERTY_STATEOWNED = "3"; //国企
	
}
