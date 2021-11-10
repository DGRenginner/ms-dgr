let carts = document.querySelectorAll('.fas fa-shopping-cart');

let products = [ 
    {
        id: "",
        name: "COMPUTADOR MANCER GAMER, AMD RYZEN 5 3350G, GEFORCE GTX 750 TI 4GB, 8GB DDR4, SSD 240GB",
        tag: "banner4",
        price: 3999.80,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR GAMER SKADI II, AMD RYZEN 5 3600, GEFORCE RTX 3060 TI 8GB, 8GB DDR4, SSD 240GB",
        tag: "banner5",
        price: 9798.44,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR GAMER, INTEL I5-10600K, GEFORCE RTX 3060 TI 8GB, 8GB DDR4, SSD 240GB",
        tag: "banner6",
        price: 10619.84,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR GAMER UDYAT, INTEL I5-10400F, GEFORCE GTX 1650 4GB, 8GB DDR4, SSD 240GB",
        tag: "banner7",
        price: 5399.94,
        inCart: 0
    },
    { 
        id: "",
        name: "COMPUTADOR DGR GAMER, AMD RYZEN 5 3350G, GEFORCE RTX 2060 6GB, 8GB DDR4, SSD 240GB",
        tag: "banner8",
        price: 5999.14,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR MANCER GAMER BORR II, INTEL I3-10105F, RADEON RX 550 4GB, 8GB DDR4, SSD 240GB",
        tag: "banner9",
        price: 3555.21,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR MANCER GAMER, AMD ATHLON 3000G, RADEON RX 560 4GB, 8GB DDR4, HD 1TB",
        tag: "banner10",
        price: 3340.29,
        inCart: 0
    },
    {
        id: "",
        name: "OMPUTADOR DGR GAMER, AMD RYZEN 7 5800X, GEFORCE RTX 3060 12GB, 16GB DDR4, HD 1TB + SSD 240GB",
        tag: "banner11",
        price: 10391.92,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR MANCER GAMER, AMD RYZEN 5 3350G, GEFORCE GTX 750 TI 4GB, 8GB DDR4, SSD 240GB",
        tag: "banner12",
        price: 3999.80,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR HOME HM127, AMD ATHLON 3000G, 8GB DDR4, SSD 240GB",
        tag: "banner13",
        price: 1849.89,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR GAMER, INTEL I7-9700F, GEFORCE GTX 750 TI 4GB, 8GB DDR4, SSD 240GB",
        tag: "banner14",
        price: 5577.44,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR PICHAU GAMER SÁTIS III, AMD RYZEN 5 5600G, GEFORCE RTX 3060 TI 8GB, 8GB DDR4, SSD 240GB",
        tag: "banner15",
        price: 10033.61,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR GAMER, AMD RYZEN 7 5700G, GEFORCE RTX 3060 TI 8GB, 16GB DDR4, HD 1TB + SSD 240GB",
        tag: "banner13",
        price: 11399.91,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR MANCER GAMER, INTEL CORE I7-8700, GEFORCE GTX 1650 4GB, 8GB DDR4, SSD 240GB",
        tag: "banner14",
        price: 6522.10,
        inCart: 0
    },
    {
        id: "",
        name: "COMPUTADOR DGR GAMER, INTEL I7-11700KF, GEFORCE RTX 3060 12GB, 8GB DDR4, SSD 240GB",
        tag: "banner19",
        price: 5399.94,
        inCart: 0
    }
];

for(let i=0; i< carts.length; i++) {
    carts[i].addEventListener('click', () => {
        cartNumbers(products[i]);
        totalCost(products[i]);
    });
}

function onLoadCartNumbers() {
    let productNumbers = localStorage.getItem('cartNumbers');
    if( productNumbers ) {
        document.querySelector('.fas fa-shopping-cart').textContent = productNumbers;
    }
}

function cartNumbers(product, action) {
    let productNumbers = localStorage.getItem('cartNumbers');
    productNumbers = parseInt(productNumbers);

    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    if( action ) {
        localStorage.setItem("cartNumbers", productNumbers - 1);
        document.querySelector('.fas fa-shopping-cart').textContent= productNumbers - 1;
        console.log("action running");
    } else if( productNumbers ) {
        localStorage.setItem("cartNumbers", productNumbers + 1);
        document.querySelector('.fas fa-shopping-cart').textContent = productNumbers + 1;
    } else {
        localStorage.setItem("cartNumbers", 1);
        document.querySelector('.fas fa-shopping-cart').textContent = 1;
    }
    setItems(product);
}

