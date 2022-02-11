package com.raidiam.test.apis.account.controllers;

import com.raidiam.test.apis.account.domain.Account;
import com.raidiam.test.apis.account.domain.Address;
import com.raidiam.test.apis.account.domain.Customer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountApiController {

    @RequestMapping(method = { RequestMethod.GET }, path = "/api/v1/accounts/{accountNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account account(@PathVariable("accountNumber") String accountNumber) {
        Account account = Account.builder()
                .accountNumber("68468468")
                .customer(Customer.builder()
                        .name("Teddy Moneybags")
                        .address(Address.builder()
                                .lineOne("7 Richmond Avenue")
                                .lineTwo("Richville")
                                .town("Even Greater London")
                                .postCode("NE1 4TNS")
                                .build())
                        .build())
                .build();
        return account;
    }

}
