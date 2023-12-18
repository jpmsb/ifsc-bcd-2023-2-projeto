package engtelecom.bcd;

import engtelecom.bcd.model.*;
import engtelecom.bcd.repository.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
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
	private AtividadesDeInsigniasFeitasRepository atividadesDeInsigniasFeitasRepository;

	@NonNull
	@Autowired
	private AtividadesDeDistintivosFeitasRepository atividadesDeDistintivosFeitasRepository;

	@NonNull
	@Autowired
	private TipoSanguineoRepository tipoSanguineoRepository;

	@NonNull
	@Autowired
	private ResponsavelRepository responsavelRepository;


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

	private Pessoa adicionarPessoa(String nome, int diaNasc, int mesNasc, int anoNasc, String telefone, String email, Integer idTipoSanguineo){
		var tipoSanguineo = tipoSanguineoRepository.findById(idTipoSanguineo);

		Pessoa pessoa = null;

		if (tipoSanguineo.isPresent()) {
			var objetoTipoSanguineo = tipoSanguineo.get();
			Date dataNascimento = Date.valueOf(LocalDate.of(anoNasc, mesNasc, diaNasc));
			Pessoa novaPessoa = new Pessoa(nome, dataNascimento, objetoTipoSanguineo);

			if (! telefone.isBlank()) novaPessoa.setTelefone(telefone);
			if (! email.isBlank()) novaPessoa.setEmail(email);

			pessoaRepository.save(novaPessoa);
			pessoa = novaPessoa;
		}
		return pessoa;
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
					System.out.println("\nEncerrando a aplicação...\n");
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
					System.out.println("\nVoltando ao menu anterior.\n");
					break;
				case 1:
					listarDadosBibliograficos();
					break;
				case 2:
					listarJovensComDeterminadaEspecialidade();
					break;
				case 3:
					 listarEspecialidadesEInsigniasDeUmJovem();
					break;
				case 4:
					 listarRequisitosFeitosJovemEspecialidade();
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
					System.out.println("\nVoltando ao menu anterior.\n");
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
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;
		int idTipoSanguineo = 0;
		Responsavel responsavel = null;
		Pessoa novaPessoa = null;

		System.out.print("Nome do jovem: ");
		String nome = entrada.nextLine();

		System.out.print("Digite o dia de nascimento: ");
		int diaNasc = entrada.nextInt();

		System.out.print("Digite o mês de nascimento: ");
		int mesNasc = entrada.nextInt();

		System.out.print("Digite o ano de nascimento: ");
		int anoNasc = entrada.nextInt();

		System.out.print("Digite o telefone: ");
		String telefone = entrada.nextLine();
		telefone = entrada.nextLine();

		System.out.print("Digite um e-mail: ");
		String email = entrada.nextLine();

		System.out.println("\nSelecione o tipo sanguíneo para o novo Lobinho:\n");
		int quantidadeOpcoes = exibirTiposSanguineos();

		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + quantidadeOpcoes + "): ");
			int opcao = entrada.nextInt();

			if (opcao < 1 || opcao > quantidadeOpcoes) {
				System.out.println("Opção inválida!");
			} else {
				var consulta = tipoSanguineoRepository.findById(opcao);
				var objetoTipoSanguineo = consulta.get();
				sair = true;
				idTipoSanguineo = objetoTipoSanguineo.getIdTipoSanguineo();
			}
		}

		novaPessoa = adicionarPessoa(nome, diaNasc, mesNasc, anoNasc, telefone, email, idTipoSanguineo);

		System.out.println("\nSelecione o resposável para esse lobinho:\n");
		quantidadeOpcoes = exibirResponsaveis();

		sair = false;
		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + quantidadeOpcoes + "): ");
			int opcao = entrada.nextInt();

			if (opcao < 1 || opcao > quantidadeOpcoes) {
				System.out.println("Opção inválida!");
			} else {
				var consulta = responsavelRepository.findById(opcao);
				responsavel = consulta.get();
				sair = true;
			}
		}

		novaPessoa.adicionarResponsavel(responsavel);
		pessoaRepository.save(novaPessoa);

		System.out.println("\nCadastro realizado!\n");
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

	private int exibirResponsaveis(){
		int numeroOpcao = 0;
		for (Responsavel responsavel : responsavelRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + responsavel.getNome());
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

	private int exibirTiposSanguineos(){
		int numeroOpcao = 0;
		for (TipoSanguineo tipoSanguineo : tipoSanguineoRepository.findAll()){
			numeroOpcao++;
			System.out.println(numeroOpcao + ". " + tipoSanguineo.getTipo());
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
				System.out.println("\nVoltando ao menu anterior.\n");
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

	private void mostrarDadosDeEspecialidadeParaJovem(Pessoa pessoa, Especialidades especialidade){
		var atividades = atividadesDeEspecialidadesRepository.findAllByEspecialidadeOrderByIdAtividade(especialidade);
		int quantidadeTotalDeAtividades = atividades.size();

		int indiceNivel1 = (quantidadeTotalDeAtividades / 3) - 1;
		int indiceNivel2 = ((quantidadeTotalDeAtividades * 2) / 3) - 1;
		int indiceNivel3 = quantidadeTotalDeAtividades - 1;

		ArrayList<AtividadesDeEspecialidades> atividadesRealizadas = new ArrayList<>();

		var atividadesFeitasPelaPessoa = atividadesDeEspecialidadesFeitasRepository.findAllByPessoaOrderByData(pessoa);

		for (AtividadesDeEspecialidadesFeitas atividadeFeitaPelaPessoa : atividadesFeitasPelaPessoa){
			if (atividadeFeitaPelaPessoa.getAtividadeDeEspecialidade().getEspecialidade().equals(especialidade)){
				atividadesRealizadas.add(atividadeFeitaPelaPessoa.getAtividadeDeEspecialidade());
			}
		}

		System.out.println("Especialidade " + especialidade.getNome() + " (" + especialidade.getAreaDeConhecimento().getNome() + "): ");

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
	}

	private void mostrarDadosDeInsigniaParaJovem(Pessoa pessoa, Insignias insignia){
		var atividades = atividadesDeInsigniasRepository.findAllByInsigniaOrderByIdAtividade(insignia);
		int quantidadeTotalDeAtividades = atividades.size();

		ArrayList<AtividadesDeInsignias> atividadesRealizadas = new ArrayList<>();

		var atividadesFeitasPelaPessoa = atividadesDeInsigniasFeitasRepository.findAllByPessoaOrderByData(pessoa);

		for (AtividadesDeInsigniasFeitas atividadeFeitaPelaPessoa : atividadesFeitasPelaPessoa){
			if (atividadeFeitaPelaPessoa.getAtividadeDeInsignia().getInsignia().equals(insignia)){
				atividadesRealizadas.add(atividadeFeitaPelaPessoa.getAtividadeDeInsignia());
			}
		}

		if (quantidadeTotalDeAtividades == atividadesRealizadas.size()) {
			AtividadesDeInsignias ultimaAtividadeFeita = atividadesRealizadas.get(quantidadeTotalDeAtividades-1);

			LocalDate dataUltimaAtividade = atividadesDeInsigniasFeitasRepository.findAtividadesDeInsigniasFeitasByPessoaAndAtividadeDeInsignia(pessoa, ultimaAtividadeFeita).getData().toLocalDate();

			System.out.println(insignia.getNome() + ": " + dataUltimaAtividade.getDayOfMonth() + "/"  + dataUltimaAtividade.getMonthValue() + "/" + dataUltimaAtividade.getYear());
		}
	}

	private int mostrarRequisitosEspecialidadeJovem(Pessoa pessoa, Especialidades especialidade){
		var atividadeDeEspecialidadesFeitas = atividadesDeEspecialidadesFeitasRepository.findAllByPessoa(pessoa);

		Set<AtividadesDeEspecialidades> atividadesFeitas = new HashSet<>();
		for (AtividadesDeEspecialidadesFeitas atividadeDeEspecialidade : atividadeDeEspecialidadesFeitas){
			if (atividadeDeEspecialidade.getAtividadeDeEspecialidade().getEspecialidade().equals(especialidade)) {
				atividadesFeitas.add(atividadeDeEspecialidade.getAtividadeDeEspecialidade());
			}
		}

		int numeroAtividade = 0;
		for (AtividadesDeEspecialidades atividade : atividadesFeitas){
			numeroAtividade++;
			System.out.println(numeroAtividade + ". " + atividade.getDescricao());
		}

		return numeroAtividade;
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
				System.out.println("\nVoltando ao menu anterior.\n");
				sair = true;
			} else if (opcao < 1 || opcao > quantidadeOpcoes) {
				System.out.println("Opção inválida!");
			} else {
				// Atividades da especialidade escolhida
				var consultaEspecialidade = especialidadesRepository.findById(opcao);
				var objetoEspecialidade = consultaEspecialidade.get();
				var atividadesFeitas = atividadesDeEspecialidadesFeitasRepository.findAll();

				// Obtendo as pessoas que fizeram alguma atividade
				Set<Pessoa> pessoas = new HashSet<>();
				for (AtividadesDeEspecialidadesFeitas atividadePessoa : atividadesFeitas){
					pessoas.add(atividadePessoa.getPessoa());
				}

				System.out.println();

				// Verificando em cada pessoa as atividades da especialidade escolhida
				for (Pessoa pessoa : pessoas){
					System.out.println("Jovem: " + pessoa.getNome() + ":");
					mostrarDadosDeEspecialidadeParaJovem(pessoa, objetoEspecialidade);
					System.out.println();
				}
			}
		}
	}

	private void listarEspecialidadesEInsigniasDeUmJovem(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;

		System.out.println("\n\nSelecione um jovem:\n");

		int quantidadeOpcoes = exibirPessoas();

		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + quantidadeOpcoes + ", 0 para sair): ");
			int opcao = entrada.nextInt();

			if (opcao == 0) {
				System.out.println("\nVoltando ao menu anterior.\n");
				sair = true;
			} else if (opcao < 1 || opcao > quantidadeOpcoes) {
				System.out.println("Opção inválida!");
			} else {
				// Obter objeto pessoa
				var consultaPessoa = pessoaRepository.findById(opcao);
				var objetoPessoa = consultaPessoa.get();

				var atividadesDeEspecialidadesFeitas = atividadesDeEspecialidadesFeitasRepository.findAllByPessoaOrderByData(objetoPessoa);
				var atividadesDeInsigniasFeitas = atividadesDeInsigniasFeitasRepository.findAllByPessoaOrderByData(objetoPessoa);

				System.out.println("\nJovem: " + objetoPessoa.getNome() + ":");

				// Obter as especialidades com alguma atividade feita
				Set<Especialidades> especialidadesFeitas = new HashSet<>();
				for (AtividadesDeEspecialidadesFeitas atividade : atividadesDeEspecialidadesFeitas){
					especialidadesFeitas.add(atividade.getAtividadeDeEspecialidade().getEspecialidade());
				}

				for (Especialidades especialidade : especialidadesFeitas){
					mostrarDadosDeEspecialidadeParaJovem(objetoPessoa, especialidade);
					System.out.println();
				}

				// Obter as insígnias com alguma atividade feita
				Set<Insignias> insigniasFeitas = new HashSet<>();
				for (AtividadesDeInsigniasFeitas atividade : atividadesDeInsigniasFeitas){
					insigniasFeitas.add(atividade.getAtividadeDeInsignia().getInsignia());
				}

				for (Insignias insignia : insigniasFeitas){
					mostrarDadosDeInsigniaParaJovem(objetoPessoa, insignia);
					System.out.println();
				}
			}
		}
	}

	private void listarRequisitosFeitosJovemEspecialidade(){
		Scanner entrada = new Scanner(System.in);
		boolean sairGeral = false;
		boolean sair = false;

		Pessoa objetoPessoa = null;
		Especialidades objetoEspecialidade = null;

		while (! sairGeral) {
			System.out.println("\n\nSelecione um jovem:\n");
			int quantidadeOpcoes = exibirPessoas();

			while (! sair) {
				System.out.print("\nEscolha o jovem que deseja consultar (1 .. " + quantidadeOpcoes + ", 0 para sair): ");
				int opcao = entrada.nextInt();

				if (opcao == 0) {
					System.out.println("\nVoltando ao menu anterior.\n");
					sairGeral = true;
					sair = true;
				} else if (opcao < 1 || opcao > quantidadeOpcoes) {
					System.out.println("Opção inválida!");
				} else {
					// Obter objeto pessoa
					var consultaPessoa = pessoaRepository.findById(opcao);
					objetoPessoa = consultaPessoa.get();
					sair = true;
				}
			}

			if (sairGeral) break;

			sair = false;
			System.out.println("\n\nSelecione uma especialidade:\n");
			quantidadeOpcoes = exibirEspecialidades();

			while (! sair) {
				System.out.print("\nEscolha a especialidade desejada (1 .. " + quantidadeOpcoes + ", 0 para sair): ");
				int opcao = entrada.nextInt();

				if (opcao == 0) {
					System.out.println("\nVoltando ao menu anterior.\n");
					sairGeral = true;
					sair = true;
				} else if (opcao < 1 || opcao > quantidadeOpcoes) {
					System.out.println("Opção inválida!");
				} else {
					// Obter objeto pessoa
					var consultaEspecialidade = especialidadesRepository.findById(opcao);
					objetoEspecialidade = consultaEspecialidade.get();
					sair = true;
				}
			}

			sair = false;
			System.out.println("\nEspecialidade " + objetoEspecialidade.getNome() + "\n");

			if (mostrarRequisitosEspecialidadeJovem(objetoPessoa, objetoEspecialidade ) == 0){
				System.out.println(objetoPessoa.getNome() + " não realizou atividades da especialidade " + objetoEspecialidade.getNome() + ".");
			}

			System.out.println("\nPressione ENTER para continuar...");
			entrada = new Scanner(System.in);
			entrada.nextLine();
		}
	}
}