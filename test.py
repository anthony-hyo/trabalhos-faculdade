class Style:
    RESET = "\033[0m"

    # Estilos
    BOLD = "\033[1m"
    UNDERLINE = "\033[4m"
    REVERSED = "\033[7m"

    # Métodos para 256 cores
    @staticmethod
    def fg256(code: int) -> str:
        return f"\033[38;5;{code}m"

    @staticmethod
    def bg256(code: int) -> str:
        return f"\033[48;5;{code}m"


# --------------------------
# 1. Cores básicas (frente + fundo)
# --------------------------
print("=== Cores Básicas ===")
basic = [
    (30, "BLACK"), (31, "RED"), (32, "GREEN"), (33, "YELLOW"),
    (34, "BLUE"), (35, "MAGENTA"), (36, "CYAN"), (37, "WHITE"),
    (90, "BRIGHT_BLACK"), (91, "BRIGHT_RED"), (92, "BRIGHT_GREEN"),
    (93, "BRIGHT_YELLOW"), (94, "BRIGHT_BLUE"),
    (95, "BRIGHT_MAGENTA"), (96, "BRIGHT_CYAN"), (97, "BRIGHT_WHITE")
]

for code, name in basic:
    fg = f"\033[{code}m"
    bg = f"\033[{code+10}m" if code < 90 else f"\033[{code+60}m"
    print(f"{fg}{name:<15}{Style.RESET}   {bg}{name:<15}{Style.RESET}")

print("\n")

# --------------------------
# 2. Estilos
# --------------------------
print("=== Estilos ===")
print(f"{Style.BOLD}Negrito{Style.RESET}")
print(f"{Style.UNDERLINE}Sublinhado{Style.RESET}")
print(f"{Style.REVERSED}Invertido (fg/bg){Style.RESET}")
print("\n")

# --------------------------
# 3. Tabela 256 cores - FG
# --------------------------
print("=== 256 cores (Texto) ===")
for i in range(256):
    print(f"{Style.fg256(i)}{i:3}{Style.RESET}", end=" ")
    if (i + 1) % 16 == 0:
        print()

print("\n")

# --------------------------
# 4. Tabela 256 cores - BG
# --------------------------
print("=== 256 cores (Fundo) ===")
for i in range(256):
    print(f"{Style.bg256(i)} {i:3} {Style.RESET}", end=" ")
    if (i + 1) % 16 == 0:
        print()
