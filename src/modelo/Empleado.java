package modelo;

import interfaces.IEmpleado;

public class Empleado extends Contacto implements IEmpleado {
	//Atributos
	private String nombre;
	private String apellidos;
	private Empleado jefe;
	
	//Metodos
	public Empleado() {
		super();
		this.nombre = null;
		this.apellidos = null;
		this.jefe = null;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getapellidos() {
		return apellidos;
	}

	@Override
	public Empleado getJefe() {
		return jefe;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	@Override
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
		
	}

	@Override
	public void setJefe(Empleado jefe) {
		this.jefe = jefe;		
	}

	@Override
	public String toString() {
		return "Empleado "+getAlias().toUpperCase()+": " + nombre + " " + apellidos + " Tlf: "+ getTelefono() + " Email: " + getCorreo();
	}
	
	
	
}
