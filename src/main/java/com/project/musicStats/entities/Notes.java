package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "notes")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "notes")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Notes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idnotes;

    @NotNull
    @Getter
    @Setter
    private String value;

}

