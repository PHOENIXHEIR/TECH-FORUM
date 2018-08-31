# Discuss
A discussion forum implemented using Spring Boot in the backend, secured with Spring Security (HTTP basic), and an Angular front-end.

# How to run

1. You need to install node.js first. Minimum version is 8.9.

2. After that, install Angular CLI 6.

    `npm install -g @angular/cli`

3. Open a terminal and change your working directory to `/anular-front-end`, and then:

    `ng build --prod`

4. Copy the contents of the generated `dist` folder into `/spring-back-end/springbootdemo/src/main/resources/public`.

5. Run the Maven Goal in `springbootdemo/` as `spring-boot:run`.

6. Open the browser at `http://localhost:[server.port]`, where the `server.port` is as specified in the `application.properties` file.

# Note
You **need to** have _node_modules_ directory in the root.
