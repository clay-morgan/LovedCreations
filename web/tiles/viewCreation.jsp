<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${creation.getTitle()}</h1>
<p>${creation.getDescription()}</p>
<p class="text-muted pull-right">Posted: <fmt:formatDate value="${creation.getCreateDate()}" type="date" pattern="dd MMM YYYY"/></p>
<div>
    <c:forEach var="photo" items="${photos}">
        <a href="${pageContext.request.contextPath}/creation/${creation.getId()}?showPhoto=${photo.id}">
            <img src="${pageContext.request.contextPath}/thumb/${photo.getId()}" class="img-thumbnail"/>
        </a>
    </c:forEach>
</div>
<c:if test="${!empty showPhoto}">
    <p>
        <img class="img-responsive" src="/image/${showPhoto.getId()}"/>
    </p>
</c:if>
<p>
    <a class="btn btn-primary" href="/addPhoto/${creation.getId()}">Photos +1 photo</a>
</p>
