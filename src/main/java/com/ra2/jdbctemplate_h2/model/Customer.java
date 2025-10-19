package com.ra2.jdbctemplate_h2.model;

public class Customer {
    private int age;
    private String cicle;
    private int year;

    public Customer() {
}

public Customer(int age, String cicle, int year) {
    this.age = age;
    this.cicle = cicle;
    this.year = year;
}

public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public String getCicle() {
    return cicle;
}

public void setCicle(String cicle) {
    this.cicle = cicle;
}

public int getYear() {
    return year;
}

public void setYear(int year) {
    this.year = year;
}

@Override
public String toString() {
    return "Customer{" +
            "age=" + age +
            ", cicle='" + cicle + '\'' +
            ", year=" + year +
            '}';
}

    

}
