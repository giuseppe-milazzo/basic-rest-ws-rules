insert into user (username, password, addedAt) values ('user1', 'password1', sysdate()), ('user2', 'password2', sysdate());
insert into post (user, post) values (1, 'user1 first post'), (1, 'user1 second post'), (2, 'user2 first post');
insert into credential (username, password, role) values ('admin', 'admin', 'ADMIN'), ('user', 'user', 'USER');