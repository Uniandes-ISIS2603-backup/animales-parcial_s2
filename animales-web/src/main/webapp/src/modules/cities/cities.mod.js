(function (ng) {
var mod = ng.module("animalesModule", []);
    mod.constant("animalesContext", "api/animales");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/animales/';
            $urlRouterProvider.otherwise("/animalesList");

            $stateProvider.state('animalesList', {
                url: '/animales',
                views: {
                    'mainView': {
                        controller: 'animalesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'animales.list.html'
                    }
                }
            }).state('animalCreate', {
                url: '/animales/create',
                views: {
                    'mainView': {
                        controller: 'animalesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'animales.create.html'
                    }
                }

            }).state('animalEdit', {
                url: '/animales/:animalId',
                param: {
                    animalId: null
                },
                views: {
                    'mainView': {
                        controller: 'animalesCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'animales.create.html'
                    }
                }
            });
        }]);

})(window.angular);

