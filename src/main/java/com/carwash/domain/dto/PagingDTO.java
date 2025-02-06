package com.carwash.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagingDTO {

    private int firstRecordIndex;
    private int recordCountPerPage;
}
