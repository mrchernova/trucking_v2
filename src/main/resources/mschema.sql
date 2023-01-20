DROP TABLE IF EXISTS legal_entity CASCADE;
CREATE TABLE legal_entity
(
    id      INT AUTO_INCREMENT NOT NULL,
    title   VARCHAR(255),
    contact BLOB,
    CONSTRAINT pk_legal_entity PRIMARY KEY (id)
);


DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       INT AUTO_INCREMENT NOT NULL,
    login    VARCHAR(255),
    password VARCHAR(255),
    email    VARCHAR(255),
    role     INT,
    status   VARCHAR(255),
    le_id    INT,
    CONSTRAINT pk_users PRIMARY KEY (id)
);
ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);
ALTER TABLE users
    ADD CONSTRAINT uc_users_login UNIQUE (login);
ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_LE FOREIGN KEY (le_id) REFERENCES legal_entity (id);










DROP TABLE IF EXISTS drivers CASCADE ;
CREATE TABLE drivers
(
    id              INT AUTO_INCREMENT NOT NULL,
    name            VARCHAR(255),
    surname         VARCHAR(255),
    status          INT,
    legal_entity_id INT,
    CONSTRAINT pk_drivers PRIMARY KEY (id)
);
ALTER TABLE drivers
    ADD CONSTRAINT FK_DRIVERS_ON_LEGAL_ENTITY FOREIGN KEY (legal_entity_id) REFERENCES legal_entity (id);



DROP TABLE IF EXISTS transport CASCADE;
CREATE TABLE transport
(
    id                INT AUTO_INCREMENT NOT NULL,
    model             VARCHAR(255),
    vehicle_type      INT,
    carrying_capacity DOUBLE,
    number_plate      VARCHAR(255),
    status            INT,
    legal_entity_id   INT,
    CONSTRAINT pk_transport PRIMARY KEY (id)
);
ALTER TABLE transport
    ADD CONSTRAINT FK_TRANSPORT_ON_LEGAL_ENTITY FOREIGN KEY (legal_entity_id) REFERENCES legal_entity (id);



DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders
(
    id              INT AUTO_INCREMENT NOT NULL,
    description     VARCHAR(255),
    weight          DOUBLE,
    departure       VARCHAR(255),
    destination     VARCHAR(255),
    price           DOUBLE,
    status          INT,
    legal_entity_id INT,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);
ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_LEGAL_ENTITY FOREIGN KEY (legal_entity_id) REFERENCES legal_entity (id);


DROP TABLE IF EXISTS completed_orders;
CREATE TABLE completed_orders
(
    id           INT AUTO_INCREMENT NOT NULL,
    report       VARCHAR(255),
    order_id     INT,
    driver_id    INT,
    transport_id INT,
    CONSTRAINT pk_completed_orders PRIMARY KEY (id)
);
ALTER TABLE completed_orders
    ADD CONSTRAINT FK_COMPLETED_ORDERS_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES drivers (id);
ALTER TABLE completed_orders
    ADD CONSTRAINT FK_COMPLETED_ORDERS_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);
ALTER TABLE completed_orders
    ADD CONSTRAINT FK_COMPLETED_ORDERS_ON_TRANSPORT FOREIGN KEY (transport_id) REFERENCES transport (id);