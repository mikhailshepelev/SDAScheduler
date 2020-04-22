USE SDAScheduler;
SET GLOBAL time_zone = '+3:00';


insert into course(name, city)
values ('Java 9', 'Tallinn'),
('Java 10', 'Tallinn'),
('Java 11', 'Tartu'),
('Python 2', 'Tallinn'),
('Python 3', 'Tallinn'),
('JavaScript 1', 'Riga'),
('JavaScript 2', 'Riga');

# 20 students in java Tallinn 9, the rest have 3 people, pluss 3 without course
insert into student(name, isMale, phoneNumber, email, course_courseID)
values
('Abdul Tamim Ghiasi', true, '+37258749575', 'tamim@sda.com', 1),
('Shamshur Rahman', true, '+3724598754', 'rahman@sda.com', 1),
('Ilya Garkusha', true, '+3726549836', 'ilya@sda.com', 1),
('Marika Tamberg', false, '+3725936506', 'marika@sda.com', 1),
('Jaanika Paanika', false, '+3724475250', 'jaanika@sda.com', 2),
('Eeva-Liisa Veede', false, '+3726717117', 'eevaliisa@sda.com', 1),
('Jevgeni Solodjankin', true, '+3729026624', 'jevgeni@sda.com', 1),
('Donald Torres', true, '+3729866532', 'donald@sda.com', 2),
('Howard Rogers', true, '+3724709655', 'howard@sda.com', 2),
('Mariam Degebuadze', false, '+3723147691', 'mariam@sda.com', 1),
('Õnne Õuemaa', false, '+3725418631', '6nne@sda.com', 1),
('Oleksandr Unknown', true, '+3722466749', 'oleksandr@sda.com', 1),
('Deniss Unknown', true, '+3726232311', 'deniss@sda.com', 1),
('Stanislav Ratšinski', true, '+3724343748', 'stan@sda.com', 1),
('Maris Unknown', true, '+3727499407', 'maris@sda.com', 1),
('Mikhail Shepelev', true, '+3724355925', 'mikhail@sda.com', 1),
('Mladen Tarkolev', true, '+3728004726', 'mladen@sda.com', 1),
('Triin Rebane', false, '+3722671551', 'triin@sda.com', 1),
('Vladyslav Cherkashyn', true, '+3727111400', 'vlad@sda.com', 1),
('Taavo Leidorp', true, '+3728194037', 'taavo@sda.com', 1),
('Demi Avaliani', true, '+3724506597', 'demi@sda.com', 1),
('Dmitri Mistery', true, '+3722387923', 'dmitri@sda.com', 1),
('Lauri Suurväli', true, '+3723300525', 'lauri@sda.com', 1),
('Craig Clark', true, '+3727414414', 'craig@sda.com', 3),
('Dmitri Mistery', true, '+3722387923', 'dmitri@sda.com', 3),
('Jaan Jalgratas', true, '+3727187803', 'jaan@sda.com', 3),
('Kati Karu', false, '+3722015184', 'kati@sda.com', 3),
('Johnny Campbell', true, '+3722540552', 'johnny@sda.com', 4),
('Harold Gonzales', true, '+3727148548', 'harold@sda.com', 4),
('Jaana Lind', false, '+3722045264', 'jaana@sda.com', 4),
('Brian Harris', true, '+3723642360', 'brian@sda.com', 5),
('Scott Washington', true, '+3726632774', 'scott@sda.com', 5),
('Carolyn Patterson', false, '+3722110033', 'carolyn@sda.com', 5),
('Ilze Millers', false, '+3722251016', 'ilze@sda.com', 6),
('Karlis Millers', true, '+3727679863', 'karlis@sda.com', 6),
('Reinis Kaupers', true, '+3725502995', 'reinis@sda.com', 6),
('Jānis Jubalts', true, '+3729329891', 'janis@sda.com', 7),
('Ieva Kupce', false, '+3727526655', 'ieva@sda.com', 7),
('Jonathan Martin', true, '+3724159999', 'jonathan@sda.com',null),
('Steve Carter', true, '+3725840936', 'steve@sda.com',null),
('Judith Evans', false, '+3726949774', 'judith@sda.com',null),
('Kaspars Daugaviņš', true, '+3727761583', 'kaspars@sda.com', 7);


