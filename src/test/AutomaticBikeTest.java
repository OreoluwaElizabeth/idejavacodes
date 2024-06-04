package test;

import AutomaticBike.AutomaticBike;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutomaticBikeTest {

    @Test
    public void testAutomaticBikeIsOn() {
        AutomaticBike automaticBike = new AutomaticBike();
        automaticBike.turnOn();
        assertTrue(automaticBike.turnOn());
    }

    @Test
    public void testAutomaticBikeIsOff() {
        AutomaticBike automaticBike = new AutomaticBike();
        automaticBike.turnOn();
        assertTrue(automaticBike.turnOn());
        automaticBike.turnOff();
        assertFalse(automaticBike.turnOff());
    }

    @Test
    public void testAutomaticBikeCanBeAcceleratedByIncrementOf1and2and3and4(){
        AutomaticBike automaticBike = new AutomaticBike();
        automaticBike.turnOn();
        assertTrue(automaticBike.turnOn());

        int initialGear = automaticBike.getGear();
        automaticBike.incrementGear();
        int newGear = automaticBike.getGear();
        assertTrue(newGear == initialGear + 1);
        assertTrue(newGear <= 4);

        initialGear = newGear;
        automaticBike.incrementGear();
        newGear = automaticBike.getGear();
        assertTrue(newGear == initialGear * 2);
        assertTrue(newGear <= 4);

        initialGear = newGear;
        automaticBike.incrementGear();
        newGear = automaticBike.getGear();
        assertTrue(newGear == initialGear * 3);
        assertTrue(newGear <= 4);

        initialGear = newGear;
        automaticBike.incrementGear();
        newGear = automaticBike.getGear();
        assertTrue(newGear == initialGear * 4);
        assertTrue(newGear == 4);

    }

}
