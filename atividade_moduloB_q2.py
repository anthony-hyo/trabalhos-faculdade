from typing import Callable


class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    DANGER = "\033[97;41m"
    ALERT = "\033[30;43m"


def beautiful_io(açao: Callable, mensagem: str, tipo: str = Style.GREEN, bold: bool = False, validar_acao: Callable = None, validar_mensagem: str = None) -> str | None:
    """

    :param açao: Função input ou print
    :param mensagem: Mensagem exibida para o usuário
    :param tipo: Tipo da mensagem
    :param bold:
    :param validar_acao: Função de validação para entrada inválida
    :param validar_mensagem: Mensagem de validação para entrada inválida

    :return: int | float | None
    """
    while True:
        try:
            valor = açao(f"{tipo}{Style.BOLD if bold else ''}{mensagem}{Style.RESET}")

            if açao == input:
                if validar_acao is not None and validar_acao(valor):
                    if validar_mensagem is None:
                        beautiful_io(print, "Inválido! Tente novamente.", Style.ALERT)
                        print()
                        continue
                    else:
                        beautiful_io(print, validar_mensagem, Style.ALERT)
                        print()
                        continue

                return valor

            return None
        except ValueError:
            print(f"{Style.DANGER}Erro! Tente novamente.{Style.RESET}")
            print()


beautiful_io(print, "Bem-vindo a Loja do Anthony De Sousa Fidelis!", bold=True)

marmitas = {
    'BA': {
        'P': {
            'Nome': 'Bife Acebolado',
            'Preço': 16.00,
        },
        'M': {
            'Nome': 'Bife Acebolado',
            'Preço': 18.00,
        },
        'G': {
            'Nome': 'Bife Acebolado',
            'Preço': 22.00,
        },
    },
    'FF': {
        'P': {
            'Nome': 'Filé de Frango',
            'Preço': 15.00,
        },
        'M': {
            'Nome': 'Filé de Frango',
            'Preço': 17.00,
        },
        'G': {
            'Nome': 'Filé de Frango',
            'Preço': 21.00,
        },
    },
}

pedidos = []

while True:
    sabor = beautiful_io(
        input,
        f"Entre com o sabor desejado (BA/FF): ",

        Style.BLUE,

        validar_acao=lambda s: s.upper() not in marmitas,
        validar_mensagem="Sabor inválido! Tente novamente.",
    ).upper()

    tamanho = beautiful_io(
        input,
        "Entre com o tamanho desejado (P/M/G): ",

        Style.BLUE,

        validar_acao=lambda t: t.upper() not in marmitas[sabor],
        validar_mensagem="Tamanho inválido! Tente novamente.",
    ).upper()

    beautiful_io(
        print,
        f"Você pediu um {marmitas[sabor][tamanho]['Nome']} no tamanho {tamanho} por R$ {marmitas[sabor][tamanho]['Preço']}{Style.RESET}",
        Style.GREEN
    )

    print()

    pedidos.append(marmitas[sabor][tamanho])

    # Exibe cotinuar ou sair
    if not input("Deseja realizar outro pedido? (S/N): ").strip().upper() == "S":
        total = sum(pedido["Preço"] for pedido in pedidos)

        beautiful_io(print, f"O valor total a ser pago: R$ {total:.2f}", Style.ALERT)

        break