insert into trainer(name, isMale, email, phoneNumber)
values
("Hatef Palizgar", true, "hatef@sda.com", "+37254584357"),
("Bobur Mirzo", true, "bobur@sda.com", "+37256342343"),
("Feride Celic", false, "feride@sda.com", "+3729302776"),
("Dmitry Zinkevich", true, "dmitry@sda.com", "+3725090597"),
("Navin Reddy", true, "navin@sda.com", "+3727864324"),
("Trisha Gee", false, "trisha@sda.com", "+3726596602"),
("Guido van Rossum", true, "guido@sda.com", "+3728321102"),
("Ewa Jodlowska", false, "ewa@sda.com", "+3726905746"),
("Umar Hansa", true, "umar@sda.com", "+3726596602"),
("Zino Adidi", true, "zinomagazino@gmail.com", "+3723487695"),
("", true, "", "+37211111");

insert into topic(name, course_courseID, trainer_trainerID)
values
("Introduction to Java", 1, 3),
("Introduction to Java", 2, 3),
("Introduction to Java", 3, 3),
("Introduction to Python", 4, 7),
("Introduction to Python", 5, 7),
("Introduction to JS", 6, 9),
("Introduction to JS", 7, 9),
("Java Fundamentals", 1, 1),
("Java Fundamentals", 2, 1),
("Java Fundamentals", 3, 1),
("Java Fundamentals: Coding", 1, 2),
("Java Fundamentals: Coding", 2, 2),
("Java Fundamentals: Coding", 3, 2),
("Java Fundamentals: Testing", 1, 4),
("Java Fundamentals: Testing", 2, 4),
("Java Fundamentals: Testing", 3, 4),
("Algorithms", 1, 1),
("Algorithms", 2, 2),
("Algorithms", 3, 3),
("Algorithms", 4, 4),
("Algorithms", 5, 5),
("Java Advanced", 1, 1),
("Java Advanced", 2, 1),
("Java Advanced", 3, 1),
("Design Patterns & Good Practices", 1, 1),
("Design Patterns & Good Practices", 2, 1),
("Design Patterns & Good Practices", 3, 1),
("Java Advanced: Coding", 1, 2),
("Java Advanced: Coding", 2, 2),
("Java Advanced: Coding", 3, 2),
("Python Advanced", 4, 7),
("Database. SQL", 1, 10),
("Database. SQL", 2, 10),
("Database. SQL", 3, 10),
("Database. SQL", 4, 1),
("Database. SQL", 5, 1),
("Java FX", 1, 1),
("Java FX", 2, 2),
("Java FX", 3, 3),
("JDBC & Hibernate", 1, 10),
("JDBC & Hibernate", 2, 5),
("JDBC & Hibernate", 3, 5),
("Practical project", 1, 1),
("Practical project", 2, 1),
("Practical project", 3, 1),
("Practical project", 4, 8),
("Practical project", 5, 8),
("Practical project", 6, 9),
("Practical project", 7, 9),
("HR class", 1, 11),
("HR class", 2, 11),
("HR class", 3, 11),
("HR class", 4, 11),
("HR class", 5, 11),
("HR class", 6, 11),
("HR class", 7, 11),
("HTML, CSS, JavaScript", 1, 10),
("HTML, CSS, JavaScript", 2, 10),
("HTML, CSS, JavaScript", 3, 10),
("Angular", 1, 10),
("Angular", 2, 10),
("Angular", 3, 10),
("Spring", 1, 1),
("Spring", 2, 1),
("Spring", 3, 1),
("Software Testing- Advanced Features", 1, 11),
("Software Testing- Advanced Features", 2, 11),
("Software Testing- Advanced Features", 3, 11),
("Final Project", 1, 11),
("Final Project", 2, 11),
("Final Project", 3, 11),
("Final Project", 4, 11),
("Final Project", 5, 11),
("Final Project", 6, 11),
("Final Project", 7, 11),
("GIT", 1, 1),
("GIT", 2, 1),
("GIT", 3, 1),
("GIT", 4, 1),
("GIT", 5, 1),
("Intro to HTTP", 1, 11),
("Intro to HTTP", 2, 11),
("Intro to HTTP", 3, 11),
("Agile scrum", 1, 11),
("Agile scrum", 2, 11),
("Agile scrum", 3, 11),
("GIT", 6, 11),
("GIT", 7, 11),
("Loading Data in pandas", 4, 7),
("Loading Data in pandas", 5, 8),
("Matplotlib", 4, 7),
("Matplotlib", 5, 8),
("React", 6, 9),
("Break", 1, 11),
("React", 7, 9);


