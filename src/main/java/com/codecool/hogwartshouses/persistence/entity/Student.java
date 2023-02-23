package com.codecool.hogwartshouses.persistence.entity;

import com.codecool.hogwartshouses.data.Pet;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Pet pet;
}
