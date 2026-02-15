# Fundamentos de Gradle

## O que é Gradle?

Gradle é uma ferramenta de automação de build poderosa e flexível, baseada em linguagem Groovy/Kotlin DSL.

## Estrutura do Build

### Arquivo build.gradle
```gradle
plugins { }        // Plugins utilizados
repositories { }   // Repositórios de dependências
dependencies { }   // Bibliotecas necessárias
tasks { }         // Tarefas customizadas
```

## Conceitos Principais

### 1. Plugins
- `java`: Suporte para projetos Java
- `checkstyle`: Verificação de estilo de código

### 2. Dependências
```gradle
implementation()   // Runtime e compile
compileOnly()     // Apenas compile
annotationProcessor() // Processamento de annotations
```

### 3. Tasks
Tarefas padrão: clean, build, test, check

## Gradle Wrapper
O `gradlew` garante que todos usem a mesma versão do Gradle.