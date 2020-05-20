CREATE TABLE user_table (
    id SERIAL PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    encrypted_password VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE thing (
    id SERIAL PRIMARY KEY,
    thing VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    favourite BOOLEAN DEFAULT false,
    user_id INTEGER REFERENCES user_table(id) ON DELETE CASCADE
);

CREATE TABLE tag (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    thing_id INTEGER REFERENCES thing(id) ON DELETE CASCADE
);