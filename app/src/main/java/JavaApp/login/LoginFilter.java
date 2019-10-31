package JavaApp.login;



import javax.faces.application.ResourceHandler;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String registerURI = req.getContextPath() + "/register.xhtml";
        if ( req.getRequestURI().contains("/index.xhtml") && req.getSession().getAttribute("username") == null ) {
            res.sendRedirect(registerURI);
        } else {
            chain.doFilter(req, res);
        }

    }
}

