package com.ms.schneider.dto;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customer_data")
public class CustomerMongoInsert {

    @Id
    private String id;

    private String customerId;
    private String firstName;
    private String lastName;

    private int birthDay;
    private int birthMonth;
    private int birthYear;

    private String email;

    //private AddressDocument address;

    private Instant receivedAt;
}