function setItems(product) {
    // let productNumbers = localStorage.getItem('cartNumbers');
    // productNumbers = parseInt(productNumbers);
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    if(cartItems != null) {
        let currentProduct = product.tag;
    
        if( cartItems[currentProduct] == undefined ) {
            cartItems = {
                ...cartItems,
                [currentProduct]: product
            }
        } 
        cartItems[currentProduct].inCart += 1;

    } else {
        product.inCart = 1;
        cartItems = { 
            [product.tag]: product
        };
    }

    localStorage.setItem('productsInCart', JSON.stringify(cartItems));
}

function totalCost( product, action ) {
    let cart = localStorage.getItem("totalCost");

    if( action) {
        cart = parseInt(cart);

        localStorage.setItem("totalCost", cart - product.price);
    } else if(cart != null) {
        
        cart = parseInt(cart);
        localStorage.setItem("totalCost", cart + product.price);
    
    } else {
        localStorage.setItem("totalCost", product.price);
    }
}

function displayCart() {
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    let cart = localStorage.getItem("totalCost");
    cart = parseInt(cart);

    let productContainer = document.querySelector('.products');
    
    if( cartItems && productContainer ) {
        productContainer.innerHTML = '';
        Object.values(cartItems).map( (item, index) => {
            productContainer.innerHTML += 
            `<div class="product"><ion-icon name="close-circle"></ion-icon><img src="./img/${item.tag}.jpg" />
                <span class="sm-hide">${item.name}</span>
            </div>
            <div class="price sm-hide">$${item.price},00</div>
            <div class="quantity">
                <ion-icon class="decrease " name="arrow-dropleft-circle"></ion-icon>
                    <span>${item.inCart}</span>
                <ion-icon class="increase" name="arrow-dropright-circle"></ion-icon>   
            </div>
            <div class="total">$${item.inCart * item.price},00</div>`;
        });

        productContainer.innerHTML += `
            <div class="basketTotalContainer">
                <h4 class="basketTotalTitle">Basket Total</h4>
                <h4 class="basketTotal">$${cart},00</h4>
            </div>`

        deleteButtons();
        manageQuantity();
    }
}

function manageQuantity() {
    let decreaseButtons = document.querySelectorAll('.decrease');
    let increaseButtons = document.querySelectorAll('.increase');
    let currentQuantity = 0;
    let currentProduct = '';
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);

    for(let i=0; i < increaseButtons.length; i++) {
        decreaseButtons[i].addEventListener('click', () => {
            console.log(cartItems);
            currentQuantity = decreaseButtons[i].parentElement.querySelector('span').textContent;
            console.log(currentQuantity);
            currentProduct = decreaseButtons[i].parentElement.previousElementSibling.previousElementSibling.querySelector('span').textContent.toLocaleLowerCase().replace(/ /g,'').trim();
            console.log(currentProduct);

            if( cartItems[currentProduct].inCart > 1 ) {
                cartItems[currentProduct].inCart -= 1;
                cartNumbers(cartItems[currentProduct], "decrease");
                totalCost(cartItems[currentProduct], "decrease");
                localStorage.setItem('productsInCart', JSON.stringify(cartItems));
                displayCart();
            }
        });

        increaseButtons[i].addEventListener('click', () => {
            console.log(cartItems);
            currentQuantity = increaseButtons[i].parentElement.querySelector('span').textContent;
            console.log(currentQuantity);
            currentProduct = increaseButtons[i].parentElement.previousElementSibling.previousElementSibling.querySelector('span').textContent.toLocaleLowerCase().replace(/ /g,'').trim();
            console.log(currentProduct);

            cartItems[currentProduct].inCart += 1;
            cartNumbers(cartItems[currentProduct]);
            totalCost(cartItems[currentProduct]);
            localStorage.setItem('productsInCart', JSON.stringify(cartItems));
            displayCart();
        });
    }
}

function deleteButtons() {
    let deleteButtons = document.querySelectorAll('.product ion-icon');
    let productNumbers = localStorage.getItem('cartNumbers');
    let cartCost = localStorage.getItem("totalCost");
    let cartItems = localStorage.getItem('productsInCart');
    cartItems = JSON.parse(cartItems);
    let productName;
    console.log(cartItems);

    for(let i=0; i < deleteButtons.length; i++) {
        deleteButtons[i].addEventListener('click', () => {
            productName = deleteButtons[i].parentElement.textContent.toLocaleLowerCase().replace(/ /g,'').trim();
           
            localStorage.setItem('cartNumbers', productNumbers - cartItems[productName].inCart);
            localStorage.setItem('totalCost', cartCost - ( cartItems[productName].price * cartItems[productName].inCart));

            delete cartItems[productName];
            localStorage.setItem('productsInCart', JSON.stringify(cartItems));

            displayCart();
            onLoadCartNumbers();
        })
    }
}

onLoadCartNumbers();
displayCart();
