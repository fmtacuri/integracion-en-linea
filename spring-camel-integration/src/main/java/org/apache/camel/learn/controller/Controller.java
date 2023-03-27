package org.apache.camel.learn.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private ProducerTemplate template;

  @PostMapping(value = "/actualizar-clientes")
  public String crearTerceros() {
    return template.requestBody("direct:crearAll", "").toString();
  }
}
