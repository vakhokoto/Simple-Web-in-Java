import WebInfo.AccountManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet", "/createAccount"})
public class CreateAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username"), password = request.getParameter("password");
        AccountManager manager = (AccountManager) getServletContext().getAttribute("accountManager");
        if (manager.containsAccount(userName)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("AccountAlreadyExists.jsp");
            dispatcher.forward(request, response);
        } else {
            manager.addAccount(userName, password);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Found.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateAccount.jsp");
        dispatcher.forward(request, response);
    }
}
