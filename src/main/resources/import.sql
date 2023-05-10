-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- nextval('hibernate_sequence')
insert into faculty (id, faculty_name) values (1, 'ИАИТ');
insert into faculty (id, faculty_name) values(2, 'ЭТФ');
insert into faculty (id, faculty_name) values(3, 'ТЭФ');

insert into readerjob (id, job_name) values(1, 'Старший Преподаватель');
insert into readerjob (id, job_name) values(2, 'Профессор');
insert into readerjob (id, job_name) values(3, 'Ассистент');

insert into universitygroup (id, group_name, start_year) values (1, '20-фаит-3', 2020);
insert into universitygroup (id, group_name, start_year) values (2, '20-фаит-4', 2020);
insert into universitygroup (id, group_name, start_year) values (3, '20-фаит-9', 2020);
insert into universitygroup (id, group_name, start_year) values (4, '103', 2021);
insert into universitygroup (id, group_name, start_year) values (5, '104', 2021);
insert into universitygroup (id, group_name, start_year) values (6, '109', 2021);
insert into universitygroup (id, group_name, start_year) values (7, '113', 2022);
insert into universitygroup (id, group_name, start_year) values (8, '114', 2022);
insert into universitygroup (id, group_name, start_year) values (9, '119', 2022);

insert into readerrole (id, department, role_name, faculty_id, job_id) values (1, null, 'Студент', null, null);
insert into readerrole (id, department, role_name, faculty_id, job_id) values (2, 'Вычислительная техника', 'ПФК', 1, 1);
insert into readerrole (id, department, role_name, faculty_id, job_id) values (3, 'Вычислительная техника', 'ПФК', 1, 2);
insert into readerrole (id, department, role_name, faculty_id, job_id) values (4, 'Вычислительная техника', 'ПФК', 1, 3);

insert into adress (id, building, floor, room, street) values (1, '220', '5', '67', 'Ташкентская');
insert into adress (id, building, floor, room, street) values (2, '145', '12', '144', 'Ташкентская');
insert into adress (id, building, floor, room, street) values (3, '89', '3', '65', 'Самарская');
insert into adress (id, building, floor, room, street) values (4, '53', '7', '347', 'Ярмарочная');
insert into adress (id, building, floor, room, street) values (5, '1', '5', '55', '1-квартал');
insert into adress (id, building, floor, room, street) values (6, '244', null, null, 'Молодогвардейская');
insert into adress (id, building, floor, room, street) values (7, '133', null, null, 'Молодогвардейская');
insert into adress (id, building, floor, room, street) values (8, '18', null, null, 'Первомайская');
insert into adress (id, building, floor, room, street) values (9, '141', null, null, 'Галактионовская');
insert into adress (id, building, floor, room, street) values (10, '242', null, null, 'Молодогвардейская');

insert into housing (id, housing_name, adress_id) values (1, '1 Корпус', 8);
insert into housing (id, housing_name, adress_id) values (2, 'Главный корпус', 6);
insert into housing (id, housing_name, adress_id) values (3, '8 Корпус', 6);
insert into housing (id, housing_name, adress_id) values (4, '3 Корпус', 7);
insert into housing (id, housing_name, adress_id) values (5, '6 Корпус', 9);

insert into halltype (id, type_name) values (1, 'Читальный зал');
insert into halltype (id, type_name) values (2, 'Абонемент');

insert into libraryadmin (id, first_name, last_name, login, password, surname) values (1, 'Попов', 'Иван', 'popov', 'popov', null);
insert into libraryadmin (id, first_name, last_name, login, password, surname) values (2, 'Петров', 'Дмитрий', 'petrov', 'petrov', null);
insert into libraryadmin (id, first_name, last_name, login, password, surname) values (3, 'Иванова', 'Татьяна', 'ivanova', 'ivanova', null);

insert into libraryhall (id, hall_name, admin_id, hall_type_id, housing_id) values (1, 'Научно-технический читальный зал', 1, 1, 3);
insert into libraryhall (id, hall_name, admin_id, hall_type_id, housing_id) values (2, 'Научно-гуманитарный читальный зал', 2, 1, 1);
insert into libraryhall (id, hall_name, admin_id, hall_type_id, housing_id) values (3, 'Абонемент СамГТУ', 3, 2, 2);

insert into publisher (id, city, name) values (1, 'Москва', 'Эксмо');
insert into publisher (id, city, name) values (2, 'Санкт-Петербург', 'Азбука');
insert into publisher (id, city, name) values (3, 'Самара', 'СамГТУ');

