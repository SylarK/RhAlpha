# RhAlpha
> Project that aims to control time attendance, including reporting, changing business rules and time management and authentication for each user.
> 
> Projeto que visa o controle de registro de ponto, incluindo emissão de relatórios, alteração de regra de negócio e gestão de tempo e autenticação para cada usuário.


- [Stack](#custom_stack)
- [Installing](#custom_installing)
- [Layout](#custom_layout)
- [Aplicação em Funcionamento](#custom_final)

------------------------

### <a name="custom_stack">Stack</a>

- Java SE11
- SpringBoot (security, thymeleaf, web, jpa, hibernate, validation)
- Actuator
- Spring Admin
- Postgresql 11
- Lombok
- VueJs
- Docker
- Python
------------------------

### <a name="custom_installing">Installing</a>

> Realize o clone do repositório (apenas para fins informativos, ao criar este projeto utilizei o Intellij IDEA)
> Dentro do diretório principal abra a pasta "db" e após criar o banco de dados rhalpha, use os comandos descritos ali para gerar as tabelas e alguns dados.
> O monitor rh-Alpha é um projeto a parte para monitoramento do servidor baseando-se no actuator colocado no projeto principal. Ele precisa ser inicializado separadamente da aplicação original.
> Rode a aplicação

Por default:
- Aplicação principal, porta 8085.
- Monitor rh-Alpha, porta 8080.

> Atenção, a coluna referente ao idDiscord foi criada para realizar a integração com algum bot que venha a ser criado com integração com o discord.
------------------------

### <a name="custom_layout">Layout</a>
> Layout inicial criado utilizando figma, para se ter um norte para orientar o desenvolvimento da aplicação.
> 
> ![image](https://user-images.githubusercontent.com/40666040/140649032-f9478794-ac48-4167-ae45-b7aa0b7b84ae.png)

------------------------

### <a name="custom_final">Video - Aplicação em Funcionamento</a>
[![RhAlpha App](https://i9.ytimg.com/vi/jNDaYkbErLQ/mq1.jpg?sqp=COjFn4wG&rs=AOn4CLDl5Ao4C2-YQv3D4ugUyZalTQkuHg)](https://www.youtube.com/watch?v=xyBwRZqSNTs "RhAlpha App")
