package interfaces;

import java.util.List;

import modelo.Empleado;

/**
 * 
 * La interfaz Empresa, almacenará información laboral de la empresa en cuestión
 * @author Moises Dominguez
 *
 */
public interface IEmpresa {

	/**
	 * Metodo que devuelve el nombre de la empresa
	 * 
	 * @return String. retorna el nombre de la empresa.
	 */
	public String getNombreEmpresa();
	
	/**
	 * Metodo que devuelve la pagina web de la empresa
	 * 
	 * @return String. retorna la web de la empresa.
	 */
	public String getPaginaWeb();
	
	/**
	 * Metodo que devuelve el nombre del contacto de la empresa
	 * 
	 * @return String. retorna el nombre del contacto de la empresa.
	 */
	public String getNombreContacto();
	
	/**
	 * Metodo que devuelve una lista con los empleaados de la empresa
	 * 
	 * @return List<Empleado>. devuelve una lista de empleados.
	 */
	public List<Empleado> getEmpleados();
	
	/**
	 * Metodo que modifica el nombre de la empresa
	 * 
	 * @param String. contiene la variable que modifica el nombre de la empresa.
	 */
	public void setNombreEmpresa(String nombreEmpresa);
	
	/**
	 * Metodo que modifica la pagina web de la empresa
	 * 
	 * @param String. contiene variable ue modifica la web de la empresa.
	 */
	public void setPaginaWeb(String paginaWeb);
	
	/**
	 * Metodo que modifica el nombre del contacto de la empresa
	 * 
	 * @param String. variable que modifica el nombre del contacto de la empresa.
	 */
	public void setNombreContacto(String nombreContacto);
	
	/**
	 * Metodo que agrega un empleado a la lista de empleados de la empresa
	 * 
	 * @param Empleado. agrega el empleado a la lista de empleados.
	 */
	public void agregaEmpleado(Empleado e);
	
	/**
	 * Metodo que elimina un empleado de la lista de empleados de la empresa
	 * 
	 * @param Empleado. elimina el empleado de la lista de empleados.
	 */
	public void eliminaEmpleado(Empleado e);
	
	/**
	 * Metodo que devuelve el numero de empleados que tenga la empresa cuyo jefe se apellide Santos.
	 *@return int. variable que contiene el numero de subordinados que tenga la empresa cuyo jefe se apellide Santos
	 */
	public int subordinadosSeñorSantos();
	
	/**
	 * GENERALIZACION DEL ANTERIOR METODO
	 * Metodo que devuelve el numero de empleados que tenga la empresa cuyo jefe se apellide dado por parametro.
	 *@return int. variable que contiene el numero de subordinados que tenga la empresa cuyo jefe se apellide igual que el parametro
	 */
	public int cantidadDeSubordinadosDe(String apellido);

	/**
	 * Metodo que devuelve el texto para mostrar con la información de la empresa
	 * @return String. Variable de texto
	 */
	public String toString();
	
	/**
	 * Metodo que devuelve el texto con todos los empleados de la empresa
	 * @return String. Variable de texto
	 */
	public String muestraEmpleados();
	
	
	
}
