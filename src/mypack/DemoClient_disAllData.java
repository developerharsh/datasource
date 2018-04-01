package mypack;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;;


public class DemoClient_disAllData 
{
	public static void main(String args[]) throws SQLException
	{
		
		ApplicationContext ac = new FileSystemXmlApplicationContext("Democfg.xml");
		
		Demo d=(Demo) ac.getBean("ab");
		
		List<User> data = d.findAllData();
		Iterator<User> it = data.iterator();
		
		while(it.hasNext())
		{
			User u= it.next();
			System.out.println(u.getUserName()+" "+u.getUserPassword());
		}
	}
}
