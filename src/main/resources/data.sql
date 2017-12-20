INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (1, 'Bxl', 'Belgium', '37', 1080, 'Rue vandernoot');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (2, 'Bxl', 'Belgium', '132', 1070, 'Rue wayez');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (3, 'Bxl', 'Belgium', '45', 1000, 'Blv. Anspach');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (4, 'Bxl', 'Belgium', '37', 1080, 'Rue vandernoot');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (5, 'Bxl', 'Belgium', '37', 1080, 'Rue vandernoot');


INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender, auth_id)
VALUES('Dietetist', 4, 'momo@diet.com', 'Momo', 'Cop', '', '0', '1234 567 890', '', '', 4,
       NULL, '2017-10-17', '1990-04-11', 'F', 'auth0|5a38dd838d3cea7aad40e5ad ');
INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Admin', 5, 'mda@diet.com', 'MDA', 'VM', 'Boss', '0', '0987 654 321', '', 'YOLO', 5,
       NULL, '2017-04-25', '1991-11-09', 'M');

INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender, auth_id)
VALUES('Patient', 1, 'cal@pat.com', 'Caline', 'Coppens', '', '0', NULL, '', NULL, 1,
       NULL, '2017-12-11', '1993-11-01', 'F', 'auth0|5a33eb80ea8e2063b5c8cf7e');
INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Patient', 2, 'min@pat.com', 'Mina', 'Coppens', '', '0', NULL, '', NULL, 2,
       4, '2017-12-13', '1994-08-07', 'F');
INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Patient', 3, 'rob@pat.com', 'Roberta', 'Mergues', 'Brez', '0', NULL, '', NULL, 3,
       NULL, '2017-09-10', '2000-11-01', 'O');

INSERT INTO ANTHROPOMETRIC_PARAMETER(id, body_fat, date, length, waist_circumference, weight, patient_id)
VALUES(1, '13', '2017-12-03', '183', '83', '75.5', '1');
INSERT INTO ANTHROPOMETRIC_PARAMETER(id, body_fat, date, length, waist_circumference, weight, patient_id)
VALUES(2, '12', '2017-12-13', '183', '80', '72.2', '1');
INSERT INTO ANTHROPOMETRIC_PARAMETER(id, body_fat, date, length, waist_circumference, weight, patient_id)
VALUES(3, '12', '2017-12-23', '183', '78', '71.5', '1');
INSERT INTO ANTHROPOMETRIC_PARAMETER(id, body_fat, date, length, waist_circumference, weight, patient_id)
VALUES(4, '20', '2017-11-22', '173', '105', '95.5', '2');
INSERT INTO ANTHROPOMETRIC_PARAMETER(id, body_fat, date, length, waist_circumference, weight, patient_id)
VALUES(5, '18', '2017-12-02', '174', '102', '83.2', '2');