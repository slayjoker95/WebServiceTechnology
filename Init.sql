CREATE TABLE `web_services`.`laptops` (
`id` bigint NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT null,
`CPU` varchar(255) NOT NULL,
`RAM` varchar(255) NOT NULL,
`video_card` varchar(255) NOT NULL,
`HDD` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('HP 15-bw006ur', 'AMD E2 9000e', '4096 Mb', 'AMD Radeon R2', '500 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('Asus X541NA-GQ359', 'Pentium N4200', '4096 Mb', 'Intel HD Graphics 505', '500 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('Dell Inspiron 5567', 'Intel Core i5', '8192 Mb', 'AMD Radeon R7 M445', '1000 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('LENOVO IdeaPad 320S-15ISK', 'Intel Core i3 6006U', '4096 Mb', 'nVidia GeForce 920MX', '1000 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('ACER Extensa EX2540-34YR', 'Intel Core i3 6006U', '4096 Mb', 'Intel HD Graphics 520', '500 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('DIGMA CITI E401', 'Intel Atom X5 Z8350', '4096 Mb', 'Intel HD Graphics 400', '500 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('ACER TravelMate TMP278-M-P5JU', 'Intel Pentium 4405U', '4096 Mb', 'Intel HD Graphics 510', '500 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('Dell Vostro 5568-0320', 'Intel i5-7200U', '8192 Mb', 'NVIDIA GeForce 940MX', '1000 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('LENOVO V310-15ISK', 'Intel Core i7 6500U', '8192 Mb', 'AMD Radeon R5 M430', '1000 Gb');
INSERT INTO laptops(name, CPU, RAM, video_card, HDD) values ('Asus ROG GL752VW-T4535T', 'Intel Core i5 6300HQ', '8192 Mb', ' NVIDIA GeForce GTX 960M', '1000 Gb');