DELETE
FROM `wallet`;

DELETE
FROM `user_slot`;

DELETE
FROM `rating`;

DELETE
FROM `topic_tags`;

DELETE
FROM `tag`;

DELETE
FROM `topic`;

DELETE
FROM `user`;

INSERT INTO `user`(`user_id`, `email`, `phone_number`, `university`, `user_degree`, `user_name`)
VALUES (1, 'aditya@illinois.edu', '9876543211', 'UIUC', 'MCS', 'Aditya K'),
       (2, 'akshath@illinois.edu', '9876543221', 'UIUC', 'MCS', 'Akshath SK'),
       (3, 'ishita@illinois.edu', '9876543321', 'UIUC', 'MCS', 'Ishita'),
       (4, 'neha@illinois.edu', '9876544321', 'UIUC', 'MCS', 'Neha RV'),
       (5, 'ajit@illinois.edu', '9876554321', 'UIUC', 'MCS', 'Ajit R'),
       (6, 'aniket@uis.edu', '9876654321', 'UIS', 'MSTM', 'Aniket A'),
       (7, 'abhi@illinois.edu', '9877654321', 'USC', 'MSCS', 'Abhi SA'),
       (8, 'akash@illinois.edu', '9887654321', 'UIUC', 'MSIS', 'Akash M'),
       (9, 'anu@illinois.edu', '9987654321', 'UMich', 'MSCS', 'Anu N'),
       (10, 'nikhil@illinois.edu', '9876543210', 'NEU', 'MSCS', 'Nikhil S');

INSERT INTO `wallet`(`wallet_id`, `credit`, `user_id`)
VALUES (11, 1000, 1),
       (12, 2000, 2),
       (13, 3000, 3),
       (14, 500, 4),
       (15, 100, 5),
       (16, 6000, 6),
       (17, 7000, 7),
       (18, 800, 8),
       (19, 90, 9),
       (20, 9000, 10);

INSERT INTO `tag`(`tag_id`, `tag_name`)
VALUES (21, 'Web Programming'),
       (22, 'Data Structures'),
       (23, 'Computer Architecture'),
       (24, 'Fullstack Development'),
       (25, 'Backend Development'),
       (26, 'Database'),
       (27, 'Virtual Reality'),
       (28, 'Distributed Systems'),
       (29, 'Software Engineering'),
       (30, 'Embedded Systems'),
       (31, 'Cloud'),
       (32, 'Computer Networks'),
       (33, 'Internet of Things'),
       (34, 'Artificial Intelligence'),
       (35, 'Reinforcement Learning'),
       (36, 'UI/UX'),
       (37, 'Algorithms'),
       (38, 'Operating Systems'),
       (39, 'Signal Processing'),
       (40, 'Thermal Systems'),
       (41, 'Internal Combustion Engines'),
       (42, 'Heat Transfer'),
       (43, 'Robotics'),
       (44, 'Industrial Control Systems'),
       (45, 'Other');

INSERT INTO `topic`(`topic_id`, `credit_per_hr`, `description`, `experience_level`, `overall_rating`, `topic_name`,
                    `user_id`)
