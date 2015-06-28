<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!-- specify we'll be using the JSTL tag library -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron">
    <div class="container">
        <h1>Loved Creations</h1>
        <p>This page will show the most recent 5 creations</p>
    </div>
</div>


<table class="table top-padded table-responsive table-hover">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Date</th>
        <th></th>
    </tr>
    <c:forEach var="creation" items="${creations}">
        <tr>
            <td>${creation.id}</td>
            <td nowrap="true"><strong><a href="${pageContext.request.contextPath}/creation/${creation.id}">${creation.title}</a></strong></td>
            <td><strong>${creation.description}</strong></td>
            <td nowrap="true"><fmt:formatDate value="${creation.createDate}" pattern="dd MMM yyyy" /></td>
            <td>
                <a href="${pageContext.request.contextPath}/editCreation/${creation.id}" class="btn btn-xs btn-warning">edit</a>
                <a href="${pageContext.request.contextPath}/deleteCreation/${creation.id}" class="btn btn-xs btn-danger"
                   onclick="if( !confirm( 'Are you sure you wish to delete this Loved Creation?' ) ) return false;">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a class="btn btn-default" href="${pageContext.request.contextPath}/addCreation">+</a>
