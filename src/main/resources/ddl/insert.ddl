DELETE FROM votes;
DELETE FROM menus;
DELETE FROM establishments;
DELETE FROM users;

ALTER SEQUENCE seq_votes          RESTART WITH 1;
ALTER SEQUENCE seq_menus          RESTART WITH 1;
ALTER SEQUENCE seq_establishments RESTART WITH 1;
ALTER SEQUENCE seq_users          RESTART WITH 1;

INSERT INTO users (name, email, password, role) VALUES
  ('Lynn Douglas', 'l.douglas@gmail.com', '$2a$10$cqshpRXyPwKV19/p6hy8f.UD0eW08aLyjXEbeosxIXvC/pkov9hiS', 'ADMIN'),
  ('Scott Welch',  's.welch@gmail.com',   '$2a$10$IJCpBm3bSRpufGZOKNuL1eC1rGDBSrOUSvjr2dADkRNaQBG63/ioS', 'USER');

INSERT INTO establishments (name, address, phone, website) VALUES
  ('Dovetail',  '103 W 77th St, New York, NY 10024',      '+1 212-362-3800', 'http://www.dovetailnyc.com'),
  ('The Smith', '1900 Broadway, New York, NY 10023',      '+1 212-496-5700', 'http://thesmithrestaurant.com'),
  ('Marea',     '240 Central Park S, New York, NY 10019', '+1 212-582-5100', 'http://www.marea-nyc.com'),
  ('Ai Fiori',  '400 5th Ave #2, New York, NY 10018',     '+1 212-613-8660', 'http://aifiorinyc.com');

INSERT INTO menus (appetizer, entree, beverage, dessert, price, establishment_id) VALUES
  ('Corned beef tongue', 'Cod en papillote', 'Fresh squeezed juice',        'Meyer lemon meringue pie', 7800, 1),
  ('Seared tuna salad',  'Pot of mussels',   'Organic strawberry lemonade', 'Caramelized apple pie',    7200, 2),
  ('Baccala',            'Tagliolini',       'Sweet greens and lemon',      'Bomboloni',                6800, 3),
  ('Crudo di passera',   'Pollo arrosto',    'Green juice',                 'Gelati',                   7000, 4);