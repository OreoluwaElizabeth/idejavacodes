package AutomaticBike;

public class AutomaticBike {
    private boolean isOn;
    private int gear;

    public boolean turnOn() {
        isOn = true;
        gear = 1;
        return isOn;
    }

    public boolean turnOff() {
        isOn = false;
        return isOn;
    }

    public int getGear() {
        return gear;
    }

    public boolean incrementGear() {
        if (isOn) {
            if(gear == 1) {
                gear++;
            } else if (gear < 4) {
                gear *= 2;
            }
            return true;
        }
        return false;
    }
}
