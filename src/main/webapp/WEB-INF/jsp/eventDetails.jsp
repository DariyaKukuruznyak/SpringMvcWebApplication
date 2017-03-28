<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Event</title>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <a class="btn btn-success" href="${pageContext.request.contextPath}/event/list" class="panel-title">Go to the
            all events</a>
    </div>
    <div class="panel-body">
        <div class="page-header"><h1>Event ${operationWithEvent}</h1></div>
        <h2 style="color: red">${sessionScope.errorMessage}</h2>
        <sf:form modelAttribute="event" method="POST">

            <fieldset class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${event.name}" required>
            </fieldset>
            <fieldset class="form-group">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location" value="${event.location}"
                       required>
            </fieldset>
            <fieldset class=" form-group">
                <label for="dateFrom">Date From</label>
                <input type="date" id="dateFrom" class="form-control" name="dateFrom"
                       value="${event.dateFrom}" required>
            </fieldset>
            <fieldset class=" form-group">
                <label for="dateTo">Date To</label>
                <input type="date" class="form-control" id="dateTo" name="dateTo"
                       value="${event.dateTo}" required>
            </fieldset>
            <fieldset class=" form-group">
                <button class="btn btn-lg btn-primary btn-block" type="submit">OK</button>
            </fieldset>

            <c:if test="${not empty event.id}">
                <h1>Routers <a class="glyphicon glyphicon-plus"
                               href="${pageContext.request.contextPath}/event/${event.id}/router/add"></a></h1>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>ApMac</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty routers}">
                        <c:forEach items="${routers}" var="router" varStatus="status">
                            <tr>
                                <td> ${router.routerName}</td>
                                <td>${router.apMac}</td>
                                <td><a class="glyphicon glyphicon-pencil"
                                       href="${pageContext.request.contextPath}/event/${event.id}/router/edit/${router.id}"></a>
                                </td>
                                <td><a class="glyphicon glyphicon-trash"
                                       href="${pageContext.request.contextPath}/event/${event.id}/router/delete/${router.id}"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </c:if>
        </sf:form>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}scripts.jsp"/>
</body>
</html>
