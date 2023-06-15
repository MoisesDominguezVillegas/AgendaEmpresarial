package modelo;

import interfaces.IContacto;

public class Contacto implements IContacto{
	//Atributos
	private String alias;
	private String telefono;
	private String correo;
	private boolean favorito;
	
	//Metodos
	public Contacto() {
		this.alias = null;
		this.telefono = null;
		this.correo = null;
		this.favorito = false;
	}

	@Override
	public String getAlias() {
		return alias;
	}

	@Override
	public String getTelefono() {
		return telefono;
	}

	@Override
	public String getCorreo() {
		return correo;
	}

	@Override
	public boolean getFavorito() {
		return favorito;
	}

	@Override
	public void setAlias(String alias) {
		this.alias = alias;
		
	}

	@Override
	public void setTelefono(String telefono) {
		this.telefono = telefono;
		
	}

	@Override
	public void setCorreo(String correo) {
		this.correo = correo;
		
	}

	@Override
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
		
	}

	
	
}
