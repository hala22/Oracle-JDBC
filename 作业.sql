-- 作业一
-- 1
conn system/1234
create user HALA identified by 1234;

conn system/1234
grant connect ,resource to HALA;

-- 2
SELECT sysdate FROM dual;
ALTER SESSION SET nls_date_language=english;
-- 3

start e:\aa\my.sql
@ e:\aa\my.sql

脚本出错建议删除用户重建
先转到管理员然后删除

DROP USER 用户名 CASCADE;

-- 4
desc s_emp;


-- 用户表 视频2.1
-- 加前缀防止与关键字重名
CREATE TABLE t_user(
	id NUMBER(11),
	username VARCHAR2(255)
		CONSTRAINT t_user_username_nn NOT NULL,
	password VARCHAR2(255)
		CONSTRAINT t_user_password_nn NOT NULL,
	sex VARCHAR2 DEFAULT 'male',
	id_number NUMBER(20),
	tel NUMBER(11),
	addr VARCHAR2(255),

	CONSTRAINT t_user_id_pk PRIMARY KEY(id),
	CONSTRAINT t_user_username_un UNIQUE(username),
	CONSTRAINT t_user_id_number_un UNIQUE(id_number),
	CONSTRAINT t_user_sex_ck CHECK(sex='female' OR sex='male')
);

-- 类别表
CREATE TABLE t_product_category(
	id NUMBER(11),
	name VARCHAR2(255),
	parent_id,

	CONSTRAINT t_product_category_id_pk PRIMARY KEY(id),
	CONSTRAINT t_product_category_parent_id_fk FOREIGN KEY(parent_id) REFERENCES t_product_category(id)
);

-- 商品表

CREATE TABLE t_product(
	id NUMBER(11),
	name VARCHAR2(255),
	price NUMBER(9,2),
	stock NUMBER(11),
	cate_id NUMBER(11),
	cate_child_id NUMBER(11),

	CONSTRAINT t_product_id_pk PRIMARY KEY(id),
	CONSTRAINT t_product_cate_id_fk FOREIGN KEY(cate_id) REFERENCES t_product_category(id),
	CONSTRAINT t_product_cate_child_id_fk FOREIGN KEY(cate_child_id) REFERENCES t_product_category(id)
);

-- 添加
INSERT INTO t_user VALUES(1,'张三','111','female',111,111,'111');
INSERT INTO t_user VALUES(2,'李四','222','male',222,222,'222');
INSERT INTO t_user VALUES(3,'王五','333','male',333,333,'333');

INSERT INTO t_product_category (id,name) VALUES (1,'食品');
INSERT INTO t_product_category (id,name) VALUES (2,'日用品');
INSERT INTO t_product_category (id,name,parent_id) VALUES (3,'方便面',1);

INSERT INTO t_product VALUES(1,'红烧牛肉面',6,100,1,3);
INSERT INTO t_product VALUES(2,'香辣牛肉面',7,200,1,3);

COMMIT;

-- 作业二

-- 好1
SELECT first_name||','||last_name AS "Name"
FROM s_emp;

-- 2
SELECT id,name,salary*(1+NVL(commission,0)/100)*12 AS annual
FROM s_emp;

-- 3
SELECT id,last_name+" "+first_name+", "+title AS "Message"
FROM s_emp;

-- 4
SELECT id,name
FROM s_emp
WHERE salary<1000;

-- 5
SELECT salary
FROM s_emp
WHERE id IN(1,3,5,7,9);

-- 6
SELECT id,salary
FROM s_emp
WHERE name LIKE '___n%' AND length(first_name)>=5;

-- 7
SELECT id,name
FROM s_emp
WHERE (dept_id=41 OR dept_id=44) AND salary<1000;

-- 8
SELECT first_name,last_name
FROM s_emp
WHERE Lower(last_name) LIKE '--a%';

-- 9
SELECT first_name,last_name
FROM s_emp
WHERE last_name LIKE '%a%e%';

-- 10
SELECT last_name,start_date
FROM s_emp
WHERE BETWEEN '01-JAN-92' AND '12-DEC-92';

-- 11
SELECT name,sales_rep_id
FROM s_customer
WHERE sales_rep_id IS NOT NULL;

-- 12
SELECT id,date_ordered,total
FROM s_ord
WHERE date_ordered >= '01-SEP-92';

-- 13
SELECT first_name
FROM s_emp
WHERE Upper(first_name) LIKE '%BE%';

-- 作业三

