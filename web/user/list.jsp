<%@ page import="com.caoheng.www.entity.Bank" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: caoheng
  Date: 2020/2/4
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查看</title>
</head>
<body>
<%
    Bank bank = (Bank) request.getAttribute("user");
%>
<table border="1" cellspacing="1">
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>金额</th>
    </tr>

    <tr>
        <td><%=bank.getId()%>
        </td>
        <td><%=bank.getName()%>
        </td>
        <td><%=bank.getMoney()%>
        </td>
    </tr>
</table>
<a href="/day11/logout"><input type="button" value="注销" size="200"></a>
</body>
</html>
