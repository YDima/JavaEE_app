package JavaApp.auth;


import javax.faces.application.ResourceHandler;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class adminFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String registerURL = request.getContextPath() + "/register.xhtml";
        String profileURL = request.getContextPath() + "/user/profile.xhtml";
        String loginURL = request.getContextPath() + "/login.xhtml";

        if (isResourceReq(request) || isSiteAllowed(request) || isUserLogged(request)) {
            chain.doFilter(request, response);

        }

        else {
            response.sendRedirect(profileURL);
        }

    }

    private boolean isUserLogged(HttpServletRequest req) {
        var session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null && session.getAttribute("role").equals("admin"))
            return true;
        else
            return false;
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
                req.getRequestURI().equals(req.getContextPath() + "/register.xhtml");
    }

    private boolean isResourceReq(HttpServletRequest req) {
        return req.getRequestURI().startsWith(
                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

}
















































