package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise26 {

    public static Contact contact;
    public static String mykey;

    public static void main(String[] args) {
        ArrayList<String> phones = new ArrayList<>();
        phones.add("");
        System.out.println("********************************");
        System.out.println("*DATOS DEL PROPIETARIO DEL TELÉFONO*");
        System.out.println("********************************");
        Scanner introGen = new Scanner(System.in);
        System.out.println("Nombre: ");
        String name = introGen.nextLine();
        System.out.println("Apellidos: ");
        String surname = introGen.nextLine();
        System.out.println("Teléfono: ");
        String phone = introGen.nextLine();
        Contact i = new Contact(name, surname, phone, phones);
        mykey = i.getCode();
        Phonebook.addContact(i);
        mainMenu();
    }

    public static void mainMenu(){
        Scanner introGen = new Scanner(System.in);
        int opcListin = 1;
        while (true){
            System.out.println("1.- Añadir contacto");
            System.out.println("2.- Mostrar contactos");
            System.out.println("3.- Buscar un contacto");
            System.out.println("4.- Eliminar un contacto");
            System.out.println("5.- Salir");
            System.out.println("Opciones 1 a 5 ");
            opcListin = introGen.nextInt();
            switch (opcListin){
                case 1:
                    addContact();
                    break;
                case 2:
                    Phonebook phonebook = new Phonebook();
                    phonebook.showPhonebook();
                    break;
                case 3:
                    seekContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Error en la selección");
                    break;
            }
            if (opcListin==5){
                break;
            }
        }
    }

    public static void seekContact() {
        Scanner introGen = new Scanner(System.in);
        System.out.println("Nombre: ");
        String name = introGen.nextLine();
        System.out.println("Apellidos: ");
        String surname = introGen.nextLine();
        Contact seekContact = new Contact(name, surname);
        String key = seekContact.getCode();
        Phonebook phonebook = new Phonebook();
        Contact contact = phonebook.selectContact(key);
        if (contact!=null){
            int opcSeek = 1;
            while (true) {
                System.out.println("1.- Llamar");
                System.out.println("2.- Mostrar datos del contacto");
                System.out.println("3.- Menú anterior");
                System.out.println("Opciones 1 a 3 ");
                opcSeek = introGen.nextInt();
                switch (opcSeek) {
                    case 1:
                        if (mykey.equals(key)){
                            contact.callMyNumber();
                        }else{
                            contact.callOtherNumber(contact.getPhone());
                        }
                        break;
                    case 2:
                        contact.showContactDetails();
                        break;
                    case 3:

                        break;
                    default:
                        System.out.println("Error en la selección");
                        break;
                }
                if (opcSeek==3){
                    break;
                }
            }
        }else{
            System.out.println("El contacto no existe!!");
        }
    }

    public static void addContact(){
        Scanner introGen = new Scanner(System.in);
        contact = new Contact();
        System.out.println("Nombre: ");
        String nombre = introGen.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = introGen.nextLine();
        System.out.println("Teléfono: ");
        String telefono = introGen.nextLine();
        String yN = "S";
        ArrayList<String> phones = new ArrayList<>();
        while(true) {
            introGen = new Scanner(System.in);
            System.out.println("Quieres añadir más teléfonos:(S / N) ");
            yN = introGen.nextLine();
            if (yN.equals("S")  || yN.equals("s")){
                System.out.println("Introduce el teléfono: ");
                String phone = introGen.nextLine();
                phones.add(phone);
            }else{
                break;
            }
        }
        System.out.println();
        contact.setName(nombre);
        contact.setSurnames(apellidos);
        contact.setPhone(telefono);
        contact.setPhones(phones);
        contact.getCode();
        Phonebook.addContact(contact);
    }

    public static void deleteContact(){
        Scanner introGen = new Scanner(System.in);
        System.out.println("Nombre: ");
        String name = introGen.nextLine();
        System.out.println("Apellidos: ");
        String surname = introGen.nextLine();
        Contact seekContact = new Contact(name, surname);
        String key = seekContact.getCode();
        Phonebook phonebook = new Phonebook();
        phonebook.deleteContact(key);
    }
}
