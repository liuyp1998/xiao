   select * from  XDL_USER where 1=2;
   drop  table  xdl_user  cascade constraints; 
   create table XDL_USER  (
   USER_ID              NUMBER   constraint xdl_user_user_id_pk primary key,
   LOGIN_NAME           VARCHAR2(50) constraint xdl_user_login_name_uk unique,
   NICK_NAME            VARCHAR2(50),
   REAL_NAME            VARCHAR2(50),
   GRADE_ID             NUMBER,
   PASSWORD             VARCHAR2(50),
   EMAIL                VARCHAR2(50),
   RECOMMENDER          VARCHAR2(50),
   SEX                  VARCHAR2(2),
   PROVINCE             VARCHAR2(100),
   BIRTH                DATE,
   SCHOOL               VARCHAR2(100),
   COMPANY              VARCHAR2(50),
   CARD_NUMBER          VARCHAR2(50),
   MOBILE               VARCHAR2(50),
   PHONE                VARCHAR2(50),
   MSN                  VARCHAR2(50),
   QQ                   VARCHAR2(50),
   WEBSITE              VARCHAR2(100),
   SEND_ADDRESS         VARCHAR2(100),
   ZIPCODE              VARCHAR2(50),
   HOBBY                VARCHAR2(100),
   LAST_LOGIN_TIME      DATE,
   LAST_LOGIN_IP        VARCHAR2(50),
   HEAD_PIC             VARCHAR2(50),
   AREA                 VARCHAR2(100)
); 
/* 建立对应的序列   建立之前先删除 */
  drop   sequence  xdl_user_user_id_seq;
  create sequence  xdl_user_user_id_seq;
  
 /** 分类表相关 */
  drop  table  xdl_category cascade constraints;
  create table  xdl_category(
      category_id    number   constraint  xdl_category_category_id_pk primary key,
      name   varchar2(50),
      turn   number,
      description varchar2(100),
      parent_id   number
  );
  drop  sequence  xdl_category_category_id_seq;
  create   sequence  xdl_category_category_id_seq;
  insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '图书',xdl_category_category_id_seq.currval,'图书啊',null);
  insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '小说',xdl_category_category_id_seq.currval,'小说啊',1);
  select  * from  XDL_CATEGORY;
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '文学',xdl_category_category_id_seq.currval,'文学啊',1);
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '青春文学',xdl_category_category_id_seq.currval,'青春啊文学啊',1);
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '传记',xdl_category_category_id_seq.currval,'传记啊',1);
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '少儿',xdl_category_category_id_seq.currval,'少儿啊',1);
  
  /** 增加小说对应的子分类 */
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '言情小说',xdl_category_category_id_seq.currval,'言情啊',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '玄幻小说',xdl_category_category_id_seq.currval,'玄幻啊',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '中国近代小说',xdl_category_category_id_seq.currval,'中国近代啊',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '中国古代小说',xdl_category_category_id_seq.currval,'中国古代小说啊',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '军事小说',xdl_category_category_id_seq.currval,'军事啊',2);
  
  /** 增文学对应的子分类 */
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '古代文学',xdl_category_category_id_seq.currval,'古代文学啊',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '近代文学',xdl_category_category_id_seq.currval,'近代文学啊',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '金石文学',xdl_category_category_id_seq.currval,'金石文学啊',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  'IT文学',xdl_category_category_id_seq.currval,'IT文学',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '性格文学',xdl_category_category_id_seq.currval,'性格文学啊',3);
  /** 图书资讯表 */
  drop  table  xdl_news  cascade constraints;
  create table xdl_news(
      id   number constraint  xdl_news_id_pk primary key,
      title  varchar2(100),
      content  varchar2(200),
      release_time  Date,
      sticky   char(1)
  );
  drop  sequence  xdl_news_id_seq;
  create sequence  xdl_news_id_seq;
  insert into  xdl_news  values(xdl_news_id_seq.nextval,'国足理财',
  '有一个牛奶叫特仑苏,有一个球队叫特能输',sysdate-10,'y');
  insert into  xdl_news values(xdl_news_id_seq.nextval,'马刺',
  '有一个牛奶叫特仑苏,有一个球队叫老男孩球队',sysdate-20,'y');
  insert into  xdl_news values(xdl_news_id_seq.nextval,'勇士',
  '有一个牛奶叫特仑苏,有一个球队叫二队也能夺冠',sysdate-65,'y');
  insert into  xdl_news values(xdl_news_id_seq.nextval,'刘国梁',
  '原来我认为中国没有教练也能赢,现在有教练也不太行',sysdate-200,'y');
  
  /** 建立一张产品表   建表之前先删除表 */
 drop     table   xdl_product cascade constraints;
 create   table   xdl_product(
 product_id	NUMBER   constraint   xdl_product_product_id_pk  primary key,
name	VARCHAR2(50),
keywords	VARCHAR2(50),
add_time	DATE,
picture	VARCHAR2(50),
big_picture	VARCHAR2(50),
fixed_price	NUMBER,
lower_price	NUMBER,
description	VARCHAR2(1000),
author	VARCHAR2(100),
publishing	VARCHAR2(100),
publish_time	Date,
isbn	VARCHAR2(100),
language	VARCHAR2(100),
which_edtion	VARCHAR2(100),
total_page	VARCHAR2(100),
bind_layout	VARCHAR2(100),
book_size	VARCHAR2(100),
editor_description	VARCHAR2(1000),
catalog	VARCHAR2(1000),
book_summary	VARCHAR2(1000),
author_summary	VARCHAR2(1000),
extracts	VARCHAR2(100),
print_time	DATE,
print_number	NUMBER,
paper_type	VARCHAR2(100),
print_frequency	VARCHAR2(100)
  );
