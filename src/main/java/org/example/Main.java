package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        Person secondPerson = new Person("Petras",44,"petras.petraitis@gmail.com");
        File fileTwo = new File("src/main/java/org/example/jsonProperty.json");

        mapper.writeValue(fileTwo,secondPerson);
        String secondPersonInString = mapper.writeValueAsString(secondPerson);
        System.out.println(secondPersonInString);

        List<Person> zmones = new ArrayList<>();
        zmones.add(person);
        zmones.add(secondPerson);

//        String personsListInString = mapper.writeValueAsString(zmones);
//        pagal skaidres serializavimas jau yra su irasymu i faila.

        File fileThree = new File("src/main/java/org/example/persons.json");
        mapper.writeValue(fileThree,zmones);

        System.out.println(mapper.readValue(fileThree, new TypeReference<List<Person>>(){}));
        List<Person> zmonesIsJson = mapper.readValue(fileThree, new TypeReference<List<Person>>(){});
        System.out.println(zmonesIsJson);
        System.out.println(zmones.equals(zmonesIsJson));
    }
}