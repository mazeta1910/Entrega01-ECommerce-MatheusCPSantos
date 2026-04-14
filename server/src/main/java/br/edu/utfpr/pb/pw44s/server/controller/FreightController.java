package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.FreightResponseDTO;
import br.edu.utfpr.pb.pw44s.server.service.FreightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("freights")
public class FreightController {

    private final FreightService freightService;

    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<List<FreightResponseDTO>> calculate(@RequestParam String zipCode) {
        return ResponseEntity.ok(freightService.calculateFreight(zipCode));
    }
}