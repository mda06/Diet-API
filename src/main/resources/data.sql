INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (1, 'Bxl', 'Belgium', '37', 1080, 'Rue vandernoot');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (2, 'Bxl', 'Belgium', '132', 1070, 'Rue wayez');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (3, 'Bxl', 'Belgium', '45', 1000, 'Blv. Anspach');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (4, 'Bxl', 'Belgium', '37', 1080, 'Rue vandernoot');
INSERT INTO ADDRESS(id, city, country, number, postcode, street) VALUES (5, 'Bxl', 'Belgium', '37', 1080, 'Rue vandernoot');


INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Dietetist', 4, 'momo@diet.com', 'Momo', 'Cop', '', '0', '1234 567 890', '', 'First client', 4,
       NULL, '2017-10-17', '1990-04-11', 'F');
INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Dietetist', 5, 'mda@diet.com', 'MDA', 'VM', 'Boss', '0', '0987 654 321', '', 'YOLO', 5,
       NULL, '2017-04-25', '1991-11-09', 'M');

INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Patient', 1, 'cal@pat.com', 'Caline', 'Coppens', '', '0', NULL, '', NULL, 1,
       NULL, '2017-12-11', '1993-11-01', 'F');
INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Patient', 2, 'min@pat.com', 'Mina', 'Coppens', '', '0', NULL, '', NULL, 2,
       5, '2017-12-13', '1994-08-07', 'F');
INSERT INTO CUSTOMER(dtype, id, email, first_name, last_name, middle_name, phone, vat, extra_info, nickname, adr_id,
                     dietetist_id, created, birthday, gender)
VALUES('Patient', 3, 'rob@pat.com', 'Roberta', 'Mergues', 'Brez', '0', NULL, '', NULL, 3,
       NULL, '2017-09-10', '2000-11-01', 'O');