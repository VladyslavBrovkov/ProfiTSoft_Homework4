package servlet;

import repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {"/login", "/"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userLogin = request.getParameter("login");
        String userPassword = request.getParameter("password");
        checkUserCredentials(request, response, userLogin, userPassword);
    }

    private void checkUserCredentials(HttpServletRequest request, HttpServletResponse response, String userLogin, String userPassword) throws ServletException, IOException {
        if (UserRepository.checkUserCredentials(userLogin, userPassword)) {
            request.getSession().setAttribute("authenticated", true);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.setAttribute("credentials_error", "Incorrect login or password. Try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
