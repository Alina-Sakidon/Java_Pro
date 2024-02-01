CREATE TABLE IF NOT EXISTS Homework
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) UNIQUE  NOT NULL,
    description VARCHAR(255)  NOT NULL
);

CREATE TABLE IF NOT EXISTS Lesson
(
    id          serial PRIMARY KEY,
    homework_id INTEGER,
    name        VARCHAR(50) UNIQUE  NOT NULL,
    updatedAt TIMESTAMP  NOT NULL ,
    FOREIGN KEY (homework_id) REFERENCES Homework (id)
);

CREATE TABLE IF NOT EXISTS Schedule
(
    id          serial PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    updatedAt TIMESTAMP  NOT NULL ,
    lesson_id INTEGER,
    FOREIGN KEY (lesson_id) REFERENCES Lesson (id)
);