package org.sonatype.mavenbook.wheather.open_weather;

import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.sonatype.mavenbook.wheather.OpenWeatherParser;
import org.sonatype.mavenbook.wheather.Weather;
import org.sonatype.mavenbook.wheather.WeatherFormatter;

import java.io.InputStream;

public class WeatherFormatterTest extends TestCase {
    public WeatherFormatterTest(String name) {
        super(name);
    }

    public void testFormat() throws Exception {
        InputStream nyData = getClass().getClassLoader()
                .getResourceAsStream("ny-weather.xml");
        Weather weather = new OpenWeatherParser().parse(nyData);
        String formattedResult = new WeatherFormatter().format(weather);
        InputStream expected = getClass().getClassLoader()
                .getResourceAsStream("format-expected.txt");
        assertEquals(IOUtils.toString(expected).trim(),
                formattedResult.trim());
    }
}