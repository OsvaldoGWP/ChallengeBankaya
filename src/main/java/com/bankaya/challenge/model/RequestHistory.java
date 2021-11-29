package com.bankaya.challenge.model;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestHistory {

    private Long id;
    private String method;
    private String sourceIp;
    private OffsetDateTime requestDate;
    private boolean successful;
    private String request;
}
