package com.bankaya.challenge.ws;

import com.bankaya.challenge.client.PokemonClient;
import com.bankaya.challenge.gen.*;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.bankaya.challenge.config.WebServiceConfig.NAMESPACE_URI;
import static com.bankaya.challenge.ws.PokemonBuilder.*;

@Endpoint
@AllArgsConstructor
public class PokemonEndpoint {

    private PokemonClient pokemonClient;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    public GetIdResponse getId(@RequestPayload GetIdRequest request) {
        validPokemonName(request.getName());
        var pokemon = pokemonClient.getBy(request.getName());
        return buildIdResponse(pokemon);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilityListRequest")
    public GetAbilityListResponse getAbilities(@RequestPayload GetAbilityListRequest request) {
        validPokemonName(request.getName());
        var pokemon = pokemonClient.getBy(request.getName());
        return buildAbilityListResponse(pokemon);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    public GetBaseExperienceResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {
        validPokemonName(request.getName());
        var pokemon = pokemonClient.getBy(request.getName());
        return buildBaseExperienceResponse(pokemon);
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {
        validPokemonName(request.getName());
        var pokemon = pokemonClient.getBy(request.getName());
        var encounters = pokemonClient.getEncounters(pokemon.getId());
        return buildLocationAreaEncountersResponse(encounters);
    }

    private void validPokemonName(String name) {
        Assert.hasText(name, "El nombre del pokemon no puede ser nulo");
    }

}