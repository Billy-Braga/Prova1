package conteúdo;

class Python extends Planeta {
	private int direcao;

	public Python(int x, int y) {
		super("Python", x, y, 4, 24);
		direcao = 0;

	}

	public void mover(int segundos) {
		int unidades = segundos * getMovimento();
		unidadesPercorridas += unidades;
		totalInstantes += segundos;

		for (int i = 0; i < unidades; i++) {
			if (direcao == 0) {
				x--;
				if (x == 7 && y == 9) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 7 && y == 7) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 9 && y == 7) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 9 && y == 9) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 9)) {
				aumentarAnoPorRodada();
				aumentarAnosTotais();
			}
		}
	}

	@Override
	public void rotacionar(int instantesDesejados) {
		double tempoDesdeUltimoInstante = instantesDesejados * rotação;
		this.tempoDesdeUltimoInstante = tempoDesdeUltimoInstante;
		tempoRodado += tempoDesdeUltimoInstante;
	}

}
