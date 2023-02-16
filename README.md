# MediaVault Wiki

Created by group 3 of EECS2311.

## Members 
* Isaac Ibidun
* Herman Lim
* Ruth Bezabeh
* Mate Korognai
* Muhammad Ehab Khan

## Table of Contents 
- [Description](#description)
- [Iteration 1](#review)
  - [Overview](#overview)
  - [Architecture](#architecture)
    - [Backend](#backend)
    - [Persistence](#persistence)
    - [User Interface](#user-interface)
- [Running MediaVault](#running-mediavault)

## Description
MediaVault is a software application with the main purpose of storing a collection of media, and allowing users to keep track of their progress in them. 

Users are able to securely create an account and login to it. Within the account, users have access to their own Media Vault where they can store movies and books. MediaVault provides a wide range of movies and books that users can add to their vault, with a search feature that makes it easy to find their desired media. With each movie and book in the vault, users can assign a status such as 'Completed', 'Currently Watching', and 'Yet To Watch'. This allows the user to keep track of media they have consumed.

MediaVault can also recommend movies and books to users based on their preferred genres and they are able to view information on each piece of media such as reviews and ratings. In addition, users can personalize their profile by setting a user icon as well as adding a custom status to their profile. They can also view their user statistics such as 'Movies Watched' and 'Pages Read' so they have a better idea of their media consumption trends.

## Iteration 1 

### Overview 
For iteration 1, we created the login and sign up user interfaces and implemented the functionality our domain-specific and business logic classes, focusing on the movies section of the application.

### Architecture
![uml-diagram](https://cdn.discordapp.com/attachments/1075816196072554536/1075816562205917254/UML_Diagram.png)
The architecture of MediaVault is separated into 3 layers (packages) with classes and dependencies working together to create a functional application.

#### Backend
The backend layer contains the domain-specific classes such as User.java and Media.java which act as a template for user and media information respectively. 

AllMedia.java uses a HashMap to function as a media database for the MediaVault library; a stub database was created for testing its functionality in this iteration. MediaCollection.java works with the User and Media classes to store a user's personal list of media.
Login.java and Encryption.java work together to create user accounts securely using SHA-256 encryption and store them in the Login database (LoginDB.java). Login.java also allows users to login to their accounts using their credentials.

#### Persistence
The persistence layer contains LoginDB.java which acts as the Login database for MediaVault. It uses the Singleton Design Pattern to ensure that there can only be one instance of the database. A HashMap is used to store the logins, and validation checks are used to ensure that duplicate accounts cannot be created.

#### User Interface
The user interface layer contains SignUpUI.java and LoginUI.java which allow users create accounts and login respectively using a GUI. Both classes use validation checks to ensure that correct information is inputted such as non-empty username and password fields and matching passwords when creating an account.

ExploreUI.java is used as a placeholder window to represent the home page; users are directed to it upon a successful login/sign up and are also able to log out of it.

## Running MediaVault
To run MediaVault, simply compile and run the **MediaVault.java** file located in the userinterface package in the source folder.
