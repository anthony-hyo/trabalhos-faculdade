from typing import Callable


class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    MAGENTA = "\033[35m"
    DANGER = "\033[97;41m"
    ALERT = "\033[30;43m"


def beautiful_io(acao: Callable, mensagem: str, tipo: str = Style.GREEN, bold: bool = False, validar_acao: Callable = None, validar_mensagem: str = None) -> str | None:
    """Entrada e Saída com validação e estilo

    :param acao: Função input ou print
    :param mensagem: Mensagem exibida para o usuário
    :param tipo: Tipo da mensagem
    :param bold: Retorna a mensagem com estilo bold
    :param validar_acao: Função de validação para entrada inválida
    :param validar_mensagem: Mensagem de validação para entrada inválida

    :return: str | None
    """
    while True:
        try:
            valor = acao(f"{tipo}{Style.BOLD if bold else ''}{mensagem}{Style.RESET}")

            # Verifica se é do tipo input
            if acao == input:
                # Verifica se existe validação e executa
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

beautiful_io(print, "Bem-vindo a Loja do Anthony De Sousa Fidelis!", bold=True)

print()
beautiful_io(print, "Menu do Cliente:", Style.MAGENTA)
beautiful_io(print, "Sabores disponíveis: BA (Bife Acebolado), FF (Filé de Frango)", Style.MAGENTA)
beautiful_io(print, "Tamanhos disponíveis: P, M, G", Style.MAGENTA)
print()

pedidos = []

while True:
    # Solicita o sabor
    sabor = beautiful_io(
        input,
        "Entre com o sabor desejado (BA/FF): ",
        Style.BLUE,
        validar_acao=lambda s: s.upper() not in marmitas,
        validar_mensagem="Sabor inválido. Tente novamente",
    ).upper()

    # Solicita o tamanho
    tamanho = beautiful_io(
        input,
        "Entre com o tamanho desejado (P/M/G): ",
        Style.BLUE,
        validar_acao=lambda t: t.upper() not in marmitas[sabor],
        validar_mensagem="Tamanho inválido. Tente novamente",
    ).upper()

    # TODO: Substituir por um dicionário ex: marmitas[sabor][tamanho]['Preço']
    if sabor == "BA":
        if tamanho == "P":
            nome = "Bife Acebolado"
            preco = marmitas["BA"]["P"]['Preço']
        elif tamanho == "M":
            nome = "Bife Acebolado"
            preco = marmitas["BA"]["M"]['Preço']
        else:
            nome = "Bife Acebolado"
            preco = marmitas["BA"]["G"]['Preço']
    else:
        if tamanho == "P":
            nome = "Filé de Frango"
            preco = marmitas["FF"]["P"]['Preço']
        elif tamanho == "M":
            nome = "Filé de Frango"
            preco = marmitas["FF"]["M"]['Preço']
        else:
            nome = "Filé de Frango"
            preco = marmitas["FF"]["G"]['Preço']

    # Exibe o pedido
    beautiful_io(print, f"Você pediu um {nome} no tamanho {tamanho} por R$ {preco}", Style.GREEN)

    print()

    pedidos.append({
        'sabor': sabor,
        'preco': preco,
        'Tamanho': tamanho
    })

    resposta = beautiful_io(input, "Deseja pedir mais alguma coisa? (S/N): ", Style.BLUE).upper()

    # Exibe cotinuar ou sair
    match resposta:
        case "S":
            continue
        case "N":
            # Calcula total
            total = sum(pedido["preco"] for pedido in pedidos)

            # Exibe o total a ser pago
            beautiful_io(print, f"O valor total a ser pago: R$ {total:.2f}", Style.ALERT)
            break
