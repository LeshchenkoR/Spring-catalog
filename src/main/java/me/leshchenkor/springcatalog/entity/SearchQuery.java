package me.leshchenkor.springcatalog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class SearchQuery {
    private Long id;
    private String name;
}
