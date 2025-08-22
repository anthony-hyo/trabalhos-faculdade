from typing import Callable

class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    MAGENTA = "\033[35m"
    DANGER = "\033[97;41m"
    ALERT = "\033[30;43m"

menu_principal: dict = {
    1: "Cadastrar Funcionários",
    2: "Consultar Funcionários(s)",
    3: "Remover Funcionário",
    4: "Sair",
}

menu_consulta: dict = {
    1: "Consultar todos os Funcionários",
    2: "Consultar Funcionário por id",
    3: "Consultar Funcionário(s) por setor",
    4: "Retornar",
}

lista_funcionarios: list = []

id_global: int = 5535841

def beautiful_io(acao: Callable, mensagem: str, tipo: str = Style.GREEN, bold: bool = False, validar_acao: Callable = None, validar_mensagem: str = None, conversor: Callable[[str], float | int | str] = str, conversor_mensagem: str = "Erro! Tente novamente.") -> float | int | str | None:
    """Entrada e Saída com validação e estilo

    :param acao: Função input ou print
    :param mensagem: Mensagem exibida para o usuário
    :param tipo: Tipo da mensagem
    :param bold: Retorna a mensagem com estilo bold
    :param validar_acao: Função de validação para entrada inválida
    :param validar_mensagem: Mensagem de validação para entrada inválida
    :param conversor: Função para converter a entrada (str, int ou string)
    :param conversor_mensagem: Mensagem de erro para o conversor

    :return: str | None
    """
    while True:
        try:
            valor = conversor(acao(f"{tipo}{Style.BOLD if bold else ''}{mensagem}{Style.RESET}"))

            # Verifica se é do tipo input
            if acao == input:
                # Verifica se existe validação e executa
                if validar_acao is not None and validar_acao(valor):
                    if validar_mensagem is None:
                        beautiful_io(print, "Inválido! Tente novamente.", Style.ALERT)
                        continue
                    else:
                        beautiful_io(print, validar_mensagem, Style.ALERT)
                        continue

                return valor

            return None
        except ValueError:
            print(f"{Style.DANGER}{conversor_mensagem}{Style.RESET}")

def show_funcionario(funcionario: dict) -> None:
    """ Mostra informaçãoes do funcionário

    :param funcionario: Dictionary com dados do funcionário

    :return: None
    """
    beautiful_io(print, f"Id: {funcionario['id']}", Style.MAGENTA)
    beautiful_io(print, f"Nome: {funcionario['nome']}", Style.MAGENTA)
    beautiful_io(print, f"Setor: {funcionario['setor']}", Style.MAGENTA)
    beautiful_io(print, f"Salário: {funcionario['salario']}", Style.MAGENTA)
    print()


def cadastrar_funcionario(id: int) -> None:
    """ Cadastra um novo funcionário

    :param id: Nova id única do novo funcionário
    """

    # Mostra a id única do funcionário
    beautiful_io(print, f"Id do Funcionário: {id}", Style.BLUE)

    # Solicita nome do funcionário
    nome = beautiful_io(input, "Por favor entre com o nome do Funcionário: ", Style.BLUE)

    # Solicita setor do funcionário
    setor = beautiful_io(input, "Por favor entre com o setor do Funcionário: ", Style.BLUE)

    # Solicita salário do funcionário
    salario = beautiful_io(input, "Por favor entre com o salário do Funcionário: ", Style.BLUE, conversor=float, conversor_mensagem="Por favor digite apenas números")

    # Salva o novo funcionário na lista
    novo: dict = {
        "id": id,
        "nome": nome,
        "setor": setor,
        "salario": salario
    }

    lista_funcionarios.append(novo.copy())

def consultar_funcionarios() -> None:
    """ Mostra menu para consulta dos funcionários

    :return: None
    """
    while True:
        opcao_str: str = ""

        # Gera o menu de consulta
        for key, value in menu_consulta.items():
            opcao_str += f"\n{Style.MAGENTA}{key} - {value}{Style.RESET}"

        beautiful_io(print, f"[{" Menu Consulta Funcionário ".center(30, '-')}]", Style.BLUE)

        # Solicita o opcao de consulta
        opcao: int = beautiful_io(input, f"Escolha a opção desejada: {opcao_str}\n>> ", Style.BLUE, validar_acao=lambda s: s not in menu_consulta, validar_mensagem="Opção inválida.", conversor=int, conversor_mensagem="Por favor digite apenas números")

        match opcao:
            case 1:
                for funcionario in lista_funcionarios:
                    show_funcionario(funcionario)
            case 2:
                id: int = beautiful_io(input, f"Digite a id do funcionário: ", Style.BLUE, validar_acao=lambda s: all(f['id'] != s for f in lista_funcionarios), validar_mensagem="Id inválido", conversor=int, conversor_mensagem="Por favor digite apenas números")

                # Não é necessário verificar se existe, pois beautiful_io já fez a verificação
                show_funcionario(find_funcionario_by_id(id))

            case 3:
                setor: str = beautiful_io(input, f"Digite o setor do(s) funcionário(s): ", Style.BLUE)

                encontrou = False

                for funcionario in lista_funcionarios:
                    if funcionario['setor'].lower() == setor.lower():
                        show_funcionario(funcionario)
                        encontrou = True

                if not encontrou:
                    beautiful_io(print, "Nenhum funcionário encontrado nesse setor.", Style.ALERT)
            case 4:
                return

def find_funcionario_by_id(id: int) -> dict | None:
    """ Procura funcionário de acordo com by e target

    :param id: Id do funcionário a ser retornado

    :return: dict | None
    """

    for funcionario in lista_funcionarios:
        if funcionario['id'] == id:
            return funcionario

    return None

def remover_funcionario() -> None:
    """ Remove um funcionário da lista

    :return: dict | None
    """

    # Solicita id do funcionário a ser removido
    id: int = beautiful_io(input, f"Digite a id do funcionário: ", Style.BLUE, validar_acao=lambda s: all(f['id'] != s for f in lista_funcionarios), validar_mensagem="Id inválido", conversor=int, conversor_mensagem="Por favor digite apenas números")

    # Remove o funcionário da lista
    # Não é necessário verificar se existe, pois beautiful_io já fez a verificação
    lista_funcionarios.remove(find_funcionario_by_id(id))

beautiful_io(print, "Bem-vindo a empresa do Anthony De Sousa Fidelis!", bold=True)

while True:
    opcao_str: str = ""

    # Gera o menu principal
    for key, value in menu_principal.items():
        opcao_str += f"\n{Style.MAGENTA}{key} - {value}{Style.RESET}"

    beautiful_io(print, f"[{" Menu Principal ".center(30, '-')}]", Style.BLUE)

    # Solicita o opcao
    opcao: int = beautiful_io(input, f"Escolha a opção desejada: {opcao_str}\n>> ", Style.BLUE, validar_acao=lambda s: s not in menu_principal, validar_mensagem="Opção inválida.", conversor=int, conversor_mensagem="Por favor digite apenas números")

    match opcao:
        case 1:
            cadastrar_funcionario(id_global)

            id_global += 1
        case 2:
            consultar_funcionarios()
        case 3:
            remover_funcionario()
        case 4:
            break
