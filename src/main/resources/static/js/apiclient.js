const apiUrl = "http://localhost:8080/weatherfinder/"
apiclient = (function () {

    return {
        getWeatherByName: function (name, callback) {
            jQuery.ajax({
                url: apiUrl + name,
                success: function (result) {
                    callback(result);
                },
                async: true
            });
        }
    }

})();