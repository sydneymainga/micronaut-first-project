CREATE TABLE users (
                         id SERIAL NOT NULL,
                         name varchar(255) DEFAULT NULL,
                         email varchar(255) DEFAULT NULL,
                         mobile_number varchar(255) DEFAULT NULL,
                         PRIMARY KEY (id)
)