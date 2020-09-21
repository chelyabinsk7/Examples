DROP TABLE IF EXISTS book;

CREATE TABLE IF NOT EXISTS book (
  id SERIAL PRIMARY KEY NOT NULL,
  author_name VARCHAR(40) NOT NULL,
  book_name VARCHAR(90) NOT NULL,
  date_create DATE DEFAULT current_date,
  access_type VARCHAR(20) DEFAULT 'OPEN'
);

INSERT INTO book (author_name, book_name, date_create) VALUES 
	('Haruki Murakami', 'What I Talk About When I Talk About Running', '2007-10-15'),
	('Stephen King', 'The Long Walk', '1979-07-15'),
	('Ernest Cline', 'Ready Player One', '2011-08-16'),
	('James Dashner', 'The Maze Runner', '2009-10-06'),
	('Stephen King', 'The Stand', '1978-10-03'),
	('Charles Brandt', 'I Heard You Paint Houses', '2004-03-22'),
	('Rick Yancey', 'The 5th Wave', '2013-03-01'),
	('Suzanne Collins', 'The Hunger Games', '2008-09-14');
INSERT INTO book (author_name, book_name) VALUES ('People', 'ABC');
UPDATE book SET access_type = 'CLOSE' WHERE author_name = 'Stephen King';