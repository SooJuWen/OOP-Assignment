/*
author : Jason
date : 4/4/2021
file type : superclass
inherits : Passenger
 */
package menu;

public class Person {
    private String name;
    private String IC;
    private String age;
    private char gender;
    
    public Person() {}
    
    public Person(String name, String IC, String age, char gender) {
        this.name = name;
        this.IC = IC;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIC() {
        return IC;
    }

    public void setIC(String IC) {
        this.IC = IC;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public String genderString(char gender) {
        if (Character.toUpperCase(gender) == 'M')
            return "Male";
        else
            return "Female";
    }

    @Override
    public String toString() {
        return "\n Name      : " + name + "\n IC number : " + IC + "\n Age       : " + age + "\n Gender    : " + genderString(gender);
    }
}

//changed