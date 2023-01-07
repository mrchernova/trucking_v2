INSERT INTO USERS (ID,LOGIN, PASSWORD, EMAIL, ROLE) VALUES (101,'admin', '000','administrator@gmail.com', 0);
INSERT INTO USERS (ID,LOGIN, PASSWORD, EMAIL, ROLE) VALUES (102,'nikolaevha', '111','u.user1@gmail.com', 1);
INSERT INTO USERS (ID,LOGIN, PASSWORD, EMAIL, ROLE) VALUES (103,'parket', '111','u.user1@gmail.com', 1);
INSERT INTO USERS (ID,LOGIN, PASSWORD, EMAIL, ROLE) VALUES (104,'delivery_driver', '222','u.user2@gmail.com', 2);
INSERT INTO USERS (ID,LOGIN, PASSWORD, EMAIL, ROLE) VALUES (105,'shop_avto', '222','u.user2@gmail.com', 2);
INSERT INTO USERS (ID,LOGIN, PASSWORD, EMAIL, ROLE) VALUES (106,'logistic_drive', '222','u.user2@gmail.com', 2);

INSERT INTO LEGAL_ENTITY (ID,TITLE, CONTACT, USER_ID) VALUES (101,'ООО "ШопАвтоТранс"', 'ххх', 105);
INSERT INTO LEGAL_ENTITY (ID,TITLE, CONTACT, USER_ID) VALUES (102,'ООО "Логистические решения"', 'ххх', 106);
INSERT INTO LEGAL_ENTITY (ID,TITLE, CONTACT, USER_ID) VALUES (103,'ИП "Новак Ольга Олеговна"', 'ххх', 102);
INSERT INTO LEGAL_ENTITY (ID,TITLE, CONTACT, USER_ID) VALUES (104,'ООО "Ройал Дэливэри"','xxx', 104);
INSERT INTO LEGAL_ENTITY (ID,TITLE, CONTACT, USER_ID) VALUES (105,'ООО "ПаркетЛаб"', 'ххх', 103);