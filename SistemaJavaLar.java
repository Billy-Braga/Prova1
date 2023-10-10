package conteúdo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaJavaLar {

	private static final int Limite_Maximo = 224;

	public SistemaJavaLar() {

		menuSistemaJavaLar();

	}

	Scanner scanner = new Scanner(System.in);
	List<Planeta> planetas = Planeta.criarPlanetas();
	List<Planeta> falecidos = new ArrayList<>();
	List<Bug> bugs = new ArrayList<>();
	List<Bug> bugsRemovidos = new ArrayList<>();
	List<Desenvolvedores> desenvolvedores = new ArrayList<>();
	List<Desenvolvedores> devsRemovidos = new ArrayList<>();
	Relatório relatório = new Relatório(planetas);
	boolean[][] posicoesOcupadas = new boolean[16][16];

	private void menuSistemaJavaLar() {

		int totalInstantes = 0;
		int instantesDaRodada = 0;
		Plano plano = null;
		boolean continuarExecucao = true;

		while (continuarExecucao) {

			System.out.print(
					"┍—————————————————————————————————————————————————————————┑\n                   Escolha uma opção:\n"
							+ "\n1 - Inserir novo instante, bugs e desenvolvedores\n" + "2 - Encerrar o programa\n"
							+ "\nOpção: ");
			int opcao = scanner.nextInt();
			Planeta util = planetas.get(0);

			switch (opcao) {
			case 1:
				System.out.print("Informe a quantidade de instantes desejados: ");
				int instantesDesejados = scanner.nextInt();
				totalInstantes += instantesDesejados;

				relatório.registrarInstantes(totalInstantes);

				System.out.print("Informe a quantidade de bugs que deseja adicionar: ");
				int quantidadeBugs = scanner.nextInt();

				System.out.print("Informe a quantidade de devs que deseja adicionar: ");
				int quantidadeDevs = scanner.nextInt();

				try {
					validarQuantidades(quantidadeBugs, quantidadeDevs);

					plano = gerarInformações(instantesDesejados);
					gerarBugseDevs(plano, quantidadeBugs, quantidadeDevs);
					gerarDados(util, plano);
					gerarDistâncias(plano);
					instantesDaRodada = 0;

				} catch (LimiteExcedidoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				continuarExecucao = false;
				gerarRelatório(totalInstantes);

				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha 1 ou 2.");
				break;
			}
		}
		scanner.close();
	}

	private Plano gerarInformações(int instantesDesejados) {

		Plano plano;
		System.out.println("\nInformações dos Planetas após " + instantesDesejados + " instantes:");
		plano = new Plano(planetas, desenvolvedores, bugs);
		for (Planeta planeta : planetas) {
			planeta.zerarAnoPorRodada();
		}
		Planeta.agirPlanetas(planetas, instantesDesejados);
		return plano;
	}

	private void gerarBugseDevs(Plano plano, int quantidadeBugs, int quantidadeDevs) {
		System.out.println();
		Bug.adicionarBugs(bugs, quantidadeBugs, posicoesOcupadas);
		Desenvolvedores.adicionarDevs(desenvolvedores, quantidadeDevs, posicoesOcupadas);
		plano.verificarColisãoDev(desenvolvedores, devsRemovidos, posicoesOcupadas);
		plano.verificarColisãoBugs(bugs, bugsRemovidos, posicoesOcupadas);
		plano.explodirPlanetas(planetas, falecidos);
	}

	private void gerarDistâncias(Plano plano) {
		System.out.println("\nDistâncias entre:          Área        Euclidiana");
		plano.distâncias(planetas);
		System.out.println();
	}

	private void gerarDados(Planeta util, Plano plano) {
		plano.contarDevsEBugs();
		plano.mostrarBugs();
		plano.mostrarDevs();
		System.out.println("\n\nPlaneta           (X,Y)      Horas     Anos    Translação");
		plano.exibirDados();
		util.mostrarCardeais(planetas);
	}

	private void gerarRelatório(int totalInstantes) {
		System.out.println(
				" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ |RELATÓRIO| ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
		relatório.totalBugsEDevs();
		relatório.mostrarInstantes(totalInstantes);
		relatório.mostrarExplosões(falecidos);
		relatório.mostrarDadosFinais();
		relatório.mostrarResumos();
	}

	private void validarQuantidades(int quantidadeBugs, int quantidadeDevs) throws LimiteExcedidoException {
		if ((quantidadeBugs + bugs.size() + quantidadeDevs + desenvolvedores.size()) > Limite_Maximo) {
			throw new LimiteExcedidoException("\nQuantidades excedidas, tente novamente");
		}
	}
}
