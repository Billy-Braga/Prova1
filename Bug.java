package conteúdo;

import java.util.List;
import java.util.Random;

public class Bug {

	public Bug(int posicaoX, int posicaoY) {
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

	public static List<Bug> adicionarBugs(List<Bug> bugs, int quantidadeBugs, boolean[][] posicoesOcupadas) {
		Random random = new Random();

		for (int i = 0; i < quantidadeBugs; i++) {
			int posicaoX, posicaoY;

			do {
				posicaoX = random.nextInt(15) + 1;
				posicaoY = random.nextInt(15) + 1;
			} while (posicoesOcupadas[posicaoX][posicaoY] || (posicaoX == 8 && posicaoY == 8));

			posicoesOcupadas[posicaoX][posicaoY] = true;

			bugs.add(new Bug(posicaoX, posicaoY));
		}
		return bugs;
	}
}