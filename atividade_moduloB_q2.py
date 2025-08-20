class Style:
    RESET = "\033[0m"
    GREEN = "\033[32m"
    BLUE = "\033[34m"
    BOLD = "\033[1m"
    DANGER = "\033[97;41m"
    ALERT = "\033[30;43m"


print(f"{Style.GREEN}Bem-vindo a Loja do {Style.BOLD}Anthony De Sousa Fidelis!{Style.RESET}")

marmitas = {
    'P': {
        'BA': {
            'Nome': 'Bife Acebolado',
            'Preço': 16.00,
        },
        'FF': {
            'Nome': 'Bife Acebolado',
            'Preço': 15.00,
        },
    },
    'M': {
        'BA': {
            'Nome': 'Bife Acebolado',
            'Preço': 18.00,
        },
        'FF': {
            'Nome': 'Bife Acebolado',
            'Preço': 17.00,
        },
    },
    'G': {
        'BA': {
            'Nome': 'Bife Acebolado',
            'Preço': 22.00,
        },
        'FF': {
            'Nome': 'Bife Acebolado',
            'Preço': 21.00,
        },
    },
}

