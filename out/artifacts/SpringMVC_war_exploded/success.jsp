<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/5/28
  Time: 13:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--国际化需要引入的库,使用JSTL标签库的引入方式，c:foreach,c:if--%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${requestScope.errors}" var="error">
    ${error.getDefaultMessage()}<br>
</c:forEach>
    <fmt:message key="resource.exist"/>
    <fmt:message key="resource.welcome"/><br>
    ----request域<br>
    ${requestScope.student.id}--${requestScope.student.name}<br>
    ${requestScope.student1.id}--${requestScope.student1.name}<br>
    ${requestScope.student2.id}--${requestScope.student2.name}<br>
    ${requestScope.student3.id}--${requestScope.student3.name}<br>

    ----session域<br>
    ${sessionScope.student.id}--${sessionScope.student.name}<br>
    ${sessionScope.student1.id}--${sessionScope.student1.name}<br>
    ${sessionScope.student2.id}--${sessionScope.student2.name}<br>
    ${sessionScope.student3.id}--${sessionScope.student3.name}<br>

</body>
</html>
