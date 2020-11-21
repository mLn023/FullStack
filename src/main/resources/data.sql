INSERT INTO DEVELOPPEUR (id, name, firstname, function) VALUES
  (1, 'Henry', 'Mhilan', 'Junior'),
  (2, 'Hollertt', 'Marceau', 'Junior'),
  (3, 'Nicolas', 'Jourdain', 'Senior'),
  (4, 'Pietrzak', 'Aurelien', 'Senior');

INSERT INTO BUG (id, description, nom, priority, developpeur_id, status, created_at) VALUES
  (1, 'La page X ne repond pas' ,'Probleme Affichage', 'HAUTE', 1, 'TODO', '23/09/1996'),
  (2, 'La page Y ne repond pas' ,'Probleme conversion', 'BASSE', 2, 'TODO', '23/09/1996'),
  (3, 'La page Z ne repond pas' ,'Probleme ', 'MOYENNE', 3, 'TODO', '23/09/1996');


INSERT INTO COMMENTARY(id, description, bug_id, developpeur_id) VALUES
(1,'BUG RESOLU', 2, 3 );