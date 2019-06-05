<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/6/5
  Time: 10:47
--%>
<%--引入springel标签库--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--此处的form是springel的form，通过RequestMapping中的赋值传值，path的值必须为实体类的属性，input框中会有默认值，springmvc会自动从名为command的对象中取值
如果不想指定为command，则需要在form标签中指定commandName或者 modelAttribute
checkbox可以通过赋值true或false来使其是否勾选，数组同理--%>
    <form:form>
        ID:<form:input path="id"/><br>
        姓名：<form:input path="name"/><br>
        性别是否为男：<form:checkbox path="sex"/>
        爱好：足球<form:checkbox path="hobbies" value="football"/>篮球：<form:checkbox path="hobbies" value="basketball"/>乒乓球：<form:checkbox path="hobbies" value="pingpangball"/>
        <input type="submit" value="提交">
    </form:form>

<%--springmvc标签还支持put和delete--%>
<form:form action="FormDemo/testMethod" method="put">
    <input type="submit" value="修改">
</form:form>

<form:form action="FormDemo/testMethod" method="delete">
    <input type="submit" value="删除">
</form:form>
</body>
</html>
