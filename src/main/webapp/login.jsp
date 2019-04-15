<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
    <div>
        <h1></h1>
    </div>

    <form action="j_security_check" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2">Username:</label>
            <div class="col-sm-10">
                <input type="text" class="" name="j_username" placeholder="Username" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>
            <div class="col-sm-10">
                <input type="password" class="" name="j_password" placeholder="Password" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>
        </div>
    </form>

    <%--<div>
        <a href="<spring:url value="/register"/>"><spring:message code="app.register.form.name"/></a>
    </div>--%>
  <br/>
</body>
</html>
