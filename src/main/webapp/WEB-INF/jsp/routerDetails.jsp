<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Router</title>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <input type="button" class="btn btn-success" value="Go back" onclick="history.back()">
    </div>
    <div class="panel-body">
        <div class="page-header"><h1>Router ${operationWithRouter}</h1></div>
        <sf:form modelAttribute="router" method="POST">
            <fieldset class="form-group">
                <label for="routerName">Name</label>
                <input type="text" class="form-control" id="routerName" name="routerName" value="${router.routerName}"
                       required>
            </fieldset>
            <fieldset class="form-group">
                <label for="apMac">ApMac</label>
                <input type="text" class="form-control" id="apMac" name="apMac" value="${router.apMac}" required>
            </fieldset>
            <button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
        </sf:form>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}scripts.jsp"/>
</body>
</html>
