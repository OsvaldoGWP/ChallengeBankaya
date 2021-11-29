package com.bankaya.challenge.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Encounter {

    @JsonProperty("location_area")
    private LocationArea locationArea;

    @Data
    public static class LocationArea {

        private String name;
        private String url;
    }

}
