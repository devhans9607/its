package com.hans.its.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Table1 {
    @Id
    private Long id;

    private String string;
}
