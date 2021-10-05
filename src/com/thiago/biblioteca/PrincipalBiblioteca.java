package com.thiago.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thiago.aluno.Aluno;

public class PrincipalBiblioteca {
	public static void main(String[] args) {

		boolean sair = false;
		List<Aluno> alunos = new ArrayList<>();
		List<Livro> livros = new ArrayList<>();

		do {
			menuVisual();

			Scanner entrada = new Scanner(System.in);
			int opcao = entrada.nextInt();
			switch (opcao) {
			case 1: {
				System.out.print("Digite o nome do aluno: ");
				String nome = entrada.next();
				Aluno aluno = new Aluno(nome);
				alunos.add(aluno);
				System.out.println("Aluno adcionado com Sucesso!");
				continue;
			}
			case 2: {
				System.out.print("Digite o titulo do livro: ");
				String nomeLivro = entrada.next();
				System.out.print("Digite o nome do Autor do livro: ");
				String nomeAutor = entrada.next();
				Livro livro = new Livro();
				livro.setTitulo(nomeLivro);
				livro.setAutor(nomeAutor);
				livros.add(livro);
				System.out.println("Livro adcionado com Sucesso!");
				continue;
			}
			case 3: {
				if (alunos.isEmpty()) {
					System.out.println("Não possui alunos cadastrados!");
				} else {
					System.out.println("\t\t\t<<<Lista de Alunos>>>\n");
					for (Aluno a : alunos) {
						System.out.print("ID: " + a.getIdAluno());
						System.out.print("\tNome: " + a.getNome());
						System.out.println("\tLivro: " + a.getLivroComOAluno());
					}
				}
				continue;
			}
			case 4: {
				if (livros.isEmpty()) {
					System.out.println("Não possui livros cadastrados!");
				} else {
					System.out.println("\t\t\t<<<Lista de Livros>>>\n");
					for (Livro l : livros) {
						System.out.print("ID: " + l.getIdLivro());
						System.out.print("\tTitulo: " + l.getTitulo());
						System.out.print("\tAutor: " + l.getAutor());
						System.out.println("\tEmprestado: " + l.isEmprestado());
					}
					System.out.println();
				}
				continue;
			}
			case 5: {
				System.out.print("Digite o ID do aluno: ");
				int idInAluno = entrada.nextInt();
				System.out.print("Digite o ID do Livro: ");
				int idInLivro = entrada.nextInt();
				for (Aluno a : alunos) {
					if (a.getIdAluno() == idInAluno) {
						System.out.println("Aluno selecionado: " + a.getNome());
						for (Livro l : livros) {
							if (l.getIdLivro() == idInLivro) {
								System.out.println("Livro selecionado: " + l.getTitulo());
								l.emprestarlivro(a);
								l.alunoComOLivro = a.getNome();
								a.livroComOAluno = l.getTitulo();
							} else {
								// System.out.println("Livro não localizado!");
							}
						}
					} else {
						// System.out.println("Aluno não localizado na Base!");
					}
				}
				continue;
			}
			case 6: {
				System.out.print("Digite o ID do aluno: ");
				int idInAluno = entrada.nextInt();
				System.out.print("Digite o ID do Livro: ");
				int idInLivro = entrada.nextInt();
				for (Aluno a : alunos) {
					if (a.getIdAluno() == idInAluno) {
						System.out.println("Aluno selecionado: " + a.getNome());
						for (Livro l : livros) {
							if (l.getIdLivro() == idInLivro) {
								System.out.println("Livro selecionado: " + l.getTitulo());
								l.emprestarlivro(a);
								l.alunoComOLivro = a.getNome();
								a.livroComOAluno = l.getTitulo();
							} else {
								// System.out.println("Livro não localizado!");
							}
						}
					} else {
						// System.out.println("Aluno não localizado na Base!");
					}
				}

				continue;
			}
			case 7: {
				System.out.println("Obrigado por usar a Biblioteca Virtual!");
				sair = true;
				break;
			}
			default:
				System.err.print("Erro na opção escolhida");
				extracted(opcao);
			}
			entrada.close();

		} while (sair != true);

	}

	private static void extracted(int opcao) {
		throw new IllegalArgumentException("Valor digitado: " + opcao + " indisponivel.");
	}

	private static void menuVisual() {
		System.out.println("################################");
		System.out.println("#    Sistema Bibliotecário     #");
		System.out.println("# 1-Cadastrar Aluno            #");
		System.out.println("# 2-Cadastrar Livro            #");
		System.out.println("# 3-Consultar Aluno            #");
		System.out.println("# 4-Consultar Livro            #");
		System.out.println("# 5-Emprestar Livro            #");
		System.out.println("# 6-Devolver Livro             #");
		System.out.println("# 7-Sair                       #");
		System.out.println("#             ESCOLHA UMA OPCAO#");
		System.out.println("################################");

	}
}
