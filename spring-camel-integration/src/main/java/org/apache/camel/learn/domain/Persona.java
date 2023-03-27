package org.apache.camel.learn.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {

  String direccion;
  String nombres;
  String identificacion;
  int codigo;
  int pago;

  @Override
  public String toString() {
    return String.format("Nombre: %s, Direccion: %s, Identificacion: %s, Codigo: %s", nombres,
        direccion, identificacion, codigo);
  }
}
