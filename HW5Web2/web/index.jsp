<%@ page import="Info.DataManager" %>
<%@ page import="java.util.List" %>
<%@ page import="Info.Product" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: vakhokoto
  Date: 5/18/19
  Time: 6:25 PM

  This main jsp file which is run at startup and shows items available
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Welcome to shopping store</title>
</head>
<body>
    <h1>Shopping list</h1>
    <ul>
    <%
        DataManager manager = (DataManager) request.getServletContext().getAttribute(DataManager.ATTRIBUTE_NAME);
        List<String> idList = manager.getIDs();
        for (String id : idList) {
            Product cur = manager.getProductInfo(id);
            out.print("<li>");
            out.print("<a href=\"search.jsp?productID=" + cur.getId() + "\">" + cur.getName() + "</a>");
            out.print("<input name=\"productID\" type=\"hidden\" value=\"" + cur.getId() + "\"/>");
            out.print("</li>");
        }
    %>
    </ul>
</body>
</html>