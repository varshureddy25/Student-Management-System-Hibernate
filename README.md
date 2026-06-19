# Student Information Management System using Hibernate and MySQL

## Project Overview

The Student Information Management System is a Java-based application developed using Hibernate ORM and MySQL Database. The application enables users to perform CRUD (Create, Read, Update, Delete) operations on student records. Hibernate simplifies database interaction by mapping Java objects to database tables.

## Features

* Add new student records
* View all student records
* Update existing student details
* Delete student records
* Menu-driven console interface
* Database integration using Hibernate ORM

## Technologies Used

* Java
* Hibernate ORM 5.6.15.Final
* MySQL Database
* Maven
* Eclipse IDE

## Project Structure

src/main/java

* com.student.entity

  * Student.java

* com.student.main

  * MainApp.java

src/main/resources

* hibernate.cfg.xml

## Database Configuration

### Database Name

studentdb

### Table Structure

```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    email VARCHAR(50)
);
```

## Hibernate Configuration

The project uses `hibernate.cfg.xml` to configure:

* MySQL JDBC Driver
* Database URL
* Username and Password
* Hibernate Dialect
* Entity Mapping

## CRUD Operations

### Create

Insert a new student record into the database.

### Read

Display all student records stored in the database.

### Update

Modify student information using the student ID.

### Delete

Remove a student record using the student ID.

## How to Run

1. Install MySQL and create the database.
2. Configure database credentials in `hibernate.cfg.xml`.
3. Import the project into Eclipse.
4. Update Maven dependencies.
5. Run `MainApp.java`.
6. Select options from the menu to perform CRUD operations.

## Sample Menu

```
===== Student Management System =====
1. Insert Student
2. Display Students
3. Update Student
4. Delete Student
5. Exit
```

## Learning Outcomes

* Understanding Object Relational Mapping (ORM)
* Working with Hibernate Sessions and Transactions
* Mapping Java classes to database tables
* Performing CRUD operations using Hibernate
* Integrating Java applications with MySQL

## Author

Varshitha Reddy Yampalla

