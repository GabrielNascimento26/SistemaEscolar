package SistemaEscolar;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	private String letra;
	private int serie;
	private List<Aluno> alunos;
	
	public Turma(String letra, int serie, int quantidadeDeAlunos) {
		this.letra = letra;
		this.serie = serie;
		this.alunos = new ArrayList<>(quantidadeDeAlunos);
	}
	
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void imprimirNotasPorMateria(String materia) {
		double soma = alunos.stream()
				.flatMapToDouble(alunos -> alunos.getNotas().stream()
						.filter(nota -> nota.getMateria().equals(materia))
						.mapToDouble(Nota::getNota))
				.sum();
		
		long count = alunos.stream()
				.flatMap(alunos -> alunos.getNotas().stream())
						.filter(nota -> nota.getMateria().equals(materia))
						.count();
				
				double media = count > 0 ? soma / count : 0;
				System.out.println("Média da turma na materia " + materia + ": " + media);
	}
	
	public void imprimirAlunosAprovados(double notaDeCorte) {
		System.out.println("Alunos aprovados:");
		alunos.stream()
		.filter(aluno -> aluno.calcularMedia() >= notaDeCorte)
		.forEach(aluno -> System.out.println(aluno.getNome() + " com média " + aluno.calcularMedia()));
	}
	
	public void imprimirMediaDaTurmaPorMateria(String materia) {
		double soma = alunos.stream()
				.flatMapToDouble(aluno -> aluno.getNotas().stream()
						.filter(nota -> nota.getMateria().equals(materia))
						.mapToDouble(Nota::getNota))
				.sum();
	}
	
	public void imprimirNotasEMediaPorMateria(String materia) {
		System.out.println("Notas da turma na matéria " + materia + ":");
		double soma = 0;
		int count = 0;
		
		for(Aluno aluno : alunos) {
			for(Nota nota : aluno.getNotas()) {
				if(nota.getMateria().equals(materia)) {
					System.out.println(aluno.getNome() + ": " + nota.getNota());
					soma += nota.getNota();
					count++;
				}
			}
		}
		double media = (count > 0) ? soma / count : 0;
		System.out.println("Média da turma na matéria " + materia + ": " + media);
	}
	
	
}
