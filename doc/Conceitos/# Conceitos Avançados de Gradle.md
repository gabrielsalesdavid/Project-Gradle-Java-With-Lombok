# Conceitos Avançados de Gradle

## Multi-Project Builds

Estruture projetos complexos com múltiplos modules:
- settings.gradle: Configurações do projeto raiz
- Subprojetos com seu próprio build.gradle

## Processamento de Annotations

O projeto utiliza annotation processors para:
- Lombok: Gerar código em tempo de compilação
- MapStruct: Criar implementações de mapeadores

## Checkstyle Integration

Validação automática de padrões de código:
```gradle
tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = true
        html.required = true
    }
}
```

## Otimizações

- Build Cache para reutilizar resultados
- Parallel Execution para compilações mais rápidas
- Incremental Compilation