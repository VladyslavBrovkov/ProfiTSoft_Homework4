package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        removeSessionAttributes(request.getSession());
        request.getRequestDispatcher("/login").forward(request, response);
    }

    private void removeSessionAttributes(HttpSession session) {
        session.removeAttribute("authenticated");
        session.removeAttribute("credentials_error");
        session.removeAttribute("userFullName");
        session.removeAttribute("userInfo");
    }
}
