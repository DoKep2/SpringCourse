package spring_intro.Tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_intro.classes.Person;
import spring_intro.config.MyConfig;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();
        context.close();
    }
}
