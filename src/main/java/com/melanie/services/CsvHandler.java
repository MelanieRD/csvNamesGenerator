package com.melanie.services;

import com.melanie.person.Person;

public class CsvHandler {

    public CsvHandler(){}

    public void createCsvRandomDataPeople( int numOfRecords){

        DataPersonCreator dataPersonCreator = new DataPersonCreator();
        StringBuilder dataBuilder = new StringBuilder();
        FileHandler fileHandler = new FileHandler();
        dataBuilder.append("Name, lastName, Country, Phone Number \n");
        Person data;
        try{
            while(numOfRecords >= 1){
               data = dataPersonCreator.createDataPersonObj();
               dataBuilder.append(data+",\n");
                numOfRecords--;
            }


            fileHandler.writeRecordToFile(dataBuilder.toString());
            System.out.println(dataBuilder.toString());

        } catch (Exception e) {
                System.err.println("An error ocurred while creating the Csv");
              }

    }
}
