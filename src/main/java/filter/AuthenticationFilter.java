package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (authFilter(httpServletRequest, httpServletResponse)) {
            return;
        }
        chain.doFilter(request, response);
    }

    private boolean authFilter(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        Boolean authentication = (Boolean) httpRequest.getSession().getAttribute("authenticated");
        switch (httpRequest.getRequestURI()) {
            case "/login", "/" -> {
                if (authentication != null && authentication) {
                    httpRequest.getRequestDispatcher("home.jsp").forward(httpRequest, httpResponse);
                    return true;
                }
            }
            case "/userInfo","/home" -> {
                if (authentication == null || !authentication) {
                    httpRequest.setAttribute("credentials_error", "Please login to view this page!");
                    httpRequest.getRequestDispatcher("login.jsp").forward(httpRequest, httpResponse);
                    return true;
                }
            }
        }
        return false;
    }

}
