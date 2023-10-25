package practiceWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PracticeServlet extends HttpServlet {
	private int count;
	@Override
	public void init() throws ServletException {
		System.out.println("initiate the practice servlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy the Hello Servlet Count " + count);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().print("Hello Nishvika!");
		
		String name=req.getParameter("name");
				
		PrintWriter out=resp.getWriter();
		
		out.print("<html>");
		out.print("<title>");
		out.print("name"+count);
		out.print("</title>");
		out.print("<body>");
		out.print("Hi <b>"+name+"</b><br/>");
		out.print("You are visitor no "+ count++ +" for this website...!");
		out.print("</body>");
		out.print("</html>");
	
	}

}
