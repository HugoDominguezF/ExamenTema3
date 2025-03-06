package fecha;

/**
 * Clase de Fecha que contendra todos los constructores y funciones necesarias para calcular una fecha
 */
public class Fecha {
	private int d; //d�a
	private int m; //mes
	private int a; //a�o

	
	public Fecha() {

	}

	/**
	 * El constructor Fecha contruira una variable con los parametros dia, mes y anio
	 * @param dia variable que contendra el numero de dias
	 * @param mes variable que contendra el numero de meses
	 * @param anio variable que contendra el numero de anios
	 */
	public Fecha(int dia, int mes, int anio) {
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Esta funcion corrige si una fecha dada es correcta como puede ser un dia 34, o un mes 15. Esto lo corregira 
	 * mediante un switch que controlara los meses distintos
	 * @return true si lo es, false si tiene alguna inconsistencia
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	/**
	 * Esta Funcion comprobara si el año es bisiesto
	 * @return true si lo es, false si no
	 */
	private boolean esBisiesto() {
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	// M�todo diaSiguiente
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
			}
		}
	}

	// M�todo toString
	/**
	 * esta funcion imprimira el resultado de la fecha dada, segun si son menores que 10 el dia y 
	 * los meses cambiara el print para poner un 0 delante
	 */
	public String toString() {
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
