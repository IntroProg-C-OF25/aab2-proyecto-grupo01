import sys

def main():
    total_entradas_normales = 0
    total_entradas_especiales = 0
    total_ganancias = 0
    asistencia_por_dia = [[0, 0] for _ in range(10)]
    
    while True:
        print("\n========================================")
        print("   🎡 Sistema de Gestión de Entradas 🎟 ")
        print("========================================")
        print("1. Comprar entrada normal 🎟")
        print("2. Comprar entrada especial 🎫")
        print("3. Ver estadísticas 📊")
        print("4. Registrar asistencias 📝")
        print("5. Salir 🚪")
        
        opcion = input("Seleccione una opción: ")
        
        if opcion == "1":
            entradas, costo = comprar_entrada_normal()
            total_ganancias += costo
            total_entradas_normales += entradas
        elif opcion == "2":
            entradas, costo = comprar_entrada_especial()
            total_ganancias += costo
            total_entradas_especiales += entradas
        elif opcion == "3":
            mostrar_estadisticas(total_entradas_normales, total_entradas_especiales, total_ganancias, asistencia_por_dia)
        elif opcion == "4":
            registrar_asistencia(asistencia_por_dia)
        elif opcion == "5":
            print("\n👋 Gracias por usar el sistema. ¡Hasta la próxima!")
            sys.exit()
        else:
            print("⚠ Opción no válida, intente nuevamente.")

def comprar_entrada_normal():
    precio = 5
    entradas = int(input("¿Cuántas entradas normales desea comprar?🤔: "))
    precio_total = precio * entradas
    print(f"✅ Entradas normales compradas por ${precio_total}")
    return entradas, precio_total

def comprar_entrada_especial():
    precio_base = 10
    dias_validos = {"jueves": 8, "viernes": 12, "sábado": 12}
    
    entradas = int(input("¿Cuántas entradas especiales desea comprar?🤔: "))
    while True:
        dia = input("Ingrese el día de la semana (jueves, viernes, sábado): ").lower()
        if dia in dias_validos:
            precio_base = dias_validos[dia]
            break
        print("Error! solo puede ingresar el día: jueves, viernes y sábado")
    
    precio_total = precio_base * entradas
    print(f"🎟 Entradas especiales compradas por ${precio_total}")
    return entradas, precio_total

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
    for i, (general, especial) in enumerate(asistencia_por_dia, start=1):
        print(f" {i:2d} | {general:18d} | {especial:16d} ")
    
    resumen_semanal = [[sum(x) for x in zip(*asistencia_por_dia[:5])],
                        [sum(x) for x in zip(*asistencia_por_dia[5:])]]
    
    print("\n📊 Resumen de Asistencia por Semana:")
    print("Semana | Asistencia General | Asistencia Especial | Total")
    print("--------------------------------------------------------")
    for i, (general, especial) in enumerate(resumen_semanal, start=1):
        total_semana = general + especial
        print(f"   {i}   | {general:18d} | {especial:19d} | {total_semana:5d}")

def registrar_asistencia(asistencia_por_dia):
    print("\n========================================")
    print(" 📝 Registro de Asistencia ")
    print("========================================")
    
    dia = int(input("Ingrese el número de día de la feria (1-10): "))
    if not (1 <= dia <= 10):
        print("⚠ Día inválido, intente nuevamente.")
        return
    
    general = int(input("👥 Ingrese la cantidad de asistentes generales: "))
    especial = int(input("🎭 Ingrese la asistencia a la función especial (2pm - 5pm): "))
    
    asistencia_por_dia[dia - 1][0] += general
    asistencia_por_dia[dia - 1][1] += especial
    
    print("✅ Asistencia registrada correctamente.")

if __name__ == "__main__":
    main()
