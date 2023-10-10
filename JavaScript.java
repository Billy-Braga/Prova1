package conteúdo;

class JavaScript extends Planeta {
	private int direcao;

	public JavaScript(int x, int y) {
		super("JavaScript", x, y, 3, 10);
		direcao = 0;
		anoJavaLar = 0;

	}

	@Override
	public void mover(int instantes) {
		int unidades = instantes * getMovimento();
		unidadesPercorridas += unidades;
		totalInstantes += instantes;

		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 6 && y == 10) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 6 && y == 6) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 10 && y == 6) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 10 && y == 10) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 10)) {
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
