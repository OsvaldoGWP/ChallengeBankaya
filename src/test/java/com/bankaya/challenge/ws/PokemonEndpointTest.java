package com.bankaya.challenge.ws;

import com.bankaya.challenge.client.PokemonClient;
import com.bankaya.challenge.gen.GetAbilityListRequest;
import com.bankaya.challenge.gen.GetAbilityListResponse;
import com.bankaya.challenge.gen.GetIdRequest;
import com.bankaya.challenge.gen.GetIdResponse;
import com.bankaya.challenge.util.Mocks;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PokemonEndpointTest {

    @Mock
    private PokemonClient pokemonClient;

    @InjectMocks
    private PokemonEndpoint pokemonEndpoint;

    @Test
    void getId() {

        //Given
        var pokemonName = "pikachu";
        var pokemonMock = Mocks.getPokemon(pokemonName);
        given(pokemonClient.getBy(anyString())).willReturn(pokemonMock);
        var request = new GetIdRequest();
        request.setName(pokemonName);

        //When
        GetIdResponse result = pokemonEndpoint.getId(request);

        //Then
        then(result).isNotNull();
        then(result.getId()).isEqualTo(pokemonMock.getId());
    }

    @Test
    void getIdWithInvalidPokemonName() {

        //Given
        var pokemonName = "";
        var request = new GetIdRequest();
        request.setName(pokemonName);

        //When
        IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
                () -> pokemonEndpoint.getId(request));

        //Then
        then(result).isNotNull();
        then(result.getMessage()).contains("El nombre del pokemon no puede ser nulo");
    }

    @Test
    void getAbilities() {

        //Given
        var pokemonName = "pikachu";
        var pokemonMock = Mocks.getPokemon(pokemonName);
        given(pokemonClient.getBy(anyString())).willReturn(pokemonMock);
        var request = new GetAbilityListRequest();
        request.setName(pokemonName);

        //When
        GetAbilityListResponse result = pokemonEndpoint.getAbilities(request);

        //Then
        then(result).isNotNull();
        then(result.getAbilities()).isNotEmpty();
    }

}