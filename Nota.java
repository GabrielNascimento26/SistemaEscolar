package SistemaEscolar;

public class Nota {
	private String materia;
	private double nota;
	
	public Nota(String materia, double nota) {
		this.materia = materia;
		this.nota = nota;
	}
	
	public String getMateria() {
		return materia;
	}
	
	public double getNota() {
		return nota;
	}
}
