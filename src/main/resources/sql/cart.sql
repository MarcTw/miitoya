drop table if exists vendor ;
create table vendor(
   v_id VARCHAR(50) NOT NULL ,
   email VARCHAR(50) NOT NULL,
   name VARCHAR(20) NOT NULL,
   taxid VARCHAR(10) ,
   phone VARCHAR(20) NOT NULL,
   addr VARCHAR(100) ,
   payment_type VARCHAR(50) NOT NULL,# 對應到partner_id, partner_type as array
   # 可接受付款方式
   # 00000001 atm # 00000010 信用卡 # 00000100 超商代收 # 00001000 悠遊卡 #000100000 現金 #local
   deliver_type VARCHAR(50) NOT NULL,
   score int not null default 0,
   bank_account VARCHAR(50),
   bank_local decimal,
   primary key(v_id)
);



drop table if exists payment_type;
create table payment_type(
	 id int not null,
     p_id varchar(50),
     p_type int ,
     
	 name varchar(20) not null # atm, 信用卡, 便利商店貨到付款, 超商付款貨到

 );
 
 drop table if exists deliver_type;
 create table deliver_type(
	 id int not null,
	 name varchar(20) not null,
     p_id varchar(50),
     p_type int

 );
 
 drop table if exists item;
 create table item(
	i_id bigint not null auto_increment,
    v_id VARCHAR(50) not null,
    number int not null,
    is_subitem tinyint not null default 0,
    subitem VARCHAR(100),
    price decimal,
    description VARCHAR(300),
    stock int,
    has_sold int,
    primary key(i_id),
    foreign key(v_id) references vendor(v_id)
);
 
 drop table if exists client;
 create table client(
	c_id VARCHAR(50) NOT NULL ,
    name varchar(20) NOT NULL default '',
    email varchar(50) NOT NULL,
    score int default 0,
    addr varchar(50),
    primary key(c_id)
);

 drop table if exists cart;
 create table cart(
    c_id VARCHAR(50) NOT NULL,
    i_id VARCHAR(50) NOT NULL,
    primary key(c_id,i_id),
    foreign key (c_id) references client(c_id),
    foreign key (i_id) references item(i_id)
);



 drop table if exists order_head;
 create table order_head(
	create_date date NOT NULL,
    update_date date,
	oh_id VARCHAR(50) NOT NULL ,
    c_id VARCHAR(50) NOT NULL,
    v_id VARCHAR(50) NOT NULL,
    payment_type int NOT NULL,
    deliver_type int NOT NULL,
    deliver_fee decimal,
    p_id VARCHAR(50),
    status tinyint NOT NULL,
    primary key (oh_id),
    foreign key (c_id) references client(c_id),
    foreign key (v_id) references client(v_id)
);


 drop table if exists order_detail;
 create table order_detail(
	od_id VARCHAR(50) NOT NULL ,
    i_id VARCHAR(50) NOT NULL,
    oh_id varchar(50) NOT NULL,
    primary key (od_id),
    foreign key (oh_id) references order_head(oh_id)
);

 drop table if exists partner;
 create table partner(
	p_id VARCHAR(50) NOT NULL,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(20),
    tax_id VARCHAR(10),
    primary key (p_id)
);
    
drop table if exists partner_fee;
create table partner_fee(
	p_type tinyint auto_increment,# 貨到付款 付款貨到 atm 信用卡
    p_id varchar(50) NOT NULL ,# 7-11 , CTBC
    name varchar(50),
    description varchar(200),
	price decimal,
    primary key(p_id,p_type),
    foreign key(p_id) references partner(p_id)
);

drop table if exists partner_fee_history;
create table partner_fee_history(
	id bigint NOT NULL auto_increment,
    create_time timestamp ,
    update_time timestamp ,
    status tinyint default 1, # 1 commit , 2 cancel 
    oh_id varchar(50),
    p_id varchar(50),
    p_type int,
    price decimal
);

drop table if exists client_history;
create table client_history(
	id bigint NOT NULL auto_increment,
    c_id varchar(50) not null,
    od_id VARCHAR(50) NOT NULL ,
    create_time timestamp ,
    update_time timestamp 
 )   
    
 

