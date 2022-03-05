package spring_intro.Tests;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_intro.classes.Person;
import spring_intro.classes.Pet;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Pet pet = context.getBean("myPet", Pet.class);
        Person person = context.getBean("myPerson", Person.class);
        System.out.println(person.getSurname());
        person.callYourPet();
        context.close();
    }
}
