package com.campusdual.classroom;

import java.util.*;

public class Phonebook {

    public static Map<String, Contact> mapContacts = new HashMap<>();

    public static Map<String, Contact> addContact(Contact contact){
        mapContacts.put(contact.getCode(), contact);
        Map<String, Contact> contacts = new HashMap<>();
        return getData();
    }

    public static Map<String, Contact> getData(){
        return mapContacts;
    }

    public Map<String, Contact> showPhonebook(){
        for(Map.Entry<String, Contact> dato : mapContacts.entrySet()){
            dato.getValue().showContactDetails();
            dato.getValue().showPhones();
        }
        return mapContacts;
    }

    public Contact selectContact(String key){
         return mapContacts.get(key);
    }

    public void deleteContact(String key){
        mapContacts.remove(key);
    }
}
