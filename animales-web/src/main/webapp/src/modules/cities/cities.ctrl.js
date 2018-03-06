(function (ng) {

    var mod = ng.module("animalesModule");

    mod.controller("animalesCtrl", ['$scope', '$state', '$stateParams', '$http', 'animalesContext', function ($scope, $state, $stateParams, $http, context) {

            // inicialmente el listado de animales está vacio
            $scope.records = {};
            // carga las animales
            $http.get(context).then(function (response) {
                $scope.records = response.data;
            });

            // el controlador recibió un animalId ??
            // revisa los parámetros (ver el :animalId en la definición de la ruta)
            if ($stateParams.animalId !== null && $stateParams.animalId !== undefined) {

                // toma el id del parámetro
                id = $stateParams.animalId;
                // obtiene el dato del recurso REST
                $http.get(context + "/" + id)
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.currentRecord = response.data;
                        });

                // el controlador no recibió un animalId
            } else {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*especie Long. El valor se asigna en el backend*/,
                    name: '' /*especie String*/,
                };

                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentRecord = $scope.currentRecord;

                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(context, currentRecord)
                            .then(function () {
                                // $http.post es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('animalesList');
                            });

                    // si el id no es null, es un registro existente entonces lo actualiza
                } else {

                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                            .then(function () {
                                // $http.put es una promesa
                                // cuando termine bien, cambie de estado
                                $state.go('animalesList');
                            });
                }
                ;
            };

            this.deleteRecord = function (id) {
                $http.delete(context + "/" + id);
                $state.reload('animalesList');

            };

// Código continua con las funciones de despliegue de errores


        }]);
})(window.angular);

