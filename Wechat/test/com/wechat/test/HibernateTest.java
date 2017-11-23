package com.wechat.test;

import org.junit.Test;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;  

public class HibernateTest {

	// JUnit注解，可以通过此进行测试  
      
    /** 
     * 测试1，自动创建数据表，因为在配置文件Hibernate.cfg.xml中配置了<property name="hbm2ddl.auto">update</property> 
     */
	@Test
    public void testSchemaExport() {  
        new SchemaExport(new Configuration().configure()).create(true, true);  
    } 

}
