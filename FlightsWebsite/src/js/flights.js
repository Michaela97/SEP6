
const url = 'https://flights-service-buki55n7ba-lz.a.run.app/flights/';

function getFlights() {

    fetch(url + 'getTotalNumberOfFlights')
        .then(status)
        .then(json)
        .then(function (data) {
            // document.getElementById("myText").innerHTML = responseData;
            console.log(data);

        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function status(response) {
    if (response.status >= 200 && response.status < 300) {
        return Promise.resolve(response)
    } else {
        console.log("response code: " + response.status)
        return Promise.reject(new Error(response.statusText))
    }
}

function json(response) {
    return response.json()
}