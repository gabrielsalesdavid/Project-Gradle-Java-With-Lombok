# Fundamentos de Gradle

## O que é Gradle?

Gradle é uma ferramenta de automação de build moderna, poderosa e flexível. Combina o melhor do Ant e Maven, oferecendo uma DSL (Domain Specific Language) baseada em Groovy ou Kotlin.

## Características Principais

- **Flexible**: Pode construir qualquer tipo de software
- **Fast**: Incrementalidade e build cache
- **Dependable**: Suporta múltiplas linguagens
- **Scripted**: Oferece APIs para customização

## Estrutura do Projeto

```
project/
├── build.gradle          # Configuração do build
├── settings.gradle       # Configuração do projeto
├── gradlew              # Gradle Wrapper (Linux/Mac)
├── gradlew.bat          # Gradle Wrapper (Windows)
├── gradle/
│   ├── wrapper/
│   │   └── gradle-wrapper.jar
│   └── libs.versions.toml  # Catálogo de versões
└── src/
    ├── main/
    └── test/
```

## Arquivo build.gradle

Configuração principal do build:

### Plugins
```gradle
plugins {
    id("java")           // Suporte para projetos Java
    checkstyle           // Verificação de estilo
    id("application")    // Para aplicações executáveis
}
```

### Identificação do Projeto
```gradle
group = 'br.com.projectgradlejavawithlombok'
version = '1.0-SNAPSHOT'
```

### Repositórios
```gradle
repositories {
    mavenCentral()      // Repositório central Maven
    jcenter()           // JCenter (descontinuado)
    google()            // Google's Maven repository
}
```

### Dependências
```gradle
dependencies {
    implementation()      // Runtime + Compile
    compileOnly()         // Apenas Compile
    runtimeOnly()         // Apenas Runtime
    testImplementation()  // Testes
    annotationProcessor() // Processadores de annotations
}
```

### Versões
```gradle
val mastructVersion = "1.5.5.Final"
val lombokVersion = "1.18.30"
```

## Gradle Wrapper

O Gradle Wrapper garante que todos os desenvolvedores usem a mesma versão do Gradle:

```bash
# Linux/Mac
./gradlew build

# Windows
gradlew.bat build
```

Benefícios:
- Sem necessidade de instalar Gradle
- Consistência entre ambientes
- Atualização centralizada

## Tasks (Tarefas)

As tasks são as unidades de trabalho do Gradle:

### Tasks Padrão do Plugin Java

| Task | Descrição |
|------|-----------|
| `clean` | Remove diretório build |
| `build` | Compila, testa e empacota |
| `compile` | Compila código fonte |
| `test` | Executa testes |
| `check` | Executa verificações |
| `jar` | Cria arquivo JAR |

### Executando Tasks

```bash
gradle build              # Task única
gradle clean build        # Múltiplas tasks
gradle -x test build      # Excluir task
```

## Configuração de Tasks

```gradle
tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = true
        html.required = true
    }
}

tasks.checkstyleMain {
    source = fileTree("src/main/java")
}
```

## Annotation Processors

Processadores executados durante compilação:

```gradle
annotationProcessor("org.projectlombok:lombok:$lombokVersion")
annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
```

## Catálogo de Versões (libs.versions.toml)

Centralização de versões:

```toml
[versions]
lombok = "1.18.30"
mapstruct = "1.5.5.Final"

[libraries]
lombok = { group = "org.projectlombok", name = "lombok", version.ref = "lombok" }
mapstruct = { group = "org.mapstruct", name = "mapstruct", version.ref = "mapstruct" }
```

## Variáveis de Ambiente

```gradle
version = System.getenv('BUILD_VERSION') ?: '1.0-SNAPSHOT'
```

## Settings.gradle

Configuração do projeto raiz:

```gradle
rootProject.name = 'project-gradle-java-with-lombok'

include(':app')         // Incluir subproject
```

## Gradle Properties

No arquivo `gradle.properties`:

```properties
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.jvmargs=-Xmx2g
```

## Build Lifecycle

1. **Initialization**: Configura estrutura do projeto
2. **Configuration**: Executa scripts build.gradle
3. **Execution**: Executa as tasks solicitadas

## Diretórios Padrão

| Diretório | Conteúdo |
|-----------|----------|
| `src/main/java` | Código fonte |
| `src/main/resources` | Recursos (arquivos config, etc) |
| `src/test/java` | Código de testes |
| `src/test/resources` | Recursos de testes |
| `build/` | Artefatos gerados |

## Saída do Build

- `build/classes/java/main/` - Classes compiladas
- `build/libs/` - Arquivos JAR/WAR gerados
- `build/reports/` - Relatórios (testes, checkstyle, etc)