-- 1
SELECT e.first_name,e.last_name,s_dept.name
FROM s_dept d,s_emp e
WHERE s_dept.id=s_emp.dept_id AND Lower(e.title) LIKE '%sal%'
ORDER BY e.first_name DESC;

-- 2
SELECT c.name,e.first_name
FROM s_customer c,s_emp e
WHERE c.sales_rep_id=e.id(+)
ORDER BY c.name DESC;

-- 3
SELECT e.last_name,e.first_name,d.name,NVL(e.commission_pct,0) AS commission
FROM s_emp e,s_dept d
WHERE e.dept_id=d.id AND (e.commission_pct<13 OR e.commission_pct IS NULL);

-- 4
SELECT e.last_name,e.salary,d.name
FROM s_emp e,s_dept d
WHERE e.dept_id=d.id AND salary>1500
ORDER BY salary ASC;

-- 5
SELECT e1.id,e1.first_name,e1.last_name
FROM s_emp e1,s_emp e2
WHERE e1.manager_id=e2.id AND e1.start_date<e2.start_date
ORDER BY e1.id ASC;

-- 6
SELECT c.name,c.region_id,r.name
FROM s_customer c,s_region r
WHERE c.region_id=r.id
ORDER BY c.name;

-- 8
SELECT c.name,NVL(e.first_name,'暂无销售') AS sale_name ,r.name
FROM s_emp e,s_customer c,s_region r
WHERE c.sales_rep_id=e.id(+) AND c.region_id=r.id;

-- 9
SELECT rownum ,id,first_name
FROM s_emp
WHERE rownum<4;

-- 10
SELECT rownum,id,first_name
FROM s_emp
WHERE rownum<11
MINUS
SELECT rownum,id,first_name
FROM s_emp
WHERE rownum<6;

SELECT *
FROM(
	SELECT rownum,id,first_name
	FROM s_emp
	WHERE rownum<11
)
WHERE rownum>5;

-- 11
SELECT COUNT(id),MIN(salary),MAX(salary),AVG(salary)
FROM s_emp
GROUP BY dept_id
ORDER BY dept_id ASC,id ASC;

-- 12
SELECT SUM(salary),AVG(salary),MAX(salary),MIN(salary),COUNT(id)
FROM s_emp
WHERE dept_id=41;

-- 15
SELECT dept_id ,COUNT(id)
FROM s_emp
GROUP BY dept_id
HAVING COUNT(id)>2;

-- 作业四

-- 好1

SELECT *
FROM(
	SELECT t.* ,rownum rn
	FROM(
		SELECT id,first_name,salary,dept_id
		FROM s_emp
		ORDER BY salary ASC
		) t
	WHERE rownum<7
	-- 注意这里执行WHERE时还没到SELECT，所以这里不能用rn,只能用rownum
	-- <执行效率比<=高
	)
WHERE rn>3;
-- 这里就可以使用rn了

-- 2
SELECT AVG(salary) avg_salary,COUNT(id) num
FROM s_emp
GROUP BY dept_id 
HAVING AVG(salary)<1400;

-- 3
SELECT *
FROM s_emp
WHERE salary>
	(SELECT salary
	FROM s_emp
	WHERE last_name='Chang');

-- 好4

SELECT *
FROM s_emp
WHERE salary >
	(SELECT salary
	FROM s_emp
	WHERE last_name='Chang')
	OR
	dept_id IN
	(SELECT id
	FROM s_dept
	WHERE region_id=3);

-- 好5
SELECT id,name
FROM s_dept
WHERE dept_id =(
	SELECT dept_id
	FROM( 
		SELECT DISTINCT dept_id,COUNT(id) num
		FROM s_emp
		GROUP BY dept_id
		ORDER BY num DESC
		)
	WHERE rownum=1
	);

-- 好8 分而治之

SELECT *
FROM s_emp
WHERE salary >(
	SELECT AVG(salary)
	FROM s_emp e,s_dept d
	WHERE e.dept_id=d.id AND
	d.region_id=(
		SELECT d.region_id
		FROM s_emp e,s_dept d
		WHERE e.dept_id=d.id AND e.last_name='Chang' 
	)
);

-- 9
SELECT SUM(salary)
FROM s_emp
WHERE dept_id=(
	SELECT dept_id
	FROM s_emp
	WHERE last_name='Chang'
) AND last_name!='Chang';

-- 10
SELECT COUNT(id)
FROM s_customer
WHERE sales_rep_id!=11 AND sales_rep_id!=12 OR sales_rep_id IS NULL;

-- 12
UPDATE s_dept 
SET region_id=5
WHERE id=100;

-- 13
DELETE FROM s_dept
WHERE id=100;


