function selectedWeather() {
    const option = document.getElementById("weather");
    switch (option.selectedIndex) {
        case 1:
            displayGraphDailyMeanPerOrigin();
            break;
        case 2:
            displayGraphDailyMeanAtJFK();
            break;
        case 3:
            displayGraphTemperaturesAtJFK();
            break;
        case 5:
            displayGraphNoOfObservationsPerOrigin();
            break;
        default:
            console.log("Selected dropdown in weather:" + option.selectedIndex)
    }
}

function displayGraphNoOfObservationsPerOrigin() {
    showSpinner();
    fetch(weatherUrl + '/getNumberOfWeatherObservationsByOrigin')
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
            hideSpinner();
            showColumnGraph("Weather observations per origin", "Number of observations", "Origins", processedData);
        }).catch(function (error) {
        console.error('Request failed', error);
    });
}

function displayGraphTemperaturesAtJFK() {
    showSpinner();
    fetch(weatherUrl + '/getTemperaturesAtJFK')
        .then(status)
        .then(json)
        .then(function (data) {
            if (data != null && data.length > 0) {
                let processedData = [];
                for (let row of data) {
                    if (processedData[row.origin] == null) {
                        processedData[row.origin] = [];
                    }
                    processedData[row.origin].push({x: new Date(row.timestamp), y: row.temperature});
                }
                hideSpinner();
                showScatterGraph("Temperatures at JFK", "Temperature in Celsius", processedData, false);
            } else {
                return Promise.reject(new Error("No data"));
            }
        }).catch(function (error) {
        console.error('Request failed', error);
    });
}

function displayGraphDailyMeanPerOrigin() {
    showSpinner();
    fetch(weatherUrl + '/getDailyTemperatureMeanByOrigin')
        .then(status)
        .then(json)
        .then(function (data) {
            if (data != null && data.length > 0) {
                let processedData = [];
                for (let row of data) {
                    if (processedData[row.origin] == null) {
                        processedData[row.origin] = [];
                    }
                    processedData[row.origin].push({x: new Date(row.timestamp), y: row.temperature});
                }
                hideSpinner();
                showScatterGraph("Daily mean temperature", "Daily mean in Celsius", processedData, true);
            } else {
                return Promise.reject(new Error("No data"));
            }
        }).catch(function (error) {
        console.error('Request failed', error);
    });
}

function displayGraphDailyMeanAtJFK() {
    showSpinner();
    fetch(weatherUrl + '/getDailyTemperatureMeanAtJFK')
        .then(status)
        .then(json)
        .then(function (data) {
            if (data != null && data.length > 0) {
                let processedData = [];
                for (let row of data) {
                    processedData.push({x: new Date(row.timestamp), y: row.temperature});
                }
                hideSpinner();
                showLineGraph("Daily mean temperature at JFK", "Daily mean in Celsius", processedData);
            } else {
                return Promise.reject(new Error("No data"));
            }
        }).catch(function (error) {
        console.error('Request failed', error);
    });
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

function showScatterGraph(title, titleY, data, hasMeanValues) {
    let colors = [
        {legend: "rgba(250,300,0,0.8)", marker: "rgba(250,300,0,0.2)"},
        {legend: "rgba(120,10,158,0.8)", marker: "rgba(120,10,158,0.2)"},
        {legend: "rgba(0,148,158,0.8)", marker: "rgba(0,148,158,0.2)"}];

    let minX = null;
    let maxX = null;
    let graphData = [];
    for (let origin in data) {
        if (minX == null || data[origin][0].x < minX.toString()) {
            minX = new Date(data[origin][0].x);
        }
        if (maxX == null || data[origin][0].x > maxX.toString()) {
            maxX = new Date(data[origin][data[origin].length - 1].x);
        }

        let colorSet = colors.pop();
        graphData.push({
            type: "scatter",
            name: origin,
            showInLegend: true,
            legendMarkerColor: colorSet.legend,
            xValueFormatString: hasMeanValues ? "DD MMM YY" : "DD MMM YY (h TT)",
            yValueFormatString: "0.00",
            toolTipContent: "<span><b>Origin: {name}</b></span><br/><b> Time:</b> {x} <br/><b> Temperature:</b> {y} °C",
            markerSize: 5,
            markerBorderColor: colorSet.legend,
            markerColor: "transparent",
            markerBorderThickness: 1,
            dataPoints: data[origin]
        });
    }
    if (minX != null) minX.setMonth(minX.getMonth() - 1);
    if (maxX != null) maxX.setMonth(maxX.getMonth() + 1);

    let chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2",
        animationEnabled: true,
        title: {
            text: title
        },
        axisY: {
            title: titleY
        },
        axisX: {
            minimum: minX,
            maximum: maxX
        },
        data: graphData
    });
    chart.render();
}

function showLineGraph(title, titleY, data) {
    let chart = new CanvasJS.Chart("chartContainer", {
        theme: "light2",
        animationEnabled: true,
        title: {
            text: title
        },
        axisY: {
            title: titleY
        },
        axisX: {
            minimum: new Date(data[0].x).setMonth(data[0].x.getMonth() - 1),
            maximum: new Date(data[data.length - 1].x).setMonth(data[data.length - 1].x.getMonth() + 1)
        },
        data: [{
            type: "spline",
            name: origin,
            yValueFormatString: "0.00",
            toolTipContent: "<span><b>Origin: JFK</b></span><br/><b> Date:</b> {x} <br/><b> Temperature:</b> {y} °C",
            dataPoints: data
        }]
    });
    chart.render();
}