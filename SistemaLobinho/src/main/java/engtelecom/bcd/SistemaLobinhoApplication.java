package engtelecom.bcd;

import engtelecom.bcd.model.*;
import engtelecom.bcd.repository.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class SistemaLobinhoApplication {
	@NonNull
	@Autowired
	private PessoaRepository pessoaRepository;

	@NonNull
	@Autowired
	private EspecialidadesRepository especialidadesRepository;

	@NonNull
	@Autowired
	private InsigniasRepository insigniasRepository;

	@NonNull
	@Autowired
	private DistintivosRepository distintivosRepository;

	@NonNull
	@Autowired
	private AcampamentosRepository acampamentosRepository;

	@NonNull
	@Autowired
	private AtividadesDeEspecialidadesFeitasRepository atividadesDeEspecialidadesFeitasRepository;

	@NonNull
	@Autowired
	private AtividadesDeEspecialidadesRepository atividadesDeEspecialidadesRepository;

	@NonNull
	@Autowired
	private AtividadesDeInsigniasRepository atividadesDeInsigniasRepository;

	@NonNull
	@Autowired
	private AtividadesDeDistintivosFeitasRepository atividadesDeDistintivosFeitasRepository;


	public static void main(String[] args) {
		SpringApplication.run(SistemaLobinhoApplication.class, args);
	}

	@Bean
	public CommandLineRunner principal(){
		return args -> {
			System.out.println("\n");
			menuPrincipal();
		};
	}


	public void menuPrincipal(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;

		String opcoes[] = {
				"Cadastro.",
				"Gerar relatório."
		};

		exibirOpcoes(opcoes);

		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + opcoes.length + ", 0 para sair): ");
			int opcao = entrada.nextInt();
			switch (opcao) {
				case 0:
					sair = true;
					break;
				case 1:
					menuCadastrar();
					break;
				case 2:
					menuGerarRelatorio();
					break;
				default:
					System.out.println("\nOpção inválida! Escolha dentre as opções abaixo:\n");
			}
			exibirOpcoes(opcoes);
		}
		System.exit(0);
	}


	public void menuGerarRelatorio(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;

		String opcoes[] = {
			"Listar dados bibliográficos de um jovem.",
			"Listar jovens com uma determinada especialidades.",
			"Listar as especialidades e insígnias de interesse especial que um determinado jovem possui.",
			"Listar os requisitos já cumpridos por um determinado jovem para uma determinada especialidade.",
			"Listar jovens que possuem todos os requisitos para obter o Cruzeiro do Sul."
		};

		while (! sair) {
			exibirOpcoes(opcoes);
			System.out.print("\nEscolha a opção desejada (1 .. " + opcoes.length + ", 0 para sair): ");
			int opcao = entrada.nextInt();

			switch (opcao) {
				case 0:
					sair = true;
					System.out.println("Voltando ao menu anterior.");
					break;
				case 1:
					listarDadosBibliograficos();
					break;
				case 2:
					listarJovensComDeterminadaEspecialidade();
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("\nOpção inválida! Escolha dentre as opções abaixo:\n");
			}

		}
	}

	private void menuCadastrar(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;

		String opcoes[] = {
				"Cadastrar novo lobinho.",
				"Registrar progresso."
		};

		while (! sair) {
			exibirOpcoes(opcoes);
			System.out.print("\nEscolha a opção desejada (1 .. " + opcoes.length + ", 0 para sair): ");
			int opcao = entrada.nextInt();

			switch (opcao) {
				case 0:
					sair = true;
					System.out.println("Voltando ao menu anterior.");
					break;
				case 1:
					 cadastrarNovoLobinho();
					break;
				case 2:
					 registrarProgresso();
					break;
				default:
					System.out.println("\nOpção inválida! Escolha dentre as opções abaixo:\n");
			}

		}
	}

	private void cadastrarNovoLobinho(){

	}

	private void registrarProgresso(){

	}

	private int exibirPessoas(){
		int numeroOpcao = 0;
		for (Pessoa pessoa : pessoaRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + pessoa.getNome());
		}
		return numeroOpcao;
	}

	private int exibirEspecialidades(){
		int numeroOpcao = 0;
		for (Especialidades especialidade : especialidadesRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + especialidade.getNome());
		}
		return numeroOpcao;
	}

	private int exibirInsignias(){
		int numeroOpcao = 0;
		for (Insignias insignia : insigniasRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + insignia.getNome());
		}
		return numeroOpcao;
	}

	private int exibirDistintivos(){
		int numeroOpcao = 0;
		for (Distintivos distintivo : distintivosRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + distintivo.getNome());
		}
		return numeroOpcao;
	}

	private int exibirAcampamentos(){
		int numeroOpcao = 0;
		for (Acampamentos acampamento : acampamentosRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + acampamento.getNome());
		}
		return numeroOpcao;
	}


	private int exibirOpcoes(String itens[]){
		int numeroOpcao = 0;
		for (String item : itens){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + item);
		}
		return numeroOpcao;
	}

	private void listarDadosBibliograficos(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;

		System.out.println("\n\nSelecione um jovem:\n");

		int quantidadeOpcoes = exibirPessoas();

		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + quantidadeOpcoes + ", 0 para sair): ");
			int opcao = entrada.nextInt();

			if (opcao == 0) {
				System.out.println("Voltando ao menu anterior.");
				sair = true;
			} else if (opcao < 1 || opcao > quantidadeOpcoes) {
				System.out.println("Opção inválida!");
			} else {
				var consulta = pessoaRepository.findById(opcao);

				if (consulta.isPresent()) {
					var objetoPessoa = consulta.get();

					System.out.println("Nome:               " + objetoPessoa.getNome());

					LocalDate dataNascimento = objetoPessoa.getDataNascimento().toLocalDate();
					int dia = dataNascimento.getDayOfMonth();
					int mes = dataNascimento.getMonthValue();
					int ano = dataNascimento.getYear();
					System.out.println("Data de nascimento: " + dia + "/" + mes + "/" + ano);

					String telefone = objetoPessoa.getTelefone();
					if (telefone != null) System.out.println("Telefone: " + telefone);

					String email = objetoPessoa.getEmail();
					if (email != null) System.out.println("E-mail: " + email);

					String tipoSanguineo = objetoPessoa.getTipoSanguineo().getTipo();
					System.out.println("Tipo sanguíneo:     " + tipoSanguineo);

					Set<ProblemasDeSaude> problemasDeSaude = objetoPessoa.getProblemasDeSaude();
					if (! problemasDeSaude.isEmpty()) {
						System.out.println("Dados de saúde: ");
						for (ProblemasDeSaude problemaDeSaude : problemasDeSaude){
							System.out.println(" - " + problemaDeSaude.getTipoDeProblema() + ": " + problemaDeSaude.getDescricao());
						}
					}

					Set<Responsavel> responsaveis = objetoPessoa.getResponsaveis();
					if (responsaveis != null) {
						if (responsaveis.size() > 1) System.out.println("Responsáveis: ");
						else System.out.println("Responsável: ");

						for (Responsavel responsavel : responsaveis){
							System.out.println(" - Nome:     " + responsavel.getNome());
							System.out.println(" - Telefone: " + responsavel.getTelefone());
							System.out.println(" - E-mail:   " + responsavel.getEmail());
						}
					}
				}
			}
		}
	}

	private void listarJovensComDeterminadaEspecialidade(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;

		System.out.println("\n\nSelecione uma especialidade:\n");

		int quantidadeOpcoes = exibirEspecialidades();

		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + quantidadeOpcoes + ", 0 para sair): ");
			int opcao = entrada.nextInt();

			if (opcao == 0) {
				System.out.println("Voltando ao menu anterior.");
				sair = true;
			} else if (opcao < 1 || opcao > quantidadeOpcoes) {
				System.out.println("Opção inválida!");
			} else {
				// Atividades da especialidade escolhida
				var consultaEspecialidade = especialidadesRepository.findById(opcao);
				var objetoEspecialidade = consultaEspecialidade.get();
				var atividades = atividadesDeEspecialidadesRepository.findAllByEspecialidadeOrderByIdAtividade(objetoEspecialidade);
				int quantidadeTotalDeAtividades = atividades.size();

				int indiceNivel1 = (quantidadeTotalDeAtividades / 3) - 1;
				int indiceNivel2 = ((quantidadeTotalDeAtividades * 2) / 3) - 1;
				int indiceNivel3 = quantidadeTotalDeAtividades - 1;

				var atividadesFeitas = atividadesDeEspecialidadesFeitasRepository.findAll();

				// Obtendo as pessoas que fizeram alguma atividade
				Set<Pessoa> pessoas = new HashSet<>();
				for (AtividadesDeEspecialidadesFeitas atividadePessoa : atividadesFeitas){
					pessoas.add(atividadePessoa.getPessoa());
				}

				System.out.println();

				// Verificando em cada pessoa as atividades da especialidade escolhida
				for (Pessoa pessoa : pessoas){
					ArrayList<AtividadesDeEspecialidades> atividadesRealizadas = new ArrayList<>();

					var atividadesFeitasPelaPessoa = atividadesDeEspecialidadesFeitasRepository.findAllByPessoaOrderByData(pessoa);

					for (AtividadesDeEspecialidadesFeitas atividadeFeitaPelaPessoa : atividadesFeitasPelaPessoa){
						if (atividadeFeitaPelaPessoa.getAtividadeDeEspecialidade().getEspecialidade().equals(objetoEspecialidade)){
							atividadesRealizadas.add(atividadeFeitaPelaPessoa.getAtividadeDeEspecialidade());
						}
					}

					System.out.println(pessoa.getNome() + " possui a especialidade " + objetoEspecialidade.getNome() + ": ");

					if (atividadesRealizadas.size() >= indiceNivel1+1) {
						AtividadesDeEspecialidades atividadeNivel1 = atividadesRealizadas.get(indiceNivel1);

						LocalDate dataNivel1 = atividadesDeEspecialidadesFeitasRepository.findAtividadesDeEspecialidadesFeitasByPessoaAndAtividadeDeEspecialidade(pessoa, atividadeNivel1).getData().toLocalDate();

						System.out.println(" - Nível 1: " + dataNivel1.getDayOfMonth() + "/" + dataNivel1.getMonthValue() + "/" + dataNivel1.getYear());
					}

					if (atividadesRealizadas.size() >= indiceNivel2+1) {
						AtividadesDeEspecialidades atividadeNivel2 = atividadesRealizadas.get(indiceNivel2);

						LocalDate dataNivel2 = atividadesDeEspecialidadesFeitasRepository.findAtividadesDeEspecialidadesFeitasByPessoaAndAtividadeDeEspecialidade(pessoa, atividadeNivel2).getData().toLocalDate();

						System.out.println(" - Nível 2: " + dataNivel2.getDayOfMonth() + "/" + dataNivel2.getMonthValue() + "/" + dataNivel2.getYear());
					}

					if (quantidadeTotalDeAtividades == atividadesRealizadas.size()) {
						AtividadesDeEspecialidades atividadeNivel3 = atividadesRealizadas.get(indiceNivel3);

						LocalDate dataNivel3 = atividadesDeEspecialidadesFeitasRepository.findAtividadesDeEspecialidadesFeitasByPessoaAndAtividadeDeEspecialidade(pessoa, atividadeNivel3).getData().toLocalDate();

						System.out.println(" - Nível 3: " + dataNivel3.getDayOfMonth() + "/" + dataNivel3.getMonthValue() + "/" + dataNivel3.getYear());
					}
					System.out.println();
				}
			}
		}
	}
}