# springboot and CI/CD

1. springboot install springboot helper for springboot init
2. add controller
3. add get param parse into map
4. add response cross origin
5. add test
6. add ci demo things  travis and gitlab-ci.yml
7. Change pom.xml, to make sure we set the main class and executable to be true for maven build plugin


gitlab-ci.yml/travis.yml???? which one is working.
if gitlab-ci is working.....
11. add package command to gitlab-ci.yml, make sure to generate .tar
9. add docker file, which will copy the .tar into image
   docker build -t xingxiliang/spring_find_weak_server    .
   9.1 docker push xingxiliang/spring_find_weak_server
        docker --name sprint_find_weak_server -d -p 8888:8888  xingxiliang/spring_find_weak_server
12. change gitlib-ci.yml to integrate docker build & docker push

if travis.yml is working.....
actaully, it is travis.yml is working, please refer to it.

Java CI Demo

Largely inspired/stolen from: https://github.com/joaomlneto/travis-ci-tutorial-java/
