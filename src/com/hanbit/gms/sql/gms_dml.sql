--  id, password, name, ssn,regdate
SELECT * FROM Member;
SELECT * FROM Member WHERE name='손정의';
SELECT* FROM Member UPDATE id;
SELECT* FROM Member UPDATE password;
SELECT COUNT(*) AS count FROM Member;
INSERT INTO Member(id, name, password, ssn,regdate)
VALUES('hong', '홍길동','1', '870811-133456',SYSDATE);
INSERT INTO Member(id, name, password, ssn,regdate)
VALUES('park', '박정희','1', '570811-133456',SYSDATE);
INSERT INTO Member(id, name, password, ssn,regdate)
VALUES('MAGA', '마가릿','1', '571111-133456',SYSDATE);
UPDATE Member
SET password='2'
WHERE id='hong';
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'park','애국','내일생 조국과 민족을 위하여... ',0,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'son','손정의 10계명','1등에 집착하라 ',0,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'MA','마윈','품고 청춘의 그것은 하여도 착목한는 무엇을 있는 인생에 약동하다.  ',0,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'MA','마윈1','끓는 품에 그러므로 온갖 사막이다. 가지에 내려온 청춘에서만 인도하  ',0,SYSDATE);
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'MA','마윈1','겠다는 같은 것이다. 할지니, 우는 트고, 있는 황금시대다. ',0,SYSDATE);
SELECT * FROM Board;