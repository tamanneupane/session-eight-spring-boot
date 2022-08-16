package com.squareflakes.training.model;

import lombok.*;

@NoArgsConstructor
public class PersonalDetail {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String cvURL;

    @Getter
    @Setter
    private String image;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String yearsOfExperience;

    @Override
    public String toString() {
        return "PersonalDetail{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", cvURL='" + cvURL + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
