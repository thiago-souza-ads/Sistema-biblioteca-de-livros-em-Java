package com.thiago.aluno;

public class Aluno {
	
	private static int contadorDeAluno = 0;
	public int idAluno;
	private String nome;
	public String livroComOAluno = "Sem livros locados no momento!";
	public Aluno() {
		
	}
	
	public Aluno (String nome){
		this();
		this.nome = nome;
		this.idAluno = contadorDeAluno;
		contadorDeAluno++;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno() {
		idAluno++;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLivroComOAluno() {
		return livroComOAluno;
	}
	public void setLivroComOAluno(String livroComOAluno) {
		this.livroComOAluno = livroComOAluno;
	}
	
}