SELECT*FROM topic where course_courseID = 2;
insert into lesson(lessonDate, lessonTime, venuePlace, topic_topicID)
values
('2019-10-06', 'SHORT', 'ONLINE', 1),
('2019-10-05', 'SHORT', 'ONLINE', 2),
('2019-10-12', 'LONG', 'KREUTZWALD_HOTEL', 8),
('2019-10-12', 'LONG', 'CITYSIDE', 9),
('2019-10-13', 'LONG', 'KREUTZWALD_HOTEL', 8),
('2019-10-13', 'LONG', 'CITYSIDE', 9),
('2019-10-19', 'EMPTY', 'EMPTY', 94),
('2019-10-20', 'EMPTY', 'EMPTY', 94),
('2019-10-26', 'LONG', 'KREUTZWALD_HOTEL', 8),
('2019-10-26', 'LONG', 'CITYSIDE', 9),
('2019-10-27', 'LONG', 'KREUTZWALD_HOTEL', 8),
('2019-10-27', 'LONG', 'CITYSIDE', 9),
('2019-11-02', 'LONG', 'KREUTZWALD_HOTEL', 8),
('2019-11-02', 'LONG', 'CITYSIDE', 9),
('2019-11-03', 'SHORT', 'ONLINE', 76),
('2019-11-03', 'SHORT', 'ONLINE', 77),
('2019-11-09', 'LONG', 'KREUTZWALD_HOTEL', 11),
('2019-11-09', 'LONG', 'CITYSIDE', 12),
('2019-11-10', 'LONG', 'KREUTZWALD_HOTEL', 11),
('2019-11-10', 'LONG', 'CITYSIDE', 12),
('2019-11-16', 'LONG', 'KREUTZWALD_HOTEL', 11),
('2019-11-16', 'LONG', 'CITYSIDE', 12),
('2019-11-17', 'LONG', 'KREUTZWALD_HOTEL', 14),
('2019-11-17', 'LONG', 'CITYSIDE', 15),
('2019-11-23', 'EMPTY', 'EMPTY', 94),
('2019-11-23', 'EMPTY', 'EMPTY', 95),
('2019-11-24', 'EMPTY', 'EMPTY', 94),
('2019-11-24', 'EMPTY', 'EMPTY', 95),
('2019-11-30', 'SHORT', 'CITYSIDE', 17),

