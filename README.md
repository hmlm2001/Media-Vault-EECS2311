# MediaVault

Created by group 3 of EECS2311.

## Description
MediaVault is a software application with the main purpose of storing a collection of media, and allowing users to keep track of their progress in them. 

## Initializing the Database
The MediaVault database must be initialized using MySQL before running the main application.
To initialize the database, run the **SETUP.sql** script (located in MediaVault/database) with the root MySQL user.

## Running MediaVault
To run MediaVault, simply compile and run the **MediaVault.java** file located in MediaVault/src/userinterface.

## Switching to Stub
For the purposes of the assignment a stub DB was implemented. To switch over from the real DB to the stub DB, set the stub flag to true in MediaVault.java using the following line of code in the main method:
```
UseStub.setStubFlag(true);
```

## Required Documents
The required documents for each iteration are stored in "Planning Documents".
