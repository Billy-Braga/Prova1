package conteúdo;

import java.util.List;
import java.util.Random;

public class Desenvolvedores {

	public Desenvolvedores(int posicaoX, int posicaoY) {
		super();
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}

	Random random = new Random();
	public int posicaoX = random.nextInt(15) + 1;
	public int posicaoY = random.nextInt(15) + 1;

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}

	public static List<Desenvolvedores> adicionarDevs(List<Desenvolvedores> desenvolvedores, int quantidadeDevs,
			boolean[][] posicoesOcupadas) {
		Random random = new Random();

		for (int i = 0; i < quantidadeDevs; i++) {
			int posicaoX, posicaoY;

			do {
				posicaoX = random.nextInt(15) + 1;
				posicaoY = random.nextInt(15) + 1;
			} while (posicoesOcupadas[posicaoX][posicaoY] || (posicaoX == 8 && posicaoY == 8));

			posicoesOcupadas[posicaoX][posicaoY] = true;

			desenvolvedores.add(new Desenvolvedores(posicaoX, posicaoY));
		}
		return desenvolvedores;
	}
}