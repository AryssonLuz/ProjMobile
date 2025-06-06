# 📱 ProjMobile

Aplicativo Android simples desenvolvido em Kotlin, com funcionalidades básicas de CRUD utilizando SQLite, navegação entre telas, e manipulação de imagens e textos.

## 🚀 Funcionalidades

- ✅ Cadastro de dados (nome, idade, telefone)
- ✅ Listagem de registros usando `ListView`
- ✅ Atualização e exclusão de registros
- ✅ Armazenamento local com SQLite
- ✅ Validação de entrada
- ✅ Navegação entre múltiplas telas
- ✅ Interação com imagens, botões e campos de texto
- ✅ Layout responsivo com `ScrollView` e boas práticas de UI

## 🧱 Tecnologias Utilizadas

- Kotlin
- Android SDK
- SQLite
- Android Studio
- XML para layout

## 🖼️ Telas

1. **Tela de Cadastro/Listagem**  
   Inserir, listar, atualizar e excluir dados locais.

2. **Tela Final**  
   Exibe imagens e mensagens dinâmicas após interações específicas.

## 📂 Organização do Projeto
ProjMobile/

├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/myapplication/
│ │ │ │ ├── DBHelper.kt
│ │ │ │ ├── Tela1.kt … Tela6.kt
│ │ │ ├── res/
│ │ │ │ ├── layout/
│ │ │ │ │ ├── activity_tela1.xml … activity_tela6.xml
│ │ │ │ ├── mipmap/
│ │ │ │ │ ├── nota10.png, nota0.png, absolute.png, etc.


## 🛠️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/AryssonLuz/ProjMobile.git
