package org.acme.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "T_PERSON")
public class Person extends PanacheEntityBase {
    @Id
    @Column(name="Mote")
    public String mote;

    @Column(name="Nombre")
    public String name;
    
    @Column(name="Apellido")
    public String surname;

    @Column(name="Edad")
    public int edad;
    
    

    public Person() {
    }

    public Person(String mote, String name, String surname, int edad) {
        this.mote = mote;
        this.name = name;
        this.surname = surname;
        this.edad = edad;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void avanzarEdad(){
        setEdad(getEdad() + 1);
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getSurname() + " " + this.getMote();
    }

}
