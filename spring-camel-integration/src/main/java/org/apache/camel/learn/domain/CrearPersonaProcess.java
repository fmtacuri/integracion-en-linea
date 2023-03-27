package org.apache.camel.learn.domain;

import lombok.extern.log4j.Log4j2;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Log4j2
public class CrearPersonaProcess implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    log.info("Crear persona");
    Persona persona = Persona.builder().codigo(1955).direccion("UI").nombres("User")
        .identificacion("17xxx").build();
    log.info("Persona data: {}", persona.toString());
    exchange.getIn().setBody(persona);
  }
}
