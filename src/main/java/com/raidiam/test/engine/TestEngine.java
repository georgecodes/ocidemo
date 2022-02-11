package com.raidiam.test.engine;

public class TestEngine {

    private final Context context;

    public TestEngine(Context context) {
        this.context = context;
    }

    public ValidationResult execute(TestStep validator) {
        try {
            validator.execute(context);
        } catch (TestException e) {
            return ValidationResult.FAILURE;
        }
        return ValidationResult.SUCCESS;
    }

}
