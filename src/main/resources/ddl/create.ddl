DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS menus;
DROP TABLE IF EXISTS establishments;

DROP SEQUENCE IF EXISTS seq_users;
DROP SEQUENCE IF EXISTS seq_menus;
DROP SEQUENCE IF EXISTS seq_establishments;

-------------------

CREATE SEQUENCE seq_users START 1;

CREATE TABLE users (
  id               INTEGER   PRIMARY KEY DEFAULT nextval('seq_users'),
  name             VARCHAR   NOT NULL,
  email            VARCHAR   NOT NULL,
  password         VARCHAR   NOT NULL,
  role             VARCHAR   NOT NULL,
  created          TIMESTAMP NOT NULL DEFAULT now(),
  enabled          BOOLEAN   NOT NULL DEFAULT TRUE,
  version          INTEGER   NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX unique_users ON users (email);

-------------------

CREATE SEQUENCE seq_establishments START 1;

CREATE TABLE establishments (
  id               INTEGER   PRIMARY KEY DEFAULT nextval('seq_establishments'),
  name             VARCHAR   NOT NULL,
  address          VARCHAR   NOT NULL,
  phone            VARCHAR   NOT NULL,
  website          VARCHAR   NOT NULL,
  created          TIMESTAMP NOT NULL DEFAULT now(),
  enabled          BOOLEAN   NOT NULL DEFAULT TRUE,
  version          INTEGER   NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX unique_establishments ON establishments (name);

-------------------

CREATE SEQUENCE seq_menus START 1;

CREATE TABLE menus (
  id               INTEGER   PRIMARY KEY DEFAULT nextval('seq_menus'),
  appetizer        VARCHAR   NOT NULL,
  entree           VARCHAR   NOT NULL,
  beverage         VARCHAR   NOT NULL,
  dessert          VARCHAR   NOT NULL,
  price            INTEGER   NOT NULL,
  establishment_id INTEGER   NOT NULL REFERENCES establishments ON DELETE CASCADE,
  created          TIMESTAMP NOT NULL DEFAULT now(),
  enabled          BOOLEAN   NOT NULL DEFAULT TRUE,
  version          INTEGER   NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX unique_menus ON menus (establishment_id, created);

-------------------

CREATE SEQUENCE seq_votes START 1;

CREATE TABLE votes (
  id               INTEGER   PRIMARY KEY DEFAULT nextval('seq_votes'),
  menu_id          INTEGER   NOT NULL REFERENCES menus ON DELETE CASCADE,
  user_id          INTEGER   NOT NULL REFERENCES users ON DELETE CASCADE,
  rating           INTEGER   NOT NULL,
  created          TIMESTAMP NOT NULL DEFAULT now(),
  enabled          BOOLEAN   NOT NULL DEFAULT TRUE,
  version          INTEGER   NOT NULL DEFAULT 0
);

CREATE UNIQUE INDEX unique_votes ON votes (menu_id, user_id);