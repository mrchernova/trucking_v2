DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
  id int NOT NULL,
  title varchar(255) NOT NULL,
  contact varchar(255) NOT NULL,
  user_id int NOT NULL,
  PRIMARY KEY (id),
  KEY user_id_idx (user_id),
  CONSTRAINT c_user_id FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


LOCK TABLES clients WRITE;

INSERT INTO clients VALUES (1,'Евроопт','+375 (29) 111-11-11',1),(2,'Ами Мебель','+375 (29) 222-22-22',3),(3,'IKEA','+375 (29) 333-33-33',2);

UNLOCK TABLES;



DROP TABLE IF EXISTS drivers;

CREATE TABLE drivers (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  surname varchar(45) NOT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;


LOCK TABLES drivers WRITE;
INSERT INTO drivers VALUES (1,'Иван','Иванов',1),(2,'Петр','Петров',1),(3,'Антон','Антонов',1);
UNLOCK TABLES;


DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
  id int NOT NULL AUTO_INCREMENT,
  description varchar(255) NOT NULL,
  weight decimal(4,1) NOT NULL,
  departure varchar(45) NOT NULL,
  destination varchar(45) NOT NULL,
  price decimal(5,2) NOT NULL,
  client_id int NOT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id),
  KEY client_idx (client_id),
  CONSTRAINT ord_client_id FOREIGN KEY (client_id) REFERENCES clients (id) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

LOCK TABLES orders WRITE;
INSERT INTO orders VALUES (1,'Продукты',300.0,'Минск','Витебск',600.00,1,0),(2,'Шкаф',150.0,'Гомель','Гродно',250.00,2,0),(3,'Диван',350.0,'Гомель','Минск',200.00,3,0),(4,'Стол',16.0,'Брест','Могилев',160.00,2,2);
UNLOCK TABLES;


DROP TABLE IF EXISTS orders_base;
CREATE TABLE orders_base (
  id int NOT NULL AUTO_INCREMENT,
  order_id int NOT NULL,
  driver_id int NOT NULL,
  transport_id int NOT NULL,
  organization_id int NOT NULL,
  description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY order_id_idx (order_id),
  KEY driver_id_idx (driver_id),
  KEY transport_id_idx (transport_id),
  KEY organization_id_idx (organization_id),
  CONSTRAINT bo_driver_id FOREIGN KEY (driver_id) REFERENCES drivers (id),
  CONSTRAINT bo_order_id FOREIGN KEY (order_id) REFERENCES orders (id),
  CONSTRAINT bo_organization_id FOREIGN KEY (organization_id) REFERENCES organizations (id),
  CONSTRAINT bo_transport_id FOREIGN KEY (transport_id) REFERENCES transport (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES orders_base WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS organizations;
CREATE TABLE organizations (
  id int NOT NULL AUTO_INCREMENT,
  title varchar(255) NOT NULL,
  contact varchar(255) DEFAULT NULL,
  driver_id int DEFAULT NULL,
  transport_id int DEFAULT NULL,
  user_id int NOT NULL,
  PRIMARY KEY (id),
  KEY user_id_idx (user_id),
  KEY org_driver_id_idx (driver_id),
  KEY org_transport_id_idx (transport_id),
  CONSTRAINT org_driver_id FOREIGN KEY (driver_id) REFERENCES drivers (id),
  CONSTRAINT org_transport_id FOREIGN KEY (transport_id) REFERENCES transport (id),
  CONSTRAINT org_user_id FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

LOCK TABLES organizations WRITE;
INSERT INTO organizations VALUES (1,'ИП Перевозки',NULL,NULL,NULL,3),(2,'ООО Доставка',NULL,NULL,NULL,3);
UNLOCK TABLES;


DROP TABLE IF EXISTS transport;
CREATE TABLE transport (
  id int NOT NULL AUTO_INCREMENT,
  model varchar(45) NOT NULL,
  vehicle_type varchar(45) NOT NULL,
  carrying_capacity decimal(5,0) NOT NULL,
  number_plate varchar(9) NOT NULL,
  status_id int NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY number_plate_UNIQUE (number_plate)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

LOCK TABLES transport WRITE;
INSERT INTO transport VALUES (1,'DAF','truck',6,'1234 AE-7',1),(2,'Volvo','truck',5,'5468 EE-1',1),(3,'Mersedes','van',4,'5367 II-2',1),(4,'MAN','truck',6,'2334 RT-3',1),(5,'Renault','truck',5,'8654 OO-4',1),(6,'Scania','truck',5,'3562 RE-5',1),(7,'Volkswagen','van',4,'4353 HH-6',1);
UNLOCK TABLES;


DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  login varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  role_id int NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;


LOCK TABLES users WRITE;
INSERT INTO users VALUES (1,'evroopt','1111',2),(2,'ikea','1111',2),(3,'ami','1111',2),(4,'ip_perevozki','1111',3),(5,'ooo_dostavka','1111',3),(6,'administrator','1234',1);
UNLOCK TABLES;
