package com.example.BackLookz.Controllers;

import com.example.BackLookz.Entities.Talle;
import com.example.BackLookz.Repositories.TalleRepository;
import com.example.BackLookz.Services.TalleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talles")
public class TalleController extends BaseController<Talle, Long, TalleRepository, TalleService> {
    public TalleController(TalleService service){
        super(service);
    }
}
