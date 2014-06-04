package org.thinker.common;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ReflectServlet extends HttpServlet {
	
	protected static final String PATH="/WEB-INF/view/";
	
	protected static final Logger logger = Logger.getLogger("Controller");
	
	private String localPath ="";
	
	
	
	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}




	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		WebRequest req = new WebRequest(request);
		WebResponse res = new WebResponse(response);
		
		String path = req.getPathInfo();
		if (path == null || path.equals("/")) {
			path = "do";
		} else {
			path = path.substring(1);
		}
		String method = req.getMethod();
	
		System.out.println("reflect : " + path + method);
	
		try {
	
			Method targetMethod = this.getClass().getDeclaredMethod(
					path + method, WebRequest.class,
					WebResponse.class);
	
			targetMethod.setAccessible(true);
			String nextPage = (String) targetMethod.invoke(this, req,
					res);
	
			if (nextPage.startsWith("redirect:")) {
				res.sendRedirect(nextPage.substring(9));
				return;
			}
	
			RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);
	
			dispatcher.forward(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