drop  sequence  xdl_product_product_id_seq;  
create sequence xdl_product_product_id_seq;
insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '让子弹飞','子弹  飞   葛优 姜文 发哥',sysdate-100,'img/book01.jpg',
 'img/big/book01.jpg',100,20,'让子弹飞啊','姜文','兄弟连出版社',sysdate-100,
  'ISBN_0001','简体中文','第三版','350页','简装','16K',
  '编辑描述 你猜有没有','第一章之后就没有了','告诉你了就是让子弹飞',
  '不知道是个演员 还是个导演','吃着火锅唱着歌',sysdate-100,5000,'泥皮','第五次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '藏地密码4','藏地 密码 吗 喜马拉雅  ',
  sysdate-100,'img/book02.jpg','img/big/book02.jpg',
  100,20,'藏地密码，去西藏查查密码',
  '河马','北京电子工业出版社',sysdate-50,'ISBNisbn00xx2',
  '简体中文','第二版','300页','简装',
  '16K','第四部喜马拉雅的诱惑','第一章到第五章','听说喜马拉雅是神的住宿，门钥匙在哪里？',
  '河马爱神仙','',sysdate-20,
  3000,'牛皮','第3次影印'
  );
  
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '藏地密码5','藏地 密码 哈哈',sysdate-100,'img/book03.jpg',
  'img/big/book03.jpg',120,50,'让藏地来了密码','河马','兄弟连出版社',
  sysdate-100,'ISBN_0102','简体中文','第五版','250页','精装','16K',
  '长篇小说很棒棒','第一章主人公卒','让藏地带一个密码','编剧和作家',
  '遥远的藏地有一个密码叫高伟萎',sysdate-100,2000,'牛皮纸','修正液版');
insert into xdl_product values(xdl_product_product_id_seq.nextval,'藏地密码6','藏地 啊藏地',
sysdate-100,'img/book04.jpg','img/big/book04.jpg',88,30,'藏地密码密码',
'西藏人民','中国出版社',sysdate-100,'ISBN_0004','繁体中文',
'第四版','180页','精装','20k','编辑描述 你猜有没有',
'第一章之后就没有了','告诉你了就是藏地密码','不知道是不是一个人',
'哈哈哈哈哈 ',sysdate-100,4800,'牛皮','第四次加印');

