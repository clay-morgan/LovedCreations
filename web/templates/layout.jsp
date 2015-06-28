<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
</head>
<body>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <tiles:insertAttribute name="include"></tiles:insertAttribute>
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
    <div class="container-fluid">
        <tiles:insertAttribute name="content"></tiles:insertAttribute>
    </div>
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>