insert into storage (id, abbreviation, name) values (1, 'П-1-1', 'Программирование');
insert into storage (id, abbreviation, name) values (2, 'И-1-2', 'Информатика');
insert into storage (id, abbreviation, name) values (3, 'М-2-1', 'Математика');
insert into storage (id, abbreviation, name) values (4, 'Ф-3-2', 'Физика');
insert into storage (id, abbreviation, name) values (5, 'Х-5-7', 'Химия');
insert into storage (id, abbreviation, name) values (6, 'Э-3-6', 'Экономика');
insert into storage (id, abbreviation, name) values (7, 'Б-4-3', 'Бизнес');

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (1, null, null, '004.43(075.8)/***', null, null, 'Тюгашев А.А.', 'Языки программирования : учеб. пособие', 'Русский', 333, 2014, 3);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (2, null, null, '004.43 / ***', null, null, 'Прата С.', 'Язык программирования С++ : Лекции и упр', 'Английский', 1181, 2007, 1);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (3, null, null, null, null, null, 'Павловская Т.А.', 'С/С++.Программирование на языке высокого уровня : Учеб.', 'Русский', 460, 2006, 2);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (4, null, null, '519.6 / 681.3:51 / 681.322 / ***', null, null, 'Дьяконов', 'Компьютерная математика : Теория и практика', 'Русский', 1295, 2001, 1);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (5, null, null, '53 / 53.001.573(06) / 519.6 / ***', null, null, 'Самарский А.А.', 'Актуальные проблемы математической физики и вычислительной математики', 'Русский', 460, 1984, 3);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (6, null, '978-5-9221-1256-7', null, null, 'Один из лучших курсов элементарной физики, завоевавший огромную популярность. Достоинством курса является глубина изложения физической стороны процессов и явлений в природе и технике.',
        'Ландсберг Г.С.', 'Элементарный учебник физики. В 3 томах. Том 1. Механика. Теплота. Молекулярная физика',
        'Русский', 612, 2022, 1);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (7, null, '978-5-9221-1610-7', null, null, 'Один из лучших курсов элементарной физики, завоевавший огромную популярность. Достоинством курса является глубина изложения физической стороны процессов и явлений в природе и технике.',
        'Ландсберг Г.С.', 'Элементарный учебник физики. В 3 томах. Том 2. Электричество и магнетизм',
        'Русский', 488, 2021, 1);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (8, null, '978-5-9221-1591-9', null, null, 'Один из лучших курсов элементарной физики, завоевавший огромную популярность. Достоинством курса является глубина изложения физической стороны процессов и явлений в природе и технике.',
        'Ландсберг Г.С.', 'Элементарный учебник физики. В 3 томах. Том 3. Колебания и волны. Оптика. Атомная и ядерная физика',
        'Русский', 664, 2021, 1);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (9, null, '978-5-8114-3217-2', null, null, 'Учебник рассчитан на студентов, обучающихся по программам специалитета, магистратуры и аспирантуры направлений подготовки и специальностей, входящих в УГС: "Химия" и "Химические технологии"',
        'Москвин Л.Н., Дробышев А. И.', 'Аналитическая химия. Методы идентификации и определения веществ. Учебник',
        'Русский', 584, 2022, 1);

insert into book (id, bbk, isbn, udk, additionalinfo, annotation, author, bookname, "language", pagescount,
                  yearofpublishing, publisher_id)
values (10, null, '978-985-06-3366-8', null, null, 'Для магистрантов экономического профиля, научных работников, всех тех, кому интересны теоретические и эмпирические исследования экономического роста.',
        'Быков А.А.', 'Экономический рост и развитие',
        'Русский', 303, 2021, 2);


insert into package (id, count_of_books, book_id) values (1, 30, 1);
insert into package (id, count_of_books, book_id) values (2, 50, 2);
insert into package (id, count_of_books, book_id) values (3, 50, 3);
insert into package (id, count_of_books, book_id) values (4, 10, 4);
insert into package (id, count_of_books, book_id) values (5, 10, 5);
insert into package (id, count_of_books, book_id) values (6, 30, 6);
insert into package (id, count_of_books, book_id) values (7, 40, 7);
insert into package (id, count_of_books, book_id) values (9, 60, 8);
insert into package (id, count_of_books, book_id) values (8, 30, 9);
insert into package (id, count_of_books, book_id) values (10, 30, 10);

insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (1, 5, 1, 1, 3, 1);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (2, 2, 1, 1, 1, 1);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (3, 1, 4, 4, 1, 3);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (4, 2, 5, 5, 3, 3);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (5, 2, 6, 6, 1, 4);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (6, 2, 7, 7, 3, 4);
/*insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (7, 3, , , 3, 1);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (8, 3, , , 3, 1);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (9, 3, , , 3, 1);
insert into storages (id, book_count, book_id, bookpackage_id, hall_id, storage_id)
values (10, 3, , , 3, 1);*/