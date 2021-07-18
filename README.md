**Relevel Quora Clone – Java Spring Boot**

**Problem Statement:**

Relevel is planning to build a social media discussion app like Quora.You have to design & build the backend for this application. It should have ability for the users to ask a question , upvote a question , answer a question , follow  a user etc.

Your task is to go through below templates/stories and create this Quora clone app.

The tech stack required is Java and Spring Boot. Preferred IDE is Intellij/Eclipse to import the project directly. Postman tool to test the REST APIs. Make sure maven and .m2 etc are configured on local.

**How to Set up the Application:**

To get ready with building the application a basic or boilerplate template code is provided below.
Template Repo Link: https://github.com/RelevelBackendTest/quora_clone
Git clone the project from above location to your local system and import it any one of the IDE to get started.
  
Once you clone the application, then run the main class of the application  as a Java Application. The default port is set to 8080 for this application , and there is a sample endpoint to test the set up is complete. Open the sample URL localhost:8080\ping in browser to see a message “Ping is Successful” . This ensures the set up is complete.

**Database Set Up :**
The application is configured with an in-memory H2 Database .Dependency for the database is already added in the pom.xml file. You can access the console of the H2 database using the following link 

**URL for H2 Database: localhost:8080/h2-console
Username : sa
Password : password
**
**Note** : You can create table for your problem statements using this database.

**Problem Breakdown:**

**Template-1: User’s Question Creation and its related functionality**

**1.Story-1: Asking a question by the user (~30min)**
 As a user I should be able to ask a question with different tags.
      The task is to create an endpoint localhost:8080/ask to post a question.
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user needs to provide the details of questions e.g. (Question Description, Category (Health, Business, Music, Films, Cricket etc.) ,List of tags of the questions(movies, entertainment, songs etc.) , Visibility of the Question (Public/Limited) and Creation Date etc.)
3.	Basic validation on the attributes of the question needs to be performed with following rules : 
a. Question Description should be max 5-100 chars
b. Category should be 2-30 chars
c. Each tag should be less than 20 chars
d. Visibility should either be Public or Limited
e. Creation Date should be same as the current date

4.	In case user provides wrong input , they should get a message saying “Invalid Input by user” with appropriate HTTP status.
5.	In case user provides right set of inputs, the data should get stored in the database with an unique questionID , and user should get a response with message “Question Created Successfully” with appropriate HTTP status.

**2.Story-2: Retrieving details of a question asked by the user (~30min)**
 As a user I should be able to retrieve the a question asked by a user
      The task is to create an endpoint localhost:8080/ask/{questionID} to retrieve a question.
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user needs to provide the QuestionID in the URL to search for the question details
3.	In case user provides a QuestionID which does not exist then they should get a response “Question ID does not exist” with appropriate HTTP status.
4.	In case user provides a correct QuestionID they should get details of the question(Question Description,Cateogry , Tags, Created Date etc). with appropriate HTPP status.






**3. Story-3 : Deleting a Question asked by User (~30 min)**
The task is to create an endpoint localhost:8080/ask/{questionID} to delete  a question asked by the user.
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user needs to provide the Question ID in the URL to delete a question under the user.
3.	In case the Question ID does not exist, the user should get a response “Question does not exist” with appropriate HTTP status.
4.	In case Question ID exists in the database , delete the question from the database and send a response “Question Deleted Successfully” with appropriate HTTP status.

**4.Story-4 : Searching all questions with a given tag (~45 min)- Bonus**
The tasks is to create an endpoint localhost:8080/ask/search to search all the the questions which have a specified tag.
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user needs to provide the tag as an input to the URL , and they should get a list of questions with their details as response with appropriate HTTP status
3.	If there does not exist any question with the tag provided by the user ,it should return an empty list


**Template -2: Adding User and its related functionality**

**1.	Story -1 (~30 min): Create a User**
      The task is to create an endpoint localhost:8080/user so that we can create a user 
