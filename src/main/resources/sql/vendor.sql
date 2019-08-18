drop table if exists vendor ; # 個資暫時不處理,把密碼,電話地址等資訊要加密處理
create table vendor(
   v_id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
   pwd VARCHAR(20) NOT NULL ,
   status bool default true,
   email VARCHAR(100) NOT NULL unique, # == account
   brand VARCHAR(30) NOT NULL,
   firstname VARCHAR(20) default '',
   lastname VARCHAR(20) default 'Lin' ,
   tax_id VARCHAR(10) ,
   phone VARCHAR(20) ,
   addr VARCHAR(100) ,
   country VARCHAR(20),
   score int unsigned not null default 0,
   bank_account VARCHAR(20),
   primary key(v_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists v_token ; #MVP MVP MVP 缺點很多,但應該能用
create table v_token(
	v_token VARCHAR(50) NOT NULL,
	v_id bigint(20) NOT NULL ,
    create_time timestamp NOT NULL,
    expire_time timestamp NOT NULL default '20201208000000', # 2222.1.1
    primary key(v_token)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# intemediary table vendor-payment service
drop table if exists options_payment; #旭創意 - 7-11 貨到付款 or 先付款後寄貨 綠界
create table options_payment(
	 id int unsigned not null auto_increment,
     v_id bigint(20) unsigned NOT NULL ,
     p_id bigint(20) unsigned NOT NULL, #partner_service
     primary key(id),
     foreign key(v_id) references vendor(v_id),
     foreign key(p_id) references partner_service(p_id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 drop table if exists options_deliver;
 create table options_deliver(
	 id int unsigned not null auto_increment,
     v_id bigint(20) unsigned NOT NULL ,
     p_id bigint(20) unsigned NOT NULL, #partner_service 
     primary key(id),
     foreign key(v_id) references vendor(v_id),
     foreign key(p_id) references partner_service(p_id)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 drop table if exists item;
 create table item(
	i_id bigint(20) unsigned NOT null auto_increment,
    v_id bigint(20) unsigned not null,
    stock int unsigned not null,
    is_subitem boolean default false,# ex. 耳環型號A001-有藍色紅色
    model bigint(20) unsigned , # 同規格的模型不會有該值,其他色系或是加料會 == 父層i_id
    p_price decimal,
    description VARCHAR(300),
    has_sold int unsigned default 0,
    status boolean default true,
    primary key(i_id),
    foreign key(v_id) references vendor(v_id),
    foreign key(model) references vendor(v_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 #drop table if exists sell_record; # 其實用 v_id 到 order head裡搜尋, 取出的單號再去  order detail裡可以搜出所有細項

 

    
 

