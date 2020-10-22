const apiUrl = "https://villamil-arsw-t2.herokuapp.com/weatherfinder/"
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