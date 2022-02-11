package com.raidiam.test.engine;

public abstract class AbstractTestStep implements TestStep {

        protected void failStep(String message) {
            throw new TestException(message);
        }


}
