package testeo;

import java.util.Scanner;

import interfaces.IEmpresa;
import modelo.Agenda;
import modelo.Empleado;
import modelo.Empresa;

public class Main {

	public static void main(String[] args) {
		Agenda agenda=new Agenda();
		Scanner sc = new Scanner(System.in);
		
		// UNOS DATOS PARA LA AGENDA
		crearDatosEjemplo(agenda);
		
		int opcion=-1;
		while(opcion!=5) {
	
			opcion = agenda.menu();
			
			switch (opcion){
				
			case 1: // VER EMPRESA
				int empresaEscogida=-1;
				do {
					System.out.println("*******EMPRESAS DE LA AGENDA*******");
				System.out.println(agenda.muestraEmpresas());
					System.out.println("Selecciona empresa");
					empresaEscogida = sc.nextInt();
				}while(empresaEscogida<0 || empresaEscogida>=agenda.getEmpresas().size());
				
				System.out.println(agenda.getEmpresas().get(empresaEscogida).toString());
				
				break;
				
			case 2: // CREAR EMPRESA
				String nombreEmpresa="";
				String paginaWeb="";
				String nombreContacto="";
				System.out.println("*******CREAR EMPRESA*******");
				// pedir nombre Empresa
				do {
					sc.nextLine();
					System.out.println("Introduce el nombre de la empresa");
					nombreEmpresa=sc.nextLine();
				}while(nombreEmpresa=="");
				
				// pedir web Empresa, puede no tener web				
				System.out.println("Introduce la web de la empresa");
				paginaWeb=sc.nextLine();
				
				// pedir nombre del contacto principal de la Empresa
				do {
					System.out.println("Introduce el nombre del contacto principal");
					nombreContacto=sc.nextLine();
				}while(nombreContacto=="");
				
				Empresa e=new Empresa();
				e.setNombreEmpresa(nombreEmpresa);
				e.setPaginaWeb(paginaWeb);
				e.setNombreContacto(nombreContacto);
				
				agenda.subirEmpresa(e);
				
				break;
				
			case 3: // VER CONTACTO
				String aliasBuscado="";
				// pedir nombre empleado
				System.out.println("*******BUSCAR UN CONTACTO*******");
				do {
					sc.nextLine();
					System.out.println("Introduce el alias del empleado que buscas ");
					aliasBuscado=sc.nextLine();
				}while(aliasBuscado=="");
				
				agenda.buscarEmpleado(aliasBuscado);
				
				break;
				
			case 4: // CREAR CONTACTO
				sc = new Scanner(System.in);
				empresaEscogida=-1;
				do {
					System.out.println("*******REGISTRAR UN CONTACTO EN EMPRESA*******");
					System.out.println(agenda.muestraEmpresas());
					System.out.println("Selecciona empresa");
					empresaEscogida = sc.nextInt();
				}while(empresaEscogida<0 || empresaEscogida>=agenda.getEmpresas().size());
				
				String alias="";
				String nombre="";
				String apellido="";
				String correo="";
				Boolean favorito=false;
				String telefono="";
				
				do {
					sc = new Scanner(System.in);
					System.out.println("Introduce el alias del empleado:");
					alias=sc.nextLine();
				}while(alias=="");
				
				do {
					sc = new Scanner(System.in);
					System.out.println("Introduce el nombre del empleado:");
					nombre=sc.nextLine();
				}while(nombre=="");
				
				do {
					sc = new Scanner(System.in);
					System.out.println("Introduce el apellido del empleado:");
					apellido=sc.nextLine();
				}while(apellido=="");
				
				do {
					sc = new Scanner(System.in);
					System.out.println("Introduce el correo del empleado:");
					correo=sc.nextLine();
				}while(correo=="");
				
				String favoritoString="F";
				do {
					sc = new Scanner(System.in);
					System.out.println("Es favorito el empleado V/F: ");
					favoritoString=sc.nextLine();
				}while(!favoritoString.equalsIgnoreCase("F") && !favoritoString.equalsIgnoreCase("V"));
				if(favoritoString.equalsIgnoreCase("V")) {
					favorito=true;
				}
				
				do {
					sc = new Scanner(System.in);
					System.out.println("Introduce el telefono del empleado:");
					telefono=sc.nextLine();
				}while(telefono=="");
				
				
				Empleado emp = new Empleado();
				emp.setAlias(alias);
				emp.setNombre(nombre);
				emp.setApellidos(apellido);
				emp.setCorreo(correo);
				emp.setFavorito(favorito);
				emp.setTelefono(telefono);
				
				agenda.getEmpresas().get(empresaEscogida).agregaEmpleado(emp);
				
				break;
				
			case 5:
				System.out.println("*******MOSTRAR SUBORDINADOS DE SANTOS*******");
				int total=0;
				for (IEmpresa empresa : agenda.getEmpresas()) {
					total+=empresa.subordinadosSeñorSantos();
				}
				System.out.println("Santos tiene "+total+" subordinados");
				break;
				
			case 6:
				System.out.println("*******EMPRESAS A PARTIR DE 20 EMPLEADOS*******");
				for (IEmpresa empresa : agenda.getEmpresas()) {
					System.out.println(empresa.getNombreEmpresa()+"("+empresa.getEmpleados().size()+")");
				}
				System.out.println("\n");
				
				System.out.println("Existen "+ agenda.numeroEmpresasConMasDe20Empleados()+" empresas a partir de 20 empleados\n");
				break;
				
			case 7: // SALIR
				System.out.println("Hasta pronto");
				break;
			}
		}

	}
	