('2019-12-01', 'LONG', 'CITYSIDE', 22),
('2019-12-07', 'LONG', 'HELSINKI', 22),
('2019-12-08', 'LONG', 'HELSINKI', 22),
('2019-12-14', 'LONG', 'KREUTZWALD_HOTEL', 22),
('2019-12-15', 'LONG', 'CITYSIDE', 22),
('2019-12-21', 'EMPTY', 'EMPTY', 94),
('2020-01-05', 'EMPTY', 'EMPTY', 94),
('2020-01-11', 'LONG', 'CITYSIDE', 25),
('2020-01-12', 'LONG', 'CITYSIDE', 25),
('2020-01-18', 'LONG', 'CITYSIDE', 28),
('2020-01-19', 'LONG', 'CITYSIDE', 28),
('2020-01-25', 'LONG', 'CITYSIDE', 28),
('2020-01-26', 'LONG', 'CITYSIDE', 32),
('2020-02-01', 'EMPTY', 'EMPTY', 94),
('2020-02-02', 'EMPTY', 'EMPTY', 94),
('2020-02-08', 'LONG', 'CITYSIDE', 32),
('2020-02-09', 'LONG', 'CITYSIDE', 32),
('2020-02-15', 'LONG', 'CITYSIDE', 32),
('2020-02-16', 'LONG', 'CITYSIDE', 40),
('2020-02-22', 'SHORT', 'ONLINE', 37),
('2020-02-23', 'EMPTY', 'EMPTY', 94),
('2020-02-29', 'LONG', 'CITYSIDE', 40),
('2020-03-01', 'LONG', 'CITYSIDE', 40),
('2020-03-07', 'LONG', 'STOCKHOLM', 43),
('2020-03-08', 'LONG', 'STOCKHOLM', 43),
('2020-03-14', 'EMPTY', 'EMPTY', 94),
('2020-03-15', 'EMPTY', 'EMPTY', 94),
# CORONA PANDEMIC
('2020-03-17', 'HRCLASS', 'EMPTY', 50),
('2020-03-21', 'LONG', 'STOCKHOLM', 43),
('2020-03-22', 'SHORT', 'CITYSIDE', 81),
('2020-03-28', 'LONG', 'CITYSIDE', 57),
('2020-03-29', 'LONG', 'CITYSIDE', 57),
('2020-04-04', 'LONG', 'CITYSIDE', 60),
('2020-04-05', 'LONG', 'CITYSIDE', 60),
('2020-04-11', 'EMPTY', 'EMPTY', 94),
('2020-04-12', 'EMPTY', 'EMPTY', 94),
('2020-04-18', 'LONG', 'CITYSIDE', 60),
('2020-04-19', 'LONG', 'CITYSIDE', 63),
('2020-04-25', 'LONG', 'CITYSIDE', 63),
('2020-04-26', 'LONG', 'CITYSIDE', 63),
('2020-05-02', 'EMPTY', 'EMPTY', 94),
('2020-05-03', 'EMPTY', 'EMPTY', 94),
('2020-05-09', 'LONG', 'CITYSIDE', 63),
('2020-05-10', 'LONG', 'CITYSIDE', 63),
('2020-05-16', 'LONG', 'CITYSIDE', 63),
('2020-05-17', 'LONG', 'CITYSIDE', 66),
('2020-05-23', 'SHORT', 'ONLINE', 84),
('2020-05-24', 'LONG', 'CITYSIDE', 69),
('2020-05-30', 'EMPTY', 'EMPTY', 94),
('2020-05-31', 'EMPTY', 'EMPTY', 94),
('2020-06-06', 'LONG', 'CITYSIDE', 69),
('2020-06-07', 'LONG', 'CITYSIDE', 69),
('2020-06-13', 'LONG', 'CITYSIDE', 69),
('2020-06-14', 'LONG', 'CITYSIDE', 69),
('2020-06-20', 'LONG', 'CITYSIDE', 69);


SELECT
lessonDate,
lessonTime,
venuePlace,
topic.name,
trainer.name
	FROM lesson
inner join topic ON topic.topicID = lesson.topic_topicID
left join trainer ON  topic.trainer_trainerID=trainer.trainerID
	where topic.course_courseID = 1 order by lesson.lessonDate;

# schedule for student
SELECT
course.name AS "Name of course",
topic.name AS 'Topic Name',
lesson.lessonDate,
lesson.lessonTime,
trainer.name
FROM trainer
RIGHT JOIN topic ON topic.trainer_trainerID = trainer.trainerID
RIGHT JOIN lesson ON lesson.topic_topicID = topic.topicID
RIGHT JOIN course ON course.courseID = topic.course_courseID
where topic.course_courseID = 1 order by lesson.lessonDate;


explain student;
explain course;
explain trainer;
explain topic;
explain topic;
explain lesson;
select * from student;
select * from course;
select * from trainer;
select * from topic where trainer_trainerID is not null;
select * from topic;
select * from lesson;
select * from student;

