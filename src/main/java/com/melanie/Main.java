package com.melanie;

import com.melanie.person.Person;
import com.melanie.services.CsvHandler;
import com.melanie.services.DataPersonCreator;
import com.melanie.services.FileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Holi<3");

        CsvHandler csv = new CsvHandler();
        csv.createCsvRandomDataPeople(50);


    }
}