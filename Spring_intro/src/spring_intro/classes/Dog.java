package spring_intro.classes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("dogBean")
public class Dog implements Pet {
    private String name;
    public Dog(){
        System.out.println("Dog bean is created");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @PostConstruct
    public void init(){
        System.out.println("Class Dog: init method");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("Class Dog: destroy method");
    }

    @Override
    public void say(){
        System.out.println("Bow-wow");
    }
}
