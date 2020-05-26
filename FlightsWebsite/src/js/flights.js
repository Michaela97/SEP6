function selectedFlight() {
    const option = document.getElementById("flights");
    let flightOption = option.options[option.selectedIndex].value;

    switch(option.selectedIndex) {
        case 1:
            getTotalFlights();
            break;
        case 2:
            getFlightsFromOrigins();
            break;
        case 3:
            getFlightsByManufacturer();
            break;
        case 4:
            getTopTenDestinations();
            break;
        default:
            console.log(`Selected unhandled value ${option.selectedIndex}`)

    }
}

function getTotalFlights() {
    fetch(flightsUrl + '/getTotalNumberOfFlights')
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

    let promiseLGA =  fetch(flightsUrl + '/getTotalNumberOfFlightsFromLGA')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultLGA.push({y: element.countOfFlights, label: convertMonth(element.month)});
                }
            )

        }).catch(function (error) {
            console.log('Request failed', error);
        });

    let promiseJFK =  fetch(flightsUrl + '/getTotalNumberOfFlightsFromJFK')
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

    let promiseEWR = fetch(flightsUrl + '/getTotalNumberOfFlightsFromEWR')
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

    // Make calls asynchronously and await them here, so that they actually are async, not sync
    await promiseLGA;
    await promiseJFK;
    await promiseEWR;

    showFlightsFromOrigins(resultLGA, resultJFK, resultEWR);
    showFlightsFromOriginsPercentage(resultLGA, resultJFK, resultEWR);
    showFlightsFromOriginsStacked(resultLGA, resultJFK, resultEWR);
}

async function getTopTenDestinations() {
    let resultLGA = [];
    let resultJFK = [];
    let resultEWR = [];

    let promiseLGA =  fetch(flightsUrl + '/getTopTenDestinationsFromLGA')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultLGA.push({y: element.countOfFlights, label: element.destination});
                }
            )

        }).catch(function (error) {
            console.log('Request failed', error);
        });

    let promiseJFK = fetch(flightsUrl + '/getTopTenDestinationsFromJFK')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultJFK.push({y: element.countOfFlights, label: element.destination});
                }
            )

        }).catch(function (error) {
            console.log('Request failed', error);
        });

    let promiseEWR = fetch(flightsUrl + '/getTopTenDestinationsFromEWR')
        .then(status)
        .then(json)
        .then(function (data) {

            data.forEach(element => {
                    resultEWR.push({y: element.countOfFlights, label: element.destination});
                }
            )

        }).catch(function (error) {
            console.log('Request failed', error);
        });

    await promiseLGA;
    await promiseJFK;
    await promiseEWR;

    showTopDestinations(resultLGA, resultJFK, resultEWR);
}

function getFlightsByManufacturer() {
    fetch(flightsUrl + '/getFlightsByManufacturer')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];
            data.forEach(element => {
                    result.push({y: element.countOfFlights, label: element.manufacturer});
                }
            )
            showFlightsByManufacturer(result)

        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function showTotalFlights(data) {
    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Total number of flights per month"
        },
        axisY: {
            title: "Total number of flights",
            interval: 2500
        },
        axisX: {
            title: "Month",
            interval: 1
        },
        data: [{
            type: "column",
            yValueFormatString: "#,##0' flights'",
            legendMarkerColor: "grey",
            dataPoints: data
        }]
    });
    chart.render();
}

function showFlightsFromOrigins(dataLGA, dataJFK, dataEWR) {
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
        axisY2: {
            interval: 1000
        },
        toolTip: {
            shared: true
        },
        legend: {
            cursor: "pointer",
        },
        data: [{
            type: "column",
            name: "origin LGA",
            yValueFormatString: "#,##0' flights'",
            legendText: "origin EWR",
            showInLegend: true,
            dataPoints: dataEWR
        },
            {
                type: "column",
                name: "origin EWR",
                legendText: "origin JFK",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints: dataJFK
            },
            {
                type: "column",
                name: "origin JFK",
                legendText: "origin LGA",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints: dataLGA
            }]
    });
    chart.render();
}

function showFlightsFromOriginsPercentage(dataLGA, dataJFK, dataEWR) {
    let chart = new CanvasJS.Chart("chartContainer3", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Total number of flights per month - stacked percentage"
        },
        axisX: {
            interval: 1,
        },
        axisY: {
            title: "Total number of flights",
            suffix: "%"
        },
        toolTip: {
            shared: true
        },
        data: [{
            type: "stackedColumn100",
            name: "origin EWR",
            showInLegend: true,
            yValueFormatString: "#,##0' flights'",
            dataPoints: dataEWR
        },
            {
                type: "stackedColumn100",
                name: "origin LGA",
                showInLegend: true,
                yValueFormatString: "#,##0' flights'",
                dataPoints: dataLGA
            },
            {
                type: "stackedColumn100",
                name: "origin JFK",
                showInLegend: true,
                yValueFormatString: "#,##0' flights'",
                dataPoints: dataJFK
            }]
    });
    chart.render();
}

function showFlightsFromOriginsStacked(dataLGA, dataJFK, dataEWR) {
    let chart = new CanvasJS.Chart("chartContainer2", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Total number of flights per month - stacked",
        },
        axisX: {
            interval: 1,
        },
        axisY: {
            interval: 2500,
            title: "Total number of flights",
        },
        toolTip: {
            shared: true,
        },
        data: [{
            type: "stackedColumn",
            showInLegend: true,
            yValueFormatString: "#,##0' flights'",
            name: "origin EWR",
            dataPoints: dataEWR
        },
            {
                type: "stackedColumn",
                showInLegend: true,
                yValueFormatString: "#,##0' flights'",
                name: "origin LGA",
                dataPoints: dataLGA
            },
            {
                type: "stackedColumn",
                showInLegend: true,
                yValueFormatString: "#,##0' flights'",
                name: "origin JFK",
                dataPoints: dataJFK
            }]
    });
    chart.render();
}

function showFlightsByManufacturer(data) {
    let chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2",
        animationEnabled: true,
        title: {
            text: "The number of flights each manufacturer with more than 200 planes are responsible for"
        },
        data: [{
            type: "pie",
            startAngle: 25,
            toolTipContent: "<b>{label}</b> manufacturer : {y} flights",
            showInLegend: true,
            legendText: "{label}",
            indexLabelFontSize: 16,
            indexLabel: "{y}",
            indexLabelPlacement: "inside",
            dataPoints: data
        }]
    });
    chart.render();
}

function showTopDestinations(dataLGA, dataJFK, dataEWR) {
    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Top 10 Destinations"
        },
        axisY: {
            title: "Total number of flights",
            interval: 1000
        },
        axisX: {
            title: "Destination",
            interval: 1
        },
        axisY2: {
            interval: 1000
        },
        toolTip: {
            shared: true
        },
        legend: {
            cursor: "pointer",
        },
        data: [{
            type: "column",
            name: "origin LGA",
            legendText: "origin LGA",
            yValueFormatString: "#,##0' flights'",
            showInLegend: true,
            dataPoints: dataLGA
        },

            {
                type: "column",
                name: "origin JFK",
                legendText: "origin JFK",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints: dataJFK
            },
            {
                type: "column",
                name: "origin EWR",
                legendText: "origin EWR",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints: dataEWR
            }]
    });
    chart.render();
}










