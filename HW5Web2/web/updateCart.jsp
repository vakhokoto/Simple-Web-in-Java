<%@ page import="Info.DataManager" %>
<%@ page import="java.util.List" %>
<%@ page import="Info.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Info.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: vakhokoto
  Date: 5/18/19
  Time: 6:25 PM

  This is a jsp file for showing HTML page with update option
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cart</title>
</head>
<body>
<h1>Shopping cart</h1>
<form action = "updatedCartServlet" method="post">
<ul>
    <%
        ShoppingCart cart = (ShoppingCart) request.getServletContext().getAttribute(ShoppingCart.ATTRIBUTE_NAME);
        List<Product> cartList = cart.getItemList();
        double sum = 0;
        for (Product cur : cartList) {
            sum += cur.getPrice() * cart.getItemNumber(cur.getId());
            out.print("<li>");
            out.print("<p><input name=" + cur.getId() +" type=\"number\" value=" + cart.getItemNumber(cur.getId()) + " min = \"0\"/>");
            out.print(" " + cur.getName() + " ");
            out.print("$" + cur.getPrice() + "</p>");
            out.print("</li>");
        }
    %>
</ul>
    <p><%="Total: $" + sum + "  "%><button type = submit>Update cart</button></p>
</form>
</body>
</html>