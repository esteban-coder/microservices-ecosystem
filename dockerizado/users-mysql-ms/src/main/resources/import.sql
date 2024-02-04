INSERT INTO `user` (username, password, enabled, first_name, last_name, email) VALUES ('ealiaga','$2a$10$pqw6GYZIqWnnucKsjA1MsOsiMuI3OhiOJKORbw6hmMTFE7rwl53Ie',1, 'Esteban', '@Coder','esteban.coder@gmail.com');
INSERT INTO `user` (username, password, enabled, first_name, last_name, email) VALUES ('admin','$2a$10$9HhYgzFYwUP1D.ifPoxg1uskOYSiegjo.OWavI/UAEmq6c5rTtoQW',1, 'Admin', '@Coder','admin.coder@gmail.com');

INSERT INTO `role` (name) VALUES ('ROLE_USER');
INSERT INTO `role` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `user_role` (user_id, role_id) VALUES (1, 1);
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 2);
INSERT INTO `user_role` (user_id, role_id) VALUES (2, 1);