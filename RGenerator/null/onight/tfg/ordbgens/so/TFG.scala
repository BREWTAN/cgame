package onight.tfg.ordbgens.sys.so

import onight.async.mysql.commons.SimpleDAO
import scala.reflect.classTag
import java.math.BigDecimal
import java.sql.Timestamp


object TFGDAOs {


  case class KOTSysAction(
 val ACTION_ID: Option[Int] = null
, val ACTION_FLAG: String = null
, val ACTION_NAME: String = null
, val ACTION_DESC: String = null
, val ACTION_MENU: Option[Int] = null
, val FIELD1: String = null
  	)

  object TSysActionDAO extends SimpleDAO[KOTSysAction] {
    val ttag = classTag[KOTSysAction];
    val tablename = "T_SYS_ACTION";
    val keyname = "ACTION_ID"
  }


  case class KOTSysBranch(
 val ID: String = null
, val BRANCH_ID: String = null
, val BRANCH_DESC: String = null
, val BRANCH_NAME: String = null
, val BRANCH_MANAGER: String = null
, val MOBILE: String = null
, val BEGIN_TIME: Timestamp = null
, val END_TIME: Timestamp = null
, val PARENT_ID: String = null
, val LEAF_FLAG: Option[Int] = null
, val BRANCH_SEQ: Option[Int] = null
, val LEVEL: Option[Int] = null
  	)

  object TSysBranchDAO extends SimpleDAO[KOTSysBranch] {
    val ttag = classTag[KOTSysBranch];
    val tablename = "T_SYS_BRANCH";
    val keyname = "ID"
  }


  case class KOTSysBusiness(
 val BUSINESS_ID: String = null
, val BUSINESS_NAME: String = null
, val BUSINESS_DESC: String = null
, val BUSINESS_MANAGER: String = null
, val BUSINESS_MOBILE: String = null
, val BUSINESS_SEQ: Option[Int] = null
, val BEGIN_TIME: Timestamp = null
, val END_TIME: Timestamp = null
, val STATUS: Option[Int] = null
, val BUSINESS_DATA_PERMISSION: Option[Int] = null
  	)

  object TSysBusinessDAO extends SimpleDAO[KOTSysBusiness] {
    val ttag = classTag[KOTSysBusiness];
    val tablename = "T_SYS_BUSINESS";
    val keyname = "BUSINESS_ID"
  }


  case class KOTSysMenu(
 val MENU_ID: Option[Int] = null
, val MENU_NAME: String = null
, val MENU_DESC: String = null
, val MENU_SEQ: Option[Int] = null
, val MENU_URL: String = null
, val PARENT_ID: Option[Int] = null
, val LEAF_FLAG: Option[Int] = null
, val LEVEL: Option[Int] = null
, val ICON: String = null
  	)

  object TSysMenuDAO extends SimpleDAO[KOTSysMenu] {
    val ttag = classTag[KOTSysMenu];
    val tablename = "T_SYS_MENU";
    val keyname = "MENU_ID"
  }


  case class KOTSysOpLogs(
 val ID: String = null
, val SKEYS: String = null
, val CONTENTS: String = null
, val LEVEL: String = null
, val CRT_TIME: Timestamp = null
  	)

  object TSysOpLogsDAO extends SimpleDAO[KOTSysOpLogs] {
    val ttag = classTag[KOTSysOpLogs];
    val tablename = "T_SYS_OP_LOGS";
    val keyname = "ID"
  }


  case class KOTSysParam(
 val PARAM_ID: String = null
, val PARAM_TYPE: String = null
, val PARAM_VALUE: String = null
, val DSC: String = null
, val CRT_TIME: String = null
, val FIELD1: String = null
, val FIELD2: String = null
, val FIELD3: String = null
  	)

  object TSysParamDAO extends SimpleDAO[KOTSysParam] {
    val ttag = classTag[KOTSysParam];
    val tablename = "T_SYS_PARAM";
    val keyname = "PARAM_ID"
  }


  case class KOTSysRole(
 val ROLE_ID: String = null
, val ROLE_NAME: String = null
, val ROLE_DESC: String = null
, val STATUS: Option[Int] = null
  	)

