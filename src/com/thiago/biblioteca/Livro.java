package com.thiago.biblioteca;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.thiago.aluno.Aluno;

public class Livro {
	
	private static int contadorDeLivros = 0;
	private int idLivro;
	private String autor;
	private String titulo;
	private boolean emprestado;
	private LocalDateTime dataEmprestimo;
	private LocalDateTime dataPrevistaDevolucao;
	private LocalDateTime dataDevolucao;
	public String alunoComOLivro = "Disponivel!";
	Aluno aluno;
	
	Livro(){
		this.emprestado = false;
		this.idLivro = contadorDeLivros;
		contadorDeLivros++;
	}
	
	Livro(String autor, String titulo){
		this();
		this.autor = autor;
		this.titulo = titulo;
	}
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public boolean isEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	public void emprestarlivro(Aluno aluno){
		if (this.emprestado == false) {
			this.aluno = aluno;
			this.dataEmprestimo = LocalDateTime.of(LocalDate.now(), LocalTime.of(LocalTime.now().getHour(), 0));
			this.dataPrevistaDevolucao = LocalDateTime.now().plusDays(3).plusHours(2);
			this.emprestado = true;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			System.out.println("Livro emprestado com sucesso, devolver em => "+this.getDataPrevistaDevolucao().format(formatter));
		} else { 
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			System.out.println("O livro já está locado! Disponivel no dia => "+this.getDataPrevistaDevolucao().format(formatter));
		}
	}
	public LocalDateTime getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDateTime getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getAlunoComOLivro() {
		return alunoComOLivro;
	}

	public void setAlunoComOLivro(String alunoComOLivro) {
		this.alunoComOLivro = alunoComOLivro;
	}

	public void devolverLivro() {
		if (this.emprestado) {
			this.emprestado = false;
			this.alunoComOLivro = "Disponivel";
			if (this.dataDevolucao.isAfter(dataDevolucao)) {
				System.out.println("Voce atrasou a entrega! Pagará uma multa!");
			}
		} else {
			System.out.println("O livro não está emprestado!");
		}
	}	
}
