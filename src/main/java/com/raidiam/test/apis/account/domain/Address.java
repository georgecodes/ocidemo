package com.raidiam.test.apis.account.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String lineOne;
    private String lineTwo;
    private String town;
    private String country;
    private String postCode;

}