	public static void crearDatosEjemplo(Agenda agenda) {
		// CREAR LA EMPRESA
				Empresa e1=new Empresa();
				e1.setNombreEmpresa("Microsoft");
				e1.setNombreContacto("Pepito");
				e1.setPaginaWeb("www.microsoft.es");
				
				// MICROSOFT
				Empleado emp1 = new Empleado();
				emp1.setAlias("Moi");
				emp1.setNombre("Moises");
				emp1.setApellidos("Domínguez");
				emp1.setCorreo("moisesDominguezVillegas@gmail.com");
				emp1.setFavorito(true);
				emp1.setTelefono("666666666");
				e1.agregaEmpleado(emp1);
				
				Empleado emp2=new Empleado();
				emp2.setAlias("Ana");
				emp2.setNombre("Ana");
				emp2.setApellidos("García");
				emp2.setCorreo("ana@gmail.com");
				emp2.setFavorito(true);
				emp2.setTelefono("777777777");
				emp2.setJefe(emp1);
				e1.agregaEmpleado(emp2);
				
				Empleado emp3=new Empleado();
				emp3.setAlias("Glor");
				emp3.setNombre("Gloria");
				emp3.setApellidos("Jiménez Mendoza");
				emp3.setCorreo("gloria@gmail.com");
				emp3.setFavorito(false);
				emp3.setTelefono("755555555");
				emp3.setJefe(emp1);
				e1.agregaEmpleado(emp3);
			
				agenda.subirEmpresa(e1);

				// CREAR LA EMPRESA
				Empresa e2=new Empresa();
				e2.setNombreEmpresa("Iberia");
				e2.setNombreContacto("Noe");
				e2.setPaginaWeb("www.iberia.com");
				
				// IBERIA
				Empleado emp4=new Empleado();
				emp4.setAlias("Pepe");
				emp4.setNombre("Jose");
				emp4.setApellidos("Villarin");
				emp4.setCorreo("villarinjose@gmail.com");
				emp4.setFavorito(true);
				emp4.setTelefono("888888888");
				e2.agregaEmpleado(emp4);
				
				
				Empleado emp5=new Empleado();
				emp5.setAlias("Noe");
				emp5.setNombre("Noelia");
				emp5.setApellidos("villarin");
				emp5.setCorreo("noevillarin@gmail.com");
				emp5.setFavorito(true);
				emp5.setTelefono("111111111");
				emp5.setJefe(emp4);
				e2.agregaEmpleado(emp5);
				
				Empleado emp6=new Empleado();
				emp6.setAlias("Marta");
				emp6.setNombre("Marta");
				emp6.setApellidos("Rodriguez");
				emp6.setCorreo("marta@gmail.com");
				emp6.setFavorito(false);
				emp6.setTelefono("755235567");
				emp6.setJefe(emp4);
				e2.agregaEmpleado(emp6);
			
				agenda.subirEmpresa(e2);


				// CREAR LA EMPRESA
				Empresa e3=new Empresa();
				e3.setNombreEmpresa("NTT-DATA");
				e3.setNombreContacto("Rodrigo");
				e3.setPaginaWeb("www.everis.com");
				
				// NTT-DATA
				Empleado emp7=new Empleado();
				emp7.setAlias("Cesar");
				emp7.setNombre("Cesar");
				emp7.setApellidos("Santos");
				emp7.setCorreo("santoscesar@gmail.com");
				emp7.setFavorito(true);
				emp7.setTelefono("662354666");
				e3.agregaEmpleado(emp7);
				
				
				Empleado emp8=new Empleado();
				emp8.setAlias("Juli");
				emp8.setNombre("Julia");
				emp8.setApellidos("García");
				emp8.setCorreo("juliagarcia@gmail.com");
				emp8.setFavorito(true);
				emp8.setTelefono("000000123");
				emp8.setJefe(emp7);
				e3.agregaEmpleado(emp8);
				
				Empleado emp9=new Empleado();
				emp9.setAlias("Lucas");
				emp9.setNombre("Lucas");
				emp9.setApellidos("Sanz");
				emp9.setCorreo("lucassanz@gmail.com");
				emp9.setFavorito(false);
				emp9.setTelefono("767245060");
				emp9.setJefe(emp7);
				e3.agregaEmpleado(emp9);
			
				agenda.subirEmpresa(e3);


				// CREAR LA EMPRESA
				Empresa e4=new Empresa();
				e4.setNombreEmpresa("Deloitte");
				e4.setNombreContacto("Paco");
				e4.setPaginaWeb("www.deloitte.es");
				
				// DELOITTE
				Empleado emp10=new Empleado();
				emp10.setAlias("Bequi");
				emp10.setNombre("Rebeca");
				emp10.setApellidos("Aguilar");
				emp10.setCorreo("rebecagarciaaguilar@gmail.com");
				emp10.setFavorito(true);
				emp10.setTelefono("668761297");
				e4.agregaEmpleado(emp10);
				
				
				Empleado emp11=new Empleado();
				emp11.setAlias("Lara");
				emp11.setNombre("Isabel Lara");
				emp11.setApellidos("Lara");
				emp11.setCorreo("doñalara@gmail.com");
				emp11.setFavorito(true);
				emp11.setTelefono("777220098");
				emp11.setJefe(emp10);
				e4.agregaEmpleado(emp11);
				
				Empleado emp12=new Empleado();
				emp12.setAlias("luni");
				emp12.setNombre("Luna");
				emp12.setApellidos("Pereira");
				emp12.setCorreo("lunaa@gmail.com");
				emp12.setFavorito(false);
				emp12.setTelefono("755672455");
				emp12.setJefe(emp10);
				e4.agregaEmpleado(emp12);


				Empleado emp13=new Empleado();
				emp13.setAlias("Jastin");
				emp13.setNombre("Jacinta");
				emp13.setApellidos("Dominguez");
				emp13.setCorreo("jacinta@gmail.com");
				emp13.setFavorito(true);
				emp13.setTelefono("712220098");
				emp13.setJefe(emp10);
				e4.agregaEmpleado(emp13);
				
				Empleado emp14=new Empleado();
				emp14.setAlias("Ely");
				emp14.setNombre("Elisea");
				emp14.setApellidos("Villegas");
				emp14.setCorreo("e.villegas@gmail.com");
				emp14.setFavorito(false);
				emp14.setTelefono("953772255");
				emp14.setJefe(emp10);
				e4.agregaEmpleado(emp14);

				Empleado emp15=new Empleado();
				emp15.setAlias("Iva");
				emp15.setNombre("Ivan");
				emp15.setApellidos("Polvillo");
				emp15.setCorreo("polivan@gmail.com");
				emp15.setFavorito(true);
				emp15.setTelefono("740210298");
				emp15.setJefe(emp10);
				e4.agregaEmpleado(emp15);
				
				Empleado emp16=new Empleado();
				emp16.setAlias("Alexis");
				emp16.setNombre("Alejandro");
				emp16.setApellidos("Jiménez");
				emp16.setCorreo("jimeneale@gmail.com");
				emp16.setFavorito(false);
				emp16.setTelefono("759542455");
				emp16.setJefe(emp10);
				e4.agregaEmpleado(emp16);
			
				Empleado emp17=new Empleado();
				emp17.setAlias("Mosto");
				emp17.setNombre("Andreix");
				emp17.setApellidos("Mostovoi");
				emp17.setCorreo("andreim@gmail.com");
				emp17.setFavorito(false);
				emp17.setTelefono("764720098");
				emp17.setJefe(emp10);
				e4.agregaEmpleado(emp17);
				
				Empleado emp18=new Empleado();
				emp18.setAlias("Adri");
				emp18.setNombre("Adriano");
				emp18.setApellidos("Aguado");
				emp18.setCorreo("adrianoaguadod@gmail.com");
				emp18.setFavorito(true);
				emp18.setTelefono("715370415");
				emp18.setJefe(emp10);
				e4.agregaEmpleado(emp18); 
				
				Empleado emp19=new Empleado();
				emp19.setAlias("Martina");
				emp19.setNombre("Martina");
				emp19.setApellidos("Dominguez");
				emp19.setCorreo("domartina@gmail.com");
				emp19.setFavorito(true);
				emp19.setTelefono("612980291");
				emp19.setJefe(emp10);
				e4.agregaEmpleado(emp19);
				
				Empleado emp20=new Empleado();
				emp20.setAlias("Alba");
				emp20.setNombre("Alba");
				emp20.setApellidos("Trasto");
				emp20.setCorreo("altrast@gmail.com");
				emp20.setFavorito(true);
				emp20.setTelefono("651672405");
				emp20.setJefe(emp10);
				e4.agregaEmpleado(emp20);


				Empleado emp21=new Empleado();
				emp21.setAlias("Sandra");
				emp21.setNombre("Sandra");
				emp21.setApellidos("Martinez");
				emp21.setCorreo("sandritama@gmail.com");
				emp21.setFavorito(true);
				emp21.setTelefono("615823193");
				emp21.setJefe(emp10);
				e4.agregaEmpleado(emp21);
				
				Empleado emp22=new Empleado();
				emp22.setAlias("Raul");
				emp22.setNombre("Raul");
				emp22.setApellidos("Cortes");
				emp22.setCorreo("r.cortes@gmail.com");
				emp22.setFavorito(false);
				emp22.setTelefono("953712151");
				emp22.setJefe(emp10);
				e4.agregaEmpleado(emp22);

				Empleado emp23=new Empleado();
				emp23.setAlias("Carmelo");
				emp23.setNombre("Carmelo");
				emp23.setApellidos("Dominguez");
				emp23.setCorreo("domcar@gmail.com");
				emp23.setFavorito(true);
				emp23.setTelefono("644212296");
				emp23.setJefe(emp10);
				e4.agregaEmpleado(emp23);
				
				Empleado emp24=new Empleado();
				emp24.setAlias("Jose");
				emp24.setNombre("Jose Miguel");
				emp24.setApellidos("Carrascosa");
				emp24.setCorreo("jcarro@gmail.com");
				emp24.setFavorito(false);
				emp24.setTelefono("927502115");
				emp24.setJefe(emp10);
				e4.agregaEmpleado(emp24);
			
				Empleado emp25=new Empleado();
				emp25.setAlias("Tronco");
				emp25.setNombre("Tron");
				emp25.setApellidos("pereirez");
				emp25.setCorreo("ttronco@gmail.com");
				emp25.setFavorito(true);
				emp25.setTelefono("864721395");
				emp25.setJefe(emp10);
				e4.agregaEmpleado(emp25);
				
				Empleado emp26=new Empleado();
				emp26.setAlias("ruben");
				emp26.setNombre("Ruben");
				emp26.setApellidos("Paez");
				emp26.setCorreo("r.paez@gmail.com");
				emp26.setFavorito(true);
				emp26.setTelefono("625068413");
				emp26.setJefe(emp10);
				e4.agregaEmpleado(emp26);                                                      

				
				Empleado emp27=new Empleado();
				emp27.setAlias("Juan");
				emp27.setNombre("Juan");
				emp27.setApellidos("Garcia");
				emp27.setCorreo("jalejandro@gmail.com");
				emp27.setFavorito(false);
				emp27.setTelefono("000000000");
				emp27.setJefe(emp10);
				e4.agregaEmpleado(emp27);
				
				Empleado emp28=new Empleado();
				emp28.setAlias("Montse");
				emp28.setNombre("Montse");
				emp28.setApellidos("Guardado");
				emp28.setCorreo("mguarda@gmail.com");
				emp28.setFavorito(false);
				emp28.setTelefono("755671547");
				emp28.setJefe(emp10);
				e4.agregaEmpleado(emp28);


				Empleado emp29=new Empleado();
				emp29.setAlias("Agus");
				emp29.setNombre("Agustin");
				emp29.setApellidos("Sanchez");
				emp29.setCorreo("sanchezgaagus@gmail.com");
				emp29.setFavorito(true);
				emp29.setTelefono("911356641");
				emp29.setJefe(emp10);
				e4.agregaEmpleado(emp29);
				
				Empleado emp30=new Empleado();
				emp30.setAlias("Pilar");
				emp30.setNombre("Pilar");
				emp30.setApellidos("Alegre");
				emp30.setCorreo("palegre@gmail.com");
				emp30.setFavorito(true);
				emp30.setTelefono("953002165");
				emp30.setJefe(emp10);
				e4.agregaEmpleado(emp30);

				Empleado emp31=new Empleado();
				emp31.setAlias("Carro");
				emp31.setNombre("Jose Antonio");
				emp31.setApellidos("Carrasco");
				emp31.setCorreo("jcarrasco@gmail.com");
				emp31.setFavorito(true);
				emp31.setTelefono("741546329");
				emp31.setJefe(emp10);
				e4.agregaEmpleado(emp31);
				
				Empleado emp32=new Empleado();
				emp32.setAlias("Puri");
				emp32.setNombre("Maria");
				emp32.setApellidos("Fernandez");
				emp32.setCorreo("mpuri@gmail.com");
				emp32.setFavorito(true);
				emp32.setTelefono("653520255");
				emp32.setJefe(emp10);
				e4.agregaEmpleado(emp32);
			
				Empleado emp33=new Empleado();
				emp33.setAlias("Norberto");
				emp33.setNombre("Andrei");
				emp33.setApellidos("Mostovoi");
				emp33.setCorreo("andreim@gmail.com");
				emp33.setFavorito(false);
				emp33.setTelefono("764720098");
				emp33.setJefe(emp10);
				e4.agregaEmpleado(emp33);
				
				Empleado emp34=new Empleado();
				emp34.setAlias("Adria");
				emp34.setNombre("Adrian");
				emp34.setApellidos("Aguado");
				emp34.setCorreo("adrianaguadod@gmail.com");
				emp34.setFavorito(true);
				emp34.setTelefono("715370415");
				emp34.setJefe(emp10);
				e4.agregaEmpleado(emp34);                                                          
				
				Empleado emp35=new Empleado();
				emp35.setAlias("Pablo");
				emp35.setNombre("Pablo");
				emp35.setApellidos("Ruiz");
				emp35.setCorreo("p.ruiz@gmail.com");
				emp35.setFavorito(true);
				emp35.setTelefono("665101239");
				emp35.setJefe(emp10);
				e4.agregaEmpleado(emp35);
				
				Empleado emp36=new Empleado();
				emp36.setAlias("Ivano");
				emp36.setNombre("Ivano");
				emp36.setApellidos("Santos");
				emp36.setCorreo("santosiv@gmail.com");
				emp36.setFavorito(true);
				emp36.setTelefono("767245060");
				emp36.setJefe(emp10);
				e4.agregaEmpleado(emp36);
			
				agenda.subirEmpresa(e4);

				// CREAR LA EMPRESA
				Empresa e5=new Empresa();
				e5.setNombreEmpresa("consultora");
				e5.setNombreContacto("Joaquin");
				e5.setPaginaWeb("www.consultora.es");
				
				// CONSULTORA
				Empleado emp37=new Empleado();
				emp37.setAlias("Rosario");
				emp37.setNombre("Maria del Rosario");
				emp37.setApellidos("Santos");
				emp37.setCorreo("mrosario@gmail.com");
				emp37.setFavorito(true);
				emp37.setTelefono("668761297");
				e5.agregaEmpleado(emp37);
				
				
				Empleado emp38=new Empleado();
				emp38.setAlias("Joaquin");
				emp38.setNombre("Joaquin");
				emp38.setApellidos("Giraldez");
				emp38.setCorreo("jgiraldez@gmail.com");
				emp38.setFavorito(true);
				emp38.setTelefono("777220098");
				emp38.setJefe(emp37);
				e5.agregaEmpleado(emp38);
				
				Empleado emp39=new Empleado();
				emp39.setAlias("Toni");
				emp39.setNombre("Antonio");
				emp39.setApellidos("Regino");
				emp39.setCorreo("aregino@gmail.com");
				emp39.setFavorito(false);
				emp39.setTelefono("755672455");
				emp39.setJefe(emp37);
				e5.agregaEmpleado(emp39);


				Empleado emp40=new Empleado();
				emp40.setAlias("Lapiz");
				emp40.setNombre("Sergio");
				emp40.setApellidos("Dominguez");
				emp40.setCorreo("sergiodom@gmail.com");
				emp40.setFavorito(true);
				emp40.setTelefono("712220098");
				emp40.setJefe(emp37);
				e5.agregaEmpleado(emp40);
				
				Empleado emp41=new Empleado();
				emp41.setAlias("Pollo");
				emp41.setNombre("Myriam");
				emp41.setApellidos("Dominguez");
				emp41.setCorreo("m.dominguez@gmail.com");
				emp41.setFavorito(true);
				emp41.setTelefono("953772255");
				emp41.setJefe(emp37);
				e5.agregaEmpleado(emp41);

				Empleado emp42=new Empleado();
				emp42.setAlias("Caco");
				emp42.setNombre("Ivan");
				emp42.setApellidos("Dominguez");
				emp42.setCorreo("dominguezivan@gmail.com");
				emp42.setFavorito(true);
				emp42.setTelefono("740210298");
				emp42.setJefe(emp37);
				e5.agregaEmpleado(emp42);
				
				Empleado emp43=new Empleado();
				emp43.setAlias("Jose");
				emp43.setNombre("Jose");
				emp43.setApellidos("Dominguez");
				emp43.setCorreo("dom.j@gmail.com");
				emp43.setFavorito(true);
				emp43.setTelefono("759542455");
				emp43.setJefe(emp37);
				e5.agregaEmpleado(emp43);
			
				Empleado emp44=new Empleado();
				emp44.setAlias("Chico");
				emp44.setNombre("Moises");
				emp44.setApellidos("Dominguez");
				emp44.setCorreo("chiquim@gmail.com");
				emp44.setFavorito(true);
				emp44.setTelefono("615662577");
				emp44.setJefe(emp37);
				e5.agregaEmpleado(emp44);
				
				Empleado emp45=new Empleado();
				emp45.setAlias("Espe");
				emp45.setNombre("Esperanza");
				emp45.setApellidos("Olmedo");
				emp45.setCorreo("olmedo.e@gmail.com");
				emp45.setFavorito(true);
				emp45.setTelefono("715370415");
				emp45.setJefe(emp37);
				e5.agregaEmpleado(emp45);                                                          
			
				Empleado emp46=new Empleado();
				emp46.setAlias("Sandro");
				emp46.setNombre("Alexandro");
				emp46.setApellidos("Guzman");
				emp46.setCorreo("sguzman@gmail.com");
				emp46.setFavorito(true);
				emp46.setTelefono("618225090");
				emp46.setJefe(emp37);
				e5.agregaEmpleado(emp46);
				
				Empleado emp47=new Empleado();
				emp47.setAlias("Regi");
				emp47.setNombre("Regina");
				emp47.setApellidos("Alvarez");
				emp47.setCorreo("alregina@gmail.com");
				emp47.setFavorito(false);
				emp47.setTelefono("755672455");
				emp47.setJefe(emp37);
				e5.agregaEmpleado(emp47);


				Empleado emp48=new Empleado();
				emp48.setAlias("Lazio");
				emp48.setNombre("Angel");
				emp48.setApellidos("Gutierrez");
				emp48.setCorreo("gutiangel@gmail.com");
				emp48.setFavorito(true);
				emp48.setTelefono("612136898");
				emp48.setJefe(emp37);
				e5.agregaEmpleado(emp48);
				
				Empleado emp49=new Empleado();
				emp49.setAlias("Carmina");
				emp49.setNombre("Carmen");
				emp49.setApellidos("Vera");
				emp49.setCorreo("c.vera@gmail.com");
				emp49.setFavorito(true);
				emp49.setTelefono("653712151");
				emp49.setJefe(emp37);
				e5.agregaEmpleado(emp49);

				Empleado emp50=new Empleado();
				emp50.setAlias("Gordo");
				emp50.setNombre("Alvaro");
				emp50.setApellidos("Tristan");
				emp50.setCorreo("tristanal@gmail.com");
				emp50.setFavorito(false);
				emp50.setTelefono("954210298");
				emp50.setJefe(emp37);
				e5.agregaEmpleado(emp50);
				
				Empleado emp51=new Empleado();
				emp51.setAlias("Andres");
				emp51.setNombre("Andres");
				emp51.setApellidos("Bermudez");
				emp51.setCorreo("andresb@gmail.com");
				emp51.setFavorito(false);
				emp51.setTelefono("654542455");
				emp51.setJefe(emp37);
				e5.agregaEmpleado(emp51);
			
				Empleado emp52=new Empleado();
				emp52.setAlias("Linares");
				emp52.setNombre("Aldo");
				emp52.setApellidos("Linares");
				emp52.setCorreo("linaal@gmail.com");
				emp52.setFavorito(true);
				emp52.setTelefono("615662577");
				emp52.setJefe(emp37);
				e5.agregaEmpleado(emp52);
				
				Empleado emp53=new Empleado();
				emp53.setAlias("Moises Dominguez Villegas");
				emp53.setNombre("Moises");
				emp53.setApellidos("Dominguez");
				emp53.setCorreo("mdvg@gmail.com");
				emp53.setFavorito(false);
				emp53.setTelefono("712318415");
				emp53.setJefe(emp37);
				e5.agregaEmpleado(emp53); 

				Empleado emp54=new Empleado();
				emp54.setAlias("Cabezon");
				emp54.setNombre("Dani");
				emp54.setApellidos("cruzado");
				emp54.setCorreo("danicruzado@gmail.com");
				emp54.setFavorito(true);
				emp54.setTelefono("954210298");
				emp54.setJefe(emp37);
				e5.agregaEmpleado(emp54);
				
				Empleado emp55=new Empleado();
				emp55.setAlias("Rambo");
				emp55.setNombre("Jose Carmelo");
				emp55.setApellidos("Dominguez");
				emp55.setCorreo("dom.jc@gmail.com");
				emp55.setFavorito(true);
				emp55.setTelefono("629542455");
				emp55.setJefe(emp37);
				e5.agregaEmpleado(emp55);
			
				Empleado emp56=new Empleado();
				emp56.setAlias("Mala");
				emp56.setNombre("Bea");
				emp56.setApellidos("Rodriguez");
				emp56.setCorreo("rodribea@gmail.com");
				emp56.setFavorito(true);
				emp56.setTelefono("617612575");
				emp56.setJefe(emp37);
				e5.agregaEmpleado(emp56);
				
				Empleado emp57=new Empleado();
				emp57.setAlias("Segis");
				emp57.setNombre("Segismundo");
				emp57.setApellidos("Amador");
				emp57.setCorreo("amador.segis@gmail.com");
				emp57.setFavorito(true);
				emp57.setTelefono("669370415");
				emp57.setJefe(emp37);
				e5.agregaEmpleado(emp57); 

				agenda.subirEmpresa(e5);
				
				
	}

}
