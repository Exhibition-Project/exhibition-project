drop table exhibition;
drop table member;
drop table review;
drop table reservation;
drop table discount;
drop table reservation_line;


CREATE TABLE exhibition (
	exhibition_no	Number	PRIMARY KEY,
	exhibition_name	VARCHAR2(150) NOT NULL,
	start_date	Date NOT NULL,
	end_date	Date NOT NULL,
	genre	VARCHAR2(150),
	price	Number NOT NULL,
	exhibition_loc	VARCHAR2(150) NOT NULL
);

CREATE TABLE member (
	member_no	number	PRIMARY KEY,
	member_id	VARCHAR2(30) NOT NULL,
	member_name	VARCHAR2(150) NOT NULL,
	member_birth	Date,
	member_pass VARCHAR2(30) NOT NULL
);
alter table member add constraint member_member_no_uk unique(member_id);

CREATE TABLE review (
	review_no	number	PRIMARY KEY,
	member_no	number NOT NULL	CONSTRAINT review_member_no_fk REFERENCES member(member_no),
	exhibition_no	Number NOT NULL	CONSTRAINT review_exhibition_no_fk REFERENCES exhibition(exhibition_no),
	review_content VARCHAR2(255) NOT NULL,
	stars number(1) NOT NULL
);

CREATE TABLE reservation (
	reservation_no	Number	PRIMARY KEY,
	member_no	number NOT NULL	CONSTRAINT reservation_member_no_fk REFERENCES member(member_no),
	exhibition_no Number NOT NULL CONSTRAINT reservation_exhibition_no_fk REFERENCES exhibition(exhibition_no),
	total_amount	Number	NOT NULL,
	reg_date	Date	NOT NULL
);

CREATE TABLE discount (
	visit_age	VARCHAR2(30)	PRIMARY KEY,
	discount_rate	number(2)	NULL
);

CREATE TABLE reservation_line (
	reservation_line_no	number	PRIMARY KEY,
	reservation_no	Number NOT NULL CONSTRAINT reservation_no_fk REFERENCES reservation(reservation_no),
	visit_age	VARCHAR2(30) CONSTRAINT visit_age_fk REFERENCES discount(visit_age),
	ticket_qty	number NOT NULL,
	amount	number NOT NULL
);

drop sequence exhibition_no_seq;
drop sequence member_no_seq;
drop sequence review_no_seq;
drop sequence reservation_no_seq;
drop sequence reservation_line_no_seq;

CREATE SEQUENCE exhibition_no_seq NOCACHE;
create sequence member_no_seq nocache;
create sequence review_no_seq nocache;
create sequence reservation_no_seq nocache;
create sequence reservation_line_no_seq nocache;




