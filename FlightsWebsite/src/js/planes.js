function selectedPlanes() {
    const option = document.getElementById("planes");

    switch (option.selectedIndex) {
        case 0:
            break;
        case 1:
            console.log("Planes 1 selected")
            getCountOfAirbusPlanesByModel()
            break;
        case 2:
            break;
        case 3:
            break;
        case 4:
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