package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "keytone")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "keytone")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class KeyTone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idKeyTone;

    @NotNull
    @Getter
    @Setter
    private Integer absoluteTime;

    @ManyToOne
    @JoinColumn(name = "mode_idmode", foreignKey = @ForeignKey(name = "Fk_mode_idmode"))
    @NotNull
    @Getter
    @Setter
    private Mode mode;

    @ManyToOne
    @JoinColumn(name = "tone_idtone", foreignKey = @ForeignKey(name = "Fk_tone_idtone"))
    @NotNull
    @Getter
    @Setter
    private Tone tone;

    @ManyToOne
    @JoinColumn(name = "track_idtrack", foreignKey = @ForeignKey(name = "Fk_track_idtrack"))
    @NotNull
    @Getter
    @Setter
    private Track track_idtrack;

}
