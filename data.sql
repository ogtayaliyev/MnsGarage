#
#                     --VOITURES --------------------------------
# INSERT INTO voitures (anne_fabrication, couleur, boite, carroserie, carburant, kilometrage, plaque_immatriculation, etat_vente) VALUES
#                                                                                                                                   ('2015-05-20', 'Rouge', 'Automatique', 'SUV', 'Essence', 45000, 'AB-123-CD', TRUE),
#                                                                                                                                   ('2017-07-10', 'Noir', 'Manuelle', 'Berline', 'Diesel', 30000, 'EF-456-GH', FALSE),
#                                                                                                                                   ('2018-09-15', 'Blanc', 'Automatique', 'Coupé', 'Hybride', 15000, 'IJ-789-KL', TRUE),
#                                                                                                                                   ('2020-01-25', 'Bleu', 'Manuelle', 'Hatchback', 'Essence', 5000, 'MN-012-OP', FALSE),
#                                                                                                                                   ('2016-11-30', 'Gris', 'Automatique', 'Break', 'Diesel', 60000, 'QR-345-ST', TRUE),
#                                                                                                                                   ('2019-03-18', 'Vert', 'Manuelle', 'Cabriolet', 'Electrique', 10000, 'UV-678-WX', TRUE),
#                                                                                                                                   ('2014-08-22', 'Jaune', 'Automatique', 'SUV', 'Essence', 70000, 'YZ-901-AB', FALSE),
#                                                                                                                                   ('2021-05-11', 'Marron', 'Manuelle', 'Berline', 'Hybride', 25000, 'CD-234-EF', TRUE),
#                                                                                                                                   ('2013-07-07', 'Rouge', 'Automatique', 'Coupé', 'Diesel', 80000, 'GH-567-IJ', FALSE),
#                                                                                                                                   ('2015-12-05', 'Noir', 'Manuelle', 'Hatchback', 'Electrique', 20000, 'KL-890-MN', TRUE),
#
#                                                                                                                                   ('2022-02-15', 'Blanc', 'Automatique', 'Break', 'Essence', 1000, 'OP-123-QR', TRUE);
#
#                                  -- VOITURE MARQUE --------------------------------
#
# INSERT INTO voiture_marque (marque_nom, pays_fabriquant) VALUES
#                                                              ('Ford', 'USA'),
#                                                              ('Honda', 'Japon'),
#                                                              ('BMW', 'Allemagne'),
#                                                              ('Mercedes-Benz', 'Allemagne'),
#                                                              ('Peugeot', 'France'),
#                                                              ('Audi', 'Allemagne'),
#                                                              ('Hyundai', 'Corée du Sud');

                                      -- VOITURE MODEL ------------------------

# INSERT INTO voiture_model (model_nom, mise_circulation, moteure_type, moteure_puissance, marque_id) VALUES
#                                                                                                         ('Fiesta', '2016-05-15', 'Essence', 100, 1),
#                                                                                                         ('Focus', '2018-03-20', 'Diesel', 120, 1),
#                                                                                                         ('Mustang', '2020-09-12', 'Essence', 450, 1),
#                                                                                                         ('Civic', '2015-10-10', 'Essence', 110, 2),
#                                                                                                         ('Accord', '2017-11-20', 'Hybride', 150, 2),
#                                                                                                         ('CR-V', '2019-04-18', 'Diesel', 140, 2),
#                                                                                                         ('208', '2015-12-01', 'Essence', 95, 5),
#                                                                                                         ('308', '2018-10-17', 'Diesel', 130, 5),
#                                                                                                         ('3008', '2020-03-22', 'Hybride', 180, 5),
#                                                                                                         ('A3', '2016-04-18', 'Essence', 150, 6),
#                                                                                                         ('Q5', '2018-06-25', 'Diesel', 190, 6),
#                                                                                                         ('e-tron', '2021-11-30', 'Electrique', 408, 6),
#                                                                                                         ('i30', '2017-01-15', 'Essence', 120, 7),
#                                                                                                         ('Santa Fe', '2019-05-28', 'Diesel', 200, 7),
#                                                                                                         ('Kona', '2021-08-12', 'Hybride', 140, 7),
#                                                                                                         ('Serie 3', '2016-06-30', 'Essence', 180, 3),
#                                                                                                         ('X5', '2018-08-22', 'Diesel', 220, 3),
#                                                                                                         ('i8', '2021-01-15', 'Hybride', 370, 3),
#                                                                                                         ('Classe A', '2017-05-18', 'Essence', 160, 4),
#                                                                                                         ('GLE', '2019-02-28', 'Diesel', 210, 4),
#
#                                             --------REPARATION TYPE -----------                                                                                           ('SLS AMG', '2020-07-05', 'Essence', 571, 4);
# INSERT INTO reparation_type (reparation_type, duree) VALUES
#                                                        ('Diagnostic', 40),
#                                                        ('Pneumatiques', 60),
#                                                        ('Service Electricien', 90),
#                                                        ('Courroie de distribution', 120),
#                                                        ('Réparation de moteur', 180);
            -- Garage Boxs------
# INSERT INTO box (superficie, prix_loc) VALUES
#                                            ('Petit', 50.0),
#                                            ('Normal', 75.0),
#                                            ('Grand', 100.0),
#
#
#                                           ('Très grand', 150.0);
