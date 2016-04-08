
use msb;

/*内管系统表*/
insert  into `T_SYS_ACTION`(`ACTION_ID`,`ACTION_FLAG`,`ACTION_NAME`,`ACTION_DESC`,`ACTION_MENU`,`FIELD1`) values (1,'mchntaudit','商户审批按钮','商户审批',7,'商户审批'),(2,'channelaudit','渠道审批按钮','渠道审批',9,'渠道审批'),(3,'addmchnt','添加商户按钮','添加商户按钮',6,'添加商户按钮'),(4,'addproduct','添加产品按钮','添加产品按钮',10,'添加产品按钮'),(5,'addchannel','添加渠道按钮','添加渠道按钮',8,'添加渠道按钮'),(222,'productaudit','产品审批按钮','产品审批',11,'产品审批');
insert  into `T_SYS_MENU`(`MENU_ID`,`MENU_NAME`,`MENU_DESC`,`MENU_SEQ`,`MENU_URL`,`PARENT_ID`,`LEAF_FLAG`,`LEVEL`,`ICON`) values (1,'商户管理','商户管理',1,'',0,0,0,'0'),(2,'产品渠道管理','产品渠道管理',2,'',0,0,0,'0'),(3,'交易管理','交易管理',3,'',0,0,0,'0'),(4,'差错对账管理','差错对账管理',4,'',0,0,0,'0'),(5,'系统管理','系统管理',5,'',0,0,0,'0'),(6,'结算管理','结算管理',6,'',0,0,0,'0'),(7,'客户管理','客户管理',7,'',0,0,0,'0'),(8,'监控管理','监控管理',8,'',0,0,0,'0'),(9,'用户管理','系统管理-用户管理',9,'admin/users.html',5,1,1,'1'),(10,'角色管理','系统管理-角色管理',10,'admin/role.html',5,1,1,'1'),(11,'菜单管理','系统管理-菜单管理',11,'admin/menu.html',5,1,1,'1'),(12,'权限管理','系统管理-权限管理',12,'admin/action.html',5,1,1,'1'),(13,'刷新缓存','系统管理-刷新缓存',13,'admin/refreshRam.html',5,1,1,'1'),(14,'用户角色管理','系统管理-用户角色管理',14,'admin/userrole.html',5,1,1,'1'),(15,'角色菜单管理','系统管理-角色菜单管理',15,'admin/rolemenu.html',5,1,1,'1'),(16,'角色权限管理','系统管理-角色权限管理',16,'admin/roleaction.html',5,1,1,'1'),(17,'商户维护','商户管理-商户维护',17,'pages/mchnt/ops.html',1,1,1,'1'),(18,'商户产品维护','商户管理-商户产品维护',18,'pages/mchnt/mchntprodops.html',1,1,1,'1'),(19,'商户结算账户维护','商户管理-商户结算账户维护',19,'pages/mchnt/mchntacctops.html',1,1,1,'1'),(20,'商户手续费维护','商户管理-商户手续费维护',20,'pages/mchnt/mchntfeeops.html',1,1,1,'1'),(21,'商户审批','商户管理-商户审批',21,'pages/mchnt/audit.html',1,1,1,'1'),(22,'渠道维护','产品渠道管理-渠道维护',22,'pages/land/channel.html',2,1,1,'1'),(23,'渠道审批','产品渠道管理-渠道审批',23,'pages/land/channelaudit.html',2,1,1,'1'),(24,'产品维护','产品渠道管理-产品维护',24,'pages/land/product.html',2,1,1,'1'),(25,'产品审批','产品渠道管理-产品审批',25,'pages/land/productaudit.html',2,1,1,'1'),(26,'产品手续费维护','产品渠道管理-产品手续费维护',26,'pages/land/prodfeeops.html',2,1,1,'1'),(27,'渠道产品维护','产品渠道管理-渠道产品维护',27,'pages/land/channelprodops.html',2,1,1,'1'),(28,'外部产品维护','产品渠道管理-外部产品维护',28,'pages/land/prodquery.html',2,1,1,'1'),(29,'开户查询','交易管理-开户查询',29,'pages/front/frontdigacctinf.html',3,1,1,'1'),(30,'建账查询','交易管理-建账查询',30,'pages/front/frontuserprodacct.html',3,1,1,'1'),(31,'申购交易','交易管理-申购交易',31,'pages/trade/tr101.html',3,1,1,'1'),(32,'赎回交易','交易管理-赎回交易',32,'pages/trade/tr102.html',3,1,1,'1'),(33,'失败通知','交易管理-失败通知',33,'pages/trade/transerrinf.html',3,1,1,'1'),(34,'商户结算','结算管理-商户结算',34,'pages/settle/settmchntbalance.html',6,1,1,'1'),(35,'产品渠道结算','结算管理-产品渠道结算',35,'pages/settle/settprodchnbalance.html',6,1,1,'1'),(36,'平台损益','结算管理-平台损益',36,'pages/settle/settsydaily.html',6,1,1,'1'),(37,'差错审核','差错对账管理-差错审核',37,'pages/settle/erroraudit.html',4,1,1,'1'),(38,'差错经办','差错对账管理-差错经办',38,'pages/settle/errorops.html',4,1,1,'1'),(39,'日终监控','差错对账管理-日终监控',39,'pages/settle/setttaskrun.html',4,1,1,'1'),(40,'用户信息','客户管理-用户信息',40,'pages/front/frontmchuserinf.html',7,1,1,'1'),(41,'用户收益','客户管理-用户收益',41,'pages/front/settuserproddetails.html',7,1,1,'1'),(42,'交易量统计曲线图','监控管理-交易量统计曲线图',42,'pages/monitor/graph1.html',8,1,1,'1'),(43,'当月交易量统计','监控管理-当月交易量统计',43,'pages/monitor/graph2.html',8,1,1,'1'),(44,'当日商户交易量组成分析','监控管理-当日商户交易量组成分析',44,'pages/monitor/graph3.html',8,1,1,'1'),(45,'按月统计成功、失败交易量','监控管理-按月统计成功、失败交易量',45,'pages/monitor/graph4.html',8,1,1,'1'),(46,'实时交易成功率统计','监控管理-实时交易成功率统计',46,'pages/monitor/graph5.html',8,1,1,'1'),(47,'商户交易量','监控管理-商户交易量',47,'pages/monitor/graph6.html',8,1,1,'1'),(48,'商户业务增长率','监控管理-商户业务增长率',48,'pages/monitor/graph7.html',8,1,1,'1'),(49,'公共参数','1',49,'admin/sysinfo.html',5,1,1,'1'),(50,'电子账户收益','客户管理-电子账户收益',50,'pages/front/settlandacctdetails.html',7,1,1,'1'),(51,'节假日维护','系统管理-节假日维护',51,'admin/festivalOps.html',5,1,1,'1'),(52,'下一个工作日查询','系统管理-下一个工作日查询',52,'admin/nexttradedatequery.html',5,1,1,'1'),(53,'日终回滚申请','差错对账管理-日终重做申请',53,'pages/settle/settretask.html',4,1,1,'1'),(54,'日终回滚审批','差错对账管理-日终回滚审批',54,'pages/settle/settretaskaudit.html',4,1,1,'1');
insert  into `T_SYS_ROLE`(`ROLE_ID`,`ROLE_NAME`,`ROLE_DESC`,`STATUS`) values ('111','系统管理员','系统管理员',1);
insert  into `T_SYS_ROLE_MENU`(`ID`,`MENU_ID`,`ROLE_ID`,`STATUS`) values ('1SAbpQmjac27zgANOrRPr7l7DyB4BXH7',31,'111',1),('1WG3vzeOzZ19Ve3KIWvYbiTzPybI1qLX',29,'111',1),('1ZbiLOohTaepseliEqrknjSVGnZCqinF',25,'111',1),('3IBQgwtyziIMO8Z0MXC8zh1HnNYKffXm',13,'111',1),('5A9ptxIYCpbUMIutee1jiXmIKSzGCKCN',39,'111',1),('5lA2DE7RJg848T60CBMehEzXuppckCCx',44,'111',1),('6tKUInHUisvqQ1wFJ2MoCi1ZVZXdy4Bg',50,'111',1),('7vLAKEbMV1tsI3lkDR0EZ8pMEdwlSCuA',36,'111',1),('8Vk4i9BOBZlsPNU7uwT5pNitKlzyCDkz',17,'111',1),('9SaqkgvkGa6wlyC0tDxMgRWG8qTkQvTS',5,'111',1),('A2BVFh96wead9388Iz2abc7IGW4wJhEV',45,'111',1),('AfO3J4hvUzgTKeGZxpBiIIwe8PMcOOU1',15,'111',1),('akBxHwZgzNGQEYWyKsmzRTLn8ZJ63nkN',54,'111',1),('Ba52Mq6zAE7vRJxC6DQr1VjxyXecF87I',10,'111',1),('BaTBaiQxjaqzwopzyJqSdUMSp70n3gI3',2,'111',1),('DduxwGcj9ZpMBdxaXnGGrLn4FAJuAofh',22,'111',1),('eKW48FVI4YW6OpDGGwsAz8mCwtoRYx7u',16,'111',1),('fnFv8ZthLjRr7iC6BUOHnUVV8ARIBRZT',41,'111',1),('HkODJZVxEcAU8nD4xAE2yFwBd34FGgWH',20,'111',1),('hVskPp0SOa6W6BrjoikN9P1R77T31mvW',24,'111',1),('iskIvUJBwzKCln2DTajLEO8Ivcasdtri',37,'111',1),('iTMlKw1MZ3LE6mKrTPn6KL7Fijm4T1lB',14,'111',1),('iud2WTzn24hSitm3U54Rz2DXJqLjk7UD',32,'111',1),('jd6mMwE5QQAdt1lDqWqnWqDj0CO2GxqM',30,'111',1),('KAKIVNhLqwoCl4dsE0HyamzZLXMy5nEY',23,'111',1),('Lbn9grTGvanxR0slHXj8nH8T8hB76wC4',34,'111',1),('LFugVUldn0kjWQcmtmAPrgUP2MCsSmTt',12,'111',1),('m2iysiRZMD6MSZJhQO9FIZUvrt2OAbzs',4,'111',1),('nwcGSBDXGOeQ6Df68qXCDCAIkwXsb3Ii',9,'111',1),('nxAcY1X9lKC7XruKabie9j2gc92gIJK0',7,'111',1),('oPLPQ8ToDUCYticlx6EvjZP2irTw5PCw',26,'111',1),('pnNoKTbfqMVn2VIHCS3amNWFTqzRshuu',18,'111',1),('PUtBHZPynanUEQ3DUH1RWpg9QSPdMQzC',48,'111',1),('pyWzuO10VRShUoWzFKcS8AV6y1ZpUQUt',40,'111',1),('QKO9zPGtVIjhNPl09b3ZI5PSNd1h5pWA',49,'111',1),('QLs6nL0SWLxfGVRTIPnBNzmqZbfviNm1',19,'111',1),('s8FaTT3mgPc8TwrIRXeTb9zBBymbqCWN',1,'111',1),('sdJBUmbmprSjv0BtVsTjljRcuwEekFyt',52,'111',1),('TbLFgvo3f5rUkZCPCMlKwcNC5ZwCakRD',42,'111',1),('TdIxVIKpwovUkdTTc1rk6KdQfNJKsL1x',53,'111',1),('TvaQtF7Kv5IsyxPn1SyXpS2ktlPjJM9k',46,'111',1),('UltdSvlNyfCyBXK9URkAoZChIPN5D8wQ',43,'111',1),('Up1qxbcq19KCpKpepajGL6yVY6LG1Qrf',47,'111',1),('uRtnh2DTvrGhVDWEcekD80NMEx6dzL9M',11,'111',1),('W1ba9KbdmpOKWvlyhX6VT2hezwtPYcm9',51,'111',1),('Wvs1eicIJziQJiDutnUo3Fx2RcsTquQW',8,'111',1),('x72qB8W1lfTlFJA6lz9UCwyMMQC5Fm8R',27,'111',1),('xUtkZVEKngGhKQznj7B1O4lqp0EsMyMg',3,'111',1),('YqD7Muo6qHtkLN3k0nh9ONV9IttAj1Rr',6,'111',1),('Yw2iEo7QwXZR9RXNiLdbnFDRdc1BPDKt',21,'111',1),('ZGfoFdyTtW1c9Y3bvfZs2tXzAfRAVEVO',35,'111',1),('zt5DjRMyeN4oI0aQjN6MtV34k27DlcuB',33,'111',1),('Zw2GyJDjFzf2gY8Wb0EF2wle3JanGZzZ',28,'111',1);
insert  into `T_SYS_ROLE_ACTION`(`ID`,`ACTION_ID`,`ROLE_ID`,`STATUS`) values ('9XHJSMtBJlhtJ0bGoZIJkBmbD66voh2D',7,'111',1),('CgJYRTGghpY33yB9HiaOJaUIz59NHJjX',4,'111',1),('cV4Q3RESFXcgwZhO29rPqqRpvB20KsEF',1,'111',1),('DFQLqjXk2MNAIFZ18btEIqOtGjTfvTDM',2,'111',1),('NpVurOVUwTudLGCugywhJwUZYK8QxEvv',9,'111',1),('pHpA1sNKiLZkZgCre7Xp0sn8iTrtDBEV',222,'111',1),('RIqmjUsvLYWsSNwB4hDwWIdXbhfIOU4M',3,'111',1),('u5oz8ZAk6i6daOeyd5AVAYsCnz2PyXZu',5,'111',1),('V24RPjal899yAMX4UJjEvl5pUbdkYjZw',8,'111',1),('WTnxsCl2ZG9TYmbky71elCYy17FLefvQ',11,'111',1),('yrL9hTpJKorCKXJGJcS4BmDzQEX3vCvj',10,'111',1),('ZvqCgYOT6OsKdWZzrfJFzCQD136AaStP',6,'111',1);
insert  into `T_SYS_USER`(`USER_ID`,`BRANCH_ID`,`LOGIN_NAME`,`USER_NAME`,`MOBILE`,`USER_WORKADDRESS`,`STATUS`,`PASSWORD`,`UPDATE_TIME`,`CREATE_TIME`,`CREATED_BY`,`MODIFIED_BY`,`EMAIL`,`DATA_ENVIRON`,`ICON`) values ('11',NULL,'admin','admin','24234324324',NULL,'00','e10adc3949ba59abbe56e057f20f883e',NULL,'2015-04-13 17:34:29',NULL,NULL,'asdf@2.com',111,'');
insert  into `T_SYS_USER_ROLE`(`USER_ROLE_ID`,`ROLE_ID`,`USER_ID`,`STATUS`) values ('e0216021-4bbc-4079-afbf-c5d92912a033','111','11',1);

