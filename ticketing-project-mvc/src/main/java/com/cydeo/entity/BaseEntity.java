package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseEntity {

    private Long id;
    private LocalDate insertDateTime;
    private Long insertUSerId;
    private LocalDate lastUpdateDateTime;
    private Long lastUpdateUserId;

}
