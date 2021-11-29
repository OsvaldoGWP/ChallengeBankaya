package com.bankaya.challenge.client;

import com.bankaya.challenge.cache.CacheName;
import com.bankaya.challenge.client.response.Encounter;
import com.bankaya.challenge.client.response.Pokemon;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "pokemon-client", url = "${api.pokemon}")
public interface PokemonClient {

    @GetMapping("/pokemon/{name}")
    @Cacheable(value = CacheName.POKEMON,
            key = "'getBy' + '_pokemonName:' + #name")
    Pokemon getBy(@PathVariable String name);

    @GetMapping("/pokemon/{id}/encounters")
    List<Encounter> getEncounters(@PathVariable Long id);
}
