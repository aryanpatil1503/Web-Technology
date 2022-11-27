CREATE DATABASE Assignment_No_5;

CREATE TABLE eBookShop(
	book_id INT,
    book_title VARCHAR(20),
    book_author VARCHAR(20),
    book_price FLOAT,
	quantity INT
    );

INSERT INTO eBookShop VALUES
	(1,	'OOP',	'Stephen King',	500, 2),
	(2, 'CNS', 'J.K. Rowling', 450, 3),
	(3, 'WT', 'Stephen King', 347, 5),
	(4, 'DBMS', 'Danzy Senna', 654, 8),
	(5, 'DSA', 'Tana French', 900, 1);
     
SELECT * FROM eBookShop;