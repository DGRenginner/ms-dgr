const carregarProdutos = async () => {

    const response = await fetch('https://ms-dgr.herokuapp.com/produtos')
    const dados = await response.json()
    console.log(dados)

    //para cada item de produto, adiciona na pagina html um template preenchido
    dados.forEach(item => {
        const containerProdutosElement = document.getElementById("container-produtos")
       
        const template = document.getElementById("produto-template")

        //const imagemElement = document.getElementById('product-header')
        
        const produtoElement = document.importNode(template.content, true)

        const itens_produto = produtoElement.querySelectorAll('span')
        itens_produto[0].innerText = item.id
        itens_produto[1].innerText = item.nome
        itens_produto[2].innerText = item.descricao
        itens_produto[3].innerText = item.marca
        itens_produto[4].innerText = item.preco
        itens_produto[5].innerText = item.urlImagem


        containerProdutosElement.append(produtoElement)
    });

    
    let items = "items";
    localStorage.setItem(email, 'value')
    console.log(dados)
}


window.onload = () => {
    carregarProdutos()
    console.log('Iniciado')
}


function addCarrinho() {

    let xhr = new XMLHttpRequest();
    let dgr = ('https://ms-dgr.herokuapp.com/carrinhos/criarAtualizarCarrinho');

    let idProduto = document.getElementById("id")
    console.log(idProduto)

    body = {
        "id_pessoa": 37,
        "id_produto": 1
    }


    xhr.open('POST', dgr, true);
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


/*function addCarrinho(){
    event.preventDefault()
    let xhr = new XMLHttpRequest();
    let dgr = "https://ms-dgr.herokuapp.com/carrinhos/criarAtualizarCarrinho";

    document.getElementById("add-cart").addEventListener("click",pag)
    

    xhr.open('POST', dgr, true);
    xhr.setRequestHeader("Content-type", "application/json")
    xhr.send(JSON.stringify(sessionStorage))

    window.addEventListener("load", addCarrinho)
}*/