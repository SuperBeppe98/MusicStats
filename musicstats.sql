-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 06, 2018 alle 14:25
-- Versione del server: 10.1.26-MariaDB
-- Versione PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musicstats`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `effect`
--

CREATE TABLE `effect` (
  `ideffect` int(11) NOT NULL,
  `purpose` varchar(127) NOT NULL,
  `description` varchar(127) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `ifamilies`
--

CREATE TABLE `ifamilies` (
  `idfamily` int(11) NOT NULL,
  `name` varchar(127) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `instrument`
--

CREATE TABLE `instrument` (
  `idinstrument` int(11) NOT NULL,
  `name` varchar(127) NOT NULL,
  `ifamilies_idfamily` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `keytone`
--

CREATE TABLE `keytone` (
  `idkey` int(11) NOT NULL,
  `tone` enum('-7','-6','-5','-4','-3','-2','-1','0','1','2','3','4','5','6','7') DEFAULT NULL,
  `modality` enum('Major','Minor') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `midi`
--

CREATE TABLE `midi` (
  `idmidi` int(11) NOT NULL,
  `name` varchar(127) NOT NULL,
  `tracks` int(11) NOT NULL,
  `bpm` int(11) NOT NULL,
  `tempo_numerator` int(11) NOT NULL,
  `tempo_denominator` int(11) NOT NULL,
  `totrows` int(11) NOT NULL,
  `nonstatrows` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `note`
--

CREATE TABLE `note` (
  `idnote` int(11) NOT NULL,
  `value` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `title`
--

CREATE TABLE `title` (
  `idtitle` int(11) NOT NULL,
  `content` varchar(127) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `track`
--

CREATE TABLE `track` (
  `idtrack` int(11) NOT NULL,
  `instrument_idinstrument` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `trackeffect`
--

CREATE TABLE `trackeffect` (
  `effect_ideffect` int(11) NOT NULL,
  `track_idtrack` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `trackkey`
--

CREATE TABLE `trackkey` (
  `keytone_idkey` int(11) NOT NULL,
  `track_idtrack` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `trackmidi`
--

CREATE TABLE `trackmidi` (
  `midi_idmidi` int(11) NOT NULL,
  `track_idtrack` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `tracknote`
--

CREATE TABLE `tracknote` (
  `track_idtrack` int(11) NOT NULL,
  `note_idnote` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `tracktitle`
--

CREATE TABLE `tracktitle` (
  `track_idtrack` int(11) NOT NULL,
  `title_idtitle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `effect`
--
ALTER TABLE `effect`
  ADD PRIMARY KEY (`ideffect`);

--
-- Indici per le tabelle `ifamilies`
--
ALTER TABLE `ifamilies`
  ADD PRIMARY KEY (`idfamily`);

--
-- Indici per le tabelle `instrument`
--
ALTER TABLE `instrument`
  ADD PRIMARY KEY (`idinstrument`),
  ADD KEY `instrument_ifamilies_fk` (`ifamilies_idfamily`);

--
-- Indici per le tabelle `keytone`
--
ALTER TABLE `keytone`
  ADD PRIMARY KEY (`idkey`);

--
-- Indici per le tabelle `midi`
--
ALTER TABLE `midi`
  ADD PRIMARY KEY (`idmidi`);

