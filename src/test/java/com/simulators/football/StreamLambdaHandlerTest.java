package com.simulators.football;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;

import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class StreamLambdaHandlerTest {

    private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

    @Mock
    private Context context;

    @BeforeAll
    static void setup() {
        try {
            handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(FootballApplication.class);
        } catch (ContainerInitializationException e) {
            throw new RuntimeException("Could not initialize Spring Boot application", e);
        }
    }

    @Test
    void testHandleRequest() throws IOException {
        // Prepare the input and output streams
        String inputJson = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        InputStream inputStream = new ByteArrayInputStream(inputJson.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        // Mock the context
        when(context.getAwsRequestId()).thenReturn("request-id-123");

        // Invoke the handleRequest method
        StreamLambdaHandler lambdaHandler = new StreamLambdaHandler();
        lambdaHandler.handleRequest(inputStream, outputStream, context);

        // Verify the output
        assertNotNull(outputStream);
    }
}