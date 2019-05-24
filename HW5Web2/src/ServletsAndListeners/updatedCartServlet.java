package ServletsAndListeners;

import Info.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

@WebServlet(name = "updatedCartServlet", urlPatterns = { "/updatedCartServlet" })
public class updatedCartServlet extends HttpServlet {

    /**
     * This method updates quantity of items in shopping cart
     * if quantity is 0 than item is removed
     * */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShoppingCart cart = (ShoppingCart) request.getServletContext().getAttribute(ShoppingCart.ATTRIBUTE_NAME);
        Enumeration<String> list = request.getParameterNames();
        while(list.hasMoreElements()){
            String id = list.nextElement();
            int val = Integer.parseInt(request.getParameter(id));
            if (val == 0){
                cart.remove(id);
            } else {
                cart.updateItemNumber(id, val);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("showCart.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
