package com.raidiam.test;

import com.raidiam.test.engine.Context;
import com.raidiam.test.engine.TestEngine;
import com.raidiam.test.engine.TestStep;
import com.raidiam.test.engine.ValidationResult;
import com.raidiam.test.validators.simpleapi.SetupSimpleApi;
import com.raidiam.test.validators.simpleapi.SimpleApiValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValidationTests {

    @LocalServerPort
    private int serverPort;

    @Test
    void fetch() {

        Context context = new Context();
        String baseUrl = String.format("http://localhost:%d", serverPort);
        context.addProperty("simple_api_base_url", baseUrl);

        TestEngine testEngine = new TestEngine(context);
        testEngine.execute(new SetupSimpleApi());

        SimpleApiValidator validator = new SimpleApiValidator();

        ValidationResult result = testEngine.execute(validator);

        assertEquals(ValidationResult.SUCCESS, result);

    }

    @Test
    void validateAccounts() {

        Context context = new Context();

        TestEngine testEngine = new TestEngine(context);

        TestStep validator = null;

        ValidationResult result = testEngine.execute(validator);

        assertEquals(ValidationResult.FAILURE, result);

    }

}
