<%--
  Created by IntelliJ IDEA.
  User: tuess
  Date: 2019/5/28
  Time: 12:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
      <script>
          $(document).ready(function () {
             $("#Json").click(function () {
             //    通过ajax请求springMVC
                 $.post(
                     "testJson", //请求的服务器地址
                     {"name":"zs"}, //传递的json格式的参数
                     function (res) { //服务端处理完毕后的回调函数,List<Student> students，实质是一个json数组的格式
                         // eval(res);
                         for(var i=0;i<res.length;i++){
                             alert(res[i].id+"--"+res[i].name)
                         }
                     }
                 )
             })
          });
      </script>
  </head>
  <body>

  <input type="button" name="Json" id="Json" value="testJson"><br>

    <a href="Welcome">first springmvc</a><br>
    <a href="Welcome2">second soringmvc</a><br>
    <a href="Welcome3/zs">third springmvc</a><br>
  -------------
   <form action="Add/10001" method="post">
      <input type="submit" value="增加">
    </form>

    <form action="Search/10001" method="get">
      <input type="submit" value="查找">
    </form>

    <form action="Delete/10001" method="post">
      <%--添加隐藏域，通过过滤器修改请求方式--%>
      <input type="hidden" name="_method" value="DELETE">
      <input type="submit" value="删除">
    </form>

    <form action="Update/10001" method="post">
      <input type="hidden" name="_method" value="PUT">
      <input type="submit" value="修改">
    </form>

    <form action="Param" method="post">
      <input name="name" type="text"><br>
      <input name="age" type="number">
      <input type="submit" value="传值">
    </form>

    <a href="Header">test Header</a><br>
    <a href="Cookie">test Cookie</a><br>

    <%--对象传值--%>
    <form action="ObjectProperties" method="post">
        id：<input name="id" type="text"><br>
        姓名：<input name="name" type="text"><br>
        家庭地址：<input name="address.homeAddress" type="text"><br>
        学校地址：<input name="address.schoolAddress" type="text"><br>
        <input type="submit" value="传值">
    </form>

    <a href="testServlet">test ServletAPI</a><br>

    <a href="ModelAndView">test ModelAndView</a><br>
    <a href="ModelMap">test ModelMap</a><br>
    <a href="Map">test Map</a><br>
    <a href="Model">test Model</a><br>


    <form action="ModelAttribute" method="post">
        id：<input name="id" type="hidden" value="10001"><br>
        姓名：<input name="name" type="text"><br>
        <input type="submit" value="传值">
    </form>


    <a href="I18n">test i18n</a><br>

    <%--不经过controller直接跳转到另一页面--%>
    <a href="ViewController">test ViewController</a><br>

    <%--测试自定义转换器--%>
    <form action="Converter" method="post">
        学生信息:<input type="text" name="student" value="1-zs">
        <input type="submit" value="转换">
    </form>

    <%--测试日期格式化--%>
    <form action="DataTimeFormat" method="post">
        id：<input name="id" type="text" ><br>
        姓名：<input name="name" type="text"><br>
        出生日期:<input name="birthday" type="text">
        <input type="submit" value="传值">
    </form>

  <%--测试文件上传--%>
  文件上传<br>
  <form action="FileUpload" method="post" enctype="multipart/form-data">
      描述：<input type="text" name="desc"><br>
      <input type="file" name="file"><br>
      <input type="submit" value="上传">
  </form>

  <a href="second/testExceptionHandler">testExceptionHandler</a><br>
  <a href="second/testMyException?i=3">testMyException</a><br>
  <a href="FormDemo/testForm">test Spring EL</a>
  </body>
</html>
