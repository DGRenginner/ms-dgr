function fazPost(url, body) {

  console.log("Body=", body)
  var xhr = new XMLHttpRequest();
  request.open("post", url, true)
  request.setRequestHeader("Content-type", "application/json")
  request.send(JSON.stringify(body))

  request.onload = function () {
    console.log(this.responseText)
  }

  return request.responseText
}

function cadastraUsuario() {
  event.preventDefault()
  let xhr = new XMLHttpRequest();

  let cpfcnpj = document.getElementById("cpfcnpj").value
  let email = document.getElementById("email").value
  let nome = document.getElementById("nome").value
  let senha = document.getElementById("senha").value
  let telefone = document.getElementById("telefone").value
  let genero = document.querySelector('input[name="genero"]:checked').value

  console.log(cpfcnpj)
  console.log(email)
  console.log(nome)
  console.log(senha)
  console.log(telefone)
  console.log(genero)

  body = {
    "cpfCnpj": cpfcnpj,
    "email": email,
    "nome": nome,
    "senha": senha,
    "telefone": telefone,
    "tipoGenero": genero,
    "tipoAcesso": "CLIENTE"
  }

  console.log(JSON.stringify(body))
  console.log(xhr)



  xhr.onreadystatechange = function () {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
        console.log("Conta criada com sucesso!")

      } if (xhr.status == 409) {
        console.log("Já existe um cadastro com esse e-mail.")
      } else if (xhr.status != 200 && xhr.status != 409){
        console.log("Ocorreu algum erro durante o processamento. Tente novamente!")
      }
        console.log(xhr.responseText);
     
    } 
  }

  xhr.open('POST', "https://ms-dgr.herokuapp.com/pessoas/criarPessoa", true);
  xhr.setRequestHeader("Content-type", "application/json")
  xhr.send(JSON.stringify(body))

  console.log(xhr.responseText)
}


function login() {
  event.preventDefault()
  let xhr = new XMLHttpRequest();
  let dgr = "https://ms-dgr.herokuapp.com/pessoas/efetuarLogin";


  let email = document.getElementById("email").value
  let senha = document.getElementById("senha").value

  console.log(email)
  console.log(senha)
 

  body = {
    "email": email,
    "senha": senha,
  
  }

  console.log(JSON.stringify(body))
  console.log(xhr)


  xhr.onreadystatechange = function () {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {

      }else if (xhr.status == 204) {
        console.log("Não identificamos um cadastro com esse e-mail. Gostaria de se cadastrar agora mesmo?")
      }else if (xhr.status == 203) {
        console.log("A senha não coincide com a que encontramos. Deseja recuperar sua senha?")
      } else {
        console.log("Ocorreu algum erro durante o processamento. Tente novamente!")
      }
        console.log(xhr.responseText);
     
    } 
  }

  xhr.open('POST', dgr, true);
  xhr.setRequestHeader("Content-type", "application/json")
  xhr.send(JSON.stringify(body))

  console.log(xhr.responseText)
  
}
/* Adicionar form action para direcioar para pagina e incluir alert para conta criada com sucesso e etc */