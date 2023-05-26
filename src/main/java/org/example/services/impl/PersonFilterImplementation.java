package org.example.services.impl;

import org.example.model.Person;
import org.example.services.PersonFilter;
import org.example.model.UKGvalues;

//Bienvenidos al code challenge nivel facil UKG
//Deben implementar un filtro para poder ser empleado de UKG:
//REGLAS:
//  1- Cada empleado debe tener al menos 3 attitudes definidas en el enum UKGValues
//  2- Cada empleado debe ser KIND
//  3- Cada empleado debe ser RESPECTFUL
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
