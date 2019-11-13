import java.util.*;

class Interface {

    private Empresa empresa;

    Interface() {
        this.empresa = new Empresa();
    }

    //================= GERENCIAR USUARIO ==============//
    private void gerenciarUsuario() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao == 0) {
            System.out.println("\n**********************************************");
            System.out.println("*           1 - GERENCIAR USUÁRIO            *");
            System.out.println("*--------------------------------------------*");
            System.out.println("*  ( 1 ) - Cadastrar novo usuário            *");
            System.out.println("*  ( 2 ) - Editar usuário                    *");
            System.out.println("*  ( 3 ) - Listar todos os usuários          *");
            System.out.println("*  ( 4 ) - Remover usuário(s)                *");
            System.out.println("*  ( 0 ) - Voltar ao menu principal          *");
            System.out.println("**********************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (3)  (4)  (0)\n");

            switch (scanner.nextInt()) {
                case 0:
                    menuPrincipal();
                    opcao = 1;
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
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        while (opcao == 0) {
            System.out.println("*--------------------------------------------*");
            System.out.println("*  1 - Pessoa Física                         *");
            System.out.println("*  2 - Pessoa Jurídica                       *");
            System.out.println("*  0 - Voltar                                *");
            System.out.println("**********************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (0)\n");
            switch (scanner.nextInt()) {
                case 0:
                    gerenciarUsuario();
                    opcao = 1;
                    break;
                case 1:
                    cadastrarPessoaFisica();
                    break;
                case 2:
                    cadastrarPessoaJuridica();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }

    private void cadastrarPessoaFisica() {
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
        this.listarCargos();
        System.out.println("Selecione o cargo pretendido: ( ? )");

        int position = scanner.nextInt();
        cargo = selecionarCargo(position);

        Usuario usuario = new Usuario(new PessoaFisica(nome, cpf, dataNascimento, sexo, cargo));
        if (this.empresa.inserirUsuario(usuario)) {
            this.listarUsuarios();
            System.out.println("Usuário inserido com SUCESSO!!!");
        } else {
            System.out.println("Erro: Usuário NÃO INSERIDO!!!");
        }
    }

    private void cadastrarPessoaJuridica() {
        String razaoSocial, cnpj, dataAbertura, email;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o nome: ");
        razaoSocial = scanner.nextLine();
        System.out.println("Digite o cnpj: ");
        cnpj = scanner.nextLine();
        System.out.println("Digite a data de abertura: ");
        dataAbertura = scanner.nextLine();
        System.out.println("Digite o email: ");
        email = scanner.nextLine();

        Usuario usuario = new Usuario(new PessoaJuridica(razaoSocial, cnpj, dataAbertura, email));
        if (this.empresa.inserirUsuario(usuario)) {
            System.out.println("Usuário inserido com SUCESSO!!!");
        } else {
            System.out.println("Erro: Usuário NÃO INSERIDO!!!");
        }
    }

    private void removerUsuario() {
        String cpf;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o CPF do usuário que deseja remover: ");
        cpf = scanner.nextLine();
        if (this.empresa.removerUsuario(cpf)) {
            System.out.println("Usuário removido com SUCESSO!!!");
            this.listarUsuarios();
        } else {
            System.out.println("Erro: Usuário NÃO REMOVIDO!!!");
        }
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = this.empresa.getListaUsuario();
        if (!usuarios.isEmpty()){
            for (Usuario user : usuarios) {
                if (user.getPf() != null) {
                    System.out.println(user.getPf() + "\n");
                } else {
                    System.out.println(user.getPj() + "\n");
                }
            }
        }else{
            System.out.println("Nenhum usuário cadastrado!");
        }
    }

    private void editarUsuario() {

    }

    //================= GERENCIAR CARGO ===============//
    private void gerenciarCargo() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao == 0) {
            System.out.println("\n**********************************************");
            System.out.println("*           2 - GERENCIAR CARGO              *");
            System.out.println("*--------------------------------------------*");
            System.out.println("*  ( 1 ) - Cadastrar novo cargo              *");
            System.out.println("*  ( 2 ) - Editar cargo                       *");
            System.out.println("*  ( 3 ) - Listar todos os cargos            *");
            System.out.println("*  ( 4 ) - Remover cargo(s)                  *");
            System.out.println("*  ( 0 ) - Voltar ao menu principal          *");
            System.out.println("**********************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (3)  (4)  (0)\n");
            switch (scanner.nextInt()) {
                case 0:
                    opcao = 1;
                    menuPrincipal();
                    break;
                case 1:
                    cadastrarCargo();
                    break;
                case 2:
                    editarCargo();
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
        nomeCargo = Helper.ucFirst(scanner.nextLine());
        Cargo cargo = new Cargo(nomeCargo);
        this.empresa.inserirCargo(cargo);
        this.listarCargos();
    }

    private void listarCargos() {

        List<Cargo> listaDeCargos = this.empresa.getListaCargo();

        System.out.println("\n----------------------------------------------");
        System.out.println("|              Lista de Cargos               |");
        System.out.println("----------------------------------------------");
        if (listaDeCargos.isEmpty()) {
            System.out.println("\n\t *** Nenhum cargo cadastrado ***\n");
        } else {
            for (Cargo cargo : listaDeCargos) {
                System.out.println("\t\t" + (listaDeCargos.indexOf(cargo) + 1) + " - " + cargo.toString());
            }
        }
        System.out.println("|--------------------------------------------|\n");
    }

    private void removerCargo() {
        Scanner scanner = new Scanner(System.in);

        this.listarCargos();
        System.out.println("Digite o número do cargo que deseja remover: \n");
        if (this.empresa.removerCargo(scanner.nextInt())) {
            System.out.println("Cargo removido com SUCESSO!!!\n");
            this.listarCargos();
        } else {
            System.out.println("Erro: cargo NÃO removido");
        }
    }

    private void editarCargo() {
    }

    /**
     * Retorna o nome do cargo de acordo com a posição na lista de cargos
     *
     * @param position
     * @return nomeCargo
     */
    private String selecionarCargo(int position) {
        Cargo cargo = this.empresa.getListaCargo().get(position - 1);
        return cargo.getNomeCargo();
    }

    //================= GERENCIAR PERFIL ===============//
    private void gerenciarPerfil() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao == 0) {
            System.out.println("\n**********************************************");
            System.out.println("*           3 - GERENCIAR PERFIL               *");
            System.out.println("*----------------------------------------------*");
            System.out.println("*  ( 1 ) - Cadastrar novo perfil               *");
            System.out.println("*  ( 2 ) - Editar perfil                        *");
            System.out.println("*  ( 3 ) - Listar todos os perfis              *");
            System.out.println("*  ( 4 ) - Remover perfil(s)                   *");
            System.out.println("*  ( 0 ) - Voltar ao menu principal            *");
            System.out.println("************************************************");
            System.out.println("Escolha uma opção (?): (1)  (2)  (3)  (4)  (0)\n");
            switch (scanner.nextInt()) {
                case 0:
                    opcao = 1;
                    menuPrincipal();
                    break;
                case 1:
                    cadastrarPerfil();
                    break;
                case 2:
                    editarPerfil();
                    break;
                case 3:
                    listarPerfis();
                    break;
                case 4:
                    removerPerfil();
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }

    private void cadastrarPerfil() {
        String tipoPerfil;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o nome do perfil: ");
        tipoPerfil = Helper.ucFirst(scanner.nextLine());
        Perfil perfil = new Perfil(tipoPerfil);
        if (this.empresa.inserirPerfil(perfil)) {
            System.out.println("Perfil inserido com SUCESSO");
            this.listarPerfis();
        } else {
            System.out.println("Erro: perfil não inserido");
        }
    }

    private void listarPerfis() {
        List<Perfil> perfis = this.empresa.getListaPerfil();
        System.out.println("\n----------------------------------------------");
        System.out.println("|              Lista de Perfis               |");
        System.out.println("----------------------------------------------");
        for (Perfil perfil : perfis) {
            System.out.println("      " + (perfis.indexOf(perfil) + 1) + " - " + perfil.toString());
        }
        System.out.println("|--------------------------------------------|\n\n");
    }

    private void removerPerfil() {
        Scanner scanner = new Scanner(System.in);

        this.listarPerfis();
        System.out.println("Digite o número do cargo que deseja remover: ");
        if (this.empresa.removerPerfil(scanner.nextInt())) {
            System.out.println("Cargo removido com SUCESSO");
            this.listarPerfis();
        } else {
            System.out.println("Erro: cargo não removido");
        }
    }

    private void editarPerfil() {
    }

    //================= MENU PRINCIPAL ===============//
    private void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("#############################################");
        System.out.println("#              MENU PRINCIPAL               #");
        System.out.println("#############################################");
        System.out.println("#  ( 1 ) - Gerenciar Usuarios               #");
        System.out.println("#  ( 2 ) - Gerenciar Cargos                 #");
        System.out.println("#  ( 3 ) - Gerenciar Perfis de Usuário      #");
        System.out.println("#  ( 0 ) - Sair/Cancelar/Finalizar          #");
        System.out.println("+-------------------------------------------+");
        System.out.println("Escolha uma opção(?):  (1)  (2)  (3)  (0)\n");

        while (opcao == 0) {
            switch (scanner.nextInt()) {
                case 0:
                    opcao = 1;
                    System.out.println("Programa encerrado!!");
                    break;
                case 1:
                    if (this.empresa.getListaCargo().isEmpty() || this.empresa.getListaPerfil().isEmpty()) {
                        Helper.clearScreen();
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