  object TSysRoleDAO extends SimpleDAO[KOTSysRole] {
    val ttag = classTag[KOTSysRole];
    val tablename = "T_SYS_ROLE";
    val keyname = "ROLE_ID"
  }


  case class KOTSysRoleAction(
 val ID: Option[Char] = null
, val ACTION_ID: Option[Int] = null
, val ROLE_ID: Option[Char] = null
, val STATUS: Option[Int] = null
  	)

  object TSysRoleActionDAO extends SimpleDAO[KOTSysRoleAction] {
    val ttag = classTag[KOTSysRoleAction];
    val tablename = "T_SYS_ROLE_ACTION";
    val keyname = "ID"
  }


  case class KOTSysRoleMenu(
 val ID: String = null
, val MENU_ID: Option[Int] = null
, val ROLE_ID: String = null
, val STATUS: Option[Int] = null
  	)

  object TSysRoleMenuDAO extends SimpleDAO[KOTSysRoleMenu] {
    val ttag = classTag[KOTSysRoleMenu];
    val tablename = "T_SYS_ROLE_MENU";
    val keyname = "ID"
  }


  case class KOTSysRoleMutex(
 val ROLE_MUTEX_ID: String = null
, val ROLE_ID_A: String = null
, val ROLE_ID_B: String = null
, val STATUS: Option[Int] = null
  	)

  object TSysRoleMutexDAO extends SimpleDAO[KOTSysRoleMutex] {
    val ttag = classTag[KOTSysRoleMutex];
    val tablename = "T_SYS_ROLE_MUTEX";
    val keyname = "ROLE_MUTEX_ID"
  }


  case class KOTSysRspCode(
 val ID: String = null
, val PROD_ID: String = null
, val OUT_RSP_CODE: String = null
, val IN_RSP_CODE2: String = null
, val RSP_DESC: String = null
  	)

  object TSysRspCodeDAO extends SimpleDAO[KOTSysRspCode] {
    val ttag = classTag[KOTSysRspCode];
    val tablename = "T_SYS_RSP_CODE";
    val keyname = "ID"
  }


  case class KOTSysUser(
 val USER_ID: String = null
, val BRANCH_ID: String = null
, val LOGIN_NAME: String = null
, val USER_NAME: String = null
, val MOBILE: String = null
, val USER_WORKADDRESS: String = null
, val STATUS: String = null
, val PASSWORD: String = null
, val UPDATE_TIME: Timestamp = null
, val CREATE_TIME: Timestamp = null
, val CREATED_BY: String = null
, val MODIFIED_BY: String = null
, val EMAIL: String = null
, val DATA_ENVIRON: Option[Int] = null
, val ICON: String = null
  	)

  object TSysUserDAO extends SimpleDAO[KOTSysUser] {
    val ttag = classTag[KOTSysUser];
    val tablename = "T_SYS_USER";
    val keyname = "USER_ID"
  }


  case class KOTSysUserRole(
 val USER_ROLE_ID: String = null
, val ROLE_ID: String = null
, val USER_ID: String = null
, val STATUS: Option[Int] = null
  	)

  object TSysUserRoleDAO extends SimpleDAO[KOTSysUserRole] {
    val ttag = classTag[KOTSysUserRole];
    val tablename = "T_SYS_USER_ROLE";
    val keyname = "USER_ROLE_ID"
  }


  case class KOTFGGroup(
 val GROUP_ID: String = null
, val PARENT_GROUP_ID: String = null
, val GROUP_NAME: String = null
, val GROUP_DESC: String = null
, val STATUS: String = null
  	)

  object TFGGroupDAO extends SimpleDAO[KOTFGGroup] {
    val ttag = classTag[KOTFGGroup];
    val tablename = "TFG_GROUP";
    val keyname = "GROUP_ID"
  }


  case class KOTFGLoginUser(
 val USER_ID: Option[Int] = null
, val LOGIN_ID: String = null
, val NICKNAME: String = null
, val EMAIL: String = null
, val MOBILE: String = null
, val THIRD_LOGINID1: String = null
, val THIRD_LOGINID2: String = null
, val REG_TYPE: String = null
, val STATUS: Option[Int] = null
, val PASSWORD: String = null
, val TRADE_PASSWORD: String = null
, val UPDATE_TIME: Timestamp = null
, val CREATE_TIME: Timestamp = null
, val LAST_LOGIN_TIME: Timestamp = null
, val LAST_LOGIN_IP: String = null
, val LAST_LOGIN_TERMINAL: Option[Int] = null
, val LAST_LOGIN_SYSINFO: String = null
  	)

