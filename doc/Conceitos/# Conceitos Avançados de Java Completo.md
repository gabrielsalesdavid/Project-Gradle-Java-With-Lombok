# Conceitos Avançados de Java

## Anotações (Annotations)

As anotações fornecem metadados sobre o código. Seu projeto utiliza duas bibliotecas principais:

### Lombok Annotations

Lombok reduz código boilerplate com processamento de anotações em tempo de compilação:

#### @Data
Combina `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode` e `@RequiredArgsConstructor`:
```java
@Data
public class Usuario {
    private Long id;
    private String nome;
    private String email;
}
// Gera automaticamente: getters, setters, toString, equals, hashCode
```

#### @Getter / @Setter
```java
@Getter
@Setter
public class Produto {
    private String descricao;
    private BigDecimal preco;
}
```

#### @NoArgsConstructor
Construtor sem argumentos:
```java
@NoArgsConstructor
public class Categoria {
    private Long id;
}
```

#### @AllArgsConstructor
Construtor com todos os argumentos:
```java
@AllArgsConstructor
public class Tag {
    private String nome;
    private String descricao;
}
```

#### @RequiredArgsConstructor
Construtor com argumentos final/non-null:
```java
@RequiredArgsConstructor
public class Configuracao {
    private final String chave;
    private String valor;
}
```

#### @Builder
Implementa o padrão Builder:
```java
@Builder
public class Usuario {
    private String nome;
    private String email;
    private int idade;
}

// Uso:
Usuario usuario = Usuario.builder()
    .nome("João")
    .email("joao@example.com")
    .idade(30)
    .build();
```

#### @ToString
```java
@ToString
public class Pedido {
    private Long id;
    private LocalDateTime data;
}
```

#### @EqualsAndHashCode
```java
@EqualsAndHashCode
public class Cliente {
    private Long id;
    private String cpf;
}
```

### MapStruct

MapStruct é um framework para geração de implementações de mapeadores entre tipos Java.

#### Criando um Mapper
```java
@Mapper
public interface UsuarioMapper {
    UsuarioDTO toDTO(Usuario usuario);
    Usuario toEntity(UsuarioDTO usuarioDTO);
    List<UsuarioDTO> toDTOList(List<Usuario> usuarios);
}
```

#### Mapeamento Customizado
```java
@Mapper
public interface ProdutoMapper {
    @Mapping(source = "nome", target = "descricao")
    @Mapping(target = "ativo", constant = "true")
    ProdutoDTO toDTO(Produto produto);
}
```

#### Tipos de Mapping
- **Direct**: Campo com mesmo nome
- **@Mapping**: Configuração customizada
- **@Mappings**: Múltiplos mapeamentos
- **@ValueMapping**: Para enums

## Design Patterns Utilizados

### 1. Builder Pattern
Implementado automaticamente pelo Lombok `@Builder`:
```java
Objeto obj = novo ObjetoBuilder()
    .campo1("valor1")
    .campo2("valor2")
    .build();
```

### 2. Data Transfer Object (DTO)
Separação entre modelos internos e API:
```java
// Entity - Banco de dados
@Entity
@Data
public class Usuario {
    @Id
    private Long id;
}

// DTO - API Response
@Data
public class UsuarioDTO {
    private Long id;
}
```

### 3. Repository Pattern
Abstração de acesso a dados.

### 4. Dependency Injection
Injeção de dependências para desacoplamento.

## Princípios SOLID

### S - Single Responsibility
Uma classe deve ter apenas uma razão para mudar.

### O - Open/Closed
Aberta para extensão, fechada para modificação.

### L - Liskov Substitution
Subclasses podem substituir suas superclasses.

### I - Interface Segregation
Clientes não devem depender de interfaces que não usam.

### D - Dependency Inversion
Dependa de abstrações, não de implementações concretas.

## Imutabilidade

Criação de objetos imutáveis com Lombok:
```java
@Value
public class ImovelDTO {
    Long id;
    String endereco;
    BigDecimal preco;
}
```

## Documentação com Javadoc

```java
/**
 * Calcula o total de uma compra aplicando desconto.
 *
 * @param valor O valor base da compra
 * @param desconto O percentual de desconto (0-100)
 * @return O valor final após aplicar o desconto
 * @throws IllegalArgumentException se o desconto for inválido
 */
public BigDecimal calcularTotal(BigDecimal valor, int desconto) {
    // implementação
}
```

## Generics

Tipos parametrizados para maior segurança:
```java
public class Repositorio<T> {
    public void salvar(T entidade) { }
    public T buscar(Long id) { }
    public List<T> listar() { }
}
```

## Lambdas e Streams

Programação funcional:
```java
List<String> nomes = usuarios.stream()
    .map(Usuario::getNome)
    .filter(nome -> nome.startsWith("A"))
    .collect(Collectors.toList());
```