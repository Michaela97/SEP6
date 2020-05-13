//import Converter from "./monthConventer";
const url = 'https://flights-service-buki55n7ba-lz.a.run.app/flights/';

function getTotalFlights() {

    fetch(url + 'getTotalNumberOfFlights')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];
            data.forEach(element => {
                    result.push({y: element.countOfFlights, label: convertMonth(element.month)});
                }
            )

            showTotalFlights(result)

        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

async function getFlightsFromOrigins() {

    let resultLGA = [];
    let resultJFK = [];
    let resultEWR = [];

    await fetch("http://localhost:8080/flights/" + 'getTotalNumberOfFlightsFromLGA')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultLGA.push({y: element.countOfFlights, label: convertMonth(element.month)});
                }
            )
            console.log(resultLGA)

        }).catch(function (error) {
        console.log('Request failed', error);
    });

    await fetch("http://localhost:8080/flights/" + 'getTotalNumberOfFlightsFromJFK')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultJFK.push({y: element.countOfFlights, label: convertMonth(element.month)});
                }
            )

        }).catch(function (error) {
        console.log('Request failed', error);
    });

    await fetch("http://localhost:8080/flights/" + 'getTotalNumberOfFlightsFromEWR')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultEWR.push({y: element.countOfFlights, label: convertMonth(element.month)});
                }
            )
        }).catch(function (error) {
        console.log('Request failed', error);
    });

    showTotalFlightsFromOrigins(resultLGA, resultJFK, resultEWR);

}

function getTopTenDestinations() {

    fetch("http://localhost:8080/flights/" + 'getTopTenDestinations')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];

            data.forEach(element => {
                    result.push({y: element.countOfFlights, label: element.destination});
                }
            )

            showTopDestinations(result)

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
        title: {
            text: "Total number of flights per month"
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
            legendText: "Month",
            dataPoints: data
        }]
    });
    chart.render();
}

function showTopDestinations(data) {

    let chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2", // "light1", "light2", "dark1", "dark2"
        exportEnabled: true,
        animationEnabled: true,
        title: {
            text: "Top 10 Destinations"
        },
        data: [{
            type: "pie",
            startAngle: 25,
            toolTipContent: "<b>{label}</b> : {y} flights",
            showInLegend: "true",
            legendText: "{label}",
            indexLabelFontSize: 16,
            indexLabel: "{label}",
            dataPoints: data
        }]
    });
    chart.render();
}

function showTotalFlightsFromOrigins(dataLGA, dataJFK, dataEWR) {

    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Total number of flights per month from three origins"
        },
        axisY: {
            title: "Total number of flights",
            interval: 1000
        },
        axisX: {
            interval: 1
        },
        toolTip: {
            shared: true
        },
        legend: {
            fontSize: 13
        },
        data: [{
            type: "splineArea",
            showInLegend: true,
            name: "origin LGA",
            yValueFormatString: "$#,##0",
            dataPoints: dataLGA
        },
            {
                type: "splineArea",
                showInLegend: true,
                name: "origin EWR",
                yValueFormatString: "$#,##0",
                dataPoints: dataEWR
            },
            {
                type: "splineArea",
                showInLegend: true,
                name: "origin JFK",
                yValueFormatString: "$#,##0",
                dataPoints: dataJFK
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
    if (flightOption == 2) {
        getFlightsFromOrigins();
    }
    if (flightOption == 4) {
        getTopTenDestinations();
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



