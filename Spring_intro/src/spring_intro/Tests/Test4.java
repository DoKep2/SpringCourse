package spring_intro.Tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_intro.classes.Dog;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Dog dog = context.getBean("myPet", Dog.class);
        dog.setName("Barsik");
        Dog dog2 = context.getBean("myPet", Dog.class);
        dog2.setName("Red");
        System.out.println(dog.getName());
        System.out.println(dog2.getName());
        context.close();
    }
}
