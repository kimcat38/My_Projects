public enum Planet {
    MERCURY("Mercury", 0.39),
    VENUS("Venus", 0.74),
    EARTH("Earth", 1.0),
    MARS("Mars", 1.53);

    private final String name;
    private final double distanceFromSun;

    Planet(String name, double distanceFromSun) {
        this.name = name;
        this.distanceFromSun = distanceFromSun;
    }

    public String getName() {
        return name;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

}
