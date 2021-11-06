let carts = document.querySelectorAll('.fas fa-shopping-cart');

for (let i=0; i < carts.length; i++) {
    carts[i].addEventListener('click', () => {
        console.log("adicionado");
    })
}

function carrinhoQuant(){
    localStorage.setItem('cartNumbers', 1)
}