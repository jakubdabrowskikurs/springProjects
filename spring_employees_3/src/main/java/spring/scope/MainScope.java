package spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScope {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-singleton.xml");

        ScopeExample scopeExample  = ac.getBean("scopeExample", ScopeExample.class);

        System.out.println(scopeExample.hashCode());

        ScopeExample scopeExample2  = ac.getBean("scopeExample", ScopeExample.class);

        System.out.println(scopeExample2.hashCode());

        //Singleton

        System.out.println("=========");

        ScopeExample scopeExample3  = ac.getBean("scopeSingletonExample", ScopeExample.class);

        System.out.println(scopeExample3.hashCode());

        ScopeExample scopeExample4  = ac.getBean("scopeSingletonExample", ScopeExample.class);

        System.out.println(scopeExample4.hashCode());



    }
}
