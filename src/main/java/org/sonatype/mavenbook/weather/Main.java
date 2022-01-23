package org.sonatype.mavenbook.weather;

import java.io.InputStream;

public class Main {
    private static final String DEFAULT_CITY = "London";

    public static void main(String[] args) throws Exception {
        String cityName = args.length != 0 ? args[0] : DEFAULT_CITY;
        InputStream dataIn = new OpenWeatherRetriever().retrieve(cityName);
        Weather weather = new OpenWeatherParser().parse(dataIn);

        System.out.print(new WeatherFormatter(weather).format());
    }
}