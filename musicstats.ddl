-- Generato da Oracle SQL Developer Data Modeler 17.3.0.261.1529
--   in:        2018-05-06 12:32:12 CEST
--   sito:      Oracle Database 12cR2
--   tipo:      Oracle Database 12cR2



CREATE TABLE effect (
    ideffect      INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    purpose       VARCHAR(127) NOT NULL,
    description   VARCHAR(127) NOT NULL
);

CREATE TABLE ifamilies (
    idfamily   INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(127)
);


CREATE TABLE instrument (
    idinstrument         INTEGER NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    name                 VARCHAR(127) NOT NULL,
    ifamilies_idfamily   INTEGER NOT NULL
);

CREATE TABLE keytone (
    idkey      INTEGER NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    tone       INTEGER NOT NULL,
    modality   VARCHAR(10)
);


CREATE TABLE midi (
    idmidi              INTEGER NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    name                VARCHAR(127) NOT NULL,
    tracks              INTEGER NOT NULL,
    bpm                 INTEGER NOT NULL,
    tempo_numerator     INTEGER NOT NULL,
    tempo_denominator   INTEGER NOT NULL,
    totrows             INTEGER NOT NULL,
    nonstatrows         INTEGER NOT NULL
);


CREATE TABLE note (
    idnote   INTEGER NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    value    VARCHAR(4) NOT NULL
);



CREATE TABLE title (
    idtitle   INTEGER NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    content   VARCHAR(127) NOT NULL
);



CREATE TABLE track (
    idtrack                   INTEGER NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    instrument_idinstrument   INTEGER NOT NULL
);


CREATE TABLE trackeffect (
    effect_ideffect   INTEGER NOT NULL ,
    track_idtrack     INTEGER NOT NULL
);

ALTER TABLE trackeffect ADD CONSTRAINT trackeffect_pk PRIMARY KEY ( effect_ideffect,
track_idtrack );

CREATE TABLE trackkey (
    keytone_idkey      INTEGER NOT NULL,
    track_idtrack      INTEGER NOT NULL
);

ALTER TABLE trackkey ADD CONSTRAINT trackkey_pk PRIMARY KEY ( keytone_idkey,
track_idtrack );

CREATE TABLE trackmidi (
    midi_idmidi     INTEGER NOT NULL,
    track_idtrack   INTEGER NOT NULL
);

ALTER TABLE trackmidi ADD CONSTRAINT trackmidi_pk PRIMARY KEY ( midi_idmidi,
track_idtrack );

CREATE TABLE tracknote (
    track_idtrack   INTEGER NOT NULL,
    note_idnote     INTEGER NOT NULL
);

ALTER TABLE tracknote ADD CONSTRAINT tracknote_pk PRIMARY KEY ( track_idtrack,
note_idnote );

CREATE TABLE tracktitle (
    track_idtrack   INTEGER NOT NULL,
    title_idtitle   INTEGER NOT NULL
);

ALTER TABLE tracktitle ADD CONSTRAINT tracktitle_pk PRIMARY KEY ( track_idtrack,
title_idtitle );

ALTER TABLE instrument
    ADD CONSTRAINT instrument_ifamilies_fk FOREIGN KEY ( ifamilies_idfamily )
        REFERENCES ifamilies ( idfamily )
            ON DELETE CASCADE;

ALTER TABLE track
    ADD CONSTRAINT track_instrument_fk FOREIGN KEY ( instrument_idinstrument )
        REFERENCES instrument ( idinstrument )
            ON DELETE CASCADE;

ALTER TABLE trackeffect
    ADD CONSTRAINT trackeffect_effect_fk FOREIGN KEY ( effect_ideffect )
        REFERENCES effect ( ideffect )
            ON DELETE CASCADE;

ALTER TABLE trackeffect
    ADD CONSTRAINT trackeffect_track_fk FOREIGN KEY ( track_idtrack )
        REFERENCES track ( idtrack )
            ON DELETE CASCADE;

ALTER TABLE trackkey
    ADD CONSTRAINT trackkey_key_fk FOREIGN KEY ( keytone_idkey )
        REFERENCES keytone (idkey );
		

ALTER TABLE trackkey
    ADD CONSTRAINT trackkey_track_fk FOREIGN KEY ( track_idtrack )
        REFERENCES track ( idtrack )
            ON DELETE CASCADE;

ALTER TABLE trackmidi
    ADD CONSTRAINT trackmidi_midi_fk FOREIGN KEY ( midi_idmidi )
        REFERENCES midi ( idmidi )
            ON DELETE CASCADE;

ALTER TABLE trackmidi
    ADD CONSTRAINT trackmidi_track_fk FOREIGN KEY ( track_idtrack )
        REFERENCES track ( idtrack )
            ON DELETE CASCADE;

ALTER TABLE tracknote
    ADD CONSTRAINT tracknote_note_fk FOREIGN KEY ( note_idnote )
        REFERENCES note ( idnote )
            ON DELETE CASCADE;

ALTER TABLE tracknote
    ADD CONSTRAINT tracknote_track_fk FOREIGN KEY ( track_idtrack )
        REFERENCES track ( idtrack )
            ON DELETE CASCADE;

ALTER TABLE tracktitle
    ADD CONSTRAINT tracktitle_title_fk FOREIGN KEY ( title_idtitle )
        REFERENCES title ( idtitle )
            ON DELETE CASCADE;

ALTER TABLE tracktitle
    ADD CONSTRAINT tracktitle_track_fk FOREIGN KEY ( track_idtrack )
        REFERENCES track ( idtrack )
            ON DELETE CASCADE;
