package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Talle;
import com.example.BackLookz.Repositories.TalleRepository;
import com.example.BackLookz.Services.TalleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/talles")
public class TalleController extends BaseController<Talle, Long, TalleRepository, TalleService> {
    public TalleController(TalleService service){
        super(service);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<?> filtrarPorTalle(@RequestParam String talle) {
        try {
            List<Talle> talles = service.filtrarPorTalle(talle);
            return ResponseEntity.ok(talles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
