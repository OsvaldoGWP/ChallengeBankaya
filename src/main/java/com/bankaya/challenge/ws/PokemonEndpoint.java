package com.bankaya.challenge.ws;

import com.bankaya.challenge.client.PokemonClient;
import com.bankaya.challenge.gen.GetIdRequest;
import com.bankaya.challenge.gen.GetIdResponse;
import lombok.AllArgsConstructor;
import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static com.bankaya.challenge.config.WebServiceConfig.NAMESPACE_URI;

@Endpoint
@AllArgsConstructor
public class PokemonEndpoint {

    private PokemonClient pokemonClient;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    public GetIdResponse getId(@RequestPayload GetIdRequest request) {
        validPokemonName(request.getName());
        var pokemon = pokemonClient.getBy(request.getName());
        return PokemonBuilder.buildIdResponse(pokemon.getId());
    }

    private void validPokemonName(String name) {
        Assert.hasText(name, "El nombre del pokemon no puede ser nulo");
    }

}