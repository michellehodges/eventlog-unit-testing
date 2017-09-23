package com.theironyard.eventlog;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class EventLogTest {
    EventLog log;

    @Rule
    public ExpectedException ex = ExpectedException.none();

    @Before
    public void setUp() {
        System.out.println("Setting up....");
        log = new EventLog();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Cleaning up now.\n");
    }

    @Test
    public void addEventWhenValid() {
        System.out.println("Running addEvent test.");

        Event e1 = new Event("CONNECTED", "Face2Face");
        Event e2 = new Event("CONNECTED", "PhoneCall");
        Event e3 = new Event("CONNECTED", "TextMessaging");
        Event e4 = new Event("CONNECTED", "Unknown");

        log.addEvent(e1);
        log.addEvent(e2);
        log.addEvent(e3);
        log.addEvent(e4);

        assertEquals(4, log.getNumEvents());
    }

    @Test
    public void addEventWhenNullThrowsException() {
        Event e = null;

        ex.expect(IllegalArgumentException.class);

        log.addEvent(e);

        assertEquals(4, log.getNumEvents());
    }

    @Test
    public void addEventThrowsExceptionIfEventInvalid() {
        Event e = new Event(null, "Something random");

        ex.expect(IllegalArgumentException.class);
        log.addEvent(e);

        assertEquals(4, log.getNumEvents());
    }

//    @Test
//    public void testGetNumEvents() throws Exception {
//        System.out.println("Running getNumEvents test.");
//        assertEquals(1, log.getNumEvents());
//    }

}