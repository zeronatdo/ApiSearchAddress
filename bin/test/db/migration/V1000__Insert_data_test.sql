INSERT INTO tbl_prefecture(prefecture_id,prefecture,prefecture_kana,prefecture_code) VALUES (1,'北海道','ﾎｯｶｲﾄﾞｳ','01');
INSERT INTO tbl_post(post_id,post_code,update_show,change_reason,multi_area) VALUES (1,'0010000',0,0,0);
INSERT INTO tbl_old_post(old_post_id,old_post_code) VALUES (1,'001');
INSERT INTO tbl_city(city_id,prefecture_id,code,city,city_kana) VALUES (1,1,'01101','札幌市中央区','ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ');
INSERT INTO tbl_area(area_id,area_kana, area,city_id,chome_area,koaza_area,multi_post_area,post_id,old_post_id)
 VALUES (1,'ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ','以下に掲載がない場合',1	,0,0,0,1,1);
