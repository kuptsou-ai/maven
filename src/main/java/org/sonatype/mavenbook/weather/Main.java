package org.sonatype.mavenbook.weather;

import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
// Configure Log4J
        PropertyConfigurator
                .configure(Main.class.getClassLoader()
                        .getResource("log4j.properties"));
        String cityName = "London";
        try {
            cityName = args[0];
        } catch (Exception e) {
        }

        InputStream dataIn = new OpenWeatherRetriever().retrieve(cityName);

        Weather weather = new OpenWeatherParser().parse(dataIn);

        System.out.print(new WeatherFormatter().format(weather));
    }
}