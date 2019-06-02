# Clínica Life App
Sistema para o gerenciamento de uma clínica de fisioterapias e estética. A seguir é apresentado as principais funcionalidades do sistema:
- Agenda;
- Gerenciamento de Pacientes;
- Gerenciamento de Profissionais - além do controle de especialidades dos profissionais;
- Gerenciamento de Usuários (acesso ao sistema);
- Gerenciamento de Procedimentos;

# Conteúdo:

- [Funcionalidades e screenshots](https://github.com/laisfrigerio/ClinicaLifeApp#funcionalidades)
- [Tecnologias](https://github.com/laisfrigerio/ClinicaLifeApp#tecnologias)
- [Changelog](https://github.com/laisfrigerio/ClinicaLifeApp#Changelog)

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

- Sistema desenvolvido em JAVA com SWING;
- Banco de dado MySQL;

## Changelog

- Versão 1.0.0: (08/2017) Não possuia agenda;
- Versão 2.0.0: (02/2018) Adicionado agenda;
- Versão 3.0.0: (11/2018) Agendamento recorrente;
- Versão 3.0.2: (06/2019) Ajuste do responsivo da tea na vertical;
