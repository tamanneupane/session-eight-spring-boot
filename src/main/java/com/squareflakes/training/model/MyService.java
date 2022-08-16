package com.squareflakes.training.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "service")
public class MyService {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "icon", length = 50)
    private String icon;

    @Getter
    @Setter
    @Column(name = "title")
    private String title;

    @Getter
    @Setter
    @Column(name = "description", length = 500)
    private String description;

    public MyService(String icon, String title, String description) {
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "MyService{" +
                "icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