  object TFGLoginUserDAO extends SimpleDAO[KOTFGLoginUser] {
    val ttag = classTag[KOTFGLoginUser];
    val tablename = "TFG_LOGIN_USER";
    val keyname = "USER_ID"
  }


  case class KOTFGRole(
 val ROLE_ID: String = null
, val PARENT_ROLE_ID: String = null
, val ROLE_NAME: String = null
, val ROLE_DESC: String = null
, val STATUS: String = null
  	)

  object TFGRoleDAO extends SimpleDAO[KOTFGRole] {
    val ttag = classTag[KOTFGRole];
    val tablename = "TFG_ROLE";
    val keyname = "ROLE_ID"
  }


  case class KOTFGUserGroup(
 val USER_GROUP_ID: String = null
, val USER_ID: String = null
, val GROUP_ID: String = null
, val STATUS: String = null
  	)

  object TFGUserGroupDAO extends SimpleDAO[KOTFGUserGroup] {
    val ttag = classTag[KOTFGUserGroup];
    val tablename = "TFG_USER_GROUP";
    val keyname = "USER_GROUP_ID"
  }


  case class KOTFGUserIdList(
 val USER_ID: Option[Int] = null
, val STATUS: Option[Int] = null
  	)

  object TFGUserIdListDAO extends SimpleDAO[KOTFGUserIdList] {
    val ttag = classTag[KOTFGUserIdList];
    val tablename = "TFG_USER_ID_LIST";
    val keyname = "USER_ID"
  }


  case class KOTFGUserInfo(
 val USER_ID: Option[Int] = null
, val NICKNAME: String = null
, val PARENT_ID: Option[Int] = null
, val RECOMMEND_ID: Option[Int] = null
, val USER_TYPE: String = null
, val SECURITY_EMAIL: String = null
, val REAL_NAME: String = null
, val STATUS: Option[Int] = null
, val ID_NO: String = null
, val UPDATE_TIME: Timestamp = null
, val CREATE_TIME: Timestamp = null
, val QQ_ID: String = null
, val WECHAT_ID: String = null
, val MOBILE: String = null
, val EMAIL: String = null
, val RENREN: String = null
, val WEIBO: String = null
, val FACE: Option[Int] = null
, val FACE_URL: String = null
, val GENDER: Option[Int] = null
, val BIRTHDAY: Date = null
, val COUNTRY: String = null
, val PROVINCE: String = null
, val CITY: String = null
, val HOME_ADDRESS: String = null
, val WORK_ADDRESS: String = null
, val MOBILE1: String = null
, val MOBILE2: String = null
, val MOBILE3: String = null
, val MOBILEHIS: String = null
, val REMARK: String = null
, val REG_TIME: Timestamp = null
, val REG_IP: String = null
  	)

  object TFGUserInfoDAO extends SimpleDAO[KOTFGUserInfo] {
    val ttag = classTag[KOTFGUserInfo];
    val tablename = "TFG_USER_INFO";
    val keyname = "USER_ID"
  }


  case class KOTFGUserRole(
 val USER_ROLE_ID: String = null
, val USER_ID: String = null
, val ROLE_ID: String = null
, val STATUS: String = null
  	)

  object TFGUserRoleDAO extends SimpleDAO[KOTFGUserRole] {
    val ttag = classTag[KOTFGUserRole];
    val tablename = "TFG_USER_ROLE";
    val keyname = "USER_ROLE_ID"
  }


  case class KOTLTBetAuto(
 val ID: Option[Int] = null
, val AUTOBET_NO: String = null
, val USER_ID: String = null
, val LTYPE: String = null
, val LNAME: String = null
, val PLAYTYPE: String = null
, val LPG_ID: String = null
, val LP_ID: String = null
, val CREATE_TIME: Timestamp = null
, val START_ISSUE: String = null
, val ISSUE_NUM: Option[Int] = null
, val COMPLETE_NUM: Option[Int] = null
, val CANCEL_NUM: Option[Int] = null
, val BET_NUM: Option[Int] = null
, val BET_DATA: String = null
, val BET_COINS: String = null
, val COMPLETE_COINS: String = null
, val CANCEL_COINS: String = null
, val MODE: Option[Int] = null
, val TIMES: Option[Int] = null
, val WIN_STOP: Option[Int] = null
, val STATUS: Option[Int] = null
, val BET_NO: String = null
  	)

