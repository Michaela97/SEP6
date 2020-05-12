
var responseData = "test";


function fetchDataTest() {
    fetch('https://api.chucknorris.io/jokes/random')
    .then(status)
    .then(json)
    .then(function(data) {

        responseData = data['value'];
       // document.getElementById("myText").innerHTML = responseData;
        console.log(responseData)

    }).catch(function(error) {
    console.log('Request failed', error);
    });
}

function status(response) {
    if (response.status >= 200 && response.status < 300) {
      return Promise.resolve(response)
    } else {
      return Promise.reject(new Error(response.statusText))
    }
  }
  
function json(response) {
    return response.json()
}

function showGraph() {
    window.onload = function () {
    
        var chart = new CanvasJS.Chart("chartContainer", {
            animationEnabled: true,
            theme: "light2",
            title:{
                text: ""
            },
            axisY:{
                includeZero: false
            },
            data: [{        
                type: "line",       
                dataPoints: [
                    { y: 450 },
                    { y: 414},
                    { y: 520, indexLabel: "highest",markerColor: "red", markerType: "triangle" },
                    { y: 460 },
                    { y: 450 },
                    { y: 500 },
                    { y: 480 },
                    { y: 480 },
                    { y: 410 , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross" },
                    { y: 500 },
                    { y: 480 },
                    { y: 510 }
                ]
            }]
        });
        chart.render();
    }
}

showGraph();
fetchDataTest();