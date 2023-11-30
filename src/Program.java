import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------");
        //OBS PARA TODOS OS CASOS ABAIXO, REPARA QUE NA HORA DE EXIBIR NA TELA, ELE JA VEM IMPLICITO...
        //... O METODO TOSTRING(), JUSTAMENTE PARA EXIBIR ESSES OBJETOS. E JA FAZ NO FORMATO ISO 8601.
        //exemplo System.out.println(d05.toString());

        //data hora local instanciando, ele pega a data do sistema e cria um objeto do tipo LocalDate.
        LocalDate d01 = LocalDate.now();
        System.out.println(d01);

        //data hora local e tem o horario, repara que na resposta vem o T de time, e o ponto em milissegundos.
        //é a data e hora local que ta no meu computador, nao importa o fuso horario.
        LocalDateTime d02 = LocalDateTime.now();
        System.out.println(d02);

        //data hora global, repara que na resposta tem o Z no final que é o Zulu time que é GMT
        //repara que gera a data e hora de londres, que é o horario GMT, ele considera o fuso horario
        Instant d03 = Instant.now();
        System.out.println(d03);

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("AGORA VAMOS CONVERTER DE TEXTO PARA DATA HORA : ");
        //agora a partir de um texto, vamos gerar uma data local. para isso usamos o metodo estatico 'parse' ja que vem do LocalDate.
        LocalDate d04 = LocalDate.parse("1984-04-18");
        System.out.println(d04);

        //agora vamos a partir de um texto gerar uma data hora local mas com horario tambem.
        //é bem semelhante ao caso de cima, so que agora tem horario
        LocalDateTime d05 = LocalDateTime.parse("1984-04-18T23:10:25");
        System.out.println(d05);

        //transformar a hora em texto para uma data hora global, que sera o horario la de londres esse
        Instant d06 = Instant.parse("1984-05-10T16:10:05Z");
        System.out.println(d06);

        //se eu quiser guardar a data global mas no formato aqui que estou no caso sao paulo
        //colocamos a hora daqui, e o fuso daqui, e ele vai mostrar qual hora seria em londres.
        Instant d07 = Instant.parse("1984-04-18T16:10:10-03:00");
        System.out.println(d07);

        //agora vamos pegar um formato texto mas que esta customizado ou seja fora do padrao.
        //entao usamos o DateTimeFormatter, essa classe serve pra formatar data, ou seja converte de string para objeto data hora.
        //vou entao criar um formato modelo, um padrao que vou escolher dd/MM/yyy
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //o metodo parse do localDate tem uma sobrecarga que aceita o fmt1 que é um metodo pra dizer como sera a data
        //ou seja eu passo o formato que eu quero, o customizado, e ele transforma em formato ISO 8601.
        LocalDate d08 = LocalDate.parse("10/05/2022", fmt1);
        System.out.println(d08);
        /* outra boa opcao de digitacao que podemos fazer, é direto assim, e ja colocar o DateTimeFormatter direto.
        //obs. no segundo campo do parenteses, ja colocamos o DateTimeFormatter customizado como desejamos que ele leia.
        //obs é uma outra maneira de se fazer os exemplos acima, mas com menos linhas de codigo, só isso.
        LocalDate d08 = LocalDate.parse("01/10/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy");
         */

        //vamos fazer mais um exemplo com DateTimeFormatter, mas agora com a hora.
        //eu escolhi o formato ou seja eu customizei, e depois quando eu inseri a data e hora ele transforma para o formato ISO 8601.
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm");
        LocalDateTime d09 = LocalDateTime.parse("01/10/2020 13:01", fmt2);
        System.out.println(d09);

        //usando o ''of'' para pegar ano, mes e dia... e transformar para o padrao ISO 8601.
        LocalDate d10 = LocalDate.of(2022, 04, 01);
        System.out.println(d10);

        //usando mais ''of'' ... mas dessa vez transformando data e a hora para o formato ISO 8601.
        LocalDateTime d11 = LocalDateTime.of(2022, 04, 01, 22, 05);
        System.out.println(d11);

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("AGORA VAMOS CONVERTER DE DATA HORA ISO PARA TEXTO : ");
        // primeiro eu tenho a minha data no formato padrao ISO 8601 e quero transforma-la para texto
        //...depois eu vou criar um formato fmt3, ou seja um formato que eu quero customizar.
        //...e depois vou aplicar esse formato que criei para transformar do padrao ISO 8601, para texto.
        //e depois vou chamar o metodo format(). para formatar para o formato customizado que criei.
        LocalDate d12 = LocalDate.parse("2022-10-15");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(d12.format(fmt3));
        //obs essa ultima linha de codigo tb posso fazer assim, chamando o fmt3 e o metodo format() e depois a variavel d12. vai dar o mesmo resultado do codigo acima.
        System.out.println(fmt3.format(d12));
        //tem ainda mais uma opcao que é ja instanciar na hora DateTimeFormatter.
        //obs aqui ele nao cria o objeto fmt3 fora, mas sim instancia direto do DateTimeFormatter e depois ja descarta ele qd acabar de usar.
        System.out.println(d12.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        //agora vamos transformar uma data e hora ISO 8601 para um formato customizado de data e hora.
        //primeiro tenho o formato de hora em ISO 8601, e depois vou criar um objeto fmt4 para armazenar um novo padrao customizado que desejo criar.
        LocalDateTime d13 = LocalDateTime.parse("2020-07-12T01:30:15");
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(d13.format(fmt4));

        //agora com um Instant.
        //o Instant nao tem o format() porque tenho que falar qual o fuso horario que vou considerar..
        //entao usamos o metodo whithZone(ZoneId.systemDefault()) onde ele pega o fuso horario do computador do usuario.
        //e na hora de exibir eu chamo primeiro o objeto de ohora que criei, e depois sim o format().
        //obs temos sempre que especificar o fuso horario, nao pode fazer sem isso, tem que usar o withZone(ZoneId.systemDefault()) para ele ler o fuso horario do computador local.
        //e na hora de exibir na tela, repara que vai exibir a hora no fuso horario do computador que esta.
        Instant d14 = Instant.parse("2022-07-01T13:05:22Z");
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        System.out.println(fmt5.format(d14));

        //outra boa opcao que temos, é consultar a documentacao oficial que esta na linha abaixo, e usar direto as palavras reservadas, ao inves de fazer o ofPattern().
        //esse padrao ISO_DATE_TIME é um padrao ISO europa, ele ja transforma direto para esse padrao. esse é um padrao local, ele nao é fuso horario, nao funciona com Instant
        LocalDateTime d15 = LocalDateTime.parse("2022-10-01T15:20:25");
        DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(fmt6.format(d15));

        //se quisermos usar com o Instant, algum padrao ja pronto la na documentacao, entao temos que usar o padrao da documentacao chamado ISO_INSTANT
        //é pq sempre que for mexer com Instant, tem que ser um com fuso horario.
        Instant d16 = Instant.parse("2023-01-01T20:20:05Z");
        DateTimeFormatter fmt7 = DateTimeFormatter.ISO_INSTANT;
        System.out.println(fmt7.format(d16));

        // SEGUE SITE OFICIAL DA ORACLE COM DOCUMENTACAO SOBRE  DATETIMEFORMATTER.
        // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html


        System.out.println("------------------------------------------------------------------------------");
        //converter de data global para data local.
        //vamos ver o ZoneId.getAvailableZoneIds() que vai listar para nós as regioes de fuso horario.
        //sao mais de 600 regioes.
        for (String s : ZoneId.getAvailableZoneIds()) {
            System.out.println(s);
        }
        //vamos comecar a ver os exemplos, de transformar de data global para data local.
        //primeiro vamos pegar um Instant que é data global, formato iso padrao mesmo...
        //e vamos transforma-lo para data local, que é LocalDate da minha maquina mesmo do meu computador.
        // no r1 usamos o ofInstant(Instant, regiao para qual quero transformar)... que aqui é a data local do meu computador mesmo
        //ja no r2 vamos usar a data local da regiao de portugal. entao usamos o ZoneId.of() e dentro colocamos a regiao.
        //agora vamos criar um LocalDateTime para os exemplos acima...
        Instant d17 = Instant.parse("2018-01-30T01:25:44Z");
        LocalDate r1 = LocalDate.ofInstant(d17, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d17, ZoneId.of("Portugal"));
        LocalDateTime r3 = LocalDateTime.ofInstant(d17, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d17, ZoneId.of("Portugal"));
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);

        //pegando o dia ou hora de uma data local. como fazemos isso?
        //primeiro temos a data local...e depois usamos o get() e escolhemos qual metodo usar, nesse caso para pegar o dia do mes, usamos getDayOfMonth().
        //outra opcao é pegarmos o mês, usamos entao o metodo getMonthValue().
        //outra opcao é pegarmos o ano, usamos o metodo getYear().
        LocalDate d18 = LocalDate.parse("2022-12-02");
        System.out.println(d18.getDayOfMonth());
        System.out.println(d18.getMonthValue());
        System.out.println(d18.getYear());

        //vamos fazer os mesmos exercicios anteriores, mas agora com LocalDateTime.
        //vamos pegar a hora, usamos o metodo getHour()
        //vamos pegar os minutos, usa o metodo getMinute()
        LocalDateTime d19 = LocalDateTime.parse("2022-01-31T15:12:22");
        System.out.println(d19.getHour());
        System.out.println(d19.getMinute());

        System.out.println("------------------------------------------------------------------------------");
        //agora vamos subtrair ou aumentar a partir de uma data.
        //usando o minus() e o plus(), ele subtrai e adiciona, respectivamente.
        //vamos testar o minusDays() onde ele vai reduzir a data conforme a qt de dias que escolhermos para reduzir.
        //podemos testar o plusDays() onde vai aumentar a data conforme a qt de dias que escolhermos para aumentar.
        LocalDate d20 = LocalDate.parse("2022-10-10");
        LocalDate pastWeekLocalDate = d20.minusDays(7);
        LocalDate nextWeekLocalDate = d20.plusDays(7);
        System.out.println(pastWeekLocalDate);
        System.out.println(nextWeekLocalDate);

        //para o LocalDateTime é a mesma coisa dos exemplos anteriores com LocalDate, so que agora tem a hora tbm.
        //obs para o LocalDateTime ja temos os metodos de horas, minutos e segundos e ate de milissegundos.
        LocalDateTime d21 = LocalDateTime.parse("2023-05-02T13:22:25");
        LocalDateTime  pastWeekLocalDateTime = d21.minusDays(7);
        LocalDateTime  nextWeekLocalDateTime = d21.plusDays(7);
        System.out.println(pastWeekLocalDateTime);
        System.out.println(nextWeekLocalDateTime);

        //agora vamos fazer para o Instant, que é a data global.
        //para o Instant, nao tem o metodo minusDays()....tem que usar o minus() passando uma quantia e o temporalUnit. e ai...
        //pode especificar se quero dias, mes, anos etc.
        //nesse caso vou instanciar um objeto chamado ChronoUnit e dai vou poder escolher se quero dias,mes, anos etc.
        Instant d22 = Instant.parse("2022-01-14T10:20:11Z");
        Instant pastWeekInstant = d22.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d22.plus(7, ChronoUnit.DAYS);
        System.out.println(pastWeekInstant);
        System.out.println(nextWeekInstant);

        //agora vamos descobrir a duracao entre 2 datas horas.
        //pra isso vou importar o Duration no java.time.Duration.
        //dai preciso chamar o metodo Duration.between e dentro vou colocar as duas datas que quero saber a duracao.
        //depois vou imprimir, mas tenho que chamar o toDays() por exemplo ou qq outro metodo.
        Duration d1 = Duration.between(pastWeekInstant, nextWeekInstant);
        System.out.println(d1.toDays());

        //agora ainda usando o Duration, vamos achar a duracao entre duas datas, e ambas as datas nao tem hora...
        //ou seja elas sao LocalDate e nao LocalDateTime.
        //entao usamos nesse LocalDate o metodo .atTime() e passamos ai dentro a hora por exemplo zero e zero....
        // e tb podemos usar o metodo....atStartOfDay() que ele converte para LocalDateTime na meia noite que é o começo do dia.
        Duration d2 = Duration.between(pastWeekLocalDate.atTime(0, 0), nextWeekLocalDate.atStartOfDay( ));
        System.out.println(d2.toDays());

    }
}
