package Dominio;

import java.sql.Date;
import java.util.*;

import Presentacion.ClasePrincipal.rango;

public class Empleado extends Persona{
	
	/*Atributos*/
	private int telefono;
	private String direccion;
	private int nss;
	private double nomina;
	private String fechaalta;
	
	/*Constructor*/
	public Empleado(String name, String apellido, String dni, String email, int telefono, String direccion, int nss, double nomina, String fechaalta) {
		super(name, apellido, dni, email);
		this.telefono = telefono;
		this.direccion = direccion;
		this.nss = nss;
		this.nomina = nomina;
		this.fechaalta = fechaalta;
	}

	/*Getters*/
	public int getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getNss() {
		return nss;
	}

	public double getNomina() {
		return nomina;
	}

	public String getFechaalta() {
		return fechaalta;
	}

	/*Setters*/
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setNss(int nss) {
		this.nss = nss;
	}

	public void setNomina(double nomina) {
		this.nomina = nomina;
	}

	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}
	
	/*Métodos*/
	public String crearcliente(ArrayList<Cliente> clientes) {
		Scanner dato=new Scanner(System.in);
		System.out.println("Nombre del cliente");
		String nombre=dato.nextLine();
		System.out.println("Apellidos del cliente");
		String apellidos=dato.nextLine();
		System.out.println("DNI del cliente");
		String dni=dato.nextLine();
		System.out.println("Email del cliente");
		String email=dato.nextLine();
		System.out.println("Nickname del cliente");
		String nickname=dato.nextLine();
		System.out.println("Fecha nacimiento del cliente");
		String fechanac=dato.nextLine();
		Cliente aux =new Cliente(nombre,apellidos,dni,email,nickname,fechanac, 0, rango.COBRE);
		clientes.add(aux);
		return "Cliente creado"+aux.toString();
	}
	
	public String eliminarcliente(ArrayList<Cliente> clientes) {
		Scanner dato=new Scanner(System.in);
		System.out.println("Escribe el DNI del cliente a eliminar");
		String dnicliente=dato.nextLine();
		int numaux=0;
		
		for (int i=0;i<clientes.size();i++) {
			if(clientes.get(i).getDni().equalsIgnoreCase(dnicliente)) {
				clientes.remove(i);
				numaux++;
			}
		}
		
		if(numaux==0) {
			return "Cliente no encontrado";
		}else {
			return "Cliente eliminado correctamente";
		}	
	}
	
	public String verDatosCliente(ArrayList<Cliente> clientes) {
		Scanner dato=new Scanner(System.in);
		String respuesta;
		String aux = null;
		
		System.out.println("Escribe el nickname del usuario que quieras ver los datos");
		String nicknamecliente=dato.nextLine();
		
		int numaux=0;
		
		for (int i=0;i<clientes.size();i++) {
			if(clientes.get(i).getNickname().equalsIgnoreCase(nicknamecliente)) {
				aux=clientes.get(i).toString();
				numaux++;
			}
		}
		
		if(numaux==0) {
			return "Cliente no encontrado";
		}else {
			respuesta=aux;
			return respuesta;
		}	
	}
	
	public String añadirHorasCliente(ArrayList<Cliente> clientes) {
		Scanner dato=new Scanner(System.in);
		
		System.out.println("Escribe el nickname del usuario que quieras ver los datos");
		String nicknamecliente=dato.nextLine();
		String horasrestanteux="";
		int numaux=0;
		
		for (int i=0;i<clientes.size();i++) {
			if(clientes.get(i).getNickname().equalsIgnoreCase(nicknamecliente)) {
				numaux++;
				System.out.println("¿Cuantas horas quieres añadir?");
				int horasañadir=dato.nextInt();
				clientes.get(i).setTiemporestante(clientes.get(i).getTiemporestante()+horasañadir);
				horasrestanteux=clientes.get(i).calculartrestante();
				clientes.get(i).setTiempoTotal(clientes.get(i).getTiempoTotal()+horasañadir);
				
				if(clientes.get(i).getTiempoTotal()>=30 && clientes.get(i).getTiempoTotal()<60) {
					clientes.get(i).setRango(rango.BRONCE);
				}else if(clientes.get(i).getTiempoTotal()>=60 && clientes.get(i).getTiempoTotal()<100) {
					clientes.get(i).setRango(rango.PLATA);
				}else if(clientes.get(i).getTiempoTotal()>=100 && clientes.get(i).getTiempoTotal()<150) {
					clientes.get(i).setRango(rango.ORO);
				}else if(clientes.get(i).getTiempoTotal()>=150 && clientes.get(i).getTiempoTotal()<210) {
					clientes.get(i).setRango(rango.PLATINO);
				}else if(clientes.get(i).getTiempoTotal()>=210) {
					clientes.get(i).setRango(rango.DIAMANTE);
				}
				
			}
		}
		
		if(numaux==0) {
			return "Cliente no encontrado";
		}else {
			
			return "Tiempo añadido correctamente. Tiempo restante del cliente: "+horasrestanteux;
		}	
	}
}
