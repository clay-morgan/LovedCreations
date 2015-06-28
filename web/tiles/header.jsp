<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!-- specify we'll be using the JSTL tag library -->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#lovedCreations-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Loved Creations</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="lovedCreations-navbar-collapse">
            <div class="pull-right">
                <form class="navbar-form navbar-left" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </form>
                <span class="pull-right">
                    <sec:authorize access="!isAuthenticated()">
                        <a class="btn btn-success navbar-btn" href="<c:url value="${pageContext.request.contextPath}/login"></c:url>">Log In</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a class="btn btn-warning navbar-btn" href="<c:url value="${pageContext.request.contextPath}/j_spring_security_logout"></c:url>">Log Out</a>
                    </sec:authorize>
                </span>
            </div>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>