package hei.prog.app.endpoint.rest.controller.arith;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import hei.prog.app.exception.BadRequestException;
import hei.prog.app.service.ArithService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArithController.class)
@DisplayName("ArithController tests")
class ArithControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private ArithService arithService;

  @Test
  @DisplayName("GET /add should return sum")
  void add() throws Exception {

    when(arithService.add(10.0, 3.0)).thenReturn(13.0);

    mockMvc
        .perform(get("/add").param("a", "10.0").param("b", "3.0"))
        .andExpect(status().isOk())
        .andExpect(content().string("13.0"));
  }

  @Test
  @DisplayName("GET /sub should return subtraction result")
  void sub() throws Exception {

    when(arithService.sub(10.0, 4.0)).thenReturn(6.0);

    mockMvc
        .perform(get("/sub").param("a", "10.0").param("b", "4.0"))
        .andExpect(status().isOk())
        .andExpect(content().string("6.0"));
  }

  @Test
  @DisplayName("GET /mul should return multiplication result")
  void mul() throws Exception {

    when(arithService.mul(2.0, -3.0)).thenReturn(-6.0);

    mockMvc
        .perform(get("/mul").param("a", "2.0").param("b", "-3.0"))
        .andExpect(status().isOk())
        .andExpect(content().string("-6.0"));
  }

  @Test
  @DisplayName("GET /div should return division result")
  void div() throws Exception {

    when(arithService.div(8.0, 2.0)).thenReturn(4.0);

    mockMvc
        .perform(get("/div").param("a", "8.0").param("b", "2.0"))
        .andExpect(status().isOk())
        .andExpect(content().string("4.0"));
  }

  @Test
  @DisplayName("GET /add should return 400 when param missing")
  void missing_param_add() throws Exception {

    mockMvc.perform(get("/add").param("a", "10.0")).andExpect(status().isBadRequest());
  }

  @Test
  @DisplayName("GET /div should return 400 when param missing")
  void missing_param_div() throws Exception {

    mockMvc.perform(get("/div").param("a", "10.0")).andExpect(status().isBadRequest());
  }

  @Test
  void invalid_b() throws Exception {

    when(arithService.div(10.0, 0.0))
        .thenThrow(new BadRequestException("Division by zero is not allowed"));

    mockMvc
        .perform(get("/div").param("a", "10.0").param("b", "0.0"))
        .andExpect(status().isBadRequest());
  }
}
