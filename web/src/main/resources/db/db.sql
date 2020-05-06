create database eastory;
use eastory;
create schema if not exists eastory;

create table if not exists languages
(
	id int auto_increment
		primary key,
	language varchar(255) null
);

create table if not exists questions
(
	id int auto_increment
		primary key,
	answer_1 varchar(255) null,
	answer_2 varchar(255) null,
	answer_3 varchar(255) null,
	answer_4 varchar(255) null,
	description varchar(255) null,
	image blob null,
	language_id int not null,
	question varchar(255) null,
	right_answer int not null,
	constraint questions_languages_id_fk
		foreign key (language_id) references languages (id)
			on update cascade on delete cascade
);

create table if not exists topics
(
	id int auto_increment
		primary key,
	topic varchar(255) null
);

create table if not exists tests
(
	id int auto_increment
		primary key,
	topic_id int not null,
	question_id int not null,
	constraint tests_questions_id_fk
		foreign key (question_id) references questions (id)
			on update cascade on delete cascade,
	constraint tests_topics_id_fk
		foreign key (topic_id) references topics (id)
			on update cascade on delete cascade
);

create table if not exists results
(
	id int auto_increment
	    primary key,
	name              varchar(255) null,
	number_of_answers int          null,
	topic_id          int          null,
	constraint results_topics_id_fk
		foreign key (topic_id) references topics (id)
);


