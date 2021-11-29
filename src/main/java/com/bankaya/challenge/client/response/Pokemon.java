package com.bankaya.challenge.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Pokemon implements Serializable {

    private Long id;
    private String name;
    private List<AbilityData> abilities;
    @JsonProperty("base_experience")
    private Integer baseExperience;

    @Data
    public static class AbilityData implements Serializable {

        private Ability ability;
        @JsonProperty("is_hidden")
        private boolean hidden;
        private int slot;
    }

    @Data
    public static class Ability implements Serializable {
        private String name;
        private String url;
    }

}
