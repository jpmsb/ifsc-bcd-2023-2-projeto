package engtelecom.bcd;

import engtelecom.bcd.model.Pessoa;
import engtelecom.bcd.model.ProblemasDeSaude;
import engtelecom.bcd.model.Responsavel;
import engtelecom.bcd.repository.PessoaRepository;
import engtelecom.bcd.repository.TipoSanguineoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class SistemaLobinhoApplication {
	@NonNull
	@Autowired
	private PessoaRepository pessoaRepository;

	@NonNull
	@Autowired
	private TipoSanguineoRepository tipoSanguineoRepository;

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

		System.out.println("Bem-vindo(a) ao Sistema Lobinho!!");
		System.out.println("Escolha dentre as opções abaixo para interagir com o sistema:\n");

		String opcoes[] = {
			"Listar dados bibliográficos de um jovem.",
			"Listar jovens com uma determinada especialidades.",
			"Listar as especialidades e insígnias de interesse especial que um determinado jovem possui.",
			"Listar os requisitos já cumpridos por um determinado jovem para uma determinada especialidade.",
			"Listar jovens que possuem todos os requisitos para obter o Cruzeiro do Sul."
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
					listarDadosBibliograficos();
					exibirOpcoes(opcoes);
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Opção inválida!");
			}
		}
		System.exit(0);
	}

	private int exibirOpcoes(Iterable<Pessoa> pessoas){
		int numeroOpcao = 0;
		for (Pessoa pessoa : pessoas){
			System.out.println(numeroOpcao + ". " + pessoa.getNome());
			numeroOpcao++;
		}
		return numeroOpcao;
	}

	private int exibirOpcoes(String itens[]){
		int numeroOpcao = 0;
		for (String item : itens){
			System.out.println(numeroOpcao + ". " + item);
			numeroOpcao++;
		}
		return numeroOpcao;
	}

	private void listarDadosBibliograficos(){
		Scanner entrada = new Scanner(System.in);
		boolean sair = false;


		System.out.println("Selecione um jovem:\n");

		int numeroOpcao = exibirOpcoes(pessoaRepository.findAll());

		while (! sair) {
			System.out.print("\nEscolha a opção desejada (1 .. " + numeroOpcao + ", 0 para sair): ");
			int opcao = entrada.nextInt();

			if (opcao == 0) {
				System.out.println("Voltando ao menu anterior.");
				sair = true;
			} else if (opcao < 1 || opcao > numeroOpcao) {
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
}