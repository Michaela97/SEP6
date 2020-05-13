function selectedWeather() {
    const option = document.getElementById("weather");
    switch (option.selectedIndex) {
        case 5:
            displayGraphNoOfObservationsPerOrigin();
            break;
        default:
            console.log("Selected dropdown in weather:" + option.selectedIndex)
    }

}

function displayGraphNoOfObservationsPerOrigin() {
    fetch('http://localhost:8080/weather/getNumberOfWeatherObservationsByOrigin')
        .then(status)
        .then(json)
        .then(function (data) {
            let processedData = [];
            for (let row of data) {
                processedData.push({
                    label: row.origin,
                    y: row.countOfObservations
                });
            }
            showColumnGraph("Weather observations per origin","Number of observations","Origins",processedData);
        }).catch(function (error) {
        console.error('Request failed', error);
    });
}

function status(response) {
    if (response.status >= 200 && response.status < 300) {
        return Promise.resolve(response)
    } else {
        return Promise.reject(new Error(response.statusText))
    }
}

function json(response) {
    return response.json()
}

function showColumnGraph(title, titleY, titleX, data) {

    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: title
        },
        axisY: {
            title: titleY,
            titleFontSize: 24
        },
        data: [{
            type: "column",
            showInLegend: true,
            legendMarkerColor: "grey",
            legendText: titleX,
            dataPoints: data
        }]
    });
    chart.render();
}