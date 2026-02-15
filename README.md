# Project Gradle Java With Lombok

[![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=java)](https://www.java.com)
[![Gradle](https://img.shields.io/badge/Gradle-8.0%2B-02303A?logo=gradle)](https://gradle.org)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.30-red)](https://projectlombok.org)
[![MapStruct](https://img.shields.io/badge/MapStruct-1.5.5-blue)](https://mapstruct.org)
[![License](https://img.shields.io/badge/License-MIT-green)](LICENSE)

> Um projeto educacional de referência para desenvolvimento Java com Gradle, demonstrando as melhores práticas de uso de Lombok, MapStruct e Gradle.

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Instalação](#instalação)
- [Como Usar](#como-usar)
- [Documentação](#documentação)
- [Exemplos de Código](#exemplos-de-código)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## 🎯 Sobre o Projeto

Este projeto foi desenvolvido como material de estudo e referência para a **Formação Java** oferecida pela **DIO.me**. Demonstra:

- ✅ Configuração profissional de projetos Java com Gradle
- ✅ Integração e uso prático de Lombok para reduzir boilerplate
- ✅ Mapeamento entre tipos com MapStruct
- ✅ Aplicação de Design Patterns e princípios SOLID
- ✅ Boas práticas de desenvolvimento orientado a objetos
- ✅ Verificação de qualidade de código com Checkstyle
- ✅ Estruturação modular com Gradle

## 🛠️ Tecnologias Utilizadas

### Linguagens
- **Java 11+**: Linguagem de programação principal

### Ferramentas de Build
- **Gradle 8.0+**: Automação de build e dependências
- **Gradle Wrapper**: Garantia de consistência entre ambientes

### Bibliotecas
- **Lombok 1.18.30**: Redução de código boilerplate
  - `@Data`: Gera getters, setters, toString, equals, hashCode
  - `@Builder`: Padrão Builder automático
  - `@NoArgsConstructor / @AllArgsConstructor`: Construtores automáticos
  - `@Getter / @Setter`: Acessores automáticos

- **MapStruct 1.5.5**: Mapeamento entre tipos
  - Mappers type-safe
  - Zero performance overhead
  - Integração com Lombok

### Verificação de Qualidade
- **Checkstyle**: Verificação de padrões de código
- **Google Checkstyle Config**: Regras de estilo seguindo Google Java Style Guide

## 📁 Estrutura do Projeto

```
Project-Gradle-Java-With-Lombok/
├── README.md                           # Este arquivo
├── build.gradle                        # Configuração do build principal
├── settings.gradle                     # Configurações do projeto
├── gradle.properties                   # Propriedades do Gradle
├── gradlew                             # Gradle Wrapper (Linux/Mac)
├── gradlew.bat                         # Gradle Wrapper (Windows)
├── gradle/
│   ├── wrapper/
│   │   ├── gradle-wrapper.jar         # JAR do Wrapper
│   │   └── gradle-wrapper.properties   # Propriedades do Wrapper
│   └── libs.versions.toml              # Catálogo de versões centralizado
├── config/
│   └── checkstyle/
│       └── checkstyle.xml              # Configuração de estilo de código
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/projectgradlejavawithlombok/
│   │   │       ├── model/              # Modelos/Entities
│   │   │       ├── dto/                # Data Transfer Objects
│   │   │       ├── mapper/             # Mapeadores (MapStruct)
│   │   │       ├── util/               # Utilitários
│   │   │       └── Main.java           # Classe principal
│   │   └── resources/
│   │       └── application.properties  # Configurações da aplicação
│   ├── test/
│   │   ├── java/                       # Testes unitários
│   │   └── resources/                  # Recursos para testes
├── docs/
│   ├── Fundamentos/
│   │   ├── Java-Fundamentos.md         # Conceitos básicos de Java
│   │   └── Gradle-Fundamentos.md       # Conceitos básicos de Gradle
│   └── Conceitos/
│       ├── Java-Conceitos.md           # Conceitos avançados de Java
│       └── Gradle-Conceitos.md         # Conceitos avançados de Gradle
└── .gitignore                          # Arquivos ignorados pelo Git
```

## 🚀 Instalação

### Pré-requisitos

- **Java Development Kit (JDK) 11+**
  ```bash
  java -version
  ```
- **Git** (opcional, para clonar o repositório)
  ```bash
  git --version
  ```

### Clonar o Repositório

```bash
git clone https://github.com/gabrielsalesdavid/Project-Gradle-Java-With-Lombok.git
cd Project-Gradle-Java-With-Lombok
```

### (Alternativa) Download do ZIP

Faça download direto do repositório em: [GitHub](https://github.com/gabrielsalesdavid/Project-Gradle-Java-With-Lombok)

## 💻 Como Usar

### Compilar o Projeto

Usando o Gradle Wrapper (recomendado):

**Linux/Mac:**
```bash
./gradlew build
```

**Windows:**
```bash
gradlew.bat build
```

Ou, se tiver Gradle instalado globalmente:
```bash
gradle build
```

### Tarefas Disponíveis

```bash
# Limpeza
./gradlew clean

# Compilação
./gradlew compileJava

# Testes
./gradlew test

# Verificação de Qualidade
./gradlew checkstyleMain
./gradlew checkstyleTest

# Build Completo
./gradlew build

# Executar Main
./gradlew run

# Gerar Relatório Checkstyle
./gradlew checkstyleMain --scan
```

### Verificar Relatórios

Após executar `./gradlew build`, verifique:

- **Testes**: `build/reports/tests/test/index.html`
- **Checkstyle**: `build/reports/checkstyle/`

## 📚 Documentação

Este projeto inclui documentação completa dividida em:

### Fundamentos
- **[Java - Fundamentos](docs/Fundamentos/Java-Fundamentos.md)**
  - Tipos de dados
  - Orientação a Objetos
  - Estruturas de controle
  - Coleções
  - Pacotes e modificadores

- **[Gradle - Fundamentos](docs/Fundamentos/Gradle-Fundamentos.md)**
  - Estrutura do projeto
  - Build.gradle
  - Gradle Wrapper
  - Tasks padrão
  - Dependências

### Conceitos Avançados
- **[Java - Conceitos](docs/Conceitos/Java-Conceitos.md)**
  - Anotações (Lombok, MapStruct)
  - Design Patterns
  - Princípios SOLID
  - Imutabilidade
  - Generics e Lambdas

- **[Gradle - Conceitos](docs/Conceitos/Gradle-Conceitos.md)**
  - Build Cache
  - Multi-project builds
  - Annotation Processing
  - Checkstyle Integration
  - Custom Tasks
  - Performance

## 💡 Exemplos de Código

### Exemplo 1: Usando Lombok @Data

```java
import lombok.Data;

@Data
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    
    // Lombok gera automaticamente:
    // - Getters e Setters
    // - toString()
    // - equals() e hashCode()
    // - Construtor com argumentos de final fields
}
```

Uso:
```java
Usuario usuario = new Usuario();
usuario.setNome("João Silva");
usuario.setEmail("joao@example.com");
System.out.println(usuario);  // Usa toString() gerado
```

### Exemplo 2: Usando Lombok @Builder

```java
import lombok.Builder;

@Builder
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
}
```

Uso:
```java
Produto produto = Produto.builder()
    .id(1L)
    .nome("Notebook")
    .preco(BigDecimal.valueOf(3500.00))
    .descricao("Notebook de 15 polegadas")
    .build();
```

### Exemplo 3: Usando MapStruct

**Entity:**
```java
@Entity
@Data
public class Categoria {
    @Id
    private Long id;
    private String nome;
}
```

**DTO:**
```java
@Data
public class CategoriaDTO {
    private Long id;
    private String nome;
}
```

**Mapper:**
```java
@Mapper
public interface CategoriaMapper {
    CategoriaDTO toDTO(Categoria categoria);
    Categoria toEntity(CategoriaDTO dto);
    List<CategoriaDTO> toDTOList(List<Categoria> categorias);
}
```

**Uso:**
```java
// Injetar ou obter o mapper
CategoriaMapper mapper = Mappers.getMapper(CategoriaMapper.class);

// Usar
Categoria categoria = new Categoria();
categoria.setId(1L);
categoria.setNome("Eletrônicos");

CategoriaDTO dto = mapper.toDTO(categoria);
```

### Exemplo 4: Combinando Lombok + MapStruct

```java
@Mapper
public interface ProdutoMapper {
    @Mapping(source = "nome", target = "titulo")
    @Mapping(target = "ativo", constant = "true")
    ProdutoDTO toDTO(Produto produto);
    
    @InheritInverseConfiguration
    Produto toEntity(ProdutoDTO dto);
}
```

## 🔧 Configuração do Projeto

### Build.gradle Principal

```gradle
plugins {
    id("java")
    checkstyle
}

group = "br.com.projectgradlejavawithlombok"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:${lombokVersion}")
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
}
```

### Gradle Properties

```properties
# Versões principais
lombokVersion=1.18.30
mapstructVersion=1.5.5

# Configurações do Gradle
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.jvmargs=-Xmx2g
```

## 🧪 Testes

Estrutura recomendada para testes:

```
src/test/java/br/com/projectgradlejavawithlombok/
├── model/
├── mapper/
└── util/
```

Executar testes:
```bash
./gradlew test
```

## 📊 Verificação de Qualidade

### Checkstyle

Verificar padrões de código:

```bash
./gradlew checkstyleMain
./gradlew checkstyleTest
```

Configuração em: `config/checkstyle/checkstyle.xml`

## 🔄 Atualizações do Repositório

### Última Atualização: 15 de fevereiro de 2026

Mudanças recentes:

- ✅ Documentação completa de Fundamentos (Java e Gradle)
- ✅ Documentação de Conceitos Avançados (Java e Gradle)
- ✅ README.md com exemplos práticos
- ✅ Estrutura de projeto bem organizada
- ✅ Configuração de Checkstyle integrada
- ✅ Gradle Wrapper configurado
- ✅ Catálogo de versões centralizado

### Versão Atual

```
Version: 1.0-SNAPSHOT
Java Target: 11+
Gradle: 8.0+
Lombok: 1.18.30
MapStruct: 1.5.5
```

## 🤝 Contribuindo

Este é um projeto educacional. Para contribuir:

1. Faça um Fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -am 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está licenciado sob a [MIT License](LICENSE) - veja o arquivo LICENSE para detalhes.

## 📞 Contato

- **Autor**: Gabriel Sales David
- **GitHub**: [@gabrielsalesdavid](https://github.com/gabrielsalesdavid)
- **Formação**: Tecnologia - Formação Java | DIO.me

## 🎓 Recursos de Aprendizado

### Documentação Oficial
- [Java Documentation](https://docs.oracle.com/javase/)
- [Gradle User Manual](https://docs.gradle.org/)
- [Lombok Features](https://projectlombok.org/features/all)
- [MapStruct Reference Guide](https://mapstruct.org/documentation/stable/reference/html/)

### Artigos e Tutoriais
- [Clean Code in Java](https://www.baeldung.com/cs/clean-code)
- [SOLID Principles](https://www.baeldung.com/solid-principles)
- [Design Patterns in Java](https://www.baeldung.com/design-patterns-in-java)

## 📌 Roadmap Futuro

- [ ] Adicionar Spring Framework
- [ ] Integrar Spring Data JPA
- [ ] Implementar testes com JUnit 5
- [ ] Adicionar exemplos de REST API
- [ ] Documentação em vídeo
- [ ] Mais exemplos práticos

---

**⭐ Se este projeto foi útil, considere deixar uma estrela!**

Desenvolvido com ❤️ para a comunidade de desenvolvimento Java