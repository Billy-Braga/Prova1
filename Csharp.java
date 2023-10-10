package conteúdo;

class Csharp extends Planeta {
	private int direcao;

	public Csharp(int x, int y) {
		super("Csharp", x, y, 1, 4);
		direcao = 0;

	}

	@Override
	public void mover(int instantes) {
		int unidades = instantes * getMovimento();
		unidadesPercorridas += unidades;
		totalInstantes += instantes;

		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 3 && y == 13) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 3 && y == 3) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 13 && y == 3) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 13 && y == 13) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 13)) {
				aumentarAnoPorRodada();
				aumentarAnosTotais();
			}
		}
	}

	@Override
	public void rotacionar(int instantes) {
		double tempoDesdeUltimoInstante = instantes * rotação;
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}
}
