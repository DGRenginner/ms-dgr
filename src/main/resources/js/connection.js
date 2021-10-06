var cors = require('cors')

app.use(cors())

const requisicao = fetch("http://localhost:8081/pessoas/3")

.then(response => {
  return response.json();
 })
 .then(jsonpessoas =>{
     console.log(jsonpessoas)
 });  
console.log(requisicao);

