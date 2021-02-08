I have Used Spring Boot to develop the given task. Spring Boot contains in-built tomcat server to deploy application.

**Implemented Features:**
1. Security implemented by using the spring security. 
2. Handled csrf attacks using spring security.
3. Implemented logout feature.
4. Create a Todo after successful authentication.
5. Update/Delete a multiple Todo tasks by checking the checkbox.
6. Developed unit testcases.

**Pre-Requisites:**
1. Maven path configured.
2. Java8 installed and added classpath.

**Building the Jar Package**
1. Go to path of Todo-List-Application directory.
2. Execute command " mvn package"

**Running the Jar:**
1. Go to the path of Todo-List-Application/target directory.
2. Execute the command " java -jar Todo-List-Application.jar"
3. open the browser and type " http://localhost:8080 "
4. Give the credentials UserName as "test" and password as "pwd123".

**Design Patterns Used**
1. DTO design pattern used to expose only few fields.
2. SingleTon Design Pattern to keep the same object always.
3. MVC design pattern to separate the business logic and the frontend.

**Future Development Plans:**
1. Adding Method level security. Which makes security configuration easy when the application has lot of methods.
2. Creation of single page application and creation of ajax call for seeing the created todo's without page refresh.
3. New user registration with Form Validation and registration confirmation through Email Link.
