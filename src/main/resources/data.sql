CREATE TABLE IF NOT EXISTS formula (
    id IDENTITY PRIMARY KEY,
    title VARCHAR(255),
    description CLOB,
    price DECIMAL(10,2),
    code BOOLEAN,
    promotionnal_price DECIMAL(10,2)
);

INSERT INTO formula (title, description, price, code, promotionnal_price) VALUES
('Forfait B 20H', 'Inscription ANTS, Accès salle de code en illimité, Code en ligne (Pass Rousseau), 20 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite', 1139.0, true, NULL),
('Forfait AAC 20H (Dès 15 ans)', 'Inscription ANTS, Accès salle de code en illimité, Code en ligne (Pass Rousseau), 20 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite, RDV pédagogique préalable avec l’accompagnateur (2h), 2 RDV pédagogiques (2h)', 1339.0, true, NULL),
('Formule B78 13H', 'Inscription ANTS, Accès salle de code en illimité, Code en ligne (Pass Rousseau), 13 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite', 839.0, true, NULL),
('Formule B78 20H', 'Inscription ANTS, Accès salle de code en illimité, Code en ligne (Pass Rousseau), 20 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite', 1139.0, true, NULL);


INSERT INTO formula (title, description, price, code, promotionnal_price) VALUES
('Forfait B 20H', 'Inscription ANTS, 20 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite', 1099.0, false, NULL),
('Forfait AAC 20H (Dès 15 ans)', 'Inscription ANTS, 20 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite, RDV pédagogique préalable avec l’accompagnateur (2h), 2 RDV pédagogiques (2h)', 1299.0, false, NULL),
('Formule B78 13H', 'Inscription ANTS, 13 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite', 799.0, false, NULL),
('Formule B78 20H', 'Inscription ANTS, 20 leçons de conduite, Livret pédagogique dématérialisé, Accompagnement à l’examen pratique de la conduite', 1099.0, false, NULL);
