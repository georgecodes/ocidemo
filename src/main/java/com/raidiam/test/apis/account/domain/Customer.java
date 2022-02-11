package com.raidiam.test.apis.account.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String name;
    private Address address;

}
