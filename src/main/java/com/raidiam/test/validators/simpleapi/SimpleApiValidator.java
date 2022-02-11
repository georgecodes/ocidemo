package com.raidiam.test.validators.simpleapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.raidiam.test.engine.AbstractApiValidator;
import com.raidiam.test.engine.Context;
import org.springframework.http.HttpStatus;

public class SimpleApiValidator extends AbstractApiValidator {

    @Override
    public void evaluate(Context context) {
        int statusCode = context.getIntProperty("resource_response_status");
        if(statusCode != HttpStatus.OK.value()) {
            failStep("The response was not a success");
        }

        JsonObject body = context.getObject("resource_response_body");

        JsonElement message = body.get("message");

        if(message == null) {
            failStep("The response did not contain a message");
        }

    }

}
