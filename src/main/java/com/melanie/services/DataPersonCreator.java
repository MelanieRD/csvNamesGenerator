package com.melanie.services;

import com.melanie.person.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Optional;
import java.util.Scanner;

public class DataPersonCreator {
    int counterId = 0;
    private String namesSource = "src/main/resources/assets/names.json";
    private String lastNamesSource = "src/main/resources/assets/lastNames.json";
    private String countriesSource = "src/main/resources/assets/countries.json";


    public DataPersonCreator(){
    }

  public Person createDataPersonObj(){
      Person person = new Person( randomName(), randomLastName(), randomCountry(), randomPhoneNumber());
      return person;
    }


    public JSONObject getJSONData(String jsonPathURL){
        try{
            File fileObj = new File(jsonPathURL);
            Scanner reader = new Scanner(fileObj);
            StringBuilder data = new StringBuilder(); // acumula el contenido del archivo para convertirlo en una cadena.

            while(reader.hasNextLine()){
                String readerLineData = reader.nextLine();
                data.append(readerLineData);
            }
            reader.close();

            JSONObject JSONData = new JSONObject(data.toString());// Se espera un String, por eso lo converti a String, ya que era un StringBuilder
            return JSONData;
        } catch (Exception e) {
            System.err.println("An error ocurred trying to read the file "+e);
        }
        return null;
    }

        String randomName(){
        JSONObject JSONData = getJSONData(this.namesSource);
        String name ="";
        String[] gender = {"female", "male"};
        int randomNumGender = (int)Math.round(Math.random());


        try{
            JSONArray names = JSONData.getJSONArray(gender[randomNumGender]);
            name = names.getString(randomNumber(names.length()-1));
        }catch (Exception e){System.err.println("Error al obtener el nombre random"+e);}

        return name;
        }

    // Choosing a LastName
    String randomLastName(){
        JSONObject JSONData = getJSONData(this.lastNamesSource);
        String lastName ="";
        try{
            JSONArray lastNames = JSONData.getJSONArray("lastnames");
            lastName = lastNames.getString(randomNumber(lastNames.length()-1));
            return lastName;
        }catch (Exception e){System.err.println("Error trying to obtain a random Lastname"+e);}

        return lastName;
    }

    //Choosing a country
    String randomCountry(){
        JSONObject JSONData = getJSONData(this.countriesSource);
        String country ="";

        try {
            JSONArray countries = JSONData.getJSONArray("countries");
            country = countries.getString(randomNumber(countries.length()-1));
            return country;
        } catch (Exception e) {
            System.err.println("Error trying to get a random country "+e);
        }
        return  country;
    }

    // PhoneNumber Generator

    String randomPhoneNumber(){
        String randomPNumber = "";
        int minNum = 0;
        int maxNum = 9;
        int counter = 9;
        try {

            while(counter >= 0){

                if(counter == 3 | counter == 6 ) {
                    randomPNumber = randomPNumber+"-";
                }
                    String number = String.valueOf(Math.round(Math.random() * (maxNum - minNum) + minNum));
                    randomPNumber = randomPNumber+ number;
                counter--;
            }

        } catch (Exception e) {
            System.err.println("An error has ocurred trying to create a phoneNumber");
        }

        return randomPNumber;
    }


   int randomNumber(int nameListLength){
        return (int) Math.round(Math.random() * nameListLength);
    }


}
