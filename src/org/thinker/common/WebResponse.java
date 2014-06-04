package org.thinker.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WebResponse extends HttpServletResponseWrapper {

	public WebResponse(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}
	
	public void addCookie(String name, String value, int expire){
		
		Cookie ck = new Cookie(name, value);
		
		ck.setMaxAge(expire);
		
		this.addCookie(ck);
	}

}
