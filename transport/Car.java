package transport;

import java.time.LocalDateTime;


public class Car {

    private class key {
        /*Может быть я неправильно понял условие второго задания... Согласно подсказке "Оба параметра могут быть boolean.", соответственно какие проверки им нужны?
        * Значения всегда будут либо true, либо false.  */
        private final boolean remoteEngineStart = false;
        private final boolean keylessEntry = false;

        public key() {
        }

        private boolean verificationRemoteEngineStart(boolean remoteEngineStart) {
            String check = String.valueOf(remoteEngineStart);
            return check.equals(null) || check.isEmpty() || check.isBlank() ? false : remoteEngineStart;
        }

        private boolean verificationRemoteKeylessEntry(boolean keylessEntry) {
            String check = String.valueOf(keylessEntry);
            return check.equals(null) || check.isEmpty() || check.isBlank() ? false : keylessEntry;
        }
    }

    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int numberOfSeats;
    private String tireType;


    public Car(String brand, String model, int year, double engineVolume, String transmission, String bodyType, int numberOfSeats, String color, String registrationNumber, String country) {
        this.brand = verificationBrand(brand);
        this.model = verificationModel(model);
        this.engineVolume = setEngineVolume(engineVolume);
        this.color = setColor(color);
        this.year = verificationYear(year);
        this.country = verificationCountry(country);
        this.bodyType = verificationBodyType(bodyType);
        this.transmission = setTransmission(transmission);
        this.numberOfSeats = verificationNumberOfSeats(numberOfSeats);
        this.registrationNumber = setRegistrationNumber(registrationNumber);
        this.tireType = setTireType();

    }

    private String verificationBrand(String brand) {
        return brand == null || brand.isEmpty() || brand.isBlank() ? "default" : brand;
    }

    private String verificationModel(String model) {
        return model == null || model.isEmpty() || model.isBlank() ? "default" : model;
    }

    private int verificationYear(int year) {
        return year < 1886 || year > LocalDateTime.now().getYear() ? 2000 : year; //Автомобиль не может быть старше самого первого автомобиля. А также заранее построен.
    }

    private String verificationCountry(String country) {
        return country == null || country.isEmpty() || country.isBlank() ? "default" : country;
    }

    private String verificationBodyType(String bodyType) {
        return bodyType == null || bodyType.isEmpty() || bodyType.isBlank() ? "default" : bodyType;
    }

    private int verificationNumberOfSeats(int numberOfSeats) {
        return numberOfSeats <= 0 ? 2 : numberOfSeats; //Я думаю, гоночные болиды не будут присутствовать в нашем списке.
    }


    public double setEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    public String setColor(String color) {
        return color == null || color.isEmpty() || color.isBlank() ? "белый" : color;
    }

    public String setTransmission(String transmission) {
        return transmission == null || transmission.isEmpty() || transmission.isBlank() ? "default" : transmission;
    }

    public String setRegistrationNumber(String registrationNumber) {
        String s = registrationNumber.toUpperCase();
        if (s == null ||
                s.isEmpty() ||
                s.isBlank() ||
                s.contains("Й") ||
                s.contains("Ц") ||
                s.contains("Г") ||
                s.contains("Ш") ||
                s.contains("Щ") ||
                s.contains("З") ||
                s.contains("Ф") ||
                s.contains("Ы") ||
                s.contains("П") ||
                s.contains("Л") ||
                s.contains("Д") ||
                s.contains("Ж") ||
                s.contains("Э") ||
                s.contains("Я") ||
                s.contains("Ч") ||
                s.contains("Ь") ||
                s.contains("Ъ") ||
                s.contains("Б") ||
                s.contains("Ю")) {
            return "default";
        } else return s;
    }

    public String setTireType() { //Сменить шины на сезонные
        String month = LocalDateTime.now().getMonth().toString();
        switch (month) {
            case "DECEMBER":
            case "JANUARY":
            case "FEBRUARY":
                return "Зимняя резина";
            default:
                return "Летняя резина";
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getColor() {
        return color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getTireType() {
        return tireType;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }


    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return brand +
                " " + model +
                ", объем двигателя " + engineVolume + " л." +
                ", год производства " + year +
                ", страна сборки " + country +
                ", коробка передач " + transmission +
                ", тип кузова " + bodyType +
                ", цвет кузова " + color +
                ", количество мест " + numberOfSeats +
                ", тип шин " + tireType +
                ", регистрационный номер " + registrationNumber;
    }
}


