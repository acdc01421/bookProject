package org.thinker.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestToVOConverter<E> {
	private String className;
	private HttpServletRequest request;
	private Object obj;
	
	public E getObject(){
		return (E)this.obj;
		
	}

	public RequestToVOConverter(String className, HttpServletRequest request) throws Exception{

		this.className = className;
		this.request = request;
		
		Class clz = Class.forName(className);
		obj = clz.newInstance();
		
		Map<String, String[]> paraMap = request.getParameterMap();
		
		
		BeanInfo info = Introspector.getBeanInfo(clz);
		PropertyDescriptor[] props = info.getPropertyDescriptors();
		
		
		for (PropertyDescriptor prop : props) {
//			System.out.println(prop);
			Method setMethod = prop.getWriteMethod();
			if(setMethod == null || paraMap.get(prop.getName()) == null){
				continue;
			}
			
			Class paraType = setMethod.getParameterTypes()[0];
			
			if(paraType == String.class){
				setMethod.invoke(obj, paraMap.get(prop.getName())[0]);
			}else if(paraType == int.class){
				setMethod.invoke(obj, Integer.parseInt(paraMap.get(prop.getName())[0]));
			}else if(paraType == long.class){
				setMethod.invoke(obj, Long.parseLong(paraMap.get(prop.getName())[0]));
			}

		}
		
		
	}
	
	
	
}
