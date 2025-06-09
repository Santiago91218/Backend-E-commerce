package com.example.BackLookz.DTO;

import lombok.Data;
import java.util.List;

@Data
public class PagoRequest {
    private List<ItemRequest> items;
    private String email;
}
