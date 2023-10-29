package loginpage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print("User name ="+request.getParameter("name")+"\n"+"Password="+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if name and pass is wrong show login page again with msg..
	 * if name is less than 4 chars then add msg and login page
	 * if pass is less than 8 chars add msg login page
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  //super.doGet(request, response); get 405 error
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
//		if("root".equals(name) && "root".equals(pass) ) {
//			request.setAttribute("message", "Hii root .. how have you been");
//		}else{
//			request.setAttribute("message", "only root is a valid user");
//		}
		
		if(isValidUser(name,pass)) {
//			String message="login successfully";
			request.setAttribute("message","login successfully" );
			
			
			
		}else {
			String message="invalid user name or password";
			request.setAttribute("message",message );
			request.getRequestDispatcher("loginresults.jsp").forward(request, response);
		}
	}
		
		private boolean isValidUser(String name,String pass) {
			return name.equals("root")&& pass.equals("root");
		}
	
		
		
//		if(name.length()<4) {
//			request.setAttribute("message", "name must be atleast 4 char long");
//		}else {
//			request.setAttribute("message", "login successfully");
//		}
//		
//		
//		if(pass.length()<8) {
//			request.setAttribute("message", "password must be atleast 8 char long");
//		}else {
//			request.setAttribute("message", "login successfully");
//		}	
//		
		

//		if(pass.length()<8 && name.length()<4) {
//			request.setAttribute("message", "invalid user name or password");
//		}else {
//			request.setAttribute("message", "login successfully");
//		}	
		
	
//		request.getRequestDispatcher("loginresults.jsp").forward(request, response);
////		
	}


