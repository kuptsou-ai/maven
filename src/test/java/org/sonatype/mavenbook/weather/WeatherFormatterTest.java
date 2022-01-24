package org.sonatype.mavenbook.weather;

import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;

public class WeatherFormatterTest extends TestCase {

    public void testFormat() throws Exception {
        InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny-weather.xml");
        Weather weather = new OpenWeatherParser().parse(nyData);
        String formattedResult = new WeatherFormatter(weather).format();
        InputStream expected = getClass().getClassLoader().getResourceAsStream("format-expected.txt");
        assertEquals(IOUtils.toString(expected, Charset.defaultCharset()).trim(), formattedResult.trim());
    }
}