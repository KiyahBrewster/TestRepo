public class Locker {
    private final int number;
    private String pin;

    public Locker(int number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    public int getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public void release() {
        this.pin = null;
    }

    public boolean isAvailable() {
        return pin == null;
    }

    public boolean verifyPin(String inputPin) {
        return pin != null && pin.equals(inputPin);
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}