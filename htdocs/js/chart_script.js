//Chart.html
//execute the checkFile
window.setInterval(checkFile, 5000);
//Chart.html + File.html initialization
function getReady() {
    $(document).ready(function () {
        $(".button-collapse").sideNav();
        $('.tooltipped').tooltip();
        $('.tabs').tabs();
    });
}
function getEmptyData() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    document.getElementById("select").innerHTML = "<div class='collection container'><a href='#!' class='collection-item center'>No data to visualize</a></div>";
}
function getTempo() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "block";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/tempo/group", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    if (myObj[i][0] > 3) {
                        var ans = Math.sqrt(myObj[i][0], 2);
                    }
                    else {
                        ans = myObj[i][0];
                    }
                    datas.push(myObj[i][1]);
                    labels.push(ans);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ],
                };
                var ctx = $("#getTempo");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        },
                    }
                });
            }
        }
    }
}
function getTempoFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "block";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/tempo/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    if (myObj[i][0] > 3) {
                        var ans = Math.sqrt(myObj[i][0], 2);
                    }
                    else {
                        ans = myObj[i][0];
                    }
                    datas.push(myObj[i][1]);
                    labels.push(ans);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ],
                };
                var ctx = $("#getTempoFile");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        },
                    }
                });
            }
        }
    }
}
function getInstrument() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var xmlhttp, myObj, txt = "";
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/instrument/group", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (var i = 0; i < myObj.length; i++) {
                    txt += "<a href='#!' class='collection-item center'>" + myObj[i][0] + " with family: " + myObj[i][1] + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getNoteGroup() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "block";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var xmlhttp, myObj, labels = [], datas = [];
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/note/group", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][1]);
                    labels.push(myObj[i][0] + " " + myObj[i][2]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Note",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getNoteGroup");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false
                    }
                });
            }
        }
    }
}
function getNote() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "block";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var xmlhttp, myObj, labels = [], datas = [];
    xmlhttp = new XMLHttpRequest();
    //xmlhttp.open("GET", "http://localhost:8081/note/all", true);
    xmlhttp.open("GET", "http://localhost:8081/note/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][0]);
                    labels.push(myObj[i][1]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Note",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getNote");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false
                    }
                });
            }
        }
    }
}
function getNoteGroupFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "block";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var xmlhttp, myObj, labels = [], datas = [];
    xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/note/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][0]);
                    labels.push(myObj[i][1]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Note",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getNoteGroupFile");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                    }
                });
            }
        }
    }
}
function getNoteFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "block";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var xmlhttp, myObj, labels = [], datas = [];;
    xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/note/all/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][1]);
                    labels.push("Track:" + myObj[i][0] + " " + myObj[i][2]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Note",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getNoteFile");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                    }
                });
            }
        }
    }
}
function getMidi() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "block";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [], datas2 = [];
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/midi/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i].totrows);
                    datas2.push(myObj[i].nonstatrows);
                    labels.push(myObj[i].name);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Righe di statistica",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }, {
                            label: "Righe di non statistica",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas2
                        }
                    ],
                };
                var ctx = $("#getMidi");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                    }
                });
            }
        }
    }
}
function getMidiTracks() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "block";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/midi/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i].tracks);
                    labels.push(myObj[i].name);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getMidiTracks");
                var chart = new Chart(ctx, {
                    type: 'pie',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                    }
                });
            }
        }
    }
}
function getMidiFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "block";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [], datas2 = [];
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/midi/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[0][0]);
                    datas2.push(myObj[0][1]);
                    labels.push(takenamefile());
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Righe di statistica",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }, {
                            label: "Righe di non statistica",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas2
                        }
                    ],
                };
                var ctx = $("#getMidiFile");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                    }
                });
            }
        }
    }
}
function getMidiTracksFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "block";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];;
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/midi/grouptrack/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = this.responseText;
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                datas.push([myObj]);
                labels.push(takenamefile());
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getMidiTracksFile");
                var chart = new Chart(ctx, {
                    type: 'pie',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false
                    }
                });
            }
        }
    }
}
function getTrackInstrument() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "block";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/track/group", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][0]);
                    labels.push(myObj[i][1]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }],
                };
                var ctx = $("#getTrackInstrument");
                var chart = new Chart(ctx, {
                    type: 'pie',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                    }
                });
            }
        }
    }
}
function getInstruments() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "block";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/track/instrumentsOfMidi", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    if (myObj[i][1] != null) {
                        datas.push(myObj[i][1]);
                        labels.push(myObj[i][0] + ": " + myObj[i][2]);
                    }
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }],
                };
                var ctx = $("#getInstruments");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    }
                });
            }
        }
    }
}
function getTrackInstrumentFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "block";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/track/instrumentsOfMidiFile/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][0]);
                    labels.push(myObj[i][1]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }],
                };
                var ctx = $("#getTrackInstrumentFile");
                var chart = new Chart(ctx, {
                    type: 'pie',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false
                    }
                });
            }
        }
    }
}
function getInstrumentsFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "block";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/track/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    if (myObj[i][1] != null) {
                        datas.push(myObj[i][0]);
                        labels.push(myObj[i][1]);
                    }
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }],
                };
                var ctx = $("#getInstrumentsFile");
                var chart = new Chart(ctx, {
                    type: 'bar',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true,
                                }
                            }]
                        },
                    }
                });
            }
        }
    }
}
function getBpmFile() {
    document.getElementById("getBpmFile").style.display = "block";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/bpm/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i].bpm);
                    labels.push(myObj[i].absoluteTime);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Bpm",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getBpmFile");
                var chart = new Chart(ctx, {
                    type: 'line',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                    }
                });
            }
        }
    }
}
function getBpm() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "block";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "block";
    document.getElementById("select").style.display = "none";
    var myObj, labels = [], datas = [];
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/bpm/group", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                for (var i = 0; i < myObj.length; i++) {
                    datas.push(myObj[i][0]);
                    labels.push(myObj[i][1]);
                }
                var chartdata = {
                    labels: labels,
                    datasets: [
                        {
                            label: "Bpm",
                            backgroundColor: [
                                'rgba(255, 77, 77)',
                                'rgba(204, 0, 0)',
                                'rgba(128, 0, 0)',
                                'rgba(255, 128, 128)',
                                'rgba(51, 153, 255)',
                                'rgba(0, 89, 179)',
                                'rgba(0, 51, 102)',
                                'rgba(153, 204, 255)',
                                'rgba(102, 255, 102)',
                                'rgba(0, 179, 0)',
                                'rgba(0, 77, 0)',
                                'rgba(255, 255, 77)',
                                'rgba(179, 179, 0)',
                                'rgba(191, 128, 255)',
                                'rgba(166, 77, 255)',
                                'rgba(128, 0, 255)',
                                'rgba(89, 0, 179)',
                                'rgba(38, 0, 77)',
                                'rgba(255, 102, 153)',
                                'rgba(255, 51, 119)',
                                'rgba(102, 255, 255)',
                                'rgba(0, 230, 230)',
                                'rgba(0, 153, 153)',
                                'rgba(0, 51, 51)',
                                'rgba(255, 153, 51)',
                                'rgba(230, 115, 0)',
                                'rgba(153, 0, 51)',
                                'rgba(128, 64, 0)',
                                'rgba(153, 0, 153)',
                                'rgba(0, 0, 255)',
                                'rgba(128, 128, 255)',],
                            borderColor: 'black',
                            borderWidth: 0.5,
                            data: datas
                        }
                    ]
                };
                var ctx = $("#getBpm");
                var chart = new Chart(ctx, {
                    type: 'line',
                    data: chartdata,
                    options: {
                        responsive: true,
                        maintainAspectRatio: false
                    }
                });
            }
        }
    }
}
function getTitle() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/title/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (i in myObj) {
                    txt += "<a href='#!' class='collection-item center'>'" + myObj[i].content + "' on track: " + myObj[i].track_idtrack.midi_idmidi.name + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getKeytoneFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/keyTone/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (var i = 0; i < myObj.length; i++) {
                    txt += "<a href='#!' class='collection-item center'>" + "Mode: " + myObj[i][0] + " - Tone: " + myObj[i][1] + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getKeytone() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/keyTone/group", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (var i = 0; i < myObj.length; i++) {
                    txt += "<a href='#!' class='collection-item center'>" + "Mode: " + myObj[i][0] + " - Tone: " + myObj[i][1] + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getTitleFile() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    var url = "http://localhost:8081/title/group/" + takenamefile();
    xmlhttp.open("GET", url, true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (i in myObj) {
                    txt += "<a href='#!' class='collection-item center'>'" + myObj[i].content + "' on track " + myObj[i].track_idtrack.idtrack + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getCollection() {
    var myObj, i, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/midi/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (Object.keys(myObj).length == 0) {
                txt += "<br><ul class='collection'><li class='collection-item'><div class='center'>No Files uploaded<a href='#!' class='secondary-content'></a></div></li></ul>";
                document.getElementById("nofile-collection").innerHTML = txt;
                document.getElementById("nofile-collection").style.display = "block";
                document.getElementById("multifile-collection").style.display = "none";
                document.getElementById("file-collection").style.display = "none";
                document.getElementById("midi-collection").style.display = "block";
            } else {
                document.getElementById("nofile-collection").style.display = "none";
                document.getElementById("multifile-collection").style.display = "block";
                document.getElementById("file-collection").style.display = "none";
                document.getElementById("midi-collection").style.display = "block";
            }
        }
    }
}
function checkFile() {
    try {
        $('select').formSelect();
        var response = $('select').formSelect('getSelectedValues');
        if (response == "No file selected") {
            getCollection();
        }
        else {
            document.getElementById("multifile-collection").style.display = "none";
            document.getElementById("file-collection").style.display = "block";
            document.getElementById("midi-collection").style.display = "block";
        }
    }
    finally { }
}
function takenamefile() {
    try {
        $('select').formSelect();
        var response = $('select').formSelect('getSelectedValues')
    }
    finally { return response }
}
//Script for select midi file
function select_midi_file() {
    var xmlhttp, myObj, i, txt = "";
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/midi/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            txt += "<br><div class='input-field'><select>";
            txt += "<option>No file selected</option>";
            for (i in myObj) {
                txt += "<option>"
                    + myObj[i].name +
                    "</option>";
            }
            txt += "</select></div><br>";
            document.getElementById("select_midi").innerHTML = txt;
            $('select').formSelect();
        }
    };
}
function getIfamily() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/iFamily", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (i in myObj) {
                    txt += "<a href='#!' class='collection-item center'>" + myObj[i].name + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getTone() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/tone/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (var i = 0; i < myObj.length; i++) {
                    txt += "<a href='#!' class='collection-item center'>" + myObj[i].value + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getMode() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/mode/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (var i = 0; i < myObj.length; i++) {
                    txt += "<a href='#!' class='collection-item center'>" + myObj[i].value + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}
function getNotes() {
    document.getElementById("getBpmFile").style.display = "none";
    document.getElementById("getBpm").style.display = "none";
    document.getElementById("getTrackInstrument").style.display = "none";
    document.getElementById("getTrackInstrumentFile").style.display = "none";
    document.getElementById("getInstrumentsFile").style.display = "none";
    document.getElementById("getInstruments").style.display = "none";
    document.getElementById("getMidiTracksFile").style.display = "none";
    document.getElementById("getMidiFile").style.display = "none";
    document.getElementById("getMidiTracks").style.display = "none";
    document.getElementById("getMidi").style.display = "none";
    document.getElementById("getTempoFile").style.display = "none";
    document.getElementById("getTempo").style.display = "none";
    document.getElementById("getNote").style.display = "none";
    document.getElementById("getNoteGroup").style.display = "none";
    document.getElementById("getNoteGroupFile").style.display = "none";
    document.getElementById("getNoteFile").style.display = "none";
    document.getElementById("chart-container").style.display = "none";
    document.getElementById("select").style.display = "block";
    var myObj, txt = "";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", "http://localhost:8081/notes/all", true);
    xmlhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
    xmlhttp.setRequestHeader("Content-type", "application/javascript");
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                getEmptyData();
            } else {
                txt += "<div class='collection container'>";
                for (var i = 0; i < myObj.length; i++) {
                    txt += "<a href='#!' class='collection-item center'>" + myObj[i].value + '</a>';
                }
                txt += "</div>";
                document.getElementById("select").innerHTML = txt;
            }
        }
    }
}