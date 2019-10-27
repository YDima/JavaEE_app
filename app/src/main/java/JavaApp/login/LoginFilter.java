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
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login.xhtml";
        String registerURI = req.getContextPath() + "/register.xhtml";

        boolean in = session != null && session.getAttribute("user") != null;
        boolean loginr = req.getRequestURI().equals(loginURI);
        boolean registerr = req.getRequestURI().equals(registerURI);
        boolean resourcer = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (in || loginr || registerr || resourcer){
            chain.doFilter(req, res);
        }
        else
            res.sendRedirect(loginURI);

//        if ( req.getRequestURI().contains("/index.xhtml") && req.getSession().getAttribute("username") == null ) {
//
//        } else {
//
//        }
    }
}
