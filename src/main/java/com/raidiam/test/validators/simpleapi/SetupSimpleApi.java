package com.raidiam.test.validators.simpleapi;

import com.raidiam.test.engine.AbstractTestStep;
import com.raidiam.test.engine.Context;

public class SetupSimpleApi extends AbstractTestStep {

    @Override
    public void execute(Context context) {
        String baseUrl = context.getProperty("simple_api_base_url");
        String apiUrl = baseUrl.concat("/api/v1/simple");

        context.addProperty("resource_url", apiUrl);
        context.addProperty("resource_method", "GET");
    }
}
