package tp01.ejercicio3;

public class Estudiante extends Persona {
	private String comision;
	private String direccion;

	public Estudiante(String nombre, String apellido, String comision, String email, String direccion) {
		super(nombre, apellido, email);
		this.comision = comision;
		this.direccion = direccion;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String tusDatos() {
		return super.tusDatos() + String.format(", %s, %s", getComision(), getDireccion());
	}
}
