package de.it4ipm.mymapstruct.service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    public String enrichName(String name) {
        return "-:: " + name + " ::-";
    }
}
