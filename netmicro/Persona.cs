namespace netmicro;

public class Persona {

  public Persona(int codigo, string nombres, string direccion, string identificacion, int pago){
    this.pago = pago;
    this.codigo = codigo;
    this.nombres = nombres;
    this.direccion = direccion;
    this.identificacion = identificacion;
  }

  
  public int pago {get;set;}
  public int codigo {get;set;}
  public String nombres {get;set;}
  public String direccion {get;set;}
  public String identificacion {get;set;}
}