using Microsoft.AspNetCore.Mvc;

namespace netmicro.Controllers;

[ApiController]
[Route("[controller]")]
public class PersonaController : ControllerBase {
  private readonly ILogger<PersonaController> _logger;
  static List<Persona> personas = new List<Persona> (){new Persona(12345, "Fred", "QUITO", "172xxxx", 33)};

  public PersonaController (ILogger<PersonaController> logger) {
    _logger = logger;
  }

  [HttpGet(Name = "GetPersonas")]
  public IEnumerable<Persona> Get(){
    return personas.ToArray();
  }

  [HttpPut(Name = "UpdatePersona")]
  public string Put(Persona persona){
    foreach(Persona p in personas){
      if (p.codigo == persona.codigo) {
        p.pago = persona.pago;
      }
    }
    return "OK";
  }
}