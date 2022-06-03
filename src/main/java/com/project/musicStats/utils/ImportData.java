package com.project.musicStats.utils;

import com.project.musicStats.daos.*;
import com.project.musicStats.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ImportData {

    @Autowired
    IFamilyDao iFamilyDao;

    @Autowired
    InstrumentDao instrumentDao;

    @Autowired
    ModeDao modeDao;

    @Autowired
    ToneDao toneDao;

    @Autowired
    NotesDao notesDao;

    public void importAll() throws IOException {
        importIFamily();
        importInstrument();
        importMode();
        importTone();
        importNotes();
    }

    public void importIFamily() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("importDump/ifamily.csv").getFile());
        BufferedReader bufferedReaderIFamily = new BufferedReader(new FileReader(file));
        String rowIFamily = bufferedReaderIFamily.readLine();
        rowIFamily = bufferedReaderIFamily.readLine();
        while (rowIFamily != ("") && rowIFamily != null) {
            String[] vectorIFamily = rowIFamily.split(";");
            iFamilyDao.save(new IFamily(Integer.parseInt(vectorIFamily[0]), vectorIFamily[1]));
            rowIFamily = bufferedReaderIFamily.readLine();
        }
        bufferedReaderIFamily.close();
    }

    public void importInstrument() throws IOException {
        Integer countRow, family;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("importDump/instrument.csv").getFile());
        BufferedReader bufferedReaderInstrument = new BufferedReader(new FileReader(file));
        String rowInstrument = bufferedReaderInstrument.readLine();
        rowInstrument = bufferedReaderInstrument.readLine();
        countRow = 1;
        while (rowInstrument != ("") && rowInstrument != null) {
            String[] vectorInstrument = rowInstrument.split(";");
            if (countRow < 9) {
                family = 1;
            } else if (countRow < 17) {
                family = 2;
            } else if (countRow < 25) {
                family = 3;
            } else if (countRow < 33) {
                family = 4;
            } else if (countRow < 41) {
                family = 5;
            } else if (countRow < 49) {
                family = 6;
            } else if (countRow < 57) {
                family = 7;
            } else if (countRow < 65) {
                family = 8;
            } else if (countRow < 73) {
                family = 9;
            } else if (countRow < 81) {
                family = 10;
            } else if (countRow < 89) {
                family = 11;
            } else if (countRow < 97) {
                family = 12;
            } else if (countRow < 105) {
                family = 13;
            } else if (countRow < 113) {
                family = 14;
            } else if (countRow < 121) {
                family = 15;
            } else {
                family = 16;
            }
            instrumentDao.save(new Instrument(Integer.parseInt(vectorInstrument[0]), vectorInstrument[1], iFamilyDao.findById(family).get()));
            countRow++;
            rowInstrument = bufferedReaderInstrument.readLine();
        }
        bufferedReaderInstrument.close();
    }

    public void importMode() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("importDump/mode.csv").getFile());
        BufferedReader bufferedReaderMode = new BufferedReader(new FileReader(file));
        String rowMode = bufferedReaderMode.readLine();
        rowMode = bufferedReaderMode.readLine();
        while (rowMode != ("") && rowMode != null) {
            String[] vectorMode = rowMode.split(";");
            modeDao.save(new Mode(Integer.parseInt(vectorMode[0]), vectorMode[1]));
            rowMode = bufferedReaderMode.readLine();
        }
        bufferedReaderMode.close();
    }

    public void importTone() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("importDump/tone.csv").getFile());
        BufferedReader bufferedReaderTone = new BufferedReader(new FileReader(file));
        String rowTone = bufferedReaderTone.readLine();
        rowTone = bufferedReaderTone.readLine();
        while (rowTone != ("") && rowTone != null) {
            String[] vectorTone = rowTone.split(";");
            toneDao.save(new Tone(Integer.parseInt(vectorTone[0]), vectorTone[1]));
            rowTone = bufferedReaderTone.readLine();
        }
        bufferedReaderTone.close();
    }

    public void importNotes() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("importDump/notes.csv").getFile());
        BufferedReader bufferedReaderNotes = new BufferedReader(new FileReader(file));
        String rowNotes = bufferedReaderNotes.readLine();
        rowNotes = bufferedReaderNotes.readLine();
        while (rowNotes != ("") && rowNotes != null) {
            String[] vectorNotes = rowNotes.split(";");
            notesDao.save(new Notes(Integer.parseInt(vectorNotes[0]), vectorNotes[1]));
            rowNotes = bufferedReaderNotes.readLine();
        }
        bufferedReaderNotes.close();
    }

}
