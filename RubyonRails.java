package conteúdo;

class RubyonRails extends Planeta {
	private int direcao;

	public RubyonRails(int x, int y) {
		super("RubyonRails", x, y, 2, 48);
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
				if (x == 5 && y == 11) {
					direcao = 1;
				}
			} else if (direcao == 1) {
				y--;
				if (x == 5 && y == 5) {
					direcao = 2;
				}
			} else if (direcao == 2) {
				x++;
				if (x == 11 && y == 5) {
					direcao = 3;
				}
			} else if (direcao == 3) {
				y++;
				if (x == 11 && y == 11) {
					direcao = 0;
				}
			}
			if (passouPelaCoordenada(8, 11)) {
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
