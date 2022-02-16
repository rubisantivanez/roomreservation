DROP TABLE IF EXISTS building, company, floor, meeting_room, reservation, multimedia, meeting_room_multimedia;

CREATE TABLE company
(
    id          LONG AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(250)
);

CREATE TABLE building
(
    id         LONG AUTO_INCREMENT PRIMARY KEY,
    company_id LONG NOT NULL,
    name       VARCHAR(50),
    FOREIGN KEY (company_id) REFERENCES company (id)
);

CREATE TABLE floor
(
    id           LONG AUTO_INCREMENT PRIMARY KEY,
    building_id  LONG NOT NULL,
    number_floor INT  NOT NULL,
    name         VARCHAR(50),
    description  VARCHAR(150),
    FOREIGN KEY (building_id) REFERENCES building (id)
);

CREATE TABLE meeting_room
(
    id             LONG AUTO_INCREMENT PRIMARY KEY,
    room_name      VARCHAR(100),
    floor_id       LONG NOT NULL,
    max_allocation INT  NOT NULL,
    building_id    LONG NOT NULL,
    FOREIGN KEY (floor_id) REFERENCES floor (id),
    FOREIGN KEY (building_id) REFERENCES building (id)
);

CREATE TABLE reservation
(
    id              LONG AUTO_INCREMENT PRIMARY KEY,
    meeting_room_id LONG NOT NULL,
    start_date      DATE NOT NULL,
    FOREIGN KEY (meeting_room_id) REFERENCES meeting_room (id)
);

CREATE TABLE multimedia
(
    id          LONG AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(100)
);

CREATE TABLE meeting_room_multimedia
(
    meeting_room_id LONG NOT NULL,
    multimedia_id   LONG NOT NULL,
    PRIMARY KEY (meeting_room_id, multimedia_id)
);

INSERT INTO multimedia (name)
VALUES ('Projector'),
       ('Sound bass');

INSERT INTO company (name)
VALUES ('Nikon'),
       ('CC Construction Company'),
       ('ABC Company');

INSERT INTO building (company_id, name)
VALUES (1, 'Nikon Main Tower'),
       (2, 'CC Construction Secondary Tower'),
       (3, 'CC Construction Main Tower');

INSERT INTO floor (building_id, number_floor, name)
VALUES (1, 2, 'Main Mezzanine'),
       (1, 1, 'Lobby'),
       (1, 5, 'Entertainment Floor');

INSERT INTO floor (building_id, number_floor)
VALUES (1, 2),
       (3, 1),
       (1, 5);

INSERT INTO meeting_room (floor_id, building_id, room_name, max_allocation)
VALUES (1, 1, 'Main lounge', 100),
       (1, 1, 'Auxiliary lounge', 70),
       (3, 2, 'Small room 1', 10),
       (3, 2, 'Small room 2', 10),
       (3, 2, 'Medium room 1', 30);