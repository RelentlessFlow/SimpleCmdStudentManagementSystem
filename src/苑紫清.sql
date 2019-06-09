CREATE  DATABASE IF NOT EXISTS db_subway DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE db_subway;
DROP DATABASE IF EXISTS db_subway;
CREATE  DATABASE IF NOT EXISTS db_subway;
SHOW ENGINES;
USE db_subway;
CREATE TABLE passenger(
    p_id char(20) NOT NULL COMMENT '乘客身份证',
    p_name varchar(20) NOT NULL COMMENT '乘客姓名',
    p_sex char(2) NOT NULL COMMENT '乘客性别',
    p_address varchar(50) NOT NULL COMMENT '乘客籍贯',
    p_nationality varchar(20) NOT NULL COMMENT '国籍',
    PRIMARY KEY (p_id)
)ENGINE=InnoDB DEFAULT CHARSET = gbk;

INSERT INTO `passenger` VALUE ('110102200101010815','张伟','男','北京','中国');
INSERT INTO `passenger` VALUE ('120102199801017598','王伟','男','天津','中国');
INSERT INTO `passenger` VALUE ('130102198801012598','王芳','男','河北石家庄','中国');
INSERT INTO `passenger` VALUE ('130102200101010815','李伟','男','河北石家庄','中国');
INSERT INTO `passenger` VALUE ('221010220010101815','王秀英','女','辽宁沈阳','中国');
INSERT INTO `passenger` VALUE ('210102201101010815','李娜','女','辽宁大连','中国');
INSERT INTO `passenger` VALUE ('120102200101010815','王秀英','女','天津','中国');
UPDATE passenger SET p_address = '河北唐山' WHERE p_id='130102200101010815';

CREATE TABLE train(
    t_id char(10) NOT NULL COMMENT '车次',
    t_start varchar(10) NOT NULL COMMENT '始发站',
    t_final varchar(10) NOT NULL COMMENT '终点站',
    t_start_time varchar(10) NOT NULL COMMENT '开车时间',
    t_final_time varchar(10)NOT NULL COMMENT '到达时间',
    t_final_time_start_time varchar(10) NOT NULL COMMENT '到达站发车时间',
    t_final_time_start_station varchar(10) NOT NULL COMMENT '到达站发车站点',
    PRIMARY KEY (t_id)
)ENGINE=InnoDB DEFAULT CHARSET = gbk;

INSERT INTO train
    VALUE
    ('D1', '北京', '沈阳北', '10:43', '当天18:31', '14:08', '北京'),
    ('K3', '佳木斯','北京','10:02', '第2日13:00', '13:00', '北京'),
    ('T63', '北京', '北京', '19:57', '当天----', '19:57', '合肥'),
    ('Z84', '齐齐哈尔', '北京', '18:23', '第2日08:24', '08:24', '北京');

CREATE TABLE ticket(
    t_id char(10) NOT NULL COMMENT '车次',
    p_id char(20) NOT NULL COMMENT '车票旅客身份证',
    t_t_id varchar(100) NOT NULL COMMENT '车票编号',
    t_start varchar(10) NOT NULL COMMENT '始发站',
    t_final varchar(10) NOT NULL COMMENT '终点站',
    t_size varchar(10) NOT NULL COMMENT '车票价格',
    t_type varchar(10) NOT NULL COMMENT '车票类型',
    KEY(`p_id`),
    KEY (`t_t_id`)
)ENGINE=InnoDB DEFAULT CHARSET = gbk;

INSERT INTO ticket
VALUE
('D1','110102200101010815','IDENTITY(1,1)','河北石家庄','河北秦皇岛','267','动车'),
('K3','120102199801017598','IDENTITY(1,1)','长春','北京','320','快车'),
('T63','130102198801012598','IDENTITY(1,1)','北京','合肥','411','特快'),
('Z84','130102200101010815','IDENTITY(1,1)','河北石家庄','河北唐山','301','快车'),
('D1','221010220010101815','IDENTITY(1,1)','北京','河北秦皇岛','267','动车'),
('D1','210102201101010815','IDENTITY(1,1)','河北','上海','267','动车'),
('Z84','120102200101010815','IDENTITY(1,1)','长春','北京','320','快车');

/* （删除记录） 从乘客表中删除身份证号为 130102200101010815的乘客*/
DELETE FROM passenger WHERE p_id='130102200101010815';

/* (删除字段) 从乘客表中删除火车类型这一字段 */
ALTER TABLE ticket DROP t_type;

/*(修改字段数据类型,把火车表的开车站的字段的数据类型改为varchar，长度为20 )   */
ALTER TABLE train MODIFY  t_start varchar(20);

/* 查询所有成绩表中王姓的人 */
SELECT * FROM passenger WHERE LEFT(p_name,1) = '王';

/* 统计姓王的有多少人 */
SELECT COUNT(*) as '姓王的人数' FROM passenger WHERE LEFT(p_name,1) = '王';

/*  籍贯在河北石家庄并且姓王的  */
SELECT * FROM passenger WHERE LEFT(p_name,1) = '王' AND p_address = '河北石家庄';

/*  按价格降序排列车次和价格信息 */
SELECT t_id as '车次',t_size as '价格' FROM ticket ORDER BY t_size desc;
/*显示乘客身份证，姓名，性别，起始站和终点站*/
SELECT passenger.p_id,p_name,p_sex,t_start,t_final
from passenger,ticket
where passenger.p_id=ticket.p_id;

# 多表联查
/* 查询从石家庄出发的乘客的名字*/
SELECT p_name FROM passenger,ticket  WHERE passenger.p_id=ticket.p_id AND ticket.t_start = "河北石家庄";

# 三表联查
/* 查询从张伟做的这帮火车的终点站*/
SELECT train.t_final_time_start_station FROM passenger,ticket,train
WHERE passenger.p_name="张伟" AND ticket.t_id=train.t_id AND passenger.p_id = ticket.p_id;

# 建立视图
# 查询姓王的乘客并放入视图中
CREATE VIEW view1 AS SELECT * FROM passenger WHERE p_name LIKE "王%";