insert into xdl_product values(xdl_product_product_id_seq.nextval,'黑道飞云20年','古惑仔 山鸡 陈浩南',
sysdate-100,'img/book05.jpg','img/big/book05.jpg',100,20,'黑道飞云20年啊',
'山鸡','人民出版社',sysdate-100,'ISBN_0005','简体中文',
'第三版','500页','精装','16k','编辑描述 你猜有没有',
'第一章之后就没有了','告诉你了就是黑道飞云20年','是个古惑仔',
'指导我大哥是谁吗',sysdate-100,5000,'金皮','第六次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'风雨哈佛路','风雨 哈佛 路',sysdate-100,'img/book06.jpg',
'img/big/book06.jpg',100,99,'风雨哈佛路','外国人',
'总监出版社',sysdate-200,'ISBN_0002','简体中文','第二版','350页',
'精装','16k','编辑描述','第一章','风雨哈佛路','外国妞','吃着火锅唱着歌',
sysdate-100,5000,'牛皮纸','第二次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'奈良美智','奈良 美 智',sysdate-100,'img/book07.jpg',
'img/big/book07.jpg',100,99,'奈良美智','日本人',
'总监出版社',sysdate-200,'ISBN_0003','简体中文','第二版','350页',
'精装','16k','编辑描述','第一章','奈良美智','日本r','吃着火锅唱着歌',
sysdate-100,5000,'牛皮纸','第二次加印');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'说服力','ppt 说 说服力 会说话',sysdate-100,'img/book08.jpg',
'img/big/book08.jpg',100,20,'说服力 让你的PPT会说话',
'张志 刘俊 包翔','人民邮电出版社',sysdate-300,'ISBN_0008',
'简体中文','第一版','520页','精装','16K','编辑描述 让你的PPT会说话',
'第一章说服力了','说服力 ...省略一万字','不知道是一个人写到还是三个人写的..',
'让你的PPT会说话',sysdate-100,10000,'宣纸','第一次精印');

insert into xdl_product values(xdl_product_product_id_seq.nextval,
'再见出租屋','再见 出租屋 屋',sysdate-100,'img/book09.jpg','img/big/book09.jpg',
100,20,'再见出租屋','李冰','生活?读书?新知三联书店',sysdate-300,'ISBN_0009',
'简体中文','第五版','400页','精装','16K','编辑描述 这是一本好书',
'第一章我的北漂生活','北漂生活 ...省略一万字','不知道这是谁..','再见出租屋',
sysdate-100,2500,'竹纸','第六次印');

 insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '将才','将 大将 人才',sysdate-100,'img/book10.jpg',
 'img/big/book10.jpg',100,20,'人才指南','将才作者本人','兄弟连出版社',sysdate-100,
  'ISBN_0010','简体中文','第一版','350页','简装','16K',
  '成为将才，必先掌握一技之长','总共36章','人才成长必备',
  '著名作家','不想成为将军的士兵不是好士兵',sysdate-100,5000,'牛皮','第三次第一次印刷'); 
  insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '怪诞行为学','怪诞 行为 心理学 行为学',sysdate-100,'img/book11.jpg',
 'img/big/book11.jpg',100,20,'这是一本关于行为和心理方面的著作','高伟伟','兄弟连出版社',sysdate-100,
  'ISBN_0011','简体中文','第三版','350页','简装','16K',
  '行为理性息息相关','总共31章','要想学习心理学，必先读此书',
  '马太效应 从众心理','停车做爱枫林晚，桑叶红于二月花',sysdate-100,5000,'特级纸','第五次加印');
  select   * from  xdl_product;
  
  /** 把数据修改成随机的 
  update   xdl_product set lower_price = trunc(dbms_random.value(30,50),2);
  update   xdl_product set  publish_time = sysdate - trunc(dbms_random.value(0,100),6);   
  */
  
  /**类型 和  产品的关系表 */
  drop  table  xdl_category_product cascade constraints;
  create  table  xdl_category_product(
      id    number   constraint  xdl_category_product_id_pk primary key,
      category_id  number constraint xdl_cate_pro_category_id_fk 
      references xdl_category(category_id),
      product_id   number  constraint xdl_cate_pro_product_id_fk 
      references xdl_product(product_id)
  );
  drop  sequence   xdl_category_product_id_seq;
  create  sequence   xdl_category_product_id_seq;
  /** 给言情小说 插入 5 条数据 */ 
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,7,1);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,7,2);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,7,3);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,7,4);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,7,5);
  /** 玄幻分类插入 6条数据 */    
   insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,8,6);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,8,7);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,8,8);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,8,9);
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,8,10);    
  insert into  xdl_category_product values(
      xdl_category_product_id_seq.nextval,8,11); 