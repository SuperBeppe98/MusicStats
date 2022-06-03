package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "bpm")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "bpm")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Bpm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idBpm;

    @NotNull
    @Getter
    @Setter
    private Integer absoluteTime;

    @NotNull
    @Getter
    @Setter
    private Integer bpm;

    @ManyToOne
    @JoinColumn(name = "track_idtrack", foreignKey = @ForeignKey(name = "Fk_track_idtrack"))
    @NotNull
    @Getter
    @Setter
    private Track track_idtrack;

}
