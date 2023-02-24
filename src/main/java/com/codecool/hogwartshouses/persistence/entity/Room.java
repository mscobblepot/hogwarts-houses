package com.codecool.hogwartshouses.persistence.entity;

import com.codecool.hogwartshouses.data.House;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Room {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(value = EnumType.STRING)
    private House house;
    @OneToOne
    private Student student;

    public Room(House house, Student student) {
        this.house = house;
        this.student = student;
    }
}
