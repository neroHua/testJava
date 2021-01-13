package jmx.agent;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import jmx.instrument.bean.CentralHeater;
import jmx.instrument.bean.impl.CentralHeaterImpl;
import jmx.insturemnt.mbean.TestMBean;
import jmx.insturemnt.mbean.Test;

public class CentralHeaterAgent {

	public static void main(String[] args) throws Exception {
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		
		CentralHeater centralHeater = new CentralHeaterImpl();

		jmx.insturemnt.mbean.CentralHeaterMBean centralHeaterMBean = new jmx.insturemnt.mbean.CentralHeater(centralHeater);
		ObjectName centralHeaterName = new ObjectName("MyHome:name=centralheater");
		mBeanServer.registerMBean(centralHeaterMBean, centralHeaterName);
		
		TestMBean testMBean = new Test();
		ObjectName testName = new ObjectName("MyHome:name=test");
		mBeanServer.registerMBean(testMBean, testName);

		System.out.println("Press any key to end our JMX agent...");
		System.in.read();
	}
}
