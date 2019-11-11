import java.util.ArrayList;
import java.util.Scanner;

class Interface {

    private Empresa empresa;

    Interface() {
        this.empresa = new Empresa();
    }

    //================= INÍCIO USUÁRIO ===============//
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
        System.out.println("\nSelecione o cargo pretendido: ");
        this.listarCargos();

        int pos = scanner.nextInt();
        System.out.println("POSITION: " + pos);
        cargo = selecionarCargo(pos);

        Usuario usuario = new Usuario(nome, cpf, dataNascimento, sexo, cargo);
        this.empresa.inserirUsuario(usuario);
        this.listarUsuarios();
    }

    private String selecionarCargo(int position) {
        Cargo cargo = this.empresa.getListaCargo().get(position);
        return cargo.getNomeCargo();
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

    //================= INÍCIO CARGO ===============//
    private void cadastrarCargo() {
        String nomeCargo;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDigite o nome do cargo: ");
        nomeCargo = ucFirst(scanner.nextLine());
        Cargo cargo = new Cargo(nomeCargo);
        this.empresa.inserirCargo(cargo);
        this.listarCargos();
    }

    private void listarCargos() {
        ArrayList<Cargo> listaCargo = (ArrayList<Cargo>) this.empresa.getListaCargo();
        for (Cargo cargo : this.empresa.getListaCargo()) {
            System.out.println(aux + " - " + cargo.toString());
        }
    }

    private void removerCargo() {

    }

    private void editarCargo() {
    }

    private static void cadastrarPerfil() {
    }

    //================= GERENCIAR USUARIO ==============//
    private void gerenciarUsuario() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while (op == 0) {
            System.out.println("\n 1 - Cadastrar um novo usuário");
            System.out.println(" 2 - Editar usuário");
            System.out.println(" 3 - Listar todos os usuários");
            System.out.println(" 4 - Remover um usuário");
            System.out.println(" 0 - Voltar");
            System.out.println(" Digite o valor da opção desejada: \n");
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

    //================= GERENCIAR CARGO ===============//
    private void gerenciarCargo() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while (op == 0) {
            System.out.println("\n 1 - Cadastrar um novo cargo");
            System.out.println(" 2 - Remover um cargo");
            System.out.println(" 0 - Voltar");
            System.out.println(" Digite o valor da opção desejada: \n");
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

    //================= GERENCIAR PERFIL ===============//
    private void gerenciarPerfil() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        while (op == 0) {
            System.out.println("\n 1 - Cadastrar um novo perfil");
            System.out.println(" 2 - Remover um perfil");
            System.out.println(" Digite o valor da opção desejada: \n");
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

    private void menuPrincipal() {
        Scanner scan = new Scanner(System.in);
        int op = 0;

        System.out.println("\n 1 - Gerenciar Usuarios");
        System.out.println(" 2 - Gerenciar Cargos");
        System.out.println(" 3 - Gerenciar Perfis de Usuário");
        System.out.println(" 0 - Sair\n");
        System.out.println(" Digite o valor da opção desejada: \n");

        while (op == 0) {
            switch (scan.nextInt()) {
                case 0:
                    System.out.println("Programa encerrado!!");
                    op = 1;
                    scan.close();
                    break;
                case 1:
                    gerenciarUsuario();
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

    private String ucFirst(String letter) {
        return letter.substring(0, 1).toUpperCase() + letter.substring(1);
    }

    void run() {
        this.menuPrincipal();
    }
}
