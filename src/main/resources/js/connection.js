fetch("")
.then(response => response.json())
.then(json => {
    console.log(json);
})

const Pessoas = {
    id: "",
    nome: "Giovanni",
    cpfCnpj: "49490467804",
    telefone: "11971288482",
    email: "projetointer12021@gmail.com",
    tipoGenero: "Macho alfa",
    login: "admin",
    senha: "admin",
    tipoAcesso: "funcionário"
};

fetch("", {
    method: "GET",
    mode: "",
    cache: "",
    credentials: "same-origin",
    headers: {
        "Content-Type": "application/json"
    },
    redirect: "follow",
    referrer: "no-referrer",
    body: JSON.stringify(Pessoas)
});

