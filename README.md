# Java Database Connection (JDBC) Example with Student Database Manager

This repository contains Java code for managing a student database using JDBC (Java Database Connectivity). The `StudentDatabaseManager` class demonstrates basic operations such as inserting, fetching, updating, and deleting student records.

## Contents

- [Introduction](#introduction)
- [JDBC](#jdbc)
- [SQL](#sql)
- [JDBC Driver](#jdbc-driver)
- [Steps to Establish a JDBC Connection](#steps-to-establish-a-jdbc-connection)
- [Code Structure](#code-structure)
- [Usage](#usage)

## Introduction

JDBC stands for **Java Database Connectivity**. It is a standard Java API that allows Java programs to connect to and interact with relational databases. JDBC provides methods for querying and updating data in a database.

## JDBC

JDBC, or Java Database Connectivity, serves as a fundamental API for Java applications to interact with databases. It establishes a standard interface through which Java clients can access and manipulate relational databases. JDBC offers a comprehensive set of methods and interfaces designed for querying data with SQL commands and updating database records. Its primary focus lies in facilitating communication between Java programs and various relational database management systems (RDBMS), such as MySQL, PostgreSQL, Oracle, and SQL Server.

By leveraging JDBC, developers can establish connections to databases, execute SQL statements to retrieve and modify data, and manage transactions to ensure data integrity. The API also supports handling database-specific exceptions and accessing metadata that describes the structure and properties of the database schema. JDBC's flexibility and portability make it an essential tool for developing database-driven applications in Java, enabling seamless integration with diverse database platforms while adhering to standardized practices for efficient data management and interaction.

### Key Components

1. **JDBC Driver**: A set of classes that implement the JDBC interfaces for a specific database.
2. **Connection**: An interface that has all methods for contacting a database.
3. **Statement**: An interface that represents a SQL statement.
4. **ResultSet**: A table of data representing a database result set.

## SQL

SQL (Structured Query Language) is a standardized language for managing and manipulating databases. It is used to perform various operations such as querying data, updating data, and managing database structures.

### Common SQL Commands

- `SELECT`: [Retrieve data from a database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/FetchDataJDBC.java).
- `INSERT`: [Add new records to a database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/InsertDataJDBC.java).
- `UPDATE`: [Modify existing records](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/UpdateDataJDBC.java).
- `DELETE`: [Remove records from a database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/DeleteDataJDBC.java).

## JDBC Driver

A JDBC driver is a software component that enables Java applications to interact with a database. For MySQL databases, the driver is `com.mysql.cj.jdbc.Driver`.

## Steps to Establish a JDBC Connection

1. **Load the JDBC driver**:
   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
2. **Establish a connection**:
   ```java
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");
3. **Create a statement**:
   ```java
   Statement stmt = con.createStatement();
4. **Execute a query**:
   ```java
   ResultSet rs = stmt.executeQuery("SELECT * FROM personal");
5. **Process the results**:
   ```java
   while (rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
   }
6. **Close the connection**:
   ```java
   con.close();
   
## Code Structure

**FetchDataJDBC.java**: [Retrieve data from a database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/FetchDataJDBC.java).

**InsertDataJDBC.java**: [Add new records to a database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/InsertDataJDBC.java).

**UpdateDataJDBC.java**: [Modify existing records](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/UpdateDataJDBC.java).

**DeleteDataJDBC.java**: [Remove records from a database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/DeleteDataJDBC.java).

**StudentDatabaseManager.java**: [Contains methods to insert, fetch, update, and delete student records in the database](https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity/blob/main/StudentDatabaseManager.java).

## Usage

### The Repository

```sh
git https://github.com/AdityaSinghMandrawal/Java-Database-Connectivity
```
## Compile and Run

1. **Compile the Java file**:

   ```sh
   javac FetchDataJDBC.java
   javac InsertDataJDBC.java
   javac UpdateDataJDBC.java
   javac DeleteDataJDBC.java
   javac StudentDatabaseManager.java
   ```
2. **Run the Java file**:

   ```sh
   java FetchDataJDBC
   java InsertDataJDBC
   java UpdateDataJDBC
   java DeleteDataJDBC
   java StudentDatabaseManager
