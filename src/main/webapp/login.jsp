<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h1>AUTHORIZATION</h1>
    </div>

    <form action="${pageContext.request.contextPath}/j_security_check" method="post">
        <div>
            <div>
                Username:
            </div>
            <div>
                <input type="text" name="j_username" min="3" max="20"/>
            </div>
        </div>
        <div>
            <div>
                Password:
            </div>
            <div>
                <input type="password" name="j_password" min="8" max="20"/>
            </div>
        </div>
        <div>
            <div>
                <button type="submit">Login</button>
            </div>
        </div>
    </form>

    <div>
        <a href="${pageContext.request.contextPath}/registration.jsp">Registration</a>
    </div>
  <br/>
</body>
</html>
