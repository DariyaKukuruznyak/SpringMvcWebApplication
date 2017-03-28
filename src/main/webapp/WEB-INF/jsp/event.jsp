<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Events</title>
</head>
<body>
<div class="panel panel-primary">
    <div class="panel-heading">
        <a class="btn btn-success" href="${pageContext.request.contextPath}/event/add">Add new event</a>
    </div>
    <div class="panel-body">
        <div class="page-header">
            <h1>All events</h1>
        </div>

        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Location</th>
                <th>Date from</th>
                <th>Date to</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${eventList}" var="event" varStatus="status">
                <tr>
                    <td>${event.name}</td>
                    <td>${event.location}</td>
                    <td>${event.dateFrom}</td>
                    <td>${event.dateTo}</td>
                    <td>
                        <a class="btn btn-info"
                           href="${pageContext.request.contextPath}/event/edit/${event.id}">Edit</a>
                    </td>
                    <td>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/event/delete/${event.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="${pageContext.request.contextPath}scripts.jsp"/>
</body>
</html>
