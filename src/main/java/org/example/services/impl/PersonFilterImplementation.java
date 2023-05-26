package org.example.services.impl;

import org.example.model.Person;
import org.example.services.PersonFilter;
import org.example.model.UKGvalues;

//Bienvenidos al code challenge nivel facil UKG
//En UKG estamos buscando a los mejores astronautas, para eso, necesitamos implmenetar
//un filtro con unos requisitos minimos para poder ser nuestro astronauta estrella
//REGLAS:
//  1- Cada astronauta debe tener al menos 3 attitudes definidas en el enum UKGValues
//  2- Cada astronauta debe ser KIND
//  3- Cada astronauta debe ser RESPECTFUL
public class PersonFilterImplementation implements PersonFilter {
    @Override
    public Boolean filterPersonByAttitudes(Person person) {
        //TODO()
    }

    private static boolean UKGValuesContainsAttitude(UKGvalues attitude) {
        for (UKGvalues attitudeEnum : UKGvalues.values()) {
            if (attitudeEnum.equals(attitude)) {
                return true;
            }
        }
        return false;
    }
}