  object TLTBetAutoDAO extends SimpleDAO[KOTLTBetAuto] {
    val ttag = classTag[KOTLTBetAuto];
    val tablename = "TLT_BET_AUTO";
    val keyname = "ID"
  }


  case class KOTLTBonus(
 val ID: Option[Int] = null
, val BONUSGROUP_ID: Option[Int] = null
, val LTYPE: String = null
, val PLAY_TYPE: String = null
, val LPG_ID: Option[Int] = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val BONUS: String = null
, val BET_NUM: Option[Int] = null
, val TOTAL_MARGIN: String = null
, val STATUS: Option[Int] = null
  	)

  object TLTBonusDAO extends SimpleDAO[KOTLTBonus] {
    val ttag = classTag[KOTLTBonus];
    val tablename = "TLT_BONUS";
    val keyname = "ID"
  }


  case class KOTLTBonusgroup(
 val ID: Option[Int] = null
, val LTYPE: String = null
, val PLAY_TYPE: String = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val STATUS: Option[Int] = null
, val CREATE_TIME: Timestamp = null
, val UPDATE_TIME: Timestamp = null
, val USER_ID: Option[Int] = null
  	)

  object TLTBonusgroupDAO extends SimpleDAO[KOTLTBonusgroup] {
    val ttag = classTag[KOTLTBonusgroup];
    val tablename = "TLT_BONUSGROUP";
    val keyname = "ID"
  }


  case class KOTLTCoreBet(
 val TICK_NO: String = null
, val LTYPE: String = null
, val LNAME: String = null
, val PLAYTYPE: String = null
, val MERCHANTID: String = null
, val SERIALNUM: String = null
, val BET_AMOUNT: Option[Double] = null
, val BOARDS: Option[Double] = null
, val MULTI: Option[Double] = null
, val ISSUE_NO: String = null
, val BET_DATETIME: Timestamp = null
, val BET_CONTENT: String = null
, val BET_IP: String = null
, val BET_MOENY_UNIT: Option[Int] = null
, val VERSION: String = null
, val PRINTTIME: Option[Double] = null
, val BET_STATUS: Option[Double] = null
, val NOTIFYSTATUS: Option[Double] = null
, val REGION: String = null
, val FAILREASON: String = null
, val MERCHANTUSERID: String = null
, val USER_ID: String = null
, val AUTOBET_NO: String = null
, val IS_AUTO: String = null
, val AUTO_REF_TICKNO: String = null
  	)

  object TLTCoreBetDAO extends SimpleDAO[KOTLTCoreBet] {
    val ttag = classTag[KOTLTCoreBet];
    val tablename = "TLT_CORE_BET";
    val keyname = "TICK_NO"
  }


  case class KOTLTGroupType(
 val GROUP_TYPE: String = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val REMARK: String = null
  	)

  object TLTGroupTypeDAO extends SimpleDAO[KOTLTGroupType] {
    val ttag = classTag[KOTLTGroupType];
    val tablename = "TLT_GROUP_TYPE";
    val keyname = "GROUP_TYPE"
  }


  case class KOTLTIssue(
 val ISSUE_ID: Option[Int] = null
, val LTYPE: String = null
, val ISSUE_NO: String = null
, val LOTTERY_NO: String = null
, val ISSUE_DATE: String = null
, val PRE_STIME: Timestamp = null
, val PRE_ETIME: Timestamp = null
, val SALE_STIME: Timestamp = null
, val SALE_ETIME: Timestamp = null
, val REAL_STIME: Timestamp = null
, val REAL_ETIME: Timestamp = null
, val CANCEL_LTIME: Timestamp = null
, val CLOSESHARE_DATE: Timestamp = null
, val REBATE_STATUS: Option[Int] = null
, val WIN_STATUS: Option[Int] = null
, val SEND_STATUS: Option[Int] = null
, val AUTOBET_STATUS: Option[Int] = null
, val LOCK_STATUS: Option[Int] = null
, val PROCESS_STATUS: Option[Int] = null
, val CREATE_TIME: Timestamp = null
, val MODIFY_TIME: Timestamp = null
, val STATUS: String = null
  	)

