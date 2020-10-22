var app = (function () {

    var lati;
    var longi;

    function initMap() {
        const uluru = {lat: lati, lng: longi};
        const map = new google.maps.Map(document.getElementById("map"), {
            zoom: 8,
            center: uluru,
        });
        const marker = new google.maps.Marker({
            position: uluru,
            map: map,
        });
    }

    function table(datos) {
        if (datos == null) {
            return new Error("No se encontro");
        }
        var clima = JSON.parse(datos);

        lati = clima.coord.lat;
        longi = clima.coord.lon;

        var fila = `<tr class="bg-success"><td id="Nombre"> ${clima.name} </td><td id="pais">${clima.sys.country} </td><td id="vientos"> ${clima.wind.speed} km/h</td><td id="tempMin">${Math.round(clima.main.temp_min - 273.15)} °C</td><td id="tempMax">${Math.round(clima.main.temp_max - 273.15)} °C</td><td id="weather"> ${clima.weather[0].main}</td> </tr>`;
        $("#t01  tbody").append(fila);

    initMap();
    }
    return {
        getWeatherByName: function getDatos(nombre) {
            apiclient.getWeatherByName(nombre, table);
        }
    };
})();