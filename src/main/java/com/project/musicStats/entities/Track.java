package com.project.musicStats.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "track")
@TableGenerator(name = "generator", table = "sequence", pkColumnValue = "track")
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Track implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
    @NotNull
    @Getter
    @Setter
    private Integer idtrack;

    @NotNull
    @Getter
    @Setter
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "instrument_idinstrument", foreignKey = @ForeignKey(name = "Fk_instrument_idinstrument"))
    @Getter
    @Setter
    private Instrument instrument_idinstrument;

    @ManyToOne
    @JoinColumn(name = "midi_idmidi", foreignKey = @ForeignKey(name = "Fk_midi_idmidi"))
    @NotNull
    @Getter
    @Setter
    private Midi midi_idmidi;

}