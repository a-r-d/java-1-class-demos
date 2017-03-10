# Week 15 assignment

For this assignment we will practice using Maven. Please turn in your ENTIRE PROJECT! I want the pom.xml file as well as any Java files that you produce.

## Part 1.

In part one you will create a maven project, import some libraries (3) and use them (use at least one class from each library). Feel free to read documentation, Google things, and experiment. Start with [Apache.org](http://www.apache.org/index.html#projects-list) if you need ideas. These requirements are pretty open ended, so don't slack off, do something cool or interesting. Ask me if you are not sure about a library.


### Steps for part 1.

1. Create a Java project.
2. Configure it as a maven project.
3. Import 3 libraries using Maven. Any Libraries, with two exceptions: you __CANNOT USE OkHttp__ and you __CANNOT USE HyperSQLDB!__ We already did that in class, and HyperSQL is for part 2! Use something else, be creative, look at the Apache website if you cannot come up with any ideas.
4. I need to see these 3 libraries in your pom.xml file. They need to be valid. If they are not valid you will not get points.
5. Create a class with a main method. Use a class from each of the libraries you imported in some way. E.g. if you use Apache Commons CLI, then go ahead and try to parse some command line argument. You may need to read documentation or Google for tutorials about how to do this.
6. For each class from each library you instantiate, print the name of the library and the name of class out to the console to tell me what you are doing.


## Part 2.

In part 2 you will create a maven project, import HyperSQLDb, create a connection string, connect to the database, and create a table. You need to know how to do this for next week's homework, we will use HyperSQL instead of Access.

Here is the XML you need to paste into your POM file:

```xml
<dependency>
  <groupId>org.hsqldb</groupId>
  <artifactId>hsqldb</artifactId>
  <version>2.3.1</version>
</dependency>
```

Here is the table you will create:

```sql
create table if not exists
	cities (name varchar(50), state varchar(30), zipcode varchar(5));
```

Example connection string for HyperSQLDB
```
jdbc:hsqldb:file:hmwk12part2
```

### Steps to complete part 2:

1. Create a Java project.
2. Configure it as a maven project.
3. Import HyperSQLDB (hsqldb). See above for the POM entry.
4. Create a main class you can run (call it Homework12Part2) with a main method.
5. Create a "file" connection string. This should work: ```jdbc:hsqldb:file:hmwk12part2```
6. Connect to the DB using the above connection string.
7. Run the SQL statement above (create the table called "cities").
8. Print something out to the user telling them if it worked.


### Example code to create a table:

```java

String connectionString = "jdbc:hsqldb:file:hmwk12part2";
String createTable = "create table if not exists " +
	"cities (name varchar(50), state varchar(30), zipcode varchar(5));";

Connection con = DriverManager.getConnection(connectionString, "SA", "");
con.createStatement()
    .executeUpdate(createTable);

```
