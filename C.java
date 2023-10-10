package conteúdo;

class C extends Planeta {
	private int direcao;

	public C(int x, int y) {
		super("C", x, y, 10, 0.1);
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
				if (x == 1 && y == 15) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 1 && y == 1) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 15 && y == 1) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 15 && y == 15) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 15)) {
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
