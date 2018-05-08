<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head><title>Hello</title></head>
<body>
<%--<jsp:forward page="/pages/homePage.jsp" />--%>

<c:redirect url = "/showArticles"/>
<%--<form action=${pageContext.request.contextPath}/showArticles>--%>
    <%--<input type='submit' value='test'/>--%>
<%--</form>--%>
<%--<c:redirect url = "${pageContext.request.contextPath}/pages/topicPage.jsp"/>--%>
</body>
</html>