a.	Choose appropriate HTTP methods(GET,POST,PUT,DELETE) to hit this URL.
b.	The user should provide details like Name, Password, Phone Number, Email ID, Age, Gender.
c.	Validate the user input using following rules .
1.	Name – Max 20 Chars without any special character except space
2.	Password – Max 10 chars with alpha numeric string
3.	Phone Number : Should be exactly 10 digit
4.	Email ID : Valid Email Id format e.g. relevel.com is not valid where as relevel@gmail.com is valid 
5.	Age should be between 10 -99 years max
6.	Gender should be male or female.

d.	 Create an appropriate table to store these details of the user.
e.	Upon successful creation of the user return HTTP status as 201 with a message “User Created Successfully”.
f.	If user has provided wrong input , provide appropriate HTTP status with a message “User inputs are valid” .


**2.	Story -2 (~30 min): Login for the User**
      The task is to create an endpoint localhost:8080/login so that we can verify if user credentials are valid .
a.	Choose appropriate HTTP methods(GET,POST,PUT,DELETE) to hit this URL.
b. The user needs to provide email address as username and password to verify if the user credentials are correct
c. Authenticate the value against the data stored in the database and upon successful authentication return appropriate HTTP status with JWT token.
d. In case user has provided a wrong password , return a HTTP status as 401 with message as “Invalid Password”.
e. If the user name provided by the user doesn’t exist return a HTTP status as 404 with message “User does not exist”


**3.	Story-3 (~ 30 min): Retrieve the Details of the user**
The task is to create an endpoint localhost:8080/user/{userid}  to fetch the user details 
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user needs to provide the ID of the user to get user details as  response.
3.	In case user provides an ID which does not correspond to any user , they should see a HTTP 404 status with “No users for the given ID” as the response message.
4.	In case of Success , the user should see details of the user with appropriate HTTP status
**
Template: 3 : Following a user and upvote/answering a question**

**Story-1: Follow a user (~30 min)**
The task is to create an endpoint localhost:8080/follow so that a user can follow another user.
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	User needs to provide two input to this URL , follower’s user ID and user ID of the person who needs to be followed(leader).
3.	In case of User ID  of Follower or person to be followed does not exist , we should get a response “Follower or Leader’s User ID does not exist” with appropriate HTTP Status. 
4.	In case of correct input, the user should be able to follow the person  with a response “Followed Successfully” with appropriate HTTP status.




**Story-2 : Upvoting a  question (~45 min)**
The task is to create an endpoint localhost:8080/upvote so that a user can upvote a question.

1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user should provide its User ID and the QuestionID to this endpoint and should be able to upvote the question.
3.	In case the user ID or Question ID does not exist  ,we should get a response “User ID or the Question ID are not valid ” with appropriate HTTP status
4.	In case of correct input by the user , the user should be able to upvote the question and we should get a response “Upvoted the question successfully” with appropriate HTTP response.
**
Story -3 : Answering a Question (~45 min)**
The task is to create an endpoint localhost:8080/answer so that a user can answer a question .
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user should provide his own userID , questionID and an answer to the question .
3.	In case UserId  or questionID do not exist , we should get a response “User Id or Question ID are not valid” with  appropriate HTTP response.
4.	In case of correct input by the user , the user should be able to answer the question with a message “Answered the Question Successfully” with appropriate HTTP response and the answer should get tagged to the question.


**Story -4 :Finding answer to a  Question (~30 min) - Bonus**
The task is to create an endpoint localhost:8080/answer so that a user can find an answer to the question
1.	Choose appropriate HTTP methods (GET,POST,PUT,DELETE) to hit this URL.
2.	The user should provide questionID as the input to the end point.
3.	In case questionID does not exist , we should get a response “ Question ID is not valid” with  appropriate HTTP response.
4.	In case of correct input by the user , the user should be able to get list of all answer provided to the question with appropriate HTTP status.