  object TLTIssueDAO extends SimpleDAO[KOTLTIssue] {
    val ttag = classTag[KOTLTIssue];
    val tablename = "TLT_ISSUE";
    val keyname = "ISSUE_ID"
  }


  case class KOTLTIssueGenParams(
 val GEN_ID: Option[Int] = null
, val LTYPE: String = null
, val SALE_STIME: String = null
, val SALE_ETIME: String = null
, val SALE_FI_ETIME: String = null
, val SALE_CYCLE: Option[Int] = null
, val WAIT_RL_DUR: Option[Int] = null
, val CANCEL_DUR: Option[Int] = null
, val INPUT_DUR: Option[Int] = null
, val SORT: String = null
, val ENABLE: String = null
  	)

  object TLTIssueGenParamsDAO extends SimpleDAO[KOTLTIssueGenParams] {
    val ttag = classTag[KOTLTIssueGenParams];
    val tablename = "TLT_ISSUE_GEN_PARAMS";
    val keyname = "GEN_ID"
  }


  case class KOTLTIssueHis(
 val ISSUE_ID: Option[Int] = null
, val LTYPE: String = null
, val ISSUE_NO: String = null
, val LOTTERY_NO: String = null
, val ISSUE_DATE: String = null
, val PRE_STIME: Timestamp = null
, val PRE_ETIME: Timestamp = null
, val SALE_STIME: Timestamp = null
, val SALE_ETIME: Timestamp = null
, val REAL_STIME: Timestamp = null
, val REAL_ETIME: Timestamp = null
, val CANCEL_LTIME: Timestamp = null
, val CLOSESHARE_DATE: Timestamp = null
, val REBATE_STATUS: Option[Int] = null
, val WIN_STATUS: Option[Int] = null
, val SEND_STATUS: Option[Int] = null
, val AUTOBET_STATUS: Option[Int] = null
, val LOCK_STATUS: Option[Int] = null
, val PROCESS_STATUS: Option[Int] = null
, val CREATE_TIME: Timestamp = null
, val MODIFY_TIME: Timestamp = null
, val STATUS: String = null
  	)

  object TLTIssueHisDAO extends SimpleDAO[KOTLTIssueHis] {
    val ttag = classTag[KOTLTIssueHis];
    val tablename = "TLT_ISSUE_HIS";
    val keyname = "ISSUE_ID"
  }


  case class KOTLTLimitedFeature(
 val UUID: String = null
, val ISSUE_NO: String = null
, val PLAY_TYPE: String = null
, val WAGERDATA: String = null
, val CREATEDATE: Option[Double] = null
, val REGION: String = null
, val LTYPE: String = null
, val BONUS_LIMIT: Option[Double] = null
, val BETS_BOARDS_LIMIT: Option[Double] = null
, val BETS_AMOUNT_LIMIT: Option[Double] = null
, val MERCHATID: String = null
, val USER_ID: String = null
, val LIMIT_TYPE: String = null
, val START_DATE: Timestamp = null
, val EXTRAFIELD1: String = null
, val EXTRAFIELD2: String = null
, val EXTRAFIELD3: Option[Int] = null
, val EXTRAFIELD4: Option[Double] = null
, val EXTRAFIELD5: Option[Double] = null
  	)

  object TLTLimitedFeatureDAO extends SimpleDAO[KOTLTLimitedFeature] {
    val ttag = classTag[KOTLTLimitedFeature];
    val tablename = "TLT_LIMITED_FEATURE";
    val keyname = "UUID"
  }


  case class KOTLTLimitedNum(
 val UUID: String = null
, val ISSUE_NO: String = null
, val LIMITED_NUM: String = null
, val LTYPE: String = null
, val PLAY_TYPE: String = null
, val EXTRAFIELD1: String = null
, val EXTRAFIELD2: String = null
, val EXTRAFIELD3: Option[Int] = null
, val EXTRAFIELD4: Option[Double] = null
, val EXTRAFIELD5: Option[Double] = null
  	)

