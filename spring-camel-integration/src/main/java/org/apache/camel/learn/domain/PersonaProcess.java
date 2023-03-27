package org.apache.camel.learn.domain;

import lombok.extern.log4j.Log4j2;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Log4j2
public class PersonaProcess implements Processor {

  @Override
  public void process(Exchange exchange) throws Exception {

    Persona persona = (Persona) exchange.getIn().getBody();
    log.info("Persona data: {}", persona.toString());
  }
}
