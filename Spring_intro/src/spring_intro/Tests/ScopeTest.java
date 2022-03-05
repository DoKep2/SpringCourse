package spring_intro.Tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_intro.classes.Dog;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Dog dog1 = context.getBean("dogBean", Dog.class);
        dog1.say();
        context.close();
    }
}
