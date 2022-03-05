package spring_intro.Tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_intro.classes.Cat;
import spring_intro.classes.Person;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Person person = context.getBean("personBean", Person.class);
        System.out.println(person.getSurname());
        context.close();
    }
}
