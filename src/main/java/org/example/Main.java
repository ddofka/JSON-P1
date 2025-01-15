package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Person person = new Person("Jonas",30,"jonas.jonaitis@gmail.com");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("src/main/java/org/example/rezultatas.json");
        mapper.writeValue(file, person);

        Person personFromJSON = mapper.readValue(file, Person.class);
        System.out.println(personFromJSON);
        System.out.println(person);
    }
}