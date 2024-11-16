-- Создаем последовательность вручную
CREATE SEQUENCE user_id_seq START 1 INCREMENT 1;

-- Создаем тип ENUM для ролей
CREATE TYPE role_enum AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

-- Создаем таблицу users и используем тип role_enum для поля role
CREATE TABLE users (
    id BIGINT PRIMARY KEY DEFAULT nextval('user_id_seq'),
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role role_enum NOT NULL
);
