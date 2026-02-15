# Conceitos Avançados de Java

## Anotações (Annotations)

### Lombok Annotations
O projeto utiliza **Lombok** para reduzir código repetitivo:
- `@Data`: Gera getters, setters, toString, equals, hashCode
- `@Getter` / `@Setter`: Gera apenas getters e setters
- `@NoArgsConstructor`: Construtor sem argumentos
- `@AllArgsConstructor`: Construtor com todos os argumentos
- `@Builder`: Pattern Builder para construção de objetos

### MapStruct
O projeto integra **MapStruct** para mapeamento entre DTOs e Entities:
- Conversão automática de tipos
- Configuração de campos customizados
- Loose coupling entre camadas

## Design Patterns

### 1. Builder Pattern
Utilize o Lombok para implementar o padrão Builder automáticamente.

### 2. Data Transfer Objects (DTOs)
Separação entre modelos internos e API responses.

### 3. Dependency Injection
Boas práticas para injeção de dependências.

## Boas Práticas

- Utilize conventions over configuration
- Mantenha classes imutáveis quando possível
- Aplique SOLID principles
- Documente com Javadoc