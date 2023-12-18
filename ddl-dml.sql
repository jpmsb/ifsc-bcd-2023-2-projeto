-- MariaDB dump 10.19-11.2.2-MariaDB, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: pp1joao
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acampamentos`
--

DROP TABLE IF EXISTS `acampamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acampamentos` (
  `data` date NOT NULL,
  `id_acampamento` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_acampamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acampamentos`
--

LOCK TABLES `acampamentos` WRITE;
/*!40000 ALTER TABLE `acampamentos` DISABLE KEYS */;
INSERT INTO `acampamentos` VALUES
('2023-05-10',1,'Campo da coragem'),
('2023-06-10',2,'Noite do descobrimento'),
('2023-07-10',3,'Terra viva'),
('2023-08-10',4,'Natureza acolhedora'),
('2023-09-10',5,'Mãe Natureza');
/*!40000 ALTER TABLE `acampamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas_de_conhecimento`
--

DROP TABLE IF EXISTS `areas_de_conhecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas_de_conhecimento` (
  `id_area_de_conhecimento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_area_de_conhecimento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas_de_conhecimento`
--

LOCK TABLES `areas_de_conhecimento` WRITE;
/*!40000 ALTER TABLE `areas_de_conhecimento` DISABLE KEYS */;
INSERT INTO `areas_de_conhecimento` VALUES
(1,'Ciência e Tecnologia'),
(2,'Cultura'),
(3,'Desportos'),
(4,'Habilidades Escoteiras'),
(5,'Serviços');
/*!40000 ALTER TABLE `areas_de_conhecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades_de_distintivos`
--

DROP TABLE IF EXISTS `atividades_de_distintivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividades_de_distintivos` (
  `id_atividade` int NOT NULL AUTO_INCREMENT,
  `id_distintivo` int NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FK7c5pgot8e51lkjjaaiidv25ct` (`id_distintivo`),
  CONSTRAINT `FK7c5pgot8e51lkjjaaiidv25ct` FOREIGN KEY (`id_distintivo`) REFERENCES `distintivos` (`id_distintivo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades_de_distintivos`
--

LOCK TABLES `atividades_de_distintivos` WRITE;
/*!40000 ALTER TABLE `atividades_de_distintivos` DISABLE KEYS */;
INSERT INTO `atividades_de_distintivos` VALUES
(1,1,'Garantir uma boa escovação bucal.'),
(2,1,'Arrumar a cama ao acordar.'),
(3,1,'Organizar os materiais de uso diário.'),
(4,2,'Auxiliar nas tarefas domésticas.'),
(5,2,'Levantar pontos sobre sua organização que possam ser melhorados.'),
(6,2,'Avaliar se está realizando práticas que auxiliem na preservação do meio ambiente.'),
(7,3,'Auxiliar sua matilha com possíveis dificuldades em alguma tarefa.'),
(8,3,'Quando acampar, observar e avaliar as frutas que melhor possam saciar.'),
(9,3,'Apresentar duas práticas de organização para acampamentos.'),
(10,4,'Promover com seu chefe escoteiro uma atividade ao ar livre que estimule a reflexão sobre a fauna.'),
(11,4,'Auxiliar nas tarefas ao ar livre junto com sua matilha.'),
(12,4,'Fazer um diário de suas atividades.');
/*!40000 ALTER TABLE `atividades_de_distintivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades_de_distintivos_feitas`
--

DROP TABLE IF EXISTS `atividades_de_distintivos_feitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividades_de_distintivos_feitas` (
  `atividade_de_distintivo_id_atividade` int NOT NULL,
  `data` date NOT NULL,
  `pessoa_id_pessoa` int NOT NULL,
  PRIMARY KEY (`atividade_de_distintivo_id_atividade`,`pessoa_id_pessoa`),
  KEY `FKkkwuipq3ooov1slkv20ywl71s` (`pessoa_id_pessoa`),
  CONSTRAINT `FKenfw6x6nyj3upsobwj77edkka` FOREIGN KEY (`atividade_de_distintivo_id_atividade`) REFERENCES `atividades_de_distintivos` (`id_atividade`),
  CONSTRAINT `FKkkwuipq3ooov1slkv20ywl71s` FOREIGN KEY (`pessoa_id_pessoa`) REFERENCES `pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades_de_distintivos_feitas`
--

LOCK TABLES `atividades_de_distintivos_feitas` WRITE;
/*!40000 ALTER TABLE `atividades_de_distintivos_feitas` DISABLE KEYS */;
INSERT INTO `atividades_de_distintivos_feitas` VALUES
(1,'2023-01-01',1),
(1,'2023-01-01',2),
(2,'2023-02-01',1),
(2,'2023-02-01',2),
(3,'2023-03-01',1),
(3,'2023-03-01',2),
(4,'2023-04-03',1),
(4,'2023-04-03',2),
(5,'2023-04-06',1),
(5,'2023-04-06',2),
(6,'2023-04-09',1),
(6,'2023-04-09',2),
(7,'2023-05-03',1),
(7,'2023-05-03',2),
(8,'2023-05-06',1),
(8,'2023-05-06',2),
(9,'2023-05-09',1),
(10,'2023-06-03',1),
(10,'2023-06-03',2),
(11,'2023-06-06',1),
(11,'2023-06-06',2),
(12,'2023-06-09',1);
/*!40000 ALTER TABLE `atividades_de_distintivos_feitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades_de_especialidades`
--

DROP TABLE IF EXISTS `atividades_de_especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividades_de_especialidades` (
  `id_atividade` int NOT NULL AUTO_INCREMENT,
  `id_especialidade` int NOT NULL,
  `descricao` longtext NOT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FK8nxo2wm3ab0k2snrmg3vug8kf` (`id_especialidade`),
  CONSTRAINT `FK8nxo2wm3ab0k2snrmg3vug8kf` FOREIGN KEY (`id_especialidade`) REFERENCES `especialidades` (`id_especialidade`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades_de_especialidades`
--

LOCK TABLES `atividades_de_especialidades` WRITE;
/*!40000 ALTER TABLE `atividades_de_especialidades` DISABLE KEYS */;
INSERT INTO `atividades_de_especialidades` VALUES
(1,13,'Montar, desmontar, dobrar e acondicionar uma barraca.'),
(2,13,'Escolher as técnicas de conservação de uma barraca, executando pequenos reparos na lona, quarto e varetas.'),
(3,13,'Escolher locais seguros para montar uma barraca.'),
(4,13,'Explicar os cuidados a adotar em casos de temporais e alagamentos.'),
(5,13,'Cuidar e tratar do lixo quando em acampamento.'),
(6,13,'Montar 1 (um) canto de matilha/patrulha, considerando os padrões de acampamento e com auxílio da matilha/patrulha.'),
(7,13,'Cozinhar uma refeição simples individual em fogo de lenha, sem utilizar utensílios de cozinha.'),
(8,13,'Fazer pelo menos 5 (cinco) pioneirias diferentes e úteis em acampamentos, utilizando amarras.'),
(9,13,'Acampar por 3 (três) noites sem utilizar barraca, dormindo em abrigo natural ou em saco de dormir especial para o relento.'),
(10,13,'Orientar-se por meio de cartas topográficas, com e sem emprego de bússola.'),
(11,13,'Improvisar barraca, mochila, espeques, esteios e artigos semelhantes, utilizando-os durante 1 (um) acampamento ou jornada.'),
(12,13,'Demonstrar uso dos seguintes nós e voltas: de correr, escota duplo, em oito, balso pelo seio, arnês, fiel, ribeira, redonda com cotes e do salteador.'),
(13,13,'Demonstrar os cuidados para com o material necessário para 1 (um) acampamento.'),
(14,13,'Elaborar 1 (um) cardápio e lista de gêneros para as refeições da seção durante 1 (um) acampamento e uma jornada, ambos com duração igual a 1 (um) fim de semana.'),
(15,13,'Acondicionar os gêneros alimentícios para 1 (um) acampamento e uma jornada.'),
(16,13,'Preparar o material individual para 1 (um) acampamento e para uma jornada, ambos com duração igual a 1 (um) fim de semana.'),
(17,13,'Fazer 1 (um) projeto de 1 (um) acampamento suspenso, listando o material necessário, custos e os aspectos de segurança, e executá-lo.'),
(18,13,'Elaborar e executar uma programação de 1 (um) acampamento da matilha/patrulha, com duração igual a 1 (um) fim de semana.'),
(19,14,'Abrir latas de conserva, cortar legumes e preparar uma bebida.'),
(20,14,'Identificar os utensílios necessários para a preparação de uma refeição definida pelo examinador.'),
(21,14,'Fritar ovos e preparar saladas, decorando os pratos, e preparar uma bebida quente.'),
(22,14,'Fazer uma lista dos mantimentos com quantidades necessárias para uma refeição festiva para a seção.'),
(23,14,'Explicar como conservar os alimentos conforme a temperatura ambiente.'),
(24,14,'Preparar 1 (um) cardápio equilibrado para 1 (um) acampamento de final de semana, calculando as quantidades dos gêneros para a matilha/patrulha.'),
(25,14,'Cozinhar para a matilha/patrulha durante 1 (um) acampamento de final de semana, a lenha e a gás, demonstrando cuidados com a segurança e a higiene.'),
(26,14,'Preparar alguma iguaria da cozinha mateira, como pão de caçador, ovo na laranja, ovo no espeto, carne moída no espeto, etc.'),
(27,14,'Projetar e participar da montagem da cozinha do canto da matilha/patrulha em 1 (um) acampamento, justificando os cuidados adotados para reduzir os riscos de incêndio.'),
(28,14,'Preparar, em 1 (um) acampamento, 3 (três) tipos de sobremesa.'),
(29,14,'Limpar e preparar uma peça de carne e 1 (um) peixe.'),
(30,14,'Construir uma intendência no canto de matilha/patrulha, durante 1 (um) acampamento.'),
(31,15,'Conhecer a regulamentação governamental relacionada com o radioamadorismo, no que se refere ao uso, prática e ética operacional.'),
(32,15,'Elaborar 1 (um) diagrama e explicar à seção os princípios elementares dos aparelhos transmissores e receptores de rádio.'),
(33,15,'Identificar, nos arredores de sua casa ou da sede, 3 (três) tipos ou modelos de antenas destinadas ao radioamadorismo, conhecendo suas principais características.'),
(34,15,'Explicar como aterrar e proteger dos raios uma estação de rádio.'),
(35,15,'Identificar pelo menos 2 (dois) modelos de transceptores, explicando à seção as características de cada um.'),
(36,15,'Elaborar e expor à seção 1 (um) trabalho sobre o uso de repetidoras.'),
(37,15,'Preparar e aplicar 1 (um) jogo diretamente ligado ao radioamadorismo.'),
(38,15,'Apresentar à seção 1 (um) trabalho que exponha os princípios básicos do uso do radioamadorismo em operações de emergência.'),
(39,15,'Elaborar 1 (um) cartão QSL pessoal contendo o símbolo do Radioescotismo.'),
(40,15,'Manter contato de forma ágil com outras 3 (três) estações, sendo pelo menos uma delas uma estação escoteira.'),
(41,15,'Instalar e pôr em funcionamento 1 (um) sistema de comunicação via rádio em uma atividade externa.'),
(42,15,'Apresentar a licença de sua estação de radioamador expedida pelo órgão oficial competente.'),
(43,16,'Promover, sozinho ou com sua estação ou matilha/patrulha e na presença de seu examinador, duas visitas a estações de radioamador e uma visita a uma estação comercial de rádio ou televisão, apresentando relatório à seção.'),
(44,16,'Relatar por escrito 1 (um) mínimo de 5 (cinco) estações de rádio que transmitam em ondas curtas programas em língua portuguesa e outras 5 (cinco) que transmitam em língua estrangeira, descrevendo horários, frequência e conteúdo da programação.'),
(45,16,'Identificar e demonstrar o uso e a utilidade dos comandos e controles de 1 (um) rádio receptor.'),
(46,16,'Fazer uma exposição de cartões QSL com pelo menos vinte exemplares, sendo três, no mínimo, pertencentes a estações escoteiras.'),
(47,16,'Interpretar pelo menos 5 (cinco) expressões do Código Q, 5 (cinco) letras do Código Fonético Internacional e 5 (cinco) letras do Código Morse, ouvidas em transmissões.'),
(48,16,'Reconhecer pelo menos 6 (seis) indicativos de chamada de países diferentes, ouvidos em transmissões.'),
(49,17,'Conhecer a técnica e a ética operacional quanto ao uso de radiotransmissores.'),
(50,17,'Apresentar 1 (um) relatório contendo 1 (um) mínimo de vinte contatos feitos por si próprio.'),
(51,17,'Realizar uma palestra sobre os serviços de faixa do cidadão.'),
(52,17,'Conhecer os principais canais de emergência e seu uso correto.'),
(53,17,'Elaborar 1 (um) cartaz contendo, pelo menos, quinze das principais gírias utilizadas na faixa do cidadão, exibindo-o no jornal mural da seção ou do Grupo Escoteiro.'),
(54,17,'Descrever 3 (três) tipos de antenas para uso nos rádios de faixa do cidadão.'),
(55,17,'Elaborar e aplicar 1 (um) jogo envolvendo rádios da faixa do cidadão.'),
(56,17,'Participar de uma atividade com a comunidade usando sua estação e apresentando 1 (um) relatório ao final.'),
(57,17,'Apresentar sua licença de faixa do cidadão emitida pelo órgão governamental competente.'),
(58,18,'Apresentar a história e a evolução da internet no Mundo e no Brasil para sua seção, através de palestras ou cartazes ou apresentação multimídia.'),
(59,18,'Configurar 1 (um) computador para acessar a internet através do tipo de conexão disponível no local de realização da especialidade, explicando as configurações mínimas necessárias e demonstrar o funcionamento dessa conexão acessando pelo menos 3 (três) sites escoteiros.'),
(60,18,'Apresentar 1 (um) trabalho com números estatísticos sobre a Internet identificando quais as faixas etárias, sexo e o tipo de informação procurada pelos internautas, bem como a origem destas informações.'),
(61,18,'Conhecer o significado, origem e utilização de pelo menos quinze termos comuns na Internet. Exemplos: WWW, WW2, FTP, HTTP, Telnet, Backbone, Browser, TCP/IP, Java, HTML, CGI, ASP, JavaScript, VBScript, Links Dedicados, CableModem, WAP, ADSL e outros que o examinador solicitar.'),
(62,18,'Utilizar 1 (um) site de pesquisa para encontrar pelo menos doze sites escoteiros na Internet, que deverão ser listados em 1 (um) cartaz e divulgado em sua seção, sendo: o site da Comunidade de Escotismo Lusófono, quatro sites de associações escoteiras de outros países, o site da UEB, quatro sites de grupos escoteiros brasileiros e quatro sites de regiões escoteiras do Brasil.'),
(63,18,'Listar e divulgar na sua seção pelo menos 4 (quatro) especialidades e os respectivos itens que podem ser conquistados através do conteúdo de páginas na Internet encontradas por você.'),
(64,18,'Apresentar o processo para o registro de 1 (um) novo domínio brasileiro, citando quais os possíveis tipos e quais os sufixos de domínios de pelo menos outros 10 (dez) países.'),
(65,18,'Realizar uma visita técnica a 1 (um) provedor ou empresa de fornecimento/distribuição de internet ou data center de uma instituição de ensino para conhecer os equipamentos e/ou aplicativos necessários para o seu funcionamento.'),
(66,18,'Enviar, por e-mail, 1 (um) relatório final da realização de sua especialidade, contando sua experiência e indicando a dificuldade dos itens realizados.'),
(67,18,'Fazer uma apresentação à seção sobre os perigos da internet, phishing scan, hoax, abuso sexual, entre outros.'),
(68,18,'Fazer uma apresentação à seção sobre as questões relacionadas aos direitos autorais e dos crimes que envolvem o download de programas, vídeos e músicas sem autorização dos seus autores ou sem o devido pagamento por eles.'),
(69,18,'Apresentar 1 (um) trabalho sobre redes sociais, apontando suas diferentes aplicações, listando e explicando o funcionamento de pelo menos 3 (três) grandes sites de redes sociais.'),
(70,1,'Explicar as diferenças entre 1 (um) modelo on-road e outro off-road.'),
(71,1,'Explicar a diferença de caster e cambagem num automodelo e para que servem.'),
(72,1,'Afinar (ajustar) 1 (um) motor a combustão e em caso de motor elétrico trocar 1 (um) par de escovas (carvão).'),
(73,1,'Montar apresentar 1 (um) modelo escolhido.'),
(74,1,'Explicar o funcionamento de 1 (um) diferencial e como montá-lo.'),
(75,1,'Descrever o processo de limpeza e manutenção de 1 (um) automodelo.'),
(76,1,'Trimar o rádio de 1 (um) automodelo a combustão e no caso de automodelo elétrico, e ajustar 1 (um) speed control.'),
(77,1,'Ligar, ajustar (se necessário) e fazer uma demonstração num percurso rabiscado no chão em forma de oito.'),
(78,1,'Explicar qual a composição do combustível (metanol) para auto modelos a combustão e em casos de elétricos descrever o processo de carga e descarga de uma bateria elétrica.'),
(79,1,'Explicar qual a diferença básica entre rádio “stick” e “wheel” (volante).'),
(80,1,'Pintar, recortar e instalar uma bolha (carroceria).'),
(81,1,'Ter participado de pelo menos 1 (um) torneio de automodelismo.'),
(82,3,'Entender o que é encriptação e decriptação e realizar uma apresentação sobre o assunto.'),
(83,3,'Saber o que é criptografia e explicar o seu significado e sua utilidade.'),
(84,3,'Conhecer e apresentar a história de Alan Turing e sua importância na história da criptografia.'),
(85,3,'Conhecer e explicar o que foi a Cifra de César e qual a importância dela na história da criptografia.'),
(86,3,'Conhecer a diferença entre Cifras e Códigos.'),
(87,3,'Conhecer e explicar a importância da frequência das letras em uma mensagem criptografada e qual sua vantagem para conseguir descriptografá-la.'),
(88,3,'Conhecer 3 tipos de cifras ou códigos incluindo a função totiente de Euler, quando foram criadas e para que são usadas.'),
(89,3,'Criar e apresentar sua própria cifra e código explicando-a.'),
(90,3,'Realizar 1 (um) texto com algum tipo de cifra e código falando sobre o escotismo com no mínimo quinze palavras.'),
(91,3,'Conhecer e explicar o sigilo perfeito exemplificando-o.'),
(92,3,'Conhecer e explicar o que é a configuração da chave e o que é o espaço da chave e o que é criptografia de chave pública.'),
(93,3,'Explique a importância da criptografia no armazenamento de dados e informações para a segurança pessoal.'),
(94,4,'Baixar o software e configurá-lo no modo simples.'),
(95,4,'Fazer contato com pelo menos 3 (três) usuários e 3 (três) conferências de fora da sua unidade federativa.'),
(96,4,'Gravar pelo menos 9 (nove) minutos de conversação.'),
(97,4,'Ser possuidor de licença de radioamador.'),
(98,4,'Adquirir a licença de uso do Echolink.'),
(99,4,'Conectar através de Proxy.'),
(100,4,'Configurar o programa em modo link.'),
(101,4,'Montar uma interface para funcionar em modo link.'),
(102,4,'Criar 1 (um) anúncio para sua estação.'),
(103,5,'Projetar 1 (um) diagrama esquemático simples de 1 (um) aparelho eletrônico, utilizando resistores, capacitores, transistores e circuitos integrados; utilizar a simbologia correta para representar cada 1 (um) deles.'),
(104,5,'Demonstrar a forma correta de soldar e dessoldar componentes eletrônicos, bem como os cuidados a serem tomados para evitar sua inutilização.'),
(105,5,'Pesquisar sobre o desenvolvimento da válvula incandescente, como se deu sua descoberta, que utilizações teve e que tipos de material foram utilizados por seu inventor.'),
(106,5,'Pesquisar sobre o que é 1 (um) elemento “N” e 1 (um) elemento “P”, de que materiais são elaborados e o que fazem estes elementos em dispositivos eletrônicos.'),
(107,5,'Conhecer os diodos e explicar como funcionam.'),
(108,5,'Projetar, desenhar, preparar e montar uma placa de circuito impresso.'),
(109,5,'Construir 1 (um) receptor simples de AM ou FM e entender seu funcionamento.'),
(110,5,'Demonstrar que conhece o uso correto de ferramentas e aparelhos de medição mais comuns em 1 (um) laboratório de eletrônica (osciloscópio, multímetro etc.).'),
(111,5,'Conhecer as principais áreas de aplicação da eletrônica, explicando uma delas.'),
(112,6,'Explicar quais são as diferenças entre usinas termoelétricas, nucleares, hidrelétricas (UHE E PCH), biomassa, eólica.'),
(113,6,'Apresentar 1 (um) trabalho sobre uma forma de energia, escolhendo entre a energia solar, a energia térmica a energia eólica, a energia hidráulica, a energia nuclear, energia provida de biomassa, energia maremotriz e energia geotérmica.'),
(114,6,'Apresentar o esquema de funcionamento de uma usina hidrelétrica (UHE e PCH).'),
(115,6,'Selecionar e analisar 2 (dois) artigos de jornal ou revista sobre 2 (dois) tipos diferentes de energia.'),
(116,6,'Apresentar 1 (um) estudo sobre as vantagens e desvantagens para o Brasil dos tipos de energia citados no item 2.'),
(117,6,'Formular e apresentar 1 (um) projeto para economizar energia em sua casa.'),
(118,6,'Entender e explicar as razões para a utilização do horário de verão.'),
(119,6,'Desenvolver 1 (um) projeto de captação e utilização de energia eólica, solar, hidráulica ou biomassa, construindo 1 (um) protótipo e explicando seu funcionamento.'),
(120,6,'Desenvolver 1 (um) trabalho de conscientização da comunidade (pode ser o próprio Grupo Escoteiro ou sua turma na escola) em relação à necessidade de economizar energia, aos impactos ambientais da utilização de diferentes formas de energia ou ao custo social da utilização da energia. Abordar também sobre: o significado e importância da MME, EPE, ANEEL, ONS, CCEE. Descrever como é formada a atual Matriz Energética Elétrica Mundial e Brasileira, mostrando as diferenças entre 1 (um) país a sua escolha e o Brasil. Explanar sobre os atuais grupos tarifários aplicados no Brasil conforme a resolução Aneel e as diferenças entre o consumidor residencial, comercial e industrial. Explicar sobre a composição do sistema elétrico em relação aos segmentos de geração, transmissão e distribuição (GTD).'),
(121,7,'Visitar 1 (um) canteiro de obras, discutindo com o engenheiro responsável o projeto, suas características e principais dados relativos à obra.'),
(122,7,'Visitar 1 (um) escritório de engenharia e relatar o dia-a-dia dos profissionais do ramo.'),
(123,7,'Apresentar 1 (um) trabalho sobre 4 (quatro) tipos de engenharia, escolhendo entre: civil, mecânica, química, eletrônica, de minas, de produção, elétrica, de alimentos, metalúrgica, agronômica, cartográfica, industrial, física, de computação e florestal ou outra à sua escolha. O trabalho apresentado pode ser em forma de vídeo, cartaz, apresentação de slides ou outro recurso midiático à sua escolha.'),
(124,7,'Apresentar duas reportagens sobre uma das engenharias selecionadas no item 3, sendo uma recente e outra antiga (de pelo menos 10 (dez) anos), destacando a evolução da engenharia nesse período.'),
(125,7,'Falar sobre a importância dos cálculos e medidas de precisão utilizadas na engenharia, apresentando 6 ((seis) casos onde são utilizadas, exemplificando cada um.'),
(126,7,'Apresentar 2 (dois) projetos referentes a pelo menos 1 (um) tipo de engenharia proposta no item 3, dando ênfase a sua necessidade.'),
(127,7,'Apresentar diferenças entre engenharia civil e arquitetura; diferenças entre a engenharia elétrica e eletrônica e diferenças entre a engenharia mecânica e mecatrônica.'),
(128,7,'Descrever o campo de trabalho de, pelo menos, 4 (quatro) tipos de engenharia, comentando sua importância social e para o desenvolvimento do país.'),
(129,7,'Apresentar pelo menos 4 (quatro) princípios de engenharia utilizados na Idade Média e no Renascimento e que são usados até hoje, destacando como eram utilizados naquela época e como são aplicados hoje em dia.'),
(130,8,'Possuir noções de coordenadas geográficas, coordenadas UTM, paralelos e meridianos.'),
(131,8,'Fazer 1 (um) breve relato sobre o sistema GPS e suas aplicações.'),
(132,8,'Explicar o que é o Datum no sistema GPS, e mostrar onde encontrar o Datum de 1 (um) mapa e como alterar o Datum do aparelho de GPS.'),
(133,8,'Saber os fatores que fazem com que o GPS não forneça sua localização.'),
(134,8,'Estar familiarizado com os termos habitualmente utilizados no Sistema de Posicionamento Global.'),
(135,8,'Conhecer o Sistema Glonass, Galileo e Compass.'),
(136,8,'Explicar o multicaminhamento e outros fatores que afetam a precisão do Sistema GPS.'),
(137,8,'Demonstrar como transferir pontos de 1 (um) mapa para a memória do GPS.'),
(138,8,'Demonstrar como marcar pontos.'),
(139,8,'Encontrar 1 (um) ponto de coordenadas solicitado pelo examinador.'),
(140,8,'Fazer uma jornada de 2 (dois) quilômetros marcando pontos de interesse do examinador.'),
(141,8,'Efetuar 1 (um) mapeamento de uma área de acampamento definido pelo examinador.'),
(142,9,'Apresentar a história dos computadores, desde os primeiros instrumentos, como o ábaco, até os equipamentos mais modernos, caracterizando as diferenças entre cada uma das gerações de computadores pessoais.'),
(143,9,'Listar as partes internas de 1 (um) microcomputador, os acessórios básicos para seu funcionamento, montá-lo e desmontá-lo corretamente demonstrando conhecer os cuidados necessários para sua ligação à rede elétrica e apontar as boas e más práticas de operação.'),
(144,9,'Apresentar uma pesquisa com os significados e as funções e/ou aplicações na informática dos seguintes verbetes e siglas: RAM, ROM, HD, CPU, IDE, SATA, Widescreen, Flat, PS2, USB, RJ45, Serial, FireWire, MB , GB, TB, PB, KBPS, GBPS, MHZ, GHZ, VGA, HDMI, BIOS, Wireless, Modem, HUB, Switch, Bluetooth e outros que o examinador solicitar.'),
(145,9,'Digitalizar uma ou mais imagens, de 1 (um) livro ou revista, aplicá-las em 1 (um) dos seguintes documentos (1) jornal da seção ou matilha/patrulha ou (2) circular sobre uma atividade externa, com croqui de acesso ao local ou (3) cartaz de divulgação do Escotismo ou evento escoteiro ou (4) relatório de atividade.'),
(146,9,'Apresentar uma pesquisa sobre Software Livre e Inclusão Digital e quais são os seus benefícios para a sociedade.'),
(147,9,'Citar 10 (dez) profissões onde o computador seja a ferramenta de trabalho principal ou 10 (dez) aplicações da informática no mercado de trabalho.'),
(148,9,'Apresentar os tipos de ameaças virtuais, quais são os seus perigos, quais são as formas mais comuns de contaminação, como combatê-los e as melhores práticas para evitar o contágio.'),
(149,9,'Citar pelo menos 3 (três) diferentes sistemas operacionais, demonstrando o uso de pelo menos 1 (um) através das seguintes tarefas: (1) criar, renomear e excluir pastas, (2) gravar qualquer tipo de arquivo num CD ou DVD ou outro tipo de mídia externa, (3) configurar o desktop alterando sua aparência e (4) instalar e configuração pelo menos 2 (dois) aplicativos.'),
(150,9,'Citar o nome de 3 (três) diferentes programas de computador demonstrando conhecer o uso deles.'),
(151,9,'Definir o que é uma rede de computadores e citar quais as possíveis formas de conexão entre computadores.'),
(152,9,'Montar uma rede que interligue até 3 (três) computadores mostrando o seu funcionamento através da transferência de arquivos entre eles.'),
(153,9,'Mostrar conhecimento prático de uma linguagem de programação, fazendo 1 (um) programa que sirva como ferramenta para a resolução de 1 (um) problema proposto pelo examinador, discutindo com ele seus resultados.'),
(154,10,'Apresentar 1 (um) relatório sobre sua invenção descrevendo todo o processo de criação, da idealização à construção do protótipo.'),
(155,10,'Apresentar o projeto da invenção, descriminando todos os componentes, os equipamentos e o investimento utilizados para sua construção ou para o processo de sua execução/produção.'),
(156,10,'Demonstrar o funcionamento e aplicação de sua invenção.'),
(157,10,'Diferenciar invenção de inovação, exemplificando os 2 (dois) conceitos.'),
(158,10,'Demonstrar conhecimento sobre a legislação e o processo de registro de patentes de invenção no Brasil.'),
(159,10,'Apresentar uma pesquisa histórica sobre, pelo menos, 5 (cinco) grandes invenções que revolucionaram a humanidade, contendo informações sobre a invenção e seu inventor.'),
(160,10,'Apresentar uma pesquisa histórica sobre 3 (três) invenções de brasileiros, contendo informações sobre a invenção, seu inventor e seu processo de desenvolvimento.'),
(161,10,'Visitar uma instituição/empresa atuante na área científica relacionada com a invenção e apresentar 1 (um) relatório sobre o processo de produção de pelo menos 1 (um) de seus produtos.'),
(162,10,'Entrevistar 1 (um) inventor que tenha transformado sua invenção em algum produto comercial, abordando sobre a história de sua invenção e o efeito dela nas tarefas dos consumidores de seu produto.'),
(163,11,'Explicar como programas de computador e aplicativos podem facilitar tarefas do dia a dia.'),
(164,11,'Mostrar conhecimento sobre os fundamentos básicos da programação e o uso das cláusulas IF (se) e WHILE (enquanto), através de 1 (um) pequeno código funcional.'),
(165,11,'Escolher uma linguagem de programação e identificar quais os recursos mínimos, de hardware e software, são necessários para colocar 1 (um) programa em funcionamento.'),
(166,11,'Desenvolver 1 (um) programa que ao ser executado apresente na tela os dizeres \'Alô Mundo\'.'),
(167,11,'Realizar uma apresentação sobre o que é software livre, citando exemplos.'),
(168,11,'Citar pelo menos 3 (três) tipos de licenciamento de programas e explicar como a pirataria pode ser prejudicial.'),
(169,11,'Desenvolver 1 (um) jogo ou aplicativo em qualquer linguagem ou 1 (um) site que utilize programação JavaScript ou equivalente com uma função relacionada ao escotismo. Após, apresentá-lo para a sua seção.'),
(170,11,'Explicar o uso de pelo menos 5 (cinco) funções em uma linguagem de programação bem como em que local pode-se buscar referências.'),
(171,11,'Citar 3 (três) repositórios de código e mostrar como podem agilizar a programação de software.'),
(172,11,'Demonstrar conhecimentos básicos sobre pelo menos 1 (um) ambiente de desenvolvimento integrado mostrando conhecimento quanto a sua utilização.'),
(173,11,'Pesquisar como funciona uma empresa de jogos digitais e relatar o seu funcionamento ao examinador.'),
(174,11,'Apresentar uma pesquisa sobre o que são emuladores.'),
(175,12,'Saber distinguir o que pode ou não ser considerado 1 (um) robô.'),
(176,12,'Conhecer os principais tipos de robô, suas características, propriedades e principais diferenças.'),
(177,12,'Apresentar 10 (dez) robôs utilizados na atualidade.'),
(178,12,'Montar e programar 1 (um) modelo com peças móveis e que tenha pelo menos 1 (um) componente eletroeletrônico para controlar os movimentos dos componentes móveis.'),
(179,12,'Montar 1 (um) modelo que tenha ao menos 3 (três) componentes móveis acionados por engrenagens, e/ou polias, e/ou correntes e seja rádio controlado ou controlado por 1 (um) dispositivo sem fio.'),
(180,12,'Montar e programar 1 (um) modelo que sirva como protótipo para a resolução por meio da robótica de algum problema mundial na atualidade.'),
(181,12,'Compreender e saber transmitir o conhecimento de qualquer robô construído, e a utilização do comando sem fio ou radio-controle ou a programação feita.'),
(182,12,'Montar e programar 1 (um) robô que possua pelo menos 2 (dois) sensores e utilize 1 (um) condicional e 1 (um) looping.'),
(183,12,'Montar e programar 1 (um) robô que possua pelo menos 4 (quatro) variáveis.'),
(184,12,'Montar e programar 1 (um) robô que possua duas variáveis e se comunique por WIFI ou bluetooth com outro robô do mesmo tipo.'),
(185,12,'Saber explicar duas funções já existentes no programa para Arduíno, ou similar, em linguagem de programação (C++, Javascript, etc.).'),
(186,12,'Saber acender 1 (um) LED utilizando uma linguagem de programação (C++, Javascript, etc.).');
/*!40000 ALTER TABLE `atividades_de_especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades_de_especialidades_feitas`
--

DROP TABLE IF EXISTS `atividades_de_especialidades_feitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividades_de_especialidades_feitas` (
  `atividade_de_especialidade_id_atividade` int NOT NULL,
  `data` date NOT NULL,
  `pessoa_id_pessoa` int NOT NULL,
  PRIMARY KEY (`atividade_de_especialidade_id_atividade`,`pessoa_id_pessoa`),
  KEY `FKrpv3op0lrc13n4dqv7pxx0ylm` (`pessoa_id_pessoa`),
  CONSTRAINT `FK9h4gl4sovo8bhubiluedrgat9` FOREIGN KEY (`atividade_de_especialidade_id_atividade`) REFERENCES `atividades_de_especialidades` (`id_atividade`),
  CONSTRAINT `FKrpv3op0lrc13n4dqv7pxx0ylm` FOREIGN KEY (`pessoa_id_pessoa`) REFERENCES `pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades_de_especialidades_feitas`
--

LOCK TABLES `atividades_de_especialidades_feitas` WRITE;
/*!40000 ALTER TABLE `atividades_de_especialidades_feitas` DISABLE KEYS */;
INSERT INTO `atividades_de_especialidades_feitas` VALUES
(19,'2023-10-02',1),
(19,'2023-10-02',2),
(20,'2023-10-03',1),
(20,'2023-10-03',2),
(21,'2023-10-04',1),
(21,'2023-10-04',2),
(22,'2023-10-05',1),
(22,'2023-10-05',2),
(23,'2023-10-06',1),
(23,'2023-10-06',2),
(24,'2023-10-07',1),
(24,'2023-10-07',2),
(25,'2023-10-08',1),
(25,'2023-10-08',2),
(26,'2023-10-09',1),
(26,'2023-10-09',2),
(27,'2023-10-10',1),
(27,'2023-10-10',2),
(28,'2023-10-11',1),
(28,'2023-10-11',2),
(29,'2023-10-12',1),
(29,'2023-10-12',2),
(30,'2023-10-13',1),
(43,'2023-06-07',1),
(43,'2023-06-02',2),
(44,'2023-06-06',1),
(44,'2023-06-03',2),
(45,'2023-06-05',1),
(45,'2023-06-04',2),
(46,'2023-06-04',1),
(46,'2023-06-05',2),
(47,'2023-06-03',1),
(47,'2023-06-06',2),
(48,'2023-06-02',1),
(48,'2023-06-07',2),
(94,'2023-07-02',1),
(94,'2023-07-02',2),
(95,'2023-07-03',1),
(95,'2023-07-03',2),
(96,'2023-07-04',1),
(96,'2023-07-04',2),
(97,'2023-07-05',1),
(97,'2023-07-05',2),
(98,'2023-07-06',1),
(98,'2023-07-06',2),
(99,'2023-07-07',1),
(99,'2023-07-07',2),
(100,'2023-07-08',1),
(100,'2023-07-08',2),
(101,'2023-07-09',1),
(101,'2023-07-09',2),
(102,'2023-07-10',1),
(102,'2023-07-10',2),
(103,'2023-09-02',1),
(103,'2023-09-02',2),
(104,'2023-09-03',1),
(104,'2023-09-03',2),
(105,'2023-09-04',1),
(105,'2023-09-04',2),
(106,'2023-09-05',1),
(106,'2023-09-05',2),
(107,'2023-09-06',1),
(107,'2023-09-06',2),
(108,'2023-09-07',1),
(109,'2023-09-08',1),
(110,'2023-09-09',1),
(111,'2023-09-10',1),
(163,'2023-08-02',1),
(163,'2023-08-02',2),
(164,'2023-08-03',1),
(164,'2023-08-03',2),
(165,'2023-08-04',1),
(165,'2023-08-04',2),
(166,'2023-08-05',1),
(166,'2023-08-05',2),
(167,'2023-08-06',1),
(167,'2023-08-06',2),
(168,'2023-08-07',1),
(168,'2023-08-07',2),
(169,'2023-08-08',1),
(169,'2023-08-08',2),
(170,'2023-08-09',1),
(170,'2023-08-09',2),
(171,'2023-08-10',1),
(171,'2023-08-10',2),
(172,'2023-08-11',1),
(172,'2023-08-11',2),
(173,'2023-08-12',1),
(173,'2023-08-12',2),
(174,'2023-08-13',1),
(174,'2023-08-13',2);
/*!40000 ALTER TABLE `atividades_de_especialidades_feitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades_de_insignias`
--

DROP TABLE IF EXISTS `atividades_de_insignias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividades_de_insignias` (
  `id_atividade` int NOT NULL AUTO_INCREMENT,
  `id_insignia` int NOT NULL,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_atividade`),
  KEY `FK9jnvq4bc9vu4xggcx83wlik8c` (`id_insignia`),
  CONSTRAINT `FK9jnvq4bc9vu4xggcx83wlik8c` FOREIGN KEY (`id_insignia`) REFERENCES `insignias` (`id_insignia`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades_de_insignias`
--

LOCK TABLES `atividades_de_insignias` WRITE;
/*!40000 ALTER TABLE `atividades_de_insignias` DISABLE KEYS */;
INSERT INTO `atividades_de_insignias` VALUES
(1,1,'Organizar o espaço de estudo adequadamente, observando a sua iluminação, local para acondicionamento dos materiais e ambiente.'),
(2,1,'Ter o seu material escolar devidamente organizado, demonstrado cuidados com os livros, cadernos e demais materiais.'),
(3,1,'Destinar o tempo adequado para seu estudo e tarefas de casa, relatando aos pais, a Akela ou outro Velho Lobo quanto tempo utiliza para essas atividades.'),
(4,1,'Participar, como Lobinho, de pelo menos uma edição do Projeto Educação Escoteira com sua Alcateia, ou de outra atividade em conjunto com escolas realizada pela sua Alcateia ou pelo seu Grupo Escoteiro/Seção Autônoma.'),
(5,1,'Participar ativamente de pelo menos duas atividades especiais em sua escola (Ex.: Festa Junina, Feira de Ciências, Excursão, etc.) e mostrar fotos ou relatório para a Alcateia.'),
(6,1,'Apoiar um colega de classe em alguma tarefa ou ajudá-lo a aprender algum conteúdo que tenha dificuldade.'),
(7,1,'Conversar com seus pais , Akela ou outro Velho Lobo sobre sua participação na escola, seu interesse pelos estudos e sobre os pontos que podem ser melhorados para ser um melhor aluno.'),
(8,2,'Indicar, no mapa mundi, onde estão localizados os demais países do Cone Sul, sabendo reconhecer suas bandeiras e explicar o significado das cores de cada uma delas.'),
(9,2,'Pesquisar a história de algo importante por sua utilidade que tenha sido inventado em um dos países do Cone Sul.'),
(10,2,'Degustar pelo menos um prato típico de outro país do Cone Sul, conhecendo sua história e origem.'),
(11,2,'Visitar exposições ou feiras culturais referentes a outros países do Cone Sul.'),
(12,2,'Conhecer uma lenda ou conto de outro país do Cone Sul e contá-la para Alcateia.'),
(13,2,'Conhecer a principal dança típica de pelo menos dois países do Cone Sul.'),
(14,2,'Ir a uma peça de teatro cujo roteiro seja de outro país do Cone Sul e não esteja adaptado.'),
(15,2,'Assistir uma animação ou filme nacional de outro país do Cone Sul.'),
(16,2,'Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país do Cone Sul.'),
(17,2,'Entrevistar alguém que esteja morando, ou tenha morado em algum país do Cone Sul.'),
(18,2,'Descobrir quais distintivos poderia conquistar se fosse de outro país do Cone Sul.'),
(19,2,'Ensinar a Alcateia a cantar uma canção escoteira de outro país do Cone Sul.'),
(20,2,'Conhecer as principais terminologias do Ramo Lobinho (Alcateia, Matilha, acampamento etc) em castelhano ou em outro idioma falado em países do Cone Sul, como o guarani.'),
(21,2,'Conhecer os nomes e os símbolos das Associações Escoteiras dos países que integram o Cone Sul.'),
(22,3,'Conhecer os principais problemas sociais de sua rua ou bairro e conversar com seus pais ou velhos lobos sobre como você poderia contribuir para resolvê-los.'),
(23,3,'Conhecer instituições de sua comunidade que realizam ações assistenciais a pessoas necessitadas ou orientação para a melhoria da vida das pessoas, procurando saber de que forma sua Alcateia poderia ajudá-las.'),
(24,3,'Participar de pelo menos uma edição do Mutirão Nacional Escoteiro de Ação Comunitária com sua Alcateia ou de outra atividade de ação comunitária realizada pela sua Alcateia ou por seu Grupo Escoteiro.'),
(25,3,'Perceber os eventuais perigos a que estão expostos os lobinhos em uma excursão ou acampamento/acantonamento e ajudar a aplicar as regras de segurança para evitá-los.'),
(26,3,'Participar de pelo menos três boas ações coletivas com sua Alcateia, contribuindo com ideias e ações para o planejamento e execução das atividades.'),
(27,3,'Participar de uma ação comunitária promovida por alguma instituição de sua comunidade: igreja, clube, escola, posto de saúde, polícia, bombeiros, casa comercial, etc. e fazer um relatório sobre essa participação.'),
(28,3,'Planejar e executar uma boa ação, diferente das realizadas anteriormente, que seja útil em sua Alcateia, casa, escola ou comunidade, com duração mínima de um mês, apresentando posteriormente os resultados para sua Alcateia.'),
(29,4,'Pesquisar os temperos e especiarias típicos dos países lusófonos, também presentes no Brasil.'),
(30,4,'Pesquisar a fauna e flora típicos dos países lusófonos, também presentes no Brasil.'),
(31,4,'Pesquisar utensílios e invenções utilizadas no Brasil, criados em algum país lusófono.'),
(32,4,'Indicar, no mapa mundi, onde estão localizados os países lusófonos e reconhecer suas respectivas bandeiras.'),
(33,4,'Visitar exposições ou feiras culturais referentes a outros países lusófonos.'),
(34,4,'Degustar pelo menos uma refeição típica de outro país lusófono, conhecendo sua história e origem.'),
(35,4,'Ir a uma peça de teatro cujo roteiro seja de outro país lusófono e não esteja adaptado.'),
(36,4,'Assistir um espetáculo (circo, show musical etc) que seja originário de outro país lusófono.'),
(37,4,'Conhecer uma lenda ou conto de outro país lusófono, e contá-la para sua Alcateia.'),
(38,4,'Entrevistar alguém que tenha morado, ou esteja morando, em um país lusófono.'),
(39,4,'Ver um filme nacional ou animação de outro país Lusófono.'),
(40,4,'Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país Lusófono.'),
(41,4,'Descobrir quais distintivos o Lobinho poderia conquistar se fosse de outro país lusófono.'),
(42,4,'Fazer uma lista de termos escoteiros utilizados em outro país lusófono.'),
(43,4,'Conhecer o símbolo das Associações Escoteiras dos países lusófonos.');
/*!40000 ALTER TABLE `atividades_de_insignias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividades_de_insignias_feitas`
--

DROP TABLE IF EXISTS `atividades_de_insignias_feitas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividades_de_insignias_feitas` (
  `atividade_de_insignia_id_atividade` int NOT NULL,
  `data` date NOT NULL,
  `pessoa_id_pessoa` int NOT NULL,
  PRIMARY KEY (`atividade_de_insignia_id_atividade`,`pessoa_id_pessoa`),
  KEY `FK1s5qdyn1dr6txxi89pnuy752l` (`pessoa_id_pessoa`),
  CONSTRAINT `FK1s5qdyn1dr6txxi89pnuy752l` FOREIGN KEY (`pessoa_id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  CONSTRAINT `FK9nubaphld4m04hb4r9ogflrpw` FOREIGN KEY (`atividade_de_insignia_id_atividade`) REFERENCES `atividades_de_insignias` (`id_atividade`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades_de_insignias_feitas`
--

LOCK TABLES `atividades_de_insignias_feitas` WRITE;
/*!40000 ALTER TABLE `atividades_de_insignias_feitas` DISABLE KEYS */;
INSERT INTO `atividades_de_insignias_feitas` VALUES
(1,'2023-07-01',1),
(1,'2023-07-01',2),
(2,'2023-07-02',1),
(2,'2023-07-02',2),
(3,'2023-07-03',1),
(3,'2023-07-03',2),
(4,'2023-07-04',1),
(4,'2023-07-04',2),
(5,'2023-07-05',1),
(5,'2023-07-05',2),
(6,'2023-07-06',1),
(6,'2023-07-06',2),
(7,'2023-07-07',1);
/*!40000 ALTER TABLE `atividades_de_insignias_feitas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dados_de_saude`
--

DROP TABLE IF EXISTS `dados_de_saude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dados_de_saude` (
  `id_pessoa` int NOT NULL,
  `id_problema_de_saude` int NOT NULL,
  PRIMARY KEY (`id_pessoa`,`id_problema_de_saude`),
  KEY `FKgrclond3ddxxxktqy8coenu4k` (`id_problema_de_saude`),
  CONSTRAINT `FKgrclond3ddxxxktqy8coenu4k` FOREIGN KEY (`id_problema_de_saude`) REFERENCES `problemas_de_saude` (`id_problema_de_saude`),
  CONSTRAINT `FKhiiey89dobugubx7u48uwk5dm` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dados_de_saude`
--

LOCK TABLES `dados_de_saude` WRITE;
/*!40000 ALTER TABLE `dados_de_saude` DISABLE KEYS */;
INSERT INTO `dados_de_saude` VALUES
(1,1),
(2,1),
(1,2),
(3,3);
/*!40000 ALTER TABLE `dados_de_saude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distintivos`
--

DROP TABLE IF EXISTS `distintivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distintivos` (
  `id_distintivo` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_distintivo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distintivos`
--

LOCK TABLES `distintivos` WRITE;
/*!40000 ALTER TABLE `distintivos` DISABLE KEYS */;
INSERT INTO `distintivos` VALUES
(1,'Lobo Pata Tenra'),
(2,'Lobo Saltador'),
(3,'Lobo Rastreador'),
(4,'Lobo Caçador'),
(5,'Cruzeiro do Sul');
/*!40000 ALTER TABLE `distintivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidades` (
  `id_area_de_conhecimento` int NOT NULL,
  `id_especialidade` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_especialidade`),
  KEY `FK2x3un1tqnp6phywqeyid3k6qy` (`id_area_de_conhecimento`),
  CONSTRAINT `FK2x3un1tqnp6phywqeyid3k6qy` FOREIGN KEY (`id_area_de_conhecimento`) REFERENCES `areas_de_conhecimento` (`id_area_de_conhecimento`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidades`
--

LOCK TABLES `especialidades` WRITE;
/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` VALUES
(1,1,'Automobilismo Rádio Controlado'),
(1,2,'Comunicações'),
(1,3,'Criptografia'),
(1,4,'Echolink'),
(1,5,'Eletrônica'),
(1,6,'Energia'),
(1,7,'Engenharia'),
(1,8,'GPS'),
(1,9,'Informática'),
(1,10,'Invenção'),
(1,11,'Programação'),
(1,12,'Robótica'),
(4,13,'Acampamento'),
(4,14,'Culinária'),
(5,15,'Radioamadorismo'),
(5,16,'Radioescuta'),
(5,17,'Faixa do Cidadão'),
(5,18,'Internet');
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `insignias`
--

DROP TABLE IF EXISTS `insignias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insignias` (
  `id_insignia` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_insignia`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insignias`
--

LOCK TABLES `insignias` WRITE;
/*!40000 ALTER TABLE `insignias` DISABLE KEYS */;
INSERT INTO `insignias` VALUES
(1,'Insígnia do Aprender'),
(2,'Insígnia do Cone Sul'),
(3,'Insígnia da Boa Ação'),
(4,'Insígnia da Lusofonia'),
(5,'Insígnia Campeões da Natureza'),
(6,'Insígnia Reduzir, Reciclar, Reutilizar'),
(7,'Insígnia Escoteiros pela Energia Solar');
/*!40000 ALTER TABLE `insignias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noites_acampadas`
--

DROP TABLE IF EXISTS `noites_acampadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noites_acampadas` (
  `id_pessoa` int NOT NULL,
  `id_acampamento` bigint NOT NULL,
  PRIMARY KEY (`id_pessoa`,`id_acampamento`),
  KEY `FKt0i00qow5hmcy1xf211dwdp58` (`id_acampamento`),
  CONSTRAINT `FK90pb5xr3xuqjb0xgfnscte636` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  CONSTRAINT `FKt0i00qow5hmcy1xf211dwdp58` FOREIGN KEY (`id_acampamento`) REFERENCES `acampamentos` (`id_acampamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noites_acampadas`
--

LOCK TABLES `noites_acampadas` WRITE;
/*!40000 ALTER TABLE `noites_acampadas` DISABLE KEYS */;
INSERT INTO `noites_acampadas` VALUES
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(6,1),
(7,1),
(8,1),
(1,2),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2),
(1,3);
/*!40000 ALTER TABLE `noites_acampadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `data_nascimento` date NOT NULL,
  `id_pessoa` int NOT NULL AUTO_INCREMENT,
  `id_tipo_sanguineo` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pessoa`),
  KEY `FK38tjl16ap8d8pqa1399ln3cth` (`id_tipo_sanguineo`),
  CONSTRAINT `FK38tjl16ap8d8pqa1399ln3cth` FOREIGN KEY (`id_tipo_sanguineo`) REFERENCES `tipo_sanguineo` (`id_tipo_sanguineo`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES
('2016-09-14',1,8,NULL,'André Coelho Matos',NULL),
('2014-04-08',2,1,NULL,'Suzanne Nadine Vega',NULL),
('2014-08-12',3,3,NULL,'Eithne Pádraigín Ní Bhraonáin',NULL),
('2017-02-01',4,6,NULL,'James Roy Horner',NULL),
('2016-01-01',5,7,NULL,'Linus Benedict Torvalds',NULL),
('2013-12-31',6,5,NULL,'Steven Paul Jobs',NULL),
('2014-01-01',7,8,NULL,'William Henry Gates III',NULL),
('2015-12-07',8,1,NULL,'Richard Matthew Stallman',NULL),
('2014-11-09',9,3,NULL,'Philo Taylor Farnsworth',NULL),
('2016-10-10',10,8,NULL,'Isadore Friz Freleng',NULL),
('2017-01-17',11,6,NULL,'Hans Florian Zimmer',NULL),
('1996-07-12',12,8,'aa','João','1234');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problemas_de_saude`
--

DROP TABLE IF EXISTS `problemas_de_saude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problemas_de_saude` (
  `id_problema_de_saude` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `tipo_de_problema` varchar(255) NOT NULL,
  PRIMARY KEY (`id_problema_de_saude`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problemas_de_saude`
--

LOCK TABLES `problemas_de_saude` WRITE;
/*!40000 ALTER TABLE `problemas_de_saude` DISABLE KEYS */;
INSERT INTO `problemas_de_saude` VALUES
(1,'Frutos do mar.','Alergia'),
(2,'Bijuteria.','Alergia'),
(3,'Suor.','Alergia'),
(4,'Lactose.','Alergia'),
(5,'Medicamentos.','Alergia');
/*!40000 ALTER TABLE `problemas_de_saude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsavel`
--

DROP TABLE IF EXISTS `responsavel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsavel` (
  `id_responsavel` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  PRIMARY KEY (`id_responsavel`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsavel`
--

LOCK TABLES `responsavel` WRITE;
/*!40000 ALTER TABLE `responsavel` DISABLE KEYS */;
INSERT INTO `responsavel` VALUES
(1,'carl@sagan.com','Carl Edward Sagan','12345678910'),
(2,'vangelis@gmail.com','Evángelos Odysséas Papathanassíu','0987654321'),
(3,'albert@einstein.com','Albert Einstein','12345678910'),
(4,'machado@assis.com','Joaquim Maria Machado de Assis','1029384756'),
(5,'maria@dupre.com','Maria José Dupré','6758493021'),
(6,'orlando@drummond.com','Orlando Drummond Cardoso','7182934682'),
(7,'jonas@mello.com','Jonas Rodrigues de Mello','917382465'),
(8,'jorgeh@ramos.com','Jorgeh José Ramos','789654123'),
(9,'gerson@abreu.com','Gérson Ribeiro de Abreu Júnior','321456987');
/*!40000 ALTER TABLE `responsavel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_sanguineo`
--

DROP TABLE IF EXISTS `tipo_sanguineo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_sanguineo` (
  `id_tipo_sanguineo` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_tipo_sanguineo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_sanguineo`
--

LOCK TABLES `tipo_sanguineo` WRITE;
/*!40000 ALTER TABLE `tipo_sanguineo` DISABLE KEYS */;
INSERT INTO `tipo_sanguineo` VALUES
(1,'A+'),
(2,'A-'),
(3,'B+'),
(4,'B-'),
(5,'AB+'),
(6,'AB-'),
(7,'O+'),
(8,'O-');
/*!40000 ALTER TABLE `tipo_sanguineo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vinculo`
--

DROP TABLE IF EXISTS `vinculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vinculo` (
  `id_pessoa` int NOT NULL,
  `id_responsavel` int NOT NULL,
  PRIMARY KEY (`id_pessoa`,`id_responsavel`),
  KEY `FKt2ulxw29ifef2rt4lr93ln4db` (`id_responsavel`),
  CONSTRAINT `FK6nv6pg20v5qp4hssboxkj0foo` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`),
  CONSTRAINT `FKt2ulxw29ifef2rt4lr93ln4db` FOREIGN KEY (`id_responsavel`) REFERENCES `responsavel` (`id_responsavel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vinculo`
--

LOCK TABLES `vinculo` WRITE;
/*!40000 ALTER TABLE `vinculo` DISABLE KEYS */;
INSERT INTO `vinculo` VALUES
(1,1),
(2,1),
(3,2),
(4,3),
(5,4),
(6,5),
(7,6),
(8,7),
(9,8),
(10,9),
(11,9),
(12,9);
/*!40000 ALTER TABLE `vinculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-17 22:51:00
