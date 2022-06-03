package com.project.musicStats.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ifamily")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class IFamily implements Serializable {

    @Id
    @Range(min = 1, max = 16)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Getter
    @Setter
    private Integer idfamily;

    @Length(max = 20)
    @NotNull
    @Getter
    @Setter
    private String name;

}
