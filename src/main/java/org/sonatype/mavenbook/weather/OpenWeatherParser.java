package org.sonatype.mavenbook.weather;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class OpenWeatherParser {
    private final static Logger log = Logger.getLogger(OpenWeatherParser.class);

    public Weather parse(InputStream inputStream) throws Exception {
        Weather weather = new Weather();
        log.info("Creating XML Reader");
        SAXReader xmlReader = new SAXReader();
        Document doc = xmlReader.read(inputStream);
        log.info("Parsing XML Response");
        weather.setCity(doc.selectSingleNode("current/city").valueOf("@name"));
        weather.setCountry(doc.selectSingleNode("current/city").selectSingleNode("country").getText());
        weather.setTemperature(doc.selectSingleNode("current/temperature").valueOf("@value")
                + " " + doc.selectSingleNode("current/temperature").valueOf("@unit"));
        weather.setFeelsLike(doc.selectSingleNode("current/feels_like").valueOf("@value")
                + " " + doc.selectSingleNode("current/feels_like").valueOf("@unit"));
        weather.setHumidity(doc.selectSingleNode("current/humidity").valueOf("@value")
                + doc.selectSingleNode("current/humidity").valueOf("@unit"));
        weather.setPressure(doc.selectSingleNode("current/pressure").valueOf("@value")
                + " " + doc.selectSingleNode("current/pressure").valueOf("@unit"));
        weather.setVisibility(doc.selectSingleNode("current/visibility").valueOf("@value"));
        return weather;
    }

}