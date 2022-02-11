# Raidiam OCI coding test

At Raidiam we have a project which is a conformance suite for Open Banking Brasil APIs. It contains a lot of logic for testing external APIs to 
ensure they follow a specification.

This coding test is similarly structured. It hosts implementations of 2 simple APIs for the application to validate.

The simple API lives at 

    /api/v1/simple

And returns resources which look like this:

````
    {
     "message": "Hello"
    }
 ````

We have provided a class which correctly validates that this API returns a resource which is structured correctly.

There is a second API, the accounts API, which lives at 

    /api/v1/accounts/{accountNumber}

And is supposed to return resources which look like this:

````
{
    "accountNumber": "68468468",
    "customer": {
        "name": "Teddy Moneybags",
        "address": {
            "lineOne": "7 Richmond Avenue",
            "lineTwo": "Richville",
            "town": "Even Greater London",
            "county": "Middlesex",
            "country": "United Kingdom",
            "postCode": "NE1 4TNS"
        },
        "phoneNumber": "0202 201 9991"
    }
}
````

Unfortunately, the engineer who built it hasn't implemented the specification correctly, and it is necessary that validation detects this.

Your task is to write some code which will validate this API, and, importantly, *ensure that the validation fails*. 

The unit test in **com.raidiam.test.ValidationTests.validateAccounts** should pass. Make changes to that test as needed, and add new
code to the codebase as you feel necessary.

You should not modify code already in the current codebase, only add new code to it. There are several classes provided which you 
can use as the basis for your solution, and the SimpleApiValidator is a good guide at getting started.