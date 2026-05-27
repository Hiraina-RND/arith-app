package hei.prog.app.endpoint.rest.controller.arith;

import hei.prog.app.service.ArithService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ArithController {
  ArithService arithService;

  @GetMapping("/add")
  ResponseEntity<Double> add(@RequestParam Double a, @RequestParam Double b) {
    return ResponseEntity.ok(arithService.add(a, b));
  }

  @GetMapping("/sub")
  ResponseEntity<Double> sub(@RequestParam Double a, @RequestParam Double b) {
    return ResponseEntity.ok(arithService.sub(a, b));
  }

  @GetMapping("/mul")
  ResponseEntity<Double> mul(@RequestParam Double a, @RequestParam Double b) {
    return ResponseEntity.ok(arithService.mul(a, b));
  }

  @GetMapping("/div")
  ResponseEntity<Double> div(@RequestParam Double a, @RequestParam Double b) {
    return ResponseEntity.ok(arithService.div(a, b));
  }
}