VALUES (46, 10, 'Learn basics of time complexity', 5, 4.5, 'Time Complexity', 1),
       (47, 8, 'Learn basics of space complexity', 3, 4, 'Space Complexity', 1),
       (48, 10, 'Introduction to react', 4, 4.5, 'React basics', 2),
       (49, 10, 'Advanced topics in React', 1, 3.5, 'React', 2),
       (50, 10, 'Introduction to HTML5', 0.5, 4.5, 'HTML5', 2),
       (51, 10, 'Learn everything about CSS', 4, 4.5, 'CSS3', 3),
       (52, 10, 'Learn everything about JS', 6, 5, 'Javascript', 3),
       (53, 10, 'Learn basics of Ajax', 1, 4, 'Ajax basics', 3),
       (54, 10, 'Learn concepts for UIUC CS409 MP2', 5.5, 2, 'CS409 MP2', 3),
       (55, 10, 'Learn concepts for UIUC CS409 MP2', 3.5, 2.5, 'CS409 MP3', 3),
       (56, 10, 'Learn NoSQL with MongoDB', 3.5, 5, 'MongoDB', 3),
       (57, 10, 'Learn basics of NoSQL with Redis', 2, 4, 'Redis', 4),
       (58, 10, 'Learn SQL with AzureSQL', 2.5, 4.5, 'AzureSQL', 4),
       (59, 10, 'Learn basics of Software Development Lifecycle', 6.5, 4.5, 'SDLC', 5),
       (60, 10, 'Learn basics of Software Testing with Mockito', 7.5, 4.5, 'Junits', 6),
       (61, 10, 'Learn cloud concepts with AWS', 5, 4, 'AWS', 7),
       (62, 10, 'Learn cloud concepts with GCP', 5, 5, 'GCP', 7),
       (63, 10, 'Learn cloud concepts with Azure', 3.5, 4.5, 'Azure', 8),
       (64, 10, 'Learn cloud concepts with OCI', 5, 4.5, 'OCI', 8),
       (65, 10, 'Learn concepts of Deadlocks', 2, 3.5, 'Deadlocks', 9),
       (66, 10, 'Learn concepts of LRU', 2, 3.5, 'LRU Algorithm', 9),
       (67, 10, 'Learn concepts of FCFS', 2, 2.5, 'FCFS Algorithm', 9),
       (68, 10, 'Want to know how the Kruskals algorithm works?', 5.2, 5, 'Kruskals algorithm', 10),
       (69, 10, 'Want to know how the Dijkstras algorithm works?', 3.4, 5, 'Dijkstras algorithm', 10),
       (70, 10, 'Want to know how the Kadanes algorithm works?', 3, 5, 'Kadanes algorithm', 10),
       (71, 10, 'Want to know how to solve the traveling salesman problem?', 3, 5, 'Traveling Salesman Problem', 10),
       (72, 10, 'Learn concepts for UIUC CS435 MP2', 5, 3, 'Unicast Routing', 1),
       (73, 10, 'Learn concepts for UIUC CS435 MP1', 5, 4, 'HTTP Client', 1),
       (74, 10, 'Learn concepts for UIUC CS527 MP2', 5, 4, 'Configuration Tests', 2),
       (75, 10, 'Learn concepts for UIUC CS527 MP1', 5, 4, 'Falky Tests', 2);

INSERT INTO `topic_tags`(`tag_tag_id`, `topics_topic_id`)
VALUES (25, 46),
       (26, 46),
       (37, 46),
       (37, 47),
       (37, 47),
       (21, 48),
       (24, 48),
       (21, 49),
       (24, 49),
       (21, 50),
       (24, 50),
       (21, 51),
       (24, 51),
       (21, 52),
       (24, 52),
       (21, 53),
       (24, 53),
       (21, 54),
       (24, 54),
       (21, 55),
       (24, 55),
       (21, 56),
       (24, 56),
       (25, 56),
       (26, 56),
       (21, 57),
       (24, 57),
       (25, 57),
       (26, 57),
       (21, 58),
       (24, 58),
       (25, 58),
       (26, 58),
       (29, 59),
       (29, 60),
       (31, 61),
       (32, 62),
       (33, 63),
       (34, 64),
       (38, 65),
       (38, 66),
       (38, 67),
       (22, 68),
       (37, 68),
       (22, 69),
       (37, 69),
       (22, 70),
       (37, 70),
       (22, 71),
       (37, 71),
       (31, 72),
       (31, 73),
       (29, 74),
       (29, 75);

