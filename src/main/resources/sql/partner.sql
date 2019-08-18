drop table if exists partner; #ex. 7-11, ok , familymart
 create table partner(
	id bigint(20) unsigned NOT NULL auto_increment,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(20),
    tax_id VARCHAR(10),
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 drop table if exists partner_service; # ex. 7-11
 create table partner_service(
	p_id bigint(20) unsigned NOT NULL auto_increment,
    partner bigint(20) unsigned NOT NULL,
    name VARCHAR(30) NOT NULL, # 7-11 先付款, 7-11機器付款 7-11貨到付款
    primary key (p_id),
    foreign key (partner) references partner(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    
drop table if exists partner_service_fee; # ex. 離島運費,跨國,重量,體積 ,先用單一計價好了>< 有點麻煩
create table partner_service_fee(
	id bigint(20) unsigned NOT NULL auto_increment,
    p_id bigint(20) unsigned NOT NULL ,# partner service
	p_price decimal NOT NULL default 1,
    name varchar(30),
    primary key(id),
    foreign key(p_id) references partner_service(p_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*
drop table if exists partner_fee_history; # 給夥伴的費用log
create table partner_fee_history(
    create_time timestamp ,
    update_time timestamp ,
    status tinyint default 1, # 1 commit , 2 cancel 
    oh_id varchar(50),
    p_id varchar(50),
    p_type int,
    price decimal
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/