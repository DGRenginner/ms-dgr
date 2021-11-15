const carregarProdutos = async () => {
    //https://ms-dgr.herokuapp.com
    //http://localhost:8081
    const response = await fetch('https://ms-dgr.herokuapp.com/produtos')

    const dados = await response.json()
    dados.quantidade = 0
    console.log(dados)

    const containerProdutosElement = document.getElementById("container-produtos")

    dados.map((val) => {
        console.log(val)
        containerProdutosElement.innerHTML += `
   

        <div class="produtos">
        <div class="product">
          <div class="product-header">
            <img src=" ${val.urlImagem}" class='small' alt="product">
          </div>
          <div class="product-item">
            <h3<span> ${val.nome}</span></h3>
            <h4><span> ${val.marca}</span></h4>
            <div class="rating">
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="fas fa-star"></i>
              <i class="far fa-star"></i>
            </div>
            <div class="product-price">
              <h4>R$ ${val.preco}></h4>
              <input type="hidden" name="3999.80">
            </div>
          </div>
          <div class="car">
          <ul>
            <li>
            <a key="${val.id}" href="#" > Adicionar ao carrinho<a/>
              </a>
            </li>
            <li>
            </div>
       
        `
    });

    // <i id="item1" class="fas fa-shopping-cart" >Add</i>
    var links = document.getElementsByTagName('a');
    for (var i = 0; i < links.length; i++) {
        links[i].addEventListener("click", function () {
            let key = this.getAttribute('key');
            addCarrinho(key);
            return false;
        })
    }



    let items = "items";
    localStorage.setItem(email, 'value')
    console.log(dados)
}


window.onload = () => {
    carregarProdutos()
    console.log('Iniciado')
}


function addCarrinho(id) {

    let xhr = new XMLHttpRequest();
    let dgr = ('https://ms-dgr.herokuapp.com/carrinhos/criarAtualizarCarrinho');

    console.log(id)

    body = {
        "email": "admin@admin",
        "idProduto": id,
        "quantidade" : 1
    }
   
    console.log(body)

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
    localStorage.setItem(email, 'value');
    let myItem = localStorage.getItem(email);
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


function redireciona(){
  location.href = "checkout.html";
}