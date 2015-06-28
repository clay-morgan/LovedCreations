<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Edit Loved Creation</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/editCreationSubmit" commandName="creation" class="form">
    <sf:input path="id" type="hidden"></sf:input>
    <div class="form-group">
        <label for="title">Name of Creation</label>
        <sf:input path="title" class="form-control" value="${creation.getTitle()}" name="title" type="text" id="title"/>
        <sf:errors path="title" cssClass="bg-danger"/>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <sf:input path="description" name="description" value="${creation.getDescription()}" type="text"  class="form-control" id="description"/>
        <sf:errors path="description" cssClass="bg-danger"/>
    </div>
    <a href="${pageContext.request.contextPath}/" class="btn btn-warning">Cancel</a>
    <input type="submit" value="Save" class="btn btn-primary"/>
</sf:form>
