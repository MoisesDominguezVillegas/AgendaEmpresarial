package modelo;

import java.util.LinkedList;
import java.util.List;

import interfaces.IEmpresa;

public class Empresa implements IEmpresa{
	

	//Atributos
	private String nombreEmpresa;
	private String paginaWeb;
	private String nombreContacto;
	private List<Empleado> empleados;
	
	//Metodos
	public Empresa() {
		super();
		this.nombreEmpresa = null;
		this.paginaWeb = null;
		this.nombreContacto = null;
		this.empleados = new LinkedList<>();
	}

	@Override
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	@Override
	public String getPaginaWeb() {
		return paginaWeb;
	}

	@Override
	public String getNombreContacto() {
		return nombreContacto;
	}

	@Override
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	@Override
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
		
	}

	@Override
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
		
	}

	@Override
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
		
	}

	@Override
	public void agregaEmpleado(Empleado e) {
		boolean existe=false;
		for (Empleado empleado : empleados) {
			if(empleado.getNombre().equalsIgnoreCase(e.getNombre())) {
				existe=true;
			}
		}
		if(!existe) {			
			empleados.add(e);		
		}
	}

	@Override
	public void eliminaEmpleado(Empleado e) {
		empleados.remove(e);		
	}

	// SABER CUANTOS SUBORDINADOS TIENE UN APELLIDO EN CONCRETO
	public int cantidadDeSubordinadosDe(String apellido) {
		int cantidad=0;
		
		for (Empleado empleado : empleados) {
			if(empleado.getJefe()!=null && empleado.getJefe().getapellidos().equalsIgnoreCase(apellido)) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	// SABER CUANTOS SUBORDINADOS TIENE UN APELLIDO SANTOS
	public int subordinadosSeñorSantos() {
		return cantidadDeSubordinadosDe("santos");
	}
	
	@Override
	public String toString() {
		return nombreEmpresa.toUpperCase() + "\n\t Web " + paginaWeb + "\n\t Contacto Principal "
				+ nombreContacto + "\n\t Empleados " + empleados.size() + "\n" + muestraEmpleados();
	}
	
	public String muestraEmpleados() {
		String res="";
		for (Empleado empleado : empleados) {
			res += empleado.toString()+"\n"; 
		}
		return res;
	}
	
	
}
