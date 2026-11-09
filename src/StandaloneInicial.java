/*
===== JUSTIFICATIVA DO ESCOPO =====

Nesse standalone inicial, eu optei pra fazer um menu simples com opções que simulem funcionalidades que
serão aplicadas posteriormente ao sistema. As opções 1 e 2 correspondem aos requisitos funcionais RF02
e RF03 (O sistema deve permitir que recepcionistas cadastrem animais / veterinários). Já a opção 3
corresponde à regra de negócio RN01 (As consultas duram 30 minutos e só podem ser marcadas de segunda a
sexta, das 8h às 18h).

Além de criar um menu, utilizar estruturas condicionais e laços de repetição como switch...case e do...while,
eu optei por fazer algumas validações para deixar o standalone mais real, como a dos nomes de espécies,
a da idade do animal, além das validações da opção 3.

Com relação à regra de negócio RN01, eu interpretei que as consultas podem ser marcadas de 8h às 18h,
de meia em meia hora, começando no horário das 8h00. Dessa forma, o último horário disponível para
agendamento é o das 18h00. Além disso, na simulação de validação do dia da consulta (opção 3), considerei
1 como Domingo, 2 como Segunda-feira, e assim por diante.

O que ficou fora do escopo do TP1: como ainda não há armazenamento de dados, deixei para as próximas entregas
a autenticação e os perfis (RF01), o agendamento real de consultas (RF04), o conflito de horários (RN02),
a validação de datas passadas (RN03), o cancelamento e a marcação de consultas como realizadas (RN04 e RN05),
as notas de observação pelos veterinários (RF11), além da visualização das consultas (RF12). Por isso,
a opção 3 apenas valida o horário, sem agendar nada, e os cadastros apenas mostram os dados informados,
sem armazená-los de fato.

*/

import java.util.Scanner;

public class StandaloneInicial {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int opcao = 0;

        do {
            System.out.println();
            System.out.println("===== SIMULAÇÃO DE CADASTROS =====");
            System.out.println("1. Cadastrar veterinário");
            System.out.println("2. Cadastrar animal");
            System.out.println("3. Simular validação do horário de consulta");
            System.out.println("4. Sair");
            System.out.println();
            System.out.print("Digite a opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sc.nextLine(); // Para tratamento dos caracteres invisíveis
                    System.out.print("Digite o nome do veterinário: ");
                    String nomeVeterinario = sc.nextLine();

                    System.out.print("Digite o CRMV do veterinário: ");
                    String crmv = sc.nextLine();

                    System.out.println();
                    System.out.println("Veterinário cadastrado com sucesso.");
                    System.out.println("Nome: " + nomeVeterinario);
                    System.out.println("CRMV: " + crmv);
                    break;
                case 2:
                    sc.nextLine(); // Para tratamento dos caracteres invisíveis
                    System.out.print("Digite o nome do animal: ");
                    String nomeAnimal = sc.nextLine();

                    System.out.print("Digite a espécie do animal (cão/gato): ");
                    String especieAnimal = sc.nextLine();

                    if (!especieAnimal.equalsIgnoreCase("cão") && !especieAnimal.equalsIgnoreCase("gato")) {
                        System.out.println("Por favor, informe uma espécie válida.");
                        break;
                    }

                    System.out.print("Digite a idade do animal: ");
                    int idadeAnimal = sc.nextInt();

                    if (idadeAnimal < 0) {
                        System.out.println("A idade do animal não pode ser negativa.");
                        break;
                    }

                    sc.nextLine(); // Para tratamento dos caracteres invisíveis
                    System.out.print("Digite o nome do tutor: ");
                    String nomeTutor = sc.nextLine();

                    System.out.print("Digite o telefone do tutor: ");
                    String telefoneTutor = sc.nextLine();

                    System.out.println();
                    System.out.println("Animal cadastrado com sucesso.");
                    System.out.println("Nome: " + nomeAnimal);
                    System.out.println("Espécie: " + especieAnimal);
                    System.out.println("Idade: " + idadeAnimal);
                    System.out.println("Nome do tutor: " + nomeTutor);
                    System.out.println("Telefone do tutor: " + telefoneTutor);
                    break;
                case 3:
                    String nomeDia = "";

                    System.out.print("Digite o número do dia da semana da consulta (1 a 7): ");
                    int diaConsulta = sc.nextInt();

                    if (diaConsulta < 1 || diaConsulta > 7) {
                        System.out.println("Por favor digite um número de 1 a 7.");
                        break;
                    } else if (diaConsulta == 1 || diaConsulta == 7) {
                        System.out.println("Consultas só podem ser agendadas de segunda à sexta.");
                        break;
                    } else {
                        switch (diaConsulta)
                        {
                            case 2:
                                nomeDia = "Segunda-feira";
                                break;
                            case 3:
                                nomeDia = "Terça-feira";
                                break;
                            case 4:
                                nomeDia = "Quarta-feira";
                                break;
                            case 5:
                                nomeDia = "Quinta-feira";
                                break;
                            case 6:
                                nomeDia = "Sexta-feira";
                                break;
                        }
                    }

                    System.out.print("Digite a hora da consulta (sem os minutos): ");
                    int horaConsulta = sc.nextInt();

                    if (horaConsulta < 8 || horaConsulta > 18) {
                        System.out.println("Consultas só podem ser agendadas das 8h às 18h.");
                        break;
                    }

                    System.out.print("Digite os minutos da consulta (00 ou 30): ");
                    int minConsulta = sc.nextInt();

                    if (minConsulta != 0 && minConsulta != 30) {
                        System.out.println("Os minutos tem que ser 00 ou 30.");
                        break;
                    } else if (horaConsulta == 18 && minConsulta == 30) {
                        System.out.println("O último horário para agendamento é às 18h00.");
                        break;
                    }

                    System.out.println();
                    System.out.println("Horário validado.");
                    System.out.println("Dia da semana: " + nomeDia);
                    System.out.println("Horário: " + horaConsulta + "h" + minConsulta);
                    break;
                case 4:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        System.out.println("Programa encerrado.");
        sc.close();
    }
}