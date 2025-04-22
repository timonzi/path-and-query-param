package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.rest.ParametersClientApi;
import org.base.types.TypesBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class ParametersResourceTest {

    private static final String SOME_VALUE = "someValue";


    @Inject
    @RestClient
    ParametersClientApi clientApi;


    @Test
    void testStringTypePath() {
        final var result = clientApi.stringTypePath(TypesBuilder.newStringType(SOME_VALUE));
        assertEquals(SOME_VALUE, result);
    }


    @Test
    void testStringTypeQuery() {
        final var result = clientApi.stringTypeQuery(TypesBuilder.newStringType(SOME_VALUE));
        assertEquals(SOME_VALUE, result);
    }

}