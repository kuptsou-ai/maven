package org.sonatype.mavenbook.weather;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Weather {
    private String city;
    private String country;
    private String temperature;
    private String feelsLike;
    private String humidity;
    private String pressure;
    private String visibility;
}