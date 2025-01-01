package de.it4ipm.mymapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Transaction {

    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private BigDecimal total;

}
