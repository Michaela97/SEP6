//import Converter from "./monthConventer";
const url = 'https://flights-service-buki55n7ba-lz.a.run.app/flights/';

function getTotalFlights() {

    fetch(url + 'getTotalNumberOfFlights')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];
            data.forEach(element => {
                result.push({ y: element.countOfFlights, label: convertMonth(element.month)});
                }
            )
            showTotalFlights(result)
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

function showTotalFlights(data) {

    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        title:{
            text: "Months"
        },
        axisY: {
            title: "Total number of flights",
            interval: 5000
        },
        axisX: {
            interval: 1
        },
        data: [{
            type: "column",
            showInLegend: true,
            legendMarkerColor: "grey",
            legendText: "total number of flights per month",
            dataPoints: data
        }]
    });
    chart.render();
}

function selectedFlight() {

    const option = document.getElementById("flights");
    let flightOption = option.options[option.selectedIndex].value;

    if (flightOption == 1) {
        getTotalFlights();
    }
}

function convertMonth(month) {

    switch (month) {
        case 1:
            return "January"
        case 2:
            return "February"
        case 3:
            return "March"
        case 4:
            return "April"
        case 5:
            return "May"
        case 6:
            return "June"
        case 7:
            return "July"
        case 8:
            return "August"
        case 9:
            return "September"
        case 10:
            return "October"
        case 11:
            return "November"
        case 12:
            return "December"
        default:
            return "This is not a valid month"
    }
}



