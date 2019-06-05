# Clínica Life App
Sistema para o gerenciamento de uma clínica de fisioterapias e estética. A seguir é apresentado as principais funcionalidades do sistema:
- Agenda;
- Gerenciamento de Consultas;
- Gerenciamento de Pacientes;
- Gerenciamento de Profissionais - além do controle de especialidades dos profissionais;
- Gerenciamento de Usuários (acesso ao sistema);
- Gerenciamento de Procedimentos;

**ATENÇÃO**
- Aplicação desenvolvido em Windows;
- NÃO foi testado em Linux/Mac OS;

# Conteúdo:

- [Requisitos para instalar a aplicação](https://github.com/laisfrigerio/ClinicaLifeApp#rinstalacao)
- [Desenvolvimento](https://github.com/laisfrigerio/ClinicaLifeApp#desenvolvimento)
- [Funcionalidades e screenshots](https://github.com/laisfrigerio/ClinicaLifeApp#funcionalidades)
- [Tecnologias](https://github.com/laisfrigerio/ClinicaLifeApp#tecnologias)
- [Testes](https://github.com/laisfrigerio/ClinicaLifeApp#testes)
- [Changelog](https://github.com/laisfrigerio/ClinicaLifeApp#Changelog)

## Instalação

- Computador com Windows 7 (32/64 bits);
- Banco de Dados Mysql instalado localmente na máquina. As credencias do banco devem ser iguais as configuradas no seguinte arquivo de configuração >> [Credenciais do banco de dados](https://github.com/laisfrigerio/ClinicaLifeApp/blob/master/src/resources/config.properties);
- JRE 1.18.0 (Windows 32/64 bits);

## Desenvolvimento

- Local
  - NetBeans
  - JRE 1.18.0
  - Banco de Dados Mysql;
    - [Credenciais do banco de dados](https://github.com/laisfrigerio/ClinicaLifeApp/blob/master/src/resources/config.properties);

- Sobre o Instalador
  - Apenas é executado em computadores com **Windows 7 e/ou superior (32/64 bits)**;
  - O instalador foi desenvolvido utilizando a ferramenta **Inno Setup**;
  - Veja o código para gerar o instalador [AQUI](https://github.com/laisfrigerio/ClinicaLifeApp/blob/master/versoes/v3/3.0.3/generate_installer.iss);
  
- Sobre o executável da aplicação
  - Através da ferramenta **Launchj4** é gerado o executável da aplicação que contém o **.jar** e as dependências;
  - Veja o código para gerar o executável [AQUI](https://github.com/laisfrigerio/ClinicaLifeApp/blob/master/versoes/v3/3.0.3/generate_exe_app.xml);
  

- Para alterar as configurações do banco de dados:
  - Abra a aplicação em uma IDE de desenvolvimento (NetBeans);
  - Acesse o arquivo **src/resources/config.properties** e altere as credenciais do banco de dados;
  - Execute a aplicação para recriar o **.jar**;
  - Gerar .exe da aplicação através da ferramenta Launchj4;
  - Gerar o instaldor da aplicação através da ferramenta Inno Setup;

## Funcionalidades

- <strong>Login:</strong> Sistema de autenticação. Utilize os seguintes dados para realizar login na aplicação

> Login: <strong>lais</strong>;
> Senha: <strong>lais</strong>;

<br/><br/>

[![Login](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/login.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/login.png)

- **Agenda:** é possível agendar consultas, além de realizar o agendamento recorrente - diariamente, semanalmente, quinzenalmente, mensalmente e anualmente;
<br/><br/>

> **Outras funcionalidades:** 
  > - Excluir agendamento;
  > - Agendamento no sábado opcional; 
  > - O domingo *SEMPRE* é ignorado no agendamento recorrente;
  > - Filtro por data e pesquina pelo nome do paciente;

<br/><br/>

[![Agenda](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/agenda.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/agenda.png)
[![Novo agendamento](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/agendamento_novo.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/agendamento_novo.png)
[![Editar agendamento](https://github.com/laisfrigerio/ClinicaLifeApp/blob/master/screens/agendamento_editar.png)](https://github.com/laisfrigerio/ClinicaLifeApp/blob/master/screens/agendamento_editar.png)

- <strong>Pacientes</strong>: cadastro e edição dos dados de um paciente, além da listagem

> **Outras funcionalidades:** 
  > - Pesquisa por código, nome, CPF e data de nascimento do paciente;

<br/><br/>

[![Lista de Pacientes](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/pacientes.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/pacientes.png)
[![Novo paciente](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/paciente_novo.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/paciente_novo.png)
[![Editar paciente](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/paciente_editar.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/paciente_editar.png)

- <strong>Profissionais</strong>: cadastro e edição dos dados de um profissional, além da listagem;

> **Outras funcionalidades:** 
  > - Cadastro, edição, remoção e listagem de especialidades;
  > - Pesquisa por código, nome, especialidade e login do profissional;

<br/><br/>

[![Lista de Profissionais](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/profissionais.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/profissionais.png)
[![Lista de especialidades](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/especialidades.png)](https://raw.githubusercontent.com/laisfrigerio/ClinicaLifeApp/master/screens/especialidades.png)

<br/><br/>

## Tecnologias

- Windows 10 64bits (utilizado no desenvolvimento da aplicação);
- IDE Netbeans;
- Sistema desenvolvido em JAVA com SWING;
- Banco de dado MySQL;
- JRE 1.18.0;
- Inno Setup;
- Launchj4;

## Testes

- A aplicação já foi instalada em computadores com Windows 7 de 32 e 64 bits;
- Já foi instalada em um computador Windows 10 de 64 bits;

## Changelog

- Versão 1.0.0: (08/2017) Versão inicial com cadastro de pacientes, usuários, fisiotepeutas, fisioterapias e avaliações (Sem agenda);
- Versão 2.0.0: (02/2018) Adicionado agenda;
- Versão 3.0.0: (11/2018) Agendamento recorrente;
- Versão 3.0.2: (06/2019) Ajuste do responsivo da tela na vertical;
- Versão 3.0.3: (06/2019) Adicionando (novamente) CRUD de Avaliações;
