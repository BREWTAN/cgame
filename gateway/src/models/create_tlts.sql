
USE TFG;

--  银行卡


DROP TABLE IF EXISTS TLT_USER_BANK;


CREATE TABLE TLT_USER_BANK (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    USER_ID bigint(20) NOT NULL COMMENT '用户数字ID',
    BANK_CODE varchar(16) NOT NULL COMMENT '银行代码，见银行信息表',
    BANK_NAME varchar(64) NOT NULL COMMENT '银行名称，见银行信息表',
    USERNAME varchar(16) NOT NULL DEFAULT '' COMMENT '银行开户名',
    ACCOUNT varchar(64) NOT NULL DEFAULT '' COMMENT '银行账号',
    MOBILE varchar(64) NOT NULL DEFAULT '' COMMENT '手机号',
    PASSWORD varchar(64)  COMMENT '密码(可有可无)',
    ENABLE tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效 1有效 0无效',
    PRIMARY KEY (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户银行帐户信息';



-- -- 彩种管理-- -- -- -- -- -- -- -- -- -- -- -- -- --
DROP TABLE IF EXISTS TLT_GROUP_TYPE;

CREATE TABLE TLT_GROUP_TYPE (
    GROUP_TYPE varchar(16) NOT NULL ,
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称，如：数字型、乐透同区型等',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    REMARK varchar(255) DEFAULT '' COMMENT '备注',
    PRIMARY KEY (GROUP_TYPE)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='彩种类型表';


DROP TABLE IF EXISTS TLT_LTYPE;


CREATE TABLE TLT_LTYPE (
    LTYPE varchar(32) NOT NULL COMMENT '游戏类型，命名规则-[GROUPTYPE]_[游戏类型]',
    GROUP_TYPE varchar(32) NOT NULL COMMENT '所属类型，TLT_GROUP_TYPE.GROUP_TYPE',
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    CODE_LIST varchar(32) DEFAULT '0,1,2,3,4,5,6,7,8,9' COMMENT '号码形态之：彩票可选号码列表，用半角逗号分隔',
    CODE_LEN int(4) DEFAULT '0' COMMENT '号码形态之：号码总长度',
    SORT tinyint(4) NOT NULL DEFAULT '0' COMMENT '排序，一般显示用',
    ENABLE tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停售 1销售中',
    REMARK varchar(255) DEFAULT NULL COMMENT '备注,描述',
    DELAY_TIME int(4) DEFAULT '0' COMMENT '延后时长，秒？？？？？？',
    CATCH_CODE_COUNT int(4) DEFAULT '0' COMMENT '抓号次数',
    CATCH_CODE_INTERVAL int(4) DEFAULT '0' COMMENT '抓号间隔时长，秒，抓号频率最低不得低于30秒，最高不得高于300秒',
    MIN_LEFT float(10 , 3 ) DEFAULT '0.000' COMMENT '最小剩余利润率',
    MIN_SPREAD float(10 , 3 ) DEFAULT '0.000' COMMENT '上下级最小返点差',
    ISSUE_NO_FMT varchar(16) DEFAULT 'yyyymmdd-nnn' COMMENT '期号格式,yyyymmdd-nnn',
    CLEAR_YMD varchar(8) DEFAULT 'Y,M,D' COMMENT '清零规则，Y年清零，M月清零，D日清零；以逗号分隔，有哪个字母就清零',
    LOTTERY_CYCLE varchar(16) DEFAULT '1,2,3,4,5,6,7' COMMENT '开奖周期,1星期一 2星期二 3星期三 4星期四 5星期五 6星期六 7星期日',
    CLOSE_STIME datetime DEFAULT NULL COMMENT '休市开始时间',
    CLOSE_ETIME datetime DEFAULT NULL COMMENT '休市结束时间',
    REBATE float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认返点',
    DELO_REBATE float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认不定位返点',
    PRIMARY KEY (LTYPE)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='彩种（又称游戏）信息表';

create index IDX_TLT_LTYPE_GROUP on TLT_LTYPE
(
   GROUP_TYPE
);


DROP TABLE IF EXISTS TLT_PLAY_TYPE;
CREATE TABLE TLT_PLAY_TYPE (
    PLAY_TYPE varchar(64) NOT NULL COMMENT '玩法类型',
    LTYPE varchar(32) NOT NULL COMMENT '所属游戏，对应TLT_TYPE.LTYPE',
    GROUP_TYPE varchar(32) NOT NULL COMMENT '所属类型，TLT_GROUP_TYPE.GROUP_TYPE',
    LPG_ID varchar(32) NOT NULL COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    LOCK_FUNC varchar(64) DEFAULT NULL COMMENT '封锁表初始化函数',
    LOCK_TABLE varchar(64) DEFAULT NULL COMMENT '封锁表名称',
    LOCK_STATUS tinyint(1) DEFAULT '0' COMMENT '封锁状态，0未封锁 1封锁',
    MODE_YJFL varchar(16) DEFAULT '1,2,3,4' COMMENT '元角模式，1支持元,2支持角 3支持分 4支持厘',
    ISANDVALUE tinyint(1) DEFAULT '0' COMMENT '是否为和值玩法，0否 1是',
    MAX_BUY_CODENUM int(10) DEFAULT '0' COMMENT '最大购买号码个数，0表示无限制',
    WIN_FUNC varchar(64) DEFAULT NULL COMMENT '中奖函数名',
    WIN_BEGINPOS int(4) DEFAULT NULL COMMENT '中奖号码起始位置',
    WIN_CODENUM int(4) DEFAULT NULL COMMENT '中奖号码个数',
    WIN_DISCONTINUOUSPOS int(4) DEFAULT NULL COMMENT '非连续中奖号码位置',
    WIN_CHECKFUNC varchar(64) DEFAULT NULL COMMENT '中奖判断函数名',
    WIN_PAYBONUSFUNC varchar(64) DEFAULT NULL COMMENT '派发奖金函数名',
    ENABLE tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停售 1销售中',
    REMARK varchar(255) DEFAULT NULL COMMENT '备注,描述',
    PRIMARY KEY (PLAY_TYPE)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩法信息表';

create index IDX_TLT_PLAY_TYPE_GROUP on TLT_PLAY_TYPE
(
   GROUP_TYPE
);
create index IDX_TLT_PLAY_TYPE_LTYPE on TLT_PLAY_TYPE
(
   LTYPE
);

-- 游戏分组管理*显示使用
DROP TABLE IF EXISTS TLT_PLAYVGROUP;
CREATE TABLE TLT_PLAYVGROUP (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    LTYPE varchar(32) NOT NULL COMMENT '所属游戏类型，对应',
    PLAY_TYPE varchar(64) NOT NULL COMMENT '所属玩法类型，对应',
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    DEFAULT_PG int(11) DEFAULT NULL COMMENT '默认显示哪个玩法组',
    PRIMARY KEY (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩法群信息表，即虚拟玩法组，是逻辑分组层';


DROP TABLE IF EXISTS TLT_PLAYGROUP;
CREATE TABLE TLT_PLAYGROUP (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    LTYPE varchar(32) NOT NULL COMMENT '所属游戏类型，对应',
    PLAY_TYPE varchar(64) NOT NULL COMMENT '所属玩法类型，对应',
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    LOCK_TABLE varchar(64) DEFAULT NULL COMMENT '封锁表名称',
    AWARD_LEVEL int(1) DEFAULT '0' COMMENT '奖级，1单奖级 2多奖级',
    COST float(10 , 2 ) DEFAULT '0.00' COMMENT '全包成本',
    ENABLE tinyint(1) NOT NULL DEFAULT '0' COMMENT '0停售 1销售中',
    REMARK varchar(255) DEFAULT NULL COMMENT '备注,描述',
    REBATE float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认返点',
    DELO_REBATE float(5 , 1 ) NOT NULL DEFAULT '0.0' COMMENT '默认不定位返点',
    VIEWGROUP varchar(32) COMMENT '显示组的位置，例如在时时彩的第几行',
    PRIMARY KEY (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='玩法组信息表';



DROP TABLE IF EXISTS TLT_BONUSGROUP;
CREATE TABLE TLT_BONUSGROUP (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    LTYPE varchar(32) NOT NULL COMMENT '所属游戏类型，对应',
    PLAY_TYPE varchar(64) NOT NULL COMMENT '所属玩法类型，对应',
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    STATUS int(2) NOT NULL DEFAULT '0' COMMENT '状态，0不需要审核 1未审核 2审核中 3已审核',
    CREATE_TIME datetime DEFAULT NULL COMMENT '创建时间',
    UPDATE_TIME datetime DEFAULT NULL COMMENT '更新时间',
    USER_ID bigint(20) NOT NULL COMMENT '更新人的数字ID',
    PRIMARY KEY (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金组表';


DROP TABLE IF EXISTS TLT_BONUS;

CREATE TABLE TLT_BONUS (
    ID bigint(20) NOT NULL AUTO_INCREMENT,
    BONUSGROUP_ID bigint(20) NOT NULL COMMENT '所属奖金组，对应TLT_BONUSGROUP.ID',
    LTYPE varchar(32) NOT NULL COMMENT '所属游戏类型，对应',
    PLAY_TYPE varchar(64) NOT NULL COMMENT '所属玩法类型，对应',

    LPG_ID bigint(20) NOT NULL COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
    CN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '中文名称',
    EN_NAME varchar(32) NOT NULL DEFAULT '' COMMENT '英文名称',
    BONUS float(20 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '奖金额',
    BET_NUM int(10) DEFAULT '0' COMMENT '奖金对应投注数',
    TOTAL_MARGIN float(5 , 3 ) DEFAULT '0.000' COMMENT '总利润率',
    STATUS int(1) NOT NULL DEFAULT '0' COMMENT '封锁状态，0禁用 1启用',
    PRIMARY KEY (ID)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金表';


-- --期号管理

DROP TABLE IF EXISTS TLT_ISSUE;
CREATE TABLE TLT_ISSUE (
  ISSUE_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  LTYPE VARCHAR(32) NOT NULL COMMENT '所属彩种，对应TLT_TYPE.LTYPE_ID',
  ISSUE_NO VARCHAR(64) NOT NULL DEFAULT '' COMMENT '期号',
  LOTTERY_NO VARCHAR(64) NOT NULL DEFAULT '' COMMENT '开奖号码',
  ISSUE_DATE  VARCHAR(8) COMMENT '日期YYYYMMDD',
  PRE_STIME  DATETIME COMMENT '预先开始时间(提前开始)',
  PRE_ETIME  DATETIME COMMENT '预先结束时间(提前结束)',
  SALE_STIME DATETIME DEFAULT NULL COMMENT '开始时间',
  SALE_ETIME DATETIME DEFAULT NULL COMMENT '截止时间',

  REAL_STIME DATETIME DEFAULT NULL COMMENT '实际销售开始时间',
  REAL_ETIME DATETIME DEFAULT NULL COMMENT '实际销售截止时间',
  CANCEL_LTIME DATETIME DEFAULT NULL COMMENT '最后撤单时间',
  CLOSESHARE_DATE  DATETIME DEFAULT NULL  COMMENT '领奖截至时间',

  REBATE_STATUS INT(2) DEFAULT '0' COMMENT '返点状态 0未开始 1已开始 2已完成',
  WIN_STATUS INT(2) DEFAULT '0' COMMENT '中奖状态 0未开始 1已开始 2已完成',
  SEND_STATUS INT(2) DEFAULT '0' COMMENT '派奖状态 0未开始 1已开始 2已完成',
  AUTOBET_STATUS INT(2) DEFAULT '0' COMMENT '追号状态 0未开始 1已开始 2已完成',
  LOCK_STATUS INT(2) DEFAULT '0' COMMENT '封锁状态 0未开始 1已开始 2已完成',
  PROCESS_STATUS  INT(2) DEFAULT '0' COMMENT '流程状态（0：未开启，1：在销售，2：暂停，3：开奖完成，奖期截止 ，4：销售截止 ，5：获取开奖公告 ，6：算奖（中奖），7：派奖，8：追号，9：返点）',
  
  CREATE_TIME DATETIME DEFAULT NULL COMMENT '生成时间',
  MODIFY_TIME DATETIME DEFAULT NULL COMMENT '修改时间',
   
  STATUS VARCHAR(1) DEFAULT '1' COMMENT '状态:(1)有效,(0)无效',

  PRIMARY KEY (ISSUE_ID)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='游戏期号表（只保留1个月）';

create index IDX_TLT_ISSUE_ISSUE_NO on TLT_ISSUE
(
   ISSUE_NO
);

DROP TABLE IF EXISTS TLT_ISSUE_HIS;
CREATE TABLE TLT_ISSUE_HIS (
  ISSUE_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  LTYPE VARCHAR(32) NOT NULL COMMENT '所属彩种，对应TLT_TYPE.LTYPE_ID',
  ISSUE_NO VARCHAR(64) NOT NULL DEFAULT '' COMMENT '期号',
  LOTTERY_NO VARCHAR(64) NOT NULL DEFAULT '' COMMENT '开奖号码',
  ISSUE_DATE  VARCHAR(8) COMMENT '日期YYYYMMDD',
  PRE_STIME  DATETIME COMMENT '预先开始时间(提前开始)',
  PRE_ETIME  DATETIME COMMENT '预先结束时间(提前结束)',
  SALE_STIME DATETIME DEFAULT NULL COMMENT '开始时间',
  SALE_ETIME DATETIME DEFAULT NULL COMMENT '截止时间',

  REAL_STIME DATETIME DEFAULT NULL COMMENT '实际销售开始时间',
  REAL_ETIME DATETIME DEFAULT NULL COMMENT '实际销售截止时间',
  CANCEL_LTIME DATETIME DEFAULT NULL COMMENT '最后撤单时间',
  CLOSESHARE_DATE  DATETIME DEFAULT NULL  COMMENT '领奖截至时间',

  REBATE_STATUS INT(2) DEFAULT '0' COMMENT '返点状态 0未开始 1已开始 2已完成',
  WIN_STATUS INT(2) DEFAULT '0' COMMENT '中奖状态 0未开始 1已开始 2已完成',
  SEND_STATUS INT(2) DEFAULT '0' COMMENT '派奖状态 0未开始 1已开始 2已完成',
  AUTOBET_STATUS INT(2) DEFAULT '0' COMMENT '追号状态 0未开始 1已开始 2已完成',
  LOCK_STATUS INT(2) DEFAULT '0' COMMENT '封锁状态 0未开始 1已开始 2已完成',
  PROCESS_STATUS  INT(2) DEFAULT '0' COMMENT '流程状态（0：未开启，1：在销售，2：暂停，3：开奖完成，奖期截止 ，4：销售截止 ，5：获取开奖公告 ，6：算奖（中奖），7：派奖，8：追号，9：返点）',
  
  CREATE_TIME DATETIME DEFAULT NULL COMMENT '生成时间',
  MODIFY_TIME DATETIME DEFAULT NULL COMMENT '修改时间',
   
  STATUS VARCHAR(1) DEFAULT '1' COMMENT '状态:(1)有效,(0)无效',

  PRIMARY KEY (ISSUE_ID)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='游戏期号历史表';

create index IDX_TLT_ISSUE_HIS_ISSUE_NO on TLT_ISSUE_HIS
(
   ISSUE_NO
);

DROP TABLE IF EXISTS TLT_ISSUE_GEN_PARAMS;

CREATE TABLE TLT_ISSUE_GEN_PARAMS (
  GEN_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
  LTYPE VARCHAR(32) NOT NULL COMMENT '所属彩种，对应TLT_TYPE.LTYPE_ID',
  SALE_STIME VARCHAR(20) DEFAULT NULL COMMENT '销售开始时间 YYYYMMDDHHmmss',
  SALE_ETIME VARCHAR(20) DEFAULT NULL COMMENT '销售截止时间 YYYYMMDDHHmmss',
  SALE_FI_ETIME VARCHAR(20) DEFAULT NULL COMMENT '第一期销售截止时间，FI即FIRST ISSUE',
  SALE_CYCLE INT(4) DEFAULT '0' COMMENT '销售周期，秒',
  WAIT_RL_DUR INT(4) DEFAULT '0' COMMENT '等待开奖时长，秒',
  CANCEL_DUR INT(4) DEFAULT '0' COMMENT '撤单限制时长，秒',
  INPUT_DUR INT(4) DEFAULT '0' COMMENT '录入时长，秒',
  SORT TINYINT(4) NOT NULL DEFAULT '0' COMMENT '排序，一般显示用',
  ENABLE TINYINT(1) NOT NULL DEFAULT '0' COMMENT '0无效 1有效',
  PRIMARY KEY (GEN_ID)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='期号时间设置表，是批量生成期号的基础';



-- -- -投注管理-- -- -- -- -- -- -- -- -- -- -- -- -- --

DROP TABLE  IF EXISTS TLT_CORE_BET;

CREATE TABLE TLT_CORE_BET
(
   TICK_NO              VARCHAR(64) NOT NULL COMMENT '票编码UUID',
   LTYPE                VARCHAR(32) NOT NULL COMMENT '游戏代码',
   LNAME                VARCHAR(128) NOT NULL  COMMENT '投注玩法名称', 
   PLAY_TYPE            VARCHAR(64) NOT NULL  COMMENT '投注玩法代号', 
   MERCHANTID           VARCHAR(64) NOT NULL COMMENT '商户编号',
   SERIAL_NUM           VARCHAR(64) COMMENT '彩票序列号,票编码-MD5(LTYPE+PLAYTYPE+MERCHANTID+USERID,UUID)',
   
   BET_AMOUNTS          NUMERIC(24,6) COMMENT '投注总金额',
   BET_COUNTS           DECIMAL(8,0) NOT NULL COMMENT '总注数',
   BET_MULTI            DECIMAL(5,0) NOT NULL COMMENT '投注倍数',
   ISSUE_NO             VARCHAR(64) NOT NULL COMMENT '期号',   
   BET_DATETIME         DATETIME NOT NULL COMMENT '创建时间',
   BET_CONTENT          VARCHAR(512) COMMENT '投注数据',
   BET_IP 				varchar(20) 	DEFAULT '' COMMENT '投注IP',
   BET_MONEY_UNIT 		int(2) NOT NULL DEFAULT '1' COMMENT '模式，1元 2角 3分 4厘',

   BONUS_MONEY_MODE			DECIMAL(16,4) NOT NULL COMMENT '奖金模式',
   BONUS_RATE_MODE			DECIMAL(16,4) NOT NULL COMMENT '奖金模式比例',
   VERSION              VARCHAR(16) COMMENT '版本号',
   PRINTTIME            DECIMAL(16,0) COMMENT '出票时间,异步投注使用',
   BET_STATUS           DECIMAL(4,0) NOT NULL DEFAULT '0' COMMENT '投注状态(0:等待追号， 1出票成功，2出票失败，3消票撤单)',
   NOTIFYSTATUS         NUMERIC(1,0) COMMENT '通知票状态(0 失败,1 成功),异步投注使用',
   REGION               VARCHAR(16)  COMMENT '区域',
   FAILREASON           VARCHAR(64) COMMENT '失败原因',

   MERCHANTUSERID       VARCHAR(128) COMMENT '第三方用户ID',
   USER_ID              VARCHAR(128) COMMENT '本地用户编号',
   AUTOBET_NO           varchar(32) COMMENT '追号编号，由后台生成',
   IS_AUTO				varchar(1) NOT NULL DEFAULT '0' COMMENT '是否追号生成(0:否，1：是追号)',
   AUTO_REF_TICKNO		varchar(32) COMMENT '追号关联单的编号',
   PRIMARY KEY (TICK_NO)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='投注单表';

CREATE INDEX INX_T_CORE_TO_LTYPE_PTYPE ON TLT_CORE_BET
(
   LTYPE,PLAY_TYPE
);

CREATE INDEX INX_T_CORE_TO_SERIALNUM ON TLT_CORE_BET
(
   SERIAL_NUM
);
CREATE INDEX INX_T_CORE_TO_ISSUE_NO ON TLT_CORE_BET
(
   ISSUE_NO
);


DROP TABLE IF EXISTS TLT_BET_AUTO;

CREATE TABLE TLT_BET_AUTO (
  AUTOBET_NO VARCHAR(64) NOT NULL COMMENT '追号编号，由后台生成',
  USER_ID VARCHAR(64) NOT NULL COMMENT '追号用户ID',
   LTYPE                VARCHAR(32) NOT NULL COMMENT '游戏代码',
   LNAME                VARCHAR(128) NOT NULL  COMMENT '投注玩法名称', 
   PLAY_TYPE             VARCHAR(64) NOT NULL  COMMENT '投注玩法代号', 
  LPG_ID VARCHAR(8) COMMENT '所属玩法组，对应TLT_PLAYGROUP.ID',
  LP_ID VARCHAR(8) COMMENT '所属玩法，对应TLT_PLAY.ID',
  CREATE_TIME DATETIME NOT NULL COMMENT '追号时间',
  START_ISSUE VARCHAR(16) NOT NULL COMMENT '开始期号',
  ISSUE_NUM INT(11) NOT NULL DEFAULT '0' COMMENT '追号期数',
  TOTAL_BET_AMOUNTS          NUMERIC(24,6) COMMENT '投注总金额',
  TOTAL_BET_COUNTS           DECIMAL(8,0) NOT NULL COMMENT '总注数',

  COMPLETE_NUM INT(11) NOT NULL DEFAULT '0' COMMENT '完成期数',
  CANCEL_NUM INT(11) NOT NULL DEFAULT '0' COMMENT '取消期数',
  BET_NUM INT(11) NOT NULL DEFAULT '0' COMMENT '投注注数',
  BET_DATA VARCHAR(128) NOT NULL COMMENT '投注号码,格式(1,2,3,4.4,3,2,1.5,7,8,9),每注之间用.分隔,每注中的号码用,分隔',
  BET_COINS FLOAT(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '追号总金额',
  COMPLETE_COINS FLOAT(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '完成金额',
  CANCEL_COINS FLOAT(10 , 4 ) NOT NULL DEFAULT '0.0000' COMMENT '取消金额',
  MODE INT(2) NOT NULL DEFAULT '1' COMMENT '模式，1元 2角 3分 4厘',
  TIMES INT(11) NOT NULL DEFAULT '1' COMMENT '倍数',
  WIN_STOP INT(2) DEFAULT '0' COMMENT '是否中奖即停 0否 1是',
  STATUS INT(2) NOT NULL DEFAULT '0' COMMENT '追号状态 0进行中 1已完成 2已取消',
  BET_NO VARCHAR(32) DEFAULT NULL COMMENT '投注编号，由后台生成',
  PRIMARY KEY (AUTOBET_NO)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='追号表';

-- -限号表-- --
DROP TABLE IF EXISTS TLT_LIMITED_FEATURE;

CREATE TABLE TLT_LIMITED_FEATURE
(
   CASKEY               VARCHAR(256) NOT NULL COMMENT '商户编号(MERCHANTID)-游戏类型(LTYPE)-期号(PERIOD)-批次ID(BATCHID)/MESSAGEID-',
   ISSUE_NO             VARCHAR(32) COMMENT '期号',
   PLAY_TYPE            VARCHAR(64) COMMENT '投注玩法',
   WAGERDATA            VARCHAR(512) COMMENT '投注号码（多注以逗号分隔）',
   CREATEDATE           DECIMAL(16,0) DEFAULT NULL COMMENT '创建时间(默认为当前系统时间)',
   REGION               VARCHAR(16) NOT NULL COMMENT '区域编码',
   LTYPE                VARCHAR(8) NOT NULL COMMENT '游戏代码',
   BONUS_LIMIT			DECIMAL(16,5) COMMENT '限制中奖最大金额',
   BETS_BOARDS_LIMIT	DECIMAL(16,0) COMMENT '限制投注数量',
   BETS_AMOUNT_LIMIT	DECIMAL(16,0) COMMENT '限制投注金额',
   MERCHATID			VARCHAR(64)	 COMMENT '限制商户号',
   USER_ID				VARCHAR(64)	 COMMENT '限制个人',
   LIMIT_TYPE			VARCHAR(16)  COMMENT '限号规则：一共4位，分别（限制中奖最大金额，投注数量，投注金额，商户编号，用户编号)，例如0100000',
   START_DATE			DATETIME	COMMENT '开始时间',
   EXTRAFIELD1          VARCHAR(16) COMMENT '备用字段1',
   EXTRAFIELD2          VARCHAR(64) COMMENT '备用字段2',
   EXTRAFIELD3          INT COMMENT '备用字段3',
   EXTRAFIELD4          DECIMAL(16,5) COMMENT '备用字段4',
   EXTRAFIELD5          DECIMAL(16,0) COMMENT '备用字段5',
   PRIMARY KEY (CASKEY, REGION)
) ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='限号特征库表';

CREATE INDEX INX_TLT_LIMITED_NUM_ISSUE_NO ON TLT_LIMITED_FEATURE
(
   PLAY_TYPE,LTYPE,ISSUE_NO
);

DROP TABLE IF EXISTS TLT_LIMITED_NUM;

CREATE TABLE TLT_LIMITED_NUM
(
   UUID                 VARCHAR(64) NOT NULL COMMENT '序号',
   ISSUE_NO             VARCHAR(64) COMMENT '投注期号',
   LIMITED_NUM          VARCHAR(20) COMMENT '限号号码',
   LTYPE          		VARCHAR(20) COMMENT '限号游戏类型',
   PLAY_TYPE          	VARCHAR(20) COMMENT '限号玩法',
   EXTRAFIELD1          VARCHAR(16) COMMENT '备用字段1',
   EXTRAFIELD2          VARCHAR(64) COMMENT '备用字段2',
   EXTRAFIELD3          INT COMMENT '备用字段3',
   EXTRAFIELD4          DECIMAL(16,5) COMMENT '备用字段4',
   EXTRAFIELD5          DECIMAL(16,0) COMMENT '备用字段5',
   PRIMARY KEY (UUID)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8 COMMENT='限号表(实时产生，用于内存控制)';


CREATE INDEX INX_TLT_LIMITED_NUM_ISSUE_NO ON TLT_LIMITED_NUM
(
   ISSUE_NO
);

CREATE INDEX INX_TLT_LIMITED_NUM_PLAY_TYPE ON TLT_LIMITED_NUM
(
   PLAY_TYPE
);




