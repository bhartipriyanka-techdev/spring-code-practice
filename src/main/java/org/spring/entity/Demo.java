package org.spring.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Demo implements InitializingBean, DisposableBean {
    static{
        System.out.println("Demo Class has been Created Successfully....!");
    }
    Demo(){
        System.out.println("Demo Object has been Created Successfully.....!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Demo Class Has been Initialized Successfully.....!");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Demo Class Has been Destroy Successfully.....!");

    }

}
