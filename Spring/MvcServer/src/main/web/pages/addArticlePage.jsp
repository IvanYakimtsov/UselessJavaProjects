<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div itemscope itemtype="http://schema.org/Action">
    <form action="${pageContext.request.contextPath}/add" method="post">
        <input type="text" name="title" required>
        <br/>
        <input type="text" name="description">
        <br/>
        <textarea rows="100" cols="100" name="text"></textarea>
        <br/>
        <input type="text" name="author_name">
        <input type="text" name="author_surname">
        <input type="text" name="author_experience">
        <input type="submit" value="Создать">
    </form>
</div>
<form action="${pageContext.request.contextPath}/showArticles">
    <input type="submit" value="назад"/>
</form>
</body>
</html>
