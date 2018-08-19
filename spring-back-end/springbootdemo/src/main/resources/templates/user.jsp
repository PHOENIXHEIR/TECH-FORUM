<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
    </head>
    <body>

        <div class="container container-fluid">
            <h1>Welcome, <span id="username" th:text="${user}"></span></h1>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Body</th>
                        <th>Posted by</th>
                    </tr>
                </thead>
                <tr id="pst" th:each="post: ${posts}">
                    <td th:text="${post.heading}"></td>
                    <td th:text="${post.body}"></td>
                    <td th:text="${post.userEmailId}"></td>
                </tr>
            </table>
        </div>
    </body>
</html>