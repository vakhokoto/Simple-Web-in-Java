<%@ page import="Info.DataManager" %>
<%@ page import="java.util.List" %>
<%@ page import="Info.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Info.ShoppingCart" %><%--
  Created by IntelliJ IDEA.
  User: vakhokoto
  Date: 5/18/19
  Time: 6:25 PM

  This jsp file is for showing cart items with quantity, price, name
  and also total price of items in the cart
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
<ul>
    <%
        ShoppingCart cart = (ShoppingCart) request.getServletContext().getAttribute(ShoppingCart.ATTRIBUTE_NAME);
        List<Product> cartList = cart.getItemList();
        double sum = 0;
        for (Product cur : cartList) {
            sum += cur.getPrice() * cart.getItemNumber(cur.getId());
            out.print("<li>");
            out.print("<p><input name=\"productID\" type=\"number\" value=" + cart.getItemNumber(cur.getId()) + " readonly/>");
            out.print(" " + cur.getName() + " ");
            out.print("$" + cur.getPrice() + "</p>");
            out.print("</li>");
        }
    %>
</ul>
<form action = updateCart.jsp>
    <p><%="Total: $" + sum + "  "%><button type = submit>Update cart</button></p>
</form>
<a href="index.jsp">
    Continue shopping
</a>
</body>
</html>