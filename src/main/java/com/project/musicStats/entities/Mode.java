package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "mode")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "mode")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Mode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idmode;

    @NotNull
    @Getter
    @Setter
    private String value;


}

