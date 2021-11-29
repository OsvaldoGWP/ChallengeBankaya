package com.bankaya.challenge.ws;

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

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    public GetIdResponse getId(@RequestPayload GetIdRequest request) {
        validPokemonName(request.getName());
        return PokemonBuilder.buildIdResponse(1L);
    }

    private void validPokemonName(String name) {
        Assert.hasText(name, "El nombre del pokemon no puede ser nulo");
    }

}