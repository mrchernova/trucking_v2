
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "ШопАвтоТранс"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "Логистические решения"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ИП "Новак Ольга Олеговна"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "Ройал Дэливэри"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "ПаркетЛаб"');

INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('1', '1','administrator@gmail.com', 'ADMINISTRATOR','ACTIVE', null);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('client1', '1','u.user1@gmail.com', 'CLIENT', 'ACTIVE', 1);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('client2', '1','u.user2@gmail.com', 'CLIENT', 'ACTIVE', 2);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('carrier1', '1','u.user3@gmail.com', 'CARRIER', 'ACTIVE', 3);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('carrier2', '1','u.user4@gmail.com', 'CARRIER', 'ACTIVE', 4);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('carrier3', '1','u.user5@gmail.com', 'CARRIER', 'ACTIVE', 5);

insert into drivers(name, surname, status,legal_entity_id) values ('Иван', 'Иванов', 0, 3);
insert into drivers(name, surname, status,legal_entity_id) values ('Перт', 'Петров', 0, 3);

insert into transport(CARRYING_CAPACITY,MODEL,NUMBER_PLATE,STATUS,VEHICLE_TYPE,LEGAL_ENTITY_ID) values (5.1, 'Volvo', '1234 HI-3',0,0,3);
insert into transport(CARRYING_CAPACITY,MODEL,NUMBER_PLATE,STATUS,VEHICLE_TYPE,LEGAL_ENTITY_ID) values (5.8, 'MAN', '5678 EE-3',0,0,3);

insert into orders(DESCRIPTION,DEPARTURE,DESTINATION,WEIGHT,PRICE,STATUS,LEGAL_ENTITY_ID) values ('Мебель','Минск','Витебск',800,600,0,1);
insert into orders(DESCRIPTION,DEPARTURE,DESTINATION,WEIGHT,PRICE,STATUS,LEGAL_ENTITY_ID) values ('Продукты','Гомель','Гродно',400,550,0,2);

