package engtelecom.bcd;

import engtelecom.bcd.model.*;
import engtelecom.bcd.repository.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SistemaLobinhoRunner implements CommandLineRunner {
    @NonNull
    @Autowired
    private AreasDeConhecimentoRepository areasDeConhecimentoRepository;

    @NonNull
    @Autowired
    private EspecialidadesRepository especialidadesRepository;

    @NonNull
    @Autowired
    private AtividadesDeEspecialidadesRepository atividadesDeEspecialidadesRepository;

    @NonNull
    @Autowired
    private PessoaRepository pessoasRepository;

    @NonNull
    @Autowired
    private TipoSanguineoRepository tipoSanguineoRepository;

    @NonNull
    @Autowired
    private ResponsavelRepository responsavelRepository;

    @NonNull
    @Autowired
    private InsigniasRepository insigniasRepository;

    @NonNull
    @Autowired
    private AtividadesDeInsigniasRepository atividadesDeInsigniasRepository;

    @NonNull
    @Autowired
    private DistintivosRepository distintivosRepository;

    @NonNull
    @Autowired
    private AtividadesDeDistintivosRepository atividadesDeDistintivosRepository;

    @NonNull
    @Autowired
    private ProblemasDeSaudeRepository problemasDeSaudeRepository;

    @NonNull
    @Autowired
    private AcampamentosRepository acampamentosRepository;

    @NonNull
    @Autowired
    private AtividadesDeInsigniasFeitasRepository atividadesDeInsigniasFeitasRepository;

    @NonNull
    @Autowired
    private AtividadesDeDistintivosFeitasRepository atividadesDeDistintivosFeitasRepository;

    @NonNull
    @Autowired
    private AtividadesDeEspecialidadesFeitasRepository atividadesDeEspecialidadesFeitasRepository;

    public void adicionarAreasDeConhecimento(String[] areasDeConhecimento){
        for (String areaDeConhecimento : areasDeConhecimento) {
            AreasDeConhecimento novaAreaDeConhecimento = new AreasDeConhecimento(areaDeConhecimento);
            areasDeConhecimentoRepository.save(novaAreaDeConhecimento);
        }
    }

    private void adicionarInsignias(String[] insignias){
        for (String insignia : insignias) {
            Insignias novaInsignia = new Insignias(insignia);
            insigniasRepository.save(novaInsignia);
        }
    }

    private void adicionarDistintivos(String[] distintivos){
        for (String distintivo : distintivos) {
            Distintivos novoDistintivo = new Distintivos(distintivo);
            distintivosRepository.save(novoDistintivo);
        }
    }

    private void adicionarTiposSanguineos(String[] tipos){
        for (String tipo : tipos) {
            TipoSanguineo novoTipo = new TipoSanguineo(tipo);
            tipoSanguineoRepository.save(novoTipo);
        }
    }

    private void adicionarProblemaDeSaude(String tipo, String descricao){
        ProblemasDeSaude novoProblema = new ProblemasDeSaude(tipo, descricao);
        problemasDeSaudeRepository.save(novoProblema);
    }

    private void adicionarAcampamento(String nome, int dia, int mes, int ano){
        Date dataAcampamento = Date.valueOf(LocalDate.of(ano, mes, dia));
        Acampamentos novoAcampamento = new Acampamentos(nome, dataAcampamento);
        acampamentosRepository.save(novoAcampamento);
    }

    private void adicionarResponsavel(String nome, String telefone, String email){
        Responsavel novoResponsavel = new Responsavel(nome, telefone, email);
        responsavelRepository.save(novoResponsavel);
    }

    private void adicionarPessoa(String nome, int diaNasc, int mesNasc, int anoNasc, String nomeTipoSanguineo){
        var tipoSanguineo = tipoSanguineoRepository.findTipoSanguineoByTipo(nomeTipoSanguineo);

        if (tipoSanguineo.isPresent()) {
            var objetoTipoSanguineo = tipoSanguineo.get();
            Date dataNascimento = Date.valueOf(LocalDate.of(anoNasc, mesNasc, diaNasc));
            Pessoa novaPessoa = new Pessoa(nome, dataNascimento, objetoTipoSanguineo);
            pessoasRepository.save(novaPessoa);
        }
    }

    private void adicionarEspecialidades(String[] especialidades, String areaDeConhecimento){
        var areaDeConhec = areasDeConhecimentoRepository.findAreasDeConhecimentoByNome(areaDeConhecimento);

        if (areaDeConhec.isPresent()) {
            var objetoAreaDeConhecimento = areaDeConhec.get();

            for (String especialidade : especialidades) {
                Especialidades novaEspecialidade = new Especialidades(especialidade, objetoAreaDeConhecimento);
                especialidadesRepository.save(novaEspecialidade);
            }
        }

    }

    private void adicionarAtividadesDeEspecilidades(String[] atividades, String nomeEspecialidade){
        var especialidade = especialidadesRepository.findEspecialidadesByNome(nomeEspecialidade);

        if (especialidade.isPresent()) {
            var objetoEspecialidade = especialidade.get();
            for (String atividade : atividades) {
                AtividadesDeEspecialidades novaAtividadeDeEspecialidade = new AtividadesDeEspecialidades(atividade, objetoEspecialidade);
                atividadesDeEspecialidadesRepository.save(novaAtividadeDeEspecialidade);
            }
        }
    }

    private void adicionarAtividadesDeInsignias(String[] atividades, String nomeInsignia){
        var insignia = insigniasRepository.findInsigniasByNome(nomeInsignia);

        if (insignia.isPresent()) {
            var objetoInsignia = insignia.get();
            for (String atividade : atividades) {
                AtividadesDeInsignias novaAtividadeDeInsignia = new AtividadesDeInsignias(atividade, objetoInsignia);
                atividadesDeInsigniasRepository.save(novaAtividadeDeInsignia);
            }
        }
    }

    private void adicionarAtividadesDeDistintivos(String[] atividades, String nomeDistintivo){
        var distintivo = distintivosRepository.findDistintivosByNome(nomeDistintivo);

        if(distintivo.isPresent()){
            var objetoDistintivo = distintivo.get();
            for (String atividade : atividades) {
                AtividadesDeDistintivos novaAtividadeDeDistintivo = new AtividadesDeDistintivos(atividade, objetoDistintivo);
                atividadesDeDistintivosRepository.save(novaAtividadeDeDistintivo);
            }
        }
    }

    private void adicionarVinculo(Integer idResponsavel, Integer idPessoa){
        var pessoa = pessoasRepository.findById(idPessoa);
        var responsavel = responsavelRepository.findById(idResponsavel);
        if (pessoa.isPresent() && responsavel.isPresent()){
            var objetoPessoa = pessoa.get();
            var objetoResponsavel = responsavel.get();

            objetoPessoa.adicionarResponsavel(objetoResponsavel);
            pessoasRepository.save(objetoPessoa);
        }
    }

    private void adicionarDadosDeSaude(Integer idPessoa, Integer idProblemaDeSaude){
        var pessoa = pessoasRepository.findById(idPessoa);
        var problemaDeSaude = problemasDeSaudeRepository.findById(idProblemaDeSaude);

        if (pessoa.isPresent() && problemaDeSaude.isPresent()){
            var objetoPessoa = pessoa.get();
            var objetoProblemaDeSaude = problemaDeSaude.get();

            objetoPessoa.adicionarDadoSaude(objetoProblemaDeSaude);
            pessoasRepository.save(objetoPessoa);
        }
    }

    private void adicionarNoitesAcampadas(Integer idPessoa, Integer idAcampamento){
        var pessoa = pessoasRepository.findById(idPessoa);
        var acampamento = acampamentosRepository.findById(idAcampamento);

        if (pessoa.isPresent() && acampamento.isPresent()){
            var objetoPessoa = pessoa.get();
            var objetoAcampamento = acampamento.get();

            objetoPessoa.adicionarNoiteAcampada(objetoAcampamento);
            pessoasRepository.save(objetoPessoa);
        }
    }

    private void adicionarAtividadesDeInsigniasFeitas(Integer idPessoa, Integer idAtividade, int dia, int mes, int ano){
        var pessoa = pessoasRepository.findById(idPessoa);
        var atividade = atividadesDeInsigniasRepository.findById(idAtividade);

        if (pessoa.isPresent() && atividade.isPresent()) {
            var objetoPessoa = pessoa.get();
            var objetoAtividade = atividade.get();

            Date data = Date.valueOf(LocalDate.of(ano, mes, dia));
            var atividadeDeInsigniaFeita = new AtividadesDeInsigniasFeitas(objetoAtividade, objetoPessoa, data);
            atividadesDeInsigniasFeitasRepository.save(atividadeDeInsigniaFeita);
        }
    }

    private void adicionarAtividadesDeDistintivosFeitas(Integer idPessoa, Integer idAtividade, int dia, int mes, int ano){
        var pessoa = pessoasRepository.findById(idPessoa);
        var atividade = atividadesDeDistintivosRepository.findById(idAtividade);

        if (pessoa.isPresent() && atividade.isPresent()) {
            var objetoPessoa = pessoa.get();
            var objetoAtividade = atividade.get();

            Date data = Date.valueOf(LocalDate.of(ano, mes, dia));
            var atividadeDeDistintivoFeita = new AtividadesDeDistintivosFeitas(objetoAtividade, objetoPessoa, data);
            atividadesDeDistintivosFeitasRepository.save(atividadeDeDistintivoFeita);
        }
    }

    private void adicionarAtividadesDeEspecialidadesFeitas(Integer idPessoa, Integer idAtividade, int dia, int mes, int ano){
        var pessoa = pessoasRepository.findById(idPessoa);
        var atividade = atividadesDeEspecialidadesRepository.findById(idAtividade);

        if (pessoa.isPresent() && atividade.isPresent()) {
            var objetoPessoa = pessoa.get();
            var objetoAtividade = atividade.get();

            Date data = Date.valueOf(LocalDate.of(ano, mes, dia));
            var atividadeDeEspecialidadeFeita = new AtividadesDeEspecialidadesFeitas(objetoAtividade, objetoPessoa, data);
            atividadesDeEspecialidadesFeitasRepository.save(atividadeDeEspecialidadeFeita);
        }
    }

    private void povoandoBanco(){
        // Adicionando áreas de conhecimento
        String tiposSanguineos[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        this.adicionarTiposSanguineos(tiposSanguineos);

        // Adicionando áreas de conhecimento
        String areasDeConhecimento[] = {
                "Ciência e Tecnologia",
                "Cultura",
                "Desportos",
                "Habilidades Escoteiras",
                "Serviços"
        };

        this.adicionarAreasDeConhecimento(areasDeConhecimento);

        // Adicionando as especialidades de ciência e tecnologia
        String especialidadesCT[] = {
                "Automobilismo Rádio Controlado",
                "Comunicações",
                "Criptografia",
                "Echolink",
                "Eletrônica",
                "Energia",
                "Engenharia",
                "GPS",
                "Informática",
                "Invenção",
                "Programação",
                "Robótica"
        };

        this.adicionarEspecialidades(especialidadesCT, "Ciência e Tecnologia");

        // Adicionando as especialidades de habilidades escoteiras
        String especialidadesHE[] = {
                "Acampamento",
                "Culinária"
        };

        this.adicionarEspecialidades(especialidadesHE, "Habilidades Escoteiras");

        // Adicionando as especilidades de serviços
        String especialidadesServicos[] = {
                "Radioamadorismo",
                "Radioescuta",
                "Faixa do Cidadão",
                "Internet"
        };

        this.adicionarEspecialidades(especialidadesServicos, "Serviços");

        // Adicionando insígnias
        String insignias[] = {
                "Insígnia do Aprender",
                "Insígnia do Cone Sul",
                "Insígnia da Boa Ação",
                "Insígnia da Lusofonia",
                "Insígnia Campeões da Natureza",
                "Insígnia Reduzir, Reciclar, Reutilizar",
                "Insígnia Escoteiros pela Energia Solar"
        };

        this.adicionarInsignias(insignias);

        // Adicionando distintivos
        String distintivos[] = {
                "Lobo Pata Tenra",
                "Lobo Saltador",
                "Lobo Rastreador",
                "Lobo Caçador",
                "Cruzeiro do Sul"
        };

        this.adicionarDistintivos(distintivos);

        // Adicionando atividades de especialidades
        // Especialidade acampamento
        String atividadesAcampamento[] = {
                "Montar, desmontar, dobrar e acondicionar uma barraca.",
                "Escolher as técnicas de conservação de uma barraca, executando pequenos reparos na lona, quarto e varetas.",
                "Escolher locais seguros para montar uma barraca.",
                "Explicar os cuidados a adotar em casos de temporais e alagamentos.",
                "Cuidar e tratar do lixo quando em acampamento.",
                "Montar 1 (um) canto de matilha/patrulha, considerando os padrões de acampamento e com auxílio da matilha/patrulha.",
                "Cozinhar uma refeição simples individual em fogo de lenha, sem utilizar utensílios de cozinha.",
                "Fazer pelo menos 5 (cinco) pioneirias diferentes e úteis em acampamentos, utilizando amarras.",
                "Acampar por 3 (três) noites sem utilizar barraca, dormindo em abrigo natural ou em saco de dormir especial para o relento.",
                "Orientar-se por meio de cartas topográficas, com e sem emprego de bússola.",
                "Improvisar barraca, mochila, espeques, esteios e artigos semelhantes, utilizando-os durante 1 (um) acampamento ou jornada.",
                "Demonstrar uso dos seguintes nós e voltas: de correr, escota duplo, em oito, balso pelo seio, arnês, fiel, ribeira, redonda com cotes e do salteador.",
                "Demonstrar os cuidados para com o material necessário para 1 (um) acampamento.",
                "Elaborar 1 (um) cardápio e lista de gêneros para as refeições da seção durante 1 (um) acampamento e uma jornada, ambos com duração igual a 1 (um) fim de semana.",
                "Acondicionar os gêneros alimentícios para 1 (um) acampamento e uma jornada.",
                "Preparar o material individual para 1 (um) acampamento e para uma jornada, ambos com duração igual a 1 (um) fim de semana.",
                "Fazer 1 (um) projeto de 1 (um) acampamento suspenso, listando o material necessário, custos e os aspectos de segurança, e executá-lo.",
                "Elaborar e executar uma programação de 1 (um) acampamento da matilha/patrulha, com duração igual a 1 (um) fim de semana."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesAcampamento, "Acampamento");


        // Especialidade culinária
        String atividadesCulinaria[] = {
                "Abrir latas de conserva, cortar legumes e preparar uma bebida.",
                "Identificar os utensílios necessários para a preparação de uma refeição definida pelo examinador.",
                "Fritar ovos e preparar saladas, decorando os pratos, e preparar uma bebida quente.",
                "Fazer uma lista dos mantimentos com quantidades necessárias para uma refeição festiva para a seção.",
                "Explicar como conservar os alimentos conforme a temperatura ambiente.",
                "Preparar 1 (um) cardápio equilibrado para 1 (um) acampamento de final de semana, calculando as quantidades dos gêneros para a matilha/patrulha.",
                "Cozinhar para a matilha/patrulha durante 1 (um) acampamento de final de semana, a lenha e a gás, demonstrando cuidados com a segurança e a higiene.",
                "Preparar alguma iguaria da cozinha mateira, como pão de caçador, ovo na laranja, ovo no espeto, carne moída no espeto, etc.",
                "Projetar e participar da montagem da cozinha do canto da matilha/patrulha em 1 (um) acampamento, justificando os cuidados adotados para reduzir os riscos de incêndio.",
                "Preparar, em 1 (um) acampamento, 3 (três) tipos de sobremesa.",
                "Limpar e preparar uma peça de carne e 1 (um) peixe.",
                "Construir uma intendência no canto de matilha/patrulha, durante 1 (um) acampamento."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesCulinaria, "Culinária");


        // Especialidade radioamadorismo
        String atividadesRadioamadorismo[] = {
                "Conhecer a regulamentação governamental relacionada com o radioamadorismo, no que se refere ao uso, prática e ética operacional.",
                "Elaborar 1 (um) diagrama e explicar à seção os princípios elementares dos aparelhos transmissores e receptores de rádio.",
                "Identificar, nos arredores de sua casa ou da sede, 3 (três) tipos ou modelos de antenas destinadas ao radioamadorismo, conhecendo suas principais características.",
                "Explicar como aterrar e proteger dos raios uma estação de rádio.",
                "Identificar pelo menos 2 (dois) modelos de transceptores, explicando à seção as características de cada um.",
                "Elaborar e expor à seção 1 (um) trabalho sobre o uso de repetidoras.",
                "Preparar e aplicar 1 (um) jogo diretamente ligado ao radioamadorismo.",
                "Apresentar à seção 1 (um) trabalho que exponha os princípios básicos do uso do radioamadorismo em operações de emergência.",
                "Elaborar 1 (um) cartão QSL pessoal contendo o símbolo do Radioescotismo.",
                "Manter contato de forma ágil com outras 3 (três) estações, sendo pelo menos uma delas uma estação escoteira.",
                "Instalar e pôr em funcionamento 1 (um) sistema de comunicação via rádio em uma atividade externa.",
                "Apresentar a licença de sua estação de radioamador expedida pelo órgão oficial competente."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesRadioamadorismo, "Radioamadorismo");


        // Especialidade radioescuta
        // System.out.println("Adicionando atividades da especialidade radioescuta...");
        String atividadesRadioescuta[] = {
                "Promover, sozinho ou com sua estação ou matilha/patrulha e na presença de seu examinador, duas visitas a estações de radioamador e uma visita a uma estação comercial de rádio ou televisão, apresentando relatório à seção.",
                "Relatar por escrito 1 (um) mínimo de 5 (cinco) estações de rádio que transmitam em ondas curtas programas em língua portuguesa e outras 5 (cinco) que transmitam em língua estrangeira, descrevendo horários, frequência e conteúdo da programação.",
                "Identificar e demonstrar o uso e a utilidade dos comandos e controles de 1 (um) rádio receptor.",
                "Fazer uma exposição de cartões QSL com pelo menos vinte exemplares, sendo três, no mínimo, pertencentes a estações escoteiras.",
                "Interpretar pelo menos 5 (cinco) expressões do Código Q, 5 (cinco) letras do Código Fonético Internacional e 5 (cinco) letras do Código Morse, ouvidas em transmissões.",
                "Reconhecer pelo menos 6 (seis) indicativos de chamada de países diferentes, ouvidos em transmissões."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesRadioescuta, "Radioescuta");


        // Especialidade faixa do cidadão
        String atividadesFaixaDoCidadao[] = {
                "Conhecer a técnica e a ética operacional quanto ao uso de radiotransmissores.",
                "Apresentar 1 (um) relatório contendo 1 (um) mínimo de vinte contatos feitos por si próprio.",
                "Realizar uma palestra sobre os serviços de faixa do cidadão.",
                "Conhecer os principais canais de emergência e seu uso correto.",
                "Elaborar 1 (um) cartaz contendo, pelo menos, quinze das principais gírias utilizadas na faixa do cidadão, exibindo-o no jornal mural da seção ou do Grupo Escoteiro.",
                "Descrever 3 (três) tipos de antenas para uso nos rádios de faixa do cidadão.",
                "Elaborar e aplicar 1 (um) jogo envolvendo rádios da faixa do cidadão.",
                "Participar de uma atividade com a comunidade usando sua estação e apresentando 1 (um) relatório ao final.",
                "Apresentar sua licença de faixa do cidadão emitida pelo órgão governamental competente."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesFaixaDoCidadao, "Faixa do Cidadão");


        // Especialidade Internet
        String atividadesInternet[] = {
                "Apresentar a história e a evolução da internet no Mundo e no Brasil para sua seção, através de palestras ou cartazes ou apresentação multimídia.",
                "Configurar 1 (um) computador para acessar a internet através do tipo de conexão disponível no local de realização da especialidade, explicando as configurações mínimas necessárias e demonstrar o funcionamento dessa conexão acessando pelo menos 3 (três) sites escoteiros.",
                "Apresentar 1 (um) trabalho com números estatísticos sobre a Internet identificando quais as faixas etárias, sexo e o tipo de informação procurada pelos internautas, bem como a origem destas informações.",
                "Conhecer o significado, origem e utilização de pelo menos quinze termos comuns na Internet. Exemplos: WWW, WW2, FTP, HTTP, Telnet, Backbone, Browser, TCP/IP, Java, HTML, CGI, ASP, JavaScript, VBScript, Links Dedicados, CableModem, WAP, ADSL e outros que o examinador solicitar.",
                "Utilizar 1 (um) site de pesquisa para encontrar pelo menos doze sites escoteiros na Internet, que deverão ser listados em 1 (um) cartaz e divulgado em sua seção, sendo: o site da Comunidade de Escotismo Lusófono, quatro sites de associações escoteiras de outros países, o site da UEB, quatro sites de grupos escoteiros brasileiros e quatro sites de regiões escoteiras do Brasil.",
                "Listar e divulgar na sua seção pelo menos 4 (quatro) especialidades e os respectivos itens que podem ser conquistados através do conteúdo de páginas na Internet encontradas por você.",
                "Apresentar o processo para o registro de 1 (um) novo domínio brasileiro, citando quais os possíveis tipos e quais os sufixos de domínios de pelo menos outros 10 (dez) países.",
                "Realizar uma visita técnica a 1 (um) provedor ou empresa de fornecimento/distribuição de internet ou data center de uma instituição de ensino para conhecer os equipamentos e/ou aplicativos necessários para o seu funcionamento.",
                "Enviar, por e-mail, 1 (um) relatório final da realização de sua especialidade, contando sua experiência e indicando a dificuldade dos itens realizados.",
                "Fazer uma apresentação à seção sobre os perigos da internet, phishing scan, hoax, abuso sexual, entre outros.",
                "Fazer uma apresentação à seção sobre as questões relacionadas aos direitos autorais e dos crimes que envolvem o download de programas, vídeos e músicas sem autorização dos seus autores ou sem o devido pagamento por eles.",
                "Apresentar 1 (um) trabalho sobre redes sociais, apontando suas diferentes aplicações, listando e explicando o funcionamento de pelo menos 3 (três) grandes sites de redes sociais."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesInternet, "Internet");


        // Especialidade automobilismo radio controlado
        String atividadesAutomobilismoRadioControlado[] = {
                "Explicar as diferenças entre 1 (um) modelo on-road e outro off-road.",
                "Explicar a diferença de caster e cambagem num automodelo e para que servem.",
                "Afinar (ajustar) 1 (um) motor a combustão e em caso de motor elétrico trocar 1 (um) par de escovas (carvão).",
                "Montar apresentar 1 (um) modelo escolhido.",
                "Explicar o funcionamento de 1 (um) diferencial e como montá-lo.",
                "Descrever o processo de limpeza e manutenção de 1 (um) automodelo.",
                "Trimar o rádio de 1 (um) automodelo a combustão e no caso de automodelo elétrico, e ajustar 1 (um) speed control.",
                "Ligar, ajustar (se necessário) e fazer uma demonstração num percurso rabiscado no chão em forma de oito.",
                "Explicar qual a composição do combustível (metanol) para auto modelos a combustão e em casos de elétricos descrever o processo de carga e descarga de uma bateria elétrica.",
                "Explicar qual a diferença básica entre rádio “stick” e “wheel” (volante).",
                "Pintar, recortar e instalar uma bolha (carroceria).",
                "Ter participado de pelo menos 1 (um) torneio de automodelismo."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesAutomobilismoRadioControlado, "Automobilismo Rádio Controlado");


        // Especialidade criptografia
        String atividadesCriptografia[] = {
                "Entender o que é encriptação e decriptação e realizar uma apresentação sobre o assunto.",
                "Saber o que é criptografia e explicar o seu significado e sua utilidade.",
                "Conhecer e apresentar a história de Alan Turing e sua importância na história da criptografia.",
                "Conhecer e explicar o que foi a Cifra de César e qual a importância dela na história da criptografia.",
                "Conhecer a diferença entre Cifras e Códigos.",
                "Conhecer e explicar a importância da frequência das letras em uma mensagem criptografada e qual sua vantagem para conseguir descriptografá-la.",
                "Conhecer 3 tipos de cifras ou códigos incluindo a função totiente de Euler, quando foram criadas e para que são usadas.",
                "Criar e apresentar sua própria cifra e código explicando-a.",
                "Realizar 1 (um) texto com algum tipo de cifra e código falando sobre o escotismo com no mínimo quinze palavras.",
                "Conhecer e explicar o sigilo perfeito exemplificando-o.",
                "Conhecer e explicar o que é a configuração da chave e o que é o espaço da chave e o que é criptografia de chave pública.",
                "Explique a importância da criptografia no armazenamento de dados e informações para a segurança pessoal."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesCriptografia, "Criptografia");


        // Especialidade echolink
        String atividadesEcholink[] = {
                "Baixar o software e configurá-lo no modo simples.",
                "Fazer contato com pelo menos 3 (três) usuários e 3 (três) conferências de fora da sua unidade federativa.",
                "Gravar pelo menos 9 (nove) minutos de conversação.",
                "Ser possuidor de licença de radioamador.",
                "Adquirir a licença de uso do Echolink.",
                "Conectar através de Proxy.",
                "Configurar o programa em modo link.",
                "Montar uma interface para funcionar em modo link.",
                "Criar 1 (um) anúncio para sua estação."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesEcholink, "Echolink");


        // Especialidade eletrônica
        String atividadesEletronica[] = {
                "Projetar 1 (um) diagrama esquemático simples de 1 (um) aparelho eletrônico, utilizando resistores, capacitores, transistores e circuitos integrados; utilizar a simbologia correta para representar cada 1 (um) deles.",
                "Demonstrar a forma correta de soldar e dessoldar componentes eletrônicos, bem como os cuidados a serem tomados para evitar sua inutilização.",
                "Pesquisar sobre o desenvolvimento da válvula incandescente, como se deu sua descoberta, que utilizações teve e que tipos de material foram utilizados por seu inventor.",
                "Pesquisar sobre o que é 1 (um) elemento “N” e 1 (um) elemento “P”, de que materiais são elaborados e o que fazem estes elementos em dispositivos eletrônicos.",
                "Conhecer os diodos e explicar como funcionam.",
                "Projetar, desenhar, preparar e montar uma placa de circuito impresso.",
                "Construir 1 (um) receptor simples de AM ou FM e entender seu funcionamento.",
                "Demonstrar que conhece o uso correto de ferramentas e aparelhos de medição mais comuns em 1 (um) laboratório de eletrônica (osciloscópio, multímetro etc.).",
                "Conhecer as principais áreas de aplicação da eletrônica, explicando uma delas."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesEletronica, "Eletrônica");


        // Especialidade energia
        String atividadesEnergia[] = {
                "Explicar quais são as diferenças entre usinas termoelétricas, nucleares, hidrelétricas (UHE E PCH), biomassa, eólica.",
                "Apresentar 1 (um) trabalho sobre uma forma de energia, escolhendo entre a energia solar, a energia térmica a energia eólica, a energia hidráulica, a energia nuclear, energia provida de biomassa, energia maremotriz e energia geotérmica.",
                "Apresentar o esquema de funcionamento de uma usina hidrelétrica (UHE e PCH).",
                "Selecionar e analisar 2 (dois) artigos de jornal ou revista sobre 2 (dois) tipos diferentes de energia.",
                "Apresentar 1 (um) estudo sobre as vantagens e desvantagens para o Brasil dos tipos de energia citados no item 2.",
                "Formular e apresentar 1 (um) projeto para economizar energia em sua casa.",
                "Entender e explicar as razões para a utilização do horário de verão.",
                "Desenvolver 1 (um) projeto de captação e utilização de energia eólica, solar, hidráulica ou biomassa, construindo 1 (um) protótipo e explicando seu funcionamento.",
                "Desenvolver 1 (um) trabalho de conscientização da comunidade (pode ser o próprio Grupo Escoteiro ou sua turma na escola) em relação à necessidade de economizar energia, aos impactos ambientais da utilização de diferentes formas de energia ou ao custo social da utilização da energia. Abordar também sobre: o significado e importância da MME, EPE, ANEEL, ONS, CCEE. Descrever como é formada a atual Matriz Energética Elétrica Mundial e Brasileira, mostrando as diferenças entre 1 (um) país a sua escolha e o Brasil. Explanar sobre os atuais grupos tarifários aplicados no Brasil conforme a resolução Aneel e as diferenças entre o consumidor residencial, comercial e industrial. Explicar sobre a composição do sistema elétrico em relação aos segmentos de geração, transmissão e distribuição (GTD)."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesEnergia, "Energia");


        // Especialidade engenharia
        String atividadesEngenharia[] = {
                "Visitar 1 (um) canteiro de obras, discutindo com o engenheiro responsável o projeto, suas características e principais dados relativos à obra.",
                "Visitar 1 (um) escritório de engenharia e relatar o dia-a-dia dos profissionais do ramo.",
                "Apresentar 1 (um) trabalho sobre 4 (quatro) tipos de engenharia, escolhendo entre: civil, mecânica, química, eletrônica, de minas, de produção, elétrica, de alimentos, metalúrgica, agronômica, cartográfica, industrial, física, de computação e florestal ou outra à sua escolha. O trabalho apresentado pode ser em forma de vídeo, cartaz, apresentação de slides ou outro recurso midiático à sua escolha.",
                "Apresentar duas reportagens sobre uma das engenharias selecionadas no item 3, sendo uma recente e outra antiga (de pelo menos 10 (dez) anos), destacando a evolução da engenharia nesse período.",
                "Falar sobre a importância dos cálculos e medidas de precisão utilizadas na engenharia, apresentando 6 ((seis) casos onde são utilizadas, exemplificando cada um.",
                "Apresentar 2 (dois) projetos referentes a pelo menos 1 (um) tipo de engenharia proposta no item 3, dando ênfase a sua necessidade.",
                "Apresentar diferenças entre engenharia civil e arquitetura; diferenças entre a engenharia elétrica e eletrônica e diferenças entre a engenharia mecânica e mecatrônica.",
                "Descrever o campo de trabalho de, pelo menos, 4 (quatro) tipos de engenharia, comentando sua importância social e para o desenvolvimento do país.",
                "Apresentar pelo menos 4 (quatro) princípios de engenharia utilizados na Idade Média e no Renascimento e que são usados até hoje, destacando como eram utilizados naquela época e como são aplicados hoje em dia."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesEngenharia, "Engenharia");


        // Especialidade GPS
        String atividadesGPS[] = {
                "Possuir noções de coordenadas geográficas, coordenadas UTM, paralelos e meridianos.",
                "Fazer 1 (um) breve relato sobre o sistema GPS e suas aplicações.",
                "Explicar o que é o Datum no sistema GPS, e mostrar onde encontrar o Datum de 1 (um) mapa e como alterar o Datum do aparelho de GPS.",
                "Saber os fatores que fazem com que o GPS não forneça sua localização.",
                "Estar familiarizado com os termos habitualmente utilizados no Sistema de Posicionamento Global.",
                "Conhecer o Sistema Glonass, Galileo e Compass.",
                "Explicar o multicaminhamento e outros fatores que afetam a precisão do Sistema GPS.",
                "Demonstrar como transferir pontos de 1 (um) mapa para a memória do GPS.",
                "Demonstrar como marcar pontos.",
                "Encontrar 1 (um) ponto de coordenadas solicitado pelo examinador.",
                "Fazer uma jornada de 2 (dois) quilômetros marcando pontos de interesse do examinador.",
                "Efetuar 1 (um) mapeamento de uma área de acampamento definido pelo examinador."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesGPS, "GPS");


        // Especialidade informática
        String atividadesInformatica[] = {
                "Apresentar a história dos computadores, desde os primeiros instrumentos, como o ábaco, até os equipamentos mais modernos, caracterizando as diferenças entre cada uma das gerações de computadores pessoais.",
                "Listar as partes internas de 1 (um) microcomputador, os acessórios básicos para seu funcionamento, montá-lo e desmontá-lo corretamente demonstrando conhecer os cuidados necessários para sua ligação à rede elétrica e apontar as boas e más práticas de operação.",
                "Apresentar uma pesquisa com os significados e as funções e/ou aplicações na informática dos seguintes verbetes e siglas: RAM, ROM, HD, CPU, IDE, SATA, Widescreen, Flat, PS2, USB, RJ45, Serial, FireWire, MB , GB, TB, PB, KBPS, GBPS, MHZ, GHZ, VGA, HDMI, BIOS, Wireless, Modem, HUB, Switch, Bluetooth e outros que o examinador solicitar.",
                "Digitalizar uma ou mais imagens, de 1 (um) livro ou revista, aplicá-las em 1 (um) dos seguintes documentos (1) jornal da seção ou matilha/patrulha ou (2) circular sobre uma atividade externa, com croqui de acesso ao local ou (3) cartaz de divulgação do Escotismo ou evento escoteiro ou (4) relatório de atividade.",
                "Apresentar uma pesquisa sobre Software Livre e Inclusão Digital e quais são os seus benefícios para a sociedade.",
                "Citar 10 (dez) profissões onde o computador seja a ferramenta de trabalho principal ou 10 (dez) aplicações da informática no mercado de trabalho.",
                "Apresentar os tipos de ameaças virtuais, quais são os seus perigos, quais são as formas mais comuns de contaminação, como combatê-los e as melhores práticas para evitar o contágio.",
                "Citar pelo menos 3 (três) diferentes sistemas operacionais, demonstrando o uso de pelo menos 1 (um) através das seguintes tarefas: (1) criar, renomear e excluir pastas, (2) gravar qualquer tipo de arquivo num CD ou DVD ou outro tipo de mídia externa, (3) configurar o desktop alterando sua aparência e (4) instalar e configuração pelo menos 2 (dois) aplicativos.",
                "Citar o nome de 3 (três) diferentes programas de computador demonstrando conhecer o uso deles.",
                "Definir o que é uma rede de computadores e citar quais as possíveis formas de conexão entre computadores.",
                "Montar uma rede que interligue até 3 (três) computadores mostrando o seu funcionamento através da transferência de arquivos entre eles.",
                "Mostrar conhecimento prático de uma linguagem de programação, fazendo 1 (um) programa que sirva como ferramenta para a resolução de 1 (um) problema proposto pelo examinador, discutindo com ele seus resultados."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesInformatica, "Informática");


        // Especialidade invenção
        String atividadesInvencao[] = {
                "Apresentar 1 (um) relatório sobre sua invenção descrevendo todo o processo de criação, da idealização à construção do protótipo.",
                "Apresentar o projeto da invenção, descriminando todos os componentes, os equipamentos e o investimento utilizados para sua construção ou para o processo de sua execução/produção.",
                "Demonstrar o funcionamento e aplicação de sua invenção.",
                "Diferenciar invenção de inovação, exemplificando os 2 (dois) conceitos.",
                "Demonstrar conhecimento sobre a legislação e o processo de registro de patentes de invenção no Brasil.",
                "Apresentar uma pesquisa histórica sobre, pelo menos, 5 (cinco) grandes invenções que revolucionaram a humanidade, contendo informações sobre a invenção e seu inventor.",
                "Apresentar uma pesquisa histórica sobre 3 (três) invenções de brasileiros, contendo informações sobre a invenção, seu inventor e seu processo de desenvolvimento.",
                "Visitar uma instituição/empresa atuante na área científica relacionada com a invenção e apresentar 1 (um) relatório sobre o processo de produção de pelo menos 1 (um) de seus produtos.",
                "Entrevistar 1 (um) inventor que tenha transformado sua invenção em algum produto comercial, abordando sobre a história de sua invenção e o efeito dela nas tarefas dos consumidores de seu produto."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesInvencao, "Invenção");


        // Especialidade programação
        String atividadesProgramacao[] = {
                "Explicar como programas de computador e aplicativos podem facilitar tarefas do dia a dia.",
                "Mostrar conhecimento sobre os fundamentos básicos da programação e o uso das cláusulas IF (se) e WHILE (enquanto), através de 1 (um) pequeno código funcional.",
                "Escolher uma linguagem de programação e identificar quais os recursos mínimos, de hardware e software, são necessários para colocar 1 (um) programa em funcionamento.",
                "Desenvolver 1 (um) programa que ao ser executado apresente na tela os dizeres 'Alô Mundo'.",
                "Realizar uma apresentação sobre o que é software livre, citando exemplos.",
                "Citar pelo menos 3 (três) tipos de licenciamento de programas e explicar como a pirataria pode ser prejudicial.",
                "Desenvolver 1 (um) jogo ou aplicativo em qualquer linguagem ou 1 (um) site que utilize programação JavaScript ou equivalente com uma função relacionada ao escotismo. Após, apresentá-lo para a sua seção.",
                "Explicar o uso de pelo menos 5 (cinco) funções em uma linguagem de programação bem como em que local pode-se buscar referências.",
                "Citar 3 (três) repositórios de código e mostrar como podem agilizar a programação de software.",
                "Demonstrar conhecimentos básicos sobre pelo menos 1 (um) ambiente de desenvolvimento integrado mostrando conhecimento quanto a sua utilização.",
                "Pesquisar como funciona uma empresa de jogos digitais e relatar o seu funcionamento ao examinador.",
                "Apresentar uma pesquisa sobre o que são emuladores."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesProgramacao, "Programação");


        // Especialidade robótica
        String atividadesRobotica[] = {
                "Saber distinguir o que pode ou não ser considerado 1 (um) robô.",
                "Conhecer os principais tipos de robô, suas características, propriedades e principais diferenças.",
                "Apresentar 10 (dez) robôs utilizados na atualidade.",
                "Montar e programar 1 (um) modelo com peças móveis e que tenha pelo menos 1 (um) componente eletroeletrônico para controlar os movimentos dos componentes móveis.",
                "Montar 1 (um) modelo que tenha ao menos 3 (três) componentes móveis acionados por engrenagens, e/ou polias, e/ou correntes e seja rádio controlado ou controlado por 1 (um) dispositivo sem fio.",
                "Montar e programar 1 (um) modelo que sirva como protótipo para a resolução por meio da robótica de algum problema mundial na atualidade.",
                "Compreender e saber transmitir o conhecimento de qualquer robô construído, e a utilização do comando sem fio ou radio-controle ou a programação feita.",
                "Montar e programar 1 (um) robô que possua pelo menos 2 (dois) sensores e utilize 1 (um) condicional e 1 (um) looping.",
                "Montar e programar 1 (um) robô que possua pelo menos 4 (quatro) variáveis.",
                "Montar e programar 1 (um) robô que possua duas variáveis e se comunique por WIFI ou bluetooth com outro robô do mesmo tipo.",
                "Saber explicar duas funções já existentes no programa para Arduíno, ou similar, em linguagem de programação (C++, Javascript, etc.).",
                "Saber acender 1 (um) LED utilizando uma linguagem de programação (C++, Javascript, etc.)."
        };

        this.adicionarAtividadesDeEspecilidades(atividadesRobotica, "Robótica");


        // Adicionando atividades de insígnias
        // Atividades da insígnia do aprender
        String atividadesInsigniaDoAprender[] = {
                "Organizar o espaço de estudo adequadamente, observando a sua iluminação, local para acondicionamento dos materiais e ambiente.",
                "Ter o seu material escolar devidamente organizado, demonstrado cuidados com os livros, cadernos e demais materiais.",
                "Destinar o tempo adequado para seu estudo e tarefas de casa, relatando aos pais, a Akela ou outro Velho Lobo quanto tempo utiliza para essas atividades.",
                "Participar, como Lobinho, de pelo menos uma edição do Projeto Educação Escoteira com sua Alcateia, ou de outra atividade em conjunto com escolas realizada pela sua Alcateia ou pelo seu Grupo Escoteiro/Seção Autônoma.",
                "Participar ativamente de pelo menos duas atividades especiais em sua escola (Ex.: Festa Junina, Feira de Ciências, Excursão, etc.) e mostrar fotos ou relatório para a Alcateia.",
                "Apoiar um colega de classe em alguma tarefa ou ajudá-lo a aprender algum conteúdo que tenha dificuldade.",
                "Conversar com seus pais , Akela ou outro Velho Lobo sobre sua participação na escola, seu interesse pelos estudos e sobre os pontos que podem ser melhorados para ser um melhor aluno."
        };

        this.adicionarAtividadesDeInsignias(atividadesInsigniaDoAprender, "Insígnia do Aprender");


         // Atividades da insígnia do cone sul
        String atividadesInsigniaConeSul[] = {
                "Indicar, no mapa mundi, onde estão localizados os demais países do Cone Sul, sabendo reconhecer suas bandeiras e explicar o significado das cores de cada uma delas.",
                "Pesquisar a história de algo importante por sua utilidade que tenha sido inventado em um dos países do Cone Sul.",
                "Degustar pelo menos um prato típico de outro país do Cone Sul, conhecendo sua história e origem.",
                "Visitar exposições ou feiras culturais referentes a outros países do Cone Sul.",
                "Conhecer uma lenda ou conto de outro país do Cone Sul e contá-la para Alcateia.",
                "Conhecer a principal dança típica de pelo menos dois países do Cone Sul.",
                "Ir a uma peça de teatro cujo roteiro seja de outro país do Cone Sul e não esteja adaptado.",
                "Assistir uma animação ou filme nacional de outro país do Cone Sul.",
                "Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país do Cone Sul.",
                "Entrevistar alguém que esteja morando, ou tenha morado em algum país do Cone Sul.",
                "Descobrir quais distintivos poderia conquistar se fosse de outro país do Cone Sul.",
                "Ensinar a Alcateia a cantar uma canção escoteira de outro país do Cone Sul.",
                "Conhecer as principais terminologias do Ramo Lobinho (Alcateia, Matilha, acampamento etc) em castelhano ou em outro idioma falado em países do Cone Sul, como o guarani.",
                "Conhecer os nomes e os símbolos das Associações Escoteiras dos países que integram o Cone Sul."
        };

        this.adicionarAtividadesDeInsignias(atividadesInsigniaConeSul, "Insígnia do Cone Sul");


        // Atividades da insígnia da boa ação
        String atividadesInsigniaDaBoaAcao[] = {
                "Conhecer os principais problemas sociais de sua rua ou bairro e conversar com seus pais ou velhos lobos sobre como você poderia contribuir para resolvê-los.",
                "Conhecer instituições de sua comunidade que realizam ações assistenciais a pessoas necessitadas ou orientação para a melhoria da vida das pessoas, procurando saber de que forma sua Alcateia poderia ajudá-las.",
                "Participar de pelo menos uma edição do Mutirão Nacional Escoteiro de Ação Comunitária com sua Alcateia ou de outra atividade de ação comunitária realizada pela sua Alcateia ou por seu Grupo Escoteiro.",
                "Perceber os eventuais perigos a que estão expostos os lobinhos em uma excursão ou acampamento/acantonamento e ajudar a aplicar as regras de segurança para evitá-los.",
                "Participar de pelo menos três boas ações coletivas com sua Alcateia, contribuindo com ideias e ações para o planejamento e execução das atividades.",
                "Participar de uma ação comunitária promovida por alguma instituição de sua comunidade: igreja, clube, escola, posto de saúde, polícia, bombeiros, casa comercial, etc. e fazer um relatório sobre essa participação.",
                "Planejar e executar uma boa ação, diferente das realizadas anteriormente, que seja útil em sua Alcateia, casa, escola ou comunidade, com duração mínima de um mês, apresentando posteriormente os resultados para sua Alcateia."
        };

        this.adicionarAtividadesDeInsignias(atividadesInsigniaDaBoaAcao, "Insígnia da Boa Ação");


        // Atividades da insígnia da lusofonia
        String atividadesInsigniaDaLusofonia[] = {
                "Pesquisar os temperos e especiarias típicos dos países lusófonos, também presentes no Brasil.",
                "Pesquisar a fauna e flora típicos dos países lusófonos, também presentes no Brasil.",
                "Pesquisar utensílios e invenções utilizadas no Brasil, criados em algum país lusófono.",
                "Indicar, no mapa mundi, onde estão localizados os países lusófonos e reconhecer suas respectivas bandeiras.",
                "Visitar exposições ou feiras culturais referentes a outros países lusófonos.",
                "Degustar pelo menos uma refeição típica de outro país lusófono, conhecendo sua história e origem.",
                "Ir a uma peça de teatro cujo roteiro seja de outro país lusófono e não esteja adaptado.",
                "Assistir um espetáculo (circo, show musical etc) que seja originário de outro país lusófono.",
                "Conhecer uma lenda ou conto de outro país lusófono, e contá-la para sua Alcateia.",
                "Entrevistar alguém que tenha morado, ou esteja morando, em um país lusófono.",
                "Ver um filme nacional ou animação de outro país Lusófono.",
                "Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país Lusófono.",
                "Descobrir quais distintivos o Lobinho poderia conquistar se fosse de outro país lusófono.",
                "Fazer uma lista de termos escoteiros utilizados em outro país lusófono.",
                "Conhecer o símbolo das Associações Escoteiras dos países lusófonos."
        };

        this.adicionarAtividadesDeInsignias(atividadesInsigniaDaLusofonia, "Insígnia da Lusofonia");


        // Adicionando atividades de distintivos
        // Distintivo Lobo Pata Tenra
        String atividadesLoboPataTenra[] = {
                "Garantir uma boa escovação bucal.",
                "Arrumar a cama ao acordar.",
                "Organizar os materiais de uso diário."
        };

        this.adicionarAtividadesDeDistintivos(atividadesLoboPataTenra, "Lobo Pata Tenra");


        // Distintivo Lobo Saltador
        String atividadesLoboSaltador[] = {
                "Auxiliar nas tarefas domésticas.",
                "Levantar pontos sobre sua organização que possam ser melhorados.",
                "Avaliar se está realizando práticas que auxiliem na preservação do meio ambiente.",
        };

        this.adicionarAtividadesDeDistintivos(atividadesLoboSaltador, "Lobo Saltador");


        // Distintivo Lobo Rastreador
        String atividadesLoboRastreador[] = {
                "Auxiliar sua matilha com possíveis dificuldades em alguma tarefa.",
                "Quando acampar, observar e avaliar as frutas que melhor possam saciar.",
                "Apresentar duas práticas de organização para acampamentos."
        };

        this.adicionarAtividadesDeDistintivos(atividadesLoboRastreador, "Lobo Rastreador");


        // Lobo Caçador
        String atividadesLoboCacador[] = {
                "Promover com seu chefe escoteiro uma atividade ao ar livre que estimule a reflexão sobre a fauna.",
                "Auxiliar nas tarefas ao ar livre junto com sua matilha.",
                "Fazer um diário de suas atividades."
        };

        this.adicionarAtividadesDeDistintivos(atividadesLoboCacador, "Lobo Caçador");


        // Cruzeiro do Sul

        // Adicionar problemas de saúde
        this.adicionarProblemaDeSaude("Alergia", "Frutos do mar.");
        this.adicionarProblemaDeSaude("Alergia", "Bijuteria.");
        this.adicionarProblemaDeSaude("Alergia", "Suor.");
        this.adicionarProblemaDeSaude("Alergia", "Lactose.");
        this.adicionarProblemaDeSaude("Alergia", "Medicamentos.");


        // Adicionando acampamentos
        this.adicionarAcampamento("Campo da coragem", 10, 5, 2023);
        this.adicionarAcampamento("Noite do descobrimento", 10, 6, 2023);
        this.adicionarAcampamento("Terra viva", 10, 7, 2023);
        this.adicionarAcampamento("Natureza acolhedora", 10, 8, 2023);
        this.adicionarAcampamento("Mãe Natureza", 10, 9, 2023);


        // Adicionando pessoas
        this.adicionarPessoa("André Coelho Matos", 14, 9, 2016, "O-");
        this.adicionarPessoa("Suzanne Nadine Vega", 8, 4, 2014, "A+");
        this.adicionarPessoa("Eithne Pádraigín Ní Bhraonáin", 12, 8, 2014, "B+");
        this.adicionarPessoa("James Roy Horner", 1, 2, 2017, "AB-");
        this.adicionarPessoa("Linus Benedict Torvalds", 1, 1, 2016, "O+");
        this.adicionarPessoa("Steven Paul Jobs", 31, 12, 2013, "AB+");
        this.adicionarPessoa("William Henry Gates III", 1, 1, 2014, "O-");
        this.adicionarPessoa("Richard Matthew Stallman", 7, 12, 2015, "A+");
        this.adicionarPessoa("Philo Taylor Farnsworth", 9, 11, 2014, "B+");
        this.adicionarPessoa("Isadore Friz Freleng", 10, 10, 2016, "O-");
        this.adicionarPessoa("Hans Florian Zimmer", 17, 1, 2017, "AB-");


        // Adicionando responsáveis
        this.adicionarResponsavel("Carl Edward Sagan", "12345678910", "carl@sagan.com");
        this.adicionarResponsavel("Evángelos Odysséas Papathanassíu", "0987654321", "vangelis@gmail.com");
        this.adicionarResponsavel("Albert Einstein", "12345678910", "albert@einstein.com");
        this.adicionarResponsavel("Joaquim Maria Machado de Assis", "1029384756", "machado@assis.com");
        this.adicionarResponsavel("Maria José Dupré", "6758493021", "maria@dupre.com");
        this.adicionarResponsavel("Orlando Drummond Cardoso", "7182934682", "orlando@drummond.com");
        this.adicionarResponsavel("Jonas Rodrigues de Mello", "917382465", "jonas@mello.com");
        this.adicionarResponsavel("Jorgeh José Ramos", "789654123", "jorgeh@ramos.com");
        this.adicionarResponsavel("Gérson Ribeiro de Abreu Júnior", "321456987", "gerson@abreu.com");


        // Adicionando vínculos
        this.adicionarVinculo(1,1);
        this.adicionarVinculo(1,2);
        this.adicionarVinculo(2,3);
        this.adicionarVinculo(3,4);
        this.adicionarVinculo(4,5);
        this.adicionarVinculo(5,6);
        this.adicionarVinculo(6,7);
        this.adicionarVinculo(7,8);
        this.adicionarVinculo(8,9);
        this.adicionarVinculo(9,10);
        this.adicionarVinculo(9,11);

        // Adicionando Informações de saúde na pessoa
        this.adicionarDadosDeSaude(1, 1);
        this.adicionarDadosDeSaude(1, 2);

        this.adicionarDadosDeSaude(2, 1);

        this.adicionarDadosDeSaude(3, 3);


        // Adicionando acampamentos em pessoa
        // Pessoa 1 possui 3 acampamentos participados
        this.adicionarNoitesAcampadas(1, 1);
        this.adicionarNoitesAcampadas(2, 1);
        this.adicionarNoitesAcampadas(3, 1);
        this.adicionarNoitesAcampadas(4, 1);
        this.adicionarNoitesAcampadas(5, 1);
        this.adicionarNoitesAcampadas(6, 1);
        this.adicionarNoitesAcampadas(7, 1);
        this.adicionarNoitesAcampadas(8, 1);

        this.adicionarNoitesAcampadas(1, 2);
        this.adicionarNoitesAcampadas(2, 2);
        this.adicionarNoitesAcampadas(3, 2);
        this.adicionarNoitesAcampadas(4, 2);
        this.adicionarNoitesAcampadas(5, 2);
        this.adicionarNoitesAcampadas(6, 2);
        this.adicionarNoitesAcampadas(7, 2);
        this.adicionarNoitesAcampadas(8, 2);

        this.adicionarNoitesAcampadas(1, 3);


        // Adicionando Atividiades de distintivos em pessoa
        // Pessoa 1
        // Distintivo lobo pata tenra
        this.adicionarAtividadesDeDistintivosFeitas(1,1, 1,1,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,2, 1,2,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,3, 1,3,2023);

        // Distintivo lobo saltador
        this.adicionarAtividadesDeDistintivosFeitas(1,4, 3,4,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,5, 6,4,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,6, 9,4,2023);

        // Distintivo lobo rastreador
        this.adicionarAtividadesDeDistintivosFeitas(1,7, 3,5,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,8, 6,5,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,9, 9,5,2023);

        // Distintivo lobo caçador
        this.adicionarAtividadesDeDistintivosFeitas(1,10, 3,6,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,11, 6,6,2023);
        this.adicionarAtividadesDeDistintivosFeitas(1,12, 9,6,2023);


        // Pessoa 2
        // Distintivo lobo pata tenra
        this.adicionarAtividadesDeDistintivosFeitas(2,1, 1,1,2023);
        this.adicionarAtividadesDeDistintivosFeitas(2,2, 1,2,2023);
        this.adicionarAtividadesDeDistintivosFeitas(2,3, 1,3,2023);

        // Distintivo lobo saltador
        this.adicionarAtividadesDeDistintivosFeitas(2,4, 3,4,2023);
        this.adicionarAtividadesDeDistintivosFeitas(2,5, 6,4,2023);
        this.adicionarAtividadesDeDistintivosFeitas(2,6, 9,4,2023);

        // Distintivo lobo rastreador (Falta uma atividade para completar)
        this.adicionarAtividadesDeDistintivosFeitas(2,7, 3,5,2023);
        this.adicionarAtividadesDeDistintivosFeitas(2,8, 6,5,2023);

        // Distintivo lobo caçador (Falta uma atividade para completar)
        this.adicionarAtividadesDeDistintivosFeitas(2,10, 3,6,2023);
        this.adicionarAtividadesDeDistintivosFeitas(2,11, 6,6,2023);


        // Adicionando atividades de especialidade em pessoa
        // Pessoa 1
        // Especialidade radioescuta (Serviços)
        this.adicionarAtividadesDeEspecialidadesFeitas(1,48, 2,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,47, 3,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,46, 4,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,45, 5,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,44, 6,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,43, 7,6,2023);

        // Especialidade Echolink (Ciência e tecnologia)
        this.adicionarAtividadesDeEspecialidadesFeitas(1,94, 2,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,95, 3,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,96, 4,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,97, 5,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,98, 6,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,99, 7,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,100, 8,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,101, 9,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,102, 10,7,2023);

        // Especialidade programação (Ciência e tecnologia)
        this.adicionarAtividadesDeEspecialidadesFeitas(1,163, 2,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,164, 3,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,165, 4,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,166, 5,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,167, 6,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,168, 7,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,169, 8,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,170, 9,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,171, 10,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,172, 11,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,173, 12,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,174, 13,8,2023);

        // Especialidade eletrônica (Ciência e tecnologia)
        this.adicionarAtividadesDeEspecialidadesFeitas(1,103, 2,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,104, 3,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,105, 4,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,106, 5,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,107, 6,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,108, 7,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,109, 8,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,110, 9,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,111, 10,9,2023);

        // Especialidade culinária (Habilidades escoteiras)
        this.adicionarAtividadesDeEspecialidadesFeitas(1,19, 2,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,20, 3,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,21, 4,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,22, 5,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,23, 6,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,24, 7,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,25, 8,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,26, 9,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,27, 10,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,28, 11,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,29, 12,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(1,30, 13,10,2023);

        // Pessoa 2 (Faltam completar atividades de duas especialidades para o Cruzeiro do Sul)
        // Especialidade radioescuta (Serviços)
        this.adicionarAtividadesDeEspecialidadesFeitas(2,43, 2,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,44, 3,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,45, 4,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,46, 5,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,47, 6,6,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,48, 7,6,2023);

        // Especialidade Echolink (Ciência e tecnologia)
        this.adicionarAtividadesDeEspecialidadesFeitas(2,94, 2,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,95, 3,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,96, 4,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,97, 5,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,98, 6,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,99, 7,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,100, 8,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,101, 9,7,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,102, 10,7,2023);

        // Especialidade programação (Ciência e tecnologia)
        this.adicionarAtividadesDeEspecialidadesFeitas(2,163, 2,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,164, 3,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,165, 4,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,166, 5,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,167, 6,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,168, 7,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,169, 8,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,170, 9,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,171, 10,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,172, 11,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,173, 12,8,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,174, 13,8,2023);

        // Especialidade eletrônica (Ciência e tecnologia) (Possui até o nível 1)
        this.adicionarAtividadesDeEspecialidadesFeitas(2,103, 2,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,104, 3,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,105, 4,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,106, 5,9,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,107, 6,9,2023);


        // Especialidade culinária (Habilidades escoteiras) (Falta uma para completar o nível 3)
        this.adicionarAtividadesDeEspecialidadesFeitas(2,19, 2,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,20, 3,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,21, 4,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,22, 5,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,23, 6,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,24, 7,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,25, 8,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,26, 9,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,27, 10,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,28, 11,10,2023);
        this.adicionarAtividadesDeEspecialidadesFeitas(2,29, 12,10,2023);


        // adicionando atividades de insígnia em pessoa
        // Pessoa 1
        // Insígnia do aprender
        this.adicionarAtividadesDeInsigniasFeitas(1, 1, 1, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 2, 2, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 3, 3, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 4, 4, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 4, 4, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 5, 5, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 6, 6, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(1, 7, 7, 7, 2023);

        // Pessoa 2 (Falta uma atividade para ganhar a insígnia)
        // Insígnia do aprender
        this.adicionarAtividadesDeInsigniasFeitas(2, 1, 1, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(2, 2, 2, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(2, 3, 3, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(2, 4, 4, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(2, 4, 4, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(2, 5, 5, 7, 2023);
        this.adicionarAtividadesDeInsigniasFeitas(2, 6, 6, 7, 2023);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Povoando o banco de dados...");
        this.povoandoBanco();
    }
}