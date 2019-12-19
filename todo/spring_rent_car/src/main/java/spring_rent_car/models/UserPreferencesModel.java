package spring_rent_car.models;

public class UserPreferencesModel {

    private int moneyForRent;
    private int rentDuration;
    private int proximalDistance;
    private int passengerCapacity;

    public UserPreferencesModel() {
    }

    public UserPreferencesModel(int moneyForRent, int rentDuration, int proximalDistance, int passengerCapacity) {
        this.moneyForRent = moneyForRent;
        this.rentDuration = rentDuration;
        this.proximalDistance = proximalDistance;
        this.passengerCapacity = passengerCapacity;
    }

    public int getMoneyForRent() {
        return moneyForRent;
    }

    public void setMoneyForRent(int moneyForRent) {
        this.moneyForRent = moneyForRent;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }

    public int getProximalDistance() {
        return proximalDistance;
    }

    public void setProximalDistance(int proximalDistance) {
        this.proximalDistance = proximalDistance;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
