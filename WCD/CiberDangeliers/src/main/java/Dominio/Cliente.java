package Dominio;

import java.sql.Date;
import Presentacion.ClasePrincipal.rango;

public class Cliente extends Persona{
	/*Atributos*/
	private String nickname;
	private String fechanacimiento;
	private double tiemporestante;
	private double tiempoTotal;
	private rango rango;
	
	/*Constructor*/
	public Cliente(String name, String apellido, String dni, String email, String nickname, String fechanacimiento,
			double tiemporestante, Presentacion.ClasePrincipal.rango rango) {
		super(name, apellido, dni, email);
		this.nickname = nickname;
		this.fechanacimiento = fechanacimiento;
		this.tiemporestante = tiemporestante;
		this.rango = rango;
		this.tiempoTotal=0;
	}
	
	
	/*Getters*/
	public String getNickname() {
		return nickname;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public double getTiemporestante() {
		return tiemporestante;
	}

	public rango getRango() {
		return rango;
	}

	public double getTiempoTotal() {
		return tiempoTotal;
	}


	/*Setters*/
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public void setTiemporestante(double tiemporestante) {
		this.tiemporestante = tiemporestante;
	}

	public void setRango(rango rango) {
		this.rango = rango;
	}
	
	public void setTiempoTotal(double tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

	@Override
	public String toString() {
		return "Cliente [nickname=" + nickname + ", fechanacimiento=" + fechanacimiento + ", tiemporestante="
				+ tiemporestante + ", tiempoTotal=" + tiempoTotal + ", rango=" + rango + "]";
	}


	/*Metodos*/
	public String calculartrestante() {
		int horas=(int)(tiemporestante);
		int minutos=(int)(((tiemporestante-(double)horas)*60));
		String horaminrestantes="Tiempo restante:"+horas+":"+minutos;
		return horaminrestantes;
	}
	
}
