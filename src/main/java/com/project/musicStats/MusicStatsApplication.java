package com.project.musicStats;

import com.project.musicStats.conversionCode.EtlProcess;
import com.project.musicStats.utils.ImportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MusicStatsApplication implements CommandLineRunner {

    @Autowired
    ImportData importData;

    @Autowired
    EtlProcess etlProcess;

    public static void main(String[] args) {
        SpringApplication.run(MusicStatsApplication.class, args);
    }

    @Override
    public void run(String... strings) throws IOException {
        importData.importAll();
    }
}
