# JDBC-CRUD-APP-WEB-BASED-PROJECT

This is a web-based CRUD (Create, Read, Update, Delete) application built using Java, JDBC, Servlets, MySQL Connector, and Apache Tomcat server. The application allows you to perform basic database operations on a MySQL database through a web interface.

## Prerequisites
Before running this application, ensure you have the following:

Java Development Kit (JDK) installed on your system.
Apache Tomcat server installed and configured.
MySQL database server installed.
MySQL Connector/J library downloaded and added to your project.
## Setup
To set up and run the JDBC CRUD application, follow these steps:

Clone or download the project repository to your local machine.

Import the project into your preferred Java IDE (e.g., Eclipse, IntelliJ IDEA).

Configure the project's build path to include the MySQL Connector/J library. You can download the connector from the official MySQL website.

Open the src/main/resources/db.properties file and update the database connection details according to your MySQL server configuration. Update the following properties:

jdbc.url=jdbc:mysql://localhost:3306/your_database_name
jdbc.username=your_username
jdbc.password=your_password
Build the project to compile the Java classes.

Deploy the application to the Apache Tomcat server by creating a WAR file and placing it in the webapps directory of your Tomcat installation.

Start the Apache Tomcat server.

Open a web browser and access the application using the URL: http://localhost:8080/your_application_name.

## Usage
Once the application is up and running, you can perform the following CRUD operations through the web interface:

Create: Click on the "Add" or "Create" button to create a new record in the database. Fill in the required fields in the form and submit it.

Read: The application displays a table listing all the records in the database. You can view the existing records on the homepage.

Update: Click on the "Edit" or "Update" button next to a record to modify its details. Update the necessary fields in the form and submit it to save the changes.

Delete: Click on the "Delete" or "Remove" button next to a record to delete it from the database.
