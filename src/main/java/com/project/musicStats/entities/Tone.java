package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tone")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "tone")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Tone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idtone;

    @NotNull
    @Getter
    @Setter
    private String value;
}

