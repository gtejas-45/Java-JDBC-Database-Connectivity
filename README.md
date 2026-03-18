# 📘 JDBC & SQL Queries - Complete Guide

## 🔰 Introduction

This repository contains a beginner-to-advanced overview of **JDBC (Java Database Connectivity)** and commonly used **SQL queries**. It is designed to help students and developers understand how Java applications interact with databases.

---

# ☕ What is JDBC?

**JDBC (Java Database Connectivity)** is an API in Java that allows applications to connect and interact with databases.

### 🎯 Key Features:

* Connect to databases (MySQL, Oracle, etc.)
* Execute SQL queries
* Retrieve and update data
* Handle database transactions

---

# ⚙️ JDBC Architecture

### 🧩 Components:

1. **JDBC API** – Interfaces & classes in Java
2. **JDBC Driver Manager** – Manages drivers
3. **JDBC Driver** – Database-specific implementation
4. **Database** – Stores data

---

# 🔌 Types of JDBC Drivers

1. **Type 1** – JDBC-ODBC Bridge
2. **Type 2** – Native API Driver
3. **Type 3** – Network Protocol Driver
4. **Type 4** – Thin Driver (Most Used)

---

# 🔄 Steps to Connect JDBC

```java
// 1. Load Driver
Class.forName("com.mysql.cj.jdbc.Driver");

// 2. Create Connection
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/dbname", "username", "password");

// 3. Create Statement
Statement stmt = con.createStatement();

// 4. Execute Query
ResultSet rs = stmt.executeQuery("SELECT * FROM students");

// 5. Process Result
while(rs.next()){
    System.out.println(rs.getInt(1) + " " + rs.getString(2));
}

// 6. Close Connection
con.close();
```

---

# 🧠 Important JDBC Interfaces

### 1. Connection

* Represents database connection

### 2. Statement

* Used to execute SQL queries

### 3. PreparedStatement

* Precompiled SQL (more secure & faster)

```java
PreparedStatement ps = con.prepareStatement(
    "INSERT INTO students VALUES (?, ?)");
ps.setInt(1, 1);
ps.setString(2, "Tejas");
ps.executeUpdate();
```

### 4. ResultSet

* Stores query result

---

# 🔐 Why Use PreparedStatement?

* Prevents SQL Injection
* Improves performance
* Easy parameter handling

---

# 🗄️ SQL (Structured Query Language)

SQL is used to communicate with databases.

---

# 📌 Types of SQL Commands

## 1. DDL (Data Definition Language)

Used to define structure.

```sql
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

ALTER TABLE students ADD email VARCHAR(100);

DROP TABLE students;
```

---

## 2. DML (Data Manipulation Language)

Used to modify data.

```sql
INSERT INTO students VALUES (1, 'Tejas', 21);

UPDATE students SET age = 22 WHERE id = 1;

DELETE FROM students WHERE id = 1;
```

---

## 3. DQL (Data Query Language)

Used to fetch data.

```sql
SELECT * FROM students;

SELECT name, age FROM students WHERE age > 20;
```

---

## 4. TCL (Transaction Control Language)

```sql
COMMIT;
ROLLBACK;
SAVEPOINT sp1;
```

---

## 5. DCL (Data Control Language)

```sql
GRANT SELECT ON students TO user;

REVOKE SELECT ON students FROM user;
```

---

# 🔍 Important SQL Queries

## 🔹 WHERE Clause

```sql
SELECT * FROM students WHERE age > 18;
```

## 🔹 ORDER BY

```sql
SELECT * FROM students ORDER BY age DESC;
```

## 🔹 GROUP BY

```sql
SELECT age, COUNT(*) FROM students GROUP BY age;
```

## 🔹 JOIN Operations

### INNER JOIN

```sql
SELECT s.name, c.course_name
FROM students s
INNER JOIN courses c ON s.id = c.student_id;
```

### LEFT JOIN

```sql
SELECT * FROM students
LEFT JOIN courses ON students.id = courses.student_id;
```

---

# ⚡ Batch Processing in JDBC

```java
Statement stmt = con.createStatement();
stmt.addBatch("INSERT INTO students VALUES (1, 'A')");
stmt.addBatch("INSERT INTO students VALUES (2, 'B')");
stmt.executeBatch();
```

---

# 🔄 Transactions in JDBC

```java
con.setAutoCommit(false);

stmt.executeUpdate("INSERT...");
stmt.executeUpdate("UPDATE...");

con.commit(); // save changes
```

---

# ⚠️ Exception Handling

```java
try {
    // JDBC code
} catch (SQLException e) {
    e.printStackTrace();
}
```

---

# 📂 Project Structure Example

```
project/
│── src/
│   └── DBConnection.java
│   └── StudentDAO.java
│── lib/
│── README.md
```

---

# 🚀 Best Practices

✔ Use PreparedStatement
✔ Close resources (Connection, Statement)
✔ Use connection pooling
✔ Handle exceptions properly
✔ Use MVC architecture

---

# 📚 Conclusion

JDBC is a powerful API that allows Java applications to interact with databases efficiently. Understanding SQL queries along with JDBC helps in building robust backend systems like banking apps, management systems, and enterprise applications.

---

# 🙌 Author

**Tejas Gaikwad**

---

⭐ If you found this helpful, consider giving a star!
