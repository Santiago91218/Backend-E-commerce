package com.example.BackLookz.DTO;

import lombok.Data;

@Data
public class ItemRequest {
    private String title;
    private int quantity;
    private Float unitPrice;
}
