package interfaces;

import java.util.List;

import modelo.Empleado;

/**
 * 
 * Interfaz que almacenará información personal del contacto particular.
 * @author Moises Dominguez
 *
 */
public interface IEmpleado {
	/**
	 * Metodo que devuelve el nombre del empleado
	 * 
	 * @return String. retorna el nombre.
	 */
	public String getNombre();
	
	/**
	 * Metodo que devuelve los apellidos del empleado
	 * 
	 * @return String. retorna los apellidos.
	 */
	public String getapellidos();
	
	/**
	 * Metodo que devuelve el Jefe de los empleados.
	 * 
	 * @return Empleado. retorna el Jefe.
	 */
	public Empleado getJefe();
	
	/**
	 * Metodo que modifica el nombre del empleado
	 * 
	 * @param String. variable que modifica el nombre del empleado.
	 */
	public void setNombre(String nombre);
	
	/**
	 * Metodo que modifica los apellidos del empleado
	 * 
	 * @param String. variable que modifica los apellidos del empleado.
	 */
	public void setApellidos(String apellidos);
	
	/**
	 * Metodo que modifica el Jefe de los empleados.
	 * 
	 * @param Empleado. retorna el Jefe.
	 */
	public void setJefe(Empleado jefe);
	
	public String toString();
}
