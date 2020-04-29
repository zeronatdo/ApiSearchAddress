DROP TABLE IF EXISTS tbl_temp;

-- ====Create tbl_temp=======
CREATE TABLE tbl_temp (
	id             	int(11) AUTO_INCREMENT NOT NULL,
	code           	varchar(11) NULL,
	old_post_code  	varchar(11) NULL,
	post_code      	varchar(11) NULL,
	prefecture_kana	varchar(100) NULL,
	city_kana      	varchar(100) NULL,
	area_kana      	varchar(100) NULL,
	prefecture     	varchar(100) NULL,
	city           	varchar(100) NULL,
	area           	varchar(100) NULL,
	multi_post_area	int(11) NULL,
	koaza_area     	int(11) NULL,
	chome_area     	int(11) NULL,
	multi_area     	int(11) NULL,
	update_show    	int(11) NULL,
	change_reason  	int(11) NULL,
	PRIMARY KEY(id)
)
ENGINE = InnoDB;
CREATE INDEX city_kana_index ON tbl_temp(city_kana);
CREATE INDEX old_post_index ON tbl_temp(old_post_code);
CREATE INDEX prefecture_kana_index ON tbl_temp(prefecture_kana);
CREATE INDEX post_index ON tbl_temp(post_code);
CREATE INDEX area_kana_index ON tbl_temp(area_kana);
CREATE INDEX area_index ON tbl_temp(area);
-- ===Load data=====
LOAD DATA LOCAL INFILE 'D:\\Source-project\\my-spring-boot\\src\\main\\resources\\db\\KEN_ALL.CSV' INTO TABLE tbl_temp FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n'
(code,old_post_code,post_code,prefecture_kana,city_kana,area_kana,prefecture,city,area,multi_post_area,koaza_area,chome_area,multi_area,update_show,change_reason);

-- ===tbl_prefecture============================
	INSERT INTO tbl_prefecture(prefecture_CODE,prefecture_kana,prefecture)
	SELECT CODE, prefecture_kana,prefecture
	FROM (
	SELECT DISTINCT LEFT(CODE,2) AS CODE,prefecture_kana,prefecture
	FROM tbl_temp
	) AS T2

	ORDER BY CODE;
-- ===tbl_city============================

	INSERT INTO tbl_city(CODE,city_kana,city,prefecture_id)
	SELECT CODE, city_kana AS city_kana,city AS city,(SELECT prefecture_id FROM tbl_prefecture WHERE prefecture_code =LEFT(CODE,2)) AS prefecture_id
	FROM (
	SELECT DISTINCT CODE,city_kana,city
	FROM tbl_temp
	) AS T2
	ORDER BY CODE;
-- ===tbl_post====================
	INSERT INTO tbl_post(post_code
		,update_show,change_reason,multi_area)
	SELECT DISTINCT post_code, update_show,change_reason,multi_area
	FROM tbl_temp
	ORDER BY post_code;

-- ===tbl_old_post====================
	INSERT INTO tbl_old_post(old_post_code)
	SELECT DISTINCT old_post_code
	FROM tbl_temp
	ORDER BY old_post_code;


-- ====tbl_area====================

INSERT INTO tbl_area(area_kana, AREA,multi_post_area,koaza_area,chome_area,post_id,old_post_id,city_id)
	 SELECT area_kana, AREA,multi_post_area,koaza_area,chome_area,post_id, old_post_id, city_id
	 FROM
		(
		  SELECT DISTINCT tbl_temp.area_kana, tbl_temp.area, tbl_temp.multi_post_area,tbl_temp.koaza_area,tbl_temp.chome_area,tbl_temp.code,post_id, old_post_id,
			tbl_temp.city_kana, tbl_temp.city, tbl_temp.prefecture, tbl_temp.prefecture_kana,tbl_city.city_id
		  FROM tbl_temp
		  INNER JOIN tbl_post ON tbl_post.post_code = tbl_temp.post_code
		  INNER JOIN tbl_old_post ON tbl_old_post.old_post_code = tbl_temp.old_post_code
		  INNER JOIN tbl_prefecture ON tbl_temp.prefecture = tbl_prefecture.prefecture AND tbl_temp.prefecture_kana = tbl_prefecture.prefecture_kana
		  INNER JOIN tbl_city ON tbl_city.city_kana = tbl_temp.city_kana AND tbl_city.city = tbl_temp.city AND tbl_prefecture.prefecture_id = tbl_city.prefecture_id
		) AS tbl;

-- ====Drop tbl_temp=======
DROP TABLE tbl_temp;
