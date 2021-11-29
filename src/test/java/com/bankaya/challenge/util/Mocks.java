package com.bankaya.challenge.util;

import com.bankaya.challenge.client.response.Pokemon;
import com.bankaya.challenge.client.response.Pokemon.Ability;
import com.bankaya.challenge.client.response.Pokemon.AbilityData;

import java.util.List;

public class Mocks {

    public static Pokemon getPokemon(String name) {
        var ability = new Ability();
        ability.setName("ability-name");
        ability.setUrl("url");
        var abilityData = new AbilityData();
        abilityData.setAbility(ability);

        var pokemon = new Pokemon();
        pokemon.setId(1L);
        pokemon.setName(name);
        pokemon.setBaseExperience(23);
        pokemon.setAbilities(List.of(abilityData));
        return pokemon;
    }

}
