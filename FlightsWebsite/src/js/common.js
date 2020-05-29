const url = 'https://flights-service-buki55n7ba-lz.a.run.app';
// const url = 'http://localhost:8080';
const flightsUrl = url + '/flights'
const weatherUrl = url + '/weather'
const planesUrl = url + '/planes'

let hintContainer = document.getElementById("hint");
let chartContainer = document.getElementById("chartContainer");
let chartContainer2 = document.getElementById("chartContainer2");
let chartContainer3 = document.getElementById("chartContainer3");

let flightsSelect = document.getElementById('flights');
let weatherSelect = document.getElementById('weather');
let planesSelect = document.getElementById('planes');

let spinner = document.getElementById('spinner');

let hintContainerIsDisabled;
let chartContainerIsDisabled;
let chartContainer2IsDisabled;
let chartContainer3IsDisabled;

init();

function toggleDiv(disabled, div) {

    if (disabled === true) {
        //hide div
        div.style.display = "none";
    } else {
        //show div
        div.style.display = "block";
    }
}

function init() {
    toggleDiv(true, hintContainer);
    toggleDiv(true, chartContainer);
    toggleDiv(true, chartContainer2);
    toggleDiv(true, chartContainer3);
    saveChartsState();

    wakeUpCall();
    hideSpinner();
}

function wakeUpCall() {
    fetch(flightsUrl + '/getTotalNumberOfFlights')
        .catch(function (error) {
            console.log('Wake up request failed, service unavailable', error);
        });
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
    switch (elementId) {
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
    toggleDiv(true, hintContainer);
    switch (selectedIndex) {
        case 2:
            toggleDiv(false, chartContainer3);
            toggleDiv(false, chartContainer);
            toggleDiv(false, chartContainer2);
            break;
        default:
            toggleDiv(false, chartContainer);
            toggleDiv(true, chartContainer3);
            toggleDiv(true, chartContainer2);
            break;
    }
}

function handleWeatherChange(selectedIndex) {
    switch (selectedIndex) {
        case 1:
            toggleDiv(false, hintContainer);
            toggleDiv(false, chartContainer);
            toggleDiv(true, chartContainer2);
            toggleDiv(true, chartContainer3);
            break;
        case 4:
            toggleDiv(false, hintContainer);
            toggleDiv(false, chartContainer);
            toggleDiv(false, chartContainer2);
            toggleDiv(true, chartContainer3);
            break;
        default:
            toggleDiv(true, hintContainer);
            toggleDiv(false, chartContainer);
            toggleDiv(true, chartContainer3);
            toggleDiv(true, chartContainer2);
            break;
    }
}

function handlePlanesChange(selectedIndex) {
    toggleDiv(true, hintContainer);
    switch (selectedIndex) {
        default:
            toggleDiv(false, chartContainer);
            toggleDiv(true, chartContainer3);
            toggleDiv(true, chartContainer2);
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

function convertMinute(minuteValue) {
    let decimalValue = Math.abs(Math.round(((minuteValue % 1) * 100) / 100 * 60));
    let wholePart = minuteValue | 0;
    let minus = minuteValue < 0 ? '-' : '';
    return minus + wholePart + ":" + padDigits(decimalValue, 2);
}

function padDigits(number, digits) {
    return Array(Math.max(digits - String(number).length + 1, 0)).join(0) + number;
}

function showSpinner() {
    saveChartsState();
    hideCharts();
    spinner.style.display = "block";
}

function hideSpinner() {
    restoreChartsState();
    showCharts();
    spinner.style.display = "none";
}

function saveChartsState() {
    hintContainerIsDisabled = hintContainer.style.display === "none"
    chartContainerIsDisabled = chartContainer.style.display === "none"
    chartContainer2IsDisabled = chartContainer2.style.display === "none"
    chartContainer3IsDisabled = chartContainer3.style.display === "none"
}

function restoreChartsState() {
    hintContainer.style.display = hintContainerIsDisabled ? "none" : "block"
    chartContainer.style.display = chartContainerIsDisabled ? "none" : "block"
    chartContainer2.style.display = chartContainer2IsDisabled ? "none" : "block"
    chartContainer3.style.display = chartContainer3IsDisabled ? "none" : "block"
}

function hideCharts() {
    toggleDiv(true, hintContainer);
    toggleDiv(true, chartContainer);
    toggleDiv(true, chartContainer2);
    toggleDiv(true, chartContainer3);
}

function showCharts() {
    toggleDiv(hintContainerIsDisabled, hintContainer);
    toggleDiv(chartContainerIsDisabled, chartContainer);
    toggleDiv(chartContainer2IsDisabled, chartContainer2);
    toggleDiv(chartContainer3IsDisabled, chartContainer3);
}