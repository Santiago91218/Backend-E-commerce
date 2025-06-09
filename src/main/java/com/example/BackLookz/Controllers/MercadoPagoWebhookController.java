package com.example.BackLookz.Controllers;

import com.example.BackLookz.Services.MercadoPagoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/webhook")
@RequiredArgsConstructor
public class MercadoPagoWebhookController {

    private final MercadoPagoService mercadoPagoService;

    @PostMapping
    public ResponseEntity<String> recibirWebhook(@RequestBody Map<String, Object> body) {
        System.out.println("Webhook recibido: " + body);

        try {
            Map<String, Object> data = (Map<String, Object>) body.get("data");
            Long paymentId = Long.valueOf(data.get("id").toString());


            Map<String, Object> pago = mercadoPagoService.obtenerPagoPorId(paymentId);
            System.out.println("🔍 Pago consultado: " + pago);
            if ("approved".equals(pago.get("status"))) {
                System.out.println("Pago aprobado, crear orden");
            }

            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
