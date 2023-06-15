package modelo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import interfaces.IAgenda;
import interfaces.IEmpleado;
import interfaces.IEmpresa;

public class Agenda implements IAgenda{
	//Atributos
	//private List<IContacto> contactos;
	
	private List<IEmpresa> empresas;

	//Metodos
	public Agenda() {
		//this.contactos = new LinkedList<>();
		this.empresas = new LinkedList<>();
		
	}

	@Override
	public List<IEmpresa> getEmpresas() {
		return empresas;
	}

	@Override
	public List<IEmpresa> getEmpresasOrdenadas() {
		List<IEmpresa> empresasOrdenadas = new LinkedList<>();

		empresasOrdenadas = empresas;

		Collections.sort(empresasOrdenadas, (o1, o2) -> o1.getNombreEmpresa().compareTo(o2.getNombreEmpresa()));
		
		return empresasOrdenadas;
	}

	public void subirEmpresa(Empresa e) {
		boolean existe=false;
		// comprobar si el contacto ya estaá en la lista
		for (IEmpresa empresa : empresas) {
			if (empresa.getNombreEmpresa().equalsIgnoreCase(e.getNombreEmpresa())) {
				existe=true;
			}
		}
		if(!existe) {
			empresas.add(e);
		}else {
			System.out.println("La empresa ya existe en la lista.");
		}
	}
	
	public void insertarEmpleadoEnEmpresa(Empresa e, Empleado emp) {
		int pos = empresas.indexOf(e);

		empresas.get(pos).agregaEmpleado(emp);
	}

	@Override
	public List<IEmpresa> empresasConMasDe20Empleados() {
		
		List <IEmpresa> empresasConMasDe20Empleados = new LinkedList<>();
		
		for (IEmpresa e : empresas) {
			if (e.getEmpleados().size() >= 20) {
				empresasConMasDe20Empleados.add(e);
			}
		}
		
		return empresasConMasDe20Empleados;
	}
	public int numeroEmpresasConMasDe20Empleados() {		
		return empresasConMasDe20Empleados().size();
	}


	public int numeroSubordinados(IEmpresa empresa, IEmpleado jefe) {
		// IDENTIFICA EN QUE POSICIÓN SE ENCUENTRA LA EMPESA EN NUESTRA LISTA DE EMPRESAS
		int pos = empresas.indexOf(empresa);
		
		// EN LA EMPRESA CONCRETADA SABER CUANTOS SUBORDINADOS TIENE UN JEFE
		return empresas.get(pos).cantidadDeSubordinadosDe(jefe.getapellidos());
	}
	
	public int menu() {
		int opcionElegida;
		Scanner sc = new Scanner(System.in);
		do {

			System.out.println("Elige Opcion:\n" + 
						"1.\tVer empresas\n" + 
						"2.\tCrear empresa\n" +
						"3.\tVer contacto\n" +
						"4.\tCrear contacto\n" +
						"5.\tMostrar Subordinados de Jefe santos\n" +
						"6.\tEmpresas a partir de 20 empleados\n" +
						"7.\tSalir del programa");
			opcionElegida = sc.nextInt();

			if (opcionElegida < 1 || opcionElegida > 7) {
				System.out.println("Error: Opcion no disponible (entre 1 y 7)");
			}

		} while (opcionElegida < 1 || opcionElegida > 7);
		return opcionElegida;
	}
	
	public String muestraEmpresas() {
		String res="";
		for (int i=0; i<empresas.size(); i++) {
			res+= (i+1) + "\t"+ empresas.get(i).getNombreEmpresa()+"\n";
		}
		return res;
	}
	
	public void buscarEmpleado(String alias) {
		boolean encontrado=false;
		for (IEmpresa empresa : empresas) {
			for (Empleado empleado : empresa.getEmpleados()) {
				if(empleado.getAlias().equalsIgnoreCase(alias)) {
					encontrado=true;
					System.out.println("Empresa "+empresa.getNombreEmpresa()+": "+empleado.toString());
				}
			}
		}
		
		if(!encontrado) {
			System.out.println("No se ha encontrado ningún empleado con ese alias \n");
		}else {
			System.out.println("\n");
		}
		
		
	}
	
}
