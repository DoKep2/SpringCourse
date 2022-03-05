package spring_intro.Tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_intro.classes.Dog;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog myDog2 = context.getBean("myPet", Dog.class);
        context.close();
    }
}
