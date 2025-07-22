package com.likelion.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Seoah";
    private final Lion lion;

    @Autowired
    public Person(Lion lion) {
        this.lion = lion;
    }

    public Lion getLion() {
        return lion;
    }

    /* public void setLion(Lion lion) {
        this.lion = lion;
    } */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
