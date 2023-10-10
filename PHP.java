package conteúdo;

class PHP extends Planeta {
	private int direcao;

	public PHP(int x, int y) {
		super("PHP", x, y, 2, 60);
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
				if (x == 4 && y == 12) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 4 && y == 4) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 12 && y == 4) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 12 && y == 12) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 12)) {
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