  object TLTLimitedNumDAO extends SimpleDAO[KOTLTLimitedNum] {
    val ttag = classTag[KOTLTLimitedNum];
    val tablename = "TLT_LIMITED_NUM";
    val keyname = "UUID"
  }


  case class KOTLTLtype(
 val LTYPE: String = null
, val GROUP_TYPE: String = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val CODE_LIST: String = null
, val CODE_LEN: Option[Int] = null
, val SORT: String = null
, val ENABLE: String = null
, val REMARK: String = null
, val DELAY_TIME: Option[Int] = null
, val CATCH_CODE_COUNT: Option[Int] = null
, val CATCH_CODE_INTERVAL: Option[Int] = null
, val MIN_LEFT: String = null
, val MIN_SPREAD: String = null
, val ISSUE_NO_FMT: String = null
, val CLEAR_YMD: String = null
, val LOTTERY_CYCLE: String = null
, val CLOSE_STIME: Timestamp = null
, val CLOSE_ETIME: Timestamp = null
, val REBATE: String = null
, val DELO_REBATE: String = null
  	)

  object TLTLtypeDAO extends SimpleDAO[KOTLTLtype] {
    val ttag = classTag[KOTLTLtype];
    val tablename = "TLT_LTYPE";
    val keyname = "LTYPE"
  }


  case class KOTLTPlaygroup(
 val ID: Option[Int] = null
, val LTYPE: String = null
, val PLAY_TYPE: String = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val LOCK_TABLE: String = null
, val AWARD_LEVEL: Option[Int] = null
, val COST: String = null
, val ENABLE: String = null
, val REMARK: String = null
, val REBATE: String = null
, val DELO_REBATE: String = null
, val VIEWGROUP: String = null
  	)

  object TLTPlaygroupDAO extends SimpleDAO[KOTLTPlaygroup] {
    val ttag = classTag[KOTLTPlaygroup];
    val tablename = "TLT_PLAYGROUP";
    val keyname = "ID"
  }


  case class KOTLTPlayvgroup(
 val ID: Option[Int] = null
, val LTYPE: String = null
, val PLAY_TYPE: String = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val DEFAULT_PG: Option[Int] = null
  	)

  object TLTPlayvgroupDAO extends SimpleDAO[KOTLTPlayvgroup] {
    val ttag = classTag[KOTLTPlayvgroup];
    val tablename = "TLT_PLAYVGROUP";
    val keyname = "ID"
  }


  case class KOTLTPlayType(
 val PLAY_TYPE: String = null
, val LTYPE: String = null
, val GROUP_TYPE: String = null
, val LPG_ID: String = null
, val CN_NAME: String = null
, val EN_NAME: String = null
, val LOCK_FUNC: String = null
, val LOCK_TABLE: String = null
, val LOCK_STATUS: String = null
, val MODE_YJFL: String = null
, val ISANDVALUE: String = null
, val MAX_BUY_CODENUM: Option[Int] = null
, val WIN_FUNC: String = null
, val WIN_BEGINPOS: Option[Int] = null
, val WIN_CODENUM: Option[Int] = null
, val WIN_DISCONTINUOUSPOS: Option[Int] = null
, val WIN_CHECKFUNC: String = null
, val WIN_PAYBONUSFUNC: String = null
, val ENABLE: String = null
, val REMARK: String = null
  	)

  object TLTPlayTypeDAO extends SimpleDAO[KOTLTPlayType] {
    val ttag = classTag[KOTLTPlayType];
    val tablename = "TLT_PLAY_TYPE";
    val keyname = "PLAY_TYPE"
  }


  case class KOTLTUserBank(
 val ID: Option[Int] = null
, val USER_ID: Option[Int] = null
, val BANK_CODE: String = null
, val BANK_NAME: String = null
, val USERNAME: String = null
, val ACCOUNT: String = null
, val MOBILE: String = null
, val PASSWORD: String = null
, val ENABLE: String = null
  	)

  object TLTUserBankDAO extends SimpleDAO[KOTLTUserBank] {
    val ttag = classTag[KOTLTUserBank];
    val tablename = "TLT_USER_BANK";
    val keyname = "ID"
  }


}