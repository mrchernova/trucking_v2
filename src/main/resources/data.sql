
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "ШопАвтоТранс"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "Логистические решения"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ИП "Новак Ольга Олеговна"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "Ройал Дэливэри"');
INSERT INTO LEGAL_ENTITY (TITLE) VALUES ('ООО "ПаркетЛаб"');

INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('1', '$2a$12$fG2Hd8j/p/Al4OadlaVAGe.6yD//3LB13ww62YW7uQfTtdUQChko2','administrator@gmail.com', 'ADMINISTRATOR','ACTIVE', null);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('2', '$2a$12$RnJCcjVMR/faMM2pekPi1OZv5LQvxcBBnDsy57Yi6vFsUTuCu0FTu','u.user1@gmail.com', 'CLIENT', 'ACTIVE', 1);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('client2', '$2a$12$hh18XkiGvpuRLiaNtPD8/uEIGqsyOvcqdO/91DtRT9p2C2YE7coUC','u.user2@gmail.com', 'CLIENT', 'ACTIVE', 2);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('3', '$2a$12$ZylJyDi7JVAIVE5bXcPNQeqrbzbqbpgfdjClwKuSy9q4EDIxr1mlK','u.user3@gmail.com', 'CARRIER', 'ACTIVE', 3);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('carrier2', '$2a$12$MGmw9oE1n5Kx5JYnY7FJxeb5Rm2VtxxJNnVTjl7UN.MiG2hVr8ZRm','u.user4@gmail.com', 'CARRIER', 'ACTIVE', 4);
INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, ROLE, STATUS, LE_ID) VALUES ('carrier3', '$2a$12$qm5P0wO3e1Ucly4dr7ZD6.4maiTvJwK3uo7yBKpaGkqRVVMtU8EyK','u.user5@gmail.com', 'CARRIER', 'ACTIVE', 5);

insert into drivers(name, surname, status,legal_entity_id) values ('Иван', 'Иванов', 0, 3);
insert into drivers(name, surname, status,legal_entity_id) values ('Перт', 'Петров', 0, 3);

insert into transport(CARRYING_CAPACITY,MODEL,NUMBER_PLATE,STATUS,VEHICLE_TYPE,LEGAL_ENTITY_ID) values (5.1, 'Volvo', '1234 HI-3',0,0,3);
insert into transport(CARRYING_CAPACITY,MODEL,NUMBER_PLATE,STATUS,VEHICLE_TYPE,LEGAL_ENTITY_ID) values (5.8, 'MAN', '5678 EE-3',0,0,3);

insert into orders(DESCRIPTION,DEPARTURE,DESTINATION,WEIGHT,PRICE,STATUS,LEGAL_ENTITY_ID) values ('Мебель','Минск','Витебск',800,600,0,1);
insert into orders(DESCRIPTION,DEPARTURE,DESTINATION,WEIGHT,PRICE,STATUS,LEGAL_ENTITY_ID) values ('Продукты','Гомель','Гродно',400,550,0,2);