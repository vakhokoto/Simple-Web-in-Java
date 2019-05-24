<%@ page import="Info.DataManager" %>
<%@ page import="java.util.List" %>
<%@ page import="Info.Product" %>
<%@ page import="javax.xml.crypto.Data" %><%--
  Created by IntelliJ IDEA.
  User: vakhokoto
  Date: 5/19/19
  Time: 11:50 PM

  This jsp file is for showing single item information
  including: image, name, price
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</html>
<%
    DataManager manager = (DataManager) request.getServletContext().getAttribute(DataManager.ATTRIBUTE_NAME);
    String id = request.getParameter("productID");
    Product pr = manager.getProductInfo(id);
    %>
<html>
<head>
    <title><%= pr.getName()%> Page </title>
</head>
<body>
<h1><%= pr.getName()%></h1>
<img alt="<%=pr.getName()%>" src="<%="store-images/" + pr.getImgName()%>" />

<form action="cartServlet" method="POST">
    $<%=pr.getPrice()%>
    <input name="productID" type="hidden" value="<%=pr.getId()%>"/>
    <input type="submit" value="Add to Cart"/>
</form>

</body>
</html>