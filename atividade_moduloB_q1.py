class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    BG_RED = "\033[41m"

print(f"{Style.GREEN}Bem-vindo a Loja do {Style.BOLD}Anthony De Sousa Fidelis!{Style.RESET}")

def valid_int(message: str, message_error: str) -> int | bool:
    """Valid an input message return the value in int,
    if not a valid int, return an error message
    """
    try:
        return int(input(Style.BLUE + message + Style.RESET))
    except ValueError:
        print(Style.BG_RED + message_error + Style.RESET)
        return valid_int(message, message_error)

def valid_float(message: str, message_error: str) -> float | bool:
    """Valid an input message return the value in int,
    if not a valid int, return an error message
    """
    try:
        return float(input(Style.BLUE + message + Style.RESET))
    except ValueError:
        print(Style.BG_RED + message_error + Style.RESET)
        return valid_float(message, message_error)

def fees_calc(installments: int) -> float:
    """Return the fees for each installment"""
    if 4 <= installments < 6:
        return .04
    elif 6 <= installments < 9:
        return .08
    elif 9 <= installments < 13:
        return .16
    elif installments >= 13:
        return .32
    else:
        return 0

while True:
    # Solicita o valor do pedido
    value: float = valid_float("Entre com o valor do pedido: ", "Valor do pedido é invalido! digite apenas numeros.")

    # Solicita a quantidade de parcelas
    installments: int = valid_int("Entre com a quantidade de parcelas: ", "Quantidade de parcelas é invalida! digite apenas numeros.")

    # Calcula os juros, valor da parcela e valor total parcelado
    juros = fees_calc(installments)
    valorDaParcela: float = (value * (1 + juros)) / installments
    valorTotalParcelado: float = valorDaParcela * installments

    # Exibe os resultados para o usuário
    print(f"{Style.GREEN}O valor das parcelas é de: R$ {valorDaParcela:.2f}")
    print(f"{Style.GREEN}O valor total parcelado é de: R$ {valorTotalParcelado:.2f}")
    print(f"{Style.RESET}" + ("-" * 80))

    # Exibe cotinuar ou sair
    if input("Deseja realizar outro pedido? (s/n): ").strip().lower() == "n":
        break