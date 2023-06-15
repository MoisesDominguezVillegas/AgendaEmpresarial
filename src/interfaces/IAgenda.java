package interfaces;

import java.util.List;

import modelo.Contacto;
import modelo.Empleado;
import modelo.Empresa;


/**
 * Interfaz que modela el comportamiento de la app de una Agenda Empresarial.
 * Contendra un listado de los contactos de dicha empresa.
 * 
 * Esta interfaz estará encargada de gestionar todas las clases y de reunir
 * todos los contactos en una lista determinada con capacidad para mostrar
 * distintas opciones en forma de menú.
 * 
 * @author Moises Dominguez
 *
 */

public interface IAgenda {

	/**
	 * Metodo que devuelve el listado completo de todas las
	 * empresas registradas en nuestra agenda empresarial.
	 * 
	 * @return List<IEmpresa>. Lista de todas las empresas registradas.
	 */
	public List<IEmpresa> getEmpresas();
	
	/**
	 * Metodo que devuelve el listado completo de todas las empresas registradas en la agenda y ordenados.
	 * 
	 * Los contactos serán devueltos ordenados por su alias en orden ascendente.
	 *  
	 * @return List<IEmpresa>. Lista de las empresas registradas y ordenadas.
	 */
	public List<IEmpresa> getEmpresasOrdenadas();
	
	/**
	 * Metodo utilizado para añadir un empleado en una empresa de la agenda.
	 * 
	 * @param Empresa e. Empresa donde se quiere almacenar. 
	 * @param Empleado emp. Empleado que se quiere almacenar. 
	 *  
	 */
	
	public void insertarEmpleadoEnEmpresa(Empresa e, Empleado emp);
	/**
	 * Metodo utilizado para añadir una nueva empresa en la agenda. 
	 * Es decir, el contacto que se registrara, tendra como informacion, el nombre pasado por parametro. 
	 * 
	 * @param Empresa e. Empresa que se quiere almacenar. 
	 *  
	 */
	
	public void subirEmpresa(Empresa e);

	/**
	 * Metodo que devuelve una lista con las empresas con más de 20 empleados.
	 * 
	 * @return List<Empresa>. contiene una lista que contiene las empresas que tengan más de 20 empleados. 
	 *  
	 */
	
	
	public List<IEmpresa> empresasConMasDe20Empleados();
	
	/**
	 * Metodo que devuelve número de empresas con más de 20 empleados.
	 * 
	 * @return List<Empresa>. contiene una lista que contiene las empresas que tengan más de 20 empleados. 
	 *  
	 */
	
	
	public int numeroEmpresasConMasDe20Empleados();
	
	
	
	/**
	 * Metodo que devuelve el numero de subordinados que tengan la empresa y el jefe que pasemos por parametro
	 * 
	 * @return int. variable que contiene el numero de subordinados que tengan la empresa y el jefe que pasemos por parametro
	 */
	
	public int numeroSubordinados(IEmpresa empresa, IEmpleado jefe);
	
	/**
	 * Devuelve la posición y nombre de la empresa almacenada en la lista de la agenda
	 * @return String. variable con la posicion y nombre
	 */
	public String muestraEmpresas();
}
