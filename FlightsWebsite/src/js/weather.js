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
        case 4:
            displayGraphsAllTemperatureAttributes();
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
            showColumnGraph("chartContainer", "Weather observations per origin", "Number of observations", "Origins", processedData);
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
                showScatterGraph("chartContainer", "Temperatures at JFK", "Temperature in Celsius", processedData, false);
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
                showScatterGraph("chartContainer", "Daily mean temperature", "Daily mean in Celsius", processedData, true);
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
                showLineGraph("chartContainer", "Daily mean temperature at JFK", "Daily mean in Celsius", processedData);
            } else {
                return Promise.reject(new Error("No data"));
            }
        }).catch(function (error) {
        console.error('Request failed', error);
    });
}

function displayGraphsAllTemperatureAttributes() {
    fetch(weatherUrl + '/getAllTemperatureAttributes')
        .then(status)
        .then(json)
        .then(function (data) {
            if (data != null && data.length > 0) {
                let processedDataTemp = [];
                let processedDataDewp = [];
                for (let row of data) {
                    if (processedDataTemp[row.origin] == null) {
                        processedDataTemp[row.origin] = [];
                    }
                    if (processedDataDewp[row.origin] == null) {
                        processedDataDewp[row.origin] = [];
                    }
                    processedDataTemp[row.origin].push({x: new Date(row.timestamp), y: row.temperature});
                    processedDataDewp[row.origin].push({x: new Date(row.timestamp), y: row.dewPoint});
                }
                showSplineGraph("chartContainer", "Temperatures at origins", "Temperature in Celsius", processedDataTemp);
                showSplineGraph("chartContainer2", "Dew points at origins", "Dew point in Celsius", processedDataDewp);
            } else {
                return Promise.reject(new Error("No data"));
            }
        }).catch(function (error) {
        console.error('Request failed', error);
    });
}

function showColumnGraph(graphId, title, titleY, titleX, data) {

    let chart = new CanvasJS.Chart(graphId, {
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

function showScatterGraph(graphId, title, titleY, data, hasMeanValues) {
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

    let chart = new CanvasJS.Chart(graphId, {
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

function showLineGraph(graphId, title, titleY, data) {
    let chart = new CanvasJS.Chart(graphId, {
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

function showSplineGraph(graphId, title, titleY, data) {
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
            type: "spline",
            name: origin,
            showInLegend: true,
            xValueFormatString: "DD MMM YY (h TT)",
            yValueFormatString: "0.00",
            toolTipContent: "<span><b>Origin: {name}</b></span><br/><b> Time:</b> {x} <br/><b> Temperature:</b> {y} °C",
            color: colorSet.legend,
            dataPoints: data[origin]
        });
    }
    if (minX != null) minX.setMonth(minX.getMonth() - 1);
    if (maxX != null) maxX.setMonth(maxX.getMonth() + 1);

    let chart = new CanvasJS.Chart(graphId, {
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
        legend: {
            cursor: "pointer",
            itemclick: function (e) {
                if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                } else {
                    e.dataSeries.visible = true;
                }
                e.chart.render();
            }
        },
        data: graphData
    });
    chart.render();
}