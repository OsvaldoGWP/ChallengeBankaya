package com.bankaya.challenge.ws;

import com.bankaya.challenge.gen.GetIdResponse;

public class PokemonBuilder {

    public static GetIdResponse buildIdResponse(Long id) {
        var response = new GetIdResponse();
        response.setId(id);
        return response;
    }

}
