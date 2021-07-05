Fibonacci Application:

Maven Build:

    Setup Jenkins Pipeline job 
    Configure the Git repo details
    Build with parameters
         local
    
    Job execution - Major steps
      > Code Quality Scan - SonarQube
      > Build & Package application : mvn package
      > Start the Application Server : java -jar target/fibonacci-1.0.0-SNAPSHOT.jar server config.yml
              
API Access End Points:
  
    Default: http://localhost:8181/fibonacci  [default QuaryParam = 5]
    User Input: http://localhost:8181/fibonacci?number=10 [userInput]

Dockerize:

    Setup Docker Engine in workstation
    Setup Jenkins Pipeline job 
    Configure the Git repo details
    Build with parameters
         docker
     Job execution - Major steps
      > Code Quality Scan - SonarQube
      > docker build and tag
      > docker push to DockerHub
      > docker run with expose ports


