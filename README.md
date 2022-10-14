# PaymentWalletApplicationAPI
Live Link:-  <a target="_blank" >https://payment-wallet-api.netlify.app/</a>

Swagger Link:- <a target="_blank" >http://localhost:8888/swagger-ui/</a>

This is the collabartive project which is our Backend project based on SpringBoot JPA (API).
This is the Payment API project with the help of this we can  make various operations like Transaction,Bill payment,Transaction history,Add Balance to Wallet etc. 
A Colloborative Project build by 5 Team member in 5 working Day.

## Entity Relationship Diagram



<img src="https://i.imgur.com/SeX80BI.jpg" alt="ER Diagram"/>

## Features
- User Login / Signup 
- User Wallet for Each user.
- Add Money from Bank Account to Wallet.
- Transfer Money from wallet to wallet.
- Deposit Money wallet to Bank Account.
- User can pay different category bills.
- User can view Transactions.

## Backend Work

- Stored Data in MySQL
- Authentication of signUp and Login
- Input Validation
- Implement Login and logout Functionality with CurrentSeesionUser table.
   
 ## Installation & Run
 - Before running the API server, we should update the database config inside the application.properties file.
 - Update the port number, username and password as per our local database config.  
    - server.port=8888
    - spring.datasource.url=jdbc:mysql://localhost:3306/projectDB;
    - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    - spring.datasource.username=root
    - spring.datasource.password=root

## Tech-Stack

- Java
- Spring Data JPA
- Spring Boot
- Hibernate
- MySQL
- Java-Script

# Team-Members
- Kishan Savaj [@kishan169](https://github.com/kishan169)
- Yogesh Jagtap [@jagtapyogesh41](https://github.com/jagtapyogesh41)
- Deepak Kumar Singh [@Dks-believer](https://github.com/Dks-believer)
- Surag [@SuragVC](https://github.com/SuragVC)
- Surya Moharana [@SuryAMoharana](https://github.com/SuryAMoharana)

# Frontend 
## User Interface

![Screenshot (318)](https://user-images.githubusercontent.com/97676470/193452018-ead3ee58-53ee-4d28-bc8b-3a63d1f4cc2e.png)

## LogIn_signUp

![Screenshot (319)](https://user-images.githubusercontent.com/97676470/193452106-69792da6-1cd6-4721-bc4c-19193e0b9c57.png)

## Benificiary Details

![Screenshot (320)](https://user-images.githubusercontent.com/97676470/193452144-89e944df-c8de-4355-b241-fe0dd1b6a177.png)

# Backend

## Swagger UI

![Screenshot (321)](https://user-images.githubusercontent.com/97676470/193454568-b4e6c1b4-bcf7-4a39-b544-28c4d83c67bf.png)

## Bank Account controller and Basic error controller


![Screenshot (322)](https://user-images.githubusercontent.com/97676470/193454629-f234e6a3-c789-4140-8970-282ce284b9b4.png)

## Login, SignUp, Transaction, Wallet Controller
![Screenshot (324)](https://user-images.githubusercontent.com/97676470/193454681-56f20521-7045-4fd4-b91f-ed31036ccde9.png)

## Benificiary Detail and Bill Payment controller
![Screenshot (325)](https://user-images.githubusercontent.com/97676470/193454749-00148c65-19a9-455f-8c29-5aa9ef7ef670.png)

![thank-you-message-person-using-laptop-computer-thank-you-message-person-using-laptop-computer-165172636](https://user-images.githubusercontent.com/97676470/193455146-6d60ca42-0811-46b0-ad3f-0c49a1296fa5.jpg)
