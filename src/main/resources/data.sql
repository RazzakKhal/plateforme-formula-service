DROP TABLE IF EXISTS formula CASCADE;

DELETE FROM formulas;

INSERT INTO formulas (id, title, description, price, code, promotionnal_price, created_by, created_at, updated_by, updated_at) VALUES
('4c3495fd-46d1-4409-bd22-976d9205f6b8', 'Forfait B 20H', 'Inscription ANTS, Acces salle de code en illimite, Code en ligne (Pass Rousseau), 20 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite', 1139.0, true, NULL, 'system-seed', NOW(), NULL, NULL),
('5c9f9707-e101-4718-a83f-f53a8c83edc2', 'Forfait AAC 20H (Des 15 ans)', 'Inscription ANTS, Acces salle de code en illimite, Code en ligne (Pass Rousseau), 20 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite, RDV pedagogique prealable avec l''accompagnateur (2h), 2 RDV pedagogiques (2h)', 1339.0, true, NULL, 'system-seed', NOW(), NULL, NULL),
('79a0b52a-3a5b-4dff-9a11-b63ff0bf6f95', 'Formule B78 13H', 'Inscription ANTS, Acces salle de code en illimite, Code en ligne (Pass Rousseau), 13 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite', 839.0, true, NULL, 'system-seed', NOW(), NULL, NULL),
('fec8d5bd-e5e9-4e1d-b75a-e32b85f4c3dd', 'Formule B78 20H', 'Inscription ANTS, Acces salle de code en illimite, Code en ligne (Pass Rousseau), 20 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite', 1139.0, true, NULL, 'system-seed', NOW(), NULL, NULL),
('8dc2b85f-c35d-4e3e-bd15-f5272a4f7a8f', 'Forfait B 20H', 'Inscription ANTS, 20 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite', 1099.0, false, NULL, 'system-seed', NOW(), NULL, NULL),
('8a2417d4-bf5e-46ab-8ab8-4e43b59059db', 'Forfait AAC 20H (Des 15 ans)', 'Inscription ANTS, 20 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite, RDV pedagogique prealable avec l''accompagnateur (2h), 2 RDV pedagogiques (2h)', 1299.0, false, NULL, 'system-seed', NOW(), NULL, NULL),
('b9ef6f74-c097-4d31-8a76-7f8877d52c20', 'Formule B78 13H', 'Inscription ANTS, 13 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite', 799.0, false, NULL, 'system-seed', NOW(), NULL, NULL),
('e5da7ec7-cba5-4ce5-a2b1-c41d45f3da97', 'Formule B78 20H', 'Inscription ANTS, 20 lecons de conduite, Livret pedagogique dematerialise, Accompagnement a l''examen pratique de la conduite', 1099.0, false, NULL, 'system-seed', NOW(), NULL, NULL);
