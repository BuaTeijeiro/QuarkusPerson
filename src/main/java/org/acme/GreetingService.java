package org.acme;

import java.util.List;
import java.util.Optional;

import org.acme.dominio.Person;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public GreetingService(){}

    public String nombrePersona(String mote){
        Optional<Person> persona = Person.findByIdOptional(mote);
        return persona.isPresent()? persona.get().getName(): "No existe esta persona";
    }

    public Person getPersona(String mote){
        Optional<Person> persona = Person.findByIdOptional(mote);
        return persona.isPresent()? persona.get(): new Person();
    }

    public List<Person> todos(){
        return Person.listAll();
    }

}
