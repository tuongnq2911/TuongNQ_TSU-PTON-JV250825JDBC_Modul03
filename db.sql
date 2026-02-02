CREATE DATABASE db_degree__management;
USE db_degree__management;

CREATE TABLE degrees(
                        degree_id INT PRIMARY KEY AUTO_INCREMENT,
                        degree_name VARCHAR(150) NOT NULL,
                        emp_id VARCHAR(15) NOT NULL ,
                        degree_date DATETIME NOT NULL ,
                        school_name VARCHAR(100) NOT NULL ,
                        degree_year INT NOT NULL ,
                        degree_classification VARCHAR(20) NOT NULL
);

DELIMITER $$
CREATE PROCEDURE get_all_degree ()
BEGIN
    SELECT * FROM degrees;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE add_degree (
    IN p_degree_name VARCHAR(150),
    IN p_emp_id VARCHAR(15),
    IN p_degree_date DATETIME,
    IN p_school_name VARCHAR(100),
    IN p_degree_year INT,
    IN p_degree_classification VARCHAR(20)
)
BEGIN
    INSERT INTO degrees(degree_name, emp_id, degree_date, school_name, degree_year, degree_classification)
        VALUE (p_degree_name,p_emp_id,p_degree_date,p_school_name,p_degree_year,p_degree_classification);
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE find_degree_by_degree_id (IN p_emp_id INT)
BEGIN
    SELECT * FROM degrees WHERE emp_id = p_emp_id;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_degree_by_id(
    IN p_degree_id INT,
    IN p_degree_name VARCHAR(150),
    IN p_emp_id VARCHAR(15),
    IN p_degree_date DATETIME,
    IN p_school_name VARCHAR(100),
    IN p_degree_year INT,
    IN p_degree_classification VARCHAR(20)
)
BEGIN
    UPDATE degrees SET
                       degree_name = p_degree_name,
                       emp_id = p_emp_id,
                       degree_date = p_degree_date,
                       school_name = p_school_name,
                       degree_year = p_degree_year,
                       degree_classification = p_degree_classification
    WHERE degree_id = p_degree_id;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_degree_by_id(IN p_degree_id INT)
BEGIN
    DELETE FROM degrees WHERE degree_id = p_degree_id;
end $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE search_degree_by_degree_name(IN p_search_key VARCHAR(150))
BEGIN
    SELECT * FROM degrees
    WHERE degree_name LIKE CONCAT('%',p_search_key,'%');
end $$
DELIMITER ;









