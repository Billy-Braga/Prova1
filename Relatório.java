package conteúdo;

import java.util.ArrayList;
import java.util.List;

public class Relatório {

	private List<Planeta> planetas;

	public Relatório(List<Planeta> planetas) {
		this.planetas = planetas;
	}

	private int totalInstantes = 0;

	public void registrarInstantes(int instantes) {
		totalInstantes += instantes;
	}

	public void totalBugsEDevs() {
		for (Planeta planeta : planetas) {
			System.out.println(planeta.getNome() + " colidiu com " + planeta.getBugsColididos() + " bugs e "
					+ planeta.getDevsColididos() + " devs");
		}
	}

	public void mostrarDadosFinais() {
		System.out.println("Planeta             Rotação        Translação         Horas         Anos");
		for (Planeta planeta : planetas) {
			System.out.printf("%-19s%-4.1f Jm/i%10.2f Jm/i %14.1f %11d %n", planeta.nome, planeta.getRotação(),
					planeta.calcularVelocidadeMedia(), planeta.getTempoRodado(),planeta.getAnos());
		}
	}

	public void mostrarExplosões(List<Planeta> falecidos) {

		if (falecidos.isEmpty()) {
			System.out.println("\nNenhum Planeta Explodiu!\n");
		} else {
			System.out.println("\nOs seguintes Planetas explodiram: ");
			for (Planeta planeta : falecidos) {
				System.out.println(planeta.getNome());
			}
		}
	}

	public void mostrarInstantes(int totalInstantes) {
		System.out.println("\nQuantidade total de instantes do programa: " + totalInstantes);
	}

	public void mostrarResumos() {
		System.out.println("\n                  ———————————╳ Resumo dos nossos Planeta-Linguagens ╳———————————\n"
				+ "\nJava é uma linguagem de programação versátil e amplamente usada, semelhante ao Sol,\nque é o centro do nosso sistema solar. Ela é conhecida por sua portabilidade\ne é usada em uma variedade de aplicações, desde aplicativos móveis até sistemas empresariais.\r\n"

				+ "\nPython é como a Terra, pois é um planeta habitável e diversificado no universo da programação.\nÉ conhecida por sua simplicidade e é usada em ciência de dados, desenvolvimento web e automação.\r\n"

				+ "\nJavaScript é como Mercúrio, o planeta mais próximo do Sol. É amplamente utilizado no desenvolvimento\nweb para criar interações dinâmicas nos navegadores.\r\n"

				+ "\nPHP é como Marte, um planeta vermelho e dinâmico. É frequentemente usado no desenvolvimento\nde sites e aplicativos web para processamento de formulários e interações com bancos de dados.\r\n"

				+ "\nRuby on Rails é como Júpiter, um planeta grande e expansivo. É um framework de desenvolvimento web\nque permite a criação rápida de aplicativos web elegantes.\r\n"

				+ "\nC++ é como Saturno, com suas complexas estruturas de anéis. É usado em programação de sistemas,\njogos e aplicativos de alto desempenho.\r\n"

				+ "\nC# é como Urano, uma linguagem de programação moderna e inovadora. É usado principalmente para\ndesenvolvimento de software no Windows, jogos e aplicativos móveis.\r\n"

				+ "\nC é como Netuno, um dos planetas mais distantes e fundamentais do nosso sistema solar.É uma\nlinguagem de programação de baixo nível, usada no desenvolvimento de sistemas operacionais e hardware.");
	}
}
