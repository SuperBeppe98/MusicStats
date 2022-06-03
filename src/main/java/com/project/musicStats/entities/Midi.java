package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "midi")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "midi")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Midi implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idmidi;

    @NotNull
    @Getter
    @Setter
    private String name;

    @NotNull
    @Getter
    @Setter
    private Integer tracks;

    @NotNull
    @Getter
    @Setter
    private Integer totrows;

    @NotNull
    @Getter
    @Setter
    private Integer nonstatrows;

}

