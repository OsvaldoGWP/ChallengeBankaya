package com.bankaya.challenge.ws;

import com.bankaya.challenge.client.response.Encounter;
import com.bankaya.challenge.client.response.Pokemon;
import com.bankaya.challenge.client.response.Pokemon.AbilityData;
import com.bankaya.challenge.gen.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PokemonBuilder {

    public static GetIdResponse buildIdResponse(Pokemon pokemon) {
        var response = new GetIdResponse();
        response.setId(pokemon.getId());
        return response;
    }

    public static GetAbilityListResponse buildAbilityListResponse(Pokemon pokemon) {
        var response = new GetAbilityListResponse();
        if (CollectionUtils.isEmpty(pokemon.getAbilities())) return response;
        pokemon.getAbilities().stream()
                .map(AbilityData::getAbility)
                .filter(Objects::nonNull)
                .forEach(ability -> {
                    var abilityResponse = new AbilityResponse();
                    abilityResponse.setName(ability.getName());
                    response.getAbilities().add(abilityResponse);
                });
        return response;
    }

    public static GetBaseExperienceResponse buildBaseExperienceResponse(Pokemon pokemon) {
        var response = new GetBaseExperienceResponse();
        response.setBaseExperience(pokemon.getBaseExperience());
        return response;
    }

    public static GetLocationAreaEncountersResponse buildLocationAreaEncountersResponse(List<Encounter> encounters) {
        var response = new GetLocationAreaEncountersResponse();

        encounters.stream()
                .map(Encounter::getLocationArea)
                .filter(Objects::nonNull)
                .forEach(locationArea -> {
                    var locationAreaEncounterResponse = new LocationAreaEncounterResponse();
                    locationAreaEncounterResponse.setName(locationArea.getName());
                    response.getEncounters().add(locationAreaEncounterResponse);
                });
        return response;
    }

}
