package conteúdo;

import java.util.ArrayList;
import java.util.List;

abstract class Planeta {
	protected String nome;
	protected int x;
	protected int y;
	protected double rotação;  //Velocidade de Deslocamento (rotação) por instante
	protected int movimento;   //Velodidade de Translação por instante
	protected int anoJavaLar;
	protected int anoPorRodada;
	protected double tempoDesdeUltimoInstante = 0;
	protected double tempoRodado;
	protected int unidadesPercorridas;
	protected int totalInstantes;
	private int bugsColididos;
	private int devsColididos;

	public Planeta(String nome, int x, int y, int movimento, double rotação) {
		this.nome = nome;
		this.x = x;
		this.y = y;
		this.rotação = rotação;
		this.movimento = movimento;
		this.anoJavaLar = 0;
		this.anoPorRodada = 0;
		this.tempoRodado = 0;
		bugsColididos = 0;
		devsColididos = 0;
	}

	public static List<Planeta> criarPlanetas() {
		List<Planeta> planetas = new ArrayList<>();
		planetas.add(new Python(8, 9));
		planetas.add(new JavaScript(8, 10));
		planetas.add(new RubyonRails(8, 11));
		planetas.add(new PHP(8, 12));
		planetas.add(new Csharp(8, 13));
		planetas.add(new Cplusplus(8, 14));
		planetas.add(new C(8, 15));
		return planetas;
	}

	public static void agirPlanetas(List<Planeta> planetas, int instantesDesejados) {
		for (Planeta planeta : planetas) {
			planeta.mover(instantesDesejados);
			planeta.rotacionar(instantesDesejados);
		}

	}

	public String getNome() {
		return nome;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void zerarAnoPorRodada() {
		anoPorRodada = 0;
	}

	public int getAnoPorRodada() {
		return anoPorRodada;
	}

	public double getRotação() {
		return rotação;
	}

	public int getMovimento() {
		return movimento;
	}

	public void setMovimento(int movimento) {
		this.movimento = movimento;
	}

	public int getAnos() {
		return anoJavaLar;
	}

	public void setAnos(int anoJavaLar) {
		this.anoJavaLar = anoJavaLar;
	}

	public double getTempoDesdeUltimoInstante() {
		return tempoDesdeUltimoInstante;
	}

	public void zerarTempoDesdeUltimoInstante() {
		this.tempoDesdeUltimoInstante = 0;
	}

	public double getTempoRodado() {
		return tempoRodado;
	}

	public void setTempoRodado(int tempoRodado) {
		this.tempoRodado = tempoRodado;
	}

	public int getBugsColididos() {
		return bugsColididos;
	}

	public void aumentarBugs() {
		bugsColididos++;
	}

	public int getDevsColididos() {
		return devsColididos;
	}

	public void aumentarDevs() {
		devsColididos++;
	}

	public void aumentarMovimento() {
		this.movimento++;
	}

	public void diminuirMovimento() {
		this.movimento--;
	}

	public void aumentarAnoPorRodada() {
		this.anoPorRodada++;
	}

	public void aumentarAnosTotais() {

		this.anoJavaLar++;

	}

	public abstract void mover(int instantes);

	public abstract void rotacionar(int instantes);

	protected boolean passouPelaCoordenada(int CoordX, int CoordY) {
		if (x == CoordX && y == CoordY) {
			return true;
		} else {
			return false;
		}
	}

	public double calcularVelocidadeMedia() {
		if (totalInstantes == 0) {
			return 0.0;
		}
		return (double) unidadesPercorridas / totalInstantes;
	}

	public void mostrarCardeais(List<Planeta> planetas) {
		System.out.println("\nPlanetas ao Norte de Java: ");
		for (Planeta planeta : planetas) {
			if (planeta.getY() > 8) {
				System.out.println(planeta.getNome());
			}
		}
		System.out.println("\nPlanetas ao Sul de Java: ");
		for (Planeta planeta : planetas) {
			if (planeta.getY() < 8) {
				System.out.println(planeta.getNome());
			}
		}
	}
}
