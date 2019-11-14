CREATE SEQUENCE hibernate_sequence;

CREATE TABLE profile
(
    id   BIGSERIAL NOT NULL,
    name VARCHAR   NOT NULL,
    surname VARCHAR   NOT NULL,
    username VARCHAR   NOT NULL,
    password VARCHAR   NOT NULL,

    PRIMARY KEY (id)
);