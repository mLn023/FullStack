INSERT INTO DEVELOPPEUR (name, firstname, function) VALUES
  ('Henry', 'Mhilan', 'Junior'),
  ('Hollertt', 'Marceau', 'Junior'),
  ('Jourdain', 'Nicolas', 'Senior'),
  ('George', 'Lucas', 'Junior'),
  ('Nicolas', 'Cage', 'Senior'),
  ('Machin', 'Bidule', 'Junior'),
  ('Truc', 'Muche', 'Senior'),
  ('Sapin', 'Noel', 'Junior'),
  ('Latart', 'Ifflette', 'Senior'),
  ('Pietrzak', 'Aurelien', 'Senior');

INSERT INTO BUG (description, name, priority, developpeur_id, status, created_at) VALUES
  ('La page A ne repond pas' ,'Probleme Affichage', 'HAUTE', 1, 'TODO', '23/09/2020'),
  ('La page B ne repond pas' ,'Probleme conversion', 'BASSE', 4, 'DONE', '21/02/2020'),
  ('La page C ne repond pas' ,'Probleme Root', 'HAUTE', 3, 'ONGOING', '23/09/2020'),
  ('La page D ne repond pas' ,'Probleme Entity', 'MOYENNE', 2, 'TODO', '23/09/2019'),
  ('La page E ne repond pas' ,'Probleme Exception', 'HAUTE', 1, 'ONGOING', '23/09/2019'),
  ('La page F ne repond pas' ,'Probleme Server', 'BASSE', 3, 'TODO', '23/09/2019'),
  ('La page G ne repond pas' ,'Probleme Security', 'MOYENNE', 4, 'DONE', '23/09/2013'),
  ('La page H ne repond pas' ,'Probleme conversion', 'BASSE', 2, 'DONE', '23/09/2019'),
  ('La page Z ne repond pas' ,'Probleme ', 'MOYENNE', 3, 'TODO', '23/09/1996');


INSERT INTO COMMENTARY(description, bug_id, developpeur_id) VALUES
('BUG RESOLU', 2, 2 ),
('BUG RESOLU', 1, 1 ),
('BUG RESOLU', 3, 3 ),
('BUG RESOLU', 4, 4 ),
('BUG RESOLU', 3, 2 ),
('BUG RESOLU', 4, 2 ),
('BUG RESOLU', 1, 5 ),
('BUG RESOLU', 2, 8 ),
('BUG RESOLU', 5, 7 ),
('BUG RESOLU', 5, 6 ),
('BUG RESOLU', 7, 2 ),
('BUG RESOLU', 8, 5 ),
('BUG RESOLU', 9, 3 ),
('BUG RESOLU', 6, 7 ),
('BUG RESOLU', 5, 3 ),
('BUG RESOLU', 4, 8 ),
('BUG RESOLU', 3, 3 ),
('BUG RESOLU', 5, 1 ),
('BUG RESOLU', 4, 2 ),
('BUG RESOLU', 4, 1 ),
('BUG RESOLU', 5, 4 ),
('BUG RESOLU', 1, 4 ),
('BUG_TEST', 2,3);