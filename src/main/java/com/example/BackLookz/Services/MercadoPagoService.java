package com.example.BackLookz.Services;

import com.example.BackLookz.DTO.ItemRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MercadoPagoService {

    @Value("${MERCADOPAGO_ACCESS_TOKEN}")
    private String accessToken;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String crearPreferencia(List<ItemRequest> items, String email) {
        try {
            Map<String, Object> payload = new HashMap<>();

            List<Map<String, Object>> itemsList = items.stream().map(item -> {
                Map<String, Object> map = new HashMap<>();
                map.put("title", item.getTitle());
                map.put("quantity", item.getQuantity());
                map.put("unit_price", item.getUnitPrice());
                map.put("currency_id", "ARS");
                return map;
            }).toList();

            payload.put("items", itemsList);
            payload.put("payer", Map.of("email", email));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(accessToken);

            HttpEntity<String> request = new HttpEntity<>(
                    objectMapper.writeValueAsString(payload),
                    headers
            );

            ResponseEntity<Map> response = restTemplate.exchange(
                    "https://api.mercadopago.com/checkout/preferences",
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            Map<String, Object> responseBody = response.getBody();
            return responseBody != null ? responseBody.get("init_point").toString() : null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

