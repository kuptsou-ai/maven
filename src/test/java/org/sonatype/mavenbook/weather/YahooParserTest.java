package org.sonatype.mavenbook.weather;

import junit.framework.TestCase;
import org.sonatype.mavenbook.weather.OpenWeatherParser;
import org.sonatype.mavenbook.weather.Weather;

import java.io.InputStream;

public class YahooParserTest extends TestCase {
    public YahooParserTest(String name) {
        super(name);
    }

    public void testParser() throws Exception {
        InputStream nyData = getClass().getClassLoader()
                .getResourceAsStream("ny-weather.xml");
        Weather weather = new OpenWeatherParser().parse(nyData);
        assertEquals("Minsk", weather.getCity());
        assertEquals("BY", weather.getCountry());
        assertEquals("18.86 celsius", weather.getTemperature());
        assertEquals("18.63 celsius", weather.getFeelsLike());
        assertEquals("70%", weather.getHumidity());
        assertEquals("1014 hPa", weather.getPressure());
        assertEquals("10000", weather.getVisibility());
    }
}