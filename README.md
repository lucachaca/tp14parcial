# 🖥️ Escáner de Red - Proyecto de Redes

## 📚 Introducción

Este proyecto fue desarrollado como trabajo práctico para la materia **Redes** del 5to año.  
El objetivo es crear una aplicación que permita escanear un rango de direcciones IP dentro de una red local para saber qué dispositivos están activos.

La aplicación fue desarrollada en **Java**, utilizando el entorno de desarrollo **Eclipse IDE** y componentes básicos de interfaz gráfica con **Swing**.

---

## 🚀 Funcionalidades del proyecto

- Ingreso de IP de inicio y fin para definir el rango
- Escaneo de cada IP con `ping` para ver si responde
- Tabla de resultados con:
  - Dirección IP
  - Si está activo o no
  - Tiempo de respuesta (ping)
  - Nombre del host (si se puede obtener)
- Barra de progreso
- Validación de las IP ingresadas
- Posibilidad de limpiar la tabla
- Interfaz clara, simple y funcional

---

## ⚙️ Requisitos

Antes de ejecutar el programa, necesitás:

- Tener instalado **Java JDK 8 o superior**
- Tener **Eclipse IDE** o cualquier editor de Java (VSCode, NetBeans, IntelliJ, etc.)
- Conexión de red local activa

---

## 🛠️ ¿Cómo usar el proyecto? (Paso a paso)

1. **Cloná o descargá este repositorio**
   - Si usás Git:
     ```bash
     git clone https://github.com/tuusuario/tu-repo-escaner.git
     ```
   - O descargalo como `.ZIP` y descomprimilo

2. **Abrí Eclipse**
   - Seleccioná `File > Import > Existing Projects into Workspace`
   - Buscá la carpeta del proyecto y hacé clic en `Finish`

3. **Verificá que el archivo `EscanerRed.java` esté en la carpeta correcta:**
   - `src/escaner/EscanerRed.java`

4. **Ejecutá el proyecto**
   - Clic derecho sobre `EscanerRed.java`
   - Seleccioná: `Run As > Java Application`

5. **Usá la aplicación**
   - Ingresá una IP de inicio y una IP final
     - Ejemplo: `192.168.0.1` a `192.168.0.10`
   - Hacé clic en “Escanear”
   - Observá los resultados en la tabla

6. **Limpiá la tabla si querés volver a empezar**
   - Hacé clic en el botón “Limpiar”

---

## 🧠 Notas finales

Este proyecto fue realizado con conocimientos básicos de Java, respetando el nivel de secundaria.  
Es una herramienta útil para aprender cómo funcionan los protocolos de red como **ICMP (ping)** y la lógica de programación de aplicaciones con interfaz gráfica.

---

## 👨‍💻 Autor

- Nombre: Luca Bustamante
- Escuela: E.T. N.º 36 - 5to 1ra
- Año: 2025
