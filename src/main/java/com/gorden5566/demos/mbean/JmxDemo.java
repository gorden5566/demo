package com.gorden5566.demos.mbean;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author gorden5566
 * @date 2019/08/15
 */
public class JmxDemo {
    public static void main(String[] args) throws Exception {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName = new ObjectName("jmx:type=User");
        User bean = new User();

        server.registerMBean(bean, objectName);

        System.out.println("jmx started!!!");

        String oldName = null;
        String oldPwd = null;

        while (true) {
            if (oldName != bean.getName() || oldPwd != bean.getPassword()) {
                System.out.println(bean.getName() + ":" + bean.getPassword());
                oldName = bean.getName();
                oldPwd = bean.getPassword();
            }
            Thread.sleep(1000);
        }
    }
}
