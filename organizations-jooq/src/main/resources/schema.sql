CREATE DATABASE work;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS organization;

CREATE TABLE organization
(
	id SERIAL PRIMARY KEY,
	org_name VARCHAR(50) NOT NULL,
	id_parent INTEGER REFERENCES organization (id) ON UPDATE CASCADE
);
INSERT INTO organization (org_name) VALUES ('Volkswagen AG');
INSERT INTO organization (org_name) VALUES ('Fiat Chrysler Automobiles');
INSERT INTO organization (org_name) VALUES ('Groupe PSA');
INSERT INTO organization (org_name) VALUES ('General Motors');
INSERT INTO organization (org_name, id_parent) VALUES ('Volkswagen', 1);
INSERT INTO organization (org_name, id_parent) VALUES ('Audi', 1);
INSERT INTO organization (org_name, id_parent) VALUES ('Skoda', 1);
INSERT INTO organization (org_name, id_parent) VALUES ('SEAT', 1);
INSERT INTO organization (org_name, id_parent) VALUES ('Ducati', 6);
INSERT INTO organization (org_name, id_parent) VALUES ('Lamborghini', 6);
INSERT INTO organization (org_name, id_parent) VALUES ('Fiat', 2);
INSERT INTO organization (org_name, id_parent) VALUES ('Lanchia', 11);
INSERT INTO organization (org_name, id_parent) VALUES ('Alfa Romeo', 11);
INSERT INTO organization (org_name, id_parent) VALUES ('Opel', 3);
INSERT INTO organization (org_name, id_parent) VALUES ('Peugeot', 3);
INSERT INTO organization (org_name, id_parent) VALUES ('Citroen', 3);
INSERT INTO organization (org_name, id_parent) VALUES ('Chrysler', 2);
INSERT INTO organization (org_name, id_parent) VALUES ('Dodge', 17);
INSERT INTO organization (org_name, id_parent) VALUES ('Jeep', 17);
INSERT INTO organization (org_name, id_parent) VALUES ('Chevrolet', 4);

CREATE TABLE employee
(
	id SERIAL PRIMARY KEY,
	emp_name VARCHAR(35) NOT NULL,
	id_org INTEGER,
	FOREIGN KEY (id_org) REFERENCES organization (id) ON UPDATE CASCADE,
	id_head INTEGER REFERENCES employee (id) ON UPDATE CASCADE
);
INSERT INTO employee (emp_name, id_org) VALUES ('Tom', 1);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Adam', 1, 1);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Andy', 1, 2);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Chris', 1, 2);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Collin', 1, 4);
INSERT INTO employee (emp_name, id_org) VALUES ('Dennis', 2);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Doug', 2, 6);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Gary', 2, 6);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Greg', 2, 6);
INSERT INTO employee (emp_name, id_org) VALUES ('Fred', 3);
INSERT INTO employee (emp_name, id_org) VALUES ('Ian', 3);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Gary', 3, 11);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Gregg', 3, 10);
INSERT INTO employee (emp_name, id_org) VALUES ('Keith', 4);
INSERT INTO employee (emp_name, id_org) VALUES ('Jerry', 4);
INSERT INTO employee (emp_name, id_org) VALUES ('Frank', 4);
INSERT INTO employee (emp_name, id_org) VALUES ('Albert', 5);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Mark', 5, 17);
INSERT INTO employee (emp_name, id_org) VALUES ('Matt', 6);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Jon', 6, 19);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Ron', 6, 19);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('George', 6, 21);
INSERT INTO employee (emp_name, id_org) VALUES ('Scott', 7);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Paul', 7, 23);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Steve', 7, 24);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Allen', 7, 25);
INSERT INTO employee (emp_name, id_org) VALUES ('Yahn', 8);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Nate', 8, 27);
INSERT INTO employee (emp_name, id_org) VALUES ('Bert', 9);
INSERT INTO employee (emp_name, id_org) VALUES ('Ferris', 9);
INSERT INTO employee (emp_name, id_org) VALUES ('Clarence', 10);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Elmer', 10, 31);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Eugene', 10, 31);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Bill', 10, 33);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Jason', 10, 32);
INSERT INTO employee (emp_name, id_org) VALUES ('Cecil', 11);
INSERT INTO employee (emp_name, id_org) VALUES ('Alfred', 11);
INSERT INTO employee (emp_name, id_org) VALUES ('Ernie', 11);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Josh', 11, 37);
INSERT INTO employee (emp_name, id_org) VALUES ('Martin', 13);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Elliot', 13, 40);
INSERT INTO employee (emp_name, id_org) VALUES ('Frasier', 14);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Brandon', 14, 42);
INSERT INTO employee (emp_name, id_org) VALUES ('Nick', 14);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Will', 14, 43);
INSERT INTO employee (emp_name, id_org) VALUES ('Calvin', 15);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Wyatt', 15, 46);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Norm', 15, 46);
INSERT INTO employee (emp_name, id_org) VALUES ('Dean', 16);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Orin', 16, 49);
INSERT INTO employee (emp_name, id_org) VALUES ('Perry', 19);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Ethan', 19, 51);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Tim', 19, 52);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Fergus', 19, 53);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Harold', 19, 53);
INSERT INTO employee (emp_name, id_org) VALUES ('Irving', 20);
INSERT INTO employee (emp_name, id_org, id_head) VALUES ('Shawn', 20, 57);
INSERT INTO employee (emp_name, id_org) VALUES ('Henry', 20);
