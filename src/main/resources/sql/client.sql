 drop table if exists client;
 create table client(
   c_id bigint(20) unsigned NOT NULL auto_increment ,
   pwd VARCHAR(20) NOT NULL ,
   status boolean default true,
   email VARCHAR(50) NOT NULL unique, # == account
   firstname VARCHAR(30) ,
   lastname VARCHAR(30) ,
   tax_id VARCHAR(10) ,
   phone VARCHAR(20) ,
   addr VARCHAR(100) ,
   score int unsigned not null default 0,
   primary key(c_id)
);

 drop table if exists cart;
 create table cart(
    c_id bigint(20) unsigned NOT NULL,
    i_id bigint(20) unsigned NOT NULL,
    v_id bigint(20) unsigned NOT NULL,
    foreign key (c_id) references client(c_id),
    foreign key (i_id) references item(i_id),
    foreign key (v_id) references vendor(v_id)
);

 drop table if exists order_head;
 create table order_head(
	oh_id bigint(20) unsigned NOT NULL auto_increment ,
    c_id bigint(20)  unsigned NOT NULL,
    v_id bigint(20)  unsigned NOT NULL,
    payment bigint(20) NOT NULL,
    payment_fee decimal default 0,
    deliver bigint(20) NOT NULL,
    deliver_fee decimal default 0,
    shelf_fee decimal default 0,

    status_vendor tinyint NOT NULL default 0, # 0~255
    status_payment tinyint NOT NULL default 0,
    status_deliver tinyint NOT NULL default 0,
    create_date date NOT NULL,
    update_date date,
    primary key (oh_id),
    foreign key (c_id) references client(c_id),
    foreign key (v_id) references vendor(v_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 drop table if exists order_detail;
 create table order_detail(
	od_id bigint(20) unsigned NOT NULL ,
    i_id bigint(20)  unsigned NOT NULL, # item_id
    oh_id bigint(20) unsigned NOT NULL,
    p_price decimal NOT NULL, #piece price
    t_price decimal NOT NULL, #total price =quanty * piece price
    quatity int unsigned NOT NULL,
    primary key (od_id),
    foreign key (oh_id) references order_head(oh_id),
    foreign key (i_id) references item(i_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 drop table if exists status_vendor;
 create table status_vendor(
	id tinyint NOT NULL ,
    name VARCHAR(20) NOT NULL,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 drop table if exists status_payment;
 create table status_payment(
	id tinyint NOT NULL ,
    name VARCHAR(20) NOT NULL,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
 drop table if exists status_deliver;
 create table status_deliver(
	id tinyint NOT NULL ,
    name VARCHAR(20) NOT NULL,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

