package SistemaEscolar;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private List<Nota> notas;
	
	public Aluno(String nome) {
		this.nome = nome;
		this.notas = new ArrayList<>();
	}
	
	public void adicionarNota(String materia, double nota) {
		this.notas.add(new Nota(materia, nota));
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Nota> getNotas() {
		return notas;
	}
	
	public double calcularMedia() {
		double soma = 0;
		for(Nota nota : notas) {
			soma += nota.getNota();
		}
		return notas.size() > 0 ? soma / notas.size() : 0;
				}
}
