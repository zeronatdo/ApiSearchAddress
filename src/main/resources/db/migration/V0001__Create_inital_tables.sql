create table if not exists tbl_prefecture(
	prefecture_id int(11) AUTO_INCREMENT NOT NULL,
    prefecture varchar(100),
    prefecture_kana varchar(100),
    prefecture_code varchar(2),
    primary key (prefecture_id)
);

create table if not exists tbl_city(
	city_id int(11) AUTO_INCREMENT NOT NULL,
    prefecture_id int(11) NoT NULL,
    code varchar(5),
    city varchar(100),
    city_kana  varchar(100),
    primary key (city_id),
    foreign key (prefecture_id) references tbl_prefecture(prefecture_id)
);

create table if not exists tbl_old_post(
	old_post_id int(11) AUTO_INCREMENT NOT NULL,
    old_post_code varchar(5),
    primary key (old_post_id)
);

create table if not exists tbl_post(
	post_id int(11) AUTO_INCREMENT NOT NULL,
    post_code varchar(7),
    update_show int(11),
    change_reason int(11),
    multi_area int(11),
    primary key (post_id)
);

create table if not exists tbl_area(
	area_id int(11) AUTO_INCREMENT NOT NULL,
    area_kana longtext,
    area longtext,
    city_id int(11),
    chome_area int(11),
    koaza_area int(11),
    multi_post_area int(11),
    post_id int(11),
    old_post_id int(11),
    primary key (area_id),
    foreign key (post_id) references tbl_post(post_id),
    foreign key (old_post_id) references tbl_old_post(old_post_id)
);