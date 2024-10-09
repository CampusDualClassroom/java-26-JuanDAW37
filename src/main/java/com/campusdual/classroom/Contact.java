package com.campusdual.classroom;

import java.sql.Struct;
import java.text.Normalizer;
import java.util.ArrayList;

public class Contact implements ICallActions{

    private String name;
    private String surname;
    private String phone;
    private String code;
    private ArrayList<String> phones = new ArrayList<>();

    public Contact(String name, String surname, String phone, ArrayList<String> phones){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.phones = phones;
    }

    public Contact(String name, String surname, String phone){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Contact(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Contact(){}

    @Override
    public void callMyNumber() {
        System.out.println("Hola " + this.getName() + " " + this.getSurnames() + " te estás llamando a tí mismo desde tú teléfono nº: " + this.getPhone());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando a  " + this.getName() + " " + this.getSurnames() + " con teléfono nº: " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Nombre: " + this.getName() + " Apellidos: " + this.getSurnames() + "  Teléfono: " + this.getPhone() + " Código: " + this.getCode());
    }

    public void showPhones(){
        if (this.phones.size()>0) {
            System.out.println("Lista de teléfonos del contacto:");
            for (String phone : this.phones) {
                System.out.println(phone);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        String n = this.getName().toLowerCase();
        String a;
        int espacios = 0;
        for(char e : this.getSurnames().toCharArray()){
            if (e == ' '){
                espacios++;
            }
        }
        if(espacios==0){
            a = this.getSurnames().toLowerCase();
        }else{
            String apellido2="";
            String apellido1 = Character.toString(this.getSurnames().toLowerCase().charAt(0));
            apellido2 += this.getSurnames().substring(this.getSurnames().indexOf(" "));
            a = apellido1+apellido2.replace(" ", "").toLowerCase();
        }
        n = Character.toString(n.charAt(0));
        String data = n + a;
        String stringNormalize = Normalizer.normalize(data, Normalizer.Form.NFD);
        this.setCode(stringNormalize.replaceAll("[^\\p{ASCII}]", ""));
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSurnames() {
        return this.surname;
    }

    public void setSurnames(String surname) {
        this.surname = surname;
    }

    public void setPhones(ArrayList<String> phones){
        this.phones = phones;
    }
}
