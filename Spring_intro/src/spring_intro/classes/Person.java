package spring_intro.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    @Autowired
    @Qualifier("catBean")
    private Pet pet;

    ///@Value("${person.surname}")
    private String surname;
    ///@Value("${person.age}")
    private int age;
//    @Autowired
//    public Person(Pet pet){
//        this.pet = pet;
//    }
    public Person(){
        System.out.println("Person is created");
    }
    public void setPet(Pet pet){
        this.pet = pet;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }
    public void callYourPet(){
        System.out.println("Hello my lovely pet");
        pet.say();
    }
}
