package org.thinker.common;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WebRequest extends HttpServletRequestWrapper {

	private static final String GET = "GET";

	public WebRequest(HttpServletRequest request) {
		super(request);
		try {
			this.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public String getParameter(String name) {
		if(this.getMethod().equals(GET)){
			String data = super.getParameter(name);
			
			if(data == null){
				return null;
			}
			
			try {
				return new String(data.getBytes("8859_1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			return super.getParameter(name);
		}
		return null;
	}



	public String getCookieValue(String cookieName){
		
		Cookie[] cks = this.getCookies();
		
		for (Cookie cookie : cks) {
			
			if(cookie.getName().equals(cookieName)){
				return cookie.getValue();
			}
		}
		return null;
	}
	
	public int getIntParameter(String name, int defaultValue){
		
		int value = defaultValue;
		
		try{
			value = Integer.parseInt(this.getParameter(name));
		}catch(Exception e){
			
		}
		return value;
	}
	
	
public long getLongParameter(String name){
		
		long value = 0;
		
		try{
			value = Long.parseLong(this.getParameter(name));
		}catch(Exception e){
			
		}
		return value;
	}

	
	
	

}
