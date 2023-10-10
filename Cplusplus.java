package conteúdo;

class Cplusplus extends Planeta {
	private int direcao;

	public Cplusplus(int x, int y) {
		super("Cplusplus", x, y, 2, 0.5);
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
				if (x == 2 && y == 14) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 2 && y == 2) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 14 && y == 2) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 14 && y == 14) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 14)) {
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
