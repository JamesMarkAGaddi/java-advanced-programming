package org.acumen.training.codes.itemc.test;

import java.io.File;

import org.acumen.training.codes.itemc.FlightsCreation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TestFlightsCreation {

    private static final String FILE_PATH = "./src/flightlist.xml"; // Path where the XML is created


    @AfterEach
    public void tearDown() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
    
    @Test
    public void testCreateFlightListXML() {

        FlightsCreation flightsCreation = new FlightsCreation();
        flightsCreation.createFlightListXML();
        
    }

}
