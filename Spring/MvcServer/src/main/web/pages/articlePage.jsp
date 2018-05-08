<%--
  Created by IntelliJ IDEA.
  User: ivan_
  Date: 06.04.2018
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${empty entity}">
    <c:redirect url="${pageContext.request.contextPath}/showArticles"/>
</c:if>

<div itemscope itemtype="http://schema.org/Article">

    <form action="${pageContext.request.contextPath}/update" method="post">
        <span itemprop="name">
        <input type="text" name="title" value="${entity.title}" required>
        </span>
        <br/>
        <span itemprop="pagination">
        <input type="text" name="description" value="${entity.description}">
        </span>
        <br/>
        <span itemprop="text">
        <textarea rows="100" cols="100" name="text">${entity.text}</textarea>
        </span>
        <br/>
        <span itemprop="creator">
        <input type="text" name="author_name" value= ${entity.author.name}>
        <input type="text" name="author_surname" value= ${entity.author.surname}>
        <input type="text" name="author_experience" value= ${entity.author.experience}>
        </span>
        <input type="hidden" name="id" value="${entity.id}">
        <input type="hidden" name="author_id" value="${entity.author.id}">
        <input type="submit" value="Сохранить">
    </form>

</div>

<form action="${pageContext.request.contextPath}/delete" method="post">
    <input type="hidden" name="id" value="${entity.id}">
    <input type="submit" value="удалить">
</form>
<form action="${pageContext.request.contextPath}/showArticles">
    <input type="submit" value="назад"/>
</form>
</body>
</html>
