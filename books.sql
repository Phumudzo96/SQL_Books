DROP DATABASE IF EXISTS `ebookstore`;
CREATE DATABASE `ebookstore`; 
USE `ebookstore`;

CREATE TABLE `books` (
id int(4),
title varchar(255),
author varchar(255),
qty int(2),
PRIMARY KEY(id)
);
INSERT INTO `books` VALUES (3001, "A Tale of Two Cities", "Charles Dickens ", 30);
INSERT INTO `books` VALUES (3002, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 40);
INSERT INTO `books` VALUES (3003, "The Lion, the Witch and the Wardrobe", "C. S. Lewis", 25);
INSERT INTO `books` VALUES (3004, "The Lord of the Rings", "J.R.R Tolkien", 37);
INSERT INTO `books` VALUES (3005, "Alice in Wonderland", "Lewis Carroll", 12);