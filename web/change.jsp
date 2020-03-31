<%@ page import="com.caoheng.www.service.impl.ServiceImpl" %>
<%@ page import="com.caoheng.www.entity.Bank" %><%--
  Created by IntelliJ IDEA.
  User: caoheng
  Date: 2020/2/4
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
<%
   String name = request.getParameter("name");
    ServiceImpl service = new ServiceImpl();
    Bank bank = service.select(name);

%>
<form action="/day11/update" method="post">
    <table>
        <tr>
            <td>id:</td>
            <td><input type="text" name="id" readonly value=<%=bank.getId()%>></td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="name" readonly value=<%=bank.getName()%>></td>
        </tr>
        <tr>
            <td>金额:</td>
            <td><input type="text" name="money" value=<%=bank.getMoney()%>></td>
        </tr>
    </table>
    <input type="submit" value="提交">
    <input type="reset" value="恢复">
</form>


</body>
</html>
