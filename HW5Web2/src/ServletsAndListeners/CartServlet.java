package ServletsAndListeners;

import Info.DataManager;
import Info.ShoppingCart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CartServlet", urlPatterns = {"/cartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * This Servlets post method adds item in ShoppingCart with quantity 1
     * */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("productID");
        ShoppingCart cart = (ShoppingCart) request.getServletContext().getAttribute(ShoppingCart.ATTRIBUTE_NAME);
        if (cart.containsItem(id)){
            cart.updateItemNumber(id, cart.getItemNumber(id) + 1);
        } else {
            DataManager manager = (DataManager) request.getServletContext().getAttribute(DataManager.ATTRIBUTE_NAME);
            cart.addItem(manager.getProductInfo(id));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("showCart.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
