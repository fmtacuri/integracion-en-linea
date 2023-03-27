package org.apache.camel.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.learn.domain.CrearPersonaProcess;
import org.apache.camel.learn.domain.Persona;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

  JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(Persona.class);

  @Override
  public void configure() throws Exception {
    from("direct:crearAll").routeId("crearEnTerceros").process(new CrearPersonaProcess())
        .marshal(jacksonDataFormat)
        .multicast()
        .parallelProcessing()
        .to("rest:post:/persona?host=localhost:5000", "rest:post:/Persona?host=localhost:5011")
        .to("log:foo");

    from("timer:hello?period={{timer.period}}").routeId("hello")
        .transform().method("myBean", "saySomething")
        .filter(simple("${body} contains 'foo'"))
        .to("log:foo")
        .end()
        .to("stream:out");
  }
}
