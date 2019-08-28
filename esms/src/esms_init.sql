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
/* ������Ӧ������   ����֮ǰ��ɾ�� */
  drop   sequence  xdl_user_user_id_seq;
  create sequence  xdl_user_user_id_seq;
  
 /** �������� */
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
  'ͼ��',xdl_category_category_id_seq.currval,'ͼ�鰡',null);
  insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  'С˵',xdl_category_category_id_seq.currval,'С˵��',1);
  select  * from  XDL_CATEGORY;
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '��ѧ',xdl_category_category_id_seq.currval,'��ѧ��',1);
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '�ഺ��ѧ',xdl_category_category_id_seq.currval,'�ഺ����ѧ��',1);
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '����',xdl_category_category_id_seq.currval,'���ǰ�',1);
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '�ٶ�',xdl_category_category_id_seq.currval,'�ٶ���',1);
  
  /** ����С˵��Ӧ���ӷ��� */
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '����С˵',xdl_category_category_id_seq.currval,'���鰡',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '����С˵',xdl_category_category_id_seq.currval,'���ð�',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '�й�����С˵',xdl_category_category_id_seq.currval,'�й�������',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '�й��Ŵ�С˵',xdl_category_category_id_seq.currval,'�й��Ŵ�С˵��',2);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '����С˵',xdl_category_category_id_seq.currval,'���°�',2);
  
  /** ����ѧ��Ӧ���ӷ��� */
   insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '�Ŵ���ѧ',xdl_category_category_id_seq.currval,'�Ŵ���ѧ��',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '������ѧ',xdl_category_category_id_seq.currval,'������ѧ��',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '��ʯ��ѧ',xdl_category_category_id_seq.currval,'��ʯ��ѧ��',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  'IT��ѧ',xdl_category_category_id_seq.currval,'IT��ѧ',3);
    insert into  XDL_CATEGORY values (xdl_category_category_id_seq.nextval,
  '�Ը���ѧ',xdl_category_category_id_seq.currval,'�Ը���ѧ��',3);
  /** ͼ����Ѷ�� */
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
  insert into  xdl_news  values(xdl_news_id_seq.nextval,'�������',
  '��һ��ţ�̽�������,��һ����ӽ�������',sysdate-10,'y');
  insert into  xdl_news values(xdl_news_id_seq.nextval,'���',
  '��һ��ţ�̽�������,��һ����ӽ����к����',sysdate-20,'y');
  insert into  xdl_news values(xdl_news_id_seq.nextval,'��ʿ',
  '��һ��ţ�̽�������,��һ����ӽж���Ҳ�ܶ��',sysdate-65,'y');
  insert into  xdl_news values(xdl_news_id_seq.nextval,'������',
  'ԭ������Ϊ�й�û�н���Ҳ��Ӯ,�����н���Ҳ��̫��',sysdate-200,'y');
  
  /** ����һ�Ų�Ʒ��   ����֮ǰ��ɾ���� */
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
 '���ӵ���','�ӵ�  ��   ���� ���� ����',sysdate-100,'img/book01.jpg',
 'img/big/book01.jpg',100,20,'���ӵ��ɰ�','����','�ֵ���������',sysdate-100,
  'ISBN_0001','��������','������','350ҳ','��װ','16K',
  '�༭���� �����û��','��һ��֮���û����','�������˾������ӵ���',
  '��֪���Ǹ���Ա ���Ǹ�����','���Ż�����Ÿ�',sysdate-100,5000,'��Ƥ','����μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '�ص�����4','�ص� ���� �� ϲ������  ',
  sysdate-100,'img/book02.jpg','img/big/book02.jpg',
  100,20,'�ص����룬ȥ���ز������',
  '����','�������ӹ�ҵ������',sysdate-50,'ISBNisbn00xx2',
  '��������','�ڶ���','300ҳ','��װ',
  '16K','���Ĳ�ϲ�����ŵ��ջ�','��һ�µ�������','��˵ϲ�����������ס�ޣ���Կ�������',
  '��������','',sysdate-20,
  3000,'ţƤ','��3��Ӱӡ'
  );
  
insert into xdl_product values(xdl_product_product_id_seq.nextval,
  '�ص�����5','�ص� ���� ����',sysdate-100,'img/book03.jpg',
  'img/big/book03.jpg',120,50,'�òص���������','����','�ֵ���������',
  sysdate-100,'ISBN_0102','��������','�����','250ҳ','��װ','16K',
  '��ƪС˵�ܰ���','��һ�����˹���','�òصش�һ������','��������',
  'ңԶ�Ĳص���һ������и�ΰή',sysdate-100,2000,'ţƤֽ','����Һ��');
