# MediaVault

Created by group 3 of EECS2311.

## Description
MediaVault is a software application with the main purpose of storing a collection of media, and allowing users to keep track of their progress in them. 

## Initializing the Database
The MediaVault database must be initialized before running the main application.
To initialize the MySQL database:
1. Create a new MySQL user with username "mediavaultadmin" and password "0000" and grant all privileges.
   This can be done by running the following commands with the root user:
  - CREATE USER 'mediavaultadmin'@'localhost' IDENTIFIED BY '0000';
  - GRANT ALL PRIVILEGES ON * . * TO 'mediavaultadmin'@'localhost';
  - FLUSH PRIVILEGES;
2. Switch to the new user and run the script **SETUP.sql**, located in MediaVault/database.

## Running MediaVault
To run MediaVault, simply compile and run the **MediaVault.java** file located in MediaVault/src/userinterface.
