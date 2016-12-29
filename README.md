# assigment-project-mindtree
Mindtree Assignment [Blog Site] :-

Technology used: Spring-Boot, Embedded DB (H2)

Additional Features: Spring security, Twitter (including storage of tweets in DB)

Added bonus point code

Behavior of application:-



•	For First time there is no post on Blog site and you will be asked to login or create an account.

•	First user who create account will have Admin access rest will have normal access.

•	When you create account it will be auto-logged in to application.

•	Admin can create read or delete post.

•	Post can have Image or Video in it.

•	Post will have title and description with one Media file

•	Every post has its detail page and also comment section.

•	Every logged in user or non-logged in user can read all blog, read or write comments, and search tweets.

•	Comment section does not have authorization.

•	If user is logged in then comment will not ask for your name.

•	You will have logout option at top right when click on your username.



Twitter Integration [using spring social api]

•	You can search tweet based on keyword that will be stored in db against that keyword.

•	Every keyword can have at max 20 tweets in DB at a time.


Embedded DB access

•	You can access DB by http://localhost:9090/console/ , check every transaction.

•	The only issue with embedded DB, data does not persist after restart the application.



Spring Security

•	User Authentication is available with JDBC

•	User creation and Login pages for authentication is there.

Junit 

Wrote Test cases with Junit4.


To Run Application just use maven command “spring-boot:run” from directory where pom.xml exist.

