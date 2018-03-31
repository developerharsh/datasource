package mypack;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;;


public class DemoClient 
{
	public static void main(String args[]) throws SQLException
	{
		
		ApplicationContext ac = new FileSystemXmlApplicationContext("Democfg.xml");
		
		Demo d=(Demo) ac.getBean("ub");
		
		User user = new User();
		user.setUserName("amit");
		user.setUserPassword("xyz");
		System.out.println(d.addData(user));
	}
}
