package sk.train.flexibleConstructor;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Employee extends Person {
    String officeID;
    Employee(String name, int age, String officeID) {
        if (age < 18  || age > 67)				     //Prolog
            // Now fails fast!
            throw new IllegalArgumentException("age is out of limit");
        super(name, age);							     //Pflicht oder this(...)
        this.officeID = officeID;						//Epilog
    }
}