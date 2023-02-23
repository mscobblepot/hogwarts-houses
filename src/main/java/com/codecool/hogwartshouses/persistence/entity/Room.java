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
public class Room {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(value = EnumType.STRING)
    private House house;
    @OneToOne
    private Student student;
}
