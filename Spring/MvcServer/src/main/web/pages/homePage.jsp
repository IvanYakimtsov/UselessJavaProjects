<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
<head><title>Hello</title></head>
<body>

<h2>Welcome</h2>

<br/>
<form action=${pageContext.request.contextPath}/pages/addArticlePage.jsp>
    <input type='submit' name="add" value='Создать статью'/>
</form>


<table>
    <c:forEach items="${list}" var="item">
        <tr>
            <div itemprop="article" itemscope itemtype="http://schema.org/Article">
                <span itemprop="name">
                    <a href="${pageContext.request.contextPath}/showArticle?id=${item.id}">${item.title}</a>
                </span>
            </div>
        </tr>

        <br/>
    </c:forEach>
</table>
<br/>
</body>
</html>
