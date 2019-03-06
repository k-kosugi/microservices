package org.kenta.kosugi.model;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class ActorTest {

    @Test
    public void testActor001(){
        Actor target = new Actor();

        target.actorId = 100;
        target.firstName = "Kenta";
        target.lastName = "Kosugi";
        target.lastUpdate = Calendar.getInstance().getTime();

        assertNotNull(target);
        assertEquals("Kenta", target.firstName);
        assertEquals("Kosugi", target.lastName);
    }

}