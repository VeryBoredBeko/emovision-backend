CREATE SEQUENCE news_seq START 1 INCREMENT 1;

CREATE TABLE news (
    id BIGINT PRIMARY KEY DEFAULT nextval('news_seq'),
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    text TEXT NOT NULL,
    created_on TIMESTAMP NOT NULL,
    updated_on TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);