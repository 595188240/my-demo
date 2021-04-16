package com.my.demo.decorator;

/**
 * Date        Author        Version        Comments
 * 2021/4/16     ffdeng         1.0       Initial Version
 **/
public class Finery extends Person {

    private Person person;

    public void Decorate(Person person) {
        this.person = person;
    }

    @Override
    public void Show() {
        if (person != null) {
            person.Show();
        }
    }
}
