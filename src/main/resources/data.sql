
INSERT INTO Developpeur (id, name, first_name, poste) VALUES
  (1, 'Henry', 'Mhilan', 'Junior'),
  (2, 'Hollertt', 'Marceau', 'Junior'),
  (3, 'Nicolas', 'Jourdain', 'Senior');
  (4, 'Pietrzak', 'Aurélien', 'Senior');

INSERT INTO Bug (id, nom, status, developpeur_id) VALUES
  (1, 'Probleme Affichage', 'TODO', 4),
  (2, 'Hollertt', 'FIXED', 1),
  (3, 'Nicolas', 'ONGOING', 1);
  (4, 'Pietrzak', 'FIXED', 3);
