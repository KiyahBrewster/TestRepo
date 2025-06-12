import java.util.Random;

public class LockerService {
    private final Locker[] lockers;
    private final Random random = new Random();

    public LockerService(int total) {
        lockers = new Locker[total];
        for (int i = 0; i < total; i++) {
            lockers[i] = new Locker(i, null);
        }
    }

    public boolean isFull() {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) return false;
        }
        return true;
    }

    public Locker rentLocker() {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                String pin = String.format("%04d", random.nextInt(10000));
                locker.setPin(pin);
                return locker;
            }
        }
        return null;
    }

    public Locker getLocker(int number) {
        if (number < 0 || number >= lockers.length) return null;
        return lockers[number];
    }

    public boolean releaseLocker(int number, String pin) {
        Locker locker = getLocker(number);
        if (locker != null && locker.verifyPin(pin)) {
            locker.release();
            return true;
        }
        return false;
    }
}