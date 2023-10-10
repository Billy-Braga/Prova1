package conteúdo;

import java.util.ArrayList;
import java.util.List;

public class Plano {
	private List<Planeta> planetas;
	private List<Desenvolvedores> desenvolvedores;
	private List<Bug> bugs;

	public Plano(List<Planeta> planetas, List<Desenvolvedores> desenvolvedores, List<Bug> bugs) {
		super();
		this.planetas = planetas;
		this.desenvolvedores = desenvolvedores;
		this.bugs = bugs;

	}

	public void verificarColisãoDev(List<Desenvolvedores> desenvolvedores, List<Desenvolvedores> devsRemovidos,
			boolean[][] posicoesOcupadas) {

		for (Planeta planeta : planetas) {
			for (Desenvolvedores dev : desenvolvedores) {
				if (planeta.getX() == dev.getPosicaoX() && planeta.getY() == dev.posicaoY) {
					planeta.aumentarMovimento();
					planeta.aumentarDevs();
					System.out.println("O planeta " + planeta.getNome() + " encontrou um desenvolvedor na posição ("
							+ planeta.getX() + "," + planeta.getY() + ")!");
					devsRemovidos.add(dev);
					posicoesOcupadas[dev.posicaoX][dev.posicaoY] = false;
				}
			}
		}
		desenvolvedores.removeAll(devsRemovidos);
	}

	public void verificarColisãoBugs(List<Bug> bugs, List<Bug> bugsRemovidos, boolean[][] posicoesOcupadas) {

		for (Planeta planeta : planetas) {
			for (Bug bug : bugs) {
				if (planeta.getX() == bug.posicaoX && planeta.getY() == bug.posicaoY) {
					planeta.diminuirMovimento();
					planeta.aumentarBugs();
					System.out.println("O planeta " + planeta.getNome() + " encontrou um bug na posição ("
							+ planeta.getX() + "," + planeta.getY() + ")!");
					bugsRemovidos.add(bug);
					posicoesOcupadas[bug.posicaoX][bug.posicaoY] = false;
				}
			}
		}
		bugs.removeAll(bugsRemovidos);
	}

	public void distâncias(List<Planeta> planetas) {
		for (int i = 0; i < planetas.size(); i++) {
			Planeta planeta1 = planetas.get(i);
			for (int j = i + 1; j < planetas.size(); j++) {
				Planeta planeta2 = planetas.get(j);

				int deltaX = Math.abs(planeta1.getX() - planeta2.getX());
				int deltaY = Math.abs(planeta1.getY() - planeta2.getY());

				int área = deltaX * deltaY;
				double distânciaEuclidiana = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

				System.out.printf("%-25s%3d J/m²%11.2f J/m%n", planeta1.nome + " e " + planeta2.nome, área,
						distânciaEuclidiana);
			}
		}
	}

	public void contarDevsEBugs() {
		System.out.println("\nQuantidade de bugs: " + bugs.size());
		System.out.println("Quantidade de desenvolvedores: " + desenvolvedores.size());
	}

	public void mostrarBugs() {
		System.out.println("\nAs coordenadas dos Bugs são:\n");
		int contador = 0;
		for (Bug bug : bugs) {
			System.out.print("[" + bug.getPosicaoX() + "," + bug.getPosicaoY() + "] | ");
			contador++;
			if (contador == 5) {
				System.out.println();
				contador = 0;
			}
		}
	}

	public void mostrarDevs() {
		System.out.println("\n\nAs coordenadas dos Desenvolvedores são:\n");
		int contador = 0;
		for (Desenvolvedores dev : desenvolvedores) {
			System.out.print("[" + dev.getPosicaoX() + "," + dev.getPosicaoY() + "] | ");
			contador++;
			if (contador == 5) {
				System.out.println();
				contador = 0;
			}
		}
	}

	public void exibirDados() {
		for (Planeta planeta : planetas) {
			String coordenadas = String.format("(%d,%d)", planeta.getX(), planeta.getY());

			System.out.printf("%-17s %-10s %-10.1f %-10d %-11d %n", planeta.nome, coordenadas,
					planeta.getTempoDesdeUltimoInstante(), planeta.getAnoPorRodada(), planeta.getMovimento());
		}
	}

	public void explodirPlanetas(List<Planeta> planetas, List<Planeta> falecidos) {

		for (Planeta planeta : planetas) {
			if (planeta.getMovimento() == 0) {
				System.out.println("O planeta " + planeta.getNome() + "Explodiu!");
				falecidos.add(planeta);
			}
		}
		planetas.removeAll(falecidos);
	}
}