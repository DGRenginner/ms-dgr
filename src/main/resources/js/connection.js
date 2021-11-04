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

function cadastraUsuario(){
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
    "email" : email,
    "nome" : nome,
    "senha" : senha,
    "telefone" : telefone,
    "tipoGenero" : genero,
    "tipoAcesso" : "CLIENTE"
  }

  console.log(JSON.stringify(body))
  console.log(xhr)

 xhr.onreadystatechange = function() {
   	if (xhr.readyState == 4) {
   		if (xhr.status = 200)
   			console.log(xhr.responseText);
   		}
   	}

   	xhr.open('POST', "https://ms-dgr.herokuapp.com/pessoas/criarPessoa", true);
   	xhr.setRequestHeader("Content-type", "application/json")
    xhr.send(JSON.stringify(body))

   console.log(xhr.responseText)
  }

  function login(){
    event.preventDefault()
    let xhr = new XMLHttpRequest();

    let email = document.getElementById("email").value
    let senha = document.getElementById("senha").value
    
    console.log(email)
    console.log(senha)
  
    body = {      
      "email" : email,
      "senha" : senha
    }
  
    console.log(JSON.stringify(body))
    console.log(xhr)
  
   xhr.onreadystatechange = function() {
       if (xhr.readyState == 4) {
         if (xhr.status = 200)
           console.log(xhr.responseText);
         }
       }
  
       xhr.open('GET', "https://ms-dgr.herokuapp.com/pessoas/efetuarLogin", true);
       xhr.setRequestHeader("Content-type", "application/json")
      xhr.send(JSON.stringify(body))
  
     console.log(xhr.responseText)
    }