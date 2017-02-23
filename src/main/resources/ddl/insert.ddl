DELETE FROM users;
DELETE FROM menus;
DELETE FROM establishments;
DELETE FROM votes;

ALTER SEQUENCE seq_users          RESTART WITH 1;
ALTER SEQUENCE seq_menus          RESTART WITH 1;
ALTER SEQUENCE seq_establishments RESTART WITH 1;
ALTER SEQUENCE seq_votes          RESTART WITH 1;

INSERT INTO users (name, email, password, role) VALUES
  ('Lynn Douglas', 'l.douglas@gmail.com', '$2a$10$cqshpRXyPwKV19/p6hy8f.UD0eW08aLyjXEbeosxIXvC/pkov9hiS', 'ADMIN'),
  ('Scott Welch',  's.welch@gmail.com',   '$2a$10$IJCpBm3bSRpufGZOKNuL1eC1rGDBSrOUSvjr2dADkRNaQBG63/ioS', 'USER');