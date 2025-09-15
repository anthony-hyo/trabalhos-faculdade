from typing import Callable

class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    MAGENTA = "\033[35m"
    DANGER = "\033[97;41m"
    ALERT = "\033[30;43m"

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

def calc_discount(quantidade: int) -> float | None:
    """Retorna a taxa de juros de acordo com a quantidade de camisetas

    :param quantidade: Quantidade de camisetas

    :return: float | None
    """
    if quantidade < 20:
        return 0.00
    elif 20 <= quantidade < 200:
        return .05
    elif 200 <= quantidade < 2000:
        return .07
    elif 2000 <= quantidade <= 20000:
        return .12
    else:
        return None

camisetas: dict = {
    "MCS": {
        "Nome": "Manga Curta Simples",
        "Preço": 1.80
    },
    "MLS": {
        "Nome": "Manga Longa Simples",
        "Preço": 2.10
    },
    "MCE": {
        "Nome": "Manga Curta Com Estampa",
        "Preço": 2.90
    },
    "MLE": {
        "Nome": "Manga Longa Com Estampa",
        "Preço": 3.20
    }
}

fretes: dict = {
    1: {
        "Nome": "Frete por transportadora",
        "Preço": 100.00
    },
    2: {
        "Nome": "Frete por Sedex",
        "Preço": 200.00
    },
    0: {
        "Nome": "Retirar pedido na fábrica",
        "Preço": 0.00
    }
}

beautiful_io(print, "Bem-vindo a fábrica de camisetas do Anthony De Sousa Fidelis!", bold=True)

def escolha_modelo() -> str:
    modelos_str: str = ""

    for key, camiseta in camisetas.items():
        modelos_str += f"\n{Style.MAGENTA}{key} - {camiseta['Nome']}{Style.RESET}"

    return beautiful_io(input, f"Entre com o modelo desejado: {modelos_str}\n>> ", Style.BLUE, validar_acao=lambda s: s.upper() not in camisetas, validar_mensagem="Escolha inválida, entre com o modelo novamente.").upper()

def num_camisetas() -> int:
    return beautiful_io(input, f"Entre com o número de camisetas: \n>> ", Style.BLUE, validar_acao=lambda s: s >= 20000, validar_mensagem="Não aceitamos tantas camisetas de uma vez.\nPor favor, entre com o número de camisetas novamente.", conversor=int, conversor_mensagem="Quantidade de camisetas é invalida! digite apenas numeros.")


def frete() -> float:
    frete_str: str = ""

    for key, frete in fretes.items():
        frete_str += f"\n{Style.MAGENTA}{key} - {frete['Nome']} - R$ {frete['Preço']:.2f}{Style.RESET}"

    frete_key = beautiful_io(input, f"Escolha o tipo de frete: {frete_str}\n>> ", Style.BLUE, validar_acao=lambda s: s not in fretes, validar_mensagem="Escolha inválida, selecione o frete novamente.", conversor=int, conversor_mensagem="Quantidade de camisetas é invalida! digite apenas numeros.")

    return fretes[frete_key]['Preço']

modelo: str = escolha_modelo()
quantidade: int = num_camisetas()
frete: float = frete()

quantidade_com_desconto = quantidade * (1 - calc_discount(quantidade))
total = camisetas[modelo]['Preço'] * quantidade_com_desconto + frete

beautiful_io(print, f"Total: R$ {total:.2f} (Modelo: {camisetas[modelo]['Preço']} * Quantidade(com desconto): {int(quantidade_com_desconto)} + frete: {frete:.2f})", Style.BLUE)

