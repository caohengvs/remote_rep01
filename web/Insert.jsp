<%--
  Created by IntelliJ IDEA.
  User: caoheng
  Date: 2020/2/4
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<form action="/day11/insert" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>金额:</td>
            <td><input type="text" name="money"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
</form>

</body>
</html>
