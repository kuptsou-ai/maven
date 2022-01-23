package org.sonatype.mavenbook.weather;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

@RequiredArgsConstructor
public class WeatherFormatter {
    private final static Logger log = Logger.getLogger(WeatherFormatter.class);

    private final Weather weather;

    public String format() throws Exception {
        log.info("Formatting Weather Data");
        Reader reader =
                new InputStreamReader(getClass().getClassLoader()
                        .getResourceAsStream("output.vm"));
        VelocityContext context = new VelocityContext();
        context.put("weather", weather);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(context, writer, "", reader);
        return writer.toString();
    }
}