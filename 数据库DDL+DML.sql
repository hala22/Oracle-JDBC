-- 学生表（写法一）
CREATE TABLE student(
	id NUMBER(100) PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	age NUMBER(3),
	weight NUMBER(4,2),
	sex NUMBER(1) DEFAULT 0 CHECK (sex=0 OR sex=1),
	sno NUMBER(8) UNIQUE NOT NULL,
	date_ DATE
);


-- 学生表（写法二）
CREATE TABLE student(
	id NUMBER(100) CONSTRAINT student_id_pk PRIMARY,
	name VARCHAR2(100) CONSTRAINT student_name_nn NOT NULL,
	age NUMBER(3),
	weight NUMBER(4,2);
	sex NUMBER(1) DEFAULT 0
		CONSTRAINT student_sex_ck CHECK(sex=0 OR sex=1),
	sno NUMBER(8)
		CONSTRAINT student_sno_un UNIQUE
		CONSTRAINT student_sno_nn NOT NULL,
	date_ DATE
);

-- 学生表（写法三）
CREATE TABLE student(
	id NUMBER(100),
	name VARCHAR2(100) CONSTRAINT student_name_nn NOT NULL,
	age NUMBER(3),
	weight NUMBER(4,2),
	sex NUMBER(1) DEFAULT 0,
	sno NUMBER(8)	CONSTRAINT student_sno_nn NOT NULL,
	date_ DATE,
	CONSTRAINT student_id_pk PRIMARY KEY(id),
	CONSTRAINT student_sex_ck CHECK(sex=0 OR sex=1),
	CONSTRAINT student_sno_un UNIQUE(sno)
);

ALTER TABLE student
ADD（
	column addr VARCHAR2(100)
）；

-- 科目表
CREATE TABLE subject(
	id NUMBER(100),
	name VARCHAR2(100) CONSTRAINT subject_name_nn NOT NULL,
	CONSTRAINT subject_id_pk PRIMARY KEY(id),
);

-- 成绩表
CREATE TABLE grade(
	id NUMBER(100),
	stu_id NUMBER(100),
	sub_id NUMBER(100),
	score NUMBER(3),
	CONSTRAINT grade_id_pk PRIMARY KEY(id),
	CONSTRAINT grade_stu_id_fk FOREIGN KEY (stu_id) REFERENCES student(id),
	CONSTRAINT grade_sub_id_fk FOREIGN KEY (sub_id) REFERENCES subject(id),
);

-- 子查询创建表（90分以上）
CREATE TABLE grade_90
AS SELECT * FROM grade
WHERE score>90;

ALTER TABLE grade_90
ADD(
	CONSTRAINT grade_90_stu_id FOREIGN KEY (stu_id) REFERENCES student(id),
	CONsTRAINT grade_90_sub_id FOREIGN KEY (sub_id) REFERENCES subject(id)
);

ALTER TABLE grade_90
DISABLE(
	CONSTRAINT grade_90_stu_id [CASCADE]
);

ALTER TaBLE grade_90
ENABLE(
	CONSTRAINT grade_90_stu_id
);



-- 插入学生信息

INSERT INTO student VALUES(1,'张三',20,55.23,0,20167296,'23-08月-2019','山西省太原市');
INSERT INTO subject (id,name) VALUES (001,'数据结构');
INSERT INTO grade VALUES (0001,1,001,92);

commit

--查询普通

SELECT id,name,weight*2 [AS] "WEI"
FROM student;

SELECT NVL(addr,'未填写')
FROM student;

SELECT DISTINCT name
FROM student;

-- 查询排序

SELECT stu_id,sub_id,score
FROM grade
ORDER BY  score DESC , stu_id ASC , sub_id ASC;

--查询条件

SELECT name
FROM student
WHERE name LIKE '张%';

SELECT UPPER ('hello world') FROM dual;
SELECT ROUND(23.345,2) FROM dual;
SELECT TRUNC(345.22,-1) FROM dual;

WHERE start_date BETWEEN TRUNC(NEXT_DAY(sysdate-7,'monday'),'dd') AND sysdate;









 