--
-- Indici per le tabelle `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`idnote`);

--
-- Indici per le tabelle `title`
--
ALTER TABLE `title`
  ADD PRIMARY KEY (`idtitle`);

--
-- Indici per le tabelle `track`
--
ALTER TABLE `track`
  ADD PRIMARY KEY (`idtrack`),
  ADD KEY `track_instrument_fk` (`instrument_idinstrument`);

--
-- Indici per le tabelle `trackeffect`
--
ALTER TABLE `trackeffect`
  ADD PRIMARY KEY (`effect_ideffect`,`track_idtrack`),
  ADD KEY `trackeffect_track_fk` (`track_idtrack`);

--
-- Indici per le tabelle `trackkey`
--
ALTER TABLE `trackkey`
  ADD PRIMARY KEY (`keytone_idkey`,`track_idtrack`),
  ADD KEY `trackkey_track_fk` (`track_idtrack`);

--
-- Indici per le tabelle `trackmidi`
--
ALTER TABLE `trackmidi`
  ADD PRIMARY KEY (`midi_idmidi`,`track_idtrack`),
  ADD KEY `trackmidi_track_fk` (`track_idtrack`);

--
-- Indici per le tabelle `tracknote`
--
ALTER TABLE `tracknote`
  ADD PRIMARY KEY (`track_idtrack`,`note_idnote`),
  ADD KEY `tracknote_note_fk` (`note_idnote`);

--
-- Indici per le tabelle `tracktitle`
--
ALTER TABLE `tracktitle`
  ADD PRIMARY KEY (`track_idtrack`,`title_idtitle`),
  ADD KEY `tracktitle_title_fk` (`title_idtitle`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `effect`
--
ALTER TABLE `effect`
  MODIFY `ideffect` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `ifamilies`
--
ALTER TABLE `ifamilies`
  MODIFY `idfamily` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `instrument`
--
ALTER TABLE `instrument`
  MODIFY `idinstrument` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `keytone`
--
ALTER TABLE `keytone`
  MODIFY `idkey` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `midi`
--
ALTER TABLE `midi`
  MODIFY `idmidi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `note`
--
ALTER TABLE `note`
  MODIFY `idnote` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `title`
--
ALTER TABLE `title`
  MODIFY `idtitle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `track`
--
ALTER TABLE `track`
  MODIFY `idtrack` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `instrument`
--
ALTER TABLE `instrument`
  ADD CONSTRAINT `instrument_ifamilies_fk` FOREIGN KEY (`ifamilies_idfamily`) REFERENCES `ifamilies` (`idfamily`) ON DELETE CASCADE;

--
-- Limiti per la tabella `track`
--
ALTER TABLE `track`
  ADD CONSTRAINT `track_instrument_fk` FOREIGN KEY (`instrument_idinstrument`) REFERENCES `instrument` (`idinstrument`) ON DELETE CASCADE;

--
-- Limiti per la tabella `trackeffect`
--
ALTER TABLE `trackeffect`
  ADD CONSTRAINT `trackeffect_effect_fk` FOREIGN KEY (`effect_ideffect`) REFERENCES `effect` (`ideffect`) ON DELETE CASCADE,
  ADD CONSTRAINT `trackeffect_track_fk` FOREIGN KEY (`track_idtrack`) REFERENCES `track` (`idtrack`) ON DELETE CASCADE;

--
-- Limiti per la tabella `trackkey`
--
ALTER TABLE `trackkey`
  ADD CONSTRAINT `trackkey_key_fk` FOREIGN KEY (`keytone_idkey`) REFERENCES `keytone` (`idkey`),
  ADD CONSTRAINT `trackkey_track_fk` FOREIGN KEY (`track_idtrack`) REFERENCES `track` (`idtrack`) ON DELETE CASCADE;

--
-- Limiti per la tabella `trackmidi`
--
ALTER TABLE `trackmidi`
  ADD CONSTRAINT `trackmidi_midi_fk` FOREIGN KEY (`midi_idmidi`) REFERENCES `midi` (`idmidi`) ON DELETE CASCADE,
  ADD CONSTRAINT `trackmidi_track_fk` FOREIGN KEY (`track_idtrack`) REFERENCES `track` (`idtrack`) ON DELETE CASCADE;

--
-- Limiti per la tabella `tracknote`
--
ALTER TABLE `tracknote`
  ADD CONSTRAINT `tracknote_note_fk` FOREIGN KEY (`note_idnote`) REFERENCES `note` (`idnote`) ON DELETE CASCADE,
  ADD CONSTRAINT `tracknote_track_fk` FOREIGN KEY (`track_idtrack`) REFERENCES `track` (`idtrack`) ON DELETE CASCADE;

--
-- Limiti per la tabella `tracktitle`
--
ALTER TABLE `tracktitle`
  ADD CONSTRAINT `tracktitle_title_fk` FOREIGN KEY (`title_idtitle`) REFERENCES `title` (`idtitle`) ON DELETE CASCADE,
  ADD CONSTRAINT `tracktitle_track_fk` FOREIGN KEY (`track_idtrack`) REFERENCES `track` (`idtrack`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
