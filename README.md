# udp-tcp-reader

**PT 🇧🇷**  
Projeto de estudo e teste para fixar conceitos sobre manipulação de protocolos **TCP/UDP** em Java.  
O objetivo é simular a leitura de pacotes recebidos de diferentes dispositivos (por exemplo, rastreadores) e realizar o **parse das mensagens** para um formato estruturado, como JSON, permitindo posterior envio para filas, bancos de dados ou APIs.

**EN 🌎**  
Study and test project to consolidate concepts about handling **TCP/UDP** protocols in Java.  
The goal is to simulate reading packets received from different devices (e.g., trackers) and parsing them into a structured format (such as JSON) for further processing (queues, databases, APIs).

---

## 🚀 Tecnologias utilizadas

- **Java 25**
- **Spring Boot 3.5.6**
- **Maven**
- **Lombok**
- (Opcional futuramente: AWS SDK, Redis, DynamoDB, Feature Toggles)

---

## 🎯 Objetivos do projeto

- Receber e interpretar pacotes via **UDP** e **TCP**.  
- Converter mensagens binárias em estruturas legíveis (**JSON**).  
- Criar **estratégias (Strategy Pattern)** para interpretar diferentes protocolos de fabricantes.  
- Explorar uso de **Feature Toggles** para ativar/desativar comportamentos.  
- Simular integração com **fila de mensagens** ou **API**.

---

## 📂 Estrutura inicial do projeto

```
udp-tcp-reader/
├── src/
│ ├── main/
│ │ ├── java/br/com/gora/udptcpreader/
│ │ │ ├── config
│ │ │ │ ├── FF4JConfig.java
│ │ │ │ ├── WebClientConfig.java
│ │ │ ├── dto
│ │ │ │ ├── DeviceMessageDTO.java
│ │ │ ├── parser/
│ │ │ │ ├── manufacturers/
│ │ │ │ │ ├── Manufacturer.java
│ │ │ │ │ └── ManufacturerAParser.java
│ │ │ │ ├── MessageParser.java
│ │ │ │ ├── ParserFactory .java
│ │ │ │ └── TrackerBParser.java
│ │ │ └── service/
│ │ │ │ │ ├── DataProcessorService.java
│ │ │ │ │ └── GeocodingService.java
│ │ └── resources/
│ │ └── application.yml
│ └── test/
│ └── ...
└── pom.xml
```

---

## 🧠 Próximos passos

1. Implementar servidor UDP simples que receba pacotes e registre logs.  
2. Criar parser binário → JSON para mensagens simuladas.  
3. Adicionar Strategy Pattern para diferentes formatos de fabricante.  
4. Integrar com fila ou banco (mockado inicialmente).  
5. Adicionar Feature Toggle para controlar comportamentos em tempo real.

---

## 💡 Exemplos futuros

- Conversão de coordenadas em **endereço real** usando Google Maps API.  
- Testes com **AWS Kinesis / Firehose**.  
- Armazenamento de logs no **DynamoDB**.  

---

## 🧩 Autor

**Bruno Silva**  
Projeto pessoal de estudos.  

---

## 📜 Licença

Este projeto é apenas para fins educacionais e não possui fins comerciais.

---

