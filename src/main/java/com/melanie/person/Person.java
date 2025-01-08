package com.melanie.person;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private String country;
    private String phoneNumber;

    public Person( String name, String lastName, String country, String phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }


    public void setName(String name){
        this.name = name;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void  setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getCountry(){
        return this.country;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return  this.name+" "+this.lastName+" "+this.country+" "+this.phoneNumber;
    }
}

