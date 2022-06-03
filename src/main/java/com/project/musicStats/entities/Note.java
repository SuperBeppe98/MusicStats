package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "note")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "note")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idNote;

    @NotNull
    @Getter
    @Setter
    private Integer absoluteTime;

    @ManyToOne
    @JoinColumn(name = "notes_idnotes", foreignKey = @ForeignKey(name = "Fk_notes_idnotes"))
    @NotNull
    @Getter
    @Setter
    private Notes Note;

    @ManyToOne
    @JoinColumn(name = "track_idtrack", foreignKey = @ForeignKey(name = "Fk_track_idtrack"))
    @NotNull
    @Getter
    @Setter
    private Track track_idtrack;

}
