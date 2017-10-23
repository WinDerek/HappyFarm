package org.derekdaisy.happyfarm;

public abstract class Person {

    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getNam() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
