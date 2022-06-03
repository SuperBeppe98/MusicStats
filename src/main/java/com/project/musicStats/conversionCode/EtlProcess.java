package com.project.musicStats.conversionCode;

import com.project.musicStats.daos.*;
import com.project.musicStats.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtlProcess {

    @Autowired
    MidiDao midiDao;

    @Autowired
    NoteDao noteDao;

    @Autowired
    TrackDao trackDao;

    @Autowired
    InstrumentDao instrumentDao;

    @Autowired
    TitleDao titleDao;

    @Autowired
    BpmDao bpmDao;

    @Autowired
    TempoDao tempoDao;

    @Autowired
    KeyToneDao keyToneDao;

    @Autowired
    ModeDao modeDao;

    @Autowired
    ToneDao toneDao;

    @Autowired
    NotesDao notesDao;

    public void saveFile(InputStream uploadedInputStream, String uploadedFileLocation) throws IOException {
        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
        while ((read = uploadedInputStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

    public void addfile(String filename) throws IOException, InterruptedException {
        Integer tracks = 0, countTotRows = 0, countNotStatRows = 0;
        ArrayList<Integer> bpmAboutTrack = new ArrayList<>();
        ArrayList<Integer> absoluteTimeAboutBpm = new ArrayList<>();
        ArrayList<Integer> absoluteTimeAboutKeyTone = new ArrayList<>();
        ArrayList<Integer> trackAboutBpm = new ArrayList<>();
        ArrayList<Integer> trackAboutKeyTone = new ArrayList<>();
        ArrayList<Integer> absoluteTimeAboutTimeSignature = new ArrayList<>();
        ArrayList<Integer> trackAboutInstrument = new ArrayList<>();
        ArrayList<Integer> trackAboutTimeSignature = new ArrayList<>();
        ArrayList<Integer> numeratorAboutTrack = new ArrayList<>();
        ArrayList<Integer> denominatorAboutTrack = new ArrayList<>();
        ArrayList<Integer> instrumentAboutTrack = new ArrayList<>();
        ArrayList<Integer> trackAboutNote = new ArrayList<>();
        ArrayList<String> noteAboutTrack = new ArrayList<>();
        ArrayList<Integer> absoluteTimeAboutNote = new ArrayList<>();
        ArrayList<Integer> trackAboutTitle = new ArrayList<>();
        ArrayList<String> toneTrack = new ArrayList<>();
        ArrayList<String> modeTrack = new ArrayList<>();
        ArrayList<String> titleAboutTrack = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();
        String path = new File(classLoader.getResource("music").getFile()).getPath();
        String inputFile = path + "\\input\\" + filename;
        String outputFile = path + "\\output\\" + filename.substring(0, filename.lastIndexOf(".")).concat(".csv");
        new ProcessBuilder(path + "\\conversionExe\\midicsv.exe", inputFile, outputFile).start().waitFor();
        new File(inputFile).delete();
        File file = new File(outputFile);
        BufferedReader bufferedReaderEtl = new BufferedReader(new FileReader(file));
        String row = bufferedReaderEtl.readLine();

        while ((row != "") && (row != null)) {
            String[] vector = row.split(",");

            if (vector[0].equals("0") && (vector[2].trim().equals("Header"))) {
                tracks = Integer.parseInt(vector[4].trim());

            } else if (vector[2].trim().equals("Time_signature")) {
                trackAboutTimeSignature.add(Integer.parseInt(vector[0].trim()));
                absoluteTimeAboutTimeSignature.add(Integer.parseInt(vector[1].trim()));
                numeratorAboutTrack.add(Integer.parseInt(vector[3].trim()));
                denominatorAboutTrack.add((int) Math.pow(2, Integer.parseInt(vector[4].trim())));

            } else if (vector[2].trim().equals("Key_signature")) {
                trackAboutKeyTone.add(Integer.parseInt(vector[0].trim()));
                absoluteTimeAboutKeyTone.add(Integer.parseInt(vector[1].trim()));
                if (vector[4].substring(1, vector[4].length() - 1).equals("major")) {
                    modeTrack.add("MAJOR");
                } else {
                    modeTrack.add("MINOR");
                }

                Integer tone_temp = Integer.parseInt(vector[3].trim());
                if (tone_temp == (-7)) {
                    toneTrack.add("SHARP7");
                } else if (tone_temp == (-6)) {
                    toneTrack.add("SHARP6");
                } else if (tone_temp == (-5)) {
                    toneTrack.add("SHARP5");
                } else if (tone_temp == (-4)) {
                    toneTrack.add("SHARP4");
                } else if (tone_temp == (-3)) {
                    toneTrack.add("SHARP3");
                } else if (tone_temp == (-2)) {
                    toneTrack.add("SHARP2");
                } else if (tone_temp == (-1)) {
                    toneTrack.add("SHARP1");
                } else if (tone_temp == (1)) {
                    toneTrack.add("FLAT1");
                } else if (tone_temp == (2)) {
                    toneTrack.add("FLAT2");
                } else if (tone_temp == (3)) {
                    toneTrack.add("FLAT3");
                } else if (tone_temp == (4)) {
                    toneTrack.add("FLAT4");
                } else if (tone_temp == (5)) {
                    toneTrack.add("FLAT5");
                } else if (tone_temp == (6)) {
                    toneTrack.add("FLAT6");
                } else if (tone_temp == (7)) {
                    toneTrack.add("FLAT7");
                } else {
                    toneTrack.add("ZERO");
                }

            } else if (vector[2].trim().equals("Tempo")) {
                trackAboutBpm.add(Integer.parseInt(vector[0].trim()));
                bpmAboutTrack.add((Integer.parseInt(vector[3].trim()) * 120) / 500000);
                absoluteTimeAboutBpm.add(Integer.parseInt(vector[1].trim()));

            } else if (vector[2].trim().equals("Title_t")) {
                trackAboutTitle.add(Integer.parseInt(vector[0].trim()));
                titleAboutTrack.add(vector[3].trim());

            } else if (vector[2].trim().equals("Program_c")) {
                trackAboutInstrument.add(Integer.parseInt(vector[0].trim()));
                instrumentAboutTrack.add(Integer.parseInt(vector[4].trim()) + 1);

            } else if (vector[2].trim().equals("Note_on_c")) {
                trackAboutNote.add(Integer.parseInt(vector[0].trim()));
                absoluteTimeAboutNote.add(Integer.parseInt(vector[1].trim()));
                Integer note_tempo = Integer.parseInt(vector[4].trim());
                if (note_tempo == (0) || note_tempo == (12) ||
                        note_tempo == (24) || note_tempo == (36) ||
                        note_tempo == (48) || note_tempo == (60) ||
                        note_tempo == (72) || note_tempo == (84) ||
                        note_tempo == (96) || note_tempo == (108) ||
                        note_tempo == (120)) {
                    noteAboutTrack.add("DO");
                } else if (note_tempo == (1) || note_tempo == (13) ||
                        note_tempo == (25) || note_tempo == (37) ||
                        note_tempo == (49) || note_tempo == (61) ||
                        note_tempo == (73) || note_tempo == (85) ||
                        note_tempo == (97) || note_tempo == (109) ||
                        note_tempo == (121)) {
                    noteAboutTrack.add("DOdReb");
                } else if (note_tempo == (2) || note_tempo == (14) ||
                        note_tempo == (26) || note_tempo == (38) ||
                        note_tempo == (50) || note_tempo == (62) ||
                        note_tempo == (74) || note_tempo == (86) ||
                        note_tempo == (98) || note_tempo == (110) ||
                        note_tempo == (122)) {
                    noteAboutTrack.add("RE");
                } else if (note_tempo == (3) || note_tempo == (15) ||
                        note_tempo == (27) || note_tempo == (39) ||
                        note_tempo == (51) || note_tempo == (63) ||
                        note_tempo == (75) || note_tempo == (87) ||
                        note_tempo == (99) || note_tempo == (111) ||
                        note_tempo == (123)) {
                    noteAboutTrack.add("RedMIb");
                } else if (note_tempo == (4) || note_tempo == (16) ||
                        note_tempo == (28) || note_tempo == (40) ||
                        note_tempo == (52) || note_tempo == (64) ||
                        note_tempo == (76) || note_tempo == (88) ||
                        note_tempo == (100) || note_tempo == (112) ||
                        note_tempo == (124)) {
                    noteAboutTrack.add("MI");
                } else if (note_tempo == (5) || note_tempo == (17) ||
                        note_tempo == (29) || note_tempo == (41) ||
                        note_tempo == (53) || note_tempo == (65) ||
                        note_tempo == (77) || note_tempo == (89) ||
                        note_tempo == (101) || note_tempo == (113) ||
                        note_tempo == (125)) {
                    noteAboutTrack.add("FA");
                } else if (note_tempo == (6) || note_tempo == (18) ||
                        note_tempo == (30) || note_tempo == (42) ||
                        note_tempo == (54) || note_tempo == (66) ||
                        note_tempo == (78) || note_tempo == (90) ||
                        note_tempo == (102) || note_tempo == (114) ||
                        note_tempo == (126)) {
                    noteAboutTrack.add("FAdSOLb");
                } else if (note_tempo == (7) || note_tempo == (19) ||
                        note_tempo == (31) || note_tempo == (43) ||
                        note_tempo == (55) || note_tempo == (67) ||
                        note_tempo == (79) || note_tempo == (91) ||
                        note_tempo == (103) || note_tempo == (115) ||
                        note_tempo == (127)) {
                    noteAboutTrack.add("SOL");
                } else if (note_tempo == (8) || note_tempo == (20) ||
                        note_tempo == (32) || note_tempo == (44) ||
                        note_tempo == (56) || note_tempo == (68) ||
                        note_tempo == (80) || note_tempo == (92) ||
                        note_tempo == (104) || note_tempo == (116) ||
                        note_tempo == (128)) {
                    noteAboutTrack.add("SOLdLAb");
                } else if (note_tempo == (9) || note_tempo == (21) ||
                        note_tempo == (33) || note_tempo == (45) ||
                        note_tempo == (57) || note_tempo == (69) ||
                        note_tempo == (81) || note_tempo == (93) ||
                        note_tempo == (105) || note_tempo == (117) ||
                        note_tempo == (129)) {
                    noteAboutTrack.add("LA");
                } else if (note_tempo == (10) || note_tempo == (22) ||
                        note_tempo == (34) || note_tempo == (46) ||
                        note_tempo == (58) || note_tempo == (70) ||
                        note_tempo == (82) || note_tempo == (94) ||
                        note_tempo == (106) || note_tempo == (118) ||
                        note_tempo == (130)) {
                    noteAboutTrack.add("LAdSIb");
                } else {
                    noteAboutTrack.add("SI");
                }
            } else {
                countNotStatRows++;
            }
            countTotRows++;
            row = bufferedReaderEtl.readLine();
        }
        bufferedReaderEtl.close();
        new File(outputFile).delete();
        Midi midi_temp = midiDao.save(new Midi(null, file.getName().substring(0, file.getName().length() - 4), tracks, countTotRows, countNotStatRows));

        for (int i = 0; i < tracks + 1; i++) {
            Track track = new Track(null, i, null, midi_temp);
            for (int j = 0; j < trackAboutInstrument.size(); j++) {
                if (i == trackAboutInstrument.get(j)) {
                    track.setInstrument_idinstrument(instrumentDao.findById(instrumentAboutTrack.get(j)).get());
                    trackDao.save(track);
                }
            }
            trackDao.save(track);
        }

        for (int i = 0; i < trackAboutTitle.size(); i++) {
            List<Track> AllTracksNumber = trackDao.getAllByNumber(trackAboutTitle.get(i));
            for (Track track : AllTracksNumber) {
                if (track.getMidi_idmidi().getIdmidi().equals(midi_temp.getIdmidi())) {
                    titleDao.save(new Title(null, titleAboutTrack.get(i).substring(1, titleAboutTrack.get(i).length() - 1), trackDao.findById(track.getIdtrack()).get()));
                    break;
                }
            }
        }

        for (int i = 0; i < trackAboutTimeSignature.size(); i++) {
            List<Track> AllTracksNumber = trackDao.getAllByNumber(trackAboutTimeSignature.get(i));
            for (Track track : AllTracksNumber) {
                if (track.getMidi_idmidi().getIdmidi().equals(midi_temp.getIdmidi())) {
                    tempoDao.save(new Tempo(null, absoluteTimeAboutTimeSignature.get(i), numeratorAboutTrack.get(i), denominatorAboutTrack.get(i), trackDao.findById(track.getIdtrack()).get()));
                    break;
                }
            }
        }

        for (int i = 0; i < trackAboutBpm.size(); i++) {
            List<Track> AllTracksNumber = trackDao.getAllByNumber(trackAboutBpm.get(i));
            for (Track track : AllTracksNumber) {
                if (track.getMidi_idmidi().getIdmidi().equals(midi_temp.getIdmidi())) {
                    bpmDao.save(new Bpm(null, absoluteTimeAboutBpm.get(i), bpmAboutTrack.get(i), trackDao.findById(track.getIdtrack()).get()));
                    break;
                }
            }
        }

        for (int i = 0; i < trackAboutKeyTone.size(); i++) {
            List<Track> AllTracksNumber = trackDao.getAllByNumber(trackAboutKeyTone.get(i));
            for (Track track : AllTracksNumber) {
                if (track.getMidi_idmidi().getIdmidi().equals(midi_temp.getIdmidi())) {
                    keyToneDao.save(new KeyTone(null, absoluteTimeAboutKeyTone.get(i), modeDao.findByValue(modeTrack.get(i)).get(), toneDao.findByValue(toneTrack.get(i)).get(), trackDao.findById(track.getIdtrack()).get()));
                    break;
                }
            }
        }

        for (int i = 0; i < trackAboutNote.size(); i++) {
            List<Track> AllTracksNumber = trackDao.getAllByNumber(trackAboutNote.get(i));
            for (Track track : AllTracksNumber) {
                if (track.getMidi_idmidi().getIdmidi().equals(midi_temp.getIdmidi())) {
                    noteDao.save(new com.project.musicStats.entities.Note(null, absoluteTimeAboutNote.get(i), notesDao.findByValue(noteAboutTrack.get(i)).get(), trackDao.findById(track.getIdtrack()).get()));
                    break;
                }
            }
        }
    }

}

