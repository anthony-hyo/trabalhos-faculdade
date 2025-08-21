from typing import Callable

class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    DANGER = "\033[97;41m"
    ALERT = "\033[30;43m"

print(f"{Style.GREEN}Bem-vindo a Loja do {Style.BOLD}Anthony De Sousa Fidelis!{Style.RESET}")

def valid_pedido(conversor: Callable[[str], float | int], mensagem: str, erro: str, alert: str) -> int | float | None:
    """Valida a entrada do usuário e retorna um número inteiro ou float

    :param conversor: Função para converter a entrada (int ou float)
    :param mensagem: Mensagem exibida para o usuário
    :param erro: Mensagem de erro para entrada inválida
    :param alert: Mensagem de alerta se o número for menor ou igual a zero

    :return: int | float | None
    """
    while True:
        try:
            valor = conversor(input(Style.BLUE + mensagem + Style.RESET))

            if valor <= 0:
                print(Style.ALERT + alert + Style.RESET)
                continue

            return valor
        except ValueError:
            print(Style.DANGER + erro + Style.RESET)

def fees_calc(parcelas: int) -> float:
    """Retorna a taxa de juros de acordo com a quantidade de parcelas

    :param parcelas: Quantidade de percelas

    :return: float
    """
    if 4 <= parcelas < 6:
        return .04
    elif 6 <= parcelas < 9:
        return .08
    elif 9 <= parcelas < 13:
        return .16
    elif parcelas >= 13:
        return .32
    else:
        return 0

while True:
    # Solicita o valor do pedido
    valor_pedido: float = valid_pedido(float, "Entre com o valor do pedido: ", "Valor do pedido é invalido! digite apenas numeros.", "O valor do pedido deve ser maior que zero!")

    # Solicita a quantidade de parcelas
    quantidade_parcelas: int = valid_pedido(int, "Entre com a quantidade de parcelas: ", "Quantidade de parcelas é invalida! digite apenas numeros.", "A quantidade de parcelas deve ser maior que zero!")

    # Calcula juros e valores
    juros = fees_calc(quantidade_parcelas)
    valor_parcela: float = (valor_pedido * (1 + juros)) / quantidade_parcelas
    valor_total_parcelado: float = valor_parcela * quantidade_parcelas

    # Exibe resultados
    print(f"{Style.GREEN}O valor das parcelas é de: R$ {valor_parcela:.2f}")
    print(f"{Style.GREEN}O valor total parcelado é de: R$ {valor_total_parcelado:.2f}")
    print(f"{Style.RESET}" + ("-" * 80))

    # Exibe cotinuar ou sair
    if input("Deseja realizar outro pedido? (s/n): ").strip().lower() == "n":
        print(f"{Style.GREEN}Obrigado por usar a loja!{Style.RESET}")
        break