# Compiling and setup instructions:
## Resources:
##### Install font.ttf found in /src/main/resources
## Building:
##### 1. In your terminal, navigate to Maven root directory (i.e. the directory with pom.xml)
##### 2. Enter command
> mvn package
##### This command will build the game, while executing the JUnit tests. The compiled project will be created in /target/
## Testing:
##### 1. Ensure that you are in the Maven root directory
##### 2. Enter command
> mvn clean test
##### 3. The JUnit test results will be outputted to .txt files in /target/surefire-reports
## Running:
##### 1. Ensure that you are in the Maven root directory
##### 2. After building, enter command
> java -cp target/graphics.jar com.group4.app.AppWindow
##### 3. Enjoy the game!
