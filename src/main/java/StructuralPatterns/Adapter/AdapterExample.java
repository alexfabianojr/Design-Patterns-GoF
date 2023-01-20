package StructuralPatterns.Adapter;

interface Temperature {
    double getTemperature();
}

class CelsiusTemperature implements Temperature {
    private double temperature;

    public CelsiusTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

class FahrenheitTemperature implements Temperature {
    private double temperature;

    public FahrenheitTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}

class TemperatureAdapter implements Temperature {
    private FahrenheitTemperature fahrenheitTemperature;

    public TemperatureAdapter(FahrenheitTemperature fahrenheitTemperature) {
        this.fahrenheitTemperature = fahrenheitTemperature;
    }

    public double getTemperature() {
        return (fahrenheitTemperature.getTemperature() - 32) * 5 / 9;
    }
}

