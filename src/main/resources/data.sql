
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "ШопАвтоТранс"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "Логистические решения"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ИП "Новак Ольга Олеговна"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "Ройал Дэливэри"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "ПаркетЛаб"');
-- INSERT INTO LEGAL_ENTITY (TITLE, BINARY) VALUES ('ООО "ПаркетЛаб"',aced00057372002462792e70726f6a6563742e747275636b696e675f76322e6d6f64656c2e436f6e746163744e38a8b6c5b6d5a50200024c000570686f6e657400124c6a6176612f6c616e672f537472696e673b4c0003756e707400134c6a6176612f6c616e672f496e74656765723b7870740006737472696e67737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b020000787000000000);
-- INSERT INTO LEGAL_ENTITY (TITLE, CONTACT) VALUES ('ООО "ПаркетЛаб"', 'ххх');
-- INSERT INTO LEGAL_ENTITY (TITLE, CONTACT BLOB) VALUES ('ООО "ПаркетЛаб"', 'aced00057372002462792e70726f6a6563742e747275636b696e675f76322e6d6f64656c2e436f6e746163744e38a8b6c5b6d5a50200024c000570686f6e657400124c6a6176612f6c616e672f537472696e673b4c0003756e707400134c6a6176612f6c616e672f496e74656765723b7870740006737472696e67737200116a6176612e6c616e672e496e746567657212e2a0a4f781873802000149000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b020000787000000000');

INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, LE_ID) VALUES ('admin', '000','administrator@gmail.com', 0, null);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, LE_ID) VALUES ('nikolaevha', '111','u.user1@gmail.com', 1, 1);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, LE_ID) VALUES ('parket', '111','u.user1@gmail.com', 1, 2);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, LE_ID) VALUES ('delivery_driver', '222','u.user2@gmail.com', 2, 3);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, LE_ID) VALUES ('shop_avto', '222','u.user2@gmail.com', 2, 4);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, LE_ID) VALUES ('logistic_drive', '222','u.user2@gmail.com', 2, 5);

insert into drivers(name, surname, status,legal_entity_id) values ('Иван', 'Иванов', 0, 3);
insert into drivers(name, surname, status,legal_entity_id) values ('Перт', 'Петров', 0, 3);

insert into transport(CARRYING_CAPACITY,MODEL,NUMBER_PLATE,STATUS,VEHICLE_TYPE,LEGAL_ENTITY_ID) values (5.1, 'Volvo', '1234 HI-3',0,0,3);
insert into transport(CARRYING_CAPACITY,MODEL,NUMBER_PLATE,STATUS,VEHICLE_TYPE,LEGAL_ENTITY_ID) values (5.8, 'MAN', '5678 EE-3',0,0,3);

insert into orders(DESCRIPTION,DEPARTURE,DESTINATION,WEIGHT,PRICE,STATUS,LEGAL_ENTITY_ID) values ('Мебель','Минск','Витебск',800,600,0,1);
insert into orders(DESCRIPTION,DEPARTURE,DESTINATION,WEIGHT,PRICE,STATUS,LEGAL_ENTITY_ID) values ('Продукты','Гомель','Гродно',400,550,0,2);

