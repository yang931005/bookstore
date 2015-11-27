package cn.zucc.filter;

import java.io.UnsupportedEncodingException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Myrequest extends HttpServletRequestWrapper {

	public Myrequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String value = super.getParameter(name);
		if(value == null){
			value="";
		}
		try {
			value =new String(value.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}


}
