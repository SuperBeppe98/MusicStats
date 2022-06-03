package com.project.musicStats.entities;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "instrument")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Instrument implements Serializable {

    @Id
    @Range(min = 1, max = 128)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Getter
    @Setter
    private Integer idinstrument;

    @Length(max = 23)
    @NotNull
    @Getter
    @Setter
    private String name;

    @ManyToOne
    @JoinColumn(name = "ifamilies_idfamily", foreignKey = @ForeignKey(name = "Fk_ifamilies_idfamily"))
    @NotNull
    @Getter
    @Setter
    private IFamily ifamilies_idfamily;

}