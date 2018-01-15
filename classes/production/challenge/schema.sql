DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS followers;

-- Feel free to augment or modify these schemas (and the corresponding data) as you see fit!
CREATE TABLE people (
    id IDENTITY NOT NULL UNIQUE,
    handle VARCHAR NOT NULL UNIQUE,
    name VARCHAR
);

CREATE TABLE messages (
    id IDENTITY,
    person_id NUMBER REFERENCES people (id),
    content VARCHAR
);

CREATE TABLE followers (
    id IDENTITY,
    person_id NUMBER REFERENCES people (id),
    follower_person_id NUMBER REFERENCES people (id)
);
