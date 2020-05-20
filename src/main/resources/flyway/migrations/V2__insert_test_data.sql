INSERT INTO user_table (email, encrypted_password) VALUES ('johan@gmail.com', 'johan');

INSERT INTO thing (thing, user_id) VALUES('My first thing', (SELECT id FROM user_table WHERE email='johan@gmail.com') );

INSERT INTO tag (name, thing_id) VALUES('tags', (SELECT id FROM thing WHERE thing='My first thing'));