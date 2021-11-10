const carregarProdutos = async () => {

    const response = await fetch('https://ms-dgr.herokuapp.com/produtos');
    const dados = await response.json()
    console.log(dados)

    //para cada item de produto, adiciona na pagina html um template preenchido
    dados.forEach(item => {
        const containerProdutosElement = document.getElementById("produtos")

        const template = document.getElementById("product-footer")

        const imagemElement = document.getElementById('product-header')

        const produtoElement = document.importNode(template.content, true)

        const itens_produto = produtoElement.querySelectorAll('span')
        itens_produto[0].innerText = item.nome
        itens_produto[1].innerText = item.preco
       /* itens_produto[2].innerText = item.descricao
        itens_produto[3].innerText = item.marca
        itens_produto[4].innerText = item.preco
        itens_produto[5].innerText = item.urlImagem*/

        containerProdutosElement.append(produtoElement)
    });

    console.log(dados)
}