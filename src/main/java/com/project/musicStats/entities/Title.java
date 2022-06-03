package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "title")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "title")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Title implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idtitle;

    @NotNull
    @Getter
    @Setter
    private String content;

    @ManyToOne
    @JoinColumn(name = "track_idtrack", foreignKey = @ForeignKey(name = "Fk_track_idtrack"))
    @NotNull
    @Getter
    @Setter
    private Track track_idtrack;

}