/*日终任务*/
insert into  T_SYS_PARAM  values('password',NULL,'634241',NULL,NULL,NULL,NULL,NULL);
insert into  T_SYS_PARAM  values('runCount',NULL,'3',NULL,NULL,NULL,NULL,NULL);
insert into  T_SYS_PARAM  values('rybDownLoadPath',NULL,'/var/ofish/conf/settle/',NULL,NULL,NULL,NULL,NULL);
insert into  T_SYS_PARAM  values('shellPath',NULL,'/var/ofish/conf/settle/bin/diffBatch.sh',NULL,NULL,NULL,NULL,NULL);
insert into  T_SYS_PARAM  values('sn',NULL,'DXX-BBX-10C-20384',NULL,NULL,NULL,NULL,NULL);

--INSERT INTO T_SYS_RSP_CODE VALUES ('1', '001001', 'AAAAAAA', '0000', '接收成功');
--INSERT INTO T_SYS_RSP_CODE VALUES ('2', '001001', 'EMG0000001', '0001', '请求明文串为空');
--INSERT INTO T_SYS_RSP_CODE VALUES ('3', '001001', 'E999999997', '1010', '手机号码格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('4', '001001', 'EMG0000004', '1011', '交易码错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('5', '001001', 'E999999997', '1012', '客户中文姓名格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('6', '001001', 'EMG0000002', '0013', '报文版本号码有误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('7', '001001', 'E999999997', '1014', '客户证件类型格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('8', '001001', 'E999999997', '1015', '客户证件格式错误或者客户未满18岁');
--INSERT INTO T_SYS_RSP_CODE VALUES ('9', '001001', 'E999999997', '1016', '地址格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('10', '001001', 'E999999997', '1017', '邮政编码格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('11', '001001', 'E999999997', '1018', '固定电话格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('12', '001001', 'E999999997', '1019', '性别格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('13', '001001', 'E999999997', '1020', '生日格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('14', '001001', 'E999999997', '1021', '国籍格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('15', '001001', 'E999999997', '1022', '职业格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('16', '001001', 'E999999997', '1023', '备注格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('17', '001001', 'E999999997', '1024', '产品类型格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('18', '001001', 'E999999997', '1025', '产品代码格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('19', '001001', 'E999999997', '1028', '邮件地址校验失败');
--INSERT INTO T_SYS_RSP_CODE VALUES ('20', '001001', 'E999999997', '1102', '账户格式不对');
--INSERT INTO T_SYS_RSP_CODE VALUES ('21', '001001', 'E999999997', '1103', '申购金额不对');
--INSERT INTO T_SYS_RSP_CODE VALUES ('22', '001001', 'E999999997', '1104', '手续费不对');
--INSERT INTO T_SYS_RSP_CODE VALUES ('23', '001001', 'E999999997', '1105', '客户号不正确');
--INSERT INTO T_SYS_RSP_CODE VALUES ('24', '001001', 'FP00007', '1106', '尚未开户');
--INSERT INTO T_SYS_RSP_CODE VALUES ('25', '001001', 'E999999997', '1100', '记录ID格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('26', '001001', 'FP00006', '1101', '记录ID重复');
--INSERT INTO T_SYS_RSP_CODE VALUES ('27', '001001', 'E999999997', '0016', '机构标识为空');
--INSERT INTO T_SYS_RSP_CODE VALUES ('28', '001001', 'E999999997', '0017', '交易日期格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('29', '001001', 'E999999997', '1029', '子产品代码格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('30', '001001', 'FP00070', '2002', '电子卡号不属于该客户');
--INSERT INTO T_SYS_RSP_CODE VALUES ('31', '001001', 'FP00070', '2003', '电子卡号不属于该客户');
--INSERT INTO T_SYS_RSP_CODE VALUES ('32', '001001', 'FP0LPR9999', '2004', '用户赎回额度大于余额');
--INSERT INTO T_SYS_RSP_CODE VALUES ('33', '001001', 'EMG0000001', '0001', '请求明文串为空');
--INSERT INTO T_SYS_RSP_CODE VALUES ('34', '001001', 'EMG0000020', '0005', '流水号格式错误');
--INSERT INTO T_SYS_RSP_CODE VALUES ('35', '001001', 'E999999997', '1108', '文件不存在');
--



