# Servidor de Chat TCP

## Descripción
Este proyecto implementa un servidor de chat TCP en Java que permite la comunicación en tiempo real entre múltiples clientes. El sistema está diseñado siguiendo principios sólidos de arquitectura de software y utiliza varios patrones de diseño para garantizar la mantenibilidad y escalabilidad.

## Características principales
- Sistema de múltiples salas de chat
- Gestión automática de nombres de usuario
- Comunicación en tiempo real a través de sockets TCP
- Procesamiento de mensajes basado en JSON
- Implementación robusta de patrones de diseño

## Arquitectura
El proyecto está estructurado siguiendo varios patrones de diseño:

### Patrones implementados
- **Patrón de Comando**: Para la gestión de acciones de usuario
- **Patrón de Observador**: Para la notificación de mensajes entre usuarios
- **Patrón Singleton**: Para la gestión de instancia única
- **Middleware**: Para el procesamiento y enrutamiento de mensajes

## Estructura del proyecto
src/ ├── command/ # Implementación del patrón de comando
├── entities/ # Entidades del dominio
├── interfaces/ # Interfaces del sistema
├── middleware/ # Capa de middleware
├── rooms/ # Gestión de salas de chat
├── services/ # Servicios utilitarios
└── socket/ # Implementación de socket TCP


## Especificaciones técnicas
- **Protocolo**: TCP/IP
- **Puerto**: 3000
- **Gestión de concurrencia**: CopyOnWriteArrayList
- **Procesamiento de JSON**: Biblioteca GSON
- **Multihilos**: Gestión de hilos en Java

## Acciones del sistema
El sistema implementa las siguientes acciones principales:
- `SEND_MESSAGE`: Envío de mensaje
- `CLOSE_WINDOW`: Cierre de la conexión
- `CREATE_CHAT_ROOM`: Creación de nueva sala
- `CHANGE_CHAT_ROOM`: Cambio entre salas existentes

## Instalación y ejecución
1. Clonar el repositorio
2. Compilar el proyecto
3. Ejecutar Main.java
4. El servidor se iniciará en el puerto 3000
