function fazPost(url, body) {

  console.log("Body=", body) 
    var xhr = new XMLHttpRequest();
    request.open("post", url, true)
    request.setRequestHeader("Content-type", "application/json")
    request.send(JSON.stringify(body))
  
    request.onload = function() {
      console.log(this.responseText)
    }

    return request.responseText
}
 
xhr.onreadystatechance = function cadastraUsuario(){



  event.preventDefault()
  xhr.open("POST" , "https://ms-dgr.herokuapp.com/pessoas/criarPessoa") 
  let cpf_cnpj = document.getElementById("cpf_cnpj").value
  let email = document.getElementById("email").value
  let nome = document.getElementById("nome").value
  let senha = document.getElementById("senha").value
  let confirmasenha = document.getElementById("confirmasenha").value
  let telefone = document.getElementById("telefone").value

  console.log(cpf_cnpj)
  console.log(email)
  console.log(nome)
  console.log(senha)
  console.log(confirmasenha)
  console.log(telefone)

  body = {
    "cpf_cnpj": cpf_cnpj,
    "email" : email,
    "nome" : nome,
    "senha" : senha,
    "confirmasenha" : confirmasenha,
    "telefone" : telefone,
  }
fazPost(url, body)



 }
