ALTER TABLE `air_ticket_booking`.`route` 
CHANGE COLUMN `date_arrival` `date_arrival` DATE NULL DEFAULT NULL ,
CHANGE COLUMN `date_departure` `date_departure` DATE NULL DEFAULT NULL ,
CHANGE COLUMN `time_arrival` `time_arrival` TIME NULL DEFAULT NULL ,
CHANGE COLUMN `time_departure` `time_departure` TIME NULL DEFAULT NULL ;

ALTER TABLE `air_ticket_booking`.`type_seat` 
CHANGE COLUMN `price_extra` `price_extra` DOUBLE NULL DEFAULT NULL ;

INSERT INTO `air_ticket_booking`.`air_craft` (`id_air_craft`, `name_air_craft`) VALUES ('1', 'Airbus A.320');
INSERT INTO `air_ticket_booking`.`air_craft` (`id_air_craft`, `name_air_craft`) VALUES ('2', 'Boeing 787-3');
INSERT INTO `air_ticket_booking`.`air_craft` (`id_air_craft`, `name_air_craft`) VALUES ('3', 'Embraer 195');
INSERT INTO `air_ticket_booking`.`air_craft` (`id_air_craft`, `name_air_craft`) VALUES ('4', 'Airbus A310');

INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('1', 'Tp. Hồ Chí Minh (SGN)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('2', 'Hà Nội (HAN)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('3', 'Buôn Ma Thuộc (BMV)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('4', 'Cần Thơ (VCA)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('5', 'Chu Lai (VCL)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('6', 'Đà Lạt (DLI)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('7', 'Đà Nẵng (DAD)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('8', 'Hải Phòng (HPH)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('9', 'Nha Trang(CXR)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('10', 'Phú Quốc (PQC)');
INSERT INTO `air_ticket_booking`.`departure` (`id_departure`, `name_departure`) VALUES ('11', 'Pleiku (PXU)');

INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('1', 'Tp. Hồ Chí Minh (SGN)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('2', 'Hà Nội (HAN)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('3', 'Buôn Ma Thuộc (BMV)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('4', 'Cần Thơ (VCA)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('5', 'Chu Lai (VCL)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('6', 'Đà Lạt (DLI)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('7', 'Đà Nẵng (DAD)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('8', 'Hải Phòng (HPH)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('9', 'Nha Trang(CXR)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('10', 'Phú Quốc (PQC)');
INSERT INTO `air_ticket_booking`.`destination` (`id_destination`, `name_destination`) VALUES ('11', 'Pleiku (PXU)');

INSERT INTO `air_ticket_booking`.`type_seat` (`id_type_seat`, `name_type_seat`, `price_extra`) VALUES ('1', 'BUSSINESS', '1.7');
INSERT INTO `air_ticket_booking`.`type_seat` (`id_type_seat`, `name_type_seat`, `price_extra`) VALUES ('2', 'skyBOSS', '1.5');
INSERT INTO `air_ticket_booking`.`type_seat` (`id_type_seat`, `name_type_seat`, `price_extra`) VALUES ('3', 'VELUXE', '1.2');
INSERT INTO `air_ticket_booking`.`type_seat` (`id_type_seat`, `name_type_seat`, `price_extra`) VALUES ('4', 'ECO', '1');

INSERT INTO `air_ticket_booking`.`route` (`id_route`, `date_arrival`, `date_departure`, `flag_route`, `name_route`, `price_route`, `time_arrival`, `time_departure`, `id_air_craft`, `id_departure`, `id_destination`) VALUES (1, '2023-08-10', '2023-08-10', 0, 'AL001', 500000, '09:30', '08:30', 1, 1, 2);
INSERT INTO `air_ticket_booking`.`route` (`id_route`, `date_arrival`, `date_departure`, `flag_route`, `name_route`, `price_route`, `time_arrival`, `time_departure`, `id_air_craft`, `id_departure`, `id_destination`) VALUES (3, '2023-08-11', '2023-08-11', 0, 'BF245', 600000, '17:00', '16:00', 2, 1, 2);
INSERT INTO `air_ticket_booking`.`route` (`id_route`, `date_arrival`, `date_departure`, `flag_route`, `name_route`, `price_route`, `time_arrival`, `time_departure`, `id_air_craft`, `id_departure`, `id_destination`) VALUES (4, '2023-08-10', '2023-08-10', 0, 'GD246', 700000, '20:00', '19:00', 3, 1, 2);
INSERT INTO `air_ticket_booking`.`route` (`id_route`, `date_arrival`, `date_departure`, `flag_route`, `name_route`, `price_route`, `time_arrival`, `time_departure`, `id_air_craft`, `id_departure`, `id_destination`) VALUES (5, '2023-08-20', '2023-08-20', 0, 'FG468', 800000, '20:00', '19:00', 1, 2, 1);
INSERT INTO `air_ticket_booking`.`route` (`id_route`, `date_arrival`, `date_departure`, `flag_route`, `name_route`, `price_route`, `time_arrival`, `time_departure`, `id_air_craft`, `id_departure`, `id_destination`) VALUES (6, '2023-08-20', '2023-08-20', 0, 'FG468', 900000, '13:00', '12:00', 2, 2, 1);
INSERT INTO `air_ticket_booking`.`route` (`id_route`, `date_arrival`, `date_departure`, `flag_route`, `name_route`, `price_route`, `time_arrival`, `time_departure`, `id_air_craft`, `id_departure`, `id_destination`) VALUES (7, '2023-08-21', '2023-08-21', 0, 'DT458', 900000, '13:00', '12:00', 3, 2, 1);

INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (1, 0, '1A', 1, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (2, 0, '1B', 1, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (3, 0, '1C', 1, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (4, 0, '1E', 1, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (5, 0, '1D', 1, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (6, 0, '2A', 1, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (7, 0, '2B', 1, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (8, 0, '2C', 1, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (9, 0, '2D', 1, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (10, 0, '2E', 1, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (11, 0, '3A', 1, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (12, 0, '3B', 1, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (13, 0, '3C', 1, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (14, 0, '3D', 1, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (15, 0, '3E', 1, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (16, 0, '4A', 1, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (17, 0, '4B', 1, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (18, 0, '4C', 1, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (19, 0, '4D', 1, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (20, 0, '4E', 1, 4);

INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (21, 0, '1A', 3, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (22, 0, '1B', 3, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (23, 0, '1C', 3, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (24, 0, '1E', 3, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (25, 0, '1D', 3, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (26, 0, '2A', 3, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (27, 0, '2B', 3, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (28, 0, '2C', 3, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (29, 0, '2D', 3, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (30, 0, '2E', 3, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (31, 0, '3A', 3, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (32, 0, '3B', 3, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (33, 0, '3C', 3, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (34, 0, '3D', 3, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (35, 0, '3E', 3, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (36, 0, '4A', 3, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (37, 0, '4B', 3, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (38, 0, '4C', 3, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (39, 0, '4D', 3, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (40, 0, '4E', 3, 4);

INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (41, 0, '1A', 4, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (42, 0, '1B', 4, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (43, 0, '1C', 4, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (44, 0, '1E', 4, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (45, 0, '1D', 4, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (46, 0, '2A', 4, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (47, 0, '2B', 4, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (48, 0, '2C', 4, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (49, 0, '2D', 4, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (50, 0, '2E', 4, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (51, 0, '3A', 4, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (52, 0, '3B', 4, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (53, 0, '3C', 4, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (54, 0, '3D', 4, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (55, 0, '3E', 4, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (56, 0, '4A', 4, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (57, 0, '4B', 4, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (58, 0, '4C', 4, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (59, 0, '4D', 4, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (60, 0, '4E', 4, 4);

INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (61, 0, '1A', 5, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (62, 0, '1B', 5, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (63, 0, '1C', 5, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (64, 0, '1E', 5, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (65, 0, '1D', 5, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (66, 0, '2A', 5, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (67, 0, '2B', 5, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (68, 0, '2C', 5, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (69, 0, '2D', 5, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (70, 0, '2E', 5, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (71, 0, '3A', 5, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (72, 0, '3B', 5, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (73, 0, '3C', 5, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (74, 0, '3D', 5, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (75, 0, '3E', 5, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (76, 0, '4A', 5, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (77, 0, '4B', 5, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (78, 0, '4C', 5, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (79, 0, '4D', 5, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (80, 0, '4E', 5, 4);

INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (81, 0, '1A', 6, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (82, 0, '1B', 6, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (83, 0, '1C', 6, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (84, 0, '1E', 6, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (85, 0, '1D', 6, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (86, 0, '2A', 6, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (87, 0, '2B', 6, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (88, 0, '2C', 6, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (89, 0, '2D', 6, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (90, 0, '2E', 6, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (91, 0, '3A', 6, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (92, 0, '3B', 6, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (93, 0, '3C', 6, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (94, 0, '3D', 6, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (95, 0, '3E', 6, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (96, 0, '4A', 6, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (97, 0, '4B', 6, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (98, 0, '4C', 6, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (99, 0, '4D', 6, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (100, 0, '4E', 6, 4);

INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (101, 0, '1A', 7, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (102, 0, '1B', 7, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (103, 0, '1C', 7, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (104, 0, '1E', 7, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (105, 0, '1D', 7, 1);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (106, 0, '2A', 7, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (107, 0, '2B', 7, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (108, 0, '2C', 7, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (109, 0, '2D', 7, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (110, 0, '2E', 7, 2);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (111, 0, '3A', 7, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (112, 0, '3B', 7, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (113, 0, '3C', 7, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (114, 0, '3D', 7, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (115, 0, '3E', 7, 3);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (116, 0, '4A', 7, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (117, 0, '4B', 7, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (118, 0, '4C', 7, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (119, 0, '4D', 7, 4);
INSERT INTO `air_ticket_booking`.`seat` (`id_seat`, `flag_seat`, `position_seat`, `id_route`, `id_type_seat`) VALUES (120, 0, '4E',7, 4);

INSERT INTO `air_ticket_booking`.`role` (`id_role`, `name_role`) VALUES ('1', 'Admin');
INSERT INTO `air_ticket_booking`.`role` (`id_role`, `name_role`) VALUES ('2', 'Customer');
INSERT INTO `air_ticket_booking`.`role` (`id_role`, `name_role`) VALUES ('3', 'Employee');

INSERT INTO `air_ticket_booking`.`employee` (`id_employee`, `date_employee`, `email_employee`, `flag_employee`, `gender`, `image`, `name_employee`, `tel_employee`, `account_id_account`) VALUES ('1', '20/01/1998', 'sang@gmail.com', 0, 0, 123, "Sang", 123123, 1);
INSERT INTO `air_ticket_booking`.`employee` (`id_employee`, `date_employee`, `email_employee`, `flag_employee`, `gender`, `image`, `name_employee`, `tel_employee`, `account_id_account`) VALUES ('2', '20/01/1999', 'phin@gmail.com', 0, 0, 123, "Phin", 123123, 2);

INSERT INTO `air_ticket_booking`.`customer` (`id_customer`, `address_customer`, `date_customer`, `email_customer`, `flag_customer`, `id_card_customer`, `img_customer`, `name_customer`, `nationality_customer`, `tel_customer`, `account_id_account`) VALUES ('1', 'xxx', '20/01/1998', 'sang@gmail.com',0, '123123', '123', 'Sang', 'Viet Nam', '123123', 3);




