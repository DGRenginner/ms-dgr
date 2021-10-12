function fazPost(url, body) {
  console.log("Body=", body)
  fazPost = fazPost;
  let request = new XMLHttpRequest()
  request.open("POST", url, true)
  Access-Control-Allow-Origin; 
  request.setRequestHeader("Content-type", "application/json")
  request.send(JSON.stringify(body))

  request.onload = function() {
      console.log(this.responseText)
  }

  return request.responseText
}


function cadastraUsuario(){
  event.preventDefault()
  let url = "http://localhost:8081/pessoas/criarPessoa" 
  let cpf_cnpj = document.getElementById("cpf_cnpj").value
  let email = document.getElementById("email").value
  let login = document.getElementById("login").value
  let nome = document.getElementById("nome").value
  let senha = document.getElementById("senha").value
  let telefone = document.getElementById("telefone").value
  let tipo_acesso = document.getElementById("tipo_acesso").value

  console.log(cpf_cnpj)
  console.log(email)
  console.log(login)
  console.log(nome)
  console.log(senha)
  console.log(telefone)
  console.log(tipo_acesso)
  
  body =  {
      "cpf_cnpj": cpf_cnpj,
      "email": email,
      "login": login,
      "nome": nome,
      "senha": senha,
      "telefone": telefone,
      "tipo_acesso": tipo_acesso,
  }

  fazPost(url, body)

}

