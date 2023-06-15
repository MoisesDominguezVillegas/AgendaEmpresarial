package interfaces;

import java.util.List;

/**
 * 
 * Esta interfaz tendrá los aspectos generales a almacenar en un registro de cada Contacto de nuestra Agenda:
 * @author Moises Dominguez
 *
 */
public interface IContacto {
	/**
	 * Metodo que devuelve el alias del contacto
	 * 
	 * @return String. retorna el alias.
	 */
	public String getAlias();
	
	/**
	 * Metodo que devuelve el telefono del contacto
	 * 
	 * @return String. retorna el telefono.
	 */
	public String getTelefono();
	
	/**
	 * Metodo que devuelve el correo del contacto
	 * 
	 * @return String. retorna el correo.
	 */
	public String getCorreo();
	
	/**
	 * Metodo que devuelve si el contacto es favorito.
	 * 
	 * @return boolean. retorna verdadero si el contacto es favorito y falso si no lo es.
	 */
	public boolean getFavorito();
	
	/**
	 * Metodo que modifica el alias del contacto.
	 * @param String. contiene el alias a modificar.
	 */
	public void setAlias(String alias);
	
	/**
	 * Metodo que modifica el telefono del contacto
	 * @param String. contiene el telefono a modificar.
	 */
	public void setTelefono(String telefono);
	
	/**
	 * Metodo que modifica el correo del contacto.
	 * @param String. contiene el correo a modificar.
	 */
	public void setCorreo(String correo);
	
	/**
	 * Metodo que modifica si el contacto es favorito.
	 * @param boolean. contiene el boolean de si el contacto es o no es favorito.
	 */
	public void setFavorito(boolean favorito);

}
