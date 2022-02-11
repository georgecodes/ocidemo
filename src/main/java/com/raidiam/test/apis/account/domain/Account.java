package com.raidiam.test.apis.account.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private String accountNumber;
    private Customer customer;

}
