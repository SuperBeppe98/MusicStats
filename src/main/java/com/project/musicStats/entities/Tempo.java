package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tempo")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "tempo")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Tempo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idTempo;

    @NotNull
    @Getter
    @Setter
    private Integer absoluteTime;

    @NotNull
    @Getter
    @Setter
    private Integer numerator;

    @NotNull
    @Getter
    @Setter
    private Integer denominator;

    @ManyToOne
    @JoinColumn(name = "track_idtrack", foreignKey = @ForeignKey(name = "Fk_track_idtrack"))
    @NotNull
    @Getter
    @Setter
    private Track track_idtrack;

}
