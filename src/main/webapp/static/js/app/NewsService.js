'use strict';

angular.module('myApp').factory('NewsService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8083/news-management/api/news/';

    var factory = {
        fetchAllNews: fetchAllNews,
        createNews: createNews,
        updateNews: updateNews,
        deleteNewsList: deleteNewsList
    };

    return factory;

    function fetchAllNews() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createNews(news) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: REST_SERVICE_URI,
            data: JSON.stringify(news),
            headers: {"Content-Type": "application/json"}
        })/*.post(REST_SERVICE_URI, news)*/
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function updateNews(news) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI, news)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function deleteNewsList(newsRemoveList) {
        var deferred = $q.defer();
        $http.patch(REST_SERVICE_URI, newsRemoveList)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
}]);