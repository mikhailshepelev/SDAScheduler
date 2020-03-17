USE SDAScheduler;

insert into course(name, city)
values ('Java 9', 'Tallinn'),
('Python 2', 'Tallinn'),
('JavaScript 1', 'Riga');

insert into student(name, isMale, phoneNumber, email, course_courseID)
values ('Abdul Tamim Ghiasi', true, '58749575', 'tamim@gmail.com', 1),
('Shamshur Rahman', true, '4598754', 'rahman@gmail.com', 1),
('Ilya Garkusha', true, '6549836', 'ilya@icloud.com', 1);

insert into trainer(name, isMale, email, phoneNumber)
values ("Hatef Palizgar", true, "hatef@gmail.com", "54584357"),
("Bobur Mirzo", true, "bobur@icloud.com", "56342343"),
("Zino Adidi", true, "zinomagazino@gmail.com", "3487695");

insert into topic(name, course_courseID, trainer_trainerID)
values ("Java Advanced", 1, 1),
("JDBC & Hibernate", 1, 3),
("SQL and DataBases", 1, 3);

insert into lesson(lessonDate, lessonTime, venuePlace, topic_topicID)
values ("23.03.2020", 'LONG', 'SEASIDE', 1),
("15.02.2020", "SHORT", "CITYSIDE", 2),
("01.12.2019", "LONG", "SEASIDE", 3);

select * from student;
select * from course;
select * from trainer;
select * from topic;
select * from lesson;
