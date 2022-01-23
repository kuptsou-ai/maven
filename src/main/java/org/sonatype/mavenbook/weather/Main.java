package org.sonatype.mavenbook.weather;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class Main {
    private static final String DEFAULT_CITY = "London";

    public static void main(String[] args) throws Exception {
// Configure Log4J
        PropertyConfigurator
                .configure(Main.class.getClassLoader()
                        .getResource("log4j.properties"));

        String cityName = args.length != 0 ? args[0] : DEFAULT_CITY;
        InputStream dataIn = new OpenWeatherRetriever().retrieve(cityName);
        Weather weather = new OpenWeatherParser().parse(dataIn);

        System.out.print(new WeatherFormatter(weather).format());
    }
}