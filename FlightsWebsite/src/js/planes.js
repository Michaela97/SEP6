function selectedPlanes() {
    const option = document.getElementById("planes");

    switch (option.selectedIndex) {
        case 0:
            break;
        case 1:
            getCountOfAirbusPlanesByModel();
            break;
        case 2:
            manufacturersWithPlanes();
            break;
        case 3:
            meanDepartureAndArrivalDelay();
            break;
        case 4:
            meanAirtimeByOrigin();
            break;
        default:
            break;
    }
}

function getCountOfAirbusPlanesByModel() {
    fetch(planesUrl + '/countOfAirbusPlanesByModelList')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];

            data.forEach(element => {
                    result.push({y: element.numberOfPlanes, label: element.model});
                }
            )
            showNumberOfPlanes(result)

        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function showNumberOfPlanes(data) {
    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "The number of planes of each Airbus Model"
        },
        axisY: {
            title: "Number of planes",
        },
        axisX: {
            title: "Model",
            interval: 1
        },
        data: [{
            type: "column",
            yValueFormatString: "# planes",
            legendMarkerColor: "grey",
            dataPoints: data
        }]
    });
    chart.render();
}

function manufacturersWithPlanes() {
    fetch(planesUrl + '/getManufacturersWithMoreThanTwoHundredPlanes')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];

            data.forEach(element => {
                    result.push({y: element.countOfPlanes, label: element.manufacturer});
                }
            )
            showManufacturersWithPlanes(result)

        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function showManufacturersWithPlanes(data) {
    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Manufacturers that have more than 200 planes"
        },
        axisY: {
            title: "Number of planes",
        },
        axisX: {
            title: "Manufacturer",
            interval: 1
        },
        data: [{
            type: "column",
            yValueFormatString: "# planes",
            legendMarkerColor: "grey",
            dataPoints: data
        }]
    });
    chart.render();
}

async function meanDepartureAndArrivalDelay() {

    let departurePromise = fetch(flightsUrl + '/getMeanDepartureDelay')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];

            data.forEach(element => {
                    result.push({y: element.minutes, label: element.origin});
                }
            )
            return result;

        }).catch(function (error) {
            console.log('Request failed', error);
        });

    let arrivalPromise = fetch(flightsUrl + '/getMeanArrivalDelay')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];

            data.forEach(element => {
                    result.push({y: element.minutes, label: element.origin});
                }
            )
            return result;

        }).catch(function (error) {
            console.log('Request failed', error);
        });

    let departureData = await departurePromise;
    let arrivalData = await arrivalPromise;

    showMeanDelays(departureData, arrivalData);
}

function showMeanDelays(departureData, arrivalData) {
    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "Mean departure and arrival delay for origins"
        },
        axisY: {
            title: "Delay in minutes",
            interval: 1,
            minimum: -1,
            maximum: 12
        },
        axisY2: {
            interval: 1,
            minimum: -1,
            maximum: 12
        },
        axisX: {
            title: "Origins",
            interval: 1
        },
        toolTip: {
            shared: true,
            contentFormatter: function ( e ) {
                let label = e.entries[0].dataPoint.label
                return label + "<br>"
                    + "Departure delay: " + convertMinute(e.entries[0].dataPoint.y) + " minutes <br>"
                    + "Arrival delay: " + convertMinute(e.entries[1].dataPoint.y) + " minutes ";
            }
        },
        legend: {
            cursor: "pointer",
        },
        data: [{
            type: "column",
            name: "departure",
            legendText: "Departure delay",
            showInLegend: true,
            dataPoints: departureData
        },
            {
                type: "column",
                name: "arrival",
                legendText: "Arrival delay",
                showInLegend: true,
                dataPoints: arrivalData
            }]
    });
    chart.render();
}

function meanAirtimeByOrigin() {
    fetch(flightsUrl + '/getMeanAirtime')
        .then(status)
        .then(json)
        .then(function (data) {

            let result = [];

            data.forEach(element => {
                    result.push({y: element.meanAirtime, label: element.origin});
                }
            )
            showAirtimeByOrigins(result)

        }).catch(function (error) {
        console.log('Request failed', error);
    });
}

function showAirtimeByOrigins(data) {
    let chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        theme: "light2",
        title: {
            text: "The mean airtime of each of the origins"
        },
        axisY: {
            title: "Airtime in minutes",
        },
        axisX: {
            title: "Origins",
            interval: 1
        },
        data: [{
            type: "column",
            yValueFormatString: "# minutes",
            legendMarkerColor: "grey",
            dataPoints: data
        }]
    });
    chart.render();
}
