# Fundamentos de Java

## Introdução
Java é uma linguagem de programação orientada a objetos, robusta e multiplataforma, desenvolvida pela Sun Microsystems em 1995. Segue o princípio "Write Once, Run Anywhere" (WORA).

## Conceitos Básicos

### 1. Tipos de Dados Primitivos
- **int**: Números inteiros (32 bits)
- **long**: Números inteiros grandes (64 bits)
- **float**: Números decimais (32 bits)
- **double**: Números decimais de precisão dupla (64 bits)
- **boolean**: Valores verdadeiro ou falso
- **char**: Um único caractere Unicode
- **byte**: Número inteiro pequeno (8 bits)
- **short**: Número inteiro médio (16 bits)

### 2. Tipos de Referência
- **String**: Sequência de caracteres
- **Arrays**: Coleções de elementos do mesmo tipo
- **Objetos**: Instâncias de classes

### 3. Orientação a Objetos (OOP)

#### Classes e Objetos
```java
public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}
```

#### Encapsulamento
Proteção de atributos usando modificadores de acesso:
- `public`: Acessível de qualquer lugar
- `private`: Acessível apenas na classe
- `protected`: Acessível na classe, pacote e subclasses
- (padrão): Acessível no pacote

#### Herança
```java
public class Funcionario extends Pessoa {
    private double salario;
}
```

#### Polimorfismo
Métodos podem ter diferentes implementações em subclasses.

#### Abstração
Criação de abstrações para representar conceitos.

### 4. Estruturas de Controle

#### Condicionais
```java
if (condicao) {
    // código
} else if (outraCondicao) {
    // código
} else {
    // código
}

switch (valor) {
    case 1:
        // código
        break;
    default:
        // código
}
```

#### Loops
```java
for (int i = 0; i < 10; i++) { }
while (condicao) { }
do { } while (condicao);
for (String item : lista) { } // enhanced for
```

#### Tratamento de Exceções
```java
try {
    // código que pode gerar exceção
} catch (Exception e) {
    // tratamento do erro
} finally {
    // sempre executado
}
```

### 5. Coleções
- **List**: Ordenada, permite duplicatas (ArrayList, LinkedList)
- **Set**: Sem duplicatas, não ordenada (HashSet, TreeSet)
- **Map**: Chave-valor (HashMap, TreeMap)

### 6. Métodos
```java
public String obterNome() {
    return nome;
}

public void definirNome(String novoNome) {
    this.nome = novoNome;
}
```

## Pacotes
Organizações de classes em namespaces:
```java
package br.com.projectgradlejavawithlombok.model;
```

## Modificadores
- **static**: Pertence à classe, não à instância
- **final**: Não pode ser modificado ou estendido
- **abstract**: Deve ser implementado por subclasses

## Interfaces
Contrato que uma classe deve implementar:
```java
public interface Animal {
    void fazer_som();
}
```