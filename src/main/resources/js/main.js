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
    event.preventDefault()
    let xhr = new XMLHttpRequest();

    let url = document.getElementById("urlImagem").value
    let nome = document.getElementById("nome").value
    let preço = document.getElementById("preço").value
    let descrição = document.getElementById("descrição").value
    let marca = document.getElementById("marca").value

    console.log(url)
    console.log(nome)
    console.log(preço)
    console.log(descrição)
    console.log(marca)

    body = {
        "url": "DANILO",
        "nome": "NAO VALE NADA",
        "preco": "NENHUMA",
        "descricao": 1,
        "promocao": false,
        "urlImagem": "img.png",
        "quantidade": 0


    }
    console.log(JSON.stringify(body))
    console.log(xhr)

    xhr.open('POST', "https://ms-dgr.herokuapp.com/produtos/criarProduto", true);
    xhr.setRequestHeader("Content-type", "application/json")
    xhr.send(JSON.stringify(body));

    console.log(xhr.responseText)
}



