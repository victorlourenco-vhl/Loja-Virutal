import api from "./api";


export default function EstadoService() {
    function listarEstado() {
        api.get('/estado')
    .then(function (response) {
      console.log(response);
    })
    .catch(function (error) {
      console.error(error);
    })
    .finally(function () {
        console.log('Requisição finalizada!')
    });
    }
}
