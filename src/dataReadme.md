//diferenca entre data hora global e a data hora local:
a global se importa com o fuso horario.
obs. exemplo de data hora global, 2023-11-26T10:37:00Z
onde esse Z representa o horario de londres. varias pessoas de regioes diferentes podem acessar esse horario, isso é bom.
se a pessoa esta em londres vai ser esse horario ai, mas se a pessoa esta em portugal, vai aparecer 11:37hs e se esta no ...
brasil sera 07:37hs. 
obs. usa data local qd usa em sistemas local, ou excel, ou seja nao precisa de outras pessoas em outras localizacoes. ex data de nascimento.
obs ja para data hora global é qd o momento exato interessa a outras pessoas de outros países, vai usar muito na web. ex tal comentario...
foi postado tal hora. outro exemplo é anunciar qd sera o sorteio de algo dia 13/10/23 as 13hs (horario de sao paulo).

//timezone (ou fuso horario):
GMT - greenwich mean time. que é o horario de londres. é horario padrao UTC - universal time coordenated. chamado de ''Z''' time, ou zulu time.
exemplo:
sao paulo GMT -3
manaus GMT -4
portugal GMT +1 (esta adiantado 1h em relacao a londres)
obs tem linguagens que usam nomes para as timezones. exemplo america/sp.

//padrao iso 8601:
especifica como representar data de horas na forma de texto. 
*data hora local, ou seja nao precisa especificar o fuso horario:
2023-11-26
2023-11-26T10:50
2023-11-26T10:50:50
2023-11-26T10:50:50.4073 (obs aqui ja tem a fração de segundos no final)
*data hora global
2023-11-26T10:55:00Z (obs esse Z é o zulu time que é o horario de londres)
2023-11-26T10:55:00.254935Z (aqui ja tema fração de segundos no final. a fração de segundos vem com ponto antes dela)
2023-11-26T10:55:00-03:00 (obs aqui ja diz que é um fuso horario diferente do GMT, que é o -3, que é como se fosse o horario de sao paulo).

obs é esse padrao acima que vamos encontrar em banco de dados, etc. por isso é muito importante aprendermos.

----------------------------------------------
//operacoes importantes com data hora:
*instanciar
agora -> data hora (obs tenho que saber instanciar um objeto na hora local. ex registrar um pedido no momento que ele foi feito. )
texto ISO 8601 -> data hora (obs converter esse texto que vem da api, em uma data hora da sua linguagem)
texto formato customizado -> data hora (obs é transformar esse texto customizado para o formato data hora)
dia, mes, ano, [horario] - > data hora local (obs ex transformar as 3 caixinhas que tem no site de dia mes e ano, em formato de data hora)

*formatacao
obs agora é o contrario do que vimos na linha acima.
data hora - > texto ISO 8601
data hora -> formato custorizado

*obter dados de uma data hora local. é saber extrair.
data hora local -> dia, mes, ano, horario

*converter data hora global para local.
obs aqui vou transformar a global para a local, e depois extrair o que desejo.
data hora global -> data hora local 

*calculos com data hora:
data hora + - tempo -> data hora (obs quero colocar 1 ano pra frente ou 1 ano pra tras)
data hora 1, data hora 2 -> duracao (obs dadas duas datas horas, tem que saber a diferenca de tempo entre elas).

-------------------------------------------------
//principais tipos java
obs com o java 8 la em 2014,  teve um grande marco na linguagem, apareceu lambdas, novo sistema de data. 
obs entao vamos ver abaixo como representar as datas em java:
*data hora local
LocalDate (obs qd tivermos apenas a data)
LocalDateTime (obs qd tivermos data e tambem o horario)

*data hora global
Instant (obs ele representa o instante do tempo, é usado para representar o momento atual na data hora global)

*duracao
Duration

*outros 
ZoneId
ChronoUnit







