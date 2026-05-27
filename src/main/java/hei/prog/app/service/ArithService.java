package hei.prog.app.service;

import hei.prog.app.exception.BadRequestException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ArithService {
  public Double add(Double a, Double b) {
    validate(a, b);
    return a + b;
  }

  public Double sub(Double a, Double b) {
    validate(a, b);
    return a - b;
  }

  public Double mul(Double a, Double b) {
    validate(a, b);
    return a * b;
  }

  public Double div(Double a, Double b) {
    validate(a, b);

    if (Double.compare(b, 0.0) == 0) throw new BadRequestException("Division by zero is not allowed");
    return a / b;
  }

  private void validate(Double a, Double b) {
    if (a == null || b == null) {
      throw new BadRequestException("Parameters a and b must not be null");
    }
  }
}
