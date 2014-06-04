package org.thinker.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class ResultSetToVOConverter<E> {
	private String className;
	private ResultSet rs;
	private Object obj;
	
	public E getObject(){
		return (E)this.obj;
	}

	public ResultSetToVOConverter(String className, ResultSet rs) throws Exception{

		this.className = className;
		this.rs = rs;		
		Class clz = Class.forName(className);
		obj = clz.newInstance();
		
		ResultSetMetaData rsmd = rs.getMetaData();
		


		for (int i = 1; i <= rsmd.getColumnCount(); i++) {

			BeanInfo info = Introspector.getBeanInfo(clz);
			PropertyDescriptor[] props = info.getPropertyDescriptors();
			

			for (PropertyDescriptor prop : props) {

				String name = prop.getName();
				name = name.toUpperCase();
				if(name.equals(rsmd.getColumnName(i))){
//					System.out.println(name);
					Method setMethod = prop.getWriteMethod();
					Class paraType = setMethod.getParameterTypes()[0];
//					System.out.println(paraType);
					if(paraType == String.class){
//						System.out.println(i);
						setMethod.invoke(obj, rs.getString(rsmd.getColumnName(i)));
					}else if(paraType == int.class){
//						System.out.println(rsmd.getColumnName(i));
						setMethod.invoke(obj, rs.getInt(rsmd.getColumnName(i)));
					}else if(paraType == Date.class){
//						System.out.println(rsmd.getColumnName(i));
						setMethod.invoke(obj, rs.getDate(rsmd.getColumnName(i)));
					}else if(paraType == long.class){
						setMethod.invoke(obj, rs.getLong(rsmd.getColumnName(i)));
					}
					break;
				}
				

			}
			
		}

				

		
	}
	

}