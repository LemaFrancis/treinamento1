import java.util.List;
import java.util.Scanner;

class Interface {

    private Empresa empresa;

    Interface() {
        this.empresa = new Empresa();
    }

    //================= GERENCIAR USUARIO ==============//
    private void gerenciarUsuario() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while (op == 0) {
            System.out.println("**********************************************");
            System.out.println("*         1 - GERENCIAR USUÁRIO              *");
            System.out.println("*--------------------------------------------*");
            System.out.println("*  ( 1 ) - Cadastrar novo usuário            *");
            System.out.println("*  ( 2 ) - Edita usuário                     *");
            System.out.println("*  ( 3 ) - Listar todos os usuários          *");
            System.out.println("*  ( 4 ) - Remover usuário(s)                *");
            System.out.println("*  ( 0 ) - Voltar ao menu principal          *");
            System.out.println("**********************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (3)  (4)  (0)");

            switch (scan.nextInt()) {
                case 0:
                    menuPrincipal();
                    op = 1;
                    break;
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    editarUsuario();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    removerUsuario();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
        System.out.println(this.empresa.getListaUsuario());
    }

    private void cadastrarUsuario() {
        String nome, cpf, dataNascimento, sexo, cargo;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o nome: ");
        nome = scanner.nextLine();
        System.out.println("Digite o cpf: ");
        cpf = scanner.nextLine();
        System.out.println("Digite a data de nascimento: ");
        dataNascimento = scanner.nextLine();
        System.out.println("Digite o sexo (M ou F): ");
        sexo = scanner.nextLine();
        System.out.println("Selecione o cargo pretendido: ");
        this.listarCargos();

        int pos = scanner.nextInt();
        System.out.println("POSITION: " + pos);
        cargo = selecionarCargo(pos);

        Usuario usuario = new Usuario(nome, cpf, dataNascimento, sexo, cargo);
        this.empresa.inserirUsuario(usuario);
        this.listarUsuarios();
    }

    private void removerUsuario() {
        String cpf;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o CPF do usuário que deseja remover: ");
        cpf = scanner.nextLine();
        this.empresa.removerUsuario(cpf);
        this.listarUsuarios();
    }

    private void listarUsuarios() {
        for (Usuario user : this.empresa.getListaUsuario()) {
            System.out.println(user + "\n");
        }
    }

    private void editarUsuario() {

    }

    //================= GERENCIAR CARGO ===============//
    private void gerenciarCargo() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while (op == 0) {
            System.out.println("**********************************************");
            System.out.println("*         2 - GERENCIAR CARGO                *");
            System.out.println("*--------------------------------------------*");
            System.out.println("*  ( 1 ) - Cadastrar novo cargo              *");
            System.out.println("*  ( 2 ) - Edita cargo                       *");
            System.out.println("*  ( 3 ) - Listar todos os cargos            *");
            System.out.println("*  ( 4 ) - Remover cargo(s)                  *");
            System.out.println("*  ( 0 ) - Voltar ao menu principal          *");
            System.out.println("**********************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (3)  (4)  (0)");
            switch (scan.nextInt()) {
                case 0:
                    menuPrincipal();
                    op = 1;
                    break;
                case 1:
                    cadastrarCargo();
                    break;
                case 2:
                    editarUsuario();
                    break;
                case 3:
                    listarCargos();
                    break;
                case 4:
                    removerCargo();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }

    private void cadastrarCargo() {
        String nomeCargo;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o nome do cargo: ");
        nomeCargo = new Helper().ucFirst(scanner.nextLine());
        Cargo cargo = new Cargo(nomeCargo);
        this.empresa.inserirCargo(cargo);
        this.listarCargos();
    }

    private void listarCargos() {
        List<Cargo> cargos = this.empresa.getListaCargo();
        System.out.println("----------------------------------------------");
        System.out.println("|              Lista de Cargos               |");
        System.out.println("----------------------------------------------");
        for (Cargo cargo : cargos) {
            System.out.println("      " + (cargos.indexOf(cargo) + 1) + " - " + cargo.toString());
        }
        System.out.println("|--------------------------------------------|");
    }

    private void removerCargo() {

    }

    private void editarCargo() {
    }

    /**
     * Método para retornar nome do cargo de acordo com a posição na lista de cargos
     *
     * @param position
     * @return nomeCargo
     */
    private String selecionarCargo(int position) {
        Cargo cargo = this.empresa.getListaCargo().get(position);
        return cargo.getNomeCargo();
    }

    //================= GERENCIAR PERFIL ===============//
    private void gerenciarPerfil() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while (op == 0) {
            System.out.println("**********************************************");
            System.out.println("*         3 - GERENCIAR PERFIL               *");
            System.out.println("*--------------------------------------------*");
            System.out.println("*  ( 1 ) - Cadastrar novo PERFIL             *");
            System.out.println("*  ( 2 ) - Edita perfil                      *");
            System.out.println("*  ( 3 ) - Listar todos os perfis            *");
            System.out.println("*  ( 4 ) - Remover perfil(s)                 *");
            System.out.println("*  ( 0 ) - Voltar ao menu principal          *");
            System.out.println("**********************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (3)  (4)  (0)");
            switch (scan.nextInt()) {
                case 0:
                    menuPrincipal();
                    op = 1;
                    break;
                case 1:
                    cadastrarCargo();
                    break;
                case 2:
                    removerCargo();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }

    private static void cadastrarPerfil() {
    }


    //================= MENU PRINCIPAL ===============//
    private void menuPrincipal() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        System.out.println("#############################################");
        System.out.println("##              MENU PRINCIPAL             ##");
        System.out.println("#############################################");
        System.out.println("##  ( 1 ) - Gerenciar Usuarios             ##");
        System.out.println("##  ( 2 ) - Gerenciar Cargos               ##");
        System.out.println("##  ( 3 ) - Gerenciar Perfis de Usuário    ##");
        System.out.println("##  ( 0 ) - Sair/Cancelar                  ##");
        System.out.println("#############################################");
        System.out.println("Escolha uma opção(?):  (1)  (2)  (3)  (0)");

        while (op == 0) {
            switch (scan.nextInt()) {
                case 0:
                    System.out.println("Programa encerrado!!");
                    op = 1;
                    scan.close();
                    break;
                case 1:
                    if (this.empresa.getListaCargo().isEmpty()) {
                        System.out.println("\n\t\t\t +----------    ATENÇÃO     ----------+\n" +
                                "\t\t\t +------------------------------------+\n" +
                                "\t\t\t | Antes de cadastrar um usuário(s)   |\n" +
                                "\t\t\t | é preciso inserir ao menos um(01)  |\n" +
                                "\t\t\t | CARGO(s) e um(01) tipo(s) de       |\n" +
                                "\t\t\t | PERFIL(s) para usuário(s)          |\n" +
                                "\t\t\t +------------------------------------+\n");
                        menuPrincipal();
                    } else {
                        gerenciarUsuario();
                    }
                    break;
                case 2:
                    gerenciarCargo();
                    break;
                case 3:
                    gerenciarPerfil();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }

    void run() {
        this.menuPrincipal();
    }
}