INSERT INTO `rating`(`rating_id`, `description`, `rating`, `topic_id`, `tutor_id`, `user_id`)
VALUES (76, 'Understood the concepts well', 4, 46, 1, 10),
       (77, 'Understood the concepts well', 4.5, 46, 1, 9),
       (78, 'Understood the concepts well', 4.4, 46, 1, 8),
       (79, 'Understood the concepts well', 4, 46, 1, 7),
       (80, 'Understood the concepts well', 4.5, 46, 1, 6),
       (81, 'Understood the concepts well', 3.5, 47, 1, 5),
       (82, 'Understood the concepts well', 3, 47, 1, 6),
       (83, 'Hard to follow', 3.5, 47, 1, 7),
       (84, 'Understood the concepts well', 3, 48, 2, 10),
       (85, 'Understood the concepts well', 3, 49, 2, 10),
       (86, 'Understood the concepts well', 3, 50, 2, 9),
       (87, 'Hard to follow', 3.5, 50, 2, 8),
       (88, 'Understood the concepts well', 4, 51, 3, 10),
       (89, 'Understood the concepts well', 4, 52, 3, 10),
       (90, 'Understood the concepts well', 4, 53, 3, 8),
       (91, 'Understood the concepts well', 4.5, 54, 3, 8),
       (92, 'Hard to follow', 3, 60, 6, 10),
       (93, 'Hard to follow', 3, 60, 6, 9),
       (94, 'Understood the concepts well', 3, 60, 6, 8),
       (95, 'Understood the concepts well', 3.5, 60, 6, 7),
       (96, 'Understood the concepts well', 4, 60, 6, 5),
       (97, 'Understood the concepts well', 4.5, 60, 6, 4),
       (98, 'Understood the concepts well', 4, 57, 4, 10),
       (99, 'Understood the concepts well', 4, 57, 4, 9),
       (100, 'Understood the concepts well', 4, 75, 2, 10),
       (101, 'Understood the concepts well', 5, 75, 2, 9),
       (102, 'Understood the concepts well', 5, 75, 2, 8),
       (103, 'Understood the concepts well', 5, 75, 2, 7),
       (104, 'Understood the concepts well', 5, 73, 1, 10),
       (105, 'Understood the concepts well', 5, 73, 1, 10);

INSERT INTO `user_slot`(`slot_id`, `end_time`, `is_booked`, `slot_date`, `start_time`, `booked_by_user_id`, `topic_id`,
                        `user_id`)
VALUES (106, '13:00', false, '2022-12-02', '12:00', null, null, 1),
       (107, '12:00', false, '2022-12-02', '13:00', null, null, 2),
       (108, '09:00', false, '2022-12-02', '08:00', null, null, 3),
       (109, '13:00', false, '2022-12-03', '12:00', null, null, 4),
       (110, '13:00', false, '2022-12-04', '12:00', null, null, 5),
       (111, '14:00', false, '2022-12-05', '12:00', null, null, 6),
       (112, '16:00', false, '2022-12-06', '15:00', null, null, 7),
       (113, '13:00', false, '2022-12-07', '12:00', null, null, 8),
       (114, '13:00', false, '2022-12-08', '11:00', null, null, 9),
       (115, '13:00', false, '2022-12-09', '12:00', null, null, 10),
       (116, '13:00', true, '2022-12-10', '12:00', 10, 46, 1),
       (117, '13:00', true, '2022-12-11', '12:00', 9, 46, 1),
       (118, '13:00', false, '2022-12-12', '12:00', null, null, 1),
       (119, '13:00', false, '2022-12-13', '12:00', null, null, 2),
       (120, '13:00', false, '2022-12-14', '12:00', null, null, 3),
       (121, '13:00', false, '2022-12-15', '12:00', null, null, 4),
       (122, '13:00', false, '2022-12-16', '12:00', null, null, 5),
       (123, '13:00', false, '2022-12-17', '12:00', null, null, 6),
       (124, '13:00', false, '2022-12-18', '12:00', null, null, 6),
       (125, '13:00', false, '2022-12-19', '12:00', null, null, 8),
       (126, '13:00', false, '2022-12-20', '12:00', null, null, 9),
       (127, '13:00', false, '2022-12-21', '12:00', null, null, 10),
       (128, '13:00', false, '2022-12-22', '12:00', null, null, 10),
       (129, '13:00', false, '2022-12-23', '12:00', null, null, 10),
       (130, '13:00', false, '2022-12-24', '12:00', null, null, 10),
       (131, '13:00', false, '2022-12-25', '12:00', null, null, 10),
       (132, '13:00', false, '2022-12-26', '12:00', null, null, 9),
       (133, '13:00', false, '2022-12-27', '12:00', null, null, 8),
       (134, '13:00', false, '2022-12-28', '12:00', null, null, 7),
       (135, '13:00', false, '2022-12-29', '12:00', null, null, 6),
       (136, '13:00', false, '2022-12-30', '12:00', null, null, 5);

UPDATE `hibernate_sequence`
SET `next_val`=137;



