package firstWeb;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DepartmentServlet {

	private DepartmentDAO dao=new DepartmentDAOImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession sess=req.getSession(true);
			sess.setAttribute("current", dao.firstId());
//			sess.setAttribute("dept", dao.getDepartment(dao.firstId()));
    		req.setAttribute("dept", dao.getDepartment(dao.firstId()));
			req.getRequestDispatcher("department.jsp").forward(req, resp);
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess=req.getSession();
		int current =(Integer)sess.getAttribute("current");
		String submit=req.getParameter("submit");
		try {
		if("First".equals(submit)) {
			current=dao.firstId();
		}else if("Last".equals(submit)) {
			current=dao.lastId();
		
	}else if("Next".equals(submit)) {
		current=dao.nextId(current);
	}else if("Previous".equals(submit)) {
		current=dao.previousId(current);

}
		req.setAttribute("current", current);
		req.setAttribute("dept", dao.getDepartment(current));
		req.getRequestDispatcher("department.jsp").forward(req, resp);
		
//		resp.sendRedirect("department.jsp");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
}

}
