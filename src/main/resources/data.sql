INSERT INTO DEVELOPPEUR (id, name, firstname, function) VALUES
  (1, 'Henry', 'Mhilan', 'Junior'),
  (2, 'Hollertt', 'Marceau', 'Junior'),
  (3, 'Nicolas', 'Jourdain', 'Senior'),
  (4, 'Pietrzak', 'Aurelien', 'Senior');

INSERT INTO BUG (id, nom, status) VALUES
  (1, 'Probleme Affichage', 'TODO'),
  (2, '404NotFound', 'FIXED'),
  (3, 'Jaipasdidee', 'ONGOING'),
  (4, 'Hacked', 'FIXED');

INSERT INTO BUG_LISTEDEVS (Listebugs_id, Listedevs_id) VALUES
  (1,2);

INSERT INTO COMMENTARY(id, description, created_at, developpeur_id, bug_id) VALUES
(1,'Je teste le commentaire 1 pour le bug 2 du dev 3','23/09/1996', 3, 1);