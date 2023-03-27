package org.apache.camel.learn.domain;

import lombok.extern.log4j.Log4j2;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Log4j2
public class ValidateProfile implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {
    log.info("Actualizar persona");
    Persona persona = exchange.getIn().getBody(Persona.class);
    log.info("Persona data: {}", persona.toString());
    exchange.getIn().setHeader("isDigital", persona.getPago() < 1000);
  }
}
