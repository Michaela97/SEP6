
const url = 'https://flights-service-buki55n7ba-lz.a.run.app/flights/';
const localUrl = 'http://localhost:8080/flights/';

let percentageChart = document.getElementById("percentageChartContainer");
let chartContainer = document.getElementById("chartContainer");
let stackedChartContainer = document.getElementById("stackedChartContainer");

init();

function init(){
    toggleGraph(true, percentageChart);
    toggleGraph(true, chartContainer);
    toggleGraph(true, stackedChartContainer);
}

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

    await fetch(url + 'getTotalNumberOfFlightsFromLGA')
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

    await fetch(url + 'getTotalNumberOfFlightsFromJFK')
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

    await fetch(url + 'getTotalNumberOfFlightsFromEWR')
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

    showFlightsFromOrigins(resultLGA, resultJFK, resultEWR);
    showFlightsFromOriginsPercentage(resultLGA, resultJFK, resultEWR);
    showFlightsFromOriginsStacked(resultLGA, resultJFK, resultEWR);
}

async function getTopTenDestinations() {

    let resultLGA = [];
    let resultJFK = [];
    let resultEWR = [];

    await fetch(url + 'getTopTenDestinationsFromLGA')
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

    await fetch(url + 'getTopTenDestinationsFromJFK')
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

    await fetch(url  + 'getTopTenDestinationsFromEWR')
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

    showTopDestinations(resultLGA, resultJFK, resultEWR);
}

function getFlightsByManufacturer() {

    fetch(url + 'getFlightsByManufacturer')
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
        title:{
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
            cursor:"pointer",
        },
        data: [{
            type: "column",
            name: "origin LGA",
            yValueFormatString: "#,##0' flights'",
            legendText: "origin EWR",
            showInLegend: true,
            dataPoints:dataEWR
        },
            {
                type: "column",
                name: "origin EWR",
                legendText: "origin JFK",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints:dataJFK
            },
            {
                type: "column",
                name: "origin JFK",
                legendText: "origin LGA",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints:dataLGA
            }]
    });
    chart.render();
}

function showFlightsFromOriginsPercentage(dataLGA, dataJFK, dataEWR) {

    let chart = new CanvasJS.Chart("percentageChartContainer", {
        animationEnabled: true,
        theme: "light2",
        title:{
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

    let chart = new CanvasJS.Chart("stackedChartContainer", {
        animationEnabled: true,
        theme: "light2",
        title:{
            text: "Total number of flights per month - stacked",
        },
        axisX: {
            interval: 1,
        },
        axisY:{
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
                dataPoints:dataLGA
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
        title:{
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
            cursor:"pointer",
        },
        data: [{
            type: "column",
            name: "origin LGA",
            legendText: "origin LGA",
            yValueFormatString: "#,##0' flights'",
            showInLegend: true,
            dataPoints:dataLGA
        },

            {
                type: "column",
                name: "origin JFK",
                legendText: "origin JFK",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints:dataJFK
            },
            {
                type: "column",
                name: "origin EWR",
                legendText: "origin EWR",
                axisYType: "secondary",
                yValueFormatString: "#,##0' flights'",
                showInLegend: true,
                dataPoints:dataEWR
            }]
    });
    chart.render();
}

function selectedFlight() {

    const option = document.getElementById("flights");
    let flightOption = option.options[option.selectedIndex].value;

    if (flightOption == 0) {
        init();
    }
    if (flightOption == 1) {
        toggleGraph(true, percentageChart);
        toggleGraph(false, chartContainer);
        toggleGraph(true, stackedChartContainer);
        getTotalFlights();
    }
    if (flightOption == 2) {
        toggleGraph(false, percentageChart);
        toggleGraph(false, chartContainer);
        toggleGraph(false, stackedChartContainer);
        getFlightsFromOrigins();
    }
    if (flightOption ==3) {
        toggleGraph(true, percentageChart);
        toggleGraph(false, chartContainer);
        toggleGraph(true, stackedChartContainer);
        getFlightsByManufacturer();
    }
    if (flightOption == 4) {
        toggleGraph(true, percentageChart);
        toggleGraph(false, chartContainer);
        toggleGraph(true, stackedChartContainer);
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

function toggleGraph(value, chart) {

    if (value === true) {
        //hide chart
        chart.style.display = "none";
    } else {
        //show chart
        chart.style.display = "block";
    }
}









