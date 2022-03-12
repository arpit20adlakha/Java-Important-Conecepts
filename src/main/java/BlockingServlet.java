import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class BlockingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(req.getMethod());
        Enumeration<String> e = req.getHeaderNames();
        while(e.hasMoreElements()) {
            String element = e.nextElement();
            System.out.println(element);
        }
        System.out.println();
        response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().println("{\"status\": \"ok\"}");
    }
}
