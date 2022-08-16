package com.squareflakes.training.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class MySkill {

    @Getter
    @Setter
    private String skillName;

    @Getter
    @Setter
    private String skillPercentage;
}
