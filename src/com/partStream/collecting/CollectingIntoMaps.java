package com.partStream.collecting;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author: Sean
 * Date: Created In 11:39 2019/4/2
 * Title: 收集流到映射表中
 * Description:
 * Version: 0.1
 * Update History:
 * [Date][Version][Author] What has been done;
 */

public class CollectingIntoMaps {
    public static class Person{
        private int id;
        private String name;

        public Person(int id, String name){
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public String toString(){
            return getClass().getName() + "[id=" + id + ", name=" + name+"]";
        }
    }

    public static Stream<Person> people(){
        return Stream.of(new Person(1001, "Peter"),
                new Person(1002, "Paul"), new Person(1003, "Mary"));
    }

    public static void main(String[] args) throws IOException{

        Map<Integer, String> idToName = people().collect(
                Collectors.toMap(
                        Person::getId,
                        Person::getName
                )
        );
        System.out.println("idToName: "+ idToName);
        Map<Integer, Person> idToPerson = people().collect(
                Collectors.toMap(
                        Person::getId,
                        Function.identity()));
        System.out.println("idToPerson: " + idToPerson.getClass().getName()+idToPerson);

        idToPerson = people().collect(
                Collectors.toMap(
                        Person::getId,
                        Function.identity(),
                        (ov, nv)->{throw new IllegalStateException();},
                        TreeMap::new
                )
        );
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);

        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = localeStream.collect(
                Collectors.toMap(
                        Locale::getDisplayName,
                        l->l.getDisplayName(l),
                        (ov, nv)->{throw new IllegalStateException();}
                )
        );
        System.out.println("languageNames: " + languageNames);


    }
}
