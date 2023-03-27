package org.apache.camel.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.learn.domain.Persona;
import org.apache.camel.learn.domain.ValidateProfile;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

  JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(Persona.class);

  @Override
  public void configure() throws Exception {

    from("direct:updateAll").routeId("actualizarTerceros").process(new ValidateProfile())
        .marshal(jacksonDataFormat).multicast()
        .choice()
          .when(header("isDigital").contains("true"))
            .to("rest:put:/persona?host=localhost:5000").log("Camino por el servicio en python")
        .otherwise()
          .to("rest:put:/Persona?host=localhost:5011")
          .log("Camino por el servicio netCore").end();
  }
}
