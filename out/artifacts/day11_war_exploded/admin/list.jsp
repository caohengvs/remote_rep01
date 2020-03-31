<%@ page import="com.caoheng.www.entity.Bank" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: caoheng
  Date: 2020/2/4
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员</title>
</head>
<body>
<%
    List<Bank> banks = (List<Bank>) request.getAttribute("banks");
%>
<a href="/day11/Insert.jsp"><input type="button" value="新增"></a>
<table border="1">
    <tr>
        <th>
            id
        </th>
        <th>
            姓名
        </th>
        <th>
            金额
        </th>
        <th>操作</th>
    </tr>

    <% for (Bank bank : banks) {
    %>
    <tr>
        <td><%=bank.getId()%>
        </td>
        <td><%=bank.getName()%>
        </td>
        <td><%=bank.getMoney()%>
        </td>
        <td><a href="/day11/change.jsp?name=<%=bank.getName()%>">修改</a>&nbsp;&nbsp; <a href="/day11/delete?name=<%=bank.getName()%>">删除</a></td>
    </tr>
    <%}%>

</table>
<a href="/day11/logout"><input type="button" value="注销"></a>
</body>
</html>
