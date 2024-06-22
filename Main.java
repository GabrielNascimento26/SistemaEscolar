package SistemaEscolar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar a turma
        System.out.print("Digite a letra da turma: ");
        String letra = scanner.nextLine();
        System.out.print("Digite a série da turma: ");
        int serie = scanner.nextInt();
        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeDeAlunos = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Turma turma = new Turma(letra, serie, quantidadeDeAlunos);

        // Passar o nome dos alunos
        for (int i = 0; i < quantidadeDeAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            Aluno aluno = new Aluno(nome);
            turma.adicionarAluno(aluno);
        }

        // Perguntar a quantidade de matérias
        System.out.print("Digite a quantidade de matérias: ");
        int quantidadeDeMaterias = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        // Para cada matéria, perguntar o nome da matéria e as notas dos alunos
        for (int j = 0; j < quantidadeDeMaterias; j++) {
            System.out.print("Digite o nome da matéria " + (j + 1) + ": ");
            String materia = scanner.nextLine();
            turma.getAlunos().forEach(aluno -> {
                System.out.print("Digite a nota de " + aluno.getNome() + " em " + materia + ": ");
                double nota = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha
                aluno.adicionarNota(materia, nota);
            });
        }

        // Loop para comandos até fechar
        while (true) {
            System.out.println("Digite 'mostrar notas', 'aprovados', ou 'fechar': ");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("mostrar notas")) {
                // Imprimir a nota de cada aluno e a média da turma na matéria escolhida
                System.out.print("Digite o nome da matéria para imprimir as notas e a média: ");
                String materia = scanner.nextLine();
                turma.imprimirNotasEMediaPorMateria(materia);

            } else if (comando.equalsIgnoreCase("aprovados")) {
                // Imprimir os alunos aprovados de acordo com a média de todas as matérias
                System.out.print("Digite a nota de corte para aprovação: ");
                double notaDeCorte = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha
                turma.imprimirAlunosAprovados(notaDeCorte);

            } else if (comando.equalsIgnoreCase("fechar")) {
                break;
            } else {
                System.out.println("Comando inválido. Tente novamente.");
            }
        }

        scanner.close();
    }
}
