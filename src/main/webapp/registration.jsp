<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h1>REGISTRATION</h1>
    </div>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <div>
            <div>
                Username:
            </div>
            <div>
                <input type="text" name="username" min="3" max="20"/>
            </div>
        </div>
        <div>
            <div>
                Password:
            </div>
            <div>
                <input type="password" name="password" min="8" max="20"/>
            </div>
        </div>
        <div>
            <div>
                <button type="submit">Register</button>
            </div>
        </div>
    </form>

  <br/>
</body>
</html>