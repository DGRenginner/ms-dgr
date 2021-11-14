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

function cadastraProduto() {
    console.log("CADASTRA PRODUTO")

    event.preventDefault()
    let xhr = new XMLHttpRequest();

    let url = document.getElementById("urlImagem").value
    let nome = document.getElementById("nome").value
    let preco = document.getElementById("preco").value
    let descricao = document.getElementById("descricao").value
    let marca = document.getElementById("marca").value
    let quantidade = document.getElementById("quantidade").value

    console.log(url)
    console.log(nome)
    console.log(preco)
    console.log(descricao)
    console.log(marca)

    body = {
        "nome": nome,
        "preco": preco,
        "descricao": descricao,
        "marca" : marca,
        "promocao": false,
        "urlImagem": "url",
        "quantidade": quantidade
    }
    console.log(JSON.stringify(body))
    console.log(xhr)

    xhr.open('POST', "http://localhost:8081/produtos/criarProduto", true);
    xhr.setRequestHeader("Content-type", "application/json")
    xhr.send(JSON.stringify(body));

    console.log(xhr.responseText)
}