insert into xdl_product values(xdl_product_product_id_seq.nextval,'�ص�����6','�ص� ���ص�',
sysdate-100,'img/book04.jpg','img/big/book04.jpg',88,30,'�ص���������',
'��������','�й�������',sysdate-100,'ISBN_0004','��������',
'���İ�','180ҳ','��װ','20k','�༭���� �����û��',
'��һ��֮���û����','�������˾��ǲص�����','��֪���ǲ���һ����',
'���������� ',sysdate-100,4800,'ţƤ','���Ĵμ�ӡ');

insert into xdl_product values(xdl_product_product_id_seq.nextval,'�ڵ�����20��','�Ż��� ɽ�� �º���',
sysdate-100,'img/book05.jpg','img/big/book05.jpg',100,20,'�ڵ�����20�갡',
'ɽ��','���������',sysdate-100,'ISBN_0005','��������',
'������','500ҳ','��װ','16k','�༭���� �����û��',
'��һ��֮���û����','�������˾��Ǻڵ�����20��','�Ǹ��Ż���',
'ָ���Ҵ����˭��',sysdate-100,5000,'��Ƥ','�����μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'�������·','���� ���� ·',sysdate-100,'img/book06.jpg',
'img/big/book06.jpg',100,99,'�������·','�����',
'�ܼ������',sysdate-200,'ISBN_0002','��������','�ڶ���','350ҳ',
'��װ','16k','�༭����','��һ��','�������·','����','���Ż�����Ÿ�',
sysdate-100,5000,'ţƤֽ','�ڶ��μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'��������','���� �� ��',sysdate-100,'img/book07.jpg',
'img/big/book07.jpg',100,99,'��������','�ձ���',
'�ܼ������',sysdate-200,'ISBN_0003','��������','�ڶ���','350ҳ',
'��װ','16k','�༭����','��һ��','��������','�ձ�r','���Ż�����Ÿ�',
sysdate-100,5000,'ţƤֽ','�ڶ��μ�ӡ');
insert into xdl_product values(xdl_product_product_id_seq.nextval,
'˵����','ppt ˵ ˵���� ��˵��',sysdate-100,'img/book08.jpg',
'img/big/book08.jpg',100,20,'˵���� �����PPT��˵��',
'��־ ���� ����','�����ʵ������',sysdate-300,'ISBN_0008',
'��������','��һ��','520ҳ','��װ','16K','�༭���� �����PPT��˵��',
'��һ��˵������','˵���� ...ʡ��һ����','��֪����һ����д������������д��..',
'�����PPT��˵��',sysdate-100,10000,'��ֽ','��һ�ξ�ӡ');

insert into xdl_product values(xdl_product_product_id_seq.nextval,
'�ټ�������','�ټ� ������ ��',sysdate-100,'img/book09.jpg','img/big/book09.jpg',
100,20,'�ټ�������','���','����?����?��֪�������',sysdate-300,'ISBN_0009',
'��������','�����','400ҳ','��װ','16K','�༭���� ����һ������',
'��һ���ҵı�Ư����','��Ư���� ...ʡ��һ����','��֪������˭..','�ټ�������',
sysdate-100,2500,'��ֽ','������ӡ');

 insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '����','�� �� �˲�',sysdate-100,'img/book10.jpg',
 'img/big/book10.jpg',100,20,'�˲�ָ��','�������߱���','�ֵ���������',sysdate-100,
  'ISBN_0010','��������','��һ��','350ҳ','��װ','16K',
  '��Ϊ���ţ���������һ��֮��','�ܹ�36��','�˲ųɳ��ر�',
  '��������','�����Ϊ������ʿ�����Ǻ�ʿ��',sysdate-100,5000,'ţƤ','�����ε�һ��ӡˢ'); 
  insert  into  xdl_product values(xdl_product_product_id_seq.nextval,
 '�ֵ���Ϊѧ','�ֵ� ��Ϊ ����ѧ ��Ϊѧ',sysdate-100,'img/book11.jpg',
 'img/big/book11.jpg',100,20,'����һ��������Ϊ�������������','��ΰΰ','�ֵ���������',sysdate-100,
  'ISBN_0011','��������','������','350ҳ','��װ','16K',
  '��Ϊ����ϢϢ���','�ܹ�31��','Ҫ��ѧϰ����ѧ�����ȶ�����',
  '��̫ЧӦ ��������','ͣ������������ɣҶ���ڶ��»�',sysdate-100,5000,'�ؼ�ֽ','����μ�ӡ');
  select   * from  xdl_product;
  
  /** �������޸ĳ������ 
  update   xdl_product set lower_price = trunc(dbms_random.value(30,50),2);
  update   xdl_product set  publish_time = sysdate - trunc(dbms_random.value(0,100),6);   
  */
  
  /**���� ��  ��Ʒ�Ĺ�ϵ�� */
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
  /** ������С˵ ���� 5 ������ */ 
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
  /** ���÷������ 6������ */    
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