def comprar_entrada_normal():
    precio = 5
    print(f"✅ Entrada normal comprada por ${precio}")
    return precio

def comprar_entrada_especial():
    precio_base = 10
    dia = input("Ingrese el día de la semana (jueves, viernes, sábado): ").lower()

    if dia == "jueves":
        precio_base = 8
    elif dia in ["viernes", "sábado"]:
        precio_base = 12

    print(f"🎟 Entrada especial comprada por ${precio_base}")
    return precio_base

def mostrar_estadisticas(normales, especiales, ganancias, asistencia_por_dia):
    total_visitantes = normales + especiales
    print("\n========================================")
    print(" 📊 Estadísticas de la Feria 🎡 ")
    print("========================================")
    print(f"👥 Total de visitantes: {total_visitantes}")
    print(f"🎟 Entradas normales vendidas: {normales}")
    print(f"🎭 Entradas especiales vendidas: {especiales}")
    print(f"💰 Ganancias totales: ${ganancias}")

    print("📅 Asistencia por día:")
    print("Día | Asistencia General | Función Especial")
    print("-------------------------------------------")
    for i in range(len(asistencia_por_dia)):
        print(f"{i + 1:2d} | {asistencia_por_dia[i][0]:18d} | {asistencia_por_dia[i][1]:16d}")

    asistencia_semanal = [[0, 0], [0, 0]]  # Semana 1 y Semana 2

    for i in range(5):  # Días 1-5
        asistencia_semanal[0][0] += asistencia_por_dia[i][0]
        asistencia_semanal[0][1] += asistencia_por_dia[i][1]
    for i in range(5, 10):  # Días 6-10
        asistencia_semanal[1][0] += asistencia_por_dia[i][0]
        asistencia_semanal[1][1] += asistencia_por_dia[i][1]

    print(f"📌 Asistencia primera semana: {sum(asistencia_semanal[0])} (General: {asistencia_semanal[0][0]}, Especial: {asistencia_semanal[0][1]})")
    print(f"📌 Asistencia segunda semana: {sum(asistencia_semanal[1])} (General: {asistencia_semanal[1][0]}, Especial: {asistencia_semanal[1][1]})")

def registrar_asistencia(asistencia_por_dia):
    print("\n========================================")
    print(" 📝 Registro de Asistencia ")
    print("========================================")
    dia = int(input("Ingrese el número de día de la feria (1-10): "))
    
    if dia < 1 or dia > 10:
        print("⚠ Día inválido, intente nuevamente.")
        return

    cantidad = int(input("👥 Ingrese la cantidad de asistentes generales: "))
    funcion_asistencia = int(input("🎭 Ingrese la asistencia a la función especial (2pm - 5pm): "))

    asistencia_por_dia[dia - 1][0] += cantidad
    asistencia_por_dia[dia - 1][1] += funcion_asistencia

    print("✅ Asistencia registrada correctamente.")

def main():
    total_entradas_normales = 0
    total_entradas_especiales = 0
    total_ganancias = 0
    asistencia_por_dia = [[0, 0] for _ in range(10)]  # Matriz de 10 días con 2 columnas

    while True:
        print("\n========================================")
        print("   🎡 Sistema de Gestión de Entradas 🎟 ")
        print("========================================")
        print("1. Comprar entrada normal 🎟")
        print("2. Comprar entrada especial 🎫")
        print("3. Ver estadísticas 📊")
        print("4. Registrar asistencias 📝")
        print("5. Salir 🚪")
        opcion = int(input("Seleccione una opción: "))

        if opcion == 1:
            total_ganancias += comprar_entrada_normal()
            total_entradas_normales += 1
        elif opcion == 2:
            total_ganancias += comprar_entrada_especial()
            total_entradas_especiales += 1
        elif opcion == 3:
            mostrar_estadisticas(total_entradas_normales, total_entradas_especiales, total_ganancias, asistencia_por_dia)
        elif opcion == 4:
            registrar_asistencia(asistencia_por_dia)
        elif opcion == 5:
            print("\n👋 Gracias por usar el sistema. ¡Hasta la próxima!")
            break
        else:
            print("⚠ Opción no válida, intente nuevamente.")

if __name__ == "__main__":
    main()


