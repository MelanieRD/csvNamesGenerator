package com.melanie.services;

import java.io.File;
import java.io.FileWriter;

public class FileHandler {


    private String fileName = "myCsvFile.csv";
    private File fileObj = new File(fileName);


  public FileHandler(){}

    public void createFile(){
        try{
            if(!fileObj.exists()){
                Boolean filedCreated =  fileObj.createNewFile();
                System.out.println("File created sucessfully");
            } else { System.out.println("The file already exits<3");}
        } catch (Exception e) {
            System.err.println("an error ocurred while creating the file."+e);
        }
    }

    public void writeRecordToFile(String recordData){
      try(FileWriter fileWriter = new FileWriter(this.fileName)){
          createFile();
        fileWriter.write(recordData);
        fileWriter.close();
        System.out.println("Succesfully wrote in to the file");
      }catch(Exception e){
          System.err.println("An error ocurred trying to write in to the file"+ e);
      }
    }

    public void readFile(){}



}
