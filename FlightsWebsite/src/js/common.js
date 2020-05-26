const url = 'https://flights-service-buki55n7ba-lz.a.run.app';
// const url = 'http://localhost:8080';
const flightsUrl = url + '/flights'
const weatherUrl = url + '/weather'
const planesUrl = url + '/planes'

let chartContainer = document.getElementById("chartContainer");
let chartContainer2 = document.getElementById("chartContainer2");
let chartContainer3 = document.getElementById("chartContainer3");

let flightsSelect = document.getElementById('flights');
let weatherSelect = document.getElementById('weather');
let planesSelect = document.getElementById('planes');

init();

function toggleGraph(disabled, chart) {

    if (disabled === true) {
        //hide chart
        chart.style.display = "none";
    } else {
        //show chart
        chart.style.display = "block";
    }
}

function init() {
    toggleGraph(true, chartContainer);
    toggleGraph(true, chartContainer2);
    toggleGraph(true, chartContainer3);
}

function updateContainers(element) {
    resetSelects(element.id);
    switch (element.id) {
        case 'flights':
            handleFlightsChange(element.selectedIndex);
            break;
        case 'weather':
            handleWeatherChange(element.selectedIndex);
            break;
        case 'planes':
            handlePlanesChange(element.selectedIndex)
            break;
    }
}

function resetSelects(elementId) {
    switch(elementId) {
        case 'flights':
            weatherSelect.selectedIndex = 0;
            planesSelect.selectedIndex = 0;
            break;
        case 'weather':
            flightsSelect.selectedIndex = 0;
            planesSelect.selectedIndex = 0;
            break;
        case 'planes':
            flightsSelect.selectedIndex = 0;
            weatherSelect.selectedIndex = 0;
            break;
    }
}

function handleFlightsChange(selectedIndex) {
    switch (selectedIndex) {
        case 2:
            toggleGraph(false, chartContainer3);
            toggleGraph(false, chartContainer);
            toggleGraph(false, chartContainer2);
            break;
        default:
            toggleGraph(false, chartContainer);
            toggleGraph(true, chartContainer3);
            toggleGraph(true, chartContainer2);
            break;
    }
}

function handleWeatherChange(selectedIndex) {
    switch (selectedIndex) {
        default:
            toggleGraph(false, chartContainer);
            toggleGraph(true, chartContainer3);
            toggleGraph(true, chartContainer2);
            break;
    }
}

function handlePlanesChange(selectedIndex) {
    switch (selectedIndex) {
        default:
            toggleGraph(false, chartContainer);
            toggleGraph(true, chartContainer3);
            toggleGraph(true, chartContainer2);
            break;
    }
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