# **JSON JavaScript Object Notation**

JSON (JavaScript Object Notation) é um formato leve de troca de dados, fácil de ler e escrever para humanos e simples de interpretar e gerar para máquinas. Baseado em um subconjunto da linguagem de programação JavaScript, o JSON é independente de linguagem, o que significa que pode ser usado com muitas linguagens de programação, tornando-o ideal para transmissão de dados entre cliente e servidor em aplicações web.

## Por que usar JSON?

- **Facilidade de leitura e escrita**: Sua estrutura clara e concisa torna o JSON acessível para desenvolvedores e sistemas.
- **Leve**: Comparado com outros formatos de troca de dados, como XML, o JSON é menos verboso, o que se traduz em menos bytes sendo transmitidos pela rede.
- **Compatibilidade**: Sendo independente de linguagem, ele pode ser usado em quase qualquer ambiente de programação.


<div align="center">

![147291500-402b5260-4d61-41eb-a9ff-b38957abd81f](https://github.com/Herysson/Spring-Backend-CRUD/assets/7634437/ca8129f5-19b0-4d1f-9965-46722bd3ea16)

</div>

## Estrutura Básica

O JSON é estruturado em duas estruturas principais:

- **Objetos**: Um conjunto de pares chave/valor. Um objeto começa com `{` e termina com `}`. Cada chave é seguida por `:` e os pares chave/valor são separados por `,`.
- **Arrays**: Uma lista ordenada de valores. Um array começa com `[` e termina com `]`. Os valores são separados por `,`.

### Exemplo de Objeto JSON

```json
{
  "nome": "John Doe",
  "idade": 30,
  "isAluno": true,
  "cursos": ["Java", "Spring Boot"],
  "endereco": {
    "rua": "Rua Central",
    "numero": 100
  }
}
```

### Exemplo de Array JSON

```json
[
  {
    "nome": "John Doe",
    "idade": 30
  },
  {
    "nome": "Jane Doe",
    "idade": 28
  }
]
```

## Usando JSON em Aplicações Web

JSON é amplamente usado em APIs RESTful para enviar e receber dados. Aqui está um exemplo de como os dados podem ser enviados de um cliente para um servidor usando JSON:

1. O cliente envia uma solicitação para o servidor com dados JSON no corpo da solicitação.
2. O servidor processa os dados recebidos, realiza a ação necessária, e pode responder ao cliente com mais dados JSON.

Este processo facilita a construção de aplicações web e móveis que necessitam de comunicação com um servidor para troca de dados.

## **Exercício 1**

Como exercício realizem persistam os dados abaixo usando JPA (Java Persistence API) e Hibernate, no exmplo anteriomente criado com a utilização de uma ferramente de teste de integração **Postman**.

**Noah**
```json
{
  "name": "Noah",
  "email": "noah@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 11 98765-0001"
    },
    {
      "type": "home",
      "number": "55 11 3541-0002"
    }
  ]
}
```

**Eva**
```json
{
  "name": "Eva",
  "email": "eva@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 22 98765-0002"
    },
    {
      "type": "home",
      "number": "55 22 3541-0003"
    },
    {
      "type": "work",
      "number": "55 22 3541-0044"
    }
  ]
}
```

**Moises**
```json
{
  "name": "Moises",
  "email": "moises@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 21 98765-0003"
    }
  ]
}
```

**Abraham**
```json
{
  "name": "Abraham",
  "email": "abraham@example.com",
  "phones": [
    {
      "type": "home",
      "number": "55 21 3541-0004"
    },
    {
      "type": "mobile",
      "number": "55 21 98765-0055"
    }
  ]
}
```

**Sarah**
```json
{
  "name": "Sarah",
  "email": "sarah@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 31 98765-0005"
    },
    {
      "type": "home",
      "number": "55 31 3541-0066"
    },
    {
      "type": "work",
      "number": "55 31 3541-0077"
    }
  ]
}
```

**Isaac**
```json
{
  "name": "Isaac",
  "email": "isaac@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 31 98765-0006"
    },
    {
      "type": "home",
      "number": "55 31 3541-0088"
    }
  ]
}
```

**Rebecca**
```json
{
  "name": "Rebecca",
  "email": "rebecca@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 11 98765-0007"
    }
  ]
}
```

**Joseph**
```json
{
  "name": "Joseph",
  "email": "joseph@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 11 98765-0008"
    }
  ]
}
```

**David**
```json
{
  "name": "David",
  "email": "david@example.com",
  "phones": [
    {
      "type": "home",
      "number": "55 21 3541-0009"
    }
  ]
}
```

**Solomon**
```json
{
  "name": "Solomon",
  "email": "solomon@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 21 98765-0010"
    },
    {
      "type": "home",
      "number": "55 21 3541-0011"
    }
  ]
}
```

## **Exercício 2**
Verifique se todos os registro foram inseridos com sucesso.

## **Exercício 3**
Alteres os registros conforme instrução abaixo.

1. **Noah**
    - Foi adicionado um terceiro número de telefone do tipo `work`, expandindo a lista de telefones associados ao usuário. Isso exemplifica como os dados de um usuário podem ser expandidos para incluir múltiplos tipos de contato, refletindo situações da vida real onde uma pessoa pode ter vários números de telefone.

**Noah**
```json
{
  "name": "Noah",
  "email": "noah@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 11 98765-0001"
    },
    {
      "type": "home",
      "number": "55 11 3541-0002"
    },
    {
      "type": "work",
      "number": "55 11 3542-0003"
    }
  ]
}
```

2. **Eva**
    - Foi removido o número de `work`, simplificando os contatos de Eva para apenas um `mobile` e um `home`. Esta alteração pode ajudar a discutir com os alunos sobre operações de remoção de dados em uma coleção e como isso afeta a relação entre entidades.

**Eva**
```json
{
  "name": "Eva",
  "email": "eva@example.com",
  "phones": [
    {
      "type": "mobile",
      "number": "55 22 98765-0002"
    },
    {
      "type": "home",
      "number": "55 22 3541-0003"
    }
  ]
}
```

3. **Sarah**
    - Foram alterados os tipos dos números de telefone para `personal` e `office`, ao invés de `mobile` e `home`. Isso mostra como categorias ou tipos de dados podem ser atualizados para refletir necessidades ou entendimentos diferentes, uma habilidade importante na gestão de bancos de dados.

**Sarah**
```json
{
  "name": "Sarah",
  "email": "sarah@example.com",
  "phones": [
    {
      "type": "personal",
      "number": "55 31 98765-0005"
    },
    {
      "type": "office",
      "number": "55 31 3541-0066"
    },
    {
      "type": "office",
      "number": "55 31 3541-0077"
    }
  ]
}
```
## **Exercício 4**
**David** decidiu encerrar sua conta em um popular aplicativo de gerenciamento de contatos após anos de uso fiel, motivado por uma mudança para o campo rural, onde planejava viver uma vida mais desconectada e focada na natureza. Ele percebeu que a maior parte de sua comunicação agora aconteceria face a face, uma mudança significativa de seu estilo de vida anterior, centrado na tecnologia. Com um sentimento de gratidão pelas conexões que o aplicativo lhe proporcionou ao longo dos anos, ele solicitou a remoção de seus dados, simbolizando um novo capítulo em sua jornada rumo a um estilo de vida mais simples e presente.
Certifique-se que o **David** foi removido.


## Referências

   - JSON ([json.org](https://www.json.org/json-en.html))
     
   - Mozilla Developer Network (MDN) ([MDN - JSON](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON))
    
   - O padrão ECMA-404 ([ECMA International](https://www.ecma-international.org/publications-and-standards/standards/ecma-404/)) 

   - A RFC 8259 ([RFC 8259](https://datatracker.ietf.org/doc/html/rfc8259)) é um documento técnico que define o JSON como um formato de intercâmbio de dados. É útil para entender as regras formais que governam o formato.
