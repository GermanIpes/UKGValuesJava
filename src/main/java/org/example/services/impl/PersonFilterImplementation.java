package org.example.services.impl;

import org.example.model.Person;
import org.example.services.PersonFilter;
import org.example.model.UKGvalues;

import java.util.concurrent.atomic.AtomicInteger;

//Welcome to our Code challenge level: Easy
//In this exercise you have to implement the filterPersonByAttitudes to validate if a person is Kind, Respectful and
//in total have at least 3 attitudes (Kind and respectful attitudes count too)

//Tip #1: You can inspect the model of the object Person and the UKG values in the model folder
//Tip #2: You could use the function enumContains which is on EnumExtensions in the extensions folder
//Tip #3: In services/exceptions you should find the EmptyPersonAttitudesException
//        and PersonWithoutFundamentalAttitudeException class

public class PersonFilterImplementation implements PersonFilter {
    @Override
    public Boolean filterPersonByAttitudes(Person person) {
        if (person.personValues.isEmpty()){
            return false;
        } else if (!person.personValues.contains(UKGvalues.KIND)) {
            return false;
        } else if (!person.personValues.contains(UKGvalues.RESPECTFUL)) {
            return false;
        } else {
            AtomicInteger attitudesCount = new AtomicInteger();
            person.personValues.forEach(attitude -> {
                if (UKGValuesContainsAttitude(attitude)){
                    attitudesCount.getAndIncrement();
                }
            });
            return attitudesCount.get() >= 3;
        }
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
