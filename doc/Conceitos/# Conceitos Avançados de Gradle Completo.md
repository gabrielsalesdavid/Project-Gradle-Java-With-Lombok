# Conceitos Avançados de Gradle

## Build Cache

Reutiliza resultados de tasks anterior executadas:

```gradle
org.gradle.caching=true
```

Benefícios:
- Builds mais rápidos
- Menos compilações desnecessárias
- Funciona entre diferentes máquinas (com certificado)

## Compilação Incremental

Apenas recompila o que mudou:

```gradle
tasks.withType(JavaCompile).configureEach {
    options.incremental = true
}
```

## Parallel Execution

Executa tasks em paralelo:

```bash
gradle build --parallel
```

No `gradle.properties`:
```properties
org.gradle.parallel=true
org.gradle.workers.max=4
```

## Multi-Project Builds

Estruturação de projetos complexos:

```gradle
// settings.gradle
rootProject.name = 'meu-projeto'

include(':core')
include(':api')
include(':cli')
```

### Project Structure
```
projeto/
├── settings.gradle
├── build.gradle (root)
├── core/
│   └── build.gradle
├── api/
│   └── build.gradle
└── cli/
    └── build.gradle
```

### Dependências Entre Projetos
```gradle
// api/build.gradle
dependencies {
    implementation(project(':core'))
}
```

## Annotation Processing

Processadores de anotações executados durante compilação:

### Lombok
```gradle
annotationProcessor("org.projectlombok:lombok:$lombokVersion")
```

Gera código automaticamente para:
- Getters/Setters
- equals/hashCode
- toString
- Builders
- Constructores

### MapStruct
```gradle
annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
```

Gera implementações de mapeadores:
- Conversão entre DTOs e Entities
- Type-safe mapping
- Zero-reflection performance

### Binding Lombok + MapStruct
```gradle
annotationProcessor("org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBinding")
```

Integração para que MapStruct reconheça classes geradas por Lombok.

## Checkstyle Integration

Verificação automática de padrão de código:

```gradle
plugins {
    checkstyle
}

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

### Configuração de Regras

```xml
<!-- config/checkstyle/checkstyle.xml -->
<?xml version="1.0"?>
<module name="Checker">
    <module name="LineLength">
        <property name="max" value="120"/>
    </module>
    <module name="TreeWalker">
        <module name="AvoidStarImport"/>
    </module>
</module>
```

### Executar Checkstyle
```bash
gradle checkstyleMain
gradle checkstyleTest
```

## Custom Tasks

Criação de tasks personalizadas:

```gradle
tasks.register('meuScript') {
    doLast {
        println("Minha task customizada")
    }
}

tasks.register<JavaExec>('executar') {
    group = "custom"
    description = "Executa a aplicação"
    classpath = sourceSets['main'].runtimeClasspath
    mainClass = "br.com.projectgradlejavawithlombok.Main"
}
```

## Dependências do Gradle

### Tipos de Dependência

```gradle
dependencies {
    // Runtime e Compile
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    
    // Apenas para compilação (não vai no JAR)
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    
    // Processadores de annotation
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    
    // Testes
    testImplementation("junit:junit:4.13.2")
    testRuntime("org.junit.vintage:junit-vintage-engine:5.9.0")
    
    // Apenas runtime
    runtimeOnly("com.mysql:mysql-connector-j:8.0.33")
}
```

### Bill of Materials (BOM)

Gerenciamento centralizado de versões:

```gradle
dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:3.0.0"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
```

## Perfis de Build

Configurações diferentes para ambientes:

```gradle
def isDevelopment = project.hasProperty('dev')

if (isDevelopment) {
    println("Build em DESENVOLVIMENTO")
} else {
    println("Build em PRODUÇÃO")
}
```

Uso:
```bash
gradle build -Pdev
```

## Source Sets

Organizações de código fonte:

```gradle
sourceSets {
    main {
        java {
            srcDirs = ['src/main/java']
        }
        resources {
            srcDirs = ['src/main/resources']
        }
    }
    
    test {
        java {
            srcDirs = ['src/test/java']
        }
    }
}
```

## JavaCompile Options

Configuração do compilador Java:

```gradle
tasks.withType(JavaCompile).configureEach {
    options.encoding = 'UTF-8'
    options.release = 11
    options.compilerArgs = [
        '-parameters',  // Para reflection em frameworks
        '-Xlint:all'    // Warnings detalhados
    ]
}
```

## Publishing

Publicar artefatos em repositórios:

```gradle
plugins {
    `maven-publish`
}

publishing {
    publications {
        mavenJava(MavenPublication) {
            from(components["java"])
            groupId = "br.com.projectgradlejavawithlombok"
            artifactId = "core"
            version = "1.0.0"
        }
    }
    
    repositories {
        maven {
            url = uri("https://repo.example.com/maven")
            credentials {
                username = project.findProperty("nexusUsername").toString()
                password = project.findProperty("nexusPassword").toString()
            }
        }
    }
}
```

## Debugging de Tasks

```bash
gradle build --debug              # Modo debug completo
gradle checkstyleMain --info      # Informações detalhadas
gradle build --scan               # Build scan (análise web)
```

## Performance

### Estratégias de Otimização

1. **Parallel Build**
```gradle
org.gradle.parallel=true
```

2. **Build Cache**
```gradle
org.gradle.caching=true
```

3. **Daemon Process**
```bash
gradle build --daemon
```

4. **Reduzir Tamanho do Classpath**
```gradle
tasks.withType(JavaCompile).configureEach {
    options.incremental = true
}
```

## Versionamento Semântico

No arquivo `gradle.properties`:
```properties
VERSION_MAJOR=1
VERSION_MINOR=0
VERSION_PATCH=0
VERSION_BUILD=${System.currentTimeMillis()}

version=${VERSION_MAJOR}.${VERSION_MINOR}.${VERSION_PATCH}